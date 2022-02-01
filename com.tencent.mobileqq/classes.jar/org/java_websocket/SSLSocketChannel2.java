package org.java_websocket;

import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLEngineResult.HandshakeStatus;
import javax.net.ssl.SSLEngineResult.Status;
import javax.net.ssl.SSLSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SSLSocketChannel2
  implements ByteChannel, WrappedByteChannel
{
  protected static ByteBuffer emptybuffer;
  private static final Logger log;
  protected int bufferallocations = 0;
  protected ExecutorService exec;
  protected ByteBuffer inCrypt;
  protected ByteBuffer inData;
  protected ByteBuffer outCrypt;
  protected SSLEngineResult readEngineResult;
  protected SelectionKey selectionKey;
  protected SocketChannel socketChannel;
  protected SSLEngine sslEngine;
  protected List<Future<?>> tasks;
  protected SSLEngineResult writeEngineResult;
  
  static
  {
    if (!SSLSocketChannel2.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      log = LoggerFactory.getLogger(SSLSocketChannel2.class);
      emptybuffer = ByteBuffer.allocate(0);
      return;
    }
  }
  
  public SSLSocketChannel2(SocketChannel paramSocketChannel, SSLEngine paramSSLEngine, ExecutorService paramExecutorService, SelectionKey paramSelectionKey)
  {
    if ((paramSocketChannel == null) || (paramSSLEngine == null) || (paramExecutorService == null)) {
      throw new IllegalArgumentException("parameter must not be null");
    }
    this.socketChannel = paramSocketChannel;
    this.sslEngine = paramSSLEngine;
    this.exec = paramExecutorService;
    paramSocketChannel = new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW, paramSSLEngine.getHandshakeStatus(), 0, 0);
    this.writeEngineResult = paramSocketChannel;
    this.readEngineResult = paramSocketChannel;
    this.tasks = new ArrayList(3);
    if (paramSelectionKey != null)
    {
      paramSelectionKey.interestOps(paramSelectionKey.interestOps() | 0x4);
      this.selectionKey = paramSelectionKey;
    }
    createBuffers(paramSSLEngine.getSession());
    this.socketChannel.write(wrap(emptybuffer));
    processHandshake();
  }
  
  private void consumeFutureUninterruptible(Future<?> paramFuture)
  {
    try
    {
      paramFuture.get();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Thread.currentThread().interrupt();
      }
    }
    catch (ExecutionException paramFuture)
    {
      throw new RuntimeException(paramFuture);
    }
  }
  
  private boolean isHandShakeComplete()
  {
    SSLEngineResult.HandshakeStatus localHandshakeStatus = this.sslEngine.getHandshakeStatus();
    return (localHandshakeStatus == SSLEngineResult.HandshakeStatus.FINISHED) || (localHandshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING);
  }
  
  private void processHandshake()
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        Object localObject1 = this.sslEngine.getHandshakeStatus();
        localObject3 = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        if (localObject1 == localObject3) {
          return;
        }
        if (this.tasks.isEmpty()) {
          break label101;
        }
        localObject1 = this.tasks.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label101;
        }
        localObject3 = (Future)((Iterator)localObject1).next();
        if (((Future)localObject3).isDone())
        {
          ((Iterator)localObject1).remove();
          continue;
        }
        if (!isBlocking()) {
          continue;
        }
      }
      finally {}
      consumeFutureUninterruptible((Future)localObject3);
      continue;
      label101:
      if (this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_UNWRAP)
      {
        if ((!isBlocking()) || (this.readEngineResult.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW))
        {
          this.inCrypt.compact();
          if (this.socketChannel.read(this.inCrypt) == -1) {
            throw new IOException("connection closed unexpectedly by peer");
          }
          this.inCrypt.flip();
        }
        this.inData.compact();
        unwrap();
        if (this.readEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED)
        {
          createBuffers(this.sslEngine.getSession());
          continue;
        }
      }
      consumeDelegatedTasks();
      if ((this.tasks.isEmpty()) || (this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_WRAP))
      {
        this.socketChannel.write(wrap(emptybuffer));
        if (this.writeEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED)
        {
          createBuffers(this.sslEngine.getSession());
          continue;
        }
      }
      assert (this.sslEngine.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING);
      this.bufferallocations = 1;
    }
  }
  
  private int readRemaining(ByteBuffer paramByteBuffer)
  {
    int i;
    if (this.inData.hasRemaining()) {
      i = transfereTo(this.inData, paramByteBuffer);
    }
    int j;
    do
    {
      return i;
      if (!this.inData.hasRemaining()) {
        this.inData.clear();
      }
      if (!this.inCrypt.hasRemaining()) {
        break;
      }
      unwrap();
      j = transfereTo(this.inData, paramByteBuffer);
      if (this.readEngineResult.getStatus() == SSLEngineResult.Status.CLOSED) {
        return -1;
      }
      i = j;
    } while (j > 0);
    return 0;
  }
  
  private int transfereTo(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
  {
    int j = paramByteBuffer1.remaining();
    int i = paramByteBuffer2.remaining();
    if (j > i)
    {
      int k = Math.min(j, i);
      i = 0;
      for (;;)
      {
        j = k;
        if (i >= k) {
          break;
        }
        paramByteBuffer2.put(paramByteBuffer1.get());
        i += 1;
      }
    }
    paramByteBuffer2.put(paramByteBuffer1);
    return j;
  }
  
  /* Error */
  private ByteBuffer unwrap()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 100	org/java_websocket/SSLSocketChannel2:readEngineResult	Ljavax/net/ssl/SSLEngineResult;
    //   6: invokevirtual 212	javax/net/ssl/SSLEngineResult:getStatus	()Ljavax/net/ssl/SSLEngineResult$Status;
    //   9: getstatic 259	javax/net/ssl/SSLEngineResult$Status:CLOSED	Ljavax/net/ssl/SSLEngineResult$Status;
    //   12: if_acmpne +24 -> 36
    //   15: aload_0
    //   16: getfield 77	org/java_websocket/SSLSocketChannel2:sslEngine	Ljavax/net/ssl/SSLEngine;
    //   19: invokevirtual 93	javax/net/ssl/SSLEngine:getHandshakeStatus	()Ljavax/net/ssl/SSLEngineResult$HandshakeStatus;
    //   22: astore_2
    //   23: getstatic 177	javax/net/ssl/SSLEngineResult$HandshakeStatus:NOT_HANDSHAKING	Ljavax/net/ssl/SSLEngineResult$HandshakeStatus;
    //   26: astore_3
    //   27: aload_2
    //   28: aload_3
    //   29: if_acmpne +7 -> 36
    //   32: aload_0
    //   33: invokevirtual 280	org/java_websocket/SSLSocketChannel2:close	()V
    //   36: aload_0
    //   37: getfield 232	org/java_websocket/SSLSocketChannel2:inData	Ljava/nio/ByteBuffer;
    //   40: invokevirtual 262	java/nio/ByteBuffer:remaining	()I
    //   43: istore_1
    //   44: aload_0
    //   45: aload_0
    //   46: getfield 77	org/java_websocket/SSLSocketChannel2:sslEngine	Ljavax/net/ssl/SSLEngine;
    //   49: aload_0
    //   50: getfield 214	org/java_websocket/SSLSocketChannel2:inCrypt	Ljava/nio/ByteBuffer;
    //   53: aload_0
    //   54: getfield 232	org/java_websocket/SSLSocketChannel2:inData	Ljava/nio/ByteBuffer;
    //   57: invokevirtual 283	javax/net/ssl/SSLEngine:unwrap	(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;)Ljavax/net/ssl/SSLEngineResult;
    //   60: putfield 100	org/java_websocket/SSLSocketChannel2:readEngineResult	Ljavax/net/ssl/SSLEngineResult;
    //   63: aload_0
    //   64: getfield 100	org/java_websocket/SSLSocketChannel2:readEngineResult	Ljavax/net/ssl/SSLEngineResult;
    //   67: invokevirtual 212	javax/net/ssl/SSLEngineResult:getStatus	()Ljavax/net/ssl/SSLEngineResult$Status;
    //   70: getstatic 286	javax/net/ssl/SSLEngineResult$Status:OK	Ljavax/net/ssl/SSLEngineResult$Status;
    //   73: if_acmpne +27 -> 100
    //   76: iload_1
    //   77: aload_0
    //   78: getfield 232	org/java_websocket/SSLSocketChannel2:inData	Ljava/nio/ByteBuffer;
    //   81: invokevirtual 262	java/nio/ByteBuffer:remaining	()I
    //   84: if_icmpne -48 -> 36
    //   87: aload_0
    //   88: getfield 77	org/java_websocket/SSLSocketChannel2:sslEngine	Ljavax/net/ssl/SSLEngine;
    //   91: invokevirtual 93	javax/net/ssl/SSLEngine:getHandshakeStatus	()Ljavax/net/ssl/SSLEngineResult$HandshakeStatus;
    //   94: getstatic 208	javax/net/ssl/SSLEngineResult$HandshakeStatus:NEED_UNWRAP	Ljavax/net/ssl/SSLEngineResult$HandshakeStatus;
    //   97: if_acmpeq -61 -> 36
    //   100: aload_0
    //   101: getfield 232	org/java_websocket/SSLSocketChannel2:inData	Ljava/nio/ByteBuffer;
    //   104: invokevirtual 230	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   107: pop
    //   108: aload_0
    //   109: getfield 232	org/java_websocket/SSLSocketChannel2:inData	Ljava/nio/ByteBuffer;
    //   112: astore_2
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_2
    //   116: areturn
    //   117: astore_2
    //   118: goto -82 -> 36
    //   121: astore_2
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_2
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	SSLSocketChannel2
    //   43	42	1	i	int
    //   22	94	2	localObject1	Object
    //   117	1	2	localIOException	IOException
    //   121	4	2	localObject2	Object
    //   26	3	3	localHandshakeStatus	SSLEngineResult.HandshakeStatus
    // Exception table:
    //   from	to	target	type
    //   32	36	117	java/io/IOException
    //   2	27	121	finally
    //   32	36	121	finally
    //   36	100	121	finally
    //   100	113	121	finally
  }
  
  private ByteBuffer wrap(ByteBuffer paramByteBuffer)
  {
    try
    {
      this.outCrypt.compact();
      this.writeEngineResult = this.sslEngine.wrap(paramByteBuffer, this.outCrypt);
      this.outCrypt.flip();
      paramByteBuffer = this.outCrypt;
      return paramByteBuffer;
    }
    finally
    {
      paramByteBuffer = finally;
      throw paramByteBuffer;
    }
  }
  
  public void close()
  {
    this.sslEngine.closeOutbound();
    this.sslEngine.getSession().invalidate();
    if (this.socketChannel.isOpen()) {
      this.socketChannel.write(wrap(emptybuffer));
    }
    this.socketChannel.close();
  }
  
  public SelectableChannel configureBlocking(boolean paramBoolean)
  {
    return this.socketChannel.configureBlocking(paramBoolean);
  }
  
  public boolean connect(SocketAddress paramSocketAddress)
  {
    return this.socketChannel.connect(paramSocketAddress);
  }
  
  protected void consumeDelegatedTasks()
  {
    for (;;)
    {
      Runnable localRunnable = this.sslEngine.getDelegatedTask();
      if (localRunnable == null) {
        break;
      }
      this.tasks.add(this.exec.submit(localRunnable));
    }
  }
  
  protected void createBuffers(SSLSession paramSSLSession)
  {
    int i = paramSSLSession.getPacketBufferSize();
    int j = Math.max(paramSSLSession.getApplicationBufferSize(), i);
    if (this.inData == null)
    {
      this.inData = ByteBuffer.allocate(j);
      this.outCrypt = ByteBuffer.allocate(i);
      this.inCrypt = ByteBuffer.allocate(i);
    }
    for (;;)
    {
      if ((this.inData.remaining() != 0) && (log.isTraceEnabled())) {
        log.trace(new String(this.inData.array(), this.inData.position(), this.inData.remaining()));
      }
      this.inData.rewind();
      this.inData.flip();
      if ((this.inCrypt.remaining() != 0) && (log.isTraceEnabled())) {
        log.trace(new String(this.inCrypt.array(), this.inCrypt.position(), this.inCrypt.remaining()));
      }
      this.inCrypt.rewind();
      this.inCrypt.flip();
      this.outCrypt.rewind();
      this.outCrypt.flip();
      this.bufferallocations += 1;
      return;
      if (this.inData.capacity() != j) {
        this.inData = ByteBuffer.allocate(j);
      }
      if (this.outCrypt.capacity() != i) {
        this.outCrypt = ByteBuffer.allocate(i);
      }
      if (this.inCrypt.capacity() != i) {
        this.inCrypt = ByteBuffer.allocate(i);
      }
    }
  }
  
  public boolean finishConnect()
  {
    return this.socketChannel.finishConnect();
  }
  
  public boolean isBlocking()
  {
    return this.socketChannel.isBlocking();
  }
  
  public boolean isConnected()
  {
    return this.socketChannel.isConnected();
  }
  
  public boolean isInboundDone()
  {
    return this.sslEngine.isInboundDone();
  }
  
  public boolean isNeedRead()
  {
    return (this.inData.hasRemaining()) || ((this.inCrypt.hasRemaining()) && (this.readEngineResult.getStatus() != SSLEngineResult.Status.BUFFER_UNDERFLOW) && (this.readEngineResult.getStatus() != SSLEngineResult.Status.CLOSED));
  }
  
  public boolean isNeedWrite()
  {
    return (this.outCrypt.hasRemaining()) || (!isHandShakeComplete());
  }
  
  public boolean isOpen()
  {
    return this.socketChannel.isOpen();
  }
  
  public int read(ByteBuffer paramByteBuffer)
  {
    int i;
    do
    {
      if (!paramByteBuffer.hasRemaining()) {}
      do
      {
        return 0;
        if (isHandShakeComplete()) {
          break;
        }
        if (isBlocking()) {
          while (!isHandShakeComplete()) {
            processHandshake();
          }
        }
        processHandshake();
      } while (!isHandShakeComplete());
      i = readRemaining(paramByteBuffer);
      if (i != 0) {
        return i;
      }
      assert (this.inData.position() == 0);
      this.inData.clear();
      if (!this.inCrypt.hasRemaining()) {
        this.inCrypt.clear();
      }
      while (((isBlocking()) || (this.readEngineResult.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW)) && (this.socketChannel.read(this.inCrypt) == -1))
      {
        return -1;
        this.inCrypt.compact();
      }
      this.inCrypt.flip();
      unwrap();
      i = transfereTo(this.inData, paramByteBuffer);
    } while ((i == 0) && (isBlocking()));
    return i;
  }
  
  public int readMore(ByteBuffer paramByteBuffer)
  {
    return readRemaining(paramByteBuffer);
  }
  
  public Socket socket()
  {
    return this.socketChannel.socket();
  }
  
  public int write(ByteBuffer paramByteBuffer)
  {
    int i;
    if (!isHandShakeComplete())
    {
      processHandshake();
      i = 0;
    }
    do
    {
      return i;
      i = this.socketChannel.write(wrap(paramByteBuffer));
    } while (this.writeEngineResult.getStatus() != SSLEngineResult.Status.CLOSED);
    throw new EOFException("Connection is closed");
  }
  
  public void writeMore()
  {
    write(this.outCrypt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.java_websocket.SSLSocketChannel2
 * JD-Core Version:    0.7.0.1
 */
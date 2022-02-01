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
  protected static ByteBuffer emptybuffer = ByteBuffer.allocate(0);
  private static final Logger log = LoggerFactory.getLogger(SSLSocketChannel2.class);
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
  
  public SSLSocketChannel2(SocketChannel paramSocketChannel, SSLEngine paramSSLEngine, ExecutorService paramExecutorService, SelectionKey paramSelectionKey)
  {
    if ((paramSocketChannel != null) && (paramSSLEngine != null) && (paramExecutorService != null))
    {
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
      return;
    }
    throw new IllegalArgumentException("parameter must not be null");
  }
  
  private void consumeFutureUninterruptible(Future<?> paramFuture)
  {
    try
    {
      paramFuture.get();
      return;
    }
    catch (ExecutionException paramFuture)
    {
      for (;;)
      {
        break;
        Thread.currentThread().interrupt();
      }
      paramFuture = new RuntimeException(paramFuture);
      for (;;)
      {
        throw paramFuture;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      label12:
      break label12;
    }
  }
  
  private boolean isHandShakeComplete()
  {
    SSLEngineResult.HandshakeStatus localHandshakeStatus = this.sslEngine.getHandshakeStatus();
    return (localHandshakeStatus == SSLEngineResult.HandshakeStatus.FINISHED) || (localHandshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING);
  }
  
  private void processHandshake()
  {
    try
    {
      Object localObject1 = this.sslEngine.getHandshakeStatus();
      Object localObject3 = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
      if (localObject1 == localObject3) {
        return;
      }
      if (!this.tasks.isEmpty())
      {
        localObject1 = this.tasks.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Future)((Iterator)localObject1).next();
          if (((Future)localObject3).isDone())
          {
            ((Iterator)localObject1).remove();
          }
          else
          {
            if (isBlocking()) {
              consumeFutureUninterruptible((Future)localObject3);
            }
            return;
          }
        }
      }
      if (this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_UNWRAP)
      {
        if ((!isBlocking()) || (this.readEngineResult.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW))
        {
          this.inCrypt.compact();
          if (this.socketChannel.read(this.inCrypt) != -1) {
            this.inCrypt.flip();
          }
        }
        else
        {
          this.inData.compact();
          unwrap();
          if (this.readEngineResult.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.FINISHED) {
            break label210;
          }
          createBuffers(this.sslEngine.getSession());
          return;
        }
        throw new IOException("connection closed unexpectedly by peer");
      }
      label210:
      consumeDelegatedTasks();
      if ((this.tasks.isEmpty()) || (this.sslEngine.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.NEED_WRAP))
      {
        this.socketChannel.write(wrap(emptybuffer));
        if (this.writeEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED)
        {
          createBuffers(this.sslEngine.getSession());
          return;
        }
      }
      this.bufferallocations = 1;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private int readRemaining(ByteBuffer paramByteBuffer)
  {
    if (this.inData.hasRemaining()) {
      return transfereTo(this.inData, paramByteBuffer);
    }
    if (!this.inData.hasRemaining()) {
      this.inData.clear();
    }
    if (this.inCrypt.hasRemaining())
    {
      unwrap();
      int i = transfereTo(this.inData, paramByteBuffer);
      if (this.readEngineResult.getStatus() == SSLEngineResult.Status.CLOSED) {
        return -1;
      }
      if (i > 0) {
        return i;
      }
    }
    return 0;
  }
  
  private int transfereTo(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2)
  {
    int i = paramByteBuffer1.remaining();
    int j = paramByteBuffer2.remaining();
    if (i > j)
    {
      j = Math.min(i, j);
      i = 0;
      while (i < j)
      {
        paramByteBuffer2.put(paramByteBuffer1.get());
        i += 1;
      }
      return j;
    }
    paramByteBuffer2.put(paramByteBuffer1);
    return i;
  }
  
  /* Error */
  private ByteBuffer unwrap()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 86	org/java_websocket/SSLSocketChannel2:readEngineResult	Ljavax/net/ssl/SSLEngineResult;
    //   6: invokevirtual 206	javax/net/ssl/SSLEngineResult:getStatus	()Ljavax/net/ssl/SSLEngineResult$Status;
    //   9: getstatic 250	javax/net/ssl/SSLEngineResult$Status:CLOSED	Ljavax/net/ssl/SSLEngineResult$Status;
    //   12: if_acmpne +24 -> 36
    //   15: aload_0
    //   16: getfield 63	org/java_websocket/SSLSocketChannel2:sslEngine	Ljavax/net/ssl/SSLEngine;
    //   19: invokevirtual 79	javax/net/ssl/SSLEngine:getHandshakeStatus	()Ljavax/net/ssl/SSLEngineResult$HandshakeStatus;
    //   22: astore_2
    //   23: getstatic 171	javax/net/ssl/SSLEngineResult$HandshakeStatus:NOT_HANDSHAKING	Ljavax/net/ssl/SSLEngineResult$HandshakeStatus;
    //   26: astore_3
    //   27: aload_2
    //   28: aload_3
    //   29: if_acmpne +7 -> 36
    //   32: aload_0
    //   33: invokevirtual 271	org/java_websocket/SSLSocketChannel2:close	()V
    //   36: aload_0
    //   37: getfield 221	org/java_websocket/SSLSocketChannel2:inData	Ljava/nio/ByteBuffer;
    //   40: invokevirtual 253	java/nio/ByteBuffer:remaining	()I
    //   43: istore_1
    //   44: aload_0
    //   45: aload_0
    //   46: getfield 63	org/java_websocket/SSLSocketChannel2:sslEngine	Ljavax/net/ssl/SSLEngine;
    //   49: aload_0
    //   50: getfield 208	org/java_websocket/SSLSocketChannel2:inCrypt	Ljava/nio/ByteBuffer;
    //   53: aload_0
    //   54: getfield 221	org/java_websocket/SSLSocketChannel2:inData	Ljava/nio/ByteBuffer;
    //   57: invokevirtual 274	javax/net/ssl/SSLEngine:unwrap	(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;)Ljavax/net/ssl/SSLEngineResult;
    //   60: putfield 86	org/java_websocket/SSLSocketChannel2:readEngineResult	Ljavax/net/ssl/SSLEngineResult;
    //   63: aload_0
    //   64: getfield 86	org/java_websocket/SSLSocketChannel2:readEngineResult	Ljavax/net/ssl/SSLEngineResult;
    //   67: invokevirtual 206	javax/net/ssl/SSLEngineResult:getStatus	()Ljavax/net/ssl/SSLEngineResult$Status;
    //   70: getstatic 277	javax/net/ssl/SSLEngineResult$Status:OK	Ljavax/net/ssl/SSLEngineResult$Status;
    //   73: if_acmpne +27 -> 100
    //   76: iload_1
    //   77: aload_0
    //   78: getfield 221	org/java_websocket/SSLSocketChannel2:inData	Ljava/nio/ByteBuffer;
    //   81: invokevirtual 253	java/nio/ByteBuffer:remaining	()I
    //   84: if_icmpne -48 -> 36
    //   87: aload_0
    //   88: getfield 63	org/java_websocket/SSLSocketChannel2:sslEngine	Ljavax/net/ssl/SSLEngine;
    //   91: invokevirtual 79	javax/net/ssl/SSLEngine:getHandshakeStatus	()Ljavax/net/ssl/SSLEngineResult$HandshakeStatus;
    //   94: getstatic 202	javax/net/ssl/SSLEngineResult$HandshakeStatus:NEED_UNWRAP	Ljavax/net/ssl/SSLEngineResult$HandshakeStatus;
    //   97: if_acmpeq -61 -> 36
    //   100: aload_0
    //   101: getfield 221	org/java_websocket/SSLSocketChannel2:inData	Ljava/nio/ByteBuffer;
    //   104: invokevirtual 219	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   107: pop
    //   108: aload_0
    //   109: getfield 221	org/java_websocket/SSLSocketChannel2:inData	Ljava/nio/ByteBuffer;
    //   112: astore_2
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_2
    //   116: areturn
    //   117: astore_2
    //   118: aload_0
    //   119: monitorexit
    //   120: goto +5 -> 125
    //   123: aload_2
    //   124: athrow
    //   125: goto -2 -> 123
    //   128: astore_2
    //   129: goto -93 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	SSLSocketChannel2
    //   43	42	1	i	int
    //   22	94	2	localObject1	Object
    //   117	7	2	localObject2	Object
    //   128	1	2	localIOException	IOException
    //   26	3	3	localHandshakeStatus	SSLEngineResult.HandshakeStatus
    // Exception table:
    //   from	to	target	type
    //   2	27	117	finally
    //   32	36	117	finally
    //   36	100	117	finally
    //   100	113	117	finally
    //   32	36	128	java/io/IOException
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
    paramSSLSession = this.inData;
    if (paramSSLSession == null)
    {
      this.inData = ByteBuffer.allocate(j);
      this.outCrypt = ByteBuffer.allocate(i);
      this.inCrypt = ByteBuffer.allocate(i);
    }
    else
    {
      if (paramSSLSession.capacity() != j) {
        this.inData = ByteBuffer.allocate(j);
      }
      if (this.outCrypt.capacity() != i) {
        this.outCrypt = ByteBuffer.allocate(i);
      }
      if (this.inCrypt.capacity() != i) {
        this.inCrypt = ByteBuffer.allocate(i);
      }
    }
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
      if (!paramByteBuffer.hasRemaining()) {
        return 0;
      }
      if (!isHandShakeComplete())
      {
        if (isBlocking()) {
          while (!isHandShakeComplete()) {
            processHandshake();
          }
        }
        processHandshake();
        if (!isHandShakeComplete()) {
          return 0;
        }
      }
      i = readRemaining(paramByteBuffer);
      if (i != 0) {
        return i;
      }
      this.inData.clear();
      if (!this.inCrypt.hasRemaining()) {
        this.inCrypt.clear();
      } else {
        this.inCrypt.compact();
      }
      if (((isBlocking()) || (this.readEngineResult.getStatus() == SSLEngineResult.Status.BUFFER_UNDERFLOW)) && (this.socketChannel.read(this.inCrypt) == -1)) {
        return -1;
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
    if (!isHandShakeComplete())
    {
      processHandshake();
      return 0;
    }
    int i = this.socketChannel.write(wrap(paramByteBuffer));
    if (this.writeEngineResult.getStatus() != SSLEngineResult.Status.CLOSED) {
      return i;
    }
    throw new EOFException("Connection is closed");
  }
  
  public void writeMore()
  {
    write(this.outCrypt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     org.java_websocket.SSLSocketChannel2
 * JD-Core Version:    0.7.0.1
 */
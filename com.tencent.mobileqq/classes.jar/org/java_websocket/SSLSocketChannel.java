package org.java_websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import org.java_websocket.util.ByteBufferUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SSLSocketChannel
  implements ByteChannel, WrappedByteChannel
{
  private static final Logger log = LoggerFactory.getLogger(SSLSocketChannel.class);
  private final SSLEngine engine;
  private ExecutorService executor;
  private ByteBuffer myAppData;
  private ByteBuffer myNetData;
  private ByteBuffer peerAppData;
  private ByteBuffer peerNetData;
  private final SocketChannel socketChannel;
  
  public SSLSocketChannel(SocketChannel paramSocketChannel, SSLEngine paramSSLEngine, ExecutorService paramExecutorService, SelectionKey paramSelectionKey)
  {
    if ((paramSocketChannel != null) && (paramSSLEngine != null) && (this.executor != paramExecutorService))
    {
      this.socketChannel = paramSocketChannel;
      this.engine = paramSSLEngine;
      this.executor = paramExecutorService;
      this.myNetData = ByteBuffer.allocate(this.engine.getSession().getPacketBufferSize());
      this.peerNetData = ByteBuffer.allocate(this.engine.getSession().getPacketBufferSize());
      this.engine.beginHandshake();
      if (doHandshake())
      {
        if (paramSelectionKey != null) {
          paramSelectionKey.interestOps(paramSelectionKey.interestOps() | 0x4);
        }
      }
      else {
        try
        {
          this.socketChannel.close();
          return;
        }
        catch (IOException paramSocketChannel)
        {
          log.error("Exception during the closing of the channel", paramSocketChannel);
        }
      }
      return;
    }
    throw new IllegalArgumentException("parameter must not be null");
  }
  
  private void closeConnection()
  {
    this.engine.closeOutbound();
    try
    {
      doHandshake();
      label12:
      this.socketChannel.close();
      return;
    }
    catch (IOException localIOException)
    {
      break label12;
    }
  }
  
  private boolean doHandshake()
  {
    int i = this.engine.getSession().getApplicationBufferSize();
    this.myAppData = ByteBuffer.allocate(i);
    this.peerAppData = ByteBuffer.allocate(i);
    this.myNetData.clear();
    this.peerNetData.clear();
    Object localObject1 = this.engine.getHandshakeStatus();
    i = 0;
    for (;;)
    {
      int j;
      Object localObject2;
      if (i == 0)
      {
        j = SSLSocketChannel.1.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[localObject1.ordinal()];
        if (j != 1) {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j != 4)
              {
                if (j == 5) {
                  continue;
                }
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("Invalid SSL status: ");
                ((StringBuilder)localObject2).append(localObject1);
                throw new IllegalStateException(((StringBuilder)localObject2).toString());
              }
              for (;;)
              {
                localObject1 = this.engine.getDelegatedTask();
                if (localObject1 == null) {
                  break;
                }
                this.executor.execute((Runnable)localObject1);
              }
              localObject1 = this.engine.getHandshakeStatus();
              continue;
            }
            this.myNetData.clear();
          }
        }
      }
      try
      {
        localObject1 = this.engine.wrap(this.myAppData, this.myNetData);
        localObject2 = ((SSLEngineResult)localObject1).getHandshakeStatus();
        j = SSLSocketChannel.1.$SwitchMap$javax$net$ssl$SSLEngineResult$Status[localObject1.getStatus().ordinal()];
        if (j != 1) {
          if (j != 2) {
            if (j != 3) {
              if (j != 4) {}
            }
          }
        }
      }
      catch (SSLException localException)
      {
        try
        {
          this.myNetData.flip();
          while (this.myNetData.hasRemaining()) {
            this.socketChannel.write(this.myNetData);
          }
          this.peerNetData.clear();
          localObject1 = localObject2;
          break label393;
          localObject1 = this.engine.getHandshakeStatus();
          continue;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Invalid SSL status: ");
          ((StringBuilder)localObject2).append(((SSLEngineResult)localObject1).getStatus());
          throw new IllegalStateException(((StringBuilder)localObject2).toString());
          this.myNetData = enlargePacketBuffer(this.myNetData);
          localObject1 = localObject2;
          break label393;
          throw new SSLException("Buffer underflow occured after a wrap. I don't think we should ever get here.");
          this.myNetData.flip();
          for (;;)
          {
            localObject1 = localObject2;
            if (!this.myNetData.hasRemaining()) {
              break;
            }
            this.socketChannel.write(this.myNetData);
          }
          label393:
          continue;
          this.engine.closeOutbound();
          localObject1 = this.engine.getHandshakeStatus();
          continue;
          if (this.socketChannel.read(this.peerNetData) < 0) {
            if ((this.engine.isInboundDone()) && (this.engine.isOutboundDone())) {
              return false;
            }
          }
        }
        catch (Exception localException)
        {
          try
          {
            for (;;)
            {
              for (;;)
              {
                this.engine.closeInbound();
                label457:
                this.engine.closeOutbound();
                localObject1 = this.engine.getHandshakeStatus();
                break;
                this.peerNetData.flip();
                try
                {
                  SSLEngineResult localSSLEngineResult = this.engine.unwrap(this.peerNetData, this.peerAppData);
                  this.peerNetData.compact();
                  localObject2 = localSSLEngineResult.getHandshakeStatus();
                  j = SSLSocketChannel.1.$SwitchMap$javax$net$ssl$SSLEngineResult$Status[localSSLEngineResult.getStatus().ordinal()];
                  localObject1 = localObject2;
                  if (j != 1)
                  {
                    if (j != 2)
                    {
                      if (j != 3)
                      {
                        if (j == 4)
                        {
                          if (this.engine.isOutboundDone()) {
                            return false;
                          }
                          this.engine.closeOutbound();
                          localObject1 = this.engine.getHandshakeStatus();
                          break;
                        }
                        localObject1 = new StringBuilder();
                        ((StringBuilder)localObject1).append("Invalid SSL status: ");
                        ((StringBuilder)localObject1).append(localSSLEngineResult.getStatus());
                        throw new IllegalStateException(((StringBuilder)localObject1).toString());
                      }
                      this.peerAppData = enlargeApplicationBuffer(this.peerAppData);
                      localObject1 = localObject2;
                      continue;
                    }
                    this.peerNetData = handleBufferUnderflow(this.peerNetData);
                    localObject1 = localObject2;
                  }
                }
                catch (SSLException localSSLException3)
                {
                  label654:
                  boolean bool;
                  break label654;
                }
              }
              this.engine.closeOutbound();
              localObject1 = this.engine.getHandshakeStatus();
              break;
              bool = this.peerNetData.hasRemaining() ^ true;
              if (bool) {
                return true;
              }
              this.socketChannel.write(this.peerNetData);
              break;
              return true;
              localSSLException1 = localSSLException1;
            }
            localException = localException;
          }
          catch (SSLException localSSLException2)
          {
            break label457;
          }
        }
      }
    }
  }
  
  private ByteBuffer enlargeApplicationBuffer(ByteBuffer paramByteBuffer)
  {
    return enlargeBuffer(paramByteBuffer, this.engine.getSession().getApplicationBufferSize());
  }
  
  private ByteBuffer enlargeBuffer(ByteBuffer paramByteBuffer, int paramInt)
  {
    if (paramInt > paramByteBuffer.capacity()) {
      return ByteBuffer.allocate(paramInt);
    }
    return ByteBuffer.allocate(paramByteBuffer.capacity() * 2);
  }
  
  private ByteBuffer enlargePacketBuffer(ByteBuffer paramByteBuffer)
  {
    return enlargeBuffer(paramByteBuffer, this.engine.getSession().getPacketBufferSize());
  }
  
  private ByteBuffer handleBufferUnderflow(ByteBuffer paramByteBuffer)
  {
    if (this.engine.getSession().getPacketBufferSize() < paramByteBuffer.limit()) {
      return paramByteBuffer;
    }
    ByteBuffer localByteBuffer = enlargePacketBuffer(paramByteBuffer);
    paramByteBuffer.flip();
    localByteBuffer.put(paramByteBuffer);
    return localByteBuffer;
  }
  
  private void handleEndOfStream()
  {
    try
    {
      this.engine.closeInbound();
    }
    catch (Exception localException)
    {
      label10:
      break label10;
    }
    log.error("This engine was forced to close inbound, without having received the proper SSL/TLS close notification message from the peer, due to end of stream.");
    closeConnection();
  }
  
  public void close()
  {
    closeConnection();
  }
  
  public boolean isBlocking()
  {
    return this.socketChannel.isBlocking();
  }
  
  public boolean isNeedRead()
  {
    return (this.peerNetData.hasRemaining()) || (this.peerAppData.hasRemaining());
  }
  
  public boolean isNeedWrite()
  {
    return false;
  }
  
  public boolean isOpen()
  {
    return this.socketChannel.isOpen();
  }
  
  public int read(ByteBuffer paramByteBuffer)
  {
    try
    {
      boolean bool = paramByteBuffer.hasRemaining();
      if (!bool) {
        return 0;
      }
      if (this.peerAppData.hasRemaining())
      {
        this.peerAppData.flip();
        i = ByteBufferUtils.transferByteBuffer(this.peerAppData, paramByteBuffer);
        return i;
      }
      this.peerNetData.compact();
      int i = this.socketChannel.read(this.peerNetData);
      if ((i <= 0) && (!this.peerNetData.hasRemaining()))
      {
        if (i < 0) {
          handleEndOfStream();
        }
      }
      else
      {
        this.peerNetData.flip();
        if (this.peerNetData.hasRemaining())
        {
          this.peerAppData.compact();
          try
          {
            SSLEngineResult localSSLEngineResult = this.engine.unwrap(this.peerNetData, this.peerAppData);
            i = SSLSocketChannel.1.$SwitchMap$javax$net$ssl$SSLEngineResult$Status[localSSLEngineResult.getStatus().ordinal()];
            if (i != 1)
            {
              if (i != 2)
              {
                if (i != 3)
                {
                  if (i == 4)
                  {
                    closeConnection();
                    paramByteBuffer.clear();
                    return -1;
                  }
                  paramByteBuffer = new StringBuilder();
                  paramByteBuffer.append("Invalid SSL status: ");
                  paramByteBuffer.append(localSSLEngineResult.getStatus());
                  throw new IllegalStateException(paramByteBuffer.toString());
                }
                this.peerAppData = enlargeApplicationBuffer(this.peerAppData);
                i = read(paramByteBuffer);
                return i;
              }
              this.peerAppData.flip();
              i = ByteBufferUtils.transferByteBuffer(this.peerAppData, paramByteBuffer);
              return i;
            }
            this.peerAppData.flip();
            i = ByteBufferUtils.transferByteBuffer(this.peerAppData, paramByteBuffer);
            return i;
          }
          catch (SSLException paramByteBuffer)
          {
            log.error("SSLExcpetion during unwrap", paramByteBuffer);
            throw paramByteBuffer;
          }
        }
      }
      ByteBufferUtils.transferByteBuffer(this.peerAppData, paramByteBuffer);
      return i;
    }
    finally {}
  }
  
  public int readMore(ByteBuffer paramByteBuffer)
  {
    return read(paramByteBuffer);
  }
  
  public int write(ByteBuffer paramByteBuffer)
  {
    int i = 0;
    try
    {
      while (paramByteBuffer.hasRemaining())
      {
        this.myNetData.clear();
        SSLEngineResult localSSLEngineResult = this.engine.wrap(paramByteBuffer, this.myNetData);
        int j = SSLSocketChannel.1.$SwitchMap$javax$net$ssl$SSLEngineResult$Status[localSSLEngineResult.getStatus().ordinal()];
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j == 4)
              {
                closeConnection();
                return 0;
              }
              paramByteBuffer = new StringBuilder();
              paramByteBuffer.append("Invalid SSL status: ");
              paramByteBuffer.append(localSSLEngineResult.getStatus());
              throw new IllegalStateException(paramByteBuffer.toString());
            }
            this.myNetData = enlargePacketBuffer(this.myNetData);
          }
          else
          {
            throw new SSLException("Buffer underflow occured after a wrap. I don't think we should ever get here.");
          }
        }
        else
        {
          this.myNetData.flip();
          j = i;
          for (;;)
          {
            i = j;
            if (!this.myNetData.hasRemaining()) {
              break;
            }
            i = this.socketChannel.write(this.myNetData);
            j += i;
          }
        }
      }
      return i;
    }
    finally {}
    for (;;)
    {
      throw paramByteBuffer;
    }
  }
  
  public void writeMore() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     org.java_websocket.SSLSocketChannel
 * JD-Core Version:    0.7.0.1
 */
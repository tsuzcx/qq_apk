package okhttp3.internal.ws;

import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.Buffer.UnsafeCursor;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;

final class WebSocketWriter
{
  boolean activeWriter;
  final Buffer buffer = new Buffer();
  final WebSocketWriter.FrameSink frameSink = new WebSocketWriter.FrameSink(this);
  final boolean isClient;
  private final Buffer.UnsafeCursor maskCursor;
  private final byte[] maskKey;
  final Random random;
  final BufferedSink sink;
  final Buffer sinkBuffer;
  boolean writerClosed;
  
  WebSocketWriter(boolean paramBoolean, BufferedSink paramBufferedSink, Random paramRandom)
  {
    if (paramBufferedSink != null)
    {
      if (paramRandom != null)
      {
        this.isClient = paramBoolean;
        this.sink = paramBufferedSink;
        this.sinkBuffer = paramBufferedSink.buffer();
        this.random = paramRandom;
        paramRandom = null;
        if (paramBoolean) {
          paramBufferedSink = new byte[4];
        } else {
          paramBufferedSink = null;
        }
        this.maskKey = paramBufferedSink;
        paramBufferedSink = paramRandom;
        if (paramBoolean) {
          paramBufferedSink = new Buffer.UnsafeCursor();
        }
        this.maskCursor = paramBufferedSink;
        return;
      }
      throw new NullPointerException("random == null");
    }
    throw new NullPointerException("sink == null");
  }
  
  private void writeControlFrame(int paramInt, ByteString paramByteString)
  {
    if (!this.writerClosed)
    {
      int i = paramByteString.size();
      if (i <= 125L)
      {
        this.sinkBuffer.writeByte(paramInt | 0x80);
        if (this.isClient)
        {
          this.sinkBuffer.writeByte(i | 0x80);
          this.random.nextBytes(this.maskKey);
          this.sinkBuffer.write(this.maskKey);
          if (i > 0)
          {
            long l = this.sinkBuffer.size();
            this.sinkBuffer.write(paramByteString);
            this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
            this.maskCursor.seek(l);
            WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
            this.maskCursor.close();
          }
        }
        else
        {
          this.sinkBuffer.writeByte(i);
          this.sinkBuffer.write(paramByteString);
        }
        this.sink.flush();
        return;
      }
      throw new IllegalArgumentException("Payload size must be less than or equal to 125");
    }
    throw new IOException("closed");
  }
  
  Sink newMessageSink(int paramInt, long paramLong)
  {
    if (!this.activeWriter)
    {
      this.activeWriter = true;
      WebSocketWriter.FrameSink localFrameSink = this.frameSink;
      localFrameSink.formatOpcode = paramInt;
      localFrameSink.contentLength = paramLong;
      localFrameSink.isFirstFrame = true;
      localFrameSink.closed = false;
      return localFrameSink;
    }
    throw new IllegalStateException("Another message writer is active. Did you call close()?");
  }
  
  void writeClose(int paramInt, ByteString paramByteString)
  {
    Object localObject = ByteString.EMPTY;
    if ((paramInt != 0) || (paramByteString != null))
    {
      if (paramInt != 0) {
        WebSocketProtocol.validateCloseCode(paramInt);
      }
      localObject = new Buffer();
      ((Buffer)localObject).writeShort(paramInt);
      if (paramByteString != null) {
        ((Buffer)localObject).write(paramByteString);
      }
      localObject = ((Buffer)localObject).readByteString();
    }
    try
    {
      writeControlFrame(8, (ByteString)localObject);
      return;
    }
    finally
    {
      this.writerClosed = true;
    }
  }
  
  void writeMessageFrame(int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.writerClosed)
    {
      int j = 0;
      if (!paramBoolean1) {
        paramInt = 0;
      }
      int i = paramInt;
      if (paramBoolean2) {
        i = paramInt | 0x80;
      }
      this.sinkBuffer.writeByte(i);
      paramInt = j;
      if (this.isClient) {
        paramInt = 128;
      }
      if (paramLong <= 125L)
      {
        i = (int)paramLong;
        this.sinkBuffer.writeByte(i | paramInt);
      }
      else if (paramLong <= 65535L)
      {
        this.sinkBuffer.writeByte(paramInt | 0x7E);
        this.sinkBuffer.writeShort((int)paramLong);
      }
      else
      {
        this.sinkBuffer.writeByte(paramInt | 0x7F);
        this.sinkBuffer.writeLong(paramLong);
      }
      if (this.isClient)
      {
        this.random.nextBytes(this.maskKey);
        this.sinkBuffer.write(this.maskKey);
        if (paramLong > 0L)
        {
          long l = this.sinkBuffer.size();
          this.sinkBuffer.write(this.buffer, paramLong);
          this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
          this.maskCursor.seek(l);
          WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
          this.maskCursor.close();
        }
      }
      else
      {
        this.sinkBuffer.write(this.buffer, paramLong);
      }
      this.sink.emit();
      return;
    }
    throw new IOException("closed");
  }
  
  void writePing(ByteString paramByteString)
  {
    writeControlFrame(9, paramByteString);
  }
  
  void writePong(ByteString paramByteString)
  {
    writeControlFrame(10, paramByteString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.ws.WebSocketWriter
 * JD-Core Version:    0.7.0.1
 */
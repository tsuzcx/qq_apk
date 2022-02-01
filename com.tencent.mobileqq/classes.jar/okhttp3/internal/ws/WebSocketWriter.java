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
    if (paramBufferedSink == null) {
      throw new NullPointerException("sink == null");
    }
    if (paramRandom == null) {
      throw new NullPointerException("random == null");
    }
    this.isClient = paramBoolean;
    this.sink = paramBufferedSink;
    this.sinkBuffer = paramBufferedSink.buffer();
    this.random = paramRandom;
    if (paramBoolean) {}
    for (paramBufferedSink = new byte[4];; paramBufferedSink = null)
    {
      this.maskKey = paramBufferedSink;
      paramBufferedSink = localObject;
      if (paramBoolean) {
        paramBufferedSink = new Buffer.UnsafeCursor();
      }
      this.maskCursor = paramBufferedSink;
      return;
    }
  }
  
  private void writeControlFrame(int paramInt, ByteString paramByteString)
  {
    if (this.writerClosed) {
      throw new IOException("closed");
    }
    int i = paramByteString.size();
    if (i > 125L) {
      throw new IllegalArgumentException("Payload size must be less than or equal to 125");
    }
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
    for (;;)
    {
      this.sink.flush();
      return;
      this.sinkBuffer.writeByte(i);
      this.sinkBuffer.write(paramByteString);
    }
  }
  
  Sink newMessageSink(int paramInt, long paramLong)
  {
    if (this.activeWriter) {
      throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }
    this.activeWriter = true;
    this.frameSink.formatOpcode = paramInt;
    this.frameSink.contentLength = paramLong;
    this.frameSink.isFirstFrame = true;
    this.frameSink.closed = false;
    return this.frameSink;
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
    if (this.writerClosed) {
      throw new IOException("closed");
    }
    int i;
    if (paramBoolean1)
    {
      i = paramInt;
      if (paramBoolean2) {
        i = paramInt | 0x80;
      }
      this.sinkBuffer.writeByte(i);
      if (!this.isClient) {
        break label267;
      }
    }
    label267:
    for (paramInt = 128;; paramInt = 0)
    {
      if (paramLong <= 125L)
      {
        i = (int)paramLong;
        this.sinkBuffer.writeByte(paramInt | i);
        label82:
        if (!this.isClient) {
          break label252;
        }
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
      for (;;)
      {
        this.sink.emit();
        return;
        paramInt = 0;
        break;
        if (paramLong <= 65535L)
        {
          this.sinkBuffer.writeByte(paramInt | 0x7E);
          this.sinkBuffer.writeShort((int)paramLong);
          break label82;
        }
        this.sinkBuffer.writeByte(paramInt | 0x7F);
        this.sinkBuffer.writeLong(paramLong);
        break label82;
        label252:
        this.sinkBuffer.write(this.buffer, paramLong);
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okhttp3.internal.ws.WebSocketWriter
 * JD-Core Version:    0.7.0.1
 */
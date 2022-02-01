package okio;

import java.io.IOException;
import java.io.OutputStream;

class RealBufferedSink$1
  extends OutputStream
{
  RealBufferedSink$1(RealBufferedSink paramRealBufferedSink) {}
  
  public void close()
  {
    this.this$0.close();
  }
  
  public void flush()
  {
    if (!this.this$0.closed) {
      this.this$0.flush();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0);
    localStringBuilder.append(".outputStream()");
    return localStringBuilder.toString();
  }
  
  public void write(int paramInt)
  {
    if (!this.this$0.closed)
    {
      this.this$0.buffer.writeByte((byte)paramInt);
      this.this$0.emitCompleteSegments();
      return;
    }
    throw new IOException("closed");
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.this$0.closed)
    {
      this.this$0.buffer.write(paramArrayOfByte, paramInt1, paramInt2);
      this.this$0.emitCompleteSegments();
      return;
    }
    throw new IOException("closed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.RealBufferedSink.1
 * JD-Core Version:    0.7.0.1
 */
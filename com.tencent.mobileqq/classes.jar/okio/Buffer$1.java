package okio;

import java.io.OutputStream;

class Buffer$1
  extends OutputStream
{
  Buffer$1(Buffer paramBuffer) {}
  
  public void close() {}
  
  public void flush() {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0);
    localStringBuilder.append(".outputStream()");
    return localStringBuilder.toString();
  }
  
  public void write(int paramInt)
  {
    this.this$0.writeByte((byte)paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.this$0.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.Buffer.1
 * JD-Core Version:    0.7.0.1
 */
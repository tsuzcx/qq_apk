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
    return this.this$0 + ".outputStream()";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okio.Buffer.1
 * JD-Core Version:    0.7.0.1
 */
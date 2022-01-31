package okio;

import java.io.InputStream;

class Buffer$2
  extends InputStream
{
  Buffer$2(Buffer paramBuffer) {}
  
  public int available()
  {
    return (int)Math.min(this.this$0.size, 2147483647L);
  }
  
  public void close() {}
  
  public int read()
  {
    if (this.this$0.size > 0L) {
      return this.this$0.readByte() & 0xFF;
    }
    return -1;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return this.this$0.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public String toString()
  {
    return this.this$0 + ".inputStream()";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     okio.Buffer.2
 * JD-Core Version:    0.7.0.1
 */
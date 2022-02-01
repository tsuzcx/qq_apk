package org.apache.commons.io.input;

import java.io.InputStream;

public class AutoCloseInputStream
  extends ProxyInputStream
{
  public AutoCloseInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  protected void afterRead(int paramInt)
  {
    if (paramInt == -1) {
      close();
    }
  }
  
  public void close()
  {
    this.in.close();
    this.in = new ClosedInputStream();
  }
  
  protected void finalize()
  {
    close();
    super.finalize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.input.AutoCloseInputStream
 * JD-Core Version:    0.7.0.1
 */
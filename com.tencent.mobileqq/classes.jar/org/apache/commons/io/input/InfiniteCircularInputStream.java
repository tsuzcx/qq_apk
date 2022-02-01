package org.apache.commons.io.input;

import java.io.InputStream;

public class InfiniteCircularInputStream
  extends InputStream
{
  private int position = -1;
  private final byte[] repeatedContent;
  
  public InfiniteCircularInputStream(byte[] paramArrayOfByte)
  {
    this.repeatedContent = paramArrayOfByte;
  }
  
  public int read()
  {
    int i = this.position;
    byte[] arrayOfByte = this.repeatedContent;
    this.position = ((i + 1) % arrayOfByte.length);
    return arrayOfByte[this.position] & 0xFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.input.InfiniteCircularInputStream
 * JD-Core Version:    0.7.0.1
 */
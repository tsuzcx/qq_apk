package com.tencent.vbox.decode;

public class VboxDecoder
{
  protected int height;
  protected int index;
  protected byte[] rgba = null;
  protected int rotatedHeight;
  protected int rotatedWidth;
  protected int rotation;
  protected int width;
  
  public int getFrameBytes(int paramInt)
  {
    return 0;
  }
  
  public int getFrameTexture(int paramInt)
  {
    return 0;
  }
  
  public int getHeight()
  {
    return this.rotatedHeight;
  }
  
  public int getNextFrameBytes()
  {
    return 0;
  }
  
  public int getNextFrameTexture()
  {
    return 0;
  }
  
  public int getWidth()
  {
    return this.rotatedWidth;
  }
  
  public void releaseDecoder() {}
  
  public void setBytes(byte[] paramArrayOfByte)
  {
    this.rgba = paramArrayOfByte;
  }
  
  public void setTexture(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.vbox.decode.VboxDecoder
 * JD-Core Version:    0.7.0.1
 */
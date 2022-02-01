package com.tencent.youtu.ytagreflectlivecheck.jni.model;

public class OriginYuvData
{
  int height;
  int width;
  public byte[] yuvData;
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public byte[] getYuvData()
  {
    return this.yuvData;
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
  
  public void setYuvData(byte[] paramArrayOfByte)
  {
    this.yuvData = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.jni.model.OriginYuvData
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.youtu.ytagreflectlivecheck.data;

public class YTActReflectImage
{
  public String checksum;
  public byte[] image;
  public float[] xys;
  
  public YTActReflectImage(byte[] paramArrayOfByte, float[] paramArrayOfFloat, String paramString)
  {
    this.image = paramArrayOfByte;
    this.xys = paramArrayOfFloat;
    this.checksum = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.data.YTActReflectImage
 * JD-Core Version:    0.7.0.1
 */
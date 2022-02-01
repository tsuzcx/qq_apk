package com.tencent.ttpic.params;

public class LightBasicBeauty
{
  public static final String BASIC_BASIC_LIPS = "basicLips";
  public static final String BASIC_MULTIPLY = "basicMultiply";
  public static final String BASIC_SOFT_LIGHT = "basicSoftLight";
  private int defValue;
  private String path;
  private int type;
  
  public LightBasicBeauty(String paramString, int paramInt)
  {
    this.path = paramString;
    this.defValue = paramInt;
  }
  
  public LightBasicBeauty(String paramString, int paramInt1, int paramInt2)
  {
    this.path = paramString;
    this.defValue = paramInt1;
    this.type = paramInt2;
  }
  
  public int getDefValue()
  {
    return this.defValue;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public int getType()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.params.LightBasicBeauty
 * JD-Core Version:    0.7.0.1
 */
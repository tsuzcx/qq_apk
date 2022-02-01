package com.tencent.tavcut.bean;

public class ResInfoModel
{
  private CropConfig cropConfig;
  private String resPath;
  private int type;
  
  public CropConfig getCropConfig()
  {
    return this.cropConfig;
  }
  
  public String getResPath()
  {
    return this.resPath;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setCropConfig(CropConfig paramCropConfig)
  {
    this.cropConfig = paramCropConfig;
  }
  
  public void setResPath(String paramString)
  {
    this.resPath = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.bean.ResInfoModel
 * JD-Core Version:    0.7.0.1
 */
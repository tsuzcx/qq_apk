package com.tencent.mobileqq.qqlive.data.anchor.camera;

public class QQLiveCameraFilterInfo
{
  public String desc;
  public String id;
  public boolean isSelected;
  public int thumbHeight;
  public String thumbUrl;
  public int thumbWidth;
  
  public QQLiveCameraFilterInfo() {}
  
  public QQLiveCameraFilterInfo(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this.id = paramString1;
    this.thumbUrl = paramString2;
    this.desc = paramString3;
    this.thumbHeight = paramInt1;
    this.thumbWidth = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveCameraFilterInfo
 * JD-Core Version:    0.7.0.1
 */
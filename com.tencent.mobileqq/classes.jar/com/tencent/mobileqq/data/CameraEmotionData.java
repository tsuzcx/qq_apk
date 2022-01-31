package com.tencent.mobileqq.data;

public class CameraEmotionData
  extends CustomEmotionBase
{
  public int clickNum;
  public int exposeNum;
  public String strContext;
  
  public void increaseClickNum()
  {
    if (this.clickNum == 2147483647) {
      return;
    }
    this.clickNum += 1;
  }
  
  public void increaseExposeNum()
  {
    if (this.exposeNum == 2147483647) {
      return;
    }
    this.exposeNum += 1;
  }
  
  public void replace(CameraEmotionData paramCameraEmotionData)
  {
    if (paramCameraEmotionData != null)
    {
      super.replace(paramCameraEmotionData);
      this.strContext = paramCameraEmotionData.strContext;
    }
  }
  
  public String toString()
  {
    return "CameraEmotionData [uin=" + this.uin + ", emoId=" + this.emoId + ", emoPath=" + this.emoPath + ", strContext=" + this.strContext + ", RomaingType=" + this.RomaingType + ", resid=" + this.resid + ", url=" + this.url + ", md5=" + this.md5 + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.CameraEmotionData
 * JD-Core Version:    0.7.0.1
 */
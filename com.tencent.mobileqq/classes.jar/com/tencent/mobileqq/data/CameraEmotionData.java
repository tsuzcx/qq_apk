package com.tencent.mobileqq.data;

public class CameraEmotionData
  extends CustomEmotionBase
{
  public int clickNum;
  public int exposeNum;
  public String strContext;
  public String templateId;
  
  public void increaseClickNum()
  {
    int i = this.clickNum;
    if (i == 2147483647) {
      return;
    }
    this.clickNum = (i + 1);
  }
  
  public void increaseExposeNum()
  {
    int i = this.exposeNum;
    if (i == 2147483647) {
      return;
    }
    this.exposeNum = (i + 1);
  }
  
  public void replace(CameraEmotionData paramCameraEmotionData)
  {
    if (paramCameraEmotionData != null)
    {
      super.replace(paramCameraEmotionData);
      this.strContext = paramCameraEmotionData.strContext;
      this.templateId = paramCameraEmotionData.templateId;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CameraEmotionData [uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(", emoId=");
    localStringBuilder.append(this.emoId);
    localStringBuilder.append(", emoPath=");
    localStringBuilder.append(this.emoPath);
    localStringBuilder.append(", strContext=");
    localStringBuilder.append(this.strContext);
    localStringBuilder.append(", RomaingType=");
    localStringBuilder.append(this.RomaingType);
    localStringBuilder.append(", resid=");
    localStringBuilder.append(this.resid);
    localStringBuilder.append(", url=");
    localStringBuilder.append(this.url);
    localStringBuilder.append(", md5=");
    localStringBuilder.append(this.md5);
    localStringBuilder.append(", templateId:");
    localStringBuilder.append(this.templateId);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.CameraEmotionData
 * JD-Core Version:    0.7.0.1
 */
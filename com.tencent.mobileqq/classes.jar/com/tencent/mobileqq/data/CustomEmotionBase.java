package com.tencent.mobileqq.data;

import awbv;
import awdj;

public class CustomEmotionBase
  extends awbv
{
  public String RomaingType = "init";
  @awdj
  public int emoId;
  public String emoOriginalPath;
  public String emoPath;
  public boolean isAPNG;
  public String md5;
  public String resid;
  public String thumbPath;
  public String uin;
  public String url;
  
  public void replace(CustomEmotionBase paramCustomEmotionBase)
  {
    if (paramCustomEmotionBase != null)
    {
      this.uin = paramCustomEmotionBase.uin;
      this.emoId = paramCustomEmotionBase.emoId;
      this.emoPath = paramCustomEmotionBase.emoPath;
      this.RomaingType = paramCustomEmotionBase.RomaingType;
      this.resid = paramCustomEmotionBase.resid;
      this.url = paramCustomEmotionBase.url;
      this.md5 = paramCustomEmotionBase.md5;
      this.isAPNG = paramCustomEmotionBase.isAPNG;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.data.CustomEmotionBase
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class CustomEmotionData
  extends CustomEmotionBase
{
  public int clickNum;
  public String eId;
  public int exposeNum;
  public boolean isMarkFace = false;
  public String modifyWord;
  public String ocrWord;
  
  public boolean checkMarketFace(String paramString)
  {
    if ((this.isMarkFace) && ((TextUtils.isEmpty(this.eId)) || (TextUtils.isEmpty(this.emoPath))))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error MarketFace from ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", ");
      localStringBuilder.append(toString());
      QLog.e("CustomEmotionData", 1, localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  public CustomEmotionData cloneEmotionData(CustomEmotionData paramCustomEmotionData)
  {
    CustomEmotionData localCustomEmotionData = new CustomEmotionData();
    localCustomEmotionData.uin = paramCustomEmotionData.uin;
    localCustomEmotionData.emoId = paramCustomEmotionData.emoId;
    localCustomEmotionData.emoPath = paramCustomEmotionData.emoPath;
    localCustomEmotionData.resid = paramCustomEmotionData.resid;
    localCustomEmotionData.url = paramCustomEmotionData.url;
    localCustomEmotionData.md5 = paramCustomEmotionData.md5;
    localCustomEmotionData.emoOriginalPath = paramCustomEmotionData.emoOriginalPath;
    localCustomEmotionData.thumbPath = paramCustomEmotionData.thumbPath;
    localCustomEmotionData.RomaingType = paramCustomEmotionData.RomaingType;
    localCustomEmotionData.isAPNG = paramCustomEmotionData.isAPNG;
    localCustomEmotionData.isMarkFace = paramCustomEmotionData.isMarkFace;
    localCustomEmotionData.eId = paramCustomEmotionData.eId;
    localCustomEmotionData.ocrWord = paramCustomEmotionData.ocrWord;
    localCustomEmotionData.modifyWord = paramCustomEmotionData.modifyWord;
    localCustomEmotionData.exposeNum = paramCustomEmotionData.exposeNum;
    localCustomEmotionData.clickNum = paramCustomEmotionData.clickNum;
    return localCustomEmotionData;
  }
  
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
  
  public void replace(CustomEmotionData paramCustomEmotionData)
  {
    if (paramCustomEmotionData != null)
    {
      super.replace(paramCustomEmotionData);
      this.isMarkFace = paramCustomEmotionData.isMarkFace;
      this.eId = paramCustomEmotionData.eId;
      this.ocrWord = paramCustomEmotionData.ocrWord;
      this.modifyWord = paramCustomEmotionData.modifyWord;
      this.exposeNum = paramCustomEmotionData.exposeNum;
      this.clickNum = paramCustomEmotionData.clickNum;
      checkMarketFace("replace");
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CustomEmotionData [uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(", emoId=");
    localStringBuilder.append(this.emoId);
    localStringBuilder.append(", emoPath=");
    localStringBuilder.append(this.emoPath);
    localStringBuilder.append(", isMarkFace=");
    localStringBuilder.append(this.isMarkFace);
    localStringBuilder.append(", RomaingType=");
    localStringBuilder.append(this.RomaingType);
    localStringBuilder.append(", eId=");
    localStringBuilder.append(this.eId);
    localStringBuilder.append(", resid=");
    localStringBuilder.append(this.resid);
    localStringBuilder.append(", url=");
    localStringBuilder.append(this.url);
    localStringBuilder.append(", md5=");
    localStringBuilder.append(this.md5);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.CustomEmotionData
 * JD-Core Version:    0.7.0.1
 */
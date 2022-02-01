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
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.isMarkFace) {
      if (!TextUtils.isEmpty(this.eId))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(this.emoPath)) {}
      }
      else
      {
        QLog.e("CustomEmotionData", 1, "error MarketFace from " + paramString + ", " + toString());
        bool1 = false;
      }
    }
    return bool1;
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
    return "CustomEmotionData [uin=" + this.uin + ", emoId=" + this.emoId + ", emoPath=" + this.emoPath + ", isMarkFace=" + this.isMarkFace + ", RomaingType=" + this.RomaingType + ", eId=" + this.eId + ", resid=" + this.resid + ", url=" + this.url + ", md5=" + this.md5 + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.CustomEmotionData
 * JD-Core Version:    0.7.0.1
 */
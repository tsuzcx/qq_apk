package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;

public class CustomEmotionData
  extends Entity
{
  public String RomaingType = "init";
  public String eId;
  @unique
  public int emoId;
  public String emoPath;
  public boolean isAPNG;
  public boolean isMarkFace;
  public String md5;
  public String resid;
  public String uin;
  public String url;
  
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
        QLog.e("FavroamingDBManager", 1, "error MarketFace from " + paramString + ", " + toString());
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public void replace(CustomEmotionData paramCustomEmotionData)
  {
    if (paramCustomEmotionData != null)
    {
      this.uin = paramCustomEmotionData.uin;
      this.emoId = paramCustomEmotionData.emoId;
      this.emoPath = paramCustomEmotionData.emoPath;
      this.isMarkFace = paramCustomEmotionData.isMarkFace;
      this.RomaingType = paramCustomEmotionData.RomaingType;
      this.eId = paramCustomEmotionData.eId;
      this.resid = paramCustomEmotionData.resid;
      this.url = paramCustomEmotionData.url;
      this.md5 = paramCustomEmotionData.md5;
      this.isAPNG = paramCustomEmotionData.isAPNG;
      checkMarketFace("replace");
    }
  }
  
  public String toString()
  {
    return "CustomEmotionData [uin=" + this.uin + ", emoId=" + this.emoId + ", emoPath=" + this.emoPath + ", isMarkFace=" + this.isMarkFace + ", RomaingType=" + this.RomaingType + ", eId=" + this.eId + ", resid=" + this.resid + ", url=" + this.url + ", md5=" + this.md5 + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.CustomEmotionData
 * JD-Core Version:    0.7.0.1
 */
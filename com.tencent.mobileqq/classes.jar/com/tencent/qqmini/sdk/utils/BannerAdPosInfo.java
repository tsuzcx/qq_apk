package com.tencent.qqmini.sdk.utils;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class BannerAdPosInfo
{
  public static final int BANNER_MIN_WIDTH = ;
  public static final int BANNER_UPDATE_SIZE_LEFT = 1;
  public static final int BANNER_UPDATE_SIZE_NO = -1;
  public static final int BANNER_UPDATE_SIZE_TOP = 2;
  public static final int BANNER_UPDATE_SIZE_WIDTH = 3;
  private static final String TAG = "BannerAdPosInfo";
  public int mAdHeight;
  public int mAdLeft;
  public int mAdRealHeight;
  public int mAdRealWidth;
  public int mAdTop;
  public String mAdUnitId;
  public int mAdWidth;
  
  private BannerAdPosInfo(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mAdUnitId = paramString;
    this.mAdLeft = paramInt1;
    this.mAdTop = paramInt2;
    this.mAdWidth = paramInt3;
    this.mAdHeight = paramInt4;
    this.mAdRealWidth = paramInt3;
    this.mAdRealHeight = paramInt4;
  }
  
  public BannerAdPosInfo(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.mAdUnitId = paramString;
    this.mAdLeft = paramInt1;
    this.mAdTop = paramInt2;
    this.mAdWidth = paramInt3;
    this.mAdHeight = paramInt4;
    this.mAdRealWidth = paramInt5;
    this.mAdRealHeight = paramInt6;
  }
  
  public static BannerAdPosInfo buildFormatInfo(BannerAdPosInfo paramBannerAdPosInfo, int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((paramBannerAdPosInfo == null) || (paramFloat == 0.0F)) {
      return null;
    }
    paramInt1 = calculateLegalWidth(paramBannerAdPosInfo.mAdWidth, paramInt1, paramFloat, paramInt2, paramInt3);
    paramInt2 = Double.valueOf(1.0D * paramInt1 / 1026.0D * 249.0D).intValue();
    return new BannerAdPosInfo(paramBannerAdPosInfo.mAdUnitId, paramBannerAdPosInfo.mAdLeft, paramBannerAdPosInfo.mAdTop, paramBannerAdPosInfo.mAdWidth, paramBannerAdPosInfo.mAdHeight, paramInt1, paramInt2);
  }
  
  public static int calculateLegalWidth(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4)
  {
    if (paramFloat == 0.0F) {
      return paramInt1;
    }
    if (paramInt1 < BANNER_MIN_WIDTH) {}
    int i;
    int j;
    int i1;
    int n;
    for (int k = BANNER_MIN_WIDTH;; k = paramInt1)
    {
      i = Math.round(paramInt3 * 1.0F / paramFloat);
      j = Math.round(paramInt4 * 1.0F / paramFloat);
      switch (paramInt2)
      {
      default: 
        i1 = i;
        n = j;
        i = k;
        QMLog.i("BannerAdPosInfo", "buildFormatInfo，deviceOrientation = " + paramInt2 + ", density = " + paramFloat + ", screeWpx = " + paramInt3 + ", screeHpx = " + paramInt4 + ", screenW = " + i1 + ", screenH = " + n + ", originWidth = " + paramInt1 + ", realWidth = " + i);
        return i;
      }
    }
    int m;
    if (i < j)
    {
      m = j;
      j = i;
    }
    for (;;)
    {
      i = k;
      n = j;
      i1 = m;
      if (k <= m / 2) {
        break;
      }
      i = m / 2;
      n = j;
      i1 = m;
      break;
      m = i;
      n = j;
      if (j < i)
      {
        n = i;
        m = j;
      }
      i = k;
      if (k > m) {
        i = m;
      }
      i1 = m;
      break;
      m = i;
    }
  }
  
  public static int getHeight(int paramInt)
  {
    return Double.valueOf(1.0D * paramInt / 1026.0D * 249.0D).intValue();
  }
  
  public static BannerAdPosInfo parseBannerAdPosInfoFromJson(String paramString)
  {
    int m = 0;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(paramString);
        String str = ((JSONObject)localObject2).getString("adUnitId");
        QMLog.i("BannerAdPosInfo", "parseBannerAdPosInfoFromJson error " + paramString, localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          k = ((JSONObject)localObject2).getJSONObject("style").getInt("left");
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            i = 0;
            j = 0;
            int k = 0;
            localObject2 = localObject1;
            localObject1 = localException2;
          }
        }
        try
        {
          j = ((JSONObject)localObject2).getJSONObject("style").getInt("top");
        }
        catch (Exception localException3)
        {
          i = 0;
          j = 0;
          localObject2 = localObject1;
          localObject1 = localException3;
          break label133;
        }
        try
        {
          i = ((JSONObject)localObject2).getJSONObject("style").getInt("width");
        }
        catch (Exception localException4)
        {
          i = 0;
          localObject2 = localObject1;
          localObject1 = localException4;
          break label133;
        }
        try
        {
          if (((JSONObject)localObject2).getJSONObject("style").has("height")) {
            m = ((JSONObject)localObject2).getJSONObject("style").getInt("height");
          }
          if ((!TextUtils.isEmpty(str)) && (k >= 0) && (j >= 0) && (i > 0)) {
            break;
          }
          return null;
        }
        catch (Exception localException5)
        {
          localObject2 = localObject1;
          localObject1 = localException5;
          break label133;
        }
        localException1 = localException1;
        i = 0;
        j = 0;
        localObject2 = "";
        k = 0;
      }
      label133:
      m = 0;
      localObject1 = localObject2;
    }
    return new BannerAdPosInfo(localObject1, k, j, i, m);
  }
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.mAdUnitId)) && (this.mAdRealWidth > 0) && (this.mAdRealHeight > 0);
  }
  
  public void reset()
  {
    this.mAdUnitId = "";
    this.mAdLeft = 0;
    this.mAdTop = 0;
    this.mAdWidth = 0;
    this.mAdHeight = 0;
    this.mAdRealWidth = 0;
    this.mAdRealHeight = 0;
  }
  
  public String toString()
  {
    return "mAdUnitId = " + this.mAdUnitId + ", left = " + this.mAdLeft + ", top = " + this.mAdTop + ", width = " + this.mAdWidth + ", height = " + this.mAdHeight + ", realWidth = " + this.mAdRealWidth + ", realHeight = " + this.mAdRealHeight;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.BannerAdPosInfo
 * JD-Core Version:    0.7.0.1
 */
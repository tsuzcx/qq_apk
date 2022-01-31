package com.tencent.mobileqq.minigame.data;

import aajk;
import android.text.TextUtils;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.qphone.base.util.QLog;

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
    paramInt2 = aajk.a(0, paramInt1);
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
        QLog.i("BannerAdPosInfo", 2, "buildFormatInfo，deviceOrientation = " + paramInt2 + ", density = " + paramFloat + ", screeWpx = " + paramInt3 + ", screeHpx = " + paramInt4 + ", screenW = " + i1 + ", screenH = " + n + ", originWidth = " + paramInt1 + ", realWidth = " + i);
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
  
  /* Error */
  public static BannerAdPosInfo parseBannerAdPosInfoFromJson(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: iconst_0
    //   10: istore 4
    //   12: new 126	org/json/JSONObject
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 129	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   20: astore 7
    //   22: aload 7
    //   24: ldc 131
    //   26: invokevirtual 135	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   29: astore 6
    //   31: aload 7
    //   33: ldc 137
    //   35: invokevirtual 141	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   38: ldc 143
    //   40: invokevirtual 147	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   43: istore_3
    //   44: aload 7
    //   46: ldc 137
    //   48: invokevirtual 141	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   51: ldc 149
    //   53: invokevirtual 147	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   56: istore_2
    //   57: aload 7
    //   59: ldc 137
    //   61: invokevirtual 141	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   64: ldc 151
    //   66: invokevirtual 147	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   69: istore_1
    //   70: aload 7
    //   72: ldc 137
    //   74: invokevirtual 141	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   77: ldc 153
    //   79: invokevirtual 147	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   82: istore 5
    //   84: iload 5
    //   86: istore 4
    //   88: aload 6
    //   90: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   93: ifne -86 -> 7
    //   96: iload_3
    //   97: iflt -90 -> 7
    //   100: iload_2
    //   101: iflt -94 -> 7
    //   104: iload_1
    //   105: ifle -98 -> 7
    //   108: new 2	com/tencent/mobileqq/minigame/data/BannerAdPosInfo
    //   111: dup
    //   112: aload 6
    //   114: iload_3
    //   115: iload_2
    //   116: iload_1
    //   117: iload 4
    //   119: invokespecial 155	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:<init>	(Ljava/lang/String;IIII)V
    //   122: areturn
    //   123: astore 6
    //   125: iconst_0
    //   126: istore_1
    //   127: iconst_0
    //   128: istore_2
    //   129: ldc 157
    //   131: astore 7
    //   133: iconst_0
    //   134: istore_3
    //   135: ldc 18
    //   137: iconst_2
    //   138: new 77	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   145: ldc 159
    //   147: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_0
    //   151: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: aload 6
    //   159: invokestatic 162	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   162: aload 7
    //   164: astore 6
    //   166: goto -78 -> 88
    //   169: astore 8
    //   171: iconst_0
    //   172: istore_1
    //   173: iconst_0
    //   174: istore_2
    //   175: iconst_0
    //   176: istore_3
    //   177: aload 6
    //   179: astore 7
    //   181: aload 8
    //   183: astore 6
    //   185: goto -50 -> 135
    //   188: astore 8
    //   190: iconst_0
    //   191: istore_1
    //   192: iconst_0
    //   193: istore_2
    //   194: aload 6
    //   196: astore 7
    //   198: aload 8
    //   200: astore 6
    //   202: goto -67 -> 135
    //   205: astore 8
    //   207: iconst_0
    //   208: istore_1
    //   209: aload 6
    //   211: astore 7
    //   213: aload 8
    //   215: astore 6
    //   217: goto -82 -> 135
    //   220: astore 8
    //   222: aload 6
    //   224: astore 7
    //   226: aload 8
    //   228: astore 6
    //   230: goto -95 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	paramString	String
    //   69	140	1	i	int
    //   56	138	2	j	int
    //   43	134	3	k	int
    //   10	108	4	m	int
    //   82	3	5	n	int
    //   29	84	6	str	String
    //   123	35	6	localException1	java.lang.Exception
    //   164	65	6	localObject1	Object
    //   20	205	7	localObject2	Object
    //   169	13	8	localException2	java.lang.Exception
    //   188	11	8	localException3	java.lang.Exception
    //   205	9	8	localException4	java.lang.Exception
    //   220	7	8	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   12	31	123	java/lang/Exception
    //   31	44	169	java/lang/Exception
    //   44	57	188	java/lang/Exception
    //   57	70	205	java/lang/Exception
    //   70	84	220	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.data.BannerAdPosInfo
 * JD-Core Version:    0.7.0.1
 */
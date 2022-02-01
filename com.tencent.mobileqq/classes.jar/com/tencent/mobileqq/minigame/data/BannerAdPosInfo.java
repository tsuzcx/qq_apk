package com.tencent.mobileqq.minigame.data;

import android.text.TextUtils;
import com.tencent.gdtad.api.banner.GdtBannerViewBuilder;
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
    if ((paramBannerAdPosInfo != null) && (paramFloat != 0.0F))
    {
      paramInt1 = calculateLegalWidth(paramBannerAdPosInfo.mAdWidth, paramInt1, paramFloat, paramInt2, paramInt3);
      paramInt2 = GdtBannerViewBuilder.b(0, paramInt1);
      return new BannerAdPosInfo(paramBannerAdPosInfo.mAdUnitId, paramBannerAdPosInfo.mAdLeft, paramBannerAdPosInfo.mAdTop, paramBannerAdPosInfo.mAdWidth, paramBannerAdPosInfo.mAdHeight, paramInt1, paramInt2);
    }
    return null;
  }
  
  public static int calculateLegalWidth(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4)
  {
    if (paramFloat == 0.0F) {
      return paramInt1;
    }
    int m = BANNER_MIN_WIDTH;
    if (paramInt1 >= m) {
      m = paramInt1;
    }
    int j = Math.round(paramInt3 * 1.0F / paramFloat);
    int i = Math.round(paramInt4 * 1.0F / paramFloat);
    int n;
    int i1;
    int k;
    if (paramInt2 != 0)
    {
      if (paramInt2 != 90)
      {
        n = m;
      }
      else
      {
        i1 = j;
        k = i;
        if (j < i)
        {
          k = j;
          i1 = i;
        }
        int i2 = i1 / 2;
        n = m;
        j = i1;
        i = k;
        if (m > i2)
        {
          n = i2;
          j = i1;
          i = k;
        }
      }
    }
    else
    {
      k = j;
      i1 = i;
      if (i < j)
      {
        i1 = j;
        k = i;
      }
      n = m;
      j = k;
      i = i1;
      if (m > k)
      {
        n = k;
        i = i1;
        j = k;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buildFormatInfo，deviceOrientation = ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", density = ");
    localStringBuilder.append(paramFloat);
    localStringBuilder.append(", screeWpx = ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(", screeHpx = ");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append(", screenW = ");
    localStringBuilder.append(j);
    localStringBuilder.append(", screenH = ");
    localStringBuilder.append(i);
    localStringBuilder.append(", originWidth = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", realWidth = ");
    localStringBuilder.append(n);
    QLog.i("BannerAdPosInfo", 2, localStringBuilder.toString());
    return n;
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
    //   9: ldc 126
    //   11: astore 6
    //   13: aload 6
    //   15: astore 7
    //   17: new 128	org/json/JSONObject
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 131	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   25: astore 8
    //   27: aload 6
    //   29: astore 7
    //   31: aload 8
    //   33: ldc 133
    //   35: invokevirtual 137	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   38: astore 6
    //   40: aload 6
    //   42: astore 7
    //   44: aload 8
    //   46: ldc 139
    //   48: invokevirtual 143	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   51: ldc 145
    //   53: invokevirtual 149	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   56: istore_1
    //   57: aload 8
    //   59: ldc 139
    //   61: invokevirtual 143	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   64: ldc 151
    //   66: invokevirtual 149	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   69: istore_2
    //   70: aload 8
    //   72: ldc 139
    //   74: invokevirtual 143	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   77: ldc 153
    //   79: invokevirtual 149	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   82: istore 4
    //   84: aload 8
    //   86: ldc 139
    //   88: invokevirtual 143	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   91: ldc 155
    //   93: invokevirtual 149	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   96: istore_3
    //   97: iload_3
    //   98: istore 5
    //   100: goto +88 -> 188
    //   103: astore 7
    //   105: iload_1
    //   106: istore_3
    //   107: iload 4
    //   109: istore_1
    //   110: goto +33 -> 143
    //   113: astore 7
    //   115: iload_1
    //   116: istore_3
    //   117: goto +24 -> 141
    //   120: astore 7
    //   122: goto +15 -> 137
    //   125: astore 8
    //   127: iconst_0
    //   128: istore_1
    //   129: aload 7
    //   131: astore 6
    //   133: aload 8
    //   135: astore 7
    //   137: iconst_0
    //   138: istore_2
    //   139: iload_1
    //   140: istore_3
    //   141: iconst_0
    //   142: istore_1
    //   143: new 77	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   150: astore 8
    //   152: aload 8
    //   154: ldc 157
    //   156: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 8
    //   162: aload_0
    //   163: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: ldc 18
    //   169: iconst_2
    //   170: aload 8
    //   172: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: aload 7
    //   177: invokestatic 160	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   180: iconst_0
    //   181: istore 5
    //   183: iload_1
    //   184: istore 4
    //   186: iload_3
    //   187: istore_1
    //   188: aload 6
    //   190: invokestatic 124	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   193: ifne +34 -> 227
    //   196: iload_1
    //   197: iflt +30 -> 227
    //   200: iload_2
    //   201: iflt +26 -> 227
    //   204: iload 4
    //   206: ifgt +5 -> 211
    //   209: aconst_null
    //   210: areturn
    //   211: new 2	com/tencent/mobileqq/minigame/data/BannerAdPosInfo
    //   214: dup
    //   215: aload 6
    //   217: iload_1
    //   218: iload_2
    //   219: iload 4
    //   221: iload 5
    //   223: invokespecial 162	com/tencent/mobileqq/minigame/data/BannerAdPosInfo:<init>	(Ljava/lang/String;IIII)V
    //   226: areturn
    //   227: aconst_null
    //   228: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	paramString	String
    //   56	162	1	i	int
    //   69	150	2	j	int
    //   96	91	3	k	int
    //   82	138	4	m	int
    //   98	124	5	n	int
    //   11	205	6	localObject1	Object
    //   15	28	7	localObject2	Object
    //   103	1	7	localException1	java.lang.Exception
    //   113	1	7	localException2	java.lang.Exception
    //   120	10	7	localException3	java.lang.Exception
    //   135	41	7	localObject3	Object
    //   25	60	8	localJSONObject	org.json.JSONObject
    //   125	9	8	localException4	java.lang.Exception
    //   150	21	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   84	97	103	java/lang/Exception
    //   70	84	113	java/lang/Exception
    //   57	70	120	java/lang/Exception
    //   17	27	125	java/lang/Exception
    //   31	40	125	java/lang/Exception
    //   44	57	125	java/lang/Exception
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mAdUnitId = ");
    localStringBuilder.append(this.mAdUnitId);
    localStringBuilder.append(", left = ");
    localStringBuilder.append(this.mAdLeft);
    localStringBuilder.append(", top = ");
    localStringBuilder.append(this.mAdTop);
    localStringBuilder.append(", width = ");
    localStringBuilder.append(this.mAdWidth);
    localStringBuilder.append(", height = ");
    localStringBuilder.append(this.mAdHeight);
    localStringBuilder.append(", realWidth = ");
    localStringBuilder.append(this.mAdRealWidth);
    localStringBuilder.append(", realHeight = ");
    localStringBuilder.append(this.mAdRealHeight);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.data.BannerAdPosInfo
 * JD-Core Version:    0.7.0.1
 */
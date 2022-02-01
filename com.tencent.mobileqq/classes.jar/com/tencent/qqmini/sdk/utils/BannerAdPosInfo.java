package com.tencent.qqmini.sdk.utils;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class BannerAdPosInfo
{
  public static final int BANNER_MIN_WIDTH = ;
  public static final int BANNER_UPDATE_SIZE_LEFT = 1;
  public static final int BANNER_UPDATE_SIZE_NO = -1;
  public static final int BANNER_UPDATE_SIZE_TOP = 2;
  public static final int BANNER_UPDATE_SIZE_WIDTH = 3;
  private static final String TAG = "BannerAdPosInfo";
  public int mAdHeight;
  public int mAdIntervals;
  public int mAdLeft;
  public int mAdRealHeight;
  public int mAdRealWidth;
  public int mAdTop;
  public String mAdUnitId;
  public int mAdWidth;
  
  private BannerAdPosInfo(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mAdUnitId = paramString;
    this.mAdLeft = paramInt1;
    this.mAdTop = paramInt2;
    this.mAdWidth = paramInt3;
    this.mAdHeight = paramInt4;
    this.mAdRealWidth = paramInt3;
    this.mAdRealHeight = paramInt4;
    this.mAdIntervals = paramInt5;
  }
  
  public BannerAdPosInfo(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.mAdUnitId = paramString;
    this.mAdLeft = paramInt1;
    this.mAdTop = paramInt2;
    this.mAdWidth = paramInt3;
    this.mAdHeight = paramInt4;
    this.mAdRealWidth = paramInt5;
    this.mAdRealHeight = paramInt6;
    this.mAdIntervals = paramInt7;
  }
  
  public static BannerAdPosInfo buildFormatInfo(BannerAdPosInfo paramBannerAdPosInfo, int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((paramBannerAdPosInfo != null) && (paramFloat != 0.0F))
    {
      paramInt1 = calculateLegalWidth(paramBannerAdPosInfo.mAdWidth, paramInt1, paramFloat, paramInt2, paramInt3);
      double d = paramInt1;
      Double.isNaN(d);
      paramInt2 = Double.valueOf(d * 1.0D / 1026.0D * 249.0D).intValue();
      return new BannerAdPosInfo(paramBannerAdPosInfo.mAdUnitId, paramBannerAdPosInfo.mAdLeft, paramBannerAdPosInfo.mAdTop, paramBannerAdPosInfo.mAdWidth, paramBannerAdPosInfo.mAdHeight, paramInt1, paramInt2, paramBannerAdPosInfo.mAdIntervals);
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
    if (paramInt2 != 1)
    {
      if (paramInt2 != 2)
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
    QMLog.i("BannerAdPosInfo", localStringBuilder.toString());
    return n;
  }
  
  public static int getHeight(int paramInt)
  {
    double d = paramInt;
    Double.isNaN(d);
    return Double.valueOf(d * 1.0D / 1026.0D * 249.0D).intValue();
  }
  
  /* Error */
  public static BannerAdPosInfo parseBannerAdPosInfoFromJson(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: ldc 142
    //   11: astore 7
    //   13: iconst_0
    //   14: istore 6
    //   16: aload 7
    //   18: astore 8
    //   20: new 144	org/json/JSONObject
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 147	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   28: astore 9
    //   30: aload 7
    //   32: astore 8
    //   34: aload 9
    //   36: ldc 149
    //   38: invokevirtual 153	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   41: astore 7
    //   43: aload 7
    //   45: astore 8
    //   47: aload 9
    //   49: ldc 155
    //   51: invokevirtual 159	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   54: ldc 161
    //   56: invokevirtual 165	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   59: istore_1
    //   60: aload 9
    //   62: ldc 155
    //   64: invokevirtual 159	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   67: ldc 167
    //   69: invokevirtual 165	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   72: istore_3
    //   73: aload 9
    //   75: ldc 155
    //   77: invokevirtual 159	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   80: ldc 169
    //   82: invokevirtual 165	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   85: istore 5
    //   87: aload 9
    //   89: ldc 155
    //   91: invokevirtual 159	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   94: ldc 171
    //   96: invokevirtual 175	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   99: ifeq +19 -> 118
    //   102: aload 9
    //   104: ldc 155
    //   106: invokevirtual 159	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   109: ldc 171
    //   111: invokevirtual 165	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   114: istore_2
    //   115: goto +5 -> 120
    //   118: iconst_0
    //   119: istore_2
    //   120: iload 6
    //   122: istore 4
    //   124: aload 9
    //   126: ldc 177
    //   128: invokevirtual 175	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   131: ifeq +26 -> 157
    //   134: iload 6
    //   136: istore 4
    //   138: aload 9
    //   140: ldc 177
    //   142: invokevirtual 165	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   145: ifle +12 -> 157
    //   148: aload 9
    //   150: ldc 177
    //   152: invokevirtual 165	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   155: istore 4
    //   157: iload 4
    //   159: istore 6
    //   161: goto +106 -> 267
    //   164: astore 8
    //   166: iload_1
    //   167: istore 4
    //   169: iload 5
    //   171: istore_1
    //   172: goto +50 -> 222
    //   175: astore 8
    //   177: iconst_0
    //   178: istore_2
    //   179: iload_1
    //   180: istore 4
    //   182: iload 5
    //   184: istore_1
    //   185: goto +37 -> 222
    //   188: astore 8
    //   190: iload_1
    //   191: istore 4
    //   193: goto +25 -> 218
    //   196: astore 8
    //   198: goto +15 -> 213
    //   201: astore 9
    //   203: iconst_0
    //   204: istore_1
    //   205: aload 8
    //   207: astore 7
    //   209: aload 9
    //   211: astore 8
    //   213: iconst_0
    //   214: istore_3
    //   215: iload_1
    //   216: istore 4
    //   218: iconst_0
    //   219: istore_2
    //   220: iconst_0
    //   221: istore_1
    //   222: new 91	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   229: astore 9
    //   231: aload 9
    //   233: ldc 179
    //   235: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 9
    //   241: aload_0
    //   242: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: ldc 18
    //   248: aload 9
    //   250: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: aload 8
    //   255: invokestatic 182	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   258: iconst_0
    //   259: istore 6
    //   261: iload_1
    //   262: istore 5
    //   264: iload 4
    //   266: istore_1
    //   267: aload 7
    //   269: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   272: ifne +35 -> 307
    //   275: iload_1
    //   276: iflt +31 -> 307
    //   279: iload_3
    //   280: iflt +27 -> 307
    //   283: iload 5
    //   285: ifgt +5 -> 290
    //   288: aconst_null
    //   289: areturn
    //   290: new 2	com/tencent/qqmini/sdk/utils/BannerAdPosInfo
    //   293: dup
    //   294: aload 7
    //   296: iload_1
    //   297: iload_3
    //   298: iload 5
    //   300: iload_2
    //   301: iload 6
    //   303: invokespecial 184	com/tencent/qqmini/sdk/utils/BannerAdPosInfo:<init>	(Ljava/lang/String;IIIII)V
    //   306: areturn
    //   307: aconst_null
    //   308: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	paramString	String
    //   59	238	1	i	int
    //   114	187	2	j	int
    //   72	226	3	k	int
    //   122	143	4	m	int
    //   85	214	5	n	int
    //   14	288	6	i1	int
    //   11	284	7	localObject1	Object
    //   18	28	8	localObject2	Object
    //   164	1	8	localException1	java.lang.Exception
    //   175	1	8	localException2	java.lang.Exception
    //   188	1	8	localException3	java.lang.Exception
    //   196	10	8	localException4	java.lang.Exception
    //   211	43	8	localObject3	Object
    //   28	121	9	localJSONObject	org.json.JSONObject
    //   201	9	9	localException5	java.lang.Exception
    //   229	20	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   124	134	164	java/lang/Exception
    //   138	157	164	java/lang/Exception
    //   87	115	175	java/lang/Exception
    //   73	87	188	java/lang/Exception
    //   60	73	196	java/lang/Exception
    //   20	30	201	java/lang/Exception
    //   34	43	201	java/lang/Exception
    //   47	60	201	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.BannerAdPosInfo
 * JD-Core Version:    0.7.0.1
 */
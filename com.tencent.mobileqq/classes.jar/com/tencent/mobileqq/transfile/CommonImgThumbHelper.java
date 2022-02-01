package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.DeviceProfileManager;

public class CommonImgThumbHelper
{
  private static final String TAG = "CommonImgThumbHelper";
  private static CommonImgThumbHelper mInstance;
  private static int sImageDynamicMax;
  private static int sImageDynamicMin;
  private static int sImageMaxSize;
  private static int sImageMinSize = 45;
  private static boolean sSizeInited;
  private static int sThumbnailDynamicMax = sImageDynamicMax;
  private static int sThumbnailDynamicMin;
  private static int sThumbnailMax;
  private static int sThumbnailMin;
  
  static
  {
    sImageMaxSize = 135;
    sImageDynamicMin = 45;
    sImageDynamicMax = 135;
    sThumbnailMin = sImageMinSize;
    sThumbnailMax = sImageMaxSize;
    sThumbnailDynamicMin = sImageDynamicMin;
  }
  
  public static int getImgThumbMaxDp(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return sImageDynamicMax;
    }
    return sImageMaxSize;
  }
  
  public static int getImgThumbMaxPx(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return sThumbnailDynamicMax;
    }
    return sThumbnailMax;
  }
  
  public static int getImgThumbMinDp(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return sImageDynamicMin;
    }
    return sImageMinSize;
  }
  
  public static int getImgThumbMinPx(boolean paramBoolean)
  {
    
    if (paramBoolean) {
      return sThumbnailDynamicMin;
    }
    return sThumbnailMin;
  }
  
  public static CommonImgThumbHelper getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new CommonImgThumbHelper();
      }
      return mInstance;
    }
    finally {}
  }
  
  public static void initAioThumbSizeByDpc()
  {
    getInstance().initAioThumbSizeByDpcInner();
  }
  
  public DeviceProfileManager getDeviceProfileManager()
  {
    return DeviceProfileManager.a();
  }
  
  /* Error */
  public void initAioThumbSizeByDpcInner()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 70	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sSizeInited	Z
    //   5: istore 4
    //   7: iload 4
    //   9: ifeq +6 -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: invokevirtual 72	com/tencent/mobileqq/transfile/CommonImgThumbHelper:getDeviceProfileManager	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   19: getstatic 78	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:aio_pic_thumb_size	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   22: invokevirtual 82	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   25: ldc 84
    //   27: invokevirtual 87	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   30: ldc 89
    //   32: invokevirtual 95	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   35: astore 5
    //   37: aload 5
    //   39: arraylength
    //   40: iconst_2
    //   41: if_icmpne +59 -> 100
    //   44: aload 5
    //   46: iconst_0
    //   47: aaload
    //   48: invokestatic 101	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   51: invokevirtual 105	java/lang/Integer:intValue	()I
    //   54: istore_3
    //   55: iload_3
    //   56: bipush 45
    //   58: if_icmplt +14 -> 72
    //   61: iload_3
    //   62: sipush 198
    //   65: if_icmpgt +7 -> 72
    //   68: iload_3
    //   69: putstatic 27	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sImageMaxSize	I
    //   72: aload 5
    //   74: iconst_1
    //   75: aaload
    //   76: invokestatic 101	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   79: invokevirtual 105	java/lang/Integer:intValue	()I
    //   82: istore_3
    //   83: iload_3
    //   84: bipush 45
    //   86: if_icmplt +14 -> 100
    //   89: iload_3
    //   90: sipush 198
    //   93: if_icmpgt +7 -> 100
    //   96: iload_3
    //   97: putstatic 31	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sImageDynamicMax	I
    //   100: invokestatic 111	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   103: invokevirtual 117	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   106: invokevirtual 123	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   109: getfield 129	android/util/DisplayMetrics:density	F
    //   112: fstore_2
    //   113: fload_2
    //   114: fstore_1
    //   115: fload_2
    //   116: fconst_0
    //   117: fcmpg
    //   118: ifgt +5 -> 123
    //   121: fconst_1
    //   122: fstore_1
    //   123: getstatic 27	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sImageMaxSize	I
    //   126: i2f
    //   127: fload_1
    //   128: fmul
    //   129: f2i
    //   130: putstatic 35	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sThumbnailMax	I
    //   133: getstatic 31	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sImageDynamicMax	I
    //   136: i2f
    //   137: fload_1
    //   138: fmul
    //   139: f2i
    //   140: putstatic 39	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sThumbnailDynamicMax	I
    //   143: getstatic 25	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sImageMinSize	I
    //   146: i2f
    //   147: fload_1
    //   148: fmul
    //   149: f2i
    //   150: putstatic 33	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sThumbnailMin	I
    //   153: fload_1
    //   154: getstatic 29	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sImageDynamicMin	I
    //   157: i2f
    //   158: fmul
    //   159: f2i
    //   160: putstatic 37	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sThumbnailDynamicMin	I
    //   163: iconst_1
    //   164: putstatic 70	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sSizeInited	Z
    //   167: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq -158 -> 12
    //   173: ldc 8
    //   175: iconst_2
    //   176: iconst_4
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: ldc 137
    //   184: aastore
    //   185: dup
    //   186: iconst_1
    //   187: getstatic 35	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sThumbnailMax	I
    //   190: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   193: aastore
    //   194: dup
    //   195: iconst_2
    //   196: ldc 142
    //   198: aastore
    //   199: dup
    //   200: iconst_3
    //   201: getstatic 39	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sThumbnailDynamicMax	I
    //   204: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: aastore
    //   208: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   211: goto -199 -> 12
    //   214: astore 5
    //   216: aload_0
    //   217: monitorexit
    //   218: aload 5
    //   220: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	CommonImgThumbHelper
    //   114	40	1	f1	float
    //   112	4	2	f2	float
    //   54	43	3	i	int
    //   5	3	4	bool	boolean
    //   35	38	5	arrayOfString	String[]
    //   214	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	214	finally
    //   15	55	214	finally
    //   68	72	214	finally
    //   72	83	214	finally
    //   96	100	214	finally
    //   100	113	214	finally
    //   123	211	214	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.CommonImgThumbHelper
 * JD-Core Version:    0.7.0.1
 */
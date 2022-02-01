package com.tencent.mobileqq.transfile;

public class CommonImgThumbHelper
{
  private static final String TAG = "CommonImgThumbHelper";
  private static CommonImgThumbHelper mInstance;
  private static int sImageDynamicMax;
  private static int sImageDynamicMin;
  private static int sImageMaxSize;
  private static int sImageMinSize = 45;
  private static boolean sSizeInited = false;
  private static int sThumbnailDynamicMax;
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
    sThumbnailDynamicMax = sImageDynamicMax;
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
  
  /* Error */
  public void initAioThumbSizeByDpcInner()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 41	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sSizeInited	Z
    //   5: istore 4
    //   7: iload 4
    //   9: ifeq +6 -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: ldc 65
    //   17: invokestatic 71	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   20: checkcast 65	com/tencent/mobileqq/dpc/api/IDPCApi
    //   23: getstatic 77	com/tencent/mobileqq/dpc/enumname/DPCNames:aio_pic_thumb_size	Lcom/tencent/mobileqq/dpc/enumname/DPCNames;
    //   26: invokevirtual 81	com/tencent/mobileqq/dpc/enumname/DPCNames:name	()Ljava/lang/String;
    //   29: ldc 83
    //   31: invokeinterface 87 3 0
    //   36: ldc 89
    //   38: invokevirtual 95	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   41: astore 5
    //   43: aload 5
    //   45: arraylength
    //   46: iconst_2
    //   47: if_icmpne +59 -> 106
    //   50: aload 5
    //   52: iconst_0
    //   53: aaload
    //   54: invokestatic 101	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   57: invokevirtual 105	java/lang/Integer:intValue	()I
    //   60: istore_3
    //   61: iload_3
    //   62: bipush 45
    //   64: if_icmplt +14 -> 78
    //   67: iload_3
    //   68: sipush 198
    //   71: if_icmpgt +7 -> 78
    //   74: iload_3
    //   75: putstatic 27	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sImageMaxSize	I
    //   78: aload 5
    //   80: iconst_1
    //   81: aaload
    //   82: invokestatic 101	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   85: invokevirtual 105	java/lang/Integer:intValue	()I
    //   88: istore_3
    //   89: iload_3
    //   90: bipush 45
    //   92: if_icmplt +14 -> 106
    //   95: iload_3
    //   96: sipush 198
    //   99: if_icmpgt +7 -> 106
    //   102: iload_3
    //   103: putstatic 31	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sImageDynamicMax	I
    //   106: invokestatic 111	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   109: invokevirtual 117	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   112: invokevirtual 123	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   115: getfield 129	android/util/DisplayMetrics:density	F
    //   118: fstore_2
    //   119: fload_2
    //   120: fstore_1
    //   121: fload_2
    //   122: fconst_0
    //   123: fcmpg
    //   124: ifgt +5 -> 129
    //   127: fconst_1
    //   128: fstore_1
    //   129: getstatic 27	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sImageMaxSize	I
    //   132: i2f
    //   133: fload_1
    //   134: fmul
    //   135: f2i
    //   136: putstatic 35	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sThumbnailMax	I
    //   139: getstatic 31	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sImageDynamicMax	I
    //   142: i2f
    //   143: fload_1
    //   144: fmul
    //   145: f2i
    //   146: putstatic 39	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sThumbnailDynamicMax	I
    //   149: getstatic 25	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sImageMinSize	I
    //   152: i2f
    //   153: fload_1
    //   154: fmul
    //   155: f2i
    //   156: putstatic 33	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sThumbnailMin	I
    //   159: fload_1
    //   160: getstatic 29	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sImageDynamicMin	I
    //   163: i2f
    //   164: fmul
    //   165: f2i
    //   166: putstatic 37	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sThumbnailDynamicMin	I
    //   169: iconst_1
    //   170: putstatic 41	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sSizeInited	Z
    //   173: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq -164 -> 12
    //   179: ldc 8
    //   181: iconst_2
    //   182: iconst_4
    //   183: anewarray 4	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: ldc 137
    //   190: aastore
    //   191: dup
    //   192: iconst_1
    //   193: getstatic 35	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sThumbnailMax	I
    //   196: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   199: aastore
    //   200: dup
    //   201: iconst_2
    //   202: ldc 142
    //   204: aastore
    //   205: dup
    //   206: iconst_3
    //   207: getstatic 39	com/tencent/mobileqq/transfile/CommonImgThumbHelper:sThumbnailDynamicMax	I
    //   210: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   213: aastore
    //   214: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   217: goto -205 -> 12
    //   220: astore 5
    //   222: aload_0
    //   223: monitorexit
    //   224: aload 5
    //   226: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	CommonImgThumbHelper
    //   120	40	1	f1	float
    //   118	4	2	f2	float
    //   60	43	3	i	int
    //   5	3	4	bool	boolean
    //   41	38	5	arrayOfString	String[]
    //   220	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	220	finally
    //   15	61	220	finally
    //   74	78	220	finally
    //   78	89	220	finally
    //   102	106	220	finally
    //   106	119	220	finally
    //   129	217	220	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.CommonImgThumbHelper
 * JD-Core Version:    0.7.0.1
 */
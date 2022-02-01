package com.tencent.mobileqq.shortvideo.util;

import android.content.res.AssetManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class NativeBridge
{
  private static final String TAG = "TK_Config_NativeSoLoader";
  private static boolean globalInitialized = false;
  private static boolean loadSoSuccess = false;
  public String basePath = null;
  
  public NativeBridge(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {}
    try
    {
      System.loadLibrary("TKGLRenderer");
      AssetManager localAssetManager = BaseApplicationImpl.getApplication().getAssets();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(File.separator);
      setAssetManager(localAssetManager, localStringBuilder.toString());
      loadSoSuccess = true;
      return;
    }
    catch (Throwable paramString) {}
    initSoEnvirontMent(paramString);
    return;
  }
  
  private static boolean initSoEnvirontMent(String paramString)
  {
    if (!NativeSoLoader.a("TKGLRenderer"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArNativeSoLoader", 2, "native so is not exist!");
      }
      return false;
    }
    boolean bool;
    if (!globalInitialized)
    {
      bool = true;
      globalInitialized = true;
    }
    for (;;)
    {
      try
      {
        int i = NativeSoLoader.b("TKGLRenderer");
        AssetManager localAssetManager = BaseApplicationImpl.getApplication().getAssets();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(File.separator);
        setAssetManager(localAssetManager, localStringBuilder.toString());
        if (i != 0) {
          break label145;
        }
        loadSoSuccess = bool;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("initSoEnvirontMent loadSoSuccess = ");
        paramString.append(loadSoSuccess);
        QLog.d("TK_Config_NativeSoLoader", 2, paramString.toString());
      }
      return loadSoSuccess;
      label145:
      bool = false;
    }
  }
  
  private native void nativeInitOnjBridge();
  
  public static void qqColorLog(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.e(paramString1, 2, paramString2);
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.w(paramString1, 2, paramString2);
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  private static native void setAssetManager(AssetManager paramAssetManager, String paramString);
  
  public boolean filter3DInitOnjBridge()
  {
    if (loadSoSuccess) {
      try
      {
        nativeInitOnjBridge();
        return true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
    return false;
  }
  
  /* Error */
  public android.graphics.Bitmap loadBitmapFromNative(String paramString, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +38 -> 41
    //   6: new 44	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   13: astore 6
    //   15: aload 6
    //   17: ldc 128
    //   19: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 6
    //   25: aload_1
    //   26: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 8
    //   32: iconst_2
    //   33: aload 6
    //   35: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: invokestatic 132	java/lang/System:currentTimeMillis	()J
    //   44: lstore_3
    //   45: aconst_null
    //   46: astore 13
    //   48: aconst_null
    //   49: astore 10
    //   51: aconst_null
    //   52: astore 7
    //   54: aconst_null
    //   55: astore 8
    //   57: aconst_null
    //   58: astore 6
    //   60: aconst_null
    //   61: astore 12
    //   63: aload_1
    //   64: getstatic 54	java/io/File:separator	Ljava/lang/String;
    //   67: invokevirtual 137	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   70: istore 5
    //   72: iload 5
    //   74: ifne +362 -> 436
    //   77: invokestatic 38	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   80: invokevirtual 141	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   83: invokevirtual 144	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   86: astore 6
    //   88: new 44	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   95: astore 8
    //   97: aload 8
    //   99: ldc 146
    //   101: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 8
    //   107: getstatic 54	java/io/File:separator	Ljava/lang/String;
    //   110: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 8
    //   116: aload_1
    //   117: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 6
    //   123: aload 8
    //   125: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokevirtual 152	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   131: astore 6
    //   133: aload 6
    //   135: astore 7
    //   137: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +54 -> 194
    //   143: aload 6
    //   145: astore 7
    //   147: new 44	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   154: astore 8
    //   156: aload 6
    //   158: astore 7
    //   160: aload 8
    //   162: ldc 154
    //   164: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 6
    //   170: astore 7
    //   172: aload 8
    //   174: aload_1
    //   175: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 6
    //   181: astore 7
    //   183: ldc 8
    //   185: iconst_2
    //   186: aload 8
    //   188: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: goto +400 -> 594
    //   197: aconst_null
    //   198: astore 6
    //   200: aload 6
    //   202: astore 7
    //   204: new 44	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   211: astore 9
    //   213: aload 6
    //   215: astore 7
    //   217: aload 13
    //   219: astore 10
    //   221: aload 6
    //   223: astore 8
    //   225: aload 9
    //   227: aload_0
    //   228: getfield 24	com/tencent/mobileqq/shortvideo/util/NativeBridge:basePath	Ljava/lang/String;
    //   231: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 6
    //   237: astore 7
    //   239: aload 13
    //   241: astore 10
    //   243: aload 6
    //   245: astore 8
    //   247: aload 9
    //   249: aload_1
    //   250: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload 6
    //   256: astore 7
    //   258: aload 13
    //   260: astore 10
    //   262: aload 6
    //   264: astore 8
    //   266: aload 9
    //   268: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: astore 9
    //   273: aload 6
    //   275: astore 7
    //   277: aload 13
    //   279: astore 10
    //   281: aload 6
    //   283: astore 8
    //   285: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +87 -> 375
    //   291: aload 6
    //   293: astore 7
    //   295: aload 13
    //   297: astore 10
    //   299: aload 6
    //   301: astore 8
    //   303: new 44	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   310: astore 11
    //   312: aload 6
    //   314: astore 7
    //   316: aload 13
    //   318: astore 10
    //   320: aload 6
    //   322: astore 8
    //   324: aload 11
    //   326: ldc 156
    //   328: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 6
    //   334: astore 7
    //   336: aload 13
    //   338: astore 10
    //   340: aload 6
    //   342: astore 8
    //   344: aload 11
    //   346: aload 9
    //   348: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload 6
    //   354: astore 7
    //   356: aload 13
    //   358: astore 10
    //   360: aload 6
    //   362: astore 8
    //   364: ldc 8
    //   366: iconst_2
    //   367: aload 11
    //   369: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: aload 6
    //   377: astore 7
    //   379: aload 13
    //   381: astore 10
    //   383: aload 6
    //   385: astore 8
    //   387: new 158	java/io/FileInputStream
    //   390: dup
    //   391: aload 9
    //   393: invokespecial 160	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   396: astore 9
    //   398: aload 9
    //   400: astore 6
    //   402: goto +22 -> 424
    //   405: astore 9
    //   407: aload 6
    //   409: astore 7
    //   411: aload 13
    //   413: astore 10
    //   415: aload 6
    //   417: astore 8
    //   419: aload 9
    //   421: invokevirtual 161	java/io/FileNotFoundException:printStackTrace	()V
    //   424: goto +170 -> 594
    //   427: astore_1
    //   428: goto +344 -> 772
    //   431: astore 7
    //   433: goto +352 -> 785
    //   436: new 158	java/io/FileInputStream
    //   439: dup
    //   440: aload_1
    //   441: invokespecial 160	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   444: astore 9
    //   446: aload 9
    //   448: astore 6
    //   450: aload 9
    //   452: astore 7
    //   454: aload 13
    //   456: astore 10
    //   458: aload 9
    //   460: astore 8
    //   462: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   465: ifeq +129 -> 594
    //   468: aload 9
    //   470: astore 7
    //   472: aload 13
    //   474: astore 10
    //   476: aload 9
    //   478: astore 8
    //   480: new 44	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   487: astore 6
    //   489: aload 9
    //   491: astore 7
    //   493: aload 13
    //   495: astore 10
    //   497: aload 9
    //   499: astore 8
    //   501: aload 6
    //   503: ldc 156
    //   505: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload 9
    //   511: astore 7
    //   513: aload 13
    //   515: astore 10
    //   517: aload 9
    //   519: astore 8
    //   521: aload 6
    //   523: aload_1
    //   524: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload 9
    //   530: astore 7
    //   532: aload 13
    //   534: astore 10
    //   536: aload 9
    //   538: astore 8
    //   540: ldc 8
    //   542: iconst_2
    //   543: aload 6
    //   545: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   551: aload 9
    //   553: astore 6
    //   555: goto +39 -> 594
    //   558: astore 11
    //   560: aload 9
    //   562: astore 6
    //   564: goto +13 -> 577
    //   567: astore 6
    //   569: goto +241 -> 810
    //   572: astore 11
    //   574: aconst_null
    //   575: astore 6
    //   577: aload 6
    //   579: astore 7
    //   581: aload 13
    //   583: astore 10
    //   585: aload 6
    //   587: astore 8
    //   589: aload 11
    //   591: invokevirtual 161	java/io/FileNotFoundException:printStackTrace	()V
    //   594: aload 6
    //   596: astore 7
    //   598: aload 13
    //   600: astore 10
    //   602: aload 6
    //   604: astore 8
    //   606: aload 6
    //   608: invokestatic 167	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   611: astore 9
    //   613: goto +26 -> 639
    //   616: astore 9
    //   618: aload 6
    //   620: astore 7
    //   622: aload 13
    //   624: astore 10
    //   626: aload 6
    //   628: astore 8
    //   630: aload 9
    //   632: invokevirtual 168	java/lang/OutOfMemoryError:printStackTrace	()V
    //   635: aload 12
    //   637: astore 9
    //   639: aload 9
    //   641: astore 7
    //   643: aload 9
    //   645: ifnull +91 -> 736
    //   648: aload 9
    //   650: astore 7
    //   652: iload_2
    //   653: ifne +83 -> 736
    //   656: aload 6
    //   658: astore 7
    //   660: aload 9
    //   662: astore 10
    //   664: aload 6
    //   666: astore 8
    //   668: new 170	android/graphics/Matrix
    //   671: dup
    //   672: invokespecial 171	android/graphics/Matrix:<init>	()V
    //   675: astore 11
    //   677: aload 6
    //   679: astore 7
    //   681: aload 9
    //   683: astore 10
    //   685: aload 6
    //   687: astore 8
    //   689: aload 11
    //   691: fconst_1
    //   692: ldc 172
    //   694: invokevirtual 176	android/graphics/Matrix:preScale	(FF)Z
    //   697: pop
    //   698: aload 6
    //   700: astore 7
    //   702: aload 9
    //   704: astore 10
    //   706: aload 6
    //   708: astore 8
    //   710: aload 9
    //   712: iconst_0
    //   713: iconst_0
    //   714: aload 9
    //   716: invokevirtual 182	android/graphics/Bitmap:getWidth	()I
    //   719: aload 9
    //   721: invokevirtual 185	android/graphics/Bitmap:getHeight	()I
    //   724: aload 11
    //   726: iconst_1
    //   727: invokestatic 189	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   730: astore 9
    //   732: aload 9
    //   734: astore 7
    //   736: aload 7
    //   738: astore 8
    //   740: aload 6
    //   742: ifnull +108 -> 850
    //   745: aload 6
    //   747: invokevirtual 194	java/io/InputStream:close	()V
    //   750: aload 7
    //   752: astore 8
    //   754: goto +96 -> 850
    //   757: astore 6
    //   759: aload 6
    //   761: invokevirtual 195	java/io/IOException:printStackTrace	()V
    //   764: aload 7
    //   766: astore 8
    //   768: goto +82 -> 850
    //   771: astore_1
    //   772: aload 7
    //   774: astore 6
    //   776: goto +157 -> 933
    //   779: astore 7
    //   781: aload 8
    //   783: astore 6
    //   785: aload 7
    //   787: astore 9
    //   789: aload 6
    //   791: astore 8
    //   793: aload 10
    //   795: astore 7
    //   797: goto +20 -> 817
    //   800: astore_1
    //   801: aload 7
    //   803: astore 6
    //   805: goto +128 -> 933
    //   808: astore 6
    //   810: aconst_null
    //   811: astore 7
    //   813: aload 6
    //   815: astore 9
    //   817: aload 8
    //   819: astore 6
    //   821: aload 9
    //   823: invokevirtual 196	java/lang/Exception:printStackTrace	()V
    //   826: aload 8
    //   828: ifnull +18 -> 846
    //   831: aload 8
    //   833: invokevirtual 194	java/io/InputStream:close	()V
    //   836: goto +10 -> 846
    //   839: astore 6
    //   841: aload 6
    //   843: invokevirtual 195	java/io/IOException:printStackTrace	()V
    //   846: aload 7
    //   848: astore 8
    //   850: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   853: ifeq +73 -> 926
    //   856: new 44	java/lang/StringBuilder
    //   859: dup
    //   860: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   863: astore 6
    //   865: aload 6
    //   867: ldc 128
    //   869: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: pop
    //   873: aload 6
    //   875: aload_1
    //   876: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: pop
    //   880: aload 6
    //   882: ldc 198
    //   884: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: pop
    //   888: aload 6
    //   890: aload 8
    //   892: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   895: pop
    //   896: aload 6
    //   898: ldc 203
    //   900: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   903: pop
    //   904: aload 6
    //   906: invokestatic 132	java/lang/System:currentTimeMillis	()J
    //   909: lload_3
    //   910: lsub
    //   911: invokevirtual 206	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   914: pop
    //   915: ldc 8
    //   917: iconst_2
    //   918: aload 6
    //   920: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   923: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   926: aload 8
    //   928: areturn
    //   929: astore_1
    //   930: goto -125 -> 805
    //   933: aload 6
    //   935: ifnull +18 -> 953
    //   938: aload 6
    //   940: invokevirtual 194	java/io/InputStream:close	()V
    //   943: goto +10 -> 953
    //   946: astore 6
    //   948: aload 6
    //   950: invokevirtual 195	java/io/IOException:printStackTrace	()V
    //   953: goto +5 -> 958
    //   956: aload_1
    //   957: athrow
    //   958: goto -2 -> 956
    //   961: astore 6
    //   963: goto -766 -> 197
    //   966: astore 7
    //   968: goto -768 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	971	0	this	NativeBridge
    //   0	971	1	paramString	String
    //   0	971	2	paramInt	int
    //   44	866	3	l	long
    //   70	3	5	bool	boolean
    //   13	550	6	localObject1	Object
    //   567	1	6	localException1	java.lang.Exception
    //   575	171	6	localInputStream	java.io.InputStream
    //   757	3	6	localIOException1	java.io.IOException
    //   774	30	6	localObject2	Object
    //   808	6	6	localException2	java.lang.Exception
    //   819	1	6	localObject3	Object
    //   839	3	6	localIOException2	java.io.IOException
    //   863	76	6	localStringBuilder1	StringBuilder
    //   946	3	6	localIOException3	java.io.IOException
    //   961	1	6	localException3	java.lang.Exception
    //   52	358	7	localObject4	Object
    //   431	1	7	localException4	java.lang.Exception
    //   452	321	7	localObject5	Object
    //   779	7	7	localException5	java.lang.Exception
    //   795	52	7	localObject6	Object
    //   966	1	7	localException6	java.lang.Exception
    //   55	872	8	localObject7	Object
    //   211	188	9	localObject8	Object
    //   405	15	9	localFileNotFoundException1	java.io.FileNotFoundException
    //   444	168	9	localObject9	Object
    //   616	15	9	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   637	185	9	localObject10	Object
    //   49	745	10	localObject11	Object
    //   310	58	11	localStringBuilder2	StringBuilder
    //   558	1	11	localFileNotFoundException2	java.io.FileNotFoundException
    //   572	18	11	localFileNotFoundException3	java.io.FileNotFoundException
    //   675	50	11	localMatrix	android.graphics.Matrix
    //   61	575	12	localObject12	Object
    //   46	577	13	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   387	398	405	java/io/FileNotFoundException
    //   137	143	427	finally
    //   147	156	427	finally
    //   160	168	427	finally
    //   172	179	427	finally
    //   183	194	427	finally
    //   204	213	427	finally
    //   204	213	431	java/lang/Exception
    //   462	468	558	java/io/FileNotFoundException
    //   480	489	558	java/io/FileNotFoundException
    //   501	509	558	java/io/FileNotFoundException
    //   521	528	558	java/io/FileNotFoundException
    //   540	551	558	java/io/FileNotFoundException
    //   436	446	567	java/lang/Exception
    //   436	446	572	java/io/FileNotFoundException
    //   606	613	616	java/lang/OutOfMemoryError
    //   745	750	757	java/io/IOException
    //   225	235	771	finally
    //   247	254	771	finally
    //   266	273	771	finally
    //   285	291	771	finally
    //   303	312	771	finally
    //   324	332	771	finally
    //   344	352	771	finally
    //   364	375	771	finally
    //   387	398	771	finally
    //   419	424	771	finally
    //   462	468	771	finally
    //   480	489	771	finally
    //   501	509	771	finally
    //   521	528	771	finally
    //   540	551	771	finally
    //   589	594	771	finally
    //   606	613	771	finally
    //   630	635	771	finally
    //   668	677	771	finally
    //   689	698	771	finally
    //   710	732	771	finally
    //   225	235	779	java/lang/Exception
    //   247	254	779	java/lang/Exception
    //   266	273	779	java/lang/Exception
    //   285	291	779	java/lang/Exception
    //   303	312	779	java/lang/Exception
    //   324	332	779	java/lang/Exception
    //   344	352	779	java/lang/Exception
    //   364	375	779	java/lang/Exception
    //   387	398	779	java/lang/Exception
    //   419	424	779	java/lang/Exception
    //   462	468	779	java/lang/Exception
    //   480	489	779	java/lang/Exception
    //   501	509	779	java/lang/Exception
    //   521	528	779	java/lang/Exception
    //   540	551	779	java/lang/Exception
    //   589	594	779	java/lang/Exception
    //   606	613	779	java/lang/Exception
    //   630	635	779	java/lang/Exception
    //   668	677	779	java/lang/Exception
    //   689	698	779	java/lang/Exception
    //   710	732	779	java/lang/Exception
    //   63	72	800	finally
    //   77	133	800	finally
    //   63	72	808	java/lang/Exception
    //   831	836	839	java/io/IOException
    //   436	446	929	finally
    //   821	826	929	finally
    //   938	943	946	java/io/IOException
    //   77	133	961	java/lang/Exception
    //   137	143	966	java/lang/Exception
    //   147	156	966	java/lang/Exception
    //   160	168	966	java/lang/Exception
    //   172	179	966	java/lang/Exception
    //   183	194	966	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.NativeBridge
 * JD-Core Version:    0.7.0.1
 */
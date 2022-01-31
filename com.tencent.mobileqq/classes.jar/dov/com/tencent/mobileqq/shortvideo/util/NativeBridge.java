package dov.com.tencent.mobileqq.shortvideo.util;

import android.content.res.AssetManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class NativeBridge
{
  private static final String TAG = "TK_Config_NativeSoLoader";
  private static boolean globalInitialized;
  private static boolean loadSoSuccess;
  public String basePath;
  
  public NativeBridge(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {}
    try
    {
      System.loadLibrary("TKGLRenderer");
      setAssetManager(BaseApplicationImpl.getApplication().getAssets(), paramString + File.separator);
      loadSoSuccess = true;
      return;
    }
    catch (Throwable paramString) {}
    initSoEnvirontMent(paramString);
    return;
  }
  
  private static boolean initSoEnvirontMent(String paramString)
  {
    boolean bool = false;
    if (!NativeSoLoader.a("TKGLRenderer"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArNativeSoLoader", 2, "native so is not exist!");
      }
      return false;
    }
    if (!globalInitialized) {
      globalInitialized = true;
    }
    try
    {
      int i = NativeSoLoader.a("TKGLRenderer");
      setAssetManager(BaseApplicationImpl.getApplication().getAssets(), paramString + File.separator);
      if (i == 0) {
        bool = true;
      }
      loadSoSuccess = bool;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TK_Config_NativeSoLoader", 2, "initSoEnvirontMent loadSoSuccess = " + loadSoSuccess);
    }
    return loadSoSuccess;
  }
  
  private native void nativeInitOnjBridge();
  
  public static void qqColorLog(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!QLog.isColorLevel());
        QLog.d(paramString1, 2, paramString2);
        return;
      } while (!QLog.isColorLevel());
      QLog.w(paramString1, 2, paramString2);
      return;
    } while (!QLog.isColorLevel());
    QLog.e(paramString1, 2, paramString2);
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
    //   0: aconst_null
    //   1: astore 6
    //   3: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +28 -> 34
    //   9: ldc 8
    //   11: iconst_2
    //   12: new 39	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   19: ldc 123
    //   21: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: invokestatic 127	java/lang/System:currentTimeMillis	()J
    //   37: lstore_3
    //   38: aload_1
    //   39: getstatic 49	java/io/File:separator	Ljava/lang/String;
    //   42: invokevirtual 132	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   45: istore 5
    //   47: iload 5
    //   49: ifne +336 -> 385
    //   52: invokestatic 33	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   55: invokevirtual 136	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   58: invokevirtual 139	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   61: new 39	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   68: ldc 141
    //   70: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: getstatic 49	java/io/File:separator	Ljava/lang/String;
    //   76: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_1
    //   80: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokevirtual 147	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   89: astore 7
    //   91: aload 7
    //   93: astore 6
    //   95: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +32 -> 130
    //   101: aload 7
    //   103: astore 6
    //   105: ldc 8
    //   107: iconst_2
    //   108: new 39	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   115: ldc 149
    //   117: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_1
    //   121: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload 7
    //   132: astore 6
    //   134: aload 6
    //   136: invokestatic 155	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   139: astore 7
    //   141: aload 7
    //   143: astore 8
    //   145: aload 7
    //   147: ifnull +51 -> 198
    //   150: aload 7
    //   152: astore 8
    //   154: iload_2
    //   155: ifne +43 -> 198
    //   158: new 157	android/graphics/Matrix
    //   161: dup
    //   162: invokespecial 158	android/graphics/Matrix:<init>	()V
    //   165: astore 8
    //   167: aload 8
    //   169: fconst_1
    //   170: ldc 159
    //   172: invokevirtual 163	android/graphics/Matrix:preScale	(FF)Z
    //   175: pop
    //   176: aload 7
    //   178: iconst_0
    //   179: iconst_0
    //   180: aload 7
    //   182: invokevirtual 169	android/graphics/Bitmap:getWidth	()I
    //   185: aload 7
    //   187: invokevirtual 172	android/graphics/Bitmap:getHeight	()I
    //   190: aload 8
    //   192: iconst_1
    //   193: invokestatic 176	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   196: astore 8
    //   198: aload 8
    //   200: astore 9
    //   202: aload 6
    //   204: ifnull +12 -> 216
    //   207: aload 6
    //   209: invokevirtual 181	java/io/InputStream:close	()V
    //   212: aload 8
    //   214: astore 9
    //   216: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   219: ifeq +51 -> 270
    //   222: ldc 8
    //   224: iconst_2
    //   225: new 39	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   232: ldc 123
    //   234: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_1
    //   238: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: ldc 183
    //   243: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload 9
    //   248: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   251: ldc 188
    //   253: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokestatic 127	java/lang/System:currentTimeMillis	()J
    //   259: lload_3
    //   260: lsub
    //   261: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   264: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: aload 9
    //   272: areturn
    //   273: astore 6
    //   275: aconst_null
    //   276: astore 7
    //   278: aload 7
    //   280: astore 6
    //   282: new 39	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   289: aload_0
    //   290: getfield 193	dov/com/tencent/mobileqq/shortvideo/util/NativeBridge:basePath	Ljava/lang/String;
    //   293: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_1
    //   297: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: astore 8
    //   305: aload 7
    //   307: astore 6
    //   309: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   312: ifeq +33 -> 345
    //   315: aload 7
    //   317: astore 6
    //   319: ldc 8
    //   321: iconst_2
    //   322: new 39	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   329: ldc 195
    //   331: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload 8
    //   336: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: aload 7
    //   347: astore 6
    //   349: new 197	java/io/FileInputStream
    //   352: dup
    //   353: aload 8
    //   355: invokespecial 199	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   358: astore 8
    //   360: aload 8
    //   362: astore 6
    //   364: goto -230 -> 134
    //   367: astore 8
    //   369: aload 7
    //   371: astore 6
    //   373: aload 8
    //   375: invokevirtual 200	java/io/FileNotFoundException:printStackTrace	()V
    //   378: aload 7
    //   380: astore 6
    //   382: goto -18 -> 364
    //   385: new 197	java/io/FileInputStream
    //   388: dup
    //   389: aload_1
    //   390: invokespecial 199	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   393: astore 7
    //   395: aload 7
    //   397: astore 6
    //   399: aload 7
    //   401: astore 8
    //   403: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq +36 -> 442
    //   409: aload 7
    //   411: astore 6
    //   413: aload 7
    //   415: astore 8
    //   417: ldc 8
    //   419: iconst_2
    //   420: new 39	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   427: ldc 195
    //   429: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload_1
    //   433: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   442: aload 7
    //   444: astore 6
    //   446: goto -312 -> 134
    //   449: astore 9
    //   451: aconst_null
    //   452: astore 7
    //   454: aload 7
    //   456: astore 6
    //   458: aload 7
    //   460: astore 8
    //   462: aload 9
    //   464: invokevirtual 200	java/io/FileNotFoundException:printStackTrace	()V
    //   467: aload 7
    //   469: astore 6
    //   471: goto -337 -> 134
    //   474: astore 7
    //   476: aload 7
    //   478: invokevirtual 201	java/lang/OutOfMemoryError:printStackTrace	()V
    //   481: aconst_null
    //   482: astore 7
    //   484: goto -343 -> 141
    //   487: astore 6
    //   489: aload 6
    //   491: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   494: aload 8
    //   496: astore 9
    //   498: goto -282 -> 216
    //   501: astore 8
    //   503: aconst_null
    //   504: astore 9
    //   506: aload 6
    //   508: astore 7
    //   510: aload 9
    //   512: astore 6
    //   514: aload 8
    //   516: invokevirtual 203	java/lang/Exception:printStackTrace	()V
    //   519: aload 6
    //   521: astore 9
    //   523: aload 7
    //   525: ifnull -309 -> 216
    //   528: aload 7
    //   530: invokevirtual 181	java/io/InputStream:close	()V
    //   533: aload 6
    //   535: astore 9
    //   537: goto -321 -> 216
    //   540: astore 7
    //   542: aload 7
    //   544: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   547: aload 6
    //   549: astore 9
    //   551: goto -335 -> 216
    //   554: astore_1
    //   555: aconst_null
    //   556: astore 6
    //   558: aload 6
    //   560: ifnull +8 -> 568
    //   563: aload 6
    //   565: invokevirtual 181	java/io/InputStream:close	()V
    //   568: aload_1
    //   569: athrow
    //   570: astore 6
    //   572: aload 6
    //   574: invokevirtual 202	java/io/IOException:printStackTrace	()V
    //   577: goto -9 -> 568
    //   580: astore_1
    //   581: goto -23 -> 558
    //   584: astore_1
    //   585: goto -27 -> 558
    //   588: astore_1
    //   589: aload 7
    //   591: astore 6
    //   593: goto -35 -> 558
    //   596: astore 8
    //   598: aconst_null
    //   599: astore 6
    //   601: goto -87 -> 514
    //   604: astore 9
    //   606: aconst_null
    //   607: astore 6
    //   609: aload 8
    //   611: astore 7
    //   613: aload 9
    //   615: astore 8
    //   617: goto -103 -> 514
    //   620: astore 8
    //   622: aconst_null
    //   623: astore 9
    //   625: aload 6
    //   627: astore 7
    //   629: aload 9
    //   631: astore 6
    //   633: goto -119 -> 514
    //   636: astore 8
    //   638: aload 6
    //   640: astore 9
    //   642: aload 7
    //   644: astore 6
    //   646: aload 9
    //   648: astore 7
    //   650: goto -136 -> 514
    //   653: astore 9
    //   655: goto -201 -> 454
    //   658: astore 6
    //   660: goto -382 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	663	0	this	NativeBridge
    //   0	663	1	paramString	String
    //   0	663	2	paramInt	int
    //   37	223	3	l	long
    //   45	3	5	bool	boolean
    //   1	207	6	localObject1	Object
    //   273	1	6	localException1	java.lang.Exception
    //   280	190	6	localObject2	Object
    //   487	20	6	localIOException1	java.io.IOException
    //   512	52	6	localObject3	Object
    //   570	3	6	localIOException2	java.io.IOException
    //   591	54	6	localObject4	Object
    //   658	1	6	localException2	java.lang.Exception
    //   89	379	7	localObject5	Object
    //   474	3	7	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   482	47	7	localIOException3	java.io.IOException
    //   540	50	7	localIOException4	java.io.IOException
    //   611	38	7	localObject6	Object
    //   143	218	8	localObject7	Object
    //   367	7	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   401	94	8	localObject8	Object
    //   501	14	8	localException3	java.lang.Exception
    //   596	14	8	localException4	java.lang.Exception
    //   615	1	8	localObject9	Object
    //   620	1	8	localException5	java.lang.Exception
    //   636	1	8	localException6	java.lang.Exception
    //   200	71	9	localObject10	Object
    //   449	14	9	localFileNotFoundException2	java.io.FileNotFoundException
    //   496	54	9	localObject11	Object
    //   604	10	9	localException7	java.lang.Exception
    //   623	24	9	localObject12	Object
    //   653	1	9	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   52	91	273	java/lang/Exception
    //   349	360	367	java/io/FileNotFoundException
    //   385	395	449	java/io/FileNotFoundException
    //   134	141	474	java/lang/OutOfMemoryError
    //   207	212	487	java/io/IOException
    //   38	47	501	java/lang/Exception
    //   385	395	501	java/lang/Exception
    //   528	533	540	java/io/IOException
    //   38	47	554	finally
    //   52	91	554	finally
    //   385	395	554	finally
    //   563	568	570	java/io/IOException
    //   95	101	580	finally
    //   105	130	580	finally
    //   282	305	580	finally
    //   309	315	580	finally
    //   319	345	580	finally
    //   349	360	580	finally
    //   373	378	580	finally
    //   403	409	580	finally
    //   417	442	580	finally
    //   462	467	580	finally
    //   134	141	584	finally
    //   158	198	584	finally
    //   476	481	584	finally
    //   514	519	588	finally
    //   282	305	596	java/lang/Exception
    //   309	315	596	java/lang/Exception
    //   319	345	596	java/lang/Exception
    //   349	360	596	java/lang/Exception
    //   373	378	596	java/lang/Exception
    //   403	409	604	java/lang/Exception
    //   417	442	604	java/lang/Exception
    //   462	467	604	java/lang/Exception
    //   134	141	620	java/lang/Exception
    //   476	481	620	java/lang/Exception
    //   158	198	636	java/lang/Exception
    //   403	409	653	java/io/FileNotFoundException
    //   417	442	653	java/io/FileNotFoundException
    //   95	101	658	java/lang/Exception
    //   105	130	658	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.NativeBridge
 * JD-Core Version:    0.7.0.1
 */
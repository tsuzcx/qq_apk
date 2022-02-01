package com.tencent.mobileqq.shortvideo.util;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.File;

public class ShortVideoTrimmer
{
  public static final long CODE_RATE = 1688L;
  public static final int CONFIG_LONG_EDGE_DEFAULT = 640;
  public static final int ORIENTATION_DOWN = 2;
  public static final int ORIENTATION_LEFT = 1;
  public static final int ORIENTATION_RIGHT = 3;
  public static final int ORIENTATION_UP = 0;
  public static final String TAG = "ShortVideoTrimmer";
  public static final String VIDEO_COMPRESS_BIN_NAME = "QQVideoTrimProcess";
  public static final String VIDEO_TRIM_PIC = "trim_process_pic";
  public static final String VIDEO_TRIM_PIE = "trim_process_pie";
  public static int sCpuCores;
  
  private static void PrintLog(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoTrimmer", 2, paramString);
    }
  }
  
  public static int compressVideo(Context paramContext, String paramString1, String paramString2, VideoConverterConfig paramVideoConverterConfig)
  {
    String str1 = ShortVideoSoLoad.getShortVideoSoPath(paramContext);
    String str2 = VideoEnvironment.getShortVideoSoLibName();
    VideoConverter localVideoConverter = new VideoConverter(new VideoConverterLog());
    localVideoConverter.setFFmpegBinAndSoPath(str1 + "QQVideoTrimProcess", str1 + str2);
    localVideoConverter.setCompressMode(2);
    return localVideoConverter.startCompress(paramContext, paramString1, new ShortVideoTrimmer.1(paramVideoConverterConfig, paramString1, paramString2), true);
  }
  
  public static VideoConverterConfig getCompressConfig(String paramString)
  {
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.lvcc.name(), "640|640|384|768|30");
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject == null) || (localObject.length <= 1)) {}
    }
    int j;
    File localFile;
    for (;;)
    {
      try
      {
        i = Integer.valueOf(localObject[1]).intValue();
        j = i;
        if (i <= 0) {
          j = 640;
        }
        localObject = new VideoConverterConfig();
        localFile = new File(paramString);
        if (!localFile.exists())
        {
          ((VideoConverterConfig)localObject).isNeedCompress = false;
          PrintLog("getCompressConfig, file not exists");
        }
        paramString = getVideoProperty(paramString);
        if ((paramString != null) && (paramString.length == 5) && (paramString[0] == 0)) {
          break;
        }
        ((VideoConverterConfig)localObject).isNeedCompress = false;
        PrintLog("getCompressConfig, values=" + paramString);
        if (paramString != null) {
          PrintLog("getCompressConfig, values.length=" + paramString.length + " err=" + paramString[0]);
        }
        return localObject;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoTrimmer", 2, "getCompressConfig, get DpcConfig Error", localNumberFormatException);
        }
      }
      i = 0;
    }
    localNumberFormatException.rotate = getVideoRotate(paramString[3]);
    localNumberFormatException.srcWidth = paramString[1];
    localNumberFormatException.srcHeight = paramString[2];
    int i = (int)(paramString[4] / 1000.0D + 0.5D);
    if (i == 0)
    {
      localNumberFormatException.isNeedCompress = false;
      PrintLog("getCompressConfig, [sec == 0 OR video duration < 0.5 sec]");
      return localNumberFormatException;
    }
    localNumberFormatException.srcBitrate = (localFile.length() / (i * 128));
    i = Math.max(paramString[1], paramString[2]);
    if (i <= j + 60)
    {
      if (localNumberFormatException.srcBitrate > 1688L)
      {
        localNumberFormatException.isNeedCompress = true;
        localNumberFormatException.destQmax = 25;
        localNumberFormatException.destWidth = paramString[1];
        localNumberFormatException.destHeight = paramString[2];
        return localNumberFormatException;
      }
      localNumberFormatException.isNeedCompress = false;
      PrintLog("getCompressConfig, [kbps > CODE_RATE] judge Failure...");
      return localNumberFormatException;
    }
    localNumberFormatException.isNeedCompress = true;
    float f = j / i;
    localNumberFormatException.destWidth = ((int)(paramString[1] * f));
    localNumberFormatException.destHeight = ((int)(f * paramString[2]));
    localNumberFormatException.destQmax = 25;
    return localNumberFormatException;
  }
  
  public static int getCpuCores()
  {
    if (sCpuCores == 0) {}
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new ShortVideoTrimmer.1CpuFilter());
      if (arrayOfFile == null) {
        return 1;
      }
      sCpuCores = arrayOfFile.length;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        sCpuCores = 1;
      }
    }
    return sCpuCores;
  }
  
  public static native String getRealProperties(String paramString);
  
  /* Error */
  @android.annotation.TargetApi(17)
  public static int[] getVideoProperty(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: getstatic 255	android/os/Build$VERSION:SDK_INT	I
    //   5: bipush 17
    //   7: if_icmplt +118 -> 125
    //   10: new 257	android/media/MediaMetadataRetriever
    //   13: dup
    //   14: invokespecial 258	android/media/MediaMetadataRetriever:<init>	()V
    //   17: astore_3
    //   18: aload_3
    //   19: aload_0
    //   20: invokevirtual 261	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   23: aload_3
    //   24: bipush 18
    //   26: invokevirtual 264	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   29: astore_2
    //   30: aload_3
    //   31: bipush 19
    //   33: invokevirtual 264	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   36: astore 4
    //   38: aload_3
    //   39: bipush 24
    //   41: invokevirtual 264	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   44: astore 5
    //   46: aload_3
    //   47: bipush 9
    //   49: invokevirtual 264	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   52: astore 6
    //   54: iconst_5
    //   55: newarray int
    //   57: astore_0
    //   58: aload_0
    //   59: iconst_0
    //   60: iconst_0
    //   61: iastore
    //   62: aload_0
    //   63: iconst_1
    //   64: aload_2
    //   65: invokestatic 268	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   68: iastore
    //   69: aload_0
    //   70: iconst_2
    //   71: aload 4
    //   73: invokestatic 268	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   76: iastore
    //   77: aload_0
    //   78: iconst_3
    //   79: aload 5
    //   81: invokestatic 268	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   84: iastore
    //   85: aload_0
    //   86: iconst_4
    //   87: aload 6
    //   89: invokestatic 268	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   92: iastore
    //   93: aload_3
    //   94: invokevirtual 271	android/media/MediaMetadataRetriever:release	()V
    //   97: aload_0
    //   98: areturn
    //   99: astore_2
    //   100: aconst_null
    //   101: astore_0
    //   102: ldc 23
    //   104: iconst_1
    //   105: ldc_w 273
    //   108: aload_2
    //   109: invokestatic 187	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   112: aload_3
    //   113: invokevirtual 271	android/media/MediaMetadataRetriever:release	()V
    //   116: aload_0
    //   117: areturn
    //   118: astore_0
    //   119: aload_3
    //   120: invokevirtual 271	android/media/MediaMetadataRetriever:release	()V
    //   123: aload_0
    //   124: athrow
    //   125: aload_0
    //   126: invokestatic 275	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:getRealProperties	(Ljava/lang/String;)Ljava/lang/String;
    //   129: astore_0
    //   130: aload_0
    //   131: ifnull +72 -> 203
    //   134: aload_0
    //   135: ldc_w 277
    //   138: invokevirtual 138	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   141: astore_3
    //   142: aload_3
    //   143: arraylength
    //   144: ifle +59 -> 203
    //   147: aload_3
    //   148: arraylength
    //   149: newarray int
    //   151: astore_2
    //   152: aload_2
    //   153: astore_0
    //   154: iload_1
    //   155: aload_3
    //   156: arraylength
    //   157: if_icmpge -60 -> 97
    //   160: aload_2
    //   161: iload_1
    //   162: aload_3
    //   163: iload_1
    //   164: aaload
    //   165: invokestatic 268	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   168: iastore
    //   169: iload_1
    //   170: iconst_1
    //   171: iadd
    //   172: istore_1
    //   173: goto -21 -> 152
    //   176: astore_0
    //   177: aload_0
    //   178: invokevirtual 280	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   181: ldc_w 282
    //   184: invokestatic 165	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   187: aconst_null
    //   188: astore_0
    //   189: goto -59 -> 130
    //   192: astore_0
    //   193: aload_0
    //   194: invokevirtual 283	java/lang/Exception:printStackTrace	()V
    //   197: ldc_w 285
    //   200: invokestatic 165	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   203: aconst_null
    //   204: areturn
    //   205: astore_2
    //   206: goto -104 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramString	String
    //   1	172	1	i	int
    //   29	36	2	str1	String
    //   99	10	2	localException1	Exception
    //   151	10	2	arrayOfInt	int[]
    //   205	1	2	localException2	Exception
    //   17	146	3	localObject	Object
    //   36	36	4	str2	String
    //   44	36	5	str3	String
    //   52	36	6	str4	String
    // Exception table:
    //   from	to	target	type
    //   18	58	99	java/lang/Exception
    //   18	58	118	finally
    //   62	93	118	finally
    //   102	112	118	finally
    //   125	130	176	java/lang/UnsatisfiedLinkError
    //   154	169	192	java/lang/Exception
    //   62	93	205	java/lang/Exception
  }
  
  public static String getVideoRotate(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "0";
    case 0: 
      return "0";
    case 1: 
      return "90";
    case 2: 
      return "180";
    }
    return "270";
  }
  
  /* Error */
  private static boolean initTrimProcessFile(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 58	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   4: astore_3
    //   5: new 152	java/io/File
    //   8: dup
    //   9: aload_3
    //   10: invokespecial 154	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: aload_0
    //   15: invokevirtual 157	java/io/File:exists	()Z
    //   18: ifne +8 -> 26
    //   21: aload_0
    //   22: invokevirtual 301	java/io/File:mkdirs	()Z
    //   25: pop
    //   26: getstatic 255	android/os/Build$VERSION:SDK_INT	I
    //   29: bipush 16
    //   31: if_icmplt +72 -> 103
    //   34: new 74	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   41: aload_3
    //   42: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc 32
    //   47: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: astore_0
    //   54: new 74	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   61: aload_3
    //   62: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc 26
    //   67: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: astore 4
    //   75: new 152	java/io/File
    //   78: dup
    //   79: aload 4
    //   81: invokespecial 154	java/io/File:<init>	(Ljava/lang/String;)V
    //   84: invokevirtual 157	java/io/File:exists	()Z
    //   87: ifeq +39 -> 126
    //   90: aload_0
    //   91: aload 4
    //   93: invokestatic 305	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:trimBinMd5Judge	(Ljava/lang/String;Ljava/lang/String;)Z
    //   96: ifeq +30 -> 126
    //   99: iconst_1
    //   100: istore_2
    //   101: iload_2
    //   102: ireturn
    //   103: new 74	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   110: aload_3
    //   111: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 29
    //   116: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: astore_0
    //   123: goto -69 -> 54
    //   126: new 307	java/io/FileInputStream
    //   129: dup
    //   130: aload_0
    //   131: invokespecial 308	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   134: astore_3
    //   135: aload_3
    //   136: astore_0
    //   137: ldc_w 310
    //   140: invokestatic 165	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   143: aload_3
    //   144: astore_0
    //   145: aload_3
    //   146: sipush 8192
    //   149: newarray byte
    //   151: aload 4
    //   153: invokestatic 314	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:readInputStreamToFile	(Ljava/io/InputStream;[BLjava/lang/String;)Z
    //   156: istore_2
    //   157: aload_3
    //   158: astore_0
    //   159: new 74	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   166: ldc_w 316
    //   169: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: iload_2
    //   173: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   176: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 165	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   182: iload_2
    //   183: istore_1
    //   184: iload_2
    //   185: ifeq +45 -> 230
    //   188: aload_3
    //   189: astore_0
    //   190: new 152	java/io/File
    //   193: dup
    //   194: aload 4
    //   196: invokespecial 154	java/io/File:<init>	(Ljava/lang/String;)V
    //   199: iconst_1
    //   200: iconst_1
    //   201: invokevirtual 323	java/io/File:setExecutable	(ZZ)Z
    //   204: istore_1
    //   205: aload_3
    //   206: astore_0
    //   207: new 74	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   214: ldc_w 325
    //   217: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: iload_1
    //   221: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   224: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 165	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   230: iload_1
    //   231: istore_2
    //   232: aload_3
    //   233: ifnull -132 -> 101
    //   236: aload_3
    //   237: invokevirtual 330	java/io/InputStream:close	()V
    //   240: iload_1
    //   241: ireturn
    //   242: astore_0
    //   243: aload_0
    //   244: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   247: iload_1
    //   248: ireturn
    //   249: astore 4
    //   251: aconst_null
    //   252: astore_3
    //   253: aload_3
    //   254: astore_0
    //   255: aload 4
    //   257: invokevirtual 283	java/lang/Exception:printStackTrace	()V
    //   260: aload_3
    //   261: astore_0
    //   262: new 74	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   269: ldc_w 333
    //   272: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload 4
    //   277: invokevirtual 334	java/lang/Exception:toString	()Ljava/lang/String;
    //   280: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 165	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   289: aload_3
    //   290: ifnull +7 -> 297
    //   293: aload_3
    //   294: invokevirtual 330	java/io/InputStream:close	()V
    //   297: iconst_0
    //   298: ireturn
    //   299: astore_0
    //   300: aload_0
    //   301: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   304: goto -7 -> 297
    //   307: astore_3
    //   308: aconst_null
    //   309: astore_0
    //   310: aload_0
    //   311: ifnull +7 -> 318
    //   314: aload_0
    //   315: invokevirtual 330	java/io/InputStream:close	()V
    //   318: aload_3
    //   319: athrow
    //   320: astore_0
    //   321: aload_0
    //   322: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   325: goto -7 -> 318
    //   328: astore_3
    //   329: goto -19 -> 310
    //   332: astore 4
    //   334: goto -81 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	paramContext	Context
    //   183	65	1	bool1	boolean
    //   100	132	2	bool2	boolean
    //   4	290	3	localObject1	Object
    //   307	12	3	localObject2	Object
    //   328	1	3	localObject3	Object
    //   73	122	4	str	String
    //   249	27	4	localException1	Exception
    //   332	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   236	240	242	java/io/IOException
    //   126	135	249	java/lang/Exception
    //   293	297	299	java/io/IOException
    //   126	135	307	finally
    //   314	318	320	java/io/IOException
    //   137	143	328	finally
    //   145	157	328	finally
    //   159	182	328	finally
    //   190	205	328	finally
    //   207	230	328	finally
    //   255	260	328	finally
    //   262	289	328	finally
    //   137	143	332	java/lang/Exception
    //   145	157	332	java/lang/Exception
    //   159	182	332	java/lang/Exception
    //   190	205	332	java/lang/Exception
    //   207	230	332	java/lang/Exception
  }
  
  public static boolean initVideoTrim(Context paramContext)
  {
    boolean bool2 = initTrimProcessFile(paramContext);
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (VideoEnvironment.loadAVCodecSo() != 0) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  /* Error */
  private static boolean readInputStreamToFile(java.io.InputStream paramInputStream, byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: new 342	java/io/FileOutputStream
    //   6: dup
    //   7: aload_2
    //   8: invokespecial 343	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   11: astore 7
    //   13: iconst_0
    //   14: istore_3
    //   15: aload 7
    //   17: astore_2
    //   18: aload_0
    //   19: aload_1
    //   20: iload_3
    //   21: aload_1
    //   22: arraylength
    //   23: iload_3
    //   24: isub
    //   25: invokevirtual 347	java/io/InputStream:read	([BII)I
    //   28: istore 4
    //   30: iload 4
    //   32: iconst_m1
    //   33: if_icmpeq +39 -> 72
    //   36: iload_3
    //   37: iload 4
    //   39: iadd
    //   40: istore 4
    //   42: iload 4
    //   44: istore_3
    //   45: aload 7
    //   47: astore_2
    //   48: iload 4
    //   50: aload_1
    //   51: arraylength
    //   52: if_icmpne -37 -> 15
    //   55: aload 7
    //   57: astore_2
    //   58: aload 7
    //   60: aload_1
    //   61: iconst_0
    //   62: iload 4
    //   64: invokevirtual 351	java/io/FileOutputStream:write	([BII)V
    //   67: iconst_0
    //   68: istore_3
    //   69: goto -54 -> 15
    //   72: iload_3
    //   73: ifeq +14 -> 87
    //   76: aload 7
    //   78: astore_2
    //   79: aload 7
    //   81: aload_1
    //   82: iconst_0
    //   83: iload_3
    //   84: invokevirtual 351	java/io/FileOutputStream:write	([BII)V
    //   87: iconst_1
    //   88: istore 6
    //   90: iload 6
    //   92: istore 5
    //   94: aload 7
    //   96: ifnull +12 -> 108
    //   99: aload 7
    //   101: invokevirtual 352	java/io/FileOutputStream:close	()V
    //   104: iload 6
    //   106: istore 5
    //   108: iload 5
    //   110: ireturn
    //   111: astore_1
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_0
    //   115: astore_2
    //   116: aload_1
    //   117: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   120: aload_0
    //   121: ifnull -13 -> 108
    //   124: aload_0
    //   125: invokevirtual 352	java/io/FileOutputStream:close	()V
    //   128: iconst_0
    //   129: ireturn
    //   130: astore_0
    //   131: iconst_0
    //   132: ireturn
    //   133: astore_0
    //   134: aconst_null
    //   135: astore_2
    //   136: aload_2
    //   137: ifnull +7 -> 144
    //   140: aload_2
    //   141: invokevirtual 352	java/io/FileOutputStream:close	()V
    //   144: aload_0
    //   145: athrow
    //   146: astore_0
    //   147: iconst_1
    //   148: ireturn
    //   149: astore_1
    //   150: goto -6 -> 144
    //   153: astore_0
    //   154: goto -18 -> 136
    //   157: astore_1
    //   158: aload 7
    //   160: astore_0
    //   161: goto -47 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramInputStream	java.io.InputStream
    //   0	164	1	paramArrayOfByte	byte[]
    //   0	164	2	paramString	String
    //   14	70	3	i	int
    //   28	35	4	j	int
    //   1	108	5	bool1	boolean
    //   88	17	6	bool2	boolean
    //   11	148	7	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   3	13	111	java/io/IOException
    //   124	128	130	java/io/IOException
    //   3	13	133	finally
    //   99	104	146	java/io/IOException
    //   140	144	149	java/io/IOException
    //   18	30	153	finally
    //   48	55	153	finally
    //   58	67	153	finally
    //   79	87	153	finally
    //   116	120	153	finally
    //   18	30	157	java/io/IOException
    //   48	55	157	java/io/IOException
    //   58	67	157	java/io/IOException
    //   79	87	157	java/io/IOException
  }
  
  private static boolean trimBinMd5Judge(String paramString1, String paramString2)
  {
    if (!new File(paramString1).exists()) {}
    do
    {
      return true;
      paramString1 = MD5.getFileMd5(paramString1);
      paramString2 = MD5.getFileMd5(paramString2);
      paramString1 = HexUtil.bytes2HexStr(paramString1);
      paramString2 = HexUtil.bytes2HexStr(paramString2);
      PrintLog("trimBinMd5Judge, pieMd5=" + paramString1 + "  outMd5=" + paramString2);
    } while ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString1.equals(paramString2)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer
 * JD-Core Version:    0.7.0.1
 */
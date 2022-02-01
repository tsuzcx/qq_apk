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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append("QQVideoTrimProcess");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append(str2);
    localVideoConverter.setFFmpegBinAndSoPath((String)localObject, localStringBuilder.toString());
    localVideoConverter.setCompressMode(2);
    return localVideoConverter.startCompress(paramContext, paramString1, new ShortVideoTrimmer.1(paramVideoConverterConfig, paramString1, paramString2), true);
  }
  
  public static VideoConverterConfig getCompressConfig(String paramString)
  {
    Object localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.lvcc.name(), "640|640|384|768|30");
    if ((localObject1 != null) && (((String)localObject1).length() > 0))
    {
      localObject1 = ((String)localObject1).split("\\|");
      if ((localObject1 != null) && (localObject1.length > 1)) {
        try
        {
          i = Integer.valueOf(localObject1[1]).intValue();
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ShortVideoTrimmer", 2, "getCompressConfig, get DpcConfig Error", localNumberFormatException);
          }
        }
      }
    }
    int i = 0;
    int j = i;
    if (i <= 0) {
      j = 640;
    }
    VideoConverterConfig localVideoConverterConfig = new VideoConverterConfig();
    Object localObject2 = new File(paramString);
    if (!((File)localObject2).exists())
    {
      localVideoConverterConfig.isNeedCompress = false;
      PrintLog("getCompressConfig, file not exists");
    }
    paramString = getVideoProperty(paramString);
    if ((paramString != null) && (paramString.length == 5) && (paramString[0] == 0))
    {
      localVideoConverterConfig.rotate = getVideoRotate(paramString[3]);
      localVideoConverterConfig.srcWidth = paramString[1];
      localVideoConverterConfig.srcHeight = paramString[2];
      double d = paramString[4];
      Double.isNaN(d);
      i = (int)(d / 1000.0D + 0.5D);
      if (i == 0)
      {
        localVideoConverterConfig.isNeedCompress = false;
        PrintLog("getCompressConfig, [sec == 0 OR video duration < 0.5 sec]");
        return localVideoConverterConfig;
      }
      localVideoConverterConfig.srcBitrate = (((File)localObject2).length() / (i * 128));
      i = Math.max(paramString[1], paramString[2]);
      if (i <= j + 60)
      {
        if (localVideoConverterConfig.srcBitrate > 1688L)
        {
          localVideoConverterConfig.isNeedCompress = true;
          localVideoConverterConfig.destQmax = 25;
          localVideoConverterConfig.destWidth = paramString[1];
          localVideoConverterConfig.destHeight = paramString[2];
          return localVideoConverterConfig;
        }
        localVideoConverterConfig.isNeedCompress = false;
        PrintLog("getCompressConfig, [kbps > CODE_RATE] judge Failure...");
        return localVideoConverterConfig;
      }
      localVideoConverterConfig.isNeedCompress = true;
      float f = j / i;
      localVideoConverterConfig.destWidth = ((int)(paramString[1] * f));
      localVideoConverterConfig.destHeight = ((int)(paramString[2] * f));
      localVideoConverterConfig.destQmax = 25;
      return localVideoConverterConfig;
    }
    localVideoConverterConfig.isNeedCompress = false;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getCompressConfig, values=");
    ((StringBuilder)localObject2).append(paramString);
    PrintLog(((StringBuilder)localObject2).toString());
    if (paramString != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getCompressConfig, values.length=");
      ((StringBuilder)localObject2).append(paramString.length);
      ((StringBuilder)localObject2).append(" err=");
      ((StringBuilder)localObject2).append(paramString[0]);
      PrintLog(((StringBuilder)localObject2).toString());
    }
    return localVideoConverterConfig;
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
      label40:
      break label40;
    }
    sCpuCores = 1;
    return sCpuCores;
  }
  
  public static native String getRealProperties(String paramString);
  
  /* Error */
  @android.annotation.TargetApi(17)
  public static int[] getVideoProperty(String paramString)
  {
    // Byte code:
    //   0: getstatic 261	android/os/Build$VERSION:SDK_INT	I
    //   3: istore_2
    //   4: iconst_0
    //   5: istore_1
    //   6: aconst_null
    //   7: astore 4
    //   9: iload_2
    //   10: bipush 17
    //   12: if_icmplt +154 -> 166
    //   15: new 263	android/media/MediaMetadataRetriever
    //   18: dup
    //   19: invokespecial 264	android/media/MediaMetadataRetriever:<init>	()V
    //   22: astore 5
    //   24: aload 4
    //   26: astore_3
    //   27: aload 5
    //   29: aload_0
    //   30: invokevirtual 267	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   33: aload 4
    //   35: astore_3
    //   36: aload 5
    //   38: bipush 18
    //   40: invokevirtual 270	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   43: astore 6
    //   45: aload 4
    //   47: astore_3
    //   48: aload 5
    //   50: bipush 19
    //   52: invokevirtual 270	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   55: astore 7
    //   57: aload 4
    //   59: astore_3
    //   60: aload 5
    //   62: bipush 24
    //   64: invokevirtual 270	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   67: astore 8
    //   69: aload 4
    //   71: astore_3
    //   72: aload 5
    //   74: bipush 9
    //   76: invokevirtual 270	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   79: astore 9
    //   81: aload 4
    //   83: astore_3
    //   84: iconst_5
    //   85: newarray int
    //   87: astore_0
    //   88: aload_0
    //   89: iconst_0
    //   90: iconst_0
    //   91: iastore
    //   92: aload_0
    //   93: astore_3
    //   94: aload_0
    //   95: iconst_1
    //   96: aload 6
    //   98: invokestatic 274	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   101: iastore
    //   102: aload_0
    //   103: astore_3
    //   104: aload_0
    //   105: iconst_2
    //   106: aload 7
    //   108: invokestatic 274	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   111: iastore
    //   112: aload_0
    //   113: astore_3
    //   114: aload_0
    //   115: iconst_3
    //   116: aload 8
    //   118: invokestatic 274	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   121: iastore
    //   122: aload_0
    //   123: astore_3
    //   124: aload_0
    //   125: iconst_4
    //   126: aload 9
    //   128: invokestatic 274	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   131: iastore
    //   132: goto +20 -> 152
    //   135: astore_0
    //   136: goto +23 -> 159
    //   139: astore_0
    //   140: ldc 23
    //   142: iconst_1
    //   143: ldc_w 276
    //   146: aload_0
    //   147: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   150: aload_3
    //   151: astore_0
    //   152: aload 5
    //   154: invokevirtual 279	android/media/MediaMetadataRetriever:release	()V
    //   157: aload_0
    //   158: areturn
    //   159: aload 5
    //   161: invokevirtual 279	android/media/MediaMetadataRetriever:release	()V
    //   164: aload_0
    //   165: athrow
    //   166: aload_0
    //   167: invokestatic 281	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:getRealProperties	(Ljava/lang/String;)Ljava/lang/String;
    //   170: astore_0
    //   171: goto +16 -> 187
    //   174: astore_0
    //   175: aload_0
    //   176: invokevirtual 284	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   179: ldc_w 286
    //   182: invokestatic 171	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   185: aconst_null
    //   186: astore_0
    //   187: aload_0
    //   188: ifnull +56 -> 244
    //   191: aload_0
    //   192: ldc_w 288
    //   195: invokevirtual 138	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   198: astore_0
    //   199: aload_0
    //   200: arraylength
    //   201: ifle +43 -> 244
    //   204: aload_0
    //   205: arraylength
    //   206: newarray int
    //   208: astore_3
    //   209: iload_1
    //   210: aload_0
    //   211: arraylength
    //   212: if_icmpge +19 -> 231
    //   215: aload_3
    //   216: iload_1
    //   217: aload_0
    //   218: iload_1
    //   219: aaload
    //   220: invokestatic 274	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   223: iastore
    //   224: iload_1
    //   225: iconst_1
    //   226: iadd
    //   227: istore_1
    //   228: goto -19 -> 209
    //   231: aload_3
    //   232: areturn
    //   233: astore_0
    //   234: aload_0
    //   235: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   238: ldc_w 291
    //   241: invokestatic 171	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   244: aconst_null
    //   245: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramString	String
    //   5	223	1	i	int
    //   3	10	2	j	int
    //   26	206	3	localObject1	Object
    //   7	75	4	localObject2	Object
    //   22	138	5	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   43	54	6	str1	String
    //   55	52	7	str2	String
    //   67	50	8	str3	String
    //   79	48	9	str4	String
    // Exception table:
    //   from	to	target	type
    //   27	33	135	finally
    //   36	45	135	finally
    //   48	57	135	finally
    //   60	69	135	finally
    //   72	81	135	finally
    //   84	88	135	finally
    //   94	102	135	finally
    //   104	112	135	finally
    //   114	122	135	finally
    //   124	132	135	finally
    //   140	150	135	finally
    //   27	33	139	java/lang/Exception
    //   36	45	139	java/lang/Exception
    //   48	57	139	java/lang/Exception
    //   60	69	139	java/lang/Exception
    //   72	81	139	java/lang/Exception
    //   84	88	139	java/lang/Exception
    //   94	102	139	java/lang/Exception
    //   104	112	139	java/lang/Exception
    //   114	122	139	java/lang/Exception
    //   124	132	139	java/lang/Exception
    //   166	171	174	java/lang/UnsatisfiedLinkError
    //   209	224	233	java/lang/Exception
  }
  
  public static String getVideoRotate(int paramInt)
  {
    String str = "0";
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return "0";
          }
          return "270";
        }
        return "180";
      }
      str = "90";
    }
    return str;
  }
  
  /* Error */
  private static boolean initTrimProcessFile(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 58	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   4: astore_0
    //   5: new 158	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 160	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 163	java/io/File:exists	()Z
    //   18: ifne +8 -> 26
    //   21: aload_3
    //   22: invokevirtual 307	java/io/File:mkdirs	()Z
    //   25: pop
    //   26: getstatic 261	android/os/Build$VERSION:SDK_INT	I
    //   29: bipush 16
    //   31: if_icmplt +32 -> 63
    //   34: new 74	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   41: astore_3
    //   42: aload_3
    //   43: aload_0
    //   44: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_3
    //   49: ldc 32
    //   51: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_3
    //   56: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore_3
    //   60: goto +29 -> 89
    //   63: new 74	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   70: astore_3
    //   71: aload_3
    //   72: aload_0
    //   73: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_3
    //   78: ldc 29
    //   80: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_3
    //   85: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore_3
    //   89: new 74	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   96: astore 4
    //   98: aload 4
    //   100: aload_0
    //   101: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 4
    //   107: ldc 26
    //   109: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 4
    //   115: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: astore 4
    //   120: new 158	java/io/File
    //   123: dup
    //   124: aload 4
    //   126: invokespecial 160	java/io/File:<init>	(Ljava/lang/String;)V
    //   129: invokevirtual 163	java/io/File:exists	()Z
    //   132: ifeq +14 -> 146
    //   135: aload_3
    //   136: aload 4
    //   138: invokestatic 311	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:trimBinMd5Judge	(Ljava/lang/String;Ljava/lang/String;)Z
    //   141: ifeq +5 -> 146
    //   144: iconst_1
    //   145: ireturn
    //   146: aconst_null
    //   147: astore 5
    //   149: aconst_null
    //   150: astore_0
    //   151: new 313	java/io/FileInputStream
    //   154: dup
    //   155: aload_3
    //   156: invokespecial 314	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   159: astore_3
    //   160: ldc_w 316
    //   163: invokestatic 171	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   166: aload_3
    //   167: sipush 8192
    //   170: newarray byte
    //   172: aload 4
    //   174: invokestatic 320	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:readInputStreamToFile	(Ljava/io/InputStream;[BLjava/lang/String;)Z
    //   177: istore_2
    //   178: new 74	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   185: astore_0
    //   186: aload_0
    //   187: ldc_w 322
    //   190: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload_0
    //   195: iload_2
    //   196: invokevirtual 325	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_0
    //   201: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 171	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   207: iload_2
    //   208: istore_1
    //   209: iload_2
    //   210: ifeq +47 -> 257
    //   213: new 158	java/io/File
    //   216: dup
    //   217: aload 4
    //   219: invokespecial 160	java/io/File:<init>	(Ljava/lang/String;)V
    //   222: iconst_1
    //   223: iconst_1
    //   224: invokevirtual 329	java/io/File:setExecutable	(ZZ)Z
    //   227: istore_1
    //   228: new 74	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   235: astore_0
    //   236: aload_0
    //   237: ldc_w 331
    //   240: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload_0
    //   245: iload_1
    //   246: invokevirtual 325	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_0
    //   251: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 171	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   257: aload_3
    //   258: invokevirtual 336	java/io/InputStream:close	()V
    //   261: iload_1
    //   262: ireturn
    //   263: astore_0
    //   264: aload_0
    //   265: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   268: iload_1
    //   269: ireturn
    //   270: astore_0
    //   271: goto +93 -> 364
    //   274: astore 4
    //   276: goto +18 -> 294
    //   279: astore 4
    //   281: aload_0
    //   282: astore_3
    //   283: aload 4
    //   285: astore_0
    //   286: goto +78 -> 364
    //   289: astore 4
    //   291: aload 5
    //   293: astore_3
    //   294: aload_3
    //   295: astore_0
    //   296: aload 4
    //   298: invokevirtual 289	java/lang/Exception:printStackTrace	()V
    //   301: aload_3
    //   302: astore_0
    //   303: new 74	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   310: astore 5
    //   312: aload_3
    //   313: astore_0
    //   314: aload 5
    //   316: ldc_w 339
    //   319: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload_3
    //   324: astore_0
    //   325: aload 5
    //   327: aload 4
    //   329: invokevirtual 340	java/lang/Exception:toString	()Ljava/lang/String;
    //   332: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload_3
    //   337: astore_0
    //   338: aload 5
    //   340: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 171	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:PrintLog	(Ljava/lang/String;)V
    //   346: aload_3
    //   347: ifnull +15 -> 362
    //   350: aload_3
    //   351: invokevirtual 336	java/io/InputStream:close	()V
    //   354: goto +8 -> 362
    //   357: astore_0
    //   358: aload_0
    //   359: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   362: iconst_0
    //   363: ireturn
    //   364: aload_3
    //   365: ifnull +15 -> 380
    //   368: aload_3
    //   369: invokevirtual 336	java/io/InputStream:close	()V
    //   372: goto +8 -> 380
    //   375: astore_3
    //   376: aload_3
    //   377: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   380: aload_0
    //   381: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	382	0	paramContext	Context
    //   208	61	1	bool1	boolean
    //   177	33	2	bool2	boolean
    //   13	356	3	localObject1	Object
    //   375	2	3	localIOException	java.io.IOException
    //   96	122	4	localObject2	Object
    //   274	1	4	localException1	Exception
    //   279	5	4	localObject3	Object
    //   289	39	4	localException2	Exception
    //   147	192	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   257	261	263	java/io/IOException
    //   160	207	270	finally
    //   213	257	270	finally
    //   160	207	274	java/lang/Exception
    //   213	257	274	java/lang/Exception
    //   151	160	279	finally
    //   296	301	279	finally
    //   303	312	279	finally
    //   314	323	279	finally
    //   325	336	279	finally
    //   338	346	279	finally
    //   151	160	289	java/lang/Exception
    //   350	354	357	java/io/IOException
    //   368	372	375	java/io/IOException
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
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 348	java/io/FileOutputStream
    //   9: dup
    //   10: aload_2
    //   11: invokespecial 349	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_2
    //   15: iconst_0
    //   16: istore_3
    //   17: aload_0
    //   18: aload_1
    //   19: iload_3
    //   20: aload_1
    //   21: arraylength
    //   22: iload_3
    //   23: isub
    //   24: invokevirtual 353	java/io/InputStream:read	([BII)I
    //   27: istore 4
    //   29: iload 4
    //   31: iconst_m1
    //   32: if_icmpeq +30 -> 62
    //   35: iload_3
    //   36: iload 4
    //   38: iadd
    //   39: istore 4
    //   41: iload 4
    //   43: istore_3
    //   44: iload 4
    //   46: aload_1
    //   47: arraylength
    //   48: if_icmpne -31 -> 17
    //   51: aload_2
    //   52: aload_1
    //   53: iconst_0
    //   54: iload 4
    //   56: invokevirtual 357	java/io/FileOutputStream:write	([BII)V
    //   59: goto -44 -> 15
    //   62: iload_3
    //   63: ifeq +10 -> 73
    //   66: aload_2
    //   67: aload_1
    //   68: iconst_0
    //   69: iload_3
    //   70: invokevirtual 357	java/io/FileOutputStream:write	([BII)V
    //   73: aload_2
    //   74: invokevirtual 358	java/io/FileOutputStream:close	()V
    //   77: iconst_1
    //   78: ireturn
    //   79: astore_0
    //   80: goto +37 -> 117
    //   83: astore_1
    //   84: aload_2
    //   85: astore_0
    //   86: goto +14 -> 100
    //   89: astore_0
    //   90: aload 5
    //   92: astore_2
    //   93: goto +24 -> 117
    //   96: astore_1
    //   97: aload 6
    //   99: astore_0
    //   100: aload_0
    //   101: astore 5
    //   103: aload_1
    //   104: invokevirtual 337	java/io/IOException:printStackTrace	()V
    //   107: aload_0
    //   108: ifnull +7 -> 115
    //   111: aload_0
    //   112: invokevirtual 358	java/io/FileOutputStream:close	()V
    //   115: iconst_0
    //   116: ireturn
    //   117: aload_2
    //   118: ifnull +7 -> 125
    //   121: aload_2
    //   122: invokevirtual 358	java/io/FileOutputStream:close	()V
    //   125: goto +5 -> 130
    //   128: aload_0
    //   129: athrow
    //   130: goto -2 -> 128
    //   133: astore_0
    //   134: iconst_1
    //   135: ireturn
    //   136: astore_0
    //   137: iconst_0
    //   138: ireturn
    //   139: astore_1
    //   140: goto -15 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramInputStream	java.io.InputStream
    //   0	143	1	paramArrayOfByte	byte[]
    //   0	143	2	paramString	String
    //   16	54	3	i	int
    //   27	28	4	j	int
    //   4	98	5	localInputStream	java.io.InputStream
    //   1	97	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	29	79	finally
    //   44	59	79	finally
    //   66	73	79	finally
    //   17	29	83	java/io/IOException
    //   44	59	83	java/io/IOException
    //   66	73	83	java/io/IOException
    //   6	15	89	finally
    //   103	107	89	finally
    //   6	15	96	java/io/IOException
    //   73	77	133	java/io/IOException
    //   111	115	136	java/io/IOException
    //   121	125	139	java/io/IOException
  }
  
  private static boolean trimBinMd5Judge(String paramString1, String paramString2)
  {
    if (!new File(paramString1).exists()) {
      return true;
    }
    paramString1 = MD5.getFileMd5(paramString1);
    paramString2 = MD5.getFileMd5(paramString2);
    paramString1 = HexUtil.bytes2HexStr(paramString1);
    paramString2 = HexUtil.bytes2HexStr(paramString2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("trimBinMd5Judge, pieMd5=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("  outMd5=");
    localStringBuilder.append(paramString2);
    PrintLog(localStringBuilder.toString());
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString1.equals(paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer
 * JD-Core Version:    0.7.0.1
 */
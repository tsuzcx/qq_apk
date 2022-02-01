package com.tencent.mobileqq.videocodec.ffmpeg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class FFmpegUtils
{
  public static void changeOrientationInVideo(Context paramContext, String paramString1, String paramString2, String paramString3, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 12;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.1(paramString1, paramString2, paramString3);
    localFFmpegCommandUnit.callback = paramFFmpegExecuteResponseCallback;
    localArrayList.add(localFFmpegCommandUnit);
    paramContext = FFmpeg.getInstance(paramContext);
    if (paramContext.isFFmpegCommandRunning())
    {
      paramContext.insertFFmpegQueue(localArrayList);
      return;
    }
    paramContext.cmdFFmpegQueue(localArrayList);
  }
  
  private static void clipAudio(PublishVideoEntry paramPublishVideoEntry, ExecuteBinResponseCallback paramExecuteBinResponseCallback, String paramString1, int paramInt1, int paramInt2, String paramString2, ArrayList<FFmpegCommandUnit> paramArrayList)
  {
    if (FileUtils.b(paramString2)) {
      FileUtils.f(paramString2);
    }
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 3;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.12(paramString1, paramString2, paramInt1, paramInt2);
    localFFmpegCommandUnit.callback = new FFmpegUtils.13(paramExecuteBinResponseCallback, paramPublishVideoEntry);
    paramArrayList.add(localFFmpegCommandUnit);
  }
  
  public static void combinBackgroundMusic(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    combinBackgroundMusic(paramContext, paramString1, paramString2, paramInt1, paramInt2, paramString3, true, paramExecuteBinResponseCallback);
  }
  
  public static void combinBackgroundMusic(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    combineBackgroundMusicInner(false, paramContext, paramString1, paramString2, "copy", paramInt1, paramInt2, paramString3, paramBoolean, paramExecuteBinResponseCallback);
  }
  
  public static void combinBackgroundMusicWithVideCodecH264(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    combineBackgroundMusicInner(false, paramContext, paramString1, paramString2, "h264", paramInt1, paramInt2, paramString3, false, paramExecuteBinResponseCallback);
  }
  
  private static void combineBackgroundMusicInner(boolean paramBoolean1, Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, boolean paramBoolean2, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = getAuidoType(paramString2);
    Object localObject2 = new File(QQStoryConstant.g);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append(QQStoryConstant.g);
    ((StringBuffer)localObject2).append(paramString2.hashCode());
    ((StringBuffer)localObject2).append("_");
    ((StringBuffer)localObject2).append(paramInt1);
    ((StringBuffer)localObject2).append("_");
    ((StringBuffer)localObject2).append(paramInt2);
    ((StringBuffer)localObject2).append((String)localObject1);
    localObject2 = new String((StringBuffer)localObject2);
    localObject1 = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 3;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.6(paramString2, (String)localObject2, paramInt1, paramInt2);
    localFFmpegCommandUnit.callback = new FFmpegUtils.7(paramExecuteBinResponseCallback);
    ((ArrayList)localObject1).add(localFFmpegCommandUnit);
    paramString2 = new FFmpegCommandUnit();
    paramString2.cmdType = 4;
    paramString2.arguments = new FFmpegUtils.8(paramString1, (String)localObject2, paramString3, paramString4, paramBoolean2, paramInt2);
    paramString2.callback = new FFmpegUtils.9(paramExecuteBinResponseCallback, (String)localObject2, l);
    ((ArrayList)localObject1).add(paramString2);
    if (paramBoolean1) {
      paramContext = FFmpeg.newInstance(paramContext, true);
    } else {
      paramContext = FFmpeg.getInstance(paramContext, true);
    }
    if (paramContext.isFFmpegCommandRunning())
    {
      paramContext.insertFFmpegQueue((ArrayList)localObject1);
      return;
    }
    paramContext.cmdFFmpegQueue((ArrayList)localObject1);
  }
  
  public static void combineDoodle(Context paramContext, String paramString1, String paramString2, String paramString3, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 15;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.10(paramString1, paramString2, paramString3);
    localFFmpegCommandUnit.callback = new FFmpegUtils.11(paramExecuteBinResponseCallback);
    paramString1 = new ArrayList();
    paramString1.add(localFFmpegCommandUnit);
    paramContext = FFmpeg.getInstance(paramContext, true);
    if (paramContext.isFFmpegCommandRunning())
    {
      paramContext.insertFFmpegQueue(paramString1);
      return;
    }
    paramContext.cmdFFmpegQueue(paramString1);
  }
  
  public static Bitmap combineTwoImg(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if ((paramBitmap1 == null) && (paramBitmap2 == null))
    {
      QLog.e("FFmpegCmd", 2, "FFmpegUtils combineTwoImg error");
      return null;
    }
    if (paramBitmap1 == null) {
      return paramBitmap2;
    }
    if (paramBitmap2 == null) {
      return paramBitmap1;
    }
    int i = paramBitmap1.getWidth();
    int j = paramBitmap1.getHeight();
    int k = paramBitmap2.getWidth();
    int m = paramBitmap2.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap1, 0.0F, 0.0F, null);
    if ((i == k) && (j == m))
    {
      localCanvas.drawBitmap(paramBitmap2, 0.0F, 0.0F, null);
    }
    else
    {
      float f1 = i / k;
      float f2 = j / m;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f1, f2);
      localCanvas.drawBitmap(paramBitmap2, localMatrix, null);
    }
    localCanvas.save();
    paramBitmap1.recycle();
    paramBitmap2.recycle();
    return localBitmap;
  }
  
  /* Error */
  public static boolean combineTwoImg(Bitmap paramBitmap1, Bitmap paramBitmap2, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +244 -> 245
    //   4: aload_1
    //   5: ifnull +240 -> 245
    //   8: aload_2
    //   9: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +6 -> 18
    //   15: goto +230 -> 245
    //   18: aload_0
    //   19: invokevirtual 189	android/graphics/Bitmap:getWidth	()I
    //   22: istore 5
    //   24: aload_0
    //   25: invokevirtual 192	android/graphics/Bitmap:getHeight	()I
    //   28: istore 6
    //   30: aload_1
    //   31: invokevirtual 189	android/graphics/Bitmap:getWidth	()I
    //   34: istore 7
    //   36: aload_1
    //   37: invokevirtual 192	android/graphics/Bitmap:getHeight	()I
    //   40: istore 8
    //   42: iload 5
    //   44: iload 6
    //   46: getstatic 198	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   49: invokestatic 202	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   52: astore 9
    //   54: new 204	android/graphics/Canvas
    //   57: dup
    //   58: aload 9
    //   60: invokespecial 207	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   63: astore 10
    //   65: aload 10
    //   67: aload_0
    //   68: fconst_0
    //   69: fconst_0
    //   70: aconst_null
    //   71: invokevirtual 211	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   74: iload 5
    //   76: iload 7
    //   78: if_icmpne +25 -> 103
    //   81: iload 6
    //   83: iload 8
    //   85: if_icmpeq +6 -> 91
    //   88: goto +15 -> 103
    //   91: aload 10
    //   93: aload_1
    //   94: fconst_0
    //   95: fconst_0
    //   96: aconst_null
    //   97: invokevirtual 211	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   100: goto +47 -> 147
    //   103: iload 5
    //   105: i2f
    //   106: iload 7
    //   108: i2f
    //   109: fdiv
    //   110: fstore_3
    //   111: iload 6
    //   113: i2f
    //   114: iload 8
    //   116: i2f
    //   117: fdiv
    //   118: fstore 4
    //   120: new 213	android/graphics/Matrix
    //   123: dup
    //   124: invokespecial 214	android/graphics/Matrix:<init>	()V
    //   127: astore 11
    //   129: aload 11
    //   131: fload_3
    //   132: fload 4
    //   134: invokevirtual 218	android/graphics/Matrix:postScale	(FF)Z
    //   137: pop
    //   138: aload 10
    //   140: aload_1
    //   141: aload 11
    //   143: aconst_null
    //   144: invokevirtual 221	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
    //   147: aload 10
    //   149: invokevirtual 224	android/graphics/Canvas:save	()I
    //   152: pop
    //   153: aload 9
    //   155: new 104	java/io/File
    //   158: dup
    //   159: aload_2
    //   160: invokespecial 113	java/io/File:<init>	(Ljava/lang/String;)V
    //   163: invokestatic 242	com/tencent/mobileqq/utils/BaseImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   166: aload_0
    //   167: invokevirtual 227	android/graphics/Bitmap:recycle	()V
    //   170: aload_1
    //   171: invokevirtual 227	android/graphics/Bitmap:recycle	()V
    //   174: iconst_1
    //   175: ireturn
    //   176: astore_2
    //   177: goto +58 -> 235
    //   180: astore_2
    //   181: invokestatic 245	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq +41 -> 225
    //   187: new 247	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   194: astore 9
    //   196: aload 9
    //   198: ldc 250
    //   200: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 9
    //   206: aload_2
    //   207: invokevirtual 257	java/io/IOException:getMessage	()Ljava/lang/String;
    //   210: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: ldc 176
    //   216: iconst_2
    //   217: aload 9
    //   219: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 184	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: aload_0
    //   226: invokevirtual 227	android/graphics/Bitmap:recycle	()V
    //   229: aload_1
    //   230: invokevirtual 227	android/graphics/Bitmap:recycle	()V
    //   233: iconst_0
    //   234: ireturn
    //   235: aload_0
    //   236: invokevirtual 227	android/graphics/Bitmap:recycle	()V
    //   239: aload_1
    //   240: invokevirtual 227	android/graphics/Bitmap:recycle	()V
    //   243: aload_2
    //   244: athrow
    //   245: ldc 176
    //   247: iconst_2
    //   248: ldc 178
    //   250: invokestatic 184	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: iconst_0
    //   254: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	paramBitmap1	Bitmap
    //   0	255	1	paramBitmap2	Bitmap
    //   0	255	2	paramString	String
    //   110	22	3	f1	float
    //   118	15	4	f2	float
    //   22	82	5	i	int
    //   28	84	6	j	int
    //   34	73	7	k	int
    //   40	75	8	m	int
    //   52	166	9	localObject	Object
    //   63	85	10	localCanvas	Canvas
    //   127	15	11	localMatrix	Matrix
    // Exception table:
    //   from	to	target	type
    //   153	166	176	finally
    //   181	225	176	finally
    //   153	166	180	java/io/IOException
  }
  
  public static boolean combineTwoImg(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return false;
      }
      paramString2 = SafeBitmapFactory.decodeFile(paramString2);
      paramString1 = SafeBitmapFactory.decodeFile(paramString1);
      if (paramString2 != null)
      {
        if (paramString1 == null) {
          return false;
        }
        return combineTwoImg(paramString1, paramString2, paramString3);
      }
    }
    return false;
  }
  
  private static void combineVideoAndAudio(String paramString1, PublishVideoEntry paramPublishVideoEntry, boolean paramBoolean, ExecuteBinResponseCallback paramExecuteBinResponseCallback, int paramInt, long paramLong, String paramString2, ArrayList<FFmpegCommandUnit> paramArrayList, String paramString3, String paramString4, String paramString5)
  {
    if (FileUtils.b(paramString1)) {
      FileUtils.f(paramString1);
    }
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 4;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.14(paramString5, paramString4, paramString1, paramBoolean, paramInt);
    localFFmpegCommandUnit.callback = new FFmpegUtils.15(paramExecuteBinResponseCallback, paramPublishVideoEntry, paramString2, paramString4, paramString5, paramString3, paramLong);
    paramArrayList.add(localFFmpegCommandUnit);
  }
  
  public static void compressLocalVideo(Context paramContext, String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 11;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.3(paramString1, paramInt1, paramInt2, paramInt3, paramBoolean, paramString2);
    localFFmpegCommandUnit.callback = paramFFmpegExecuteResponseCallback;
    localArrayList.add(localFFmpegCommandUnit);
    paramContext = FFmpeg.getInstance(paramContext);
    if (paramContext.isFFmpegCommandRunning())
    {
      paramContext.insertFFmpegQueue(localArrayList);
      return;
    }
    paramContext.cmdFFmpegQueue(localArrayList);
  }
  
  public static void compressVideoWithBitrate(String paramString1, String paramString2, int paramInt, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-b:v");
    paramString1 = new StringBuilder();
    paramString1.append("");
    paramString1.append(paramInt);
    localArrayList.add(paramString1.toString());
    localArrayList.add("-profile:v");
    localArrayList.add("baseline");
    localArrayList.add("-bufsize");
    localArrayList.add("800k");
    localArrayList.add("-r");
    localArrayList.add("25");
    localArrayList.add("-c:a");
    localArrayList.add("copy");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    FFmpeg.getInstance(MobileQQ.getContext()).execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public static void convertPicToVideo(Context paramContext, String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 9;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.4(paramString1, paramString2);
    localFFmpegCommandUnit.callback = paramFFmpegExecuteResponseCallback;
    localArrayList.add(localFFmpegCommandUnit);
    paramContext = FFmpeg.getInstance(paramContext);
    if (paramContext.isFFmpegCommandRunning())
    {
      paramContext.insertFFmpegQueue(localArrayList);
      return;
    }
    paramContext.cmdFFmpegQueue(localArrayList);
  }
  
  public static void convertPicToVideoWidthDuration(Context paramContext, String paramString1, String paramString2, String paramString3, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 20;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.5(paramString1, paramString2, paramString3);
    localFFmpegCommandUnit.callback = paramFFmpegExecuteResponseCallback;
    localArrayList.add(localFFmpegCommandUnit);
    paramContext = FFmpeg.getInstance(paramContext);
    if (paramContext.isFFmpegCommandRunning())
    {
      paramContext.insertFFmpegQueue(localArrayList);
      return;
    }
    paramContext.cmdFFmpegQueue(localArrayList);
  }
  
  public static void convertVideoToMp3(boolean paramBoolean, Context paramContext, String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 16;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.25(paramString1, paramString2);
    localFFmpegCommandUnit.callback = paramFFmpegExecuteResponseCallback;
    localArrayList.add(localFFmpegCommandUnit);
    if (paramBoolean) {
      paramContext = FFmpeg.newInstance(paramContext, false);
    } else {
      paramContext = FFmpeg.getInstance(paramContext);
    }
    if (paramContext.isFFmpegCommandRunning())
    {
      paramContext.insertFFmpegQueue(localArrayList);
      return;
    }
    paramContext.cmdFFmpegQueue(localArrayList);
  }
  
  public static void detectMediaVolume(Context paramContext, String paramString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 22;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.24(paramString);
    localFFmpegCommandUnit.callback = paramFFmpegExecuteResponseCallback;
    localArrayList.add(localFFmpegCommandUnit);
    paramContext = FFmpeg.getInstance(paramContext);
    if (paramContext.isFFmpegCommandRunning())
    {
      paramContext.insertFFmpegQueue(localArrayList);
      return;
    }
    paramContext.cmdFFmpegQueue(localArrayList);
  }
  
  public static void generateGifFromVideoWithPalette(String paramString1, String paramString2, String paramString3, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-ss");
    localArrayList.add("0");
    localArrayList.add("-t");
    localArrayList.add("4");
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-i");
    localArrayList.add(paramString2);
    localArrayList.add("-lavfi");
    localArrayList.add("fps=18,scale=280:-1:flags=lanczos,paletteuse=dither=floyd_steinberg");
    localArrayList.add("-y");
    localArrayList.add(paramString3);
    FFmpeg.getInstance(MobileQQ.getContext()).execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public static void generatePalettePNG(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-ss");
    localArrayList.add("0");
    localArrayList.add("-t");
    localArrayList.add("1");
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-vf");
    localArrayList.add("fps=18,scale=280:-1:flags=lanczos,palettegen=stats_mode=diff");
    localArrayList.add("-y");
    localArrayList.add(paramString2);
    FFmpeg.getInstance(MobileQQ.getContext()).execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  private static void getAudioFromMp4(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, ExecuteBinResponseCallback paramExecuteBinResponseCallback, ArrayList<FFmpegCommandUnit> paramArrayList)
  {
    if (FileUtils.b(paramString2)) {
      FileUtils.f(paramString2);
    }
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 18;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.18(paramString1, paramString2);
    localFFmpegCommandUnit.callback = new FFmpegUtils.19(paramExecuteBinResponseCallback, paramPublishVideoEntry);
    paramArrayList.add(localFFmpegCommandUnit);
  }
  
  public static String getAuidoType(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = paramString;
    if (paramString.startsWith("http"))
    {
      str = paramString;
      if (paramString.contains("?")) {
        str = paramString.substring(0, paramString.indexOf("?"));
      }
    }
    int i = str.lastIndexOf(".");
    if ((i > -1) && (i < str.length() - 1)) {
      return str.substring(i);
    }
    return "";
  }
  
  public static String getSavePublishVidFileName(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQStoryMoment");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    if (paramString2 == null) {
      paramString2 = ".mp4";
    }
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  private static void getVideoFromMp4(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, ExecuteBinResponseCallback paramExecuteBinResponseCallback, ArrayList<FFmpegCommandUnit> paramArrayList)
  {
    if (FileUtils.b(paramString1)) {
      FileUtils.f(paramString1);
    }
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 19;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.16(paramString2, paramString1);
    localFFmpegCommandUnit.callback = new FFmpegUtils.17(paramExecuteBinResponseCallback, paramPublishVideoEntry);
    paramArrayList.add(localFFmpegCommandUnit);
  }
  
  public static boolean isProcessCompleted(Process paramProcess)
  {
    return Util.isProcessCompleted(paramProcess);
  }
  
  public static void killRunningProcesses()
  {
    FFmpeg.getInstance(MobileQQ.getContext()).killRunningProcessesForShortVideo(false);
  }
  
  private static void mixMusicAndOriginal(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, ExecuteBinResponseCallback paramExecuteBinResponseCallback, ArrayList<FFmpegCommandUnit> paramArrayList)
  {
    if (FileUtils.b(paramString3)) {
      FileUtils.f(paramString3);
    }
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 17;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.22(paramString1, paramString2, paramString3, paramFloat1, paramFloat2);
    localFFmpegCommandUnit.callback = new FFmpegUtils.23(paramExecuteBinResponseCallback, paramPublishVideoEntry);
    paramArrayList.add(localFFmpegCommandUnit);
  }
  
  public static void mixOriginalAndBackgroundMusic(Context paramContext, String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry, boolean paramBoolean, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    String str = paramPublishVideoEntry.backgroundMusicPath;
    int j = paramPublishVideoEntry.backgroundMusicOffset;
    int k = paramPublishVideoEntry.backgroundMusicDuration;
    float f1 = Float.valueOf(paramPublishVideoEntry.getStringExtra("originalRecordVolume", String.valueOf(0.7F))).floatValue();
    float f2 = Float.valueOf(paramPublishVideoEntry.getStringExtra("backgroundVolume", String.valueOf(1.0F))).floatValue();
    long l = System.currentTimeMillis();
    Object localObject1 = getAuidoType(str);
    int i;
    if ((!((String)localObject1).equals(".mp4")) && (!((String)localObject1).equals(".m4a"))) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject2 = new File(QQStoryConstant.g);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append(QQStoryConstant.g);
    ((StringBuffer)localObject2).append(str.hashCode());
    ((StringBuffer)localObject2).append("_");
    ((StringBuffer)localObject2).append(j);
    ((StringBuffer)localObject2).append("_");
    ((StringBuffer)localObject2).append(k);
    ((StringBuffer)localObject2).append(".m4a");
    localObject2 = new String((StringBuffer)localObject2);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramPublishVideoEntry.videoUploadTempDir);
    ((StringBuilder)localObject3).append("clipNoneMp4Temp");
    ((StringBuilder)localObject3).append((String)localObject1);
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new ArrayList();
    if (i != 0) {
      localObject1 = localObject2;
    } else {
      localObject1 = localObject3;
    }
    clipAudio(paramPublishVideoEntry, paramExecuteBinResponseCallback, str, j, k, (String)localObject1, (ArrayList)localObject4);
    if (i == 0) {
      transcodeAudio(paramPublishVideoEntry, (String)localObject3, (String)localObject2, paramExecuteBinResponseCallback, (ArrayList)localObject4);
    }
    localObject3 = localObject4;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramPublishVideoEntry.videoUploadTempDir);
    ((StringBuilder)localObject1).append("mc_audio.mp4");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(paramPublishVideoEntry.videoUploadTempDir);
    ((StringBuilder)localObject4).append("local_video_audio.m4a");
    str = ((StringBuilder)localObject4).toString();
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(paramPublishVideoEntry.videoUploadTempDir);
    ((StringBuilder)localObject4).append("transcode_local_video_audio.m4a");
    localObject4 = ((StringBuilder)localObject4).toString();
    if (paramPublishVideoEntry.isLocalPublish)
    {
      getAudioFromMp4(paramPublishVideoEntry, paramString1, str, paramExecuteBinResponseCallback, (ArrayList)localObject3);
      transcodeAudio(paramPublishVideoEntry, str, (String)localObject4, paramExecuteBinResponseCallback, (ArrayList)localObject3);
    }
    Object localObject5 = new StringBuffer();
    ((StringBuffer)localObject5).append(QQStoryConstant.g);
    ((StringBuffer)localObject5).append(((String)localObject1).hashCode());
    ((StringBuffer)localObject5).append("_mix_with_music");
    ((StringBuffer)localObject5).append(".mp4");
    localObject5 = new String((StringBuffer)localObject5);
    Object localObject6 = new StringBuilder();
    ((StringBuilder)localObject6).append(QQStoryConstant.g);
    ((StringBuilder)localObject6).append(paramString1.hashCode());
    ((StringBuilder)localObject6).append("_none_audio_video.mp4");
    localObject6 = ((StringBuilder)localObject6).toString();
    if (paramPublishVideoEntry.isLocalPublish) {
      localObject1 = localObject4;
    }
    mixMusicAndOriginal(paramPublishVideoEntry, (String)localObject1, (String)localObject2, (String)localObject5, f1, f2, paramExecuteBinResponseCallback, (ArrayList)localObject3);
    getVideoFromMp4(paramPublishVideoEntry, (String)localObject6, paramString1, paramExecuteBinResponseCallback, (ArrayList)localObject3);
    combineVideoAndAudio(paramString2, paramPublishVideoEntry, paramBoolean, paramExecuteBinResponseCallback, k, l, (String)localObject2, (ArrayList)localObject3, str, (String)localObject5, (String)localObject6);
    paramContext = FFmpeg.getInstance(paramContext, true);
    if (paramContext.isFFmpegCommandRunning())
    {
      paramContext.insertFFmpegQueue((ArrayList)localObject3);
      return;
    }
    paramContext.cmdFFmpegQueue((ArrayList)localObject3);
  }
  
  public static void setTimestamp(Context paramContext, String paramString1, String paramString2, int paramInt, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 13;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.2(paramString1, paramString2, paramInt);
    localFFmpegCommandUnit.callback = paramFFmpegExecuteResponseCallback;
    localArrayList.add(localFFmpegCommandUnit);
    paramContext = FFmpeg.getInstance(paramContext);
    if (paramContext.isFFmpegCommandRunning())
    {
      paramContext.insertFFmpegQueue(localArrayList);
      return;
    }
    paramContext.cmdFFmpegQueue(localArrayList);
  }
  
  private static void transcodeAudio(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, ExecuteBinResponseCallback paramExecuteBinResponseCallback, ArrayList<FFmpegCommandUnit> paramArrayList)
  {
    if (FileUtils.b(paramString2)) {
      FileUtils.f(paramString2);
    }
    FFmpegCommandUnit localFFmpegCommandUnit = new FFmpegCommandUnit();
    localFFmpegCommandUnit.cmdType = 21;
    localFFmpegCommandUnit.arguments = new FFmpegUtils.20(paramString1, paramString2);
    localFFmpegCommandUnit.callback = new FFmpegUtils.21(paramExecuteBinResponseCallback, paramPublishVideoEntry);
    paramArrayList.add(localFFmpegCommandUnit);
  }
  
  public static void video2Gif(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-y");
    localArrayList.add(paramString2);
    FFmpeg.getInstance(MobileQQ.getContext()).execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils
 * JD-Core Version:    0.7.0.1
 */
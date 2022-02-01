package com.tencent.mobileqq.shortvideo.util;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(18)
public class HwVideoMerge
{
  public static final int ERR_AFVF_ERROR = -13;
  public static final int ERR_AUDIO_CREATE = -2;
  public static final int ERR_AUDIO_NONE_DATA = -6;
  public static final int ERR_AUDIO_NONE_TRACK = -4;
  public static final int ERR_INVALID_PARAM = -9;
  public static final int ERR_MUXER_NEW = -7;
  public static final int ERR_OUTPUT_FILE_EXIST = -8;
  public static final int ERR_PROCESS_NO_EXIST = -12;
  public static final int ERR_PROCESS_START_EXP = -11;
  public static final int ERR_RENAME_PATH = -10;
  public static final int ERR_VIDEO_CREATE = -1;
  public static final int ERR_VIDEO_MERGE_CANCEL = -14;
  public static final int ERR_VIDEO_MERGE_CANCEL_AUDIO_CODE = -21;
  public static final int ERR_VIDEO_MERGE_CANCEL_AUDIO_TRIM = -17;
  public static final int ERR_VIDEO_MERGE_CANCEL_AUDIO_VIDEO_MERGE = -18;
  public static final int ERR_VIDEO_MERGE_CANCEL_HUAWEI_GREEN = -22;
  public static final int ERR_VIDEO_MERGE_CANCEL_MERGE_END = -19;
  public static final int ERR_VIDEO_MERGE_CANCEL_RECODE = -16;
  public static final int ERR_VIDEO_MERGE_CANCEL_RESULT = -24;
  public static final int ERR_VIDEO_MERGE_CANCEL_RE_COMPRESS = -20;
  public static final int ERR_VIDEO_MERGE_CANCEL_SYN = -15;
  public static final int ERR_VIDEO_NONE_DATA = -5;
  public static final int ERR_VIDEO_NONE_TRACK = -3;
  private static final boolean MERGE_SYS = false;
  public static final int SUCCESS = 0;
  private static final String TAG = "HwVideoMerge";
  private static Process mMergeProcess;
  private static Process mRecodeProcess;
  private MediaExtractor mAudioExtractor;
  private String mAudioFilePath;
  private int mHeight;
  private MediaMuxer mMuxerEngine;
  private HwVideoMerge.SampaleData mSampler = new HwVideoMerge.SampaleData(null);
  private MediaExtractor mVideoExtractor;
  private String mVideoFilePath;
  private int mWidth;
  
  public HwVideoMerge(String paramString1, String paramString2)
  {
    this.mVideoFilePath = paramString1;
    this.mAudioFilePath = paramString2;
  }
  
  private static void PrintQLog(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.d("HwVideoMerge", 2, paramString, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.d("HwVideoMerge", 2, paramString);
  }
  
  private int checkNeedCreateMuxer()
  {
    int i = 0;
    this.mSampler.inputBuffer.position(0);
    if (this.mVideoExtractor.readSampleData(this.mSampler.inputBuffer, 0) <= 0)
    {
      releaseExtractor();
      i = -5;
    }
    do
    {
      return i;
      this.mSampler.inputBuffer.position(0);
    } while (this.mAudioExtractor.readSampleData(this.mSampler.inputBuffer, 0) > 0);
    releaseExtractor();
    return -6;
  }
  
  private boolean checkPath(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString));
  }
  
  private final MediaExtractor createExtractor(String paramString)
  {
    if (checkPath(paramString)) {
      localMediaExtractor = new MediaExtractor();
    }
    try
    {
      localMediaExtractor.setDataSource(paramString);
      int i = localMediaExtractor.getTrackCount();
      if (i != 1) {
        localMediaExtractor.release();
      }
      return localMediaExtractor;
    }
    catch (IOException localIOException1)
    {
      try
      {
        PrintQLog("createExtractor:invalid media file:numTracks=" + i + " path=" + paramString, null);
        return null;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localMediaExtractor = null;
        }
      }
      localIOException1 = localIOException1;
      PrintQLog("createExtractor path:" + paramString, localIOException1);
      localMediaExtractor.release();
      return null;
    }
  }
  
  public static boolean destroyRunningProcess()
  {
    boolean bool = false;
    PrintQLog("[@]  ffmpegProcess try destroy!", null);
    if ((mMergeProcess != null) && (!FFmpegUtils.isProcessCompleted(mMergeProcess)))
    {
      mMergeProcess.destroy();
      mMergeProcess = null;
      PrintQLog("[@]  ffmpegProcess, destroyMergeProcess!", null);
    }
    for (int i = 1;; i = 0)
    {
      if ((mRecodeProcess != null) && (!FFmpegUtils.isProcessCompleted(mRecodeProcess)))
      {
        mRecodeProcess.destroy();
        mRecodeProcess = null;
        PrintQLog("[@]  ffmpegProcess, destroyRecodeProcess!", null);
      }
      for (int j = 1;; j = 0)
      {
        if ((i != 0) || (j != 0)) {
          bool = true;
        }
        return bool;
      }
    }
  }
  
  /* Error */
  private static int ffmpegProcess(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 215	com/tencent/mobileqq/shortvideo/VideoEnvironment:getContext	()Landroid/content/Context;
    //   3: invokestatic 221	bddn:a	(Landroid/content/Context;)Ljava/lang/String;
    //   6: astore 6
    //   8: new 223	java/io/File
    //   11: dup
    //   12: aload 6
    //   14: invokespecial 225	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 5
    //   19: aload 5
    //   21: invokevirtual 228	java/io/File:exists	()Z
    //   24: ifeq +424 -> 448
    //   27: aload 5
    //   29: iconst_1
    //   30: iconst_1
    //   31: invokevirtual 232	java/io/File:setExecutable	(ZZ)Z
    //   34: istore 4
    //   36: new 165	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   43: ldc 234
    //   45: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload 4
    //   50: invokevirtual 237	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: ldc 239
    //   55: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload 5
    //   60: invokevirtual 243	java/io/File:length	()J
    //   63: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   66: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: aconst_null
    //   70: invokestatic 111	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:PrintQLog	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   73: aload_0
    //   74: iload_3
    //   75: invokestatic 250	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:getRotationDegree	(Ljava/lang/String;I)I
    //   78: pop
    //   79: new 252	java/util/ArrayList
    //   82: dup
    //   83: invokespecial 253	java/util/ArrayList:<init>	()V
    //   86: astore 5
    //   88: aload 5
    //   90: aload 6
    //   92: invokeinterface 258 2 0
    //   97: pop
    //   98: aload 5
    //   100: ldc_w 260
    //   103: invokeinterface 258 2 0
    //   108: pop
    //   109: aload 5
    //   111: ldc_w 262
    //   114: invokeinterface 258 2 0
    //   119: pop
    //   120: aload 5
    //   122: ldc_w 264
    //   125: invokeinterface 258 2 0
    //   130: pop
    //   131: aload 5
    //   133: ldc_w 266
    //   136: invokeinterface 258 2 0
    //   141: pop
    //   142: aload 5
    //   144: ldc_w 268
    //   147: invokeinterface 258 2 0
    //   152: pop
    //   153: aload 5
    //   155: aload_0
    //   156: invokeinterface 258 2 0
    //   161: pop
    //   162: aload 5
    //   164: ldc_w 268
    //   167: invokeinterface 258 2 0
    //   172: pop
    //   173: aload 5
    //   175: aload_1
    //   176: invokeinterface 258 2 0
    //   181: pop
    //   182: aload 5
    //   184: ldc_w 270
    //   187: invokeinterface 258 2 0
    //   192: pop
    //   193: aload 5
    //   195: ldc_w 272
    //   198: invokeinterface 258 2 0
    //   203: pop
    //   204: aload 5
    //   206: ldc_w 274
    //   209: invokeinterface 258 2 0
    //   214: pop
    //   215: aload 5
    //   217: ldc_w 272
    //   220: invokeinterface 258 2 0
    //   225: pop
    //   226: aload 5
    //   228: aload_2
    //   229: invokeinterface 258 2 0
    //   234: pop
    //   235: aload 5
    //   237: invokestatic 215	com/tencent/mobileqq/shortvideo/VideoEnvironment:getContext	()Landroid/content/Context;
    //   240: invokestatic 277	bddn:b	(Landroid/content/Context;)Ljava/lang/String;
    //   243: invokeinterface 258 2 0
    //   248: pop
    //   249: new 165	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   256: ldc_w 279
    //   259: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload 5
    //   264: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: aconst_null
    //   271: invokestatic 111	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:PrintQLog	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   274: new 284	com/tencent/mobileqq/shortvideo/util/HwVideoMerge$LogStream
    //   277: dup
    //   278: aconst_null
    //   279: invokespecial 285	com/tencent/mobileqq/shortvideo/util/HwVideoMerge$LogStream:<init>	(Lcom/tencent/mobileqq/shortvideo/util/HwVideoMerge$1;)V
    //   282: astore_0
    //   283: new 287	java/lang/ProcessBuilder
    //   286: dup
    //   287: iconst_0
    //   288: anewarray 142	java/lang/String
    //   291: invokespecial 290	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   294: astore_1
    //   295: aload_1
    //   296: iconst_1
    //   297: invokevirtual 294	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   300: pop
    //   301: aload_1
    //   302: aload 5
    //   304: invokevirtual 298	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   307: pop
    //   308: aload_1
    //   309: invokevirtual 302	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   312: astore_1
    //   313: aload_1
    //   314: putstatic 188	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:mMergeProcess	Ljava/lang/Process;
    //   317: aload_0
    //   318: aload_1
    //   319: putfield 305	com/tencent/mobileqq/shortvideo/util/HwVideoMerge$LogStream:mProcess	Ljava/lang/Process;
    //   322: aload_0
    //   323: invokevirtual 308	com/tencent/mobileqq/shortvideo/util/HwVideoMerge$LogStream:initStream	()V
    //   326: aload_1
    //   327: invokevirtual 311	java/lang/Process:waitFor	()I
    //   330: pop
    //   331: aload_1
    //   332: invokevirtual 314	java/lang/Process:exitValue	()I
    //   335: istore_3
    //   336: iload_3
    //   337: ifeq +51 -> 388
    //   340: new 223	java/io/File
    //   343: dup
    //   344: aload_2
    //   345: invokespecial 225	java/io/File:<init>	(Ljava/lang/String;)V
    //   348: astore 5
    //   350: aload 5
    //   352: invokevirtual 228	java/io/File:exists	()Z
    //   355: ifeq +9 -> 364
    //   358: aload 5
    //   360: invokevirtual 317	java/io/File:delete	()Z
    //   363: pop
    //   364: new 165	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   371: ldc_w 319
    //   374: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: iload_3
    //   378: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   381: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: aconst_null
    //   385: invokestatic 111	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:PrintQLog	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   388: new 223	java/io/File
    //   391: dup
    //   392: aload_2
    //   393: invokespecial 225	java/io/File:<init>	(Ljava/lang/String;)V
    //   396: astore_2
    //   397: new 165	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   404: ldc_w 321
    //   407: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: aload_2
    //   411: invokevirtual 228	java/io/File:exists	()Z
    //   414: invokevirtual 237	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   417: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: aconst_null
    //   421: invokestatic 111	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:PrintQLog	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   424: aload_0
    //   425: invokevirtual 324	com/tencent/mobileqq/shortvideo/util/HwVideoMerge$LogStream:printStream	()V
    //   428: aload_1
    //   429: ifnull +17 -> 446
    //   432: aload_1
    //   433: invokevirtual 199	java/lang/Process:destroy	()V
    //   436: getstatic 188	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:mMergeProcess	Ljava/lang/Process;
    //   439: ifnull +7 -> 446
    //   442: aconst_null
    //   443: putstatic 188	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:mMergeProcess	Ljava/lang/Process;
    //   446: iload_3
    //   447: ireturn
    //   448: bipush 244
    //   450: ireturn
    //   451: astore_0
    //   452: ldc_w 326
    //   455: aload_0
    //   456: invokestatic 111	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:PrintQLog	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   459: bipush 245
    //   461: ireturn
    //   462: astore 5
    //   464: ldc_w 326
    //   467: aload 5
    //   469: invokestatic 111	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:PrintQLog	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   472: goto -141 -> 331
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	475	0	paramString1	String
    //   0	475	1	paramString2	String
    //   0	475	2	paramString3	String
    //   0	475	3	paramInt	int
    //   34	15	4	bool	boolean
    //   17	342	5	localObject	Object
    //   462	6	5	localInterruptedException	java.lang.InterruptedException
    //   6	85	6	str	String
    // Exception table:
    //   from	to	target	type
    //   308	317	451	java/io/IOException
    //   326	331	462	java/lang/InterruptedException
  }
  
  /* Error */
  public static int ffmpegReCodec(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 215	com/tencent/mobileqq/shortvideo/VideoEnvironment:getContext	()Landroid/content/Context;
    //   3: invokestatic 221	bddn:a	(Landroid/content/Context;)Ljava/lang/String;
    //   6: astore 5
    //   8: new 223	java/io/File
    //   11: dup
    //   12: aload 5
    //   14: invokespecial 225	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 228	java/io/File:exists	()Z
    //   24: ifeq +336 -> 360
    //   27: aload 4
    //   29: iconst_1
    //   30: iconst_1
    //   31: invokevirtual 232	java/io/File:setExecutable	(ZZ)Z
    //   34: istore_3
    //   35: new 165	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   42: ldc 234
    //   44: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: iload_3
    //   48: invokevirtual 237	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: aconst_null
    //   55: invokestatic 111	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:PrintQLog	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   58: aload_0
    //   59: iload_2
    //   60: invokestatic 250	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:getRotationDegree	(Ljava/lang/String;I)I
    //   63: pop
    //   64: new 252	java/util/ArrayList
    //   67: dup
    //   68: invokespecial 253	java/util/ArrayList:<init>	()V
    //   71: astore 4
    //   73: aload 4
    //   75: aload 5
    //   77: invokeinterface 258 2 0
    //   82: pop
    //   83: aload 4
    //   85: ldc_w 260
    //   88: invokeinterface 258 2 0
    //   93: pop
    //   94: aload 4
    //   96: ldc_w 262
    //   99: invokeinterface 258 2 0
    //   104: pop
    //   105: aload 4
    //   107: ldc_w 264
    //   110: invokeinterface 258 2 0
    //   115: pop
    //   116: aload 4
    //   118: ldc_w 266
    //   121: invokeinterface 258 2 0
    //   126: pop
    //   127: aload 4
    //   129: ldc_w 268
    //   132: invokeinterface 258 2 0
    //   137: pop
    //   138: aload 4
    //   140: aload_0
    //   141: invokeinterface 258 2 0
    //   146: pop
    //   147: aload 4
    //   149: ldc_w 330
    //   152: invokeinterface 258 2 0
    //   157: pop
    //   158: aload 4
    //   160: ldc_w 332
    //   163: invokeinterface 258 2 0
    //   168: pop
    //   169: aload 4
    //   171: ldc_w 334
    //   174: invokeinterface 258 2 0
    //   179: pop
    //   180: aload 4
    //   182: ldc_w 336
    //   185: invokeinterface 258 2 0
    //   190: pop
    //   191: aload 4
    //   193: aload_1
    //   194: invokeinterface 258 2 0
    //   199: pop
    //   200: aload 4
    //   202: invokestatic 215	com/tencent/mobileqq/shortvideo/VideoEnvironment:getContext	()Landroid/content/Context;
    //   205: invokestatic 277	bddn:b	(Landroid/content/Context;)Ljava/lang/String;
    //   208: invokeinterface 258 2 0
    //   213: pop
    //   214: new 284	com/tencent/mobileqq/shortvideo/util/HwVideoMerge$LogStream
    //   217: dup
    //   218: aconst_null
    //   219: invokespecial 285	com/tencent/mobileqq/shortvideo/util/HwVideoMerge$LogStream:<init>	(Lcom/tencent/mobileqq/shortvideo/util/HwVideoMerge$1;)V
    //   222: astore_0
    //   223: new 287	java/lang/ProcessBuilder
    //   226: dup
    //   227: iconst_0
    //   228: anewarray 142	java/lang/String
    //   231: invokespecial 290	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   234: astore 5
    //   236: aload 5
    //   238: iconst_1
    //   239: invokevirtual 294	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   242: pop
    //   243: aload 5
    //   245: aload 4
    //   247: invokevirtual 298	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   250: pop
    //   251: aload 5
    //   253: invokevirtual 302	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   256: astore 4
    //   258: aload 4
    //   260: putstatic 203	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:mRecodeProcess	Ljava/lang/Process;
    //   263: aload_0
    //   264: aload 4
    //   266: putfield 305	com/tencent/mobileqq/shortvideo/util/HwVideoMerge$LogStream:mProcess	Ljava/lang/Process;
    //   269: aload_0
    //   270: invokevirtual 308	com/tencent/mobileqq/shortvideo/util/HwVideoMerge$LogStream:initStream	()V
    //   273: aload 4
    //   275: invokevirtual 311	java/lang/Process:waitFor	()I
    //   278: pop
    //   279: aload 4
    //   281: invokevirtual 314	java/lang/Process:exitValue	()I
    //   284: istore_2
    //   285: iload_2
    //   286: ifeq +48 -> 334
    //   289: new 223	java/io/File
    //   292: dup
    //   293: aload_1
    //   294: invokespecial 225	java/io/File:<init>	(Ljava/lang/String;)V
    //   297: astore_1
    //   298: aload_1
    //   299: invokevirtual 228	java/io/File:exists	()Z
    //   302: ifeq +8 -> 310
    //   305: aload_1
    //   306: invokevirtual 317	java/io/File:delete	()Z
    //   309: pop
    //   310: new 165	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   317: ldc_w 319
    //   320: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: iload_2
    //   324: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: aconst_null
    //   331: invokestatic 111	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:PrintQLog	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   334: aload_0
    //   335: invokevirtual 324	com/tencent/mobileqq/shortvideo/util/HwVideoMerge$LogStream:printStream	()V
    //   338: aload 4
    //   340: ifnull +18 -> 358
    //   343: aload 4
    //   345: invokevirtual 199	java/lang/Process:destroy	()V
    //   348: getstatic 203	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:mRecodeProcess	Ljava/lang/Process;
    //   351: ifnull +7 -> 358
    //   354: aconst_null
    //   355: putstatic 203	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:mRecodeProcess	Ljava/lang/Process;
    //   358: iload_2
    //   359: ireturn
    //   360: bipush 244
    //   362: ireturn
    //   363: astore_0
    //   364: ldc_w 326
    //   367: aload_0
    //   368: invokestatic 111	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:PrintQLog	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   371: bipush 245
    //   373: ireturn
    //   374: astore 5
    //   376: ldc_w 326
    //   379: aload 5
    //   381: invokestatic 111	com/tencent/mobileqq/shortvideo/util/HwVideoMerge:PrintQLog	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   384: goto -105 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	387	0	paramString1	String
    //   0	387	1	paramString2	String
    //   0	387	2	paramInt	int
    //   34	14	3	bool	boolean
    //   17	327	4	localObject1	Object
    //   6	246	5	localObject2	Object
    //   374	6	5	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   251	263	363	java/io/IOException
    //   273	279	374	java/lang/InterruptedException
  }
  
  private boolean getAudioInputBuffer()
  {
    this.mSampler.inputBuffer.position(0);
    if (this.mAudioExtractor == null) {}
    int i;
    do
    {
      return true;
      i = this.mAudioExtractor.readSampleData(this.mSampler.inputBuffer, 0);
    } while (i <= 0);
    this.mSampler.bufferInfo.presentationTimeUs = this.mAudioExtractor.getSampleTime();
    this.mSampler.bufferInfo.size = i;
    this.mSampler.bufferInfo.offset = 0;
    this.mSampler.bufferInfo.flags = this.mAudioExtractor.getSampleFlags();
    this.mAudioExtractor.advance();
    return false;
  }
  
  private static int getRotationDegree(String paramString, int paramInt)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = null;
      try
      {
        String str = localMediaMetadataRetriever.extractMetadata(24);
        paramString = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("HwVideoMerge", 2, localException, new Object[0]);
        }
      }
      localMediaMetadataRetriever.release();
      if (paramString == null) {
        return paramInt;
      }
      int i;
      return paramInt;
    }
    catch (IllegalArgumentException paramString)
    {
      try
      {
        i = Integer.parseInt(paramString);
        return i;
      }
      catch (NumberFormatException paramString) {}
      paramString = paramString;
      return paramInt;
    }
  }
  
  private boolean getVideoInputBuffer()
  {
    this.mSampler.inputBuffer.position(0);
    if (this.mVideoExtractor == null) {}
    int i;
    do
    {
      return true;
      i = this.mVideoExtractor.readSampleData(this.mSampler.inputBuffer, 0);
    } while (i <= 0);
    this.mSampler.bufferInfo.presentationTimeUs = this.mVideoExtractor.getSampleTime();
    this.mSampler.bufferInfo.size = i;
    this.mSampler.bufferInfo.offset = 0;
    this.mSampler.bufferInfo.flags = this.mVideoExtractor.getSampleFlags();
    this.mVideoExtractor.advance();
    return false;
  }
  
  public static final int merge(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    return mergeFFmpegMuxer(paramString1, paramString2, paramString3, paramInt);
  }
  
  public static final int mergeFFmpegMuxer(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    int j = new HwVideoMerge(paramString1, paramString2).initExtractor(null, paramInt);
    int i;
    if ((j == -2) || (j == -4) || (j == -6))
    {
      paramString1 = new File(paramString1);
      paramString2 = new File(paramString3);
      if (FileUtils.moveFile(paramString1.getAbsolutePath(), paramString2.getAbsolutePath())) {
        i = 0;
      }
    }
    do
    {
      return i;
      return -10;
      i = j;
    } while (j != -9);
    return ffmpegProcess(paramString1, paramString2, paramString3, paramInt);
  }
  
  public static final int mergeSysMuxer(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    paramString2 = new HwVideoMerge(paramString1, paramString2);
    int i = paramString2.initExtractor(paramString3, paramInt);
    if ((i == -2) || (i == -4) || (i == -6)) {
      if (new File(paramString1).renameTo(new File(paramString3))) {
        paramInt = 0;
      }
    }
    do
    {
      return paramInt;
      return -10;
      paramInt = i;
    } while (i != 0);
    paramString2.doWork();
    return i;
  }
  
  private void overlapCopyVideoFirst()
  {
    boolean bool2 = false;
    int i = 0;
    while ((!bool2) || (i == 0))
    {
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool2 = getVideoInputBuffer();
        bool1 = bool2;
        if (!bool2)
        {
          this.mMuxerEngine.writeSampleData(this.mSampler.videoTrack, this.mSampler.inputBuffer, this.mSampler.bufferInfo);
          bool1 = bool2;
        }
      }
      bool2 = bool1;
      if (i == 0)
      {
        boolean bool3 = getAudioInputBuffer();
        bool2 = bool1;
        i = bool3;
        if (!bool3)
        {
          this.mMuxerEngine.writeSampleData(this.mSampler.audioTrack, this.mSampler.inputBuffer, this.mSampler.bufferInfo);
          bool2 = bool1;
          i = bool3;
        }
      }
    }
  }
  
  private void releaseExtractor()
  {
    if (this.mVideoExtractor != null)
    {
      this.mVideoExtractor.release();
      this.mVideoExtractor = null;
    }
    if (this.mAudioExtractor != null)
    {
      this.mAudioExtractor.release();
      this.mAudioExtractor = null;
    }
  }
  
  public void doWork()
  {
    this.mMuxerEngine.start();
    overlapCopyVideoFirst();
    this.mMuxerEngine.stop();
    this.mMuxerEngine.release();
    this.mMuxerEngine = null;
    releaseExtractor();
  }
  
  public int initExtractor(String paramString, int paramInt)
  {
    this.mVideoExtractor = createExtractor(this.mVideoFilePath);
    int i;
    if (this.mVideoExtractor == null) {
      i = -1;
    }
    MediaFormat localMediaFormat;
    Object localObject;
    int j;
    do
    {
      return i;
      this.mAudioExtractor = createExtractor(this.mAudioFilePath);
      if (this.mAudioExtractor == null)
      {
        releaseExtractor();
        return -2;
      }
      localMediaFormat = this.mVideoExtractor.getTrackFormat(0);
      localObject = localMediaFormat.getString("mime");
      this.mWidth = localMediaFormat.getInteger("width");
      this.mHeight = localMediaFormat.getInteger("height");
      if (!((String)localObject).startsWith("video/")) {
        break;
      }
      this.mVideoExtractor.selectTrack(0);
      localObject = this.mAudioExtractor.getTrackFormat(0);
      if (!((MediaFormat)localObject).getString("mime").startsWith("audio/")) {
        break label198;
      }
      this.mAudioExtractor.selectTrack(0);
      this.mSampler.init(this.mWidth, this.mHeight);
      j = checkNeedCreateMuxer();
      i = j;
    } while (j != 0);
    if (!checkPath(paramString))
    {
      releaseExtractor();
      return -9;
      releaseExtractor();
      return -3;
      label198:
      releaseExtractor();
      return -4;
    }
    try
    {
      if (new File(paramString).exists())
      {
        releaseExtractor();
        return -8;
      }
      this.mMuxerEngine = new MediaMuxer(paramString, 0);
      paramInt = getRotationDegree(this.mVideoFilePath, paramInt);
      this.mMuxerEngine.setOrientationHint(paramInt);
      this.mSampler.videoTrack = this.mMuxerEngine.addTrack(localMediaFormat);
      this.mSampler.audioTrack = this.mMuxerEngine.addTrack((MediaFormat)localObject);
      return j;
    }
    catch (IOException paramString)
    {
      this.mMuxerEngine = null;
      releaseExtractor();
    }
    return -7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.HwVideoMerge
 * JD-Core Version:    0.7.0.1
 */
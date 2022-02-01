package com.tencent.mobileqq.editor.composite;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.api.IAEPath;
import com.tencent.aelight.camera.qqstory.api.IQimMusicPlayer;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dov.story.api.IAudioHelper;
import com.tencent.mobileqq.dov.story.api.IStoryConfigManager;
import com.tencent.mobileqq.dov.story.api.IStoryEntityManager;
import com.tencent.mobileqq.editor.composite.step.AudioDataUtil;
import com.tencent.mobileqq.editor.composite.step.HwVideoMerge;
import com.tencent.mobileqq.editor.composite.step.MergeEditVideo;
import com.tencent.mobileqq.editor.composite.step.MergeEditVideo.EditParam;
import com.tencent.mobileqq.editor.composite.step.PicToVideoConverter;
import com.tencent.mobileqq.editor.composite.step.VideoStoryPicToVideo;
import com.tencent.mobileqq.editor.composite.step.VideoStoryPicToVideo.RetCode;
import com.tencent.mobileqq.editor.composite.util.CompositeUtil;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.monitor.CaptureFreqMonitor;
import com.tencent.mobileqq.monitor.CaptureFreqMonitorItem;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder.AudioData;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;

@TargetApi(14)
public class VideoCompositeHelper
{
  public static String a = "VideoCompositeHelper";
  private boolean b;
  
  static
  {
    try
    {
      int i = VideoEnvironment.loadAVCodecSo();
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load AVCodec so, code = ");
      localStringBuilder.append(i);
      SLog.b(str, localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private int a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 18) {
      bool = false;
    } else {
      bool = ((Boolean)((IStoryConfigManager)QRoute.api(IStoryConfigManager.class)).getStoryValue("boolean_enable_hw_encode_pic_to_video", Boolean.valueOf(true))).booleanValue();
    }
    int i;
    if (bool)
    {
      int j = new PicToVideoConverter().a(paramPublishVideoEntry.mLocalRawVideoDir, paramString);
      i = j;
      if (j != 0)
      {
        i = j;
        if (j != 942014)
        {
          SLog.d(a, "convert picture to video by mediaCodec error. use ffmepg to convert again.");
          return a(paramPublishVideoEntry.mLocalRawVideoDir, paramString);
        }
      }
    }
    else
    {
      i = a(paramPublishVideoEntry.mLocalRawVideoDir, paramString);
    }
    return i;
  }
  
  private int a(PublishVideoEntry paramPublishVideoEntry, String paramString, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramPublishVideoEntry.videoUploadTempDir);
    ((StringBuilder)localObject1).append("hwtemp.mp4");
    localObject1 = ((StringBuilder)localObject1).toString();
    int i = b(paramPublishVideoEntry, paramString, paramBoolean);
    if (i != 0) {
      return i;
    }
    if (paramPublishVideoEntry.isCancel)
    {
      com.tencent.biz.qqstory.utils.FileUtils.k(paramString);
      return -19;
    }
    long l = System.currentTimeMillis();
    int j = -1;
    i = j;
    if (paramPublishVideoEntry.isLocalPublish)
    {
      i = j;
      if (paramPublishVideoEntry.businessId == 14)
      {
        i = j;
        if (paramPublishVideoEntry.getBooleanExtra("KEY_VIDEO_STORY_CAMERA_TYPE", false)) {
          i = 0;
        }
      }
    }
    i = a(paramString, (String)localObject1, i);
    if (CaptureFreqMonitor.d) {
      CaptureFreqMonitor.f.a(2, System.currentTimeMillis() - l);
    }
    Object localObject2;
    if (i == 0)
    {
      localObject2 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set moov in front of file success. targetMergedTempMp4 = ");
      localStringBuilder.append((String)localObject1);
      SLog.d((String)localObject2, localStringBuilder.toString());
      com.tencent.biz.qqstory.utils.FileUtils.b((String)localObject1, paramString);
    }
    else
    {
      SLog.d(a, "set moov in front of file fail %d", new Object[] { Integer.valueOf(i) });
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("set moov in front of file failed targetFile = ");
      ((StringBuilder)localObject2).append(paramString);
      SLog.b((String)localObject1, ((StringBuilder)localObject2).toString());
      i = 0;
    }
    j = i;
    if (((IAudioHelper)QRoute.api(IAudioHelper.class)).isHuaWeiGreen())
    {
      l = System.currentTimeMillis();
      if (!paramPublishVideoEntry.isCancel) {
        i = VideoCompositeUtil.a(paramString);
      }
      if (paramPublishVideoEntry.isCancel) {
        i = -22;
      }
      if (i == 0)
      {
        paramPublishVideoEntry = a;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isHuaweiGreen: reEncodeVideoWithFFMpeg succeed. output path = ");
        ((StringBuilder)localObject1).append(paramString);
        SLog.d(paramPublishVideoEntry, ((StringBuilder)localObject1).toString());
      }
      else
      {
        paramPublishVideoEntry = a;
        paramString = new StringBuilder();
        paramString.append("isHuaweiGreen: reEncodeVideoWithFFMpeg failed. errorCode = ");
        paramString.append(i);
        SLog.e(paramPublishVideoEntry, paramString.toString());
      }
      j = i;
      if (CaptureFreqMonitor.d)
      {
        CaptureFreqMonitor.f.a(3, System.currentTimeMillis() - l);
        j = i;
      }
    }
    return j;
  }
  
  /* Error */
  private int a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 25	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:a	Ljava/lang/String;
    //   3: ldc 195
    //   5: invokestatic 101	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_1
    //   9: invokestatic 197	com/tencent/biz/qqstory/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   12: ifne +6 -> 18
    //   15: ldc 198
    //   17: ireturn
    //   18: new 4	java/lang/Object
    //   21: dup
    //   22: invokespecial 53	java/lang/Object:<init>	()V
    //   25: astore 4
    //   27: new 200	java/util/concurrent/atomic/AtomicInteger
    //   30: dup
    //   31: ldc 201
    //   33: invokespecial 204	java/util/concurrent/atomic/AtomicInteger:<init>	(I)V
    //   36: astore 5
    //   38: invokestatic 210	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   41: aload_1
    //   42: aload_2
    //   43: new 212	com/tencent/mobileqq/editor/composite/VideoCompositeHelper$FFMPEGResponseCallback
    //   46: dup
    //   47: aload 4
    //   49: aload 5
    //   51: iconst_2
    //   52: invokespecial 215	com/tencent/mobileqq/editor/composite/VideoCompositeHelper$FFMPEGResponseCallback:<init>	(Ljava/lang/Object;Ljava/util/concurrent/atomic/AtomicInteger;I)V
    //   55: invokestatic 221	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegUtils:convertPicToVideo	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteResponseCallback;)V
    //   58: aload 4
    //   60: monitorenter
    //   61: aload 4
    //   63: ldc2_w 222
    //   66: invokevirtual 227	java/lang/Object:wait	(J)V
    //   69: aload 4
    //   71: monitorexit
    //   72: aload 5
    //   74: invokevirtual 230	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   77: istore_3
    //   78: iload_3
    //   79: ifne +5 -> 84
    //   82: iconst_0
    //   83: ireturn
    //   84: getstatic 25	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:a	Ljava/lang/String;
    //   87: ldc 232
    //   89: iconst_1
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: aload 5
    //   97: invokevirtual 230	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   100: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: aastore
    //   104: invokestatic 168	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: new 27	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   114: astore 6
    //   116: aload 6
    //   118: aload_1
    //   119: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 6
    //   125: ldc 234
    //   127: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 6
    //   133: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: astore 6
    //   138: aload_0
    //   139: aload_1
    //   140: aload 6
    //   142: invokespecial 236	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   145: istore_3
    //   146: iload_3
    //   147: ifeq +38 -> 185
    //   150: getstatic 25	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:a	Ljava/lang/String;
    //   153: astore_1
    //   154: new 27	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   161: astore_2
    //   162: aload_2
    //   163: ldc 238
    //   165: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_2
    //   170: iload_3
    //   171: invokevirtual 39	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_1
    //   176: aload_2
    //   177: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 187	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: iload_3
    //   184: ireturn
    //   185: aload 5
    //   187: ldc 201
    //   189: invokevirtual 241	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   192: invokestatic 210	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   195: aload 6
    //   197: aload_2
    //   198: new 212	com/tencent/mobileqq/editor/composite/VideoCompositeHelper$FFMPEGResponseCallback
    //   201: dup
    //   202: aload 4
    //   204: aload 5
    //   206: iconst_2
    //   207: invokespecial 215	com/tencent/mobileqq/editor/composite/VideoCompositeHelper$FFMPEGResponseCallback:<init>	(Ljava/lang/Object;Ljava/util/concurrent/atomic/AtomicInteger;I)V
    //   210: invokestatic 221	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegUtils:convertPicToVideo	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteResponseCallback;)V
    //   213: aload 4
    //   215: monitorenter
    //   216: aload 4
    //   218: ldc2_w 222
    //   221: invokevirtual 227	java/lang/Object:wait	(J)V
    //   224: aload 4
    //   226: monitorexit
    //   227: getstatic 25	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:a	Ljava/lang/String;
    //   230: ldc 243
    //   232: invokestatic 101	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: aload 5
    //   237: invokevirtual 230	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   240: istore_3
    //   241: iload_3
    //   242: ireturn
    //   243: astore_1
    //   244: aload 4
    //   246: monitorexit
    //   247: aload_1
    //   248: athrow
    //   249: astore_1
    //   250: getstatic 25	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:a	Ljava/lang/String;
    //   253: astore_2
    //   254: new 27	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   261: astore 4
    //   263: aload 4
    //   265: ldc 245
    //   267: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 4
    //   273: aload_1
    //   274: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload_2
    //   279: aload 4
    //   281: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 101	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: ldc 249
    //   289: ireturn
    //   290: astore_1
    //   291: getstatic 25	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:a	Ljava/lang/String;
    //   294: astore_2
    //   295: new 27	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   302: astore 4
    //   304: aload 4
    //   306: ldc 245
    //   308: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 4
    //   314: aload_1
    //   315: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload_2
    //   320: aload 4
    //   322: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 101	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   328: ldc 250
    //   330: ireturn
    //   331: astore_1
    //   332: getstatic 25	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:a	Ljava/lang/String;
    //   335: astore_2
    //   336: new 27	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   343: astore 4
    //   345: aload 4
    //   347: ldc 245
    //   349: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 4
    //   355: aload_1
    //   356: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload_2
    //   361: aload 4
    //   363: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokestatic 101	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: ldc 251
    //   371: ireturn
    //   372: astore_1
    //   373: aload 4
    //   375: monitorexit
    //   376: aload_1
    //   377: athrow
    //   378: astore_1
    //   379: getstatic 25	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:a	Ljava/lang/String;
    //   382: astore_2
    //   383: new 27	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   390: astore 4
    //   392: aload 4
    //   394: ldc 245
    //   396: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload 4
    //   402: aload_1
    //   403: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload_2
    //   408: aload 4
    //   410: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 101	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   416: ldc 249
    //   418: ireturn
    //   419: astore_1
    //   420: getstatic 25	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:a	Ljava/lang/String;
    //   423: astore_2
    //   424: new 27	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   431: astore 4
    //   433: aload 4
    //   435: ldc 245
    //   437: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload 4
    //   443: aload_1
    //   444: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload_2
    //   449: aload 4
    //   451: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokestatic 101	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   457: ldc 250
    //   459: ireturn
    //   460: astore_1
    //   461: getstatic 25	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:a	Ljava/lang/String;
    //   464: astore_2
    //   465: new 27	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   472: astore 4
    //   474: aload 4
    //   476: ldc 245
    //   478: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: aload 4
    //   484: aload_1
    //   485: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: aload_2
    //   490: aload 4
    //   492: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 101	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   498: ldc 251
    //   500: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	501	0	this	VideoCompositeHelper
    //   0	501	1	paramString1	String
    //   0	501	2	paramString2	String
    //   77	165	3	i	int
    //   25	466	4	localObject1	Object
    //   36	200	5	localAtomicInteger	AtomicInteger
    //   114	82	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   216	227	243	finally
    //   244	247	243	finally
    //   192	216	249	java/lang/InterruptedException
    //   227	241	249	java/lang/InterruptedException
    //   247	249	249	java/lang/InterruptedException
    //   192	216	290	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegCommandAlreadyRunningException
    //   227	241	290	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegCommandAlreadyRunningException
    //   247	249	290	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegCommandAlreadyRunningException
    //   192	216	331	java/io/IOException
    //   227	241	331	java/io/IOException
    //   247	249	331	java/io/IOException
    //   61	72	372	finally
    //   373	376	372	finally
    //   38	61	378	java/lang/InterruptedException
    //   72	78	378	java/lang/InterruptedException
    //   376	378	378	java/lang/InterruptedException
    //   38	61	419	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegCommandAlreadyRunningException
    //   72	78	419	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegCommandAlreadyRunningException
    //   376	378	419	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegCommandAlreadyRunningException
    //   38	61	460	java/io/IOException
    //   72	78	460	java/io/IOException
    //   376	378	460	java/io/IOException
  }
  
  private static int a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new Object();
    AtomicInteger localAtomicInteger = new AtomicInteger(953005);
    long l = System.currentTimeMillis();
    SLog.b(a, "setMoovAndTimeStamp start!");
    try
    {
      FFmpegUtils.setTimestamp(MobileQQ.getContext(), paramString1, paramString2, paramInt, new VideoCompositeHelper.FFMPEGResponseCallback(localObject, localAtomicInteger, 3));
      try
      {
        localObject.wait(180000L);
        SLog.a(a, "setMoovAndTimeStamp end, take time:%d", Long.valueOf(System.currentTimeMillis() - l));
        paramInt = localAtomicInteger.get();
        return paramInt;
      }
      finally {}
      return 945002;
    }
    catch (InterruptedException paramString1)
    {
      paramString2 = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Wait encode video exception:");
      ((StringBuilder)localObject).append(paramString1);
      SLog.d(paramString2, ((StringBuilder)localObject).toString());
      return 953004;
    }
    catch (FFmpegCommandAlreadyRunningException paramString1)
    {
      paramString2 = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Wait encode video exception:");
      ((StringBuilder)localObject).append(paramString1);
      SLog.d(paramString2, ((StringBuilder)localObject).toString());
      return 953003;
    }
    catch (IOException paramString1)
    {
      paramString2 = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Wait encode video exception:");
      ((StringBuilder)localObject).append(paramString1);
      SLog.d(paramString2, ((StringBuilder)localObject).toString());
    }
  }
  
  private int a(String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry, boolean paramBoolean)
  {
    SLog.d(a, "videoSynthesisForStory start");
    long l = SystemClock.elapsedRealtime();
    MergeEditVideo.EditParam localEditParam = new MergeEditVideo.EditParam(paramPublishVideoEntry.videoMaxrate, paramPublishVideoEntry);
    localEditParam.c(paramPublishVideoEntry.hwBitrateMode);
    if (paramBoolean) {
      localEditParam.a();
    }
    if (paramPublishVideoEntry.isNeedHighProfile)
    {
      localEditParam.d(8);
      SLog.b(a, "codec high profile is enable when story video encode");
    }
    int i = new MergeEditVideo().a(paramString1, paramString2, localEditParam, paramPublishVideoEntry);
    l = SystemClock.elapsedRealtime() - l;
    paramString1 = a;
    paramString2 = new StringBuilder();
    paramString2.append("[videoSynthesis]generate files|first step cost:");
    double d = l;
    Double.isNaN(d);
    paramString2.append(d / 1000.0D);
    SLog.d(paramString1, paramString2.toString());
    if (CaptureFreqMonitor.d) {
      CaptureFreqMonitor.f.a(0, l);
    }
    return i;
  }
  
  @NonNull
  public static PublishVideoEntry a(String paramString)
  {
    Object localObject2 = ((IStoryEntityManager)QRoute.api(IStoryEntityManager.class)).createEntityManager();
    Object localObject1 = new PublishVideoEntry();
    localObject2 = a((EntityManager)localObject2, PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getVidSelectionNoArgs(), new String[] { paramString });
    paramString = (String)localObject1;
    if (localObject2 != null)
    {
      paramString = (String)localObject1;
      if (((List)localObject2).size() > 0) {
        paramString = (PublishVideoEntry)((List)localObject2).get(0);
      }
    }
    localObject1 = paramString;
    if (paramString == null) {
      localObject1 = new PublishVideoEntry();
    }
    return localObject1;
  }
  
  private static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static void a(PublishVideoEntry paramPublishVideoEntry)
  {
    if (paramPublishVideoEntry.businessId == 2)
    {
      SLog.b(a, "deleteVideoCache ignore because business id is qq");
      return;
    }
    if ((!paramPublishVideoEntry.isLocalPublish) && (!TextUtils.isEmpty(paramPublishVideoEntry.mLocalRawVideoDir)) && (!paramPublishVideoEntry.mLocalRawVideoDir.contains(Environment.DIRECTORY_DCIM)))
    {
      d(paramPublishVideoEntry);
      if (paramPublishVideoEntry.isPicture)
      {
        BaseApplication localBaseApplication = MobileQQ.getContext();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("file://");
        localStringBuilder.append(Environment.getExternalStorageDirectory());
        localBaseApplication.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse(localStringBuilder.toString())));
      }
    }
    com.tencent.biz.qqstory.utils.FileUtils.e(paramPublishVideoEntry.videoUploadTempDir);
    SLog.d(a, "delete file:%s", new Object[] { paramPublishVideoEntry.videoUploadTempDir });
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString1, String paramString2)
  {
    if (CompositeUtil.a(paramString1, paramString2, paramPublishVideoEntry) != 0)
    {
      Object localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("adjustBitrate: errcode");
      localStringBuilder.append(paramInt);
      SLog.d((String)localObject, localStringBuilder.toString());
      localObject = new File(paramString2);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      com.tencent.biz.qqstory.utils.FileUtils.c(paramString1, paramString2);
      paramPublishVideoEntry.useSrcFile = true;
    }
  }
  
  private int b(PublishVideoEntry paramPublishVideoEntry)
  {
    VideoStoryPicToVideo.RetCode localRetCode = new VideoStoryPicToVideo.RetCode(940006, "");
    String str = paramPublishVideoEntry.getStringExtra("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", "");
    if ((!str.isEmpty()) && (com.tencent.biz.qqstory.utils.FileUtils.d(str)))
    {
      com.tencent.biz.qqstory.utils.FileUtils.j(paramPublishVideoEntry.mLocalRawVideoDir);
      int n = paramPublishVideoEntry.backgroundMusicDuration / 1000;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapManager.a(str, localOptions);
      int i = ScreenUtil.SCREEN_WIDTH;
      float f = localOptions.outWidth / localOptions.outHeight;
      int k = CompositeUtil.a(i);
      int m = CompositeUtil.a((int)(k / f));
      int j = k;
      i = m;
      if (m > MergeEditVideo.a)
      {
        double d1 = k;
        double d2 = MergeEditVideo.a;
        Double.isNaN(d1);
        Double.isNaN(d2);
        double d3 = m;
        Double.isNaN(d3);
        j = CompositeUtil.a((int)(d1 * d2 / d3));
        i = MergeEditVideo.a;
      }
      VideoStoryPicToVideo.a().a(str, paramPublishVideoEntry.mLocalRawVideoDir, String.valueOf(n), j, i, false, 0, new VideoCompositeHelper.2(this, localRetCode, paramPublishVideoEntry));
      d("convertImageToVideo ");
      return localRetCode.a();
    }
    return localRetCode.a();
  }
  
  private int b(PublishVideoEntry paramPublishVideoEntry, String paramString, boolean paramBoolean)
  {
    Object localObject2 = paramPublishVideoEntry.mLocalRawVideoDir;
    boolean bool = paramPublishVideoEntry.getBooleanExtra("enable_flow_decode", true);
    if (paramPublishVideoEntry.businessId != 1)
    {
      localObject1 = localObject2;
      if (bool) {}
    }
    else
    {
      localObject1 = localObject2;
      if (paramPublishVideoEntry.saveMode == 5) {
        localObject1 = paramPublishVideoEntry.mIFrameVideoPath;
      }
    }
    paramPublishVideoEntry.isMixOriginal = paramPublishVideoEntry.getBooleanExtra("isMixOriginal", false);
    if (!com.tencent.biz.qqstory.utils.FileUtils.d((String)localObject1)) {
      return 940007;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramPublishVideoEntry.videoUploadTempDir);
    ((StringBuilder)localObject2).append("_merge_video_x.mp4");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramPublishVideoEntry.videoUploadTempDir);
    ((StringBuilder)localObject3).append("_merged_video_x.mp4");
    localObject3 = ((StringBuilder)localObject3).toString();
    long l1 = SystemClock.elapsedRealtime();
    int j;
    if (!paramPublishVideoEntry.isCancel) {
      j = a((String)localObject1, (String)localObject2, paramPublishVideoEntry, paramBoolean);
    } else {
      j = 0;
    }
    if (paramPublishVideoEntry.isCancel) {
      j = -15;
    }
    int i = j;
    Object localObject4;
    if (j != 0) {
      if (j == -1)
      {
        localObject4 = new File((String)localObject2);
        if (((File)localObject4).exists()) {
          ((File)localObject4).delete();
        }
        if (this.b)
        {
          a(paramPublishVideoEntry, j, (String)localObject1, (String)localObject2);
        }
        else
        {
          com.tencent.biz.qqstory.utils.FileUtils.c((String)localObject1, (String)localObject2);
          paramPublishVideoEntry.useSrcFile = true;
        }
        i = 0;
      }
      else
      {
        return j;
      }
    }
    SLog.d(a, "hwEncodeRecordVideo mediaCodec trim video cost=%s", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - l1) });
    long l2 = b(paramPublishVideoEntry.mLocalRawVideoDir);
    l1 = SystemClock.elapsedRealtime();
    if ((!TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath)) && (com.tencent.biz.qqstory.utils.FileUtils.d(paramPublishVideoEntry.backgroundMusicPath))) {
      j = 1;
    } else {
      j = 0;
    }
    Object localObject1 = localObject2;
    int k = i;
    if (!paramPublishVideoEntry.isMuteRecordVoice) {
      if (j != 0)
      {
        localObject1 = localObject2;
        k = i;
        if (!paramPublishVideoEntry.isMixOriginal) {}
      }
      else
      {
        localObject1 = localObject2;
        k = i;
        if (!TextUtils.isEmpty(paramPublishVideoEntry.mAudioFilePath))
        {
          localObject1 = localObject2;
          k = i;
          if (!paramPublishVideoEntry.isLocalPublish)
          {
            if (!com.tencent.biz.qqstory.utils.FileUtils.d(paramPublishVideoEntry.mAudioFilePath))
            {
              SLog.d(a, "audio not exist");
              com.tencent.biz.qqstory.utils.FileUtils.b((String)localObject2, paramString);
              return 0;
            }
            SLog.d(a, "trim audio");
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramPublishVideoEntry.videoUploadTempDir);
            ((StringBuilder)localObject1).append(l1);
            ((StringBuilder)localObject1).append("_segment_mc_audio");
            localObject1 = ((StringBuilder)localObject1).toString();
            if (!paramPublishVideoEntry.isCancel)
            {
              localObject4 = paramPublishVideoEntry.mAudioFilePath;
              float f1 = paramPublishVideoEntry.videoRangeStart;
              float f2 = (float)l2;
              i = AudioDataUtil.a((String)localObject4, (String)localObject1, f1 * 1.0F / f2, paramPublishVideoEntry.videoRangeEnd * 1.0F / f2);
            }
            if (paramPublishVideoEntry.isCancel) {
              return -17;
            }
            if (i != 0)
            {
              SLog.d(a, "mediacodec AudioEncoder.clipAudioFile: errcode=%s, rangeStart=%s, rangeEnd=%s, duration=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramPublishVideoEntry.videoRangeStart), Integer.valueOf(paramPublishVideoEntry.videoRangeEnd), Long.valueOf(l2) });
              com.tencent.biz.qqstory.utils.FileUtils.b((String)localObject2, paramString);
              return 0;
            }
            j = AudioEncoder.a((String)localObject1);
            if (j != 0)
            {
              SLog.d(a, "checkSourceAudioIsOK: errorCode=%s, rangeStart=%s, rangeEnd=%s, duration=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramPublishVideoEntry.videoRangeStart), Integer.valueOf(paramPublishVideoEntry.videoRangeEnd), Long.valueOf(l2) });
              com.tencent.biz.qqstory.utils.FileUtils.b((String)localObject2, paramString);
              return 0;
            }
            SLog.d(a, "audio to mp4");
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(paramPublishVideoEntry.videoUploadTempDir);
            ((StringBuilder)localObject4).append("mc_audio.mp4");
            localObject4 = ((StringBuilder)localObject4).toString();
            if (paramPublishVideoEntry.saveMode <= 5) {
              i = paramPublishVideoEntry.saveMode;
            } else {
              i = 0;
            }
            AudioEncoder.AudioData localAudioData = AudioEncoder.a(null, null, i);
            localAudioData.b = ((String)localObject4);
            localAudioData.a = ((String)localObject1);
            i = j;
            if (!paramPublishVideoEntry.isCancel) {
              i = AudioEncoder.a(localAudioData);
            }
            if (paramPublishVideoEntry.isCancel) {
              i = -21;
            }
            if (i != 0)
            {
              com.tencent.biz.qqstory.utils.FileUtils.k((String)localObject4);
              SLog.d(a, "mediacodec AudioEncoder.encodeSafely: errorCode=%s", new Object[] { Integer.valueOf(i) });
              return i;
            }
            localObject1 = new File((String)localObject1);
            if (((File)localObject1).exists()) {
              ((File)localObject1).delete();
            }
            SLog.d(a, "video audio mp4");
            l2 = SystemClock.elapsedRealtime();
            com.tencent.biz.qqstory.utils.FileUtils.k((String)localObject3);
            if (!paramPublishVideoEntry.isCancel) {
              i = HwVideoMerge.merge((String)localObject2, (String)localObject4, (String)localObject3, 0);
            }
            if (paramPublishVideoEntry.isCancel)
            {
              com.tencent.biz.qqstory.utils.FileUtils.k((String)localObject4);
              com.tencent.biz.qqstory.utils.FileUtils.k((String)localObject3);
              return -18;
            }
            SLog.d(a, "[HwVideoMerge.merge]cost=%s", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - l2) });
            if (i != 0)
            {
              SLog.d(a, "HwVideoMerge->merge: errorCode=%s", new Object[] { Integer.valueOf(i) });
              return i;
            }
            l1 = SystemClock.elapsedRealtime() - l1;
            SLog.a(a, "mediacodec encode audio time cost=%s", Long.valueOf(l1));
            if (CaptureFreqMonitor.d) {
              CaptureFreqMonitor.f.a(1, l1);
            }
            localObject1 = localObject3;
            k = i;
          }
        }
      }
    }
    com.tencent.biz.qqstory.utils.FileUtils.b((String)localObject1, paramString);
    return k;
  }
  
  private int b(String paramString1, String paramString2)
  {
    paramString1 = BitmapManager.a(paramString1);
    if (paramString1 == null)
    {
      SLog.e(a, "BitmapManager.decodeFile in resizeToSmallBitmap failed");
      return 942007;
    }
    int i = paramString1.getHeight();
    int k = paramString1.getWidth();
    int j = i * 540 / k;
    i = j;
    if (j % 2 != 0) {
      i = j + 1;
    }
    if (k <= 540)
    {
      paramString1 = a;
      paramString2 = new StringBuilder();
      paramString2.append("No need resize. srcWidth < destWidth, srcWidth = ");
      paramString2.append(k);
      paramString2.append(" destWidth = ");
      paramString2.append(540);
      SLog.e(paramString1, paramString2.toString());
      return 942006;
    }
    Bitmap localBitmap = BitmapUtils.b(paramString1, 540, i, false, false);
    if (localBitmap == null)
    {
      SLog.e(a, "resizeAndFillBitmapEdge in resizeToSmallBitmap failed");
      return 942005;
    }
    if (!BitmapUtils.a(localBitmap, paramString2))
    {
      SLog.e(a, "compressToFile in resizeToSmallBitmap failed");
      return 942008;
    }
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      localBitmap.recycle();
    }
    if ((paramString1 != null) && (!paramString1.isRecycled())) {
      paramString1.recycle();
    }
    return 0;
  }
  
  private int b(String paramString1, String paramString2, int paramInt)
  {
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("fakeId:");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append(", encode video file is too big, so need to compress to:");
    ((StringBuilder)localObject2).append(paramInt);
    SLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
    long l1 = System.currentTimeMillis();
    localObject2 = new Object();
    AtomicInteger localAtomicInteger = new AtomicInteger(-1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append(".temp.mp4");
    localObject1 = ((StringBuilder)localObject1).toString();
    try
    {
      SLog.c(a, "compressVideoWithBitrate!");
      FFmpegUtils.compressVideoWithBitrate(paramString2, (String)localObject1, paramInt, new VideoCompositeHelper.FFMPEGResponseCallback(localObject2, localAtomicInteger, 1));
      try
      {
        localObject2.wait(180000L);
        paramInt = localAtomicInteger.get();
        SLog.c(a, "compressVideoWithBitrate end!");
      }
      finally {}
      String str;
      StringBuilder localStringBuilder;
      if (paramInt != 0) {
        break label430;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Wait encode video exception:");
      localStringBuilder.append(localInterruptedException);
      SLog.d(str, localStringBuilder.toString());
      paramInt = 943003;
    }
    catch (FFmpegCommandAlreadyRunningException localFFmpegCommandAlreadyRunningException)
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Wait encode video exception:");
      localStringBuilder.append(localFFmpegCommandAlreadyRunningException);
      SLog.d(str, localStringBuilder.toString());
      paramInt = 943002;
    }
    catch (IOException localIOException)
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Wait encode video exception:");
      localStringBuilder.append(localIOException);
      SLog.d(str, localStringBuilder.toString());
      paramInt = 943001;
    }
    com.tencent.mobileqq.utils.FileUtils.deleteFile(paramString2);
    com.tencent.mobileqq.utils.FileUtils.rename((String)localObject1, paramString2);
    long l2 = com.tencent.biz.qqstory.utils.FileUtils.a(paramString2);
    int i = VideoUtils.b(paramString2);
    paramString2 = a;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("fakeId:");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(", ffmpeg compress encode video file size to:");
    ((StringBuilder)localObject1).append(l2);
    ((StringBuilder)localObject1).append(" video bitrate to:");
    ((StringBuilder)localObject1).append(i);
    SLog.d(paramString2, ((StringBuilder)localObject1).toString());
    break label436;
    label430:
    com.tencent.mobileqq.utils.FileUtils.deleteFile((String)localObject1);
    label436:
    l2 = System.currentTimeMillis();
    paramString2 = a;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("fakeId:");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(" compressVideoByFFMPEG end errorCode:");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(" cost time=");
    ((StringBuilder)localObject1).append(l2 - l1);
    SLog.d(paramString2, ((StringBuilder)localObject1).toString());
    return paramInt;
  }
  
  public static long b(String paramString)
  {
    if (!com.tencent.biz.qqstory.utils.FileUtils.c(paramString)) {
      return 0L;
    }
    if (Build.VERSION.SDK_INT >= 10) {}
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = localMediaMetadataRetriever.extractMetadata(9);
      localMediaMetadataRetriever.release();
      long l = Long.valueOf(paramString).longValue();
      return l;
    }
    catch (Exception paramString) {}
    return 0L;
    return 0L;
  }
  
  private VideoCompositeHelper.RetCode c(PublishVideoEntry paramPublishVideoEntry)
  {
    VideoCompositeHelper.RetCode localRetCode = new VideoCompositeHelper.RetCode(-1, "");
    String str1 = paramPublishVideoEntry.getStringExtra("vs_publish_entry_json_key_music_download_url", "");
    String str2 = paramPublishVideoEntry.getStringExtra("vs_publish_entry_json_key_music_mid_id", "");
    if (StringUtil.isEmpty(str1))
    {
      localRetCode.a(0);
      localRetCode.a("don't need to download Music");
      return localRetCode;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(QQStoryConstant.c);
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(FFmpegUtils.getAuidoType(str1));
    str2 = ((StringBuilder)localObject).toString();
    paramPublishVideoEntry.backgroundMusicPath = str2;
    if (FileUtil.checkFileExist(str2))
    {
      localRetCode.a(0);
      localRetCode.a("needDownloadMusic and the file exist");
      return localRetCode;
    }
    localObject = new MusicItemInfo();
    ((MusicItemInfo)localObject).setPath(str2);
    ((MusicItemInfo)localObject).mUrl = str1;
    ((MusicItemInfo)localObject).mType = 5;
    ((MusicItemInfo)localObject).mMusicName = paramPublishVideoEntry.getStringExtra("vs_publish_entry_json_key_song_name", "unknown name");
    if (!((IQimMusicPlayer)QRoute.api(IQimMusicPlayer.class)).requestDownLoadMusicInfo((MusicItemInfo)localObject, new VideoCompositeHelper.3(this, paramPublishVideoEntry, localRetCode, str1)))
    {
      localRetCode.a(-1);
      localRetCode.a("needDownloadMusic cant startDownload maybe path is null or the music has downloaded");
      return localRetCode;
    }
    d("needAndStartDownloadMusic");
    return localRetCode;
  }
  
  private void c(String paramString)
  {
    try
    {
      notifyAll();
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" notifyAll() ");
      SLog.c(str, localStringBuilder.toString());
      return;
    }
    finally {}
  }
  
  private static void d(PublishVideoEntry paramPublishVideoEntry)
  {
    if (new File(paramPublishVideoEntry.mLocalRawVideoDir).isDirectory())
    {
      com.tencent.biz.qqstory.utils.FileUtils.e(paramPublishVideoEntry.mLocalRawVideoDir);
      SLog.d(a, "delete filePath: %s", new Object[] { paramPublishVideoEntry.mLocalRawVideoDir });
      return;
    }
    int i = paramPublishVideoEntry.mLocalRawVideoDir.lastIndexOf("/");
    paramPublishVideoEntry = paramPublishVideoEntry.mLocalRawVideoDir.substring(0, i);
    com.tencent.biz.qqstory.utils.FileUtils.e(paramPublishVideoEntry);
    SLog.d(a, "delete filePath: %s", new Object[] { paramPublishVideoEntry });
  }
  
  /* Error */
  private void d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 25	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:a	Ljava/lang/String;
    //   5: astore_2
    //   6: new 27	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: aload_1
    //   16: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload_3
    //   21: ldc_w 798
    //   24: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: aload_3
    //   30: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 657	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: ldc2_w 799
    //   40: invokevirtual 227	java/lang/Object:wait	(J)V
    //   43: goto +50 -> 93
    //   46: astore_1
    //   47: goto +49 -> 96
    //   50: astore_2
    //   51: getstatic 25	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:a	Ljava/lang/String;
    //   54: astore_3
    //   55: new 27	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   62: astore 4
    //   64: aload 4
    //   66: aload_1
    //   67: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 4
    //   73: ldc_w 802
    //   76: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_3
    //   81: aload 4
    //   83: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 657	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload_2
    //   90: invokevirtual 803	java/lang/InterruptedException:printStackTrace	()V
    //   93: aload_0
    //   94: monitorexit
    //   95: return
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	VideoCompositeHelper
    //   0	100	1	paramString	String
    //   5	24	2	str	String
    //   50	40	2	localInterruptedException	InterruptedException
    //   13	68	3	localObject	Object
    //   62	20	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	43	46	finally
    //   51	93	46	finally
    //   93	95	46	finally
    //   96	98	46	finally
    //   2	43	50	java/lang/InterruptedException
  }
  
  /* Error */
  private boolean e(String paramString)
  {
    // Byte code:
    //   0: new 713	com/tencent/mobileqq/editor/composite/VideoCompositeHelper$RetCode
    //   3: dup
    //   4: iconst_m1
    //   5: ldc_w 805
    //   8: invokespecial 714	com/tencent/mobileqq/editor/composite/VideoCompositeHelper$RetCode:<init>	(ILjava/lang/String;)V
    //   11: astore 4
    //   13: getstatic 25	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:a	Ljava/lang/String;
    //   16: ldc_w 807
    //   19: invokestatic 657	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: getstatic 60	android/os/Build$VERSION:SDK_INT	I
    //   25: bipush 16
    //   27: if_icmpge +15 -> 42
    //   30: aload 4
    //   32: invokevirtual 808	com/tencent/mobileqq/editor/composite/VideoCompositeHelper$RetCode:a	()I
    //   35: ifne +5 -> 40
    //   38: iconst_1
    //   39: ireturn
    //   40: iconst_0
    //   41: ireturn
    //   42: new 810	android/media/MediaExtractor
    //   45: dup
    //   46: invokespecial 811	android/media/MediaExtractor:<init>	()V
    //   49: astore_3
    //   50: aload_3
    //   51: aload_1
    //   52: invokevirtual 812	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   55: iconst_0
    //   56: istore_2
    //   57: iload_2
    //   58: aload_3
    //   59: invokevirtual 815	android/media/MediaExtractor:getTrackCount	()I
    //   62: if_icmpge +39 -> 101
    //   65: aload_3
    //   66: iload_2
    //   67: invokevirtual 819	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   70: ldc_w 821
    //   73: invokevirtual 826	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: ldc_w 828
    //   79: invokevirtual 831	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   82: ifeq +12 -> 94
    //   85: aload 4
    //   87: iconst_0
    //   88: invokevirtual 724	com/tencent/mobileqq/editor/composite/VideoCompositeHelper$RetCode:a	(I)V
    //   91: goto +10 -> 101
    //   94: iload_2
    //   95: iconst_1
    //   96: iadd
    //   97: istore_2
    //   98: goto -41 -> 57
    //   101: aload_3
    //   102: invokevirtual 832	android/media/MediaExtractor:release	()V
    //   105: aload 4
    //   107: invokevirtual 808	com/tencent/mobileqq/editor/composite/VideoCompositeHelper$RetCode:a	()I
    //   110: ifne +5 -> 115
    //   113: iconst_1
    //   114: ireturn
    //   115: iconst_0
    //   116: ireturn
    //   117: astore_1
    //   118: goto +14 -> 132
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 833	java/io/IOException:printStackTrace	()V
    //   126: aload_3
    //   127: invokevirtual 832	android/media/MediaExtractor:release	()V
    //   130: iconst_1
    //   131: ireturn
    //   132: aload_3
    //   133: invokevirtual 832	android/media/MediaExtractor:release	()V
    //   136: goto +5 -> 141
    //   139: aload_1
    //   140: athrow
    //   141: goto -2 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	VideoCompositeHelper
    //   0	144	1	paramString	String
    //   56	42	2	i	int
    //   49	84	3	localMediaExtractor	android.media.MediaExtractor
    //   11	95	4	localRetCode	VideoCompositeHelper.RetCode
    // Exception table:
    //   from	to	target	type
    //   50	55	117	finally
    //   57	91	117	finally
    //   122	126	117	finally
    //   50	55	121	java/io/IOException
    //   57	91	121	java/io/IOException
  }
  
  public void a(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, boolean paramBoolean, VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack)
  {
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("fakeId:");
    ((StringBuilder)localObject2).append(paramPublishVideoEntry.fakeVid);
    ((StringBuilder)localObject2).append(" start mergeMusic");
    SLog.c((String)localObject1, ((StringBuilder)localObject2).toString());
    boolean bool2 = TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath);
    boolean bool1 = true;
    int i;
    if ((!bool2) && (!MergeEditVideo.a(paramPublishVideoEntry)) && ((!paramPublishVideoEntry.useSrcFile) || (paramPublishVideoEntry.isMuteRecordVoice) || (paramPublishVideoEntry.isMixOriginal))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      com.tencent.mobileqq.utils.FileUtils.quickMove(paramString1, paramString2);
      paramString1 = a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fakeId:");
      ((StringBuilder)localObject1).append(paramPublishVideoEntry.fakeVid);
      ((StringBuilder)localObject1).append(" noMerge end");
      SLog.c(paramString1, ((StringBuilder)localObject1).toString());
      paramVideoCompositeCallBack.a(0, "", paramString2);
      return;
    }
    localObject1 = c(paramPublishVideoEntry);
    if ((((VideoCompositeHelper.RetCode)localObject1).a() == 0) && (com.tencent.biz.qqstory.utils.FileUtils.c(paramPublishVideoEntry.backgroundMusicPath)))
    {
      long l = b(paramString1);
      if (l > 0L)
      {
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("fakeId:");
        ((StringBuilder)localObject2).append(paramPublishVideoEntry.fakeVid);
        ((StringBuilder)localObject2).append(" duration > 0 need to modify video duration from %d to %d");
        SLog.b((String)localObject1, ((StringBuilder)localObject2).toString(), Integer.valueOf(paramPublishVideoEntry.backgroundMusicDuration), Long.valueOf(l));
        paramPublishVideoEntry.backgroundMusicDuration = ((int)Math.min(paramPublishVideoEntry.backgroundMusicDuration, l));
      }
      if ((paramPublishVideoEntry.isLocalPublish) && (!e(paramString1))) {
        bool1 = false;
      }
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("fakeId:");
      ((StringBuilder)localObject2).append(paramPublishVideoEntry.fakeVid);
      ((StringBuilder)localObject2).append(" detect mp4 whether has original Audio:");
      ((StringBuilder)localObject2).append(bool1);
      SLog.c((String)localObject1, ((StringBuilder)localObject2).toString());
      try
      {
        if ((paramPublishVideoEntry.isMixOriginal) && (bool1))
        {
          localObject1 = a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("fakeId:");
          ((StringBuilder)localObject2).append(paramPublishVideoEntry.fakeVid);
          ((StringBuilder)localObject2).append(" mixOriginalAndBackgroundMusic start");
          SLog.c((String)localObject1, ((StringBuilder)localObject2).toString());
          FFmpegUtils.mixOriginalAndBackgroundMusic(MobileQQ.getContext(), paramString1, paramString2, paramPublishVideoEntry, paramBoolean, new VideoCompositeHelper.MusicCallBack(paramString1, paramString2, paramVideoCompositeCallBack));
          return;
        }
        int j;
        VideoCompositeHelper.MusicCallBack localMusicCallBack;
        if ((paramPublishVideoEntry.isLocalPublish) && (paramPublishVideoEntry.isPicture))
        {
          localObject1 = MobileQQ.getContext();
          localObject2 = paramPublishVideoEntry.backgroundMusicPath;
          i = paramPublishVideoEntry.backgroundMusicOffset;
          j = paramPublishVideoEntry.backgroundMusicDuration;
          localMusicCallBack = new VideoCompositeHelper.MusicCallBack(paramString1, paramString2, paramVideoCompositeCallBack);
        }
        try
        {
          FFmpegUtils.combinBackgroundMusicWithVideCodecH264((Context)localObject1, paramString1, (String)localObject2, i, j, paramString2, localMusicCallBack);
          return;
        }
        catch (Exception paramString2) {}
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("fakeId:");
        ((StringBuilder)localObject2).append(paramPublishVideoEntry.fakeVid);
        ((StringBuilder)localObject2).append("  recordVideo combinBackgroundMusic start");
        SLog.c((String)localObject1, ((StringBuilder)localObject2).toString());
        FFmpegUtils.combinBackgroundMusic(MobileQQ.getContext(), paramString1, paramPublishVideoEntry.backgroundMusicPath, paramPublishVideoEntry.backgroundMusicOffset, paramPublishVideoEntry.backgroundMusicDuration, paramString2, paramBoolean, new VideoCompositeHelper.MusicCallBack(paramString1, paramString2, paramVideoCompositeCallBack));
        return;
      }
      catch (Exception paramString2) {}
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("fakeId:");
      ((StringBuilder)localObject2).append(paramPublishVideoEntry.fakeVid);
      ((StringBuilder)localObject2).append(" combine audio throw exception:");
      SLog.b((String)localObject1, ((StringBuilder)localObject2).toString(), paramString2);
      com.tencent.biz.qqstory.utils.FileUtils.k(paramString1);
      paramVideoCompositeCallBack.a(941000, "combine audio exception", "");
      return;
    }
    paramString1 = a;
    paramString2 = new StringBuilder();
    paramString2.append("fakeId:");
    paramString2.append(paramPublishVideoEntry.fakeVid);
    paramString2.append(" needAndStartDownloadMusic failed code:");
    paramString2.append(((VideoCompositeHelper.RetCode)localObject1).a());
    paramString2.append(",msg:");
    paramString2.append(((VideoCompositeHelper.RetCode)localObject1).b());
    SLog.c(paramString1, paramString2.toString());
    paramVideoCompositeCallBack.a(941000, ((VideoCompositeHelper.RetCode)localObject1).b(), "");
  }
  
  public void a(@NonNull PublishVideoEntry paramPublishVideoEntry, @NonNull String paramString, boolean paramBoolean1, boolean paramBoolean2, @NonNull VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack)
  {
    AssertUtils.checkNotNull(paramPublishVideoEntry);
    AssertUtils.checkNotNull(paramString);
    AssertUtils.checkNotNull(paramVideoCompositeCallBack);
    SLog.d(a, "composite create thread");
    ThreadManager.newFreeThread(new VideoCompositeHelper.1(this, paramPublishVideoEntry, paramString, paramBoolean1, paramBoolean2, paramVideoCompositeCallBack), "StoryVideoComposite", 5).start();
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void b(PublishVideoEntry paramPublishVideoEntry, String paramString, boolean paramBoolean1, boolean paramBoolean2, VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack)
  {
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("doComposite from:");
    ((StringBuilder)localObject2).append(paramPublishVideoEntry.businessId);
    ((StringBuilder)localObject2).append("| fakeId:");
    ((StringBuilder)localObject2).append(paramPublishVideoEntry.fakeVid);
    ((StringBuilder)localObject2).append(" doComposite start");
    SLog.c((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = new File(((IAEPath)QRoute.api(IAEPath.class)).getTmpCache());
    ((File)localObject1).mkdirs();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append(com.tencent.biz.qqstory.utils.FileUtils.f(paramPublishVideoEntry.mLocalRawVideoDir));
    ((StringBuilder)localObject2).append(".mp4");
    Object localObject3 = ((StringBuilder)localObject2).toString();
    boolean bool = paramPublishVideoEntry.isPicture;
    int i = 0;
    int j = 0;
    localObject2 = "";
    StringBuilder localStringBuilder;
    if (bool)
    {
      localObject1 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fakeId:");
      localStringBuilder.append(paramPublishVideoEntry.fakeVid);
      localStringBuilder.append(" not hwEncode and encodePicToVideo start");
      SLog.d((String)localObject1, localStringBuilder.toString());
      i = a(paramPublishVideoEntry, (String)localObject3);
      if (i != 942014)
      {
        j = i;
        localObject1 = localObject2;
        if (i != 942007) {}
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("outOfMemory file info:");
        ((StringBuilder)localObject1).append(BitmapUtils.c(paramPublishVideoEntry.mLocalRawVideoDir));
        localObject1 = ((StringBuilder)localObject1).toString();
        j = i;
      }
    }
    else if (paramPublishVideoEntry.hwEncodeRecordVideo)
    {
      if (QLog.isColorLevel()) {
        SLog.a(a, "record video, isLocal=%s , size=%s, bitrate=%s and need to encode to bitrate=%s", Boolean.valueOf(paramPublishVideoEntry.isLocalPublish), Long.valueOf(com.tencent.biz.qqstory.utils.FileUtils.a(paramPublishVideoEntry.mLocalRawVideoDir)), Integer.valueOf(VideoUtils.b(paramPublishVideoEntry.mLocalRawVideoDir)), Integer.valueOf(paramPublishVideoEntry.videoMaxrate));
      }
      i = j;
      if (paramPublishVideoEntry.isLocalPublish)
      {
        i = j;
        if (paramPublishVideoEntry.getBooleanExtra("KEY_FROM_PIC_TO_VIDEO", false))
        {
          i = j;
          if (!StringUtil.isEmpty(paramPublishVideoEntry.backgroundMusicPath))
          {
            l1 = System.currentTimeMillis();
            localObject1 = a;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("fakeId:");
            localStringBuilder.append(paramPublishVideoEntry.fakeVid);
            localStringBuilder.append(" convertImageToVideo start");
            SLog.c((String)localObject1, localStringBuilder.toString());
            i = b(paramPublishVideoEntry);
            localObject1 = a;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("fakeId:");
            localStringBuilder.append(paramPublishVideoEntry.fakeVid);
            localStringBuilder.append(" convertImageToVideo end errorCode:");
            localStringBuilder.append(i);
            localStringBuilder.append(" cost:");
            localStringBuilder.append(System.currentTimeMillis() - l1);
            localStringBuilder.append("ms");
            SLog.c((String)localObject1, localStringBuilder.toString());
          }
        }
      }
      j = i;
      if (i == 0)
      {
        localObject1 = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("fakeId:");
        localStringBuilder.append(paramPublishVideoEntry.fakeVid);
        localStringBuilder.append(" hwEncodeRecordVideo start");
        SLog.c((String)localObject1, localStringBuilder.toString());
        l1 = System.currentTimeMillis();
        if (!paramPublishVideoEntry.isCancel) {
          i = a(paramPublishVideoEntry, (String)localObject3, paramBoolean1);
        }
        if (paramPublishVideoEntry.isCancel)
        {
          com.tencent.biz.qqstory.utils.FileUtils.k((String)localObject3);
          i = -14;
        }
        localObject1 = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("fakeId:");
        localStringBuilder.append(paramPublishVideoEntry.fakeVid);
        localStringBuilder.append(" hwEncodeRecordVideo end errorCode:");
        localStringBuilder.append(i);
        localStringBuilder.append(" cost:");
        localStringBuilder.append(System.currentTimeMillis() - l1);
        localStringBuilder.append("ms");
        SLog.c((String)localObject1, localStringBuilder.toString());
        j = i;
      }
      localObject1 = (IStoryConfigManager)QRoute.api(IStoryConfigManager.class);
      int k = ((IStoryConfigManager)localObject1).getMaxUploadFileSize();
      int m = ((IStoryConfigManager)localObject1).getHighBitrate();
      i = VideoUtils.b((String)localObject3);
      long l1 = com.tencent.biz.qqstory.utils.FileUtils.a((String)localObject3);
      localObject1 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fakeId:");
      localStringBuilder.append(paramPublishVideoEntry.fakeVid);
      localStringBuilder.append(" encode video info file size:");
      localStringBuilder.append(l1);
      localStringBuilder.append(" bitrate=");
      localStringBuilder.append(i);
      localStringBuilder.append(" and upload limit=");
      localStringBuilder.append(k);
      SLog.c((String)localObject1, localStringBuilder.toString());
      long l2 = System.currentTimeMillis();
      i = j;
      if (j == 0)
      {
        i = j;
        if (paramPublishVideoEntry.videoDuration > 0L)
        {
          i = j;
          if (l1 > k / 10000 * paramPublishVideoEntry.videoDuration)
          {
            i = b(paramPublishVideoEntry.fakeVid, (String)localObject3, m);
            if (paramPublishVideoEntry.isCancel)
            {
              com.tencent.biz.qqstory.utils.FileUtils.k((String)localObject3);
              i = -20;
            }
          }
        }
      }
      j = i;
      localObject1 = localObject2;
      if (CaptureFreqMonitor.d)
      {
        CaptureFreqMonitor.f.a(4, System.currentTimeMillis() - l2);
        j = i;
        localObject1 = localObject2;
      }
    }
    else
    {
      QLog.d(a, 1, "hwEncodeRecordVideo false, return");
      localObject1 = localObject2;
      j = i;
    }
    if (j != 0)
    {
      localObject2 = a;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("fakeId:");
      ((StringBuilder)localObject3).append(paramPublishVideoEntry.fakeVid);
      ((StringBuilder)localObject3).append(", mediaCodec encode video failed:");
      ((StringBuilder)localObject3).append(j);
      SLog.e((String)localObject2, ((StringBuilder)localObject3).toString());
      paramVideoCompositeCallBack.a(j, (String)localObject1, paramString);
      return;
    }
    a(paramPublishVideoEntry, (String)localObject3, paramString, paramBoolean2, paramVideoCompositeCallBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.VideoCompositeHelper
 * JD-Core Version:    0.7.0.1
 */
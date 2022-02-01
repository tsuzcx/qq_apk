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
  private boolean a;
  
  static
  {
    try
    {
      int i = VideoEnvironment.loadAVCodecSo();
      String str = jdField_a_of_type_JavaLangString;
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
  
  private int a(PublishVideoEntry paramPublishVideoEntry)
  {
    VideoStoryPicToVideo.RetCode localRetCode = new VideoStoryPicToVideo.RetCode(940006, "");
    String str = paramPublishVideoEntry.getStringExtra("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", "");
    if ((!str.isEmpty()) && (com.tencent.biz.qqstory.utils.FileUtils.c(str)))
    {
      com.tencent.biz.qqstory.utils.FileUtils.f(paramPublishVideoEntry.mLocalRawVideoDir);
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
      b("convertImageToVideo ");
      return localRetCode.a();
    }
    return localRetCode.a();
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
          SLog.d(jdField_a_of_type_JavaLangString, "convert picture to video by mediaCodec error. use ffmepg to convert again.");
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
      com.tencent.biz.qqstory.utils.FileUtils.g(paramString);
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
    if (CaptureFreqMonitor.b) {
      CaptureFreqMonitor.c.a(2, System.currentTimeMillis() - l);
    }
    Object localObject2;
    if (i == 0)
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set moov in front of file success. targetMergedTempMp4 = ");
      localStringBuilder.append((String)localObject1);
      SLog.d((String)localObject2, localStringBuilder.toString());
      com.tencent.biz.qqstory.utils.FileUtils.b((String)localObject1, paramString);
    }
    else
    {
      SLog.d(jdField_a_of_type_JavaLangString, "set moov in front of file fail %d", new Object[] { Integer.valueOf(i) });
      localObject1 = jdField_a_of_type_JavaLangString;
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
        paramPublishVideoEntry = jdField_a_of_type_JavaLangString;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isHuaweiGreen: reEncodeVideoWithFFMpeg succeed. output path = ");
        ((StringBuilder)localObject1).append(paramString);
        SLog.d(paramPublishVideoEntry, ((StringBuilder)localObject1).toString());
      }
      else
      {
        paramPublishVideoEntry = jdField_a_of_type_JavaLangString;
        paramString = new StringBuilder();
        paramString.append("isHuaweiGreen: reEncodeVideoWithFFMpeg failed. errorCode = ");
        paramString.append(i);
        SLog.e(paramPublishVideoEntry, paramString.toString());
      }
      j = i;
      if (CaptureFreqMonitor.b)
      {
        CaptureFreqMonitor.c.a(3, System.currentTimeMillis() - l);
        j = i;
      }
    }
    return j;
  }
  
  /* Error */
  private int a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 24	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3: ldc_w 283
    //   6: invokestatic 193	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_1
    //   10: invokestatic 82	com/tencent/biz/qqstory/utils/FileUtils:c	(Ljava/lang/String;)Z
    //   13: ifne +7 -> 20
    //   16: ldc_w 284
    //   19: ireturn
    //   20: new 4	java/lang/Object
    //   23: dup
    //   24: invokespecial 53	java/lang/Object:<init>	()V
    //   27: astore 4
    //   29: new 286	java/util/concurrent/atomic/AtomicInteger
    //   32: dup
    //   33: ldc_w 287
    //   36: invokespecial 290	java/util/concurrent/atomic/AtomicInteger:<init>	(I)V
    //   39: astore 5
    //   41: invokestatic 296	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   44: aload_1
    //   45: aload_2
    //   46: new 298	com/tencent/mobileqq/editor/composite/VideoCompositeHelper$FFMPEGResponseCallback
    //   49: dup
    //   50: aload 4
    //   52: aload 5
    //   54: iconst_2
    //   55: invokespecial 301	com/tencent/mobileqq/editor/composite/VideoCompositeHelper$FFMPEGResponseCallback:<init>	(Ljava/lang/Object;Ljava/util/concurrent/atomic/AtomicInteger;I)V
    //   58: invokestatic 307	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegUtils:convertPicToVideo	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteResponseCallback;)V
    //   61: aload 4
    //   63: monitorenter
    //   64: aload 4
    //   66: ldc2_w 308
    //   69: invokevirtual 313	java/lang/Object:wait	(J)V
    //   72: aload 4
    //   74: monitorexit
    //   75: aload 5
    //   77: invokevirtual 316	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   80: istore_3
    //   81: iload_3
    //   82: ifne +5 -> 87
    //   85: iconst_0
    //   86: ireturn
    //   87: getstatic 24	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   90: ldc_w 318
    //   93: iconst_1
    //   94: anewarray 4	java/lang/Object
    //   97: dup
    //   98: iconst_0
    //   99: aload 5
    //   101: invokevirtual 316	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   104: invokestatic 253	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: aastore
    //   108: invokestatic 256	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: new 26	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   118: astore 6
    //   120: aload 6
    //   122: aload_1
    //   123: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 6
    //   129: ldc_w 320
    //   132: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload 6
    //   138: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: astore 6
    //   143: aload_0
    //   144: aload_1
    //   145: aload 6
    //   147: invokespecial 322	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   150: istore_3
    //   151: iload_3
    //   152: ifeq +39 -> 191
    //   155: getstatic 24	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   158: astore_1
    //   159: new 26	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   166: astore_2
    //   167: aload_2
    //   168: ldc_w 324
    //   171: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_2
    //   176: iload_3
    //   177: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload_1
    //   182: aload_2
    //   183: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 275	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: iload_3
    //   190: ireturn
    //   191: aload 5
    //   193: ldc_w 287
    //   196: invokevirtual 327	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   199: invokestatic 296	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   202: aload 6
    //   204: aload_2
    //   205: new 298	com/tencent/mobileqq/editor/composite/VideoCompositeHelper$FFMPEGResponseCallback
    //   208: dup
    //   209: aload 4
    //   211: aload 5
    //   213: iconst_2
    //   214: invokespecial 301	com/tencent/mobileqq/editor/composite/VideoCompositeHelper$FFMPEGResponseCallback:<init>	(Ljava/lang/Object;Ljava/util/concurrent/atomic/AtomicInteger;I)V
    //   217: invokestatic 307	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegUtils:convertPicToVideo	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteResponseCallback;)V
    //   220: aload 4
    //   222: monitorenter
    //   223: aload 4
    //   225: ldc2_w 308
    //   228: invokevirtual 313	java/lang/Object:wait	(J)V
    //   231: aload 4
    //   233: monitorexit
    //   234: getstatic 24	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   237: ldc_w 329
    //   240: invokestatic 193	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload 5
    //   245: invokevirtual 316	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   248: istore_3
    //   249: iload_3
    //   250: ireturn
    //   251: astore_1
    //   252: aload 4
    //   254: monitorexit
    //   255: aload_1
    //   256: athrow
    //   257: astore_1
    //   258: getstatic 24	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   261: astore_2
    //   262: new 26	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   269: astore 4
    //   271: aload 4
    //   273: ldc_w 331
    //   276: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload 4
    //   282: aload_1
    //   283: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_2
    //   288: aload 4
    //   290: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 193	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: ldc_w 335
    //   299: ireturn
    //   300: astore_1
    //   301: getstatic 24	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   304: astore_2
    //   305: new 26	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   312: astore 4
    //   314: aload 4
    //   316: ldc_w 331
    //   319: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 4
    //   325: aload_1
    //   326: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload_2
    //   331: aload 4
    //   333: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 193	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   339: ldc_w 336
    //   342: ireturn
    //   343: astore_1
    //   344: getstatic 24	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   347: astore_2
    //   348: new 26	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   355: astore 4
    //   357: aload 4
    //   359: ldc_w 331
    //   362: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: aload 4
    //   368: aload_1
    //   369: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload_2
    //   374: aload 4
    //   376: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 193	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   382: ldc_w 337
    //   385: ireturn
    //   386: astore_1
    //   387: aload 4
    //   389: monitorexit
    //   390: aload_1
    //   391: athrow
    //   392: astore_1
    //   393: getstatic 24	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   396: astore_2
    //   397: new 26	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   404: astore 4
    //   406: aload 4
    //   408: ldc_w 331
    //   411: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload 4
    //   417: aload_1
    //   418: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload_2
    //   423: aload 4
    //   425: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: invokestatic 193	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: ldc_w 335
    //   434: ireturn
    //   435: astore_1
    //   436: getstatic 24	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   439: astore_2
    //   440: new 26	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   447: astore 4
    //   449: aload 4
    //   451: ldc_w 331
    //   454: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload 4
    //   460: aload_1
    //   461: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: aload_2
    //   466: aload 4
    //   468: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokestatic 193	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   474: ldc_w 336
    //   477: ireturn
    //   478: astore_1
    //   479: getstatic 24	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   482: astore_2
    //   483: new 26	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   490: astore 4
    //   492: aload 4
    //   494: ldc_w 331
    //   497: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload 4
    //   503: aload_1
    //   504: invokevirtual 334	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload_2
    //   509: aload 4
    //   511: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokestatic 193	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   517: ldc_w 337
    //   520: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	521	0	this	VideoCompositeHelper
    //   0	521	1	paramString1	String
    //   0	521	2	paramString2	String
    //   80	170	3	i	int
    //   27	483	4	localObject1	Object
    //   39	205	5	localAtomicInteger	AtomicInteger
    //   118	85	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   223	234	251	finally
    //   252	255	251	finally
    //   199	223	257	java/lang/InterruptedException
    //   234	249	257	java/lang/InterruptedException
    //   255	257	257	java/lang/InterruptedException
    //   199	223	300	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegCommandAlreadyRunningException
    //   234	249	300	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegCommandAlreadyRunningException
    //   255	257	300	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegCommandAlreadyRunningException
    //   199	223	343	java/io/IOException
    //   234	249	343	java/io/IOException
    //   255	257	343	java/io/IOException
    //   64	75	386	finally
    //   387	390	386	finally
    //   41	64	392	java/lang/InterruptedException
    //   75	81	392	java/lang/InterruptedException
    //   390	392	392	java/lang/InterruptedException
    //   41	64	435	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegCommandAlreadyRunningException
    //   75	81	435	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegCommandAlreadyRunningException
    //   390	392	435	com/tencent/mobileqq/videocodec/ffmpeg/FFmpegCommandAlreadyRunningException
    //   41	64	478	java/io/IOException
    //   75	81	478	java/io/IOException
    //   390	392	478	java/io/IOException
  }
  
  private static int a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new Object();
    AtomicInteger localAtomicInteger = new AtomicInteger(953005);
    long l = System.currentTimeMillis();
    SLog.b(jdField_a_of_type_JavaLangString, "setMoovAndTimeStamp start!");
    try
    {
      FFmpegUtils.setTimestamp(MobileQQ.getContext(), paramString1, paramString2, paramInt, new VideoCompositeHelper.FFMPEGResponseCallback(localObject, localAtomicInteger, 3));
      try
      {
        localObject.wait(180000L);
        SLog.a(jdField_a_of_type_JavaLangString, "setMoovAndTimeStamp end, take time:%d", Long.valueOf(System.currentTimeMillis() - l));
        paramInt = localAtomicInteger.get();
        return paramInt;
      }
      finally {}
      return 945002;
    }
    catch (InterruptedException paramString1)
    {
      paramString2 = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Wait encode video exception:");
      ((StringBuilder)localObject).append(paramString1);
      SLog.d(paramString2, ((StringBuilder)localObject).toString());
      return 953004;
    }
    catch (FFmpegCommandAlreadyRunningException paramString1)
    {
      paramString2 = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Wait encode video exception:");
      ((StringBuilder)localObject).append(paramString1);
      SLog.d(paramString2, ((StringBuilder)localObject).toString());
      return 953003;
    }
    catch (IOException paramString1)
    {
      paramString2 = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Wait encode video exception:");
      ((StringBuilder)localObject).append(paramString1);
      SLog.d(paramString2, ((StringBuilder)localObject).toString());
    }
  }
  
  private int a(String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry, boolean paramBoolean)
  {
    SLog.d(jdField_a_of_type_JavaLangString, "videoSynthesisForStory start");
    long l = SystemClock.elapsedRealtime();
    MergeEditVideo.EditParam localEditParam = new MergeEditVideo.EditParam(paramPublishVideoEntry.videoMaxrate, paramPublishVideoEntry);
    localEditParam.b(paramPublishVideoEntry.hwBitrateMode);
    if (paramBoolean) {
      localEditParam.a();
    }
    if (paramPublishVideoEntry.isNeedHighProfile)
    {
      localEditParam.c(8);
      SLog.b(jdField_a_of_type_JavaLangString, "codec high profile is enable when story video encode");
    }
    int i = new MergeEditVideo().a(paramString1, paramString2, localEditParam, paramPublishVideoEntry);
    l = SystemClock.elapsedRealtime() - l;
    paramString1 = jdField_a_of_type_JavaLangString;
    paramString2 = new StringBuilder();
    paramString2.append("[videoSynthesis]generate files|first step cost:");
    double d = l;
    Double.isNaN(d);
    paramString2.append(d / 1000.0D);
    SLog.d(paramString1, paramString2.toString());
    if (CaptureFreqMonitor.b) {
      CaptureFreqMonitor.c.a(0, l);
    }
    return i;
  }
  
  public static long a(String paramString)
  {
    if (!com.tencent.biz.qqstory.utils.FileUtils.b(paramString)) {
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
  
  private VideoCompositeHelper.RetCode a(PublishVideoEntry paramPublishVideoEntry)
  {
    VideoCompositeHelper.RetCode localRetCode = new VideoCompositeHelper.RetCode(-1, "");
    String str1 = paramPublishVideoEntry.getStringExtra("vs_publish_entry_json_key_music_download_url", "");
    String str2 = paramPublishVideoEntry.getStringExtra("vs_publish_entry_json_key_music_mid_id", "");
    if (StringUtil.a(str1))
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
    b("needAndStartDownloadMusic");
    return localRetCode;
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
      SLog.b(jdField_a_of_type_JavaLangString, "deleteVideoCache ignore because business id is qq");
      return;
    }
    if ((!paramPublishVideoEntry.isLocalPublish) && (!TextUtils.isEmpty(paramPublishVideoEntry.mLocalRawVideoDir)) && (!paramPublishVideoEntry.mLocalRawVideoDir.contains(Environment.DIRECTORY_DCIM)))
    {
      b(paramPublishVideoEntry);
      if (paramPublishVideoEntry.isPicture)
      {
        BaseApplication localBaseApplication = MobileQQ.getContext();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("file://");
        localStringBuilder.append(Environment.getExternalStorageDirectory());
        localBaseApplication.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse(localStringBuilder.toString())));
      }
    }
    com.tencent.biz.qqstory.utils.FileUtils.d(paramPublishVideoEntry.videoUploadTempDir);
    SLog.d(jdField_a_of_type_JavaLangString, "delete file:%s", new Object[] { paramPublishVideoEntry.videoUploadTempDir });
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString1, String paramString2)
  {
    if (CompositeUtil.a(paramString1, paramString2, paramPublishVideoEntry) != 0)
    {
      Object localObject = jdField_a_of_type_JavaLangString;
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
  
  private void a(String paramString)
  {
    try
    {
      notifyAll();
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" notifyAll() ");
      SLog.c(str, localStringBuilder.toString());
      return;
    }
    finally {}
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: new 428	com/tencent/mobileqq/editor/composite/VideoCompositeHelper$RetCode
    //   3: dup
    //   4: iconst_m1
    //   5: ldc_w 614
    //   8: invokespecial 429	com/tencent/mobileqq/editor/composite/VideoCompositeHelper$RetCode:<init>	(ILjava/lang/String;)V
    //   11: astore 4
    //   13: getstatic 24	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: ldc_w 616
    //   19: invokestatic 612	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: getstatic 159	android/os/Build$VERSION:SDK_INT	I
    //   25: bipush 16
    //   27: if_icmpge +15 -> 42
    //   30: aload 4
    //   32: invokevirtual 617	com/tencent/mobileqq/editor/composite/VideoCompositeHelper$RetCode:a	()I
    //   35: ifne +5 -> 40
    //   38: iconst_1
    //   39: ireturn
    //   40: iconst_0
    //   41: ireturn
    //   42: new 619	android/media/MediaExtractor
    //   45: dup
    //   46: invokespecial 620	android/media/MediaExtractor:<init>	()V
    //   49: astore_3
    //   50: aload_3
    //   51: aload_1
    //   52: invokevirtual 621	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   55: iconst_0
    //   56: istore_2
    //   57: iload_2
    //   58: aload_3
    //   59: invokevirtual 624	android/media/MediaExtractor:getTrackCount	()I
    //   62: if_icmpge +39 -> 101
    //   65: aload_3
    //   66: iload_2
    //   67: invokevirtual 628	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   70: ldc_w 630
    //   73: invokevirtual 635	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: ldc_w 637
    //   79: invokevirtual 640	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   82: ifeq +12 -> 94
    //   85: aload 4
    //   87: iconst_0
    //   88: invokevirtual 439	com/tencent/mobileqq/editor/composite/VideoCompositeHelper$RetCode:a	(I)V
    //   91: goto +10 -> 101
    //   94: iload_2
    //   95: iconst_1
    //   96: iadd
    //   97: istore_2
    //   98: goto -41 -> 57
    //   101: aload_3
    //   102: invokevirtual 641	android/media/MediaExtractor:release	()V
    //   105: aload 4
    //   107: invokevirtual 617	com/tencent/mobileqq/editor/composite/VideoCompositeHelper$RetCode:a	()I
    //   110: ifne +5 -> 115
    //   113: iconst_1
    //   114: ireturn
    //   115: iconst_0
    //   116: ireturn
    //   117: astore_1
    //   118: goto +14 -> 132
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 642	java/io/IOException:printStackTrace	()V
    //   126: aload_3
    //   127: invokevirtual 641	android/media/MediaExtractor:release	()V
    //   130: iconst_1
    //   131: ireturn
    //   132: aload_3
    //   133: invokevirtual 641	android/media/MediaExtractor:release	()V
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
    if (!com.tencent.biz.qqstory.utils.FileUtils.c((String)localObject1)) {
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
        if (this.jdField_a_of_type_Boolean)
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
    SLog.d(jdField_a_of_type_JavaLangString, "hwEncodeRecordVideo mediaCodec trim video cost=%s", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - l1) });
    long l2 = a(paramPublishVideoEntry.mLocalRawVideoDir);
    l1 = SystemClock.elapsedRealtime();
    if ((!TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath)) && (com.tencent.biz.qqstory.utils.FileUtils.c(paramPublishVideoEntry.backgroundMusicPath))) {
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
            if (!com.tencent.biz.qqstory.utils.FileUtils.c(paramPublishVideoEntry.mAudioFilePath))
            {
              SLog.d(jdField_a_of_type_JavaLangString, "audio not exist");
              com.tencent.biz.qqstory.utils.FileUtils.b((String)localObject2, paramString);
              return 0;
            }
            SLog.d(jdField_a_of_type_JavaLangString, "trim audio");
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
              SLog.d(jdField_a_of_type_JavaLangString, "mediacodec AudioEncoder.clipAudioFile: errcode=%s, rangeStart=%s, rangeEnd=%s, duration=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramPublishVideoEntry.videoRangeStart), Integer.valueOf(paramPublishVideoEntry.videoRangeEnd), Long.valueOf(l2) });
              com.tencent.biz.qqstory.utils.FileUtils.b((String)localObject2, paramString);
              return 0;
            }
            j = AudioEncoder.a((String)localObject1);
            if (j != 0)
            {
              SLog.d(jdField_a_of_type_JavaLangString, "checkSourceAudioIsOK: errorCode=%s, rangeStart=%s, rangeEnd=%s, duration=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramPublishVideoEntry.videoRangeStart), Integer.valueOf(paramPublishVideoEntry.videoRangeEnd), Long.valueOf(l2) });
              com.tencent.biz.qqstory.utils.FileUtils.b((String)localObject2, paramString);
              return 0;
            }
            SLog.d(jdField_a_of_type_JavaLangString, "audio to mp4");
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
            localAudioData.jdField_a_of_type_JavaLangString = ((String)localObject1);
            i = j;
            if (!paramPublishVideoEntry.isCancel) {
              i = AudioEncoder.a(localAudioData);
            }
            if (paramPublishVideoEntry.isCancel) {
              i = -21;
            }
            if (i != 0)
            {
              com.tencent.biz.qqstory.utils.FileUtils.g((String)localObject4);
              SLog.d(jdField_a_of_type_JavaLangString, "mediacodec AudioEncoder.encodeSafely: errorCode=%s", new Object[] { Integer.valueOf(i) });
              return i;
            }
            localObject1 = new File((String)localObject1);
            if (((File)localObject1).exists()) {
              ((File)localObject1).delete();
            }
            SLog.d(jdField_a_of_type_JavaLangString, "video audio mp4");
            l2 = SystemClock.elapsedRealtime();
            com.tencent.biz.qqstory.utils.FileUtils.g((String)localObject3);
            if (!paramPublishVideoEntry.isCancel) {
              i = HwVideoMerge.merge((String)localObject2, (String)localObject4, (String)localObject3, 0);
            }
            if (paramPublishVideoEntry.isCancel)
            {
              com.tencent.biz.qqstory.utils.FileUtils.g((String)localObject4);
              com.tencent.biz.qqstory.utils.FileUtils.g((String)localObject3);
              return -18;
            }
            SLog.d(jdField_a_of_type_JavaLangString, "[HwVideoMerge.merge]cost=%s", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - l2) });
            if (i != 0)
            {
              SLog.d(jdField_a_of_type_JavaLangString, "HwVideoMerge->merge: errorCode=%s", new Object[] { Integer.valueOf(i) });
              return i;
            }
            l1 = SystemClock.elapsedRealtime() - l1;
            SLog.a(jdField_a_of_type_JavaLangString, "mediacodec encode audio time cost=%s", Long.valueOf(l1));
            if (CaptureFreqMonitor.b) {
              CaptureFreqMonitor.c.a(1, l1);
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
      SLog.e(jdField_a_of_type_JavaLangString, "BitmapManager.decodeFile in resizeToSmallBitmap failed");
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
      paramString1 = jdField_a_of_type_JavaLangString;
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
      SLog.e(jdField_a_of_type_JavaLangString, "resizeAndFillBitmapEdge in resizeToSmallBitmap failed");
      return 942005;
    }
    if (!BitmapUtils.a(localBitmap, paramString2))
    {
      SLog.e(jdField_a_of_type_JavaLangString, "compressToFile in resizeToSmallBitmap failed");
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
    Object localObject1 = jdField_a_of_type_JavaLangString;
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
      SLog.c(jdField_a_of_type_JavaLangString, "compressVideoWithBitrate!");
      FFmpegUtils.compressVideoWithBitrate(paramString2, (String)localObject1, paramInt, new VideoCompositeHelper.FFMPEGResponseCallback(localObject2, localAtomicInteger, 1));
      try
      {
        localObject2.wait(180000L);
        paramInt = localAtomicInteger.get();
        SLog.c(jdField_a_of_type_JavaLangString, "compressVideoWithBitrate end!");
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
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Wait encode video exception:");
      localStringBuilder.append(localInterruptedException);
      SLog.d(str, localStringBuilder.toString());
      paramInt = 943003;
    }
    catch (FFmpegCommandAlreadyRunningException localFFmpegCommandAlreadyRunningException)
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Wait encode video exception:");
      localStringBuilder.append(localFFmpegCommandAlreadyRunningException);
      SLog.d(str, localStringBuilder.toString());
      paramInt = 943002;
    }
    catch (IOException localIOException)
    {
      str = jdField_a_of_type_JavaLangString;
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
    paramString2 = jdField_a_of_type_JavaLangString;
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
    paramString2 = jdField_a_of_type_JavaLangString;
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
  
  private static void b(PublishVideoEntry paramPublishVideoEntry)
  {
    if (new File(paramPublishVideoEntry.mLocalRawVideoDir).isDirectory())
    {
      com.tencent.biz.qqstory.utils.FileUtils.d(paramPublishVideoEntry.mLocalRawVideoDir);
      SLog.d(jdField_a_of_type_JavaLangString, "delete filePath: %s", new Object[] { paramPublishVideoEntry.mLocalRawVideoDir });
      return;
    }
    int i = paramPublishVideoEntry.mLocalRawVideoDir.lastIndexOf("/");
    paramPublishVideoEntry = paramPublishVideoEntry.mLocalRawVideoDir.substring(0, i);
    com.tencent.biz.qqstory.utils.FileUtils.d(paramPublishVideoEntry);
    SLog.d(jdField_a_of_type_JavaLangString, "delete filePath: %s", new Object[] { paramPublishVideoEntry });
  }
  
  /* Error */
  private void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 24	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   5: astore_2
    //   6: new 26	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: aload_1
    //   16: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload_3
    //   21: ldc_w 825
    //   24: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: aload_3
    //   30: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 612	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: ldc2_w 826
    //   40: invokevirtual 313	java/lang/Object:wait	(J)V
    //   43: goto +50 -> 93
    //   46: astore_1
    //   47: goto +49 -> 96
    //   50: astore_2
    //   51: getstatic 24	com/tencent/mobileqq/editor/composite/VideoCompositeHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   54: astore_3
    //   55: new 26	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   62: astore 4
    //   64: aload 4
    //   66: aload_1
    //   67: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 4
    //   73: ldc_w 829
    //   76: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_3
    //   81: aload 4
    //   83: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 612	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload_2
    //   90: invokevirtual 830	java/lang/InterruptedException:printStackTrace	()V
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
  
  public void a(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, boolean paramBoolean, VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack)
  {
    Object localObject1 = jdField_a_of_type_JavaLangString;
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
      com.tencent.biz.qqstory.utils.FileUtils.b(paramString1, paramString2);
      paramString1 = jdField_a_of_type_JavaLangString;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fakeId:");
      ((StringBuilder)localObject1).append(paramPublishVideoEntry.fakeVid);
      ((StringBuilder)localObject1).append(" noMerge end");
      SLog.c(paramString1, ((StringBuilder)localObject1).toString());
      paramVideoCompositeCallBack.a(0, "", paramString2);
      return;
    }
    localObject1 = a(paramPublishVideoEntry);
    if ((((VideoCompositeHelper.RetCode)localObject1).a() == 0) && (com.tencent.biz.qqstory.utils.FileUtils.b(paramPublishVideoEntry.backgroundMusicPath)))
    {
      long l = a(paramString1);
      if (l > 0L)
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("fakeId:");
        ((StringBuilder)localObject2).append(paramPublishVideoEntry.fakeVid);
        ((StringBuilder)localObject2).append(" duration > 0 need to modify video duration from %d to %d");
        SLog.b((String)localObject1, ((StringBuilder)localObject2).toString(), Integer.valueOf(paramPublishVideoEntry.backgroundMusicDuration), Long.valueOf(l));
        paramPublishVideoEntry.backgroundMusicDuration = ((int)Math.min(paramPublishVideoEntry.backgroundMusicDuration, l));
      }
      if ((paramPublishVideoEntry.isLocalPublish) && (!a(paramString1))) {
        bool1 = false;
      }
      localObject1 = jdField_a_of_type_JavaLangString;
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
          localObject1 = jdField_a_of_type_JavaLangString;
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
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("fakeId:");
        ((StringBuilder)localObject2).append(paramPublishVideoEntry.fakeVid);
        ((StringBuilder)localObject2).append("  recordVideo combinBackgroundMusic start");
        SLog.c((String)localObject1, ((StringBuilder)localObject2).toString());
        FFmpegUtils.combinBackgroundMusic(MobileQQ.getContext(), paramString1, paramPublishVideoEntry.backgroundMusicPath, paramPublishVideoEntry.backgroundMusicOffset, paramPublishVideoEntry.backgroundMusicDuration, paramString2, paramBoolean, new VideoCompositeHelper.MusicCallBack(paramString1, paramString2, paramVideoCompositeCallBack));
        return;
      }
      catch (Exception paramString2) {}
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("fakeId:");
      ((StringBuilder)localObject2).append(paramPublishVideoEntry.fakeVid);
      ((StringBuilder)localObject2).append(" combine audio throw exception:");
      SLog.b((String)localObject1, ((StringBuilder)localObject2).toString(), paramString2);
      com.tencent.biz.qqstory.utils.FileUtils.g(paramString1);
      paramVideoCompositeCallBack.a(941000, "combine audio exception", "");
      return;
    }
    paramString1 = jdField_a_of_type_JavaLangString;
    paramString2 = new StringBuilder();
    paramString2.append("fakeId:");
    paramString2.append(paramPublishVideoEntry.fakeVid);
    paramString2.append(" needAndStartDownloadMusic failed code:");
    paramString2.append(((VideoCompositeHelper.RetCode)localObject1).a());
    paramString2.append(",msg:");
    paramString2.append(((VideoCompositeHelper.RetCode)localObject1).a());
    SLog.c(paramString1, paramString2.toString());
    paramVideoCompositeCallBack.a(941000, ((VideoCompositeHelper.RetCode)localObject1).a(), "");
  }
  
  public void a(@NonNull PublishVideoEntry paramPublishVideoEntry, @NonNull String paramString, boolean paramBoolean1, boolean paramBoolean2, @NonNull VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack)
  {
    AssertUtils.checkNotNull(paramPublishVideoEntry);
    AssertUtils.checkNotNull(paramString);
    AssertUtils.checkNotNull(paramVideoCompositeCallBack);
    SLog.d(jdField_a_of_type_JavaLangString, "composite create thread");
    ThreadManager.newFreeThread(new VideoCompositeHelper.1(this, paramPublishVideoEntry, paramString, paramBoolean1, paramBoolean2, paramVideoCompositeCallBack), "StoryVideoComposite", 5).start();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(PublishVideoEntry paramPublishVideoEntry, String paramString, boolean paramBoolean1, boolean paramBoolean2, VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack)
  {
    Object localObject1 = jdField_a_of_type_JavaLangString;
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
    ((StringBuilder)localObject2).append(com.tencent.biz.qqstory.utils.FileUtils.a(paramPublishVideoEntry.mLocalRawVideoDir));
    ((StringBuilder)localObject2).append(".mp4");
    Object localObject3 = ((StringBuilder)localObject2).toString();
    boolean bool = paramPublishVideoEntry.isPicture;
    int i = 0;
    int j = 0;
    localObject2 = "";
    StringBuilder localStringBuilder;
    if (bool)
    {
      localObject1 = jdField_a_of_type_JavaLangString;
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
        ((StringBuilder)localObject1).append(BitmapUtils.a(paramPublishVideoEntry.mLocalRawVideoDir));
        localObject1 = ((StringBuilder)localObject1).toString();
        j = i;
      }
    }
    else if (paramPublishVideoEntry.hwEncodeRecordVideo)
    {
      if (QLog.isColorLevel()) {
        SLog.a(jdField_a_of_type_JavaLangString, "record video, isLocal=%s , size=%s, bitrate=%s and need to encode to bitrate=%s", Boolean.valueOf(paramPublishVideoEntry.isLocalPublish), Long.valueOf(com.tencent.biz.qqstory.utils.FileUtils.a(paramPublishVideoEntry.mLocalRawVideoDir)), Integer.valueOf(VideoUtils.b(paramPublishVideoEntry.mLocalRawVideoDir)), Integer.valueOf(paramPublishVideoEntry.videoMaxrate));
      }
      i = j;
      if (paramPublishVideoEntry.isLocalPublish)
      {
        i = j;
        if (paramPublishVideoEntry.getBooleanExtra("KEY_FROM_PIC_TO_VIDEO", false))
        {
          i = j;
          if (!StringUtil.a(paramPublishVideoEntry.backgroundMusicPath))
          {
            l1 = System.currentTimeMillis();
            localObject1 = jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("fakeId:");
            localStringBuilder.append(paramPublishVideoEntry.fakeVid);
            localStringBuilder.append(" convertImageToVideo start");
            SLog.c((String)localObject1, localStringBuilder.toString());
            i = a(paramPublishVideoEntry);
            localObject1 = jdField_a_of_type_JavaLangString;
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
        localObject1 = jdField_a_of_type_JavaLangString;
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
          com.tencent.biz.qqstory.utils.FileUtils.g((String)localObject3);
          i = -14;
        }
        localObject1 = jdField_a_of_type_JavaLangString;
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
      localObject1 = jdField_a_of_type_JavaLangString;
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
              com.tencent.biz.qqstory.utils.FileUtils.g((String)localObject3);
              i = -20;
            }
          }
        }
      }
      j = i;
      localObject1 = localObject2;
      if (CaptureFreqMonitor.b)
      {
        CaptureFreqMonitor.c.a(4, System.currentTimeMillis() - l2);
        j = i;
        localObject1 = localObject2;
      }
    }
    else
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "hwEncodeRecordVideo false, return");
      localObject1 = localObject2;
      j = i;
    }
    if (j != 0)
    {
      localObject2 = jdField_a_of_type_JavaLangString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.VideoCompositeHelper
 * JD-Core Version:    0.7.0.1
 */
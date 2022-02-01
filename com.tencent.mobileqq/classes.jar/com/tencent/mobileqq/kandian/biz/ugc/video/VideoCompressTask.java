package com.tencent.mobileqq.kandian.biz.ugc.video;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.mediacodec.VideoConverterLog;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverter.Processor;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import java.io.File;
import java.util.HashMap;

public class VideoCompressTask
  extends AsyncTask<String, Void, Integer>
{
  VideoCompressTask.VideoCompressTaskListener a;
  private Long b;
  private Long c;
  private Long d;
  private Long e;
  private boolean f;
  private boolean g;
  private Context h;
  private String i;
  private String j;
  private int k;
  private int l;
  private String m;
  private String n;
  private long o;
  private long p;
  
  public VideoCompressTask(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, VideoCompressTask.VideoCompressTaskListener paramVideoCompressTaskListener)
  {
    Long localLong = Long.valueOf(0L);
    this.b = localLong;
    this.c = localLong;
    this.d = localLong;
    this.e = localLong;
    this.f = false;
    this.g = false;
    this.o = 0L;
    this.p = 0L;
    this.h = paramContext;
    this.f = paramBoolean1;
    this.g = paramBoolean2;
    this.a = paramVideoCompressTaskListener;
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    int i1 = paramInt1;
    if (paramInt1 <= paramInt2) {
      i1 = paramInt2;
    }
    paramInt2 = ReadInJoyConstants.t;
    paramInt1 = ReadInJoyHelper.N(BaseApplicationImpl.getApplication().getRuntime());
    if (paramInt1 > 0) {
      paramInt2 = paramInt1;
    }
    paramInt1 = 960;
    if (i1 >= 1280) {
      paramInt1 = 1280;
    } else if (i1 < 960) {
      paramInt1 = 640;
    }
    return (int)(paramInt2 * 1.0F / 640.0F * paramInt1);
  }
  
  @NonNull
  private Integer a(String paramString, long paramLong)
  {
    int i1 = paramString.lastIndexOf(".");
    Object localObject = Integer.valueOf(-1);
    if (i1 == -1) {
      return localObject;
    }
    this.j = ShortVideoUtils.getShortVideoCompressPath(paramString, paramString.substring(i1 + 1));
    HashMap localHashMap = a(paramString, this.h);
    if (localHashMap == null)
    {
      QLog.e("ReadInJoyUploadVideoCompressTask", 1, "dealAfterInit return for compressResult is null.");
      return localObject;
    }
    i1 = Integer.parseInt((String)localHashMap.get("ret"));
    this.j = ((String)localHashMap.get("outputPath"));
    this.k = Integer.parseInt((String)localHashMap.get("outWidth"));
    this.l = Integer.parseInt((String)localHashMap.get("outHeight"));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Before Compress file:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", after Compress file:");
      ((StringBuilder)localObject).append(this.j);
      QLog.d("ReadInJoyUploadVideoCompressTask", 2, ((StringBuilder)localObject).toString());
    }
    long l2 = System.currentTimeMillis();
    long l3 = new File(paramString).length();
    long l1 = 0L;
    if (!TextUtils.isEmpty(this.j)) {
      l1 = new File(this.j).length();
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("CompressTask，step: ShortVideoTrimmer compress ret = ");
      paramString.append(i1);
      paramString.append(", cost:");
      paramString.append(l2 - paramLong);
      paramString.append("ms, fileSourceSize=");
      paramString.append(l3);
      paramString.append(", fileTargetSize=");
      paramString.append(l1);
      QLog.d("ReadInJoyUploadVideoCompressTask", 2, paramString.toString());
    }
    this.b = Long.valueOf(l3);
    this.c = Long.valueOf(l1);
    return Integer.valueOf(i1);
  }
  
  @NonNull
  private Integer a(String paramString, File paramFile, VideoConverterConfig paramVideoConverterConfig)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", size:");
      localStringBuilder.append(paramFile.length());
      localStringBuilder.append(", no need compress");
      QLog.d("ReadInJoyUploadVideoCompressTask", 2, localStringBuilder.toString());
    }
    this.j = this.i;
    if (paramVideoConverterConfig != null) {
      a(paramString, paramVideoConverterConfig);
    }
    return Integer.valueOf(0);
  }
  
  private HashMap<String, String> a(String paramString, Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    String str = ShortVideoUtils.getShortVideoCompressPath(paramString, paramString.substring(paramString.lastIndexOf(".") + 1));
    VideoConverterConfig localVideoConverterConfig = ShortVideoTrimmer.getCompressConfig(paramString);
    if (localVideoConverterConfig == null)
    {
      QLog.e("ReadInJoyUploadVideoCompressTask", 1, "compressPosition, config = null");
      return null;
    }
    a(localVideoConverterConfig, paramString);
    boolean bool = localVideoConverterConfig.isNeedCompress;
    int i2 = 0;
    int i1 = 0;
    Object localObject1;
    if (bool)
    {
      if (Build.VERSION.SDK_INT >= 18)
      {
        MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
        localMediaMetadataRetriever.setDataSource(paramString);
        Object localObject2 = localMediaMetadataRetriever.extractMetadata(9);
        localMediaMetadataRetriever.release();
        long l1;
        try
        {
          l1 = Long.parseLong((String)localObject2);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.e("ReadInJoyUploadVideoCompressTask", 1, "compressPosition", localNumberFormatException);
          l1 = 0L;
        }
        localObject1 = new VideoCompressTask.HWCompressProcessor(this, str, (int)(localVideoConverterConfig.srcBitrate * 1024L), (int)localVideoConverterConfig.srcFrameRate, 0L, l1);
        localObject2 = new VideoConverter(new VideoConverterLog());
        ((VideoConverter)localObject2).setCompressMode(1);
        i2 = ((VideoConverter)localObject2).startCompress(paramContext, paramString, (VideoConverter.Processor)localObject1, true);
        if (i2 == 0)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, step: compress completed using MediaCodec");
            break label272;
          }
          break label272;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("CompressTask, step: compress failed using MediaCodec， compressRet:");
          ((StringBuilder)localObject1).append(i2);
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, ((StringBuilder)localObject1).toString());
        }
      }
      i1 = -1;
      label272:
      localObject1 = str;
      i2 = i1;
      if (i1 != 0)
      {
        localObject1 = str;
        i2 = i1;
        if (!TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, step: Try to compress using ShortVideoTrimmer.compressVideo");
          }
          i2 = ShortVideoTrimmer.compressVideo(paramContext, paramString, str, localVideoConverterConfig);
          localObject1 = str;
        }
      }
    }
    else
    {
      localObject1 = paramString;
    }
    localHashMap.put("outputPath", localObject1);
    localHashMap.put("ret", String.valueOf(i2));
    if (b(localVideoConverterConfig, paramString))
    {
      localHashMap.put("outWidth", String.valueOf(localVideoConverterConfig.destHeight));
      localHashMap.put("outHeight", String.valueOf(localVideoConverterConfig.destWidth));
      return localHashMap;
    }
    localHashMap.put("outWidth", String.valueOf(localVideoConverterConfig.destWidth));
    localHashMap.put("outHeight", String.valueOf(localVideoConverterConfig.destHeight));
    return localHashMap;
  }
  
  private void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append("shortvideo");
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
  }
  
  private void a(int paramInt)
  {
    this.p = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put("video_size_before_compression", this.b.toString());
    localHashMap.put("source_video_bitrate", this.d.toString());
    localHashMap.put("target_video_bitrate", this.e.toString());
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.h);
    String str = RIJQQAppInterfaceUtil.d();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStatisticCollector.collectPerformance(str, "actReadInJoyDeliverVideoCompressVideo", bool, this.p - this.o, 0L, localHashMap, "");
  }
  
  private static void a(VideoConverterConfig paramVideoConverterConfig, String paramString)
  {
    if ((paramVideoConverterConfig != null) && (paramVideoConverterConfig.isNeedCompress))
    {
      long l1 = new File(paramString).length();
      int i1 = a(paramVideoConverterConfig.srcWidth, paramVideoConverterConfig.srcHeight);
      if ((l1 <= 52428800L) && (i1 > 0) && (paramVideoConverterConfig.srcBitrate * 1024L / i1 < 1.3D))
      {
        paramVideoConverterConfig.isNeedCompress = false;
        if (QLog.isColorLevel())
        {
          paramVideoConverterConfig = new StringBuilder();
          paramVideoConverterConfig.append("CompressTask, fileSize:");
          paramVideoConverterConfig.append(l1);
          paramVideoConverterConfig.append(", no need compress!");
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, paramVideoConverterConfig.toString());
        }
      }
    }
  }
  
  private void a(String paramString, VideoConverterConfig paramVideoConverterConfig)
  {
    boolean bool = "90".equals(paramVideoConverterConfig.rotate);
    int i2 = 1;
    int i1 = i2;
    if (!bool) {
      if ("270".equals(paramVideoConverterConfig.rotate))
      {
        i1 = i2;
      }
      else
      {
        if ("0".equals(paramVideoConverterConfig.rotate))
        {
          paramString = ShortVideoTrimmer.getVideoProperty(paramString);
          if ((paramString != null) && (paramString.length == 5))
          {
            i1 = i2;
            if (paramString[3] == 90) {
              break label98;
            }
            if (paramString[3] == 270)
            {
              i1 = i2;
              break label98;
            }
          }
        }
        i1 = 0;
      }
    }
    label98:
    if (i1 != 0)
    {
      this.k = paramVideoConverterConfig.srcHeight;
      this.l = paramVideoConverterConfig.srcWidth;
      return;
    }
    this.k = paramVideoConverterConfig.srcWidth;
    this.l = paramVideoConverterConfig.srcHeight;
  }
  
  private boolean a(boolean paramBoolean, VideoConverterConfig paramVideoConverterConfig)
  {
    int i1 = a(paramVideoConverterConfig.srcWidth, paramVideoConverterConfig.srcHeight);
    this.d = Long.valueOf(paramVideoConverterConfig.srcBitrate);
    long l1 = i1;
    this.e = Long.valueOf(l1);
    boolean bool = paramBoolean;
    if (i1 > 0)
    {
      bool = paramBoolean;
      if (paramVideoConverterConfig.srcBitrate * 1024L / l1 > 1.3D) {
        bool = true;
      }
    }
    return bool;
  }
  
  private static boolean b(VideoConverterConfig paramVideoConverterConfig, String paramString)
  {
    boolean bool3 = "90".equals(paramVideoConverterConfig.rotate);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!bool3)
    {
      if ("270".equals(paramVideoConverterConfig.rotate)) {
        return true;
      }
      if ("0".equals(paramVideoConverterConfig.rotate))
      {
        paramVideoConverterConfig = ShortVideoTrimmer.getVideoProperty(paramString);
        if ((paramVideoConverterConfig != null) && (paramVideoConverterConfig.length == 5))
        {
          bool1 = bool2;
          if (paramVideoConverterConfig[3] == 90) {
            return bool1;
          }
          if (paramVideoConverterConfig[3] == 270) {
            return true;
          }
        }
      }
      bool1 = false;
    }
    return bool1;
  }
  
  protected Integer a(String... paramVarArgs)
  {
    boolean bool1 = false;
    paramVarArgs = paramVarArgs[0];
    this.a.a(0.0F);
    boolean bool2 = TextUtils.isEmpty(paramVarArgs);
    Integer localInteger = Integer.valueOf(-1);
    if ((!bool2) && (this.h != null))
    {
      this.i = paramVarArgs;
      File localFile = new File(this.i);
      VideoConverterConfig localVideoConverterConfig = ShortVideoTrimmer.getCompressConfig(this.i);
      if (localVideoConverterConfig != null) {
        bool1 = a(false, localVideoConverterConfig);
      }
      if ((localFile.exists()) && (localFile.length() <= 52428800L) && (!bool1)) {
        return a(paramVarArgs, localFile, localVideoConverterConfig);
      }
      a();
      long l1 = System.currentTimeMillis();
      if (ShortVideoTrimmer.initVideoTrim(this.h)) {
        return a(paramVarArgs, l1);
      }
      return localInteger;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyUploadVideoCompressTask", 2, "error params");
    }
    return localInteger;
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (isCancelled()) {
      return;
    }
    int i1 = paramInteger.intValue();
    int i2 = 1004;
    if (i1 != 0)
    {
      if (!this.f)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, not support shortvideo so");
        }
        paramInteger = this.a;
        i1 = i2;
        if (paramInteger != null)
        {
          paramInteger.a(1, this.b.longValue(), this.c.longValue(), null, null, 0L);
          i1 = i2;
        }
      }
      else if (!this.g)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, shortvideo so not ready");
        }
        paramInteger = this.a;
        i1 = i2;
        if (paramInteger != null)
        {
          paramInteger.a(2, this.b.longValue(), this.c.longValue(), null, null, 0L);
          i1 = i2;
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("CompressTask, compress failed, errorCode:");
          localStringBuilder.append(paramInteger);
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, localStringBuilder.toString());
        }
        paramInteger = this.a;
        i1 = i2;
        if (paramInteger != null)
        {
          paramInteger.a(3, this.b.longValue(), this.c.longValue(), null, null, 0L);
          i1 = i2;
        }
      }
    }
    else
    {
      if (TextUtils.isEmpty(this.j)) {
        paramInteger = this.i;
      } else {
        paramInteger = this.j;
      }
      this.m = paramInteger;
      paramInteger = MD5.getFileMd5(this.m);
      if (paramInteger != null) {
        this.n = new String(paramInteger);
      }
      long l1 = new File(this.m).length();
      if (QLog.isColorLevel())
      {
        paramInteger = new StringBuilder();
        paramInteger.append("CompressTask, finalSize:");
        paramInteger.append(l1);
        QLog.d("ReadInJoyUploadVideoCompressTask", 2, paramInteger.toString());
      }
      if (l1 > 314572800L)
      {
        paramInteger = this.a;
        if (paramInteger != null) {
          paramInteger.a(4, this.b.longValue(), this.c.longValue(), this.m, this.n, this.d.longValue());
        }
        i1 = 1005;
      }
      else
      {
        paramInteger = this.a;
        if (paramInteger != null) {
          paramInteger.a(0, this.b.longValue(), this.c.longValue(), this.m, this.n, this.e.longValue());
        }
        i1 = 0;
      }
    }
    a(i1);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.o = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.video.VideoCompressTask
 * JD-Core Version:    0.7.0.1
 */
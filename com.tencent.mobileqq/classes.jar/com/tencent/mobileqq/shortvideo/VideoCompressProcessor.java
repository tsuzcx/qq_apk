package com.tencent.mobileqq.shortvideo;

import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import com.tencent.image.Utils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class VideoCompressProcessor
{
  private static ConcurrentHashMap<Long, WeakReference<VideoCompressProcessor.CompressTask>> a = new ConcurrentHashMap();
  private static VideoCompressProcessor b;
  
  static
  {
    URLDrawableHelper.initVideoAIOSizeByDpc();
  }
  
  public static VideoCompressProcessor a()
  {
    if (b == null) {
      b = new VideoCompressProcessor();
    }
    return b;
  }
  
  public static void a(VideoCompressConfig.VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    a(localHashMap, paramVideoInfo);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actLongVideoInfo", true, 0L, 0L, localHashMap, "", false);
  }
  
  private static void a(HashMap<String, String> paramHashMap, VideoCompressConfig.CompressInfo paramCompressInfo)
  {
    paramHashMap.put("param_des_bps", String.valueOf(paramCompressInfo.c));
    paramHashMap.put("param_des_fps", String.valueOf(paramCompressInfo.d));
    paramHashMap.put("param_des_width", String.valueOf(paramCompressInfo.a));
    paramHashMap.put("param_des_height", String.valueOf(paramCompressInfo.b));
    paramHashMap.put("param_des_res", String.valueOf(paramCompressInfo.a * paramCompressInfo.b));
  }
  
  private static void a(HashMap<String, String> paramHashMap, VideoCompressConfig.VideoInfo paramVideoInfo)
  {
    paramHashMap.put("param_file_source_size", String.valueOf(paramVideoInfo.a));
    paramHashMap.put("param_video_duration", String.valueOf(paramVideoInfo.e));
    paramHashMap.put("param_src_bps", String.valueOf(paramVideoInfo.g));
    paramHashMap.put("param_src_fps", String.valueOf(paramVideoInfo.f));
    paramHashMap.put("param_src_width", String.valueOf(paramVideoInfo.b));
    paramHashMap.put("param_src_height", String.valueOf(paramVideoInfo.c));
    paramHashMap.put("param_src_res", String.valueOf(paramVideoInfo.b * paramVideoInfo.c));
  }
  
  public static void a(boolean paramBoolean, long paramLong1, VideoCompressConfig.VideoInfo paramVideoInfo, VideoCompressConfig.CompressInfo paramCompressInfo, long paramLong2)
  {
    if (paramVideoInfo != null)
    {
      if (paramCompressInfo == null) {
        return;
      }
      HashMap localHashMap = new HashMap();
      a(localHashMap, paramVideoInfo);
      a(localHashMap, paramCompressInfo);
      paramCompressInfo = new StringBuilder();
      paramCompressInfo.append(paramBoolean);
      paramCompressInfo.append("");
      localHashMap.put("param_compressSuccess", paramCompressInfo.toString());
      paramCompressInfo = new StringBuilder();
      paramCompressInfo.append(paramLong1);
      paramCompressInfo.append("");
      localHashMap.put("param_compressTime", paramCompressInfo.toString());
      localHashMap.put("param_file_target_sze", String.valueOf(paramLong2));
      if ((paramVideoInfo.a > 0L) && (paramLong2 > 0L)) {
        localHashMap.put("param_compress_rate", String.valueOf((float)paramLong2 / (float)paramVideoInfo.a));
      }
      if ((paramLong1 > 0L) && (paramVideoInfo.e > 0)) {
        localHashMap.put("param_compressSpeed", String.valueOf((float)paramLong1 / paramVideoInfo.e));
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actVideoCompressTime", paramBoolean, 0L, 0L, localHashMap, "", false);
      if (QLog.isColorLevel())
      {
        paramVideoInfo = new StringBuilder();
        paramVideoInfo.append("reportVideoCompressTime, success =");
        paramVideoInfo.append(paramBoolean);
        paramVideoInfo.append(", compressTime = ");
        paramVideoInfo.append(paramLong1);
        QLog.d("VideoCompressProcessor", 2, paramVideoInfo.toString());
      }
    }
  }
  
  public void a(long paramLong)
  {
    VideoCompressProcessor.CompressTask localCompressTask = b(paramLong);
    if (localCompressTask != null) {
      localCompressTask.a();
    }
    a.remove(Long.valueOf(paramLong));
  }
  
  public void a(long paramLong, VideoCompressProcessor.CompressTask paramCompressTask)
  {
    if (paramCompressTask != null)
    {
      paramCompressTask = new WeakReference(paramCompressTask);
      a.put(Long.valueOf(paramLong), paramCompressTask);
      Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)paramCompressTask.get(), new Void[0]);
    }
  }
  
  public VideoCompressProcessor.CompressTask b(long paramLong)
  {
    if (a.containsKey(Long.valueOf(paramLong)))
    {
      WeakReference localWeakReference = (WeakReference)a.get(Long.valueOf(paramLong));
      if (localWeakReference != null) {
        return (VideoCompressProcessor.CompressTask)localWeakReference.get();
      }
    }
    return null;
  }
  
  public void c(long paramLong)
  {
    VideoCompressProcessor.CompressTask localCompressTask = b(paramLong);
    if ((localCompressTask != null) && (localCompressTask.getStatus() != AsyncTask.Status.FINISHED) && (!localCompressTask.isCancelled())) {
      localCompressTask.cancel(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.VideoCompressProcessor
 * JD-Core Version:    0.7.0.1
 */
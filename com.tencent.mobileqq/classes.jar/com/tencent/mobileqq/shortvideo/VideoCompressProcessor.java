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
  private static VideoCompressProcessor jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor;
  private static ConcurrentHashMap<Long, WeakReference<VideoCompressProcessor.CompressTask>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    URLDrawableHelper.initVideoAIOSizeByDpc();
  }
  
  public static VideoCompressProcessor a()
  {
    if (jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor == null) {
      jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor = new VideoCompressProcessor();
    }
    return jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor;
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
    paramHashMap.put("param_des_bps", String.valueOf(paramCompressInfo.jdField_a_of_type_Long));
    paramHashMap.put("param_des_fps", String.valueOf(paramCompressInfo.jdField_b_of_type_Long));
    paramHashMap.put("param_des_width", String.valueOf(paramCompressInfo.jdField_a_of_type_Int));
    paramHashMap.put("param_des_height", String.valueOf(paramCompressInfo.jdField_b_of_type_Int));
    paramHashMap.put("param_des_res", String.valueOf(paramCompressInfo.jdField_a_of_type_Int * paramCompressInfo.jdField_b_of_type_Int));
  }
  
  private static void a(HashMap<String, String> paramHashMap, VideoCompressConfig.VideoInfo paramVideoInfo)
  {
    paramHashMap.put("param_file_source_size", String.valueOf(paramVideoInfo.jdField_a_of_type_Long));
    paramHashMap.put("param_video_duration", String.valueOf(paramVideoInfo.d));
    paramHashMap.put("param_src_bps", String.valueOf(paramVideoInfo.jdField_b_of_type_Long));
    paramHashMap.put("param_src_fps", String.valueOf(paramVideoInfo.e));
    paramHashMap.put("param_src_width", String.valueOf(paramVideoInfo.jdField_a_of_type_Int));
    paramHashMap.put("param_src_height", String.valueOf(paramVideoInfo.jdField_b_of_type_Int));
    paramHashMap.put("param_src_res", String.valueOf(paramVideoInfo.jdField_a_of_type_Int * paramVideoInfo.jdField_b_of_type_Int));
  }
  
  public static void a(boolean paramBoolean, long paramLong1, VideoCompressConfig.VideoInfo paramVideoInfo, VideoCompressConfig.CompressInfo paramCompressInfo, long paramLong2)
  {
    if ((paramVideoInfo == null) || (paramCompressInfo == null)) {}
    do
    {
      return;
      HashMap localHashMap = new HashMap();
      a(localHashMap, paramVideoInfo);
      a(localHashMap, paramCompressInfo);
      localHashMap.put("param_compressSuccess", paramBoolean + "");
      localHashMap.put("param_compressTime", paramLong1 + "");
      localHashMap.put("param_file_target_sze", String.valueOf(paramLong2));
      if ((paramVideoInfo.jdField_a_of_type_Long > 0L) && (paramLong2 > 0L)) {
        localHashMap.put("param_compress_rate", String.valueOf((float)paramLong2 / (float)paramVideoInfo.jdField_a_of_type_Long));
      }
      if ((paramLong1 > 0L) && (paramVideoInfo.d > 0)) {
        localHashMap.put("param_compressSpeed", String.valueOf((float)paramLong1 / paramVideoInfo.d));
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actVideoCompressTime", paramBoolean, 0L, 0L, localHashMap, "", false);
    } while (!QLog.isColorLevel());
    QLog.d("VideoCompressProcessor", 2, "reportVideoCompressTime, success =" + paramBoolean + ", compressTime = " + paramLong1);
  }
  
  public VideoCompressProcessor.CompressTask a(long paramLong)
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)))
    {
      WeakReference localWeakReference = (WeakReference)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localWeakReference != null) {
        return (VideoCompressProcessor.CompressTask)localWeakReference.get();
      }
    }
    return null;
  }
  
  public void a(long paramLong)
  {
    VideoCompressProcessor.CompressTask localCompressTask = a(paramLong);
    if (localCompressTask != null) {
      localCompressTask.a();
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
  }
  
  public void a(long paramLong, VideoCompressProcessor.CompressTask paramCompressTask)
  {
    if (paramCompressTask != null)
    {
      paramCompressTask = new WeakReference(paramCompressTask);
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), paramCompressTask);
      Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)paramCompressTask.get(), new Void[0]);
    }
  }
  
  public void b(long paramLong)
  {
    VideoCompressProcessor.CompressTask localCompressTask = a(paramLong);
    if ((localCompressTask != null) && (localCompressTask.getStatus() != AsyncTask.Status.FINISHED) && (!localCompressTask.isCancelled())) {
      localCompressTask.cancel(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.VideoCompressProcessor
 * JD-Core Version:    0.7.0.1
 */
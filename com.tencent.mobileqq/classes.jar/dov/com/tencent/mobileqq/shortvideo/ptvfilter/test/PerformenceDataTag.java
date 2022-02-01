package dov.com.tencent.mobileqq.shortvideo.ptvfilter.test;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.common.GloableValue;
import java.util.HashMap;

public class PerformenceDataTag
{
  public static void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("MANUFACTURER", Build.MANUFACTURER);
    localHashMap.put("MODEL", Build.MODEL);
    localHashMap.put("SDK_INT", "" + Build.VERSION.SDK_INT);
    localHashMap.put("crashKind", "" + paramInt);
    StatisticCollector.getInstance(VideoEnvironment.getContext()).collectPerformance(null, "sv_filter_egl_crash_exp", true, 0L, 0L, localHashMap, "");
  }
  
  public static void a(String paramString, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("MANUFACTURER", Build.MANUFACTURER);
    localHashMap.put("MODEL", Build.MODEL);
    localHashMap.put("SDK_INT", "" + Build.VERSION.SDK_INT);
    localHashMap.put("time", "" + paramLong);
    localHashMap.put("filter_id", PtvFilterTimeStatistics.jdField_a_of_type_JavaLangString);
    localHashMap.put("front_camera", String.valueOf(PtvFilterTimeStatistics.jdField_a_of_type_Boolean));
    StatisticCollector.getInstance(VideoEnvironment.getContext()).collectPerformance(null, paramString, true, paramLong, GloableValue.c, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.d("PerformenceDataTag", 2, "reportPerformance : tag = " + paramString + " ; duration = " + paramLong + " ; filter_id = " + PtvFilterTimeStatistics.jdField_a_of_type_JavaLangString + " ; front_camera = " + PtvFilterTimeStatistics.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ptvfilter.test.PerformenceDataTag
 * JD-Core Version:    0.7.0.1
 */
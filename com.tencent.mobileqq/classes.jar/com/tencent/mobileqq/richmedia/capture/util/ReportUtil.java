package com.tencent.mobileqq.richmedia.capture.util;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.ShortVideoMtaReport;
import com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.cache.ImageMemoryManager;
import java.util.HashMap;
import java.util.Properties;

public class ReportUtil
{
  public static int a;
  public static long a;
  public static String a;
  public static boolean a;
  public static int b;
  
  private static String a()
  {
    if (jdField_a_of_type_Int % 180 == 0) {
      return "0";
    }
    return "1";
  }
  
  public static void a()
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaLangString = null;
    jdField_a_of_type_Int = 90;
    b = 2;
    jdField_a_of_type_Long = 0L;
  }
  
  public static void a(int paramInt, String paramString)
  {
    try
    {
      long l = MediaUtil.a(paramString);
      if (l == 0L) {}
      for (float f = -1.0F;; f = paramInt * 1000.0F / (float)l)
      {
        StatisticCollector.a(BaseApplication.getContext()).a(null, "capture_video_fps", false, f, 0L, null, "");
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
        if (paramInt2 == -1)
        {
          if (jdField_a_of_type_Boolean)
          {
            FlowCameraMqqAction.a("", "0X80072C5", b(), jdField_a_of_type_JavaLangString, "", "");
            return;
          }
          FlowCameraMqqAction.a("", "0X80072C4", b());
          return;
        }
      } while (paramInt2 != 0);
      if (jdField_a_of_type_Boolean)
      {
        FlowCameraMqqAction.b("", "0X80072C6");
        return;
      }
      FlowCameraMqqAction.b("", "0X80072C7");
      return;
      if (paramInt2 == -1)
      {
        paramActivity = new Properties();
        paramActivity.setProperty("shortvideo_duration", String.valueOf(jdField_a_of_type_Long));
        paramActivity.setProperty("shortvideo_rotation", a());
        paramActivity.setProperty("shortvideo_camera", b());
        if (!jdField_a_of_type_Boolean)
        {
          FlowCameraMqqAction.a("", "0X8006A16", String.valueOf(jdField_a_of_type_Long), a(), b(), "");
          ShortVideoMtaReport.a("shortvideo_send_noeffects", paramActivity);
          return;
        }
        FlowCameraMqqAction.a("", "0X8006A19", String.valueOf(jdField_a_of_type_Long), a(), b(), jdField_a_of_type_JavaLangString);
        ShortVideoMtaReport.a("shortvideo_send_effects", paramActivity);
        return;
      }
    } while (paramInt2 != 0);
    if (jdField_a_of_type_Boolean)
    {
      FlowCameraMqqAction.b("", "0X8006A1B");
      return;
    }
    FlowCameraMqqAction.b("", "0X8006A17");
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      FlowCameraMqqAction.a("", "0X8007BB7", str);
      return;
    }
  }
  
  private static String b()
  {
    if (b == 1) {
      return "1";
    }
    return "0";
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Boolean)
    {
      FlowCameraMqqAction.a("", "0X80072C3", b(), jdField_a_of_type_JavaLangString, "", "");
      return;
    }
    FlowCameraMqqAction.a("", "0X80072C2", b());
  }
  
  public static void c()
  {
    if (jdField_a_of_type_Boolean)
    {
      FlowCameraMqqAction.a("", "0X8006A18", String.valueOf(jdField_a_of_type_Long), a(), b(), jdField_a_of_type_JavaLangString);
      return;
    }
    FlowCameraMqqAction.a("", "0X8006A13", String.valueOf(jdField_a_of_type_Long), a(), b(), "");
  }
  
  public static void d()
  {
    FlowCameraMqqAction.b("", "0X80072C1");
  }
  
  public static void e()
  {
    FlowCameraMqqAction.b("", "0X8006A12");
  }
  
  public static void f()
  {
    FlowCameraMqqAction.b("", "0X8006A15");
    ShortVideoMtaReport.a("shortvideo_rotate_camera", null);
  }
  
  public static void g()
  {
    long l1;
    long l2;
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      l1 = Runtime.getRuntime().maxMemory();
      l2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
      if ((l1 <= 0L) || (l2 <= 0L)) {
        break label327;
      }
    }
    label327:
    for (int i = (int)((float)l2 / (float)l1 * 100.0F);; i = 0)
    {
      int j = ImageMemoryManager.getInstance().mHitCount + ImageMemoryManager.getInstance().mUnHitCount;
      if (j > 0) {}
      for (float f1 = ImageMemoryManager.getInstance().mHitCount / j;; f1 = 0.0F)
      {
        if ((ImageMemoryManager.getInstance().mUnHitCount > 0) && (ImageMemoryManager.getInstance().decodeTime > 0.0F)) {}
        for (float f2 = ImageMemoryManager.getInstance().decodeTime / ImageMemoryManager.getInstance().mUnHitCount;; f2 = 0.0F)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("param_effectsId", jdField_a_of_type_JavaLangString);
          localHashMap.put("param_memory", String.valueOf(i));
          localHashMap.put("param_hitRate", String.valueOf(f1));
          localHashMap.put("param_decodeTime", String.valueOf(f2));
          if (QLog.isColorLevel()) {
            QLog.i("reportPtuSdkPerformance", 2, "id:" + jdField_a_of_type_JavaLangString + ", memoryUsage:" + i + ", hitRate:" + f1 + ", decodeTime:" + f2 + ", cacheSize:" + ImageMemoryManager.getInstance().getCacheSize() + ", maxSize:" + l1 / 1024L / 1024L);
          }
          StatisticCollector.a(BaseApplicationImpl.getContext()).a(null, "act_ptu_sdk_performance", true, i, 0L, localHashMap, "");
          StatisticCollector.a(BaseApplicationImpl.getContext()).a(null, "act_ptu_cache_hit_Rate", true, (int)(100.0F * f1), 0L, localHashMap, "");
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.ReportUtil
 * JD-Core Version:    0.7.0.1
 */
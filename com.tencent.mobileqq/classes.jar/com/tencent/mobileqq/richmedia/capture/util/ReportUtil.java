package com.tencent.mobileqq.richmedia.capture.util;

import android.app.Activity;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;

public class ReportUtil
{
  public static boolean a = false;
  public static String b;
  public static int c;
  public static int d;
  public static long e;
  
  public static void a()
  {
    if (a)
    {
      FlowCameraMqqAction.a("", "0X80072C3", d(), b, "", "");
      return;
    }
    FlowCameraMqqAction.a("", "0X80072C2", d());
  }
  
  public static void a(int paramInt, String paramString)
  {
    try
    {
      long l = MediaUtil.a(paramString);
      float f;
      if (l == 0L) {
        f = -1.0F;
      } else {
        f = paramInt * 1000.0F / (float)l;
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "capture_video_fps", false, f, 0L, null, "");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1012)
    {
      if ((paramInt1 != 10000) && (paramInt1 != 10007) && (paramInt1 != 10003) && (paramInt1 != 10004)) {
        return;
      }
      if (paramInt2 == -1)
      {
        if (!a)
        {
          FlowCameraMqqAction.a("", "0X8006A16", String.valueOf(e), c(), d(), "");
          return;
        }
        FlowCameraMqqAction.a("", "0X8006A19", String.valueOf(e), c(), d(), b);
        return;
      }
      if (paramInt2 == 0)
      {
        if (a)
        {
          FlowCameraMqqAction.a("", "0X8006A1B");
          return;
        }
        FlowCameraMqqAction.a("", "0X8006A17");
      }
    }
    else
    {
      if (paramInt2 == -1)
      {
        if (a)
        {
          FlowCameraMqqAction.a("", "0X80072C5", d(), b, "", "");
          return;
        }
        FlowCameraMqqAction.a("", "0X80072C4", d());
        return;
      }
      if (paramInt2 == 0)
      {
        if (a)
        {
          FlowCameraMqqAction.a("", "0X80072C6");
          return;
        }
        FlowCameraMqqAction.a("", "0X80072C7");
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "1";
    } else {
      str = "0";
    }
    FlowCameraMqqAction.a("", "0X8007BB7", str);
  }
  
  public static void b()
  {
    if (a)
    {
      FlowCameraMqqAction.a("", "0X8006A18", String.valueOf(e), c(), d(), b);
      return;
    }
    FlowCameraMqqAction.a("", "0X8006A13", String.valueOf(e), c(), d(), "");
  }
  
  private static String c()
  {
    if (c % 180 == 0) {
      return "0";
    }
    return "1";
  }
  
  private static String d()
  {
    if (d == 1) {
      return "1";
    }
    return "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.ReportUtil
 * JD-Core Version:    0.7.0.1
 */
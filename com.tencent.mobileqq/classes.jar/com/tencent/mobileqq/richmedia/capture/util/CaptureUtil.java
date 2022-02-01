package com.tencent.mobileqq.richmedia.capture.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CaptureUtil
{
  public static int a = -1;
  public static int b = -1;
  public static boolean c = false;
  public static boolean d = false;
  public static boolean e = false;
  
  public static int a(int paramInt)
  {
    int j = paramInt % 16;
    int i = paramInt;
    if (j != 0)
    {
      if (j < 8) {
        return paramInt - j;
      }
      i = paramInt + (16 - j);
    }
    return i;
  }
  
  public static DisplayMetrics a(Context paramContext)
  {
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      return localDisplayMetrics;
    }
    catch (Exception paramContext)
    {
      label28:
      break label28;
    }
    return null;
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder;
    if ((!paramBoolean2) && (d == paramBoolean1))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("no need to update ,update recognition result : ");
        localStringBuilder.append(paramBoolean1);
        localStringBuilder.append(" force : ");
        localStringBuilder.append(paramBoolean2);
        QLog.d("CaptureUtil", 2, localStringBuilder.toString());
      }
      return;
    }
    d = paramBoolean1;
    SharedPreUtils.a(BaseApplicationImpl.getApplication().getSharedPreferences("CaptureUtil", 4).edit().putBoolean("capture_shared_gesture_recognize_result", paramBoolean1));
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("update sp ,update recognition result : ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" force : ");
      localStringBuilder.append(paramBoolean2);
      QLog.d("CaptureUtil", 2, localStringBuilder.toString());
    }
  }
  
  public static boolean a()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool1 = true;
    if (i < 21)
    {
      i = 1;
      bool1 = false;
    }
    else
    {
      i = 0;
    }
    if (!((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).isSwitchOpen())
    {
      i = 2;
      bool1 = false;
    }
    int j = i;
    boolean bool2 = bool1;
    if (Build.MODEL.equals("GT-I9500"))
    {
      j = i;
      bool2 = bool1;
      if (Build.VERSION.SDK_INT == 18)
      {
        j = 6;
        bool2 = false;
      }
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("param_FailCode", Integer.toString(j));
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(null, "actMediaCodecSupport", bool2, 0L, 0L, (HashMap)localObject, "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mediacodec isMediaCodecSupport:");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append(", code:");
      ((StringBuilder)localObject).append(j);
      QLog.i("CaptureUtil", 2, ((StringBuilder)localObject).toString());
    }
    return bool2;
  }
  
  public static int[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > paramInt1) {
      return new int[] { a((int)(paramInt2 * (paramInt1 * 1.0F / paramInt3))), paramInt1 };
    }
    return new int[] { paramInt2, paramInt3 };
  }
  
  public static int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    float f1 = paramInt1;
    int i = a((int)(f1 * paramFloat));
    float f2 = paramInt2;
    int j = a((int)(f2 * paramFloat));
    f1 = f2 * 1.0F / f1;
    f2 = paramInt4 * 1.0F / paramInt3;
    if (f1 > f2) {
      j = a((int)(i * f2));
    } else {
      i = a((int)(j / f2));
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clipVideoSize(");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(",");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append(",");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(") = (");
      localStringBuilder.append(i);
      localStringBuilder.append(",");
      localStringBuilder.append(j);
      localStringBuilder.append(")");
      QLog.d("CaptureUtil", 2, localStringBuilder.toString());
    }
    return new int[] { i, j };
  }
  
  public static int b(int paramInt)
  {
    int i = 0;
    if (paramInt != 0)
    {
      if (paramInt != 90)
      {
        if (paramInt != 180)
        {
          if (paramInt != 270) {
            return 0;
          }
          return 180;
        }
        return 90;
      }
    }
    else {
      i = 270;
    }
    return i;
  }
  
  public static boolean b()
  {
    for (;;)
    {
      boolean bool2;
      boolean bool3;
      boolean bool4;
      try
      {
        if (!c)
        {
          if (((IAEResUtil)QRoute.api(IAEResUtil.class)).isLightCameraBaseResNotAllExist()) {
            break label248;
          }
          bool1 = true;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("PtvFilterSoLoad.getFilterSoState result = ");
          localStringBuilder.append(bool1);
          AEQLog.d("CaptureUtil", localStringBuilder.toString());
          AEQLog.d("CaptureUtil", "[loadEffectSo] base so load start ");
          if (bool1)
          {
            bool2 = ((IAEResUtil)QRoute.api(IAEResUtil.class)).loadAEBaseSo();
            bool3 = ((IAEResUtil)QRoute.api(IAEResUtil.class)).isFilterFaceSoVersionOK();
            if ((!bool2) || (!bool3)) {
              break label253;
            }
            i = 1;
            a = i;
            break label258;
          }
          a = 2;
          bool2 = false;
          bool3 = false;
          break label258;
          c = bool4;
          AEQLog.d("CaptureUtil", "[loadEffectSo] base so load end ");
          if (QLog.isColorLevel()) {
            QLog.d("CaptureUtil", 2, new Object[] { "loadEffectSo, ", Boolean.valueOf(c), "  ptuSo:", Boolean.valueOf(bool2), "  ptuSoVersion:", Boolean.valueOf(bool3), " result:", Boolean.valueOf(bool1), "  PTV_FILTER_SO_LOADED:", Integer.valueOf(a) });
          }
        }
        bool1 = c;
        return bool1;
      }
      finally {}
      label248:
      boolean bool1 = false;
      continue;
      label253:
      int i = 0;
      continue;
      label258:
      if ((bool2) && (bool3)) {
        bool4 = true;
      } else {
        bool4 = false;
      }
    }
  }
  
  public static int c(int paramInt)
  {
    return (paramInt + 45) / 90 * 90;
  }
  
  public static boolean c()
  {
    String str1 = Build.CPU_ABI;
    String str2 = Build.CPU_ABI2;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isX86Platform: Build.CPU_ABI=");
      localStringBuilder.append(str1);
      localStringBuilder.append(" Build.CPU_ABI2=");
      localStringBuilder.append(str2);
      QLog.d("CaptureUtil", 2, localStringBuilder.toString());
    }
    if ((str1 != null) && (!"".equals(str1)) && ("x86".equalsIgnoreCase(str1))) {
      return true;
    }
    if (VcSystemInfo.getCpuArchitecture() == 7)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureUtil", 2, "isX86Platform: VcSystemInfo.getCpuArchitecture()=x86");
      }
      return true;
    }
    return false;
  }
  
  public static boolean d()
  {
    return c() ^ true;
  }
  
  public static boolean e()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("CaptureUtil", 4).getBoolean("capture_shared_gesture_recognize_result", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.CaptureUtil
 * JD-Core Version:    0.7.0.1
 */
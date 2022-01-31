package com.tencent.mobileqq.richmedia.capture.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.shortvideo.util.SoLoader;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class CaptureUtil
{
  public static int a;
  public static boolean a;
  public static int b = -1;
  public static boolean b;
  private static boolean c;
  
  static
  {
    jdField_a_of_type_Int = -1;
  }
  
  public static int a(int paramInt)
  {
    int i = paramInt;
    if (paramInt % 16 != 0)
    {
      if (paramInt % 16 < 8) {
        i = paramInt - paramInt % 16;
      }
    }
    else {
      return i;
    }
    return paramInt + (16 - paramInt % 16);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean2) && (jdField_a_of_type_Boolean == paramBoolean1)) {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureUtil", 2, "no need to update ,update recognition result : " + paramBoolean1 + " force : " + paramBoolean2);
      }
    }
    do
    {
      return;
      jdField_a_of_type_Boolean = paramBoolean1;
      SharedPreUtils.a(BaseApplicationImpl.getApplication().getSharedPreferences("CaptureUtil", 4).edit().putBoolean("capture_shared_gesture_recognize_result", paramBoolean1));
    } while (!QLog.isColorLevel());
    QLog.d("CaptureUtil", 2, "update sp ,update recognition result : " + paramBoolean1 + " force : " + paramBoolean2);
  }
  
  public static boolean a()
  {
    int i = 1;
    boolean bool1;
    if (Build.VERSION.SDK_INT < 18) {
      bool1 = false;
    }
    for (;;)
    {
      if (!MediaCodecDPC.a())
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
      if (BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("sp_mc_crash_times", 0) >= 2) {
        i = 5;
      }
      for (bool1 = false;; bool1 = bool2)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_FailCode", Integer.toString(i));
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(null, "actMediaCodecSupport", bool1, 0L, 0L, localHashMap, "");
        if (QLog.isColorLevel()) {
          QLog.i("CaptureUtil", 2, "mediacodec isMediaCodecSupport:" + bool1 + ", code:" + i);
        }
        return bool1;
        i = j;
      }
      bool1 = true;
      i = 0;
    }
  }
  
  public static int[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > paramInt1) {
      return new int[] { a((int)(paramInt2 * (1.0F * paramInt1 / paramInt3))), paramInt1 };
    }
    return new int[] { paramInt2, paramInt3 };
  }
  
  public static int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    int j = a((int)(paramInt1 * paramFloat));
    int i = a((int)(paramInt2 * paramFloat));
    float f1 = paramInt2 * 1.0F / paramInt1;
    float f2 = paramInt4 * 1.0F / paramInt3;
    if (f1 > f2) {
      i = a((int)(j * f2));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureUtil", 2, "clipVideoSize(" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4 + "," + paramFloat + ") = (" + j + "," + i + ")");
      }
      return new int[] { j, i };
      j = a((int)(i / f2));
    }
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 90: 
    default: 
      return 0;
    case 0: 
      return 270;
    case 180: 
      return 90;
    }
    return 180;
  }
  
  public static boolean b()
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        if (!c)
        {
          boolean bool2 = GraphicRenderMgr.loadSo();
          boolean bool3 = PtvFilterSoLoad.a(BaseApplicationImpl.getContext(), false);
          boolean bool4 = PtvFilterSoLoad.a();
          if (!PtvFilterSoLoad.a(BaseApplicationImpl.getContext())) {
            continue;
          }
          if ((bool3) && (bool4))
          {
            i = 1;
            jdField_a_of_type_Int = i;
            if (QLog.isColorLevel()) {
              QLog.d("CaptureUtil", 2, "PTV_FILTER_SO_LOADED : " + jdField_a_of_type_Int);
            }
            if (!PtvFilterSoLoad.e()) {
              break label164;
            }
            if (!SoLoader.h()) {
              break label154;
            }
            break label164;
            d();
            if ((!bool2) || (!bool3) || (!bool4) || (i == 0)) {
              break label159;
            }
            c = bool1;
          }
        }
        else
        {
          bool1 = c;
          return bool1;
        }
        i = 0;
        continue;
        jdField_a_of_type_Int = 2;
        continue;
        i = 0;
      }
      finally {}
      label154:
      continue;
      label159:
      bool1 = false;
      continue;
      label164:
      int i = 1;
    }
  }
  
  public static int c(int paramInt)
  {
    return (paramInt + 45) / 90 * 90;
  }
  
  public static boolean c()
  {
    boolean bool1 = true;
    for (;;)
    {
      boolean bool2;
      boolean bool3;
      boolean bool4;
      try
      {
        if (!c)
        {
          bool2 = GraphicRenderMgr.loadSo();
          bool3 = PtvFilterSoLoad.a(BaseApplicationImpl.getContext(), false);
          bool4 = PtvFilterSoLoad.a();
          if (!PtvFilterSoLoad.a(BaseApplicationImpl.getContext())) {
            continue;
          }
          if ((bool3) && (bool4))
          {
            i = 1;
            jdField_a_of_type_Int = i;
            break label93;
            c = bool1;
          }
        }
        else
        {
          bool1 = c;
          return bool1;
        }
        int i = 0;
        continue;
        jdField_a_of_type_Int = 2;
      }
      finally {}
      label93:
      while ((!bool2) || (!bool3) || (!bool4))
      {
        bool1 = false;
        break;
      }
    }
  }
  
  public static boolean d()
  {
    boolean bool = SoLoader.a(BaseApplicationImpl.getContext());
    int i;
    if (PtvFilterSoLoad.b(BaseApplicationImpl.getContext())) {
      if (bool)
      {
        i = 1;
        b = i;
      }
    }
    for (;;)
    {
      if (b != 1) {
        break label63;
      }
      return true;
      i = 0;
      break;
      if (QmcfManager.a().d()) {
        b = 2;
      } else {
        b = 3;
      }
    }
    label63:
    return false;
  }
  
  public static boolean e()
  {
    String str1 = Build.CPU_ABI;
    String str2 = Build.CPU_ABI2;
    if (QLog.isColorLevel()) {
      QLog.d("CaptureUtil", 2, "isX86Platform: Build.CPU_ABI=" + str1 + " Build.CPU_ABI2=" + str2);
    }
    if ((str1 != null) && (!"".equals(str1)) && ("x86".equalsIgnoreCase(str1))) {}
    do
    {
      return true;
      if (VcSystemInfo.f() != 7) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("CaptureUtil", 2, "isX86Platform: VcSystemInfo.getCpuArchitecture()=x86");
    return true;
    return false;
  }
  
  public static boolean f()
  {
    return !e();
  }
  
  public static boolean g()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("CaptureUtil", 4).getBoolean("capture_shared_gesture_recognize_result", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.CaptureUtil
 * JD-Core Version:    0.7.0.1
 */
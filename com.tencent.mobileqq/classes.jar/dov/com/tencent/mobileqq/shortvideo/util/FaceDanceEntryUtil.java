package dov.com.tencent.mobileqq.shortvideo.util;

import android.os.Build;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.gesture.GestureMgr;

public class FaceDanceEntryUtil
{
  public static String[] a = { "Le X620", "Nexus 5X", "ZTE A2017", "PRA-AL00X", "SM-W2015", "Redmi Note 3", "R7Plus", "vivo X6Plus A" };
  
  public static boolean a()
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].contains(str)) {
          bool1 = true;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("FaceDanceEntryUtil", 2, "isPhoneInBlackList ： phone = " + str + ", result=" + bool1);
        }
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean b()
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (MediaCodecDPC.g())
    {
      bool1 = bool3;
      if (!a())
      {
        if (!EffectsRenderController.a(8, 1400000L))
        {
          bool1 = bool2;
          if (!EffectsRenderController.a(4, 2150000L)) {}
        }
        else
        {
          bool1 = true;
        }
        QLog.d("FaceDanceEntryUtil", 2, "FaceDanceEntryUtil check condition 2 +cpuNumber is" + bool1);
      }
    }
    return bool1;
  }
  
  public static boolean c()
  {
    return (b()) && (GestureMgr.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.FaceDanceEntryUtil
 * JD-Core Version:    0.7.0.1
 */
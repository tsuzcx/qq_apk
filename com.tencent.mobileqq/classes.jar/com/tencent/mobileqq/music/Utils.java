package com.tencent.mobileqq.music;

import android.os.Build;
import com.tencent.qphone.base.util.QLog;

public class Utils
{
  public static String[] a = { "samsung SM-N7508V", "samsung SM-N9002", "samsung SM-N9005", "samsung SM-N9006", "samsung SM-N9008", "samsung SM-N9009", "samsung SM-N9009V", "samsung SM-G3858", "samsung SM-G7108V", "samsung SM-G7108U", "samsung SM-G9008V", "samsung GT-I9308I", "samsung GT-I9508V", "samsung SM-G3588V", "samsung SM-T2558", "samsung SM-G9300", "HTC T528w", "MI 3", "HTC 802t", "GT-I9100", "GT-I9300", "SCH-I939", "MX4", "HUAWEI C8813D" };
  
  public static boolean a()
  {
    String str = Build.MODEL;
    Object localObject = a;
    int j = localObject.length;
    boolean bool2 = false;
    int i = 0;
    boolean bool1;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      if (localObject[i].contains(str))
      {
        bool1 = true;
        break;
      }
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isPhoneInWhiteList ： phone = ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(", result=");
      ((StringBuilder)localObject).append(bool1);
      QLog.d("QQPlayerService", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.music.Utils
 * JD-Core Version:    0.7.0.1
 */
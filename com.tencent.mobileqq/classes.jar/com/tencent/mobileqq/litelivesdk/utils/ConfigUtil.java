package com.tencent.mobileqq.litelivesdk.utils;

import android.os.Build;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ConfigUtil
{
  public static boolean a(ArrayList<String> paramArrayList)
  {
    try
    {
      String str = Build.MODEL;
      if ((str == null) || (str.length() == 0))
      {
        QLog.i("ConfigUtil", 1, "buildModel is empty,not show float items.命中禁止策略");
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConfigUtil", 2, "buildModel is '" + str + "'");
      }
      if ((paramArrayList != null) && (paramArrayList.size() != 0))
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          if (((String)paramArrayList.next()).equals(str))
          {
            QLog.d("ConfigUtil", 1, "命中禁止黑名单策略");
            return true;
          }
        }
        return false;
      }
    }
    catch (Throwable paramArrayList)
    {
      QLog.e("ConfigUtil", 1, "黑名单检查异常 " + paramArrayList);
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.ConfigUtil
 * JD-Core Version:    0.7.0.1
 */
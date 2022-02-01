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
      localObject = Build.MODEL;
      if ((localObject != null) && (((String)localObject).length() != 0))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("buildModel is '");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("'");
          QLog.d("ConfigUtil", 2, localStringBuilder.toString());
        }
        if (paramArrayList != null)
        {
          if (paramArrayList.size() == 0) {
            return false;
          }
          paramArrayList = paramArrayList.iterator();
        }
      }
      else
      {
        while (paramArrayList.hasNext()) {
          if (((String)paramArrayList.next()).equals(localObject))
          {
            QLog.d("ConfigUtil", 1, "命中禁止黑名单策略");
            return true;
            QLog.i("ConfigUtil", 1, "buildModel is empty,not show float items.命中禁止策略");
            return true;
          }
        }
      }
    }
    catch (Throwable paramArrayList)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("黑名单检查异常 ");
      ((StringBuilder)localObject).append(paramArrayList);
      QLog.e("ConfigUtil", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.ConfigUtil
 * JD-Core Version:    0.7.0.1
 */
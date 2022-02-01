package com.tencent.mobileqq.utils;

import android.app.ActivityManager;
import android.os.Debug.MemoryInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class MemoryUtils
{
  public static long a(int paramInt)
  {
    try
    {
      Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)MobileQQ.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { paramInt });
      if ((arrayOfMemoryInfo != null) && (arrayOfMemoryInfo.length > 0))
      {
        int i = arrayOfMemoryInfo[0].getTotalPss();
        return i * 1024L;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MemoryUtils", 2, "getMemory ex pid=" + paramInt, localException);
      }
      return 62914560L;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MemoryUtils", 2, new Object[] { "getMemory OutOfMemoryError pid=", Integer.valueOf(paramInt), localOutOfMemoryError });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.MemoryUtils
 * JD-Core Version:    0.7.0.1
 */
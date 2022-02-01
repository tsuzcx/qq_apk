package com.tencent.qapmsdk.qqbattery;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.thread.ThreadTool;
import com.tencent.qapmsdk.common.util.FileUtil;
import java.io.File;

class BatteryLog$LogHandler
  extends Handler
{
  private BatteryLog$LogHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(@NonNull Message paramMessage)
  {
    Object localObject1;
    Object localObject2;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      BatteryLog.access$102(BatteryLog.access$200() + BatteryLog.access$300() + "_" + BatteryLog.access$400() + ".log");
      BatteryLog.access$502(BatteryLog.access$200() + BatteryLog.access$300() + "_" + BatteryLog.access$400() + ".rpt");
      paramMessage = new File(BatteryLog.access$200());
      localObject1 = new File(BatteryLog.access$100());
      localObject2 = new File(BatteryLog.access$500());
      try
      {
        paramMessage.mkdirs();
        ((File)localObject1).delete();
        ((File)localObject2).delete();
        BatteryLog.writeCommonLog(new Object[] { "header", BaseInfo.userMeta.version, BatteryLog.access$600(), "pub", BaseInfo.userMeta.uuid, Build.MANUFACTURER, Build.MODEL, Integer.valueOf(Build.VERSION.SDK_INT), Long.valueOf(BatteryLog.access$400()), "1.3" });
        Logger.INSTANCE.d(new String[] { "QAPM_battery_BatteryLog", "start LogHandler init" });
        return;
      }
      catch (Throwable paramMessage)
      {
        for (;;)
        {
          Logger.INSTANCE.w(new String[] { "QAPM_battery_BatteryLog", "init LogHandler may be error, ", paramMessage.getMessage() });
        }
      }
    }
    for (;;)
    {
      int j;
      try
      {
        localObject1 = new File(BatteryLog.access$200()).listFiles();
        j = localObject1.length;
        i = 0;
        if (i < j)
        {
          localObject2 = localObject1[i];
          try
          {
            long l = FileUtil.getLastModifiedTime((File)localObject2);
            if ((l != -1L) && (l > ((Long)paramMessage.obj).longValue())) {
              break label636;
            }
            ((File)localObject2).delete();
          }
          catch (Throwable localThrowable)
          {
            Logger.INSTANCE.w(new String[] { "QAPM_battery_BatteryLog", "delete file may be error, file name = ", ((File)localObject2).getName() });
          }
        }
        if (paramMessage.arg1 != 0) {
          break label549;
        }
      }
      catch (Throwable paramMessage)
      {
        Logger.INSTANCE.w(new String[] { "QAPM_battery_BatteryLog", "clean log file may be error" });
        Logger.INSTANCE.d(new String[] { "QAPM_battery_BatteryLog", "start MSG_CLEAN" });
        return;
      }
      localObject1 = BatteryLog.access$100();
      localObject2 = ThreadTool.getReuseStringBuilder();
      Object[] arrayOfObject = (Object[])paramMessage.obj;
      int k = arrayOfObject.length;
      int i = 0;
      for (;;)
      {
        if (i >= k) {
          break label577;
        }
        Object localObject3 = arrayOfObject[i];
        if ((localObject3 instanceof Object[]))
        {
          localObject3 = (Object[])localObject3;
          int m = localObject3.length;
          j = 0;
          while (j < m)
          {
            ((StringBuilder)localObject2).append(localObject3[j]);
            j += 1;
          }
          label549:
          localObject1 = BatteryLog.access$500();
          break;
        }
        ((StringBuilder)localObject2).append(localObject3).append("|");
        i += 1;
      }
      label577:
      ((StringBuilder)localObject2).append("\r\n");
      FileUtil.writeFile((String)localObject1, ((StringBuilder)localObject2).toString(), true);
      Logger.INSTANCE.i(new String[] { "QAPM_battery_BatteryLog", " start MSG_WRITE ", String.valueOf(paramMessage.arg1), ((StringBuilder)localObject2).toString() });
      return;
      label636:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.BatteryLog.LogHandler
 * JD-Core Version:    0.7.0.1
 */
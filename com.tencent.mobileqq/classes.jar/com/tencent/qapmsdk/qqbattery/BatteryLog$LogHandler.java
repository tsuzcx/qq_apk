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
    int i = paramMessage.what;
    if (i != 0)
    {
      int j;
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        if (paramMessage.arg1 == 0) {
          localObject1 = BatteryLog.access$100();
        } else {
          localObject1 = BatteryLog.access$500();
        }
        localObject2 = ThreadTool.getReuseStringBuilder();
        Object[] arrayOfObject = (Object[])paramMessage.obj;
        int k = arrayOfObject.length;
        i = 0;
        while (i < k)
        {
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
          }
          ((StringBuilder)localObject2).append(localObject3);
          ((StringBuilder)localObject2).append("|");
          i += 1;
        }
        ((StringBuilder)localObject2).append("\r\n");
        FileUtil.writeFile((String)localObject1, ((StringBuilder)localObject2).toString(), true);
        Logger.INSTANCE.i(new String[] { "QAPM_battery_BatteryLog", " start MSG_WRITE ", String.valueOf(paramMessage.arg1), ((StringBuilder)localObject2).toString() });
        return;
      }
      for (;;)
      {
        try
        {
          localObject1 = new File(BatteryLog.access$200()).listFiles();
          j = localObject1.length;
          i = 0;
          if (i < j) {
            localObject2 = localObject1[i];
          }
        }
        catch (Throwable paramMessage)
        {
          long l;
          continue;
        }
        try
        {
          l = FileUtil.getLastModifiedTime((File)localObject2);
          if ((l != -1L) && (l > ((Long)paramMessage.obj).longValue())) {
            continue;
          }
          ((File)localObject2).delete();
        }
        catch (Throwable localThrowable)
        {
          continue;
        }
        Logger.INSTANCE.w(new String[] { "QAPM_battery_BatteryLog", "delete file may be error, file name = ", ((File)localObject2).getName() });
        i += 1;
      }
      Logger.INSTANCE.w(new String[] { "QAPM_battery_BatteryLog", "clean log file may be error" });
      Logger.INSTANCE.d(new String[] { "QAPM_battery_BatteryLog", "start MSG_CLEAN" });
      return;
    }
    paramMessage = new StringBuilder();
    paramMessage.append(BatteryLog.access$200());
    paramMessage.append(BatteryLog.access$300());
    paramMessage.append("_");
    paramMessage.append(BatteryLog.access$400());
    paramMessage.append(".log");
    BatteryLog.access$102(paramMessage.toString());
    paramMessage = new StringBuilder();
    paramMessage.append(BatteryLog.access$200());
    paramMessage.append(BatteryLog.access$300());
    paramMessage.append("_");
    paramMessage.append(BatteryLog.access$400());
    paramMessage.append(".rpt");
    BatteryLog.access$502(paramMessage.toString());
    paramMessage = new File(BatteryLog.access$200());
    Object localObject1 = new File(BatteryLog.access$100());
    Object localObject2 = new File(BatteryLog.access$500());
    try
    {
      paramMessage.mkdirs();
      ((File)localObject1).delete();
      ((File)localObject2).delete();
      BatteryLog.writeCommonLog(new Object[] { "header", BaseInfo.userMeta.version, BatteryLog.access$600(), "pub", BaseInfo.userMeta.uuid, Build.MANUFACTURER, Build.MODEL, Integer.valueOf(Build.VERSION.SDK_INT), Long.valueOf(BatteryLog.access$400()), "1.3" });
    }
    catch (Throwable paramMessage)
    {
      Logger.INSTANCE.w(new String[] { "QAPM_battery_BatteryLog", "init LogHandler may be error, ", paramMessage.getMessage() });
    }
    Logger.INSTANCE.d(new String[] { "QAPM_battery_BatteryLog", "start LogHandler init" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.BatteryLog.LogHandler
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqperf.monitor.battery;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.qapmsdk.qqbattery.IBatteryListener;
import com.tencent.qapmsdk.qqbattery.QQBatteryMonitor;
import com.tencent.qphone.base.util.QLog.ILogCallback;
import mqq.util.IServiceCmdCallback;
import org.jetbrains.annotations.NotNull;

class QApmBatteryListenerImpl
  implements IBatteryListener, QLog.ILogCallback, IServiceCmdCallback
{
  @Nullable
  public String getBlackClassName()
  {
    return ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getSosoInterfaceBlackClassName();
  }
  
  public void onCmdRequest(String paramString)
  {
    QQBatteryMonitor.getInstance().onCmdRequest(paramString);
  }
  
  public void onCmdResponse(String paramString) {}
  
  public void onPrintLog(@NotNull String paramString) {}
  
  public void onUsageAlarm(int paramInt1, int paramInt2, int paramInt3, @NotNull String paramString1, @NotNull String paramString2) {}
  
  public void onWriteLog(String paramString1, String paramString2)
  {
    QQBatteryMonitor.getInstance().onWriteLog(paramString1, paramString2);
  }
  
  public void onWriteLog(String paramString, byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.monitor.battery.QApmBatteryListenerImpl
 * JD-Core Version:    0.7.0.1
 */
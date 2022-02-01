package com.tencent.qapmsdk.qqbattery;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.qapmsdk.common.activty.IForeBackInterface;

public class BatteryForeCallbackImpl
  implements IForeBackInterface
{
  public void onBackground(@NonNull Activity paramActivity)
  {
    QQBatteryMonitor.getInstance().onAppBackground();
  }
  
  public void onCreate(@NonNull Activity paramActivity) {}
  
  public void onDestroy(@NonNull Activity paramActivity) {}
  
  public void onForeground(@NonNull Activity paramActivity)
  {
    QQBatteryMonitor.getInstance().onAppForeground();
  }
  
  public void onResume(@NonNull Activity paramActivity) {}
  
  public void onStop(@NonNull Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.BatteryForeCallbackImpl
 * JD-Core Version:    0.7.0.1
 */
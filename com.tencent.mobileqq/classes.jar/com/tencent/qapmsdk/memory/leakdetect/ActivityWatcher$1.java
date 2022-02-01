package com.tencent.qapmsdk.memory.leakdetect;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.qapmsdk.common.activty.IForeBackInterface;

final class ActivityWatcher$1
  implements IForeBackInterface
{
  public void onBackground(@NonNull Activity paramActivity) {}
  
  public void onCreate(@NonNull Activity paramActivity) {}
  
  public void onDestroy(@NonNull Activity paramActivity)
  {
    ActivityWatcher.access$000(paramActivity);
  }
  
  public void onForeground(@NonNull Activity paramActivity) {}
  
  public void onResume(@NonNull Activity paramActivity) {}
  
  public void onStop(@NonNull Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.leakdetect.ActivityWatcher.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.rmonitor.bigbitmap;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.tencent.rmonitor.common.lifecycle.SimpleActivityStateCallback;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.AndroidVersion;
import com.tencent.rmonitor.common.util.ClassUtil;

class BigBitmapMonitor$BitmapMonitorLifecycleCallbacks
  extends SimpleActivityStateCallback
{
  private final SparseArray<RootViewDetectListener> b = new SparseArray();
  
  BigBitmapMonitor$BitmapMonitorLifecycleCallbacks(BigBitmapMonitor paramBigBitmapMonitor) {}
  
  public void a(@NonNull Activity paramActivity)
  {
    Object localObject = paramActivity.getClass().getSimpleName();
    if (BigBitmapMonitor.a(this.a, (String)localObject))
    {
      Logger.b.d(new String[] { "RMonitor_bigbitmap_BitmapMonitor", localObject, " is excluded" });
      return;
    }
    localObject = paramActivity.getWindow().getDecorView();
    ViewTreeObserver localViewTreeObserver = ((View)localObject).getViewTreeObserver();
    paramActivity = new RootViewDetectListener(ClassUtil.a(paramActivity, null), (View)localObject, BigBitmapMonitor.a(this.a));
    localViewTreeObserver.addOnGlobalLayoutListener(paramActivity);
    this.b.put(localObject.hashCode(), paramActivity);
  }
  
  public void b(@NonNull Activity paramActivity)
  {
    Object localObject = paramActivity.getWindow().getDecorView();
    paramActivity = ((View)localObject).getViewTreeObserver();
    localObject = (RootViewDetectListener)this.b.get(localObject.hashCode());
    if ((localObject != null) && (AndroidVersion.a())) {
      paramActivity.removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.bigbitmap.BigBitmapMonitor.BitmapMonitorLifecycleCallbacks
 * JD-Core Version:    0.7.0.1
 */
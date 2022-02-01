package com.tencent.qapmsdk.bigbitmap;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.tencent.qapmsdk.common.activty.IForeBackInterface;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.ClassUtil;

class BitmapMonitor$BitmapMonitorLifecycleCallbacks
  implements IForeBackInterface
{
  private SparseArray<RootViewDetectListener> drawableDetectListenerMap = new SparseArray();
  
  BitmapMonitor$BitmapMonitorLifecycleCallbacks(BitmapMonitor paramBitmapMonitor) {}
  
  public void onBackground(@NonNull Activity paramActivity) {}
  
  public void onCreate(@NonNull Activity paramActivity)
  {
    Object localObject = paramActivity.getClass().getSimpleName();
    if (BitmapMonitor.access$000(this.this$0, (String)localObject))
    {
      Logger.INSTANCE.d(new String[] { "QAPM_bigbitmap_BitmapMonitor", localObject, " is excluded" });
      return;
    }
    localObject = paramActivity.getWindow().getDecorView();
    ViewTreeObserver localViewTreeObserver = ((View)localObject).getViewTreeObserver();
    paramActivity = new RootViewDetectListener(ClassUtil.getClassName(paramActivity, null), (View)localObject, BitmapMonitor.access$100(this.this$0));
    localViewTreeObserver.addOnGlobalLayoutListener(paramActivity);
    this.drawableDetectListenerMap.put(localObject.hashCode(), paramActivity);
  }
  
  public void onDestroy(@NonNull Activity paramActivity)
  {
    Object localObject = paramActivity.getWindow().getDecorView();
    paramActivity = ((View)localObject).getViewTreeObserver();
    localObject = (RootViewDetectListener)this.drawableDetectListenerMap.get(localObject.hashCode());
    if (localObject != null) {
      paramActivity.removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)localObject);
    }
  }
  
  public void onForeground(@NonNull Activity paramActivity) {}
  
  public void onResume(@NonNull Activity paramActivity) {}
  
  public void onStop(@NonNull Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.bigbitmap.BitmapMonitor.BitmapMonitorLifecycleCallbacks
 * JD-Core Version:    0.7.0.1
 */
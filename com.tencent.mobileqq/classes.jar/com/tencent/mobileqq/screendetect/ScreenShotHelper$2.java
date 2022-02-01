package com.tencent.mobileqq.screendetect;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.lang.ref.WeakReference;

final class ScreenShotHelper$2
  implements Runnable
{
  ScreenShotHelper$2(WeakReference paramWeakReference, View paramView, Handler paramHandler) {}
  
  public void run()
  {
    Object localObject = (Activity)this.a.get();
    if (localObject != null) {
      if (((Activity)localObject).hasWindowFocus())
      {
        localObject = ((ViewGroup)((Activity)localObject).getWindow().getDecorView().getRootView()).findViewById(2131445345);
        if (localObject != null) {
          ((ViewGroup)this.b.getParent()).removeView((View)localObject);
        }
      }
      else
      {
        if ((23 <= Build.VERSION.SDK_INT) && (!((Activity)localObject).isDestroyed()))
        {
          this.c.postDelayed(this, 5000L);
          return;
        }
        this.c.removeCallbacksAndMessages(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotHelper.2
 * JD-Core Version:    0.7.0.1
 */
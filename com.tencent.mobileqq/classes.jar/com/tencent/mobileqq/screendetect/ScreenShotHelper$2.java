package com.tencent.mobileqq.screendetect;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.lang.ref.WeakReference;

public final class ScreenShotHelper$2
  implements Runnable
{
  public ScreenShotHelper$2(WeakReference paramWeakReference, View paramView, Handler paramHandler) {}
  
  public void run()
  {
    Object localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null)
    {
      if (!((Activity)localObject).hasWindowFocus()) {
        break label60;
      }
      localObject = ((ViewGroup)((Activity)localObject).getWindow().getDecorView().getRootView()).findViewById(2131375640);
      if (localObject != null) {
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView((View)localObject);
      }
    }
    return;
    label60:
    if ((23 <= Build.VERSION.SDK_INT) && (!((Activity)localObject).isDestroyed()))
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 5000L);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotHelper.2
 * JD-Core Version:    0.7.0.1
 */
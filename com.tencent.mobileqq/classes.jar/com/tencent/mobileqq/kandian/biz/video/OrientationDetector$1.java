package com.tencent.mobileqq.kandian.biz.video;

import android.app.Activity;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;

class OrientationDetector$1
  extends OrientationEventListener
{
  OrientationDetector$1(OrientationDetector paramOrientationDetector, Context paramContext, Activity paramActivity, WeakReference paramWeakReference)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (!OrientationDetector.a(this.c, paramInt)) {
      return;
    }
    if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInSplashActivity(this.a)) {
      return;
    }
    int j = OrientationDetector.a(this.c);
    int i;
    if (((paramInt >= 0) && (paramInt <= 30)) || (paramInt > 330))
    {
      i = 1;
    }
    else if ((paramInt > 70) && (paramInt <= 110))
    {
      i = 8;
    }
    else if ((paramInt > 150) && (paramInt <= 210))
    {
      i = 9;
    }
    else
    {
      i = j;
      if (paramInt > 250)
      {
        i = j;
        if (paramInt <= 290) {
          i = 0;
        }
      }
    }
    if (i != OrientationDetector.a(this.c))
    {
      OrientationDetector.b(this.c, i);
      if (this.b.get() != null) {
        ((OrientationDetector.OnOrientationChangedListener)this.b.get()).a(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.OrientationDetector.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.profilecard.vas.view;

import android.graphics.PointF;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profile.view.BreatheEffectView.BreatheListener;
import com.tencent.mobileqq.vas.gldrawable.GLDrawableWraper;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;

class VasProfileTagView$5
  implements BreatheEffectView.BreatheListener
{
  VasProfileTagView$5(VasProfileTagView paramVasProfileTagView) {}
  
  public void onBreatheShown()
  {
    Object localObject1;
    if (VasProfileTagView.access$1300(this.this$0) != null)
    {
      localObject1 = VasProfileTagView.access$500(this.this$0);
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if ((localObject2 != null) && (localObject2.getVisibility() != 8))
        {
          RatioLayout.LayoutParams localLayoutParams = (RatioLayout.LayoutParams)localObject2.getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.a = VasProfileTagView.access$1300(this.this$0).x;
            localLayoutParams.b = VasProfileTagView.access$1300(this.this$0).y;
            localObject2.setLayoutParams(localLayoutParams);
          }
        }
        i += 1;
      }
      this.this$0.tagsDiffuse();
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject1 = (FrameLayout)VasProfileTagView.access$1400(this.this$0).findViewById(16908290);
      if (localObject1 != null)
      {
        VasProfileTagView.access$1502(this.this$0, ((FrameLayout)localObject1).getBackground());
        if (!GLDrawableWraper.a(VasProfileTagView.access$1500(this.this$0))) {
          ((FrameLayout)localObject1).setBackgroundDrawable(null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.5
 * JD-Core Version:    0.7.0.1
 */
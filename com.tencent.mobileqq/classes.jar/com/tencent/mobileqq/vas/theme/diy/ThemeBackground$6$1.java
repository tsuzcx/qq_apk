package com.tencent.mobileqq.vas.theme.diy;

import android.view.View;
import android.widget.ImageView;
import com.tencent.android.gldrawable.api.IGLDrawable;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasDepTemp;

class ThemeBackground$6$1
  implements Runnable
{
  ThemeBackground$6$1(ThemeBackground.6 param6, ThemeBackground paramThemeBackground) {}
  
  public void run()
  {
    if ((!"null".equals(this.a.a)) && (this.a.b != null))
    {
      ThemeBackground.a(this.this$0.e, this.a, this.this$0.d, this.this$0.b);
      return;
    }
    Object localObject = this.this$0.e.getTag();
    if ((localObject instanceof ThemeBackground))
    {
      localObject = (ThemeBackground)localObject;
      if ((((ThemeBackground)localObject).b instanceof IGLDrawable)) {
        ((IGLDrawable)((ThemeBackground)localObject).b).recycle();
      }
    }
    this.a.b = null;
    this.this$0.e.setTag(null);
    if ((this.this$0.e instanceof ImageView))
    {
      ((ImageView)this.this$0.e).setImageResource(this.this$0.d);
      if (this.a.g != null) {
        ((ImageView)this.this$0.e).setScaleType(this.a.g);
      }
    }
    else
    {
      if (((IVasDepTemp)QRoute.api(IVasDepTemp.class)).setContentBackground(this.this$0.e, this.this$0.d)) {
        return;
      }
      if ((this.this$0.e instanceof FPSSwipListView))
      {
        ((FPSSwipListView)this.this$0.e).setContentBackground(this.this$0.d);
        return;
      }
      this.this$0.e.setBackgroundResource(this.this$0.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.diy.ThemeBackground.6.1
 * JD-Core Version:    0.7.0.1
 */
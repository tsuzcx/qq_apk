package com.tencent.mobileqq.kandian.base.view.widget.pullrefresh;

import android.widget.ImageView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.util.DisplayUtil;

class RefreshAnimView$3$2
  implements Runnable
{
  RefreshAnimView$3$2(RefreshAnimView.3 param3) {}
  
  public void run()
  {
    float f = DisplayUtil.a(this.a.c.getContext(), 44.0F) / 88.0F;
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setComposition(RefreshAnimView.d(this.a.c));
    localLottieDrawable.loop(false);
    RefreshAnimView.e(this.a.c).setImageDrawable(localLottieDrawable);
    RefreshAnimView.e(this.a.c).invalidate();
    RefreshAnimView.e(this.a.c).setScaleX(f);
    RefreshAnimView.e(this.a.c).setScaleY(f);
    RefreshAnimView.e(this.a.c).setPivotX(RefreshAnimView.e(this.a.c).getWidth() / 2);
    RefreshAnimView.e(this.a.c).setPivotY(RefreshAnimView.e(this.a.c).getHeight() / 2);
    localLottieDrawable.playAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.pullrefresh.RefreshAnimView.3.2
 * JD-Core Version:    0.7.0.1
 */
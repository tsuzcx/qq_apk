package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;

final class DrawRedpacketPannelPreviewFragment$SwapViews
  implements Runnable
{
  private final boolean a;
  private final View b;
  private final View c;
  
  public DrawRedpacketPannelPreviewFragment$SwapViews(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment, boolean paramBoolean, View paramView1, View paramView2)
  {
    this.a = paramBoolean;
    this.b = paramView1;
    this.c = paramView2;
  }
  
  public void run()
  {
    float f1 = DrawRedpacketPannelPreviewFragment.s(this.this$0).getWidth() / 2.0F;
    float f2 = DrawRedpacketPannelPreviewFragment.s(this.this$0).getHeight() / 2.0F;
    Animation localAnimation;
    if (this.a)
    {
      localAnimation = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).createRotate3dAnimation(-90.0F, 0.0F, f1, f2, 610.0F, false);
      this.b.setVisibility(8);
      this.c.setVisibility(0);
      if (((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).isCanShowNewCloseBtn(this.this$0.getQBaseActivity()))
      {
        DrawRedpacketPannelPreviewFragment.t(this.this$0).setVisibility(0);
        DrawRedpacketPannelPreviewFragment.u(this.this$0).setVisibility(4);
      }
      else
      {
        DrawRedpacketPannelPreviewFragment.u(this.this$0).setVisibility(0);
        DrawRedpacketPannelPreviewFragment.v(this.this$0).setVisibility(4);
      }
    }
    else
    {
      this.b.setVisibility(0);
      this.c.setVisibility(8);
      localAnimation = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).createRotate3dAnimation(90.0F, 0.0F, f1, f2, 610.0F, false);
    }
    localAnimation.setDuration(250L);
    localAnimation.setFillAfter(true);
    localAnimation.setInterpolator(new DecelerateInterpolator());
    DrawRedpacketPannelPreviewFragment.s(this.this$0).startAnimation(localAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawRedpacketPannelPreviewFragment.SwapViews
 * JD-Core Version:    0.7.0.1
 */
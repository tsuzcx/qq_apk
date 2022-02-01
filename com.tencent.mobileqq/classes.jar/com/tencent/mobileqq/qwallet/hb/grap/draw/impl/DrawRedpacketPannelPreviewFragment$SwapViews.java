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
  private final View jdField_a_of_type_AndroidViewView;
  private final boolean jdField_a_of_type_Boolean;
  private final View b;
  
  public DrawRedpacketPannelPreviewFragment$SwapViews(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment, boolean paramBoolean, View paramView1, View paramView2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.b = paramView2;
  }
  
  public void run()
  {
    float f1 = DrawRedpacketPannelPreviewFragment.a(this.this$0).getWidth() / 2.0F;
    float f2 = DrawRedpacketPannelPreviewFragment.a(this.this$0).getHeight() / 2.0F;
    Animation localAnimation;
    if (this.jdField_a_of_type_Boolean)
    {
      localAnimation = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).createRotate3dAnimation(-90.0F, 0.0F, f1, f2, 610.0F, false);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.b.setVisibility(0);
      if (((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).isCanShowNewCloseBtn(this.this$0.getQBaseActivity()))
      {
        DrawRedpacketPannelPreviewFragment.a(this.this$0).setVisibility(0);
        DrawRedpacketPannelPreviewFragment.f(this.this$0).setVisibility(4);
      }
      else
      {
        DrawRedpacketPannelPreviewFragment.f(this.this$0).setVisibility(0);
        DrawRedpacketPannelPreviewFragment.b(this.this$0).setVisibility(4);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.b.setVisibility(8);
      localAnimation = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).createRotate3dAnimation(90.0F, 0.0F, f1, f2, 610.0F, false);
    }
    localAnimation.setDuration(250L);
    localAnimation.setFillAfter(true);
    localAnimation.setInterpolator(new DecelerateInterpolator());
    DrawRedpacketPannelPreviewFragment.a(this.this$0).startAnimation(localAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawRedpacketPannelPreviewFragment.SwapViews
 * JD-Core Version:    0.7.0.1
 */
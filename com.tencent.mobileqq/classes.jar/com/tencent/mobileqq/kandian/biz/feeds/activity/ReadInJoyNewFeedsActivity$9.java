package com.tencent.mobileqq.kandian.biz.feeds.activity;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.view.widget.BaseTabbar.OnTabChangeListener;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoySubChannelFragment;
import com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabbar;
import com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabbar.Tab;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;

class ReadInJoyNewFeedsActivity$9
  implements BaseTabbar.OnTabChangeListener
{
  ReadInJoyNewFeedsActivity$9(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity) {}
  
  public void a(int paramInt)
  {
    if ((ReadInJoyNewFeedsActivity.a(this.a).a(paramInt) != null) && (ReadInJoyNewFeedsActivity.a(this.a).a(paramInt).a() != null)) {
      ReadInJoyNewFeedsActivity.a(this.a).a(paramInt).a().az_();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      ReadinjoyReportUtils.a(false);
    }
    if (paramInt2 == 1) {
      this.a.getIntent().putExtra("channel_from", 7);
    }
    if ((paramInt1 == paramInt2) && (paramInt2 == 0) && ((this.a.a() instanceof ReadInJoySubChannelFragment))) {
      this.a.a().f();
    } else {
      this.a.a(paramInt2, 256, null, true);
    }
    View localView;
    AlphaAnimation localAlphaAnimation;
    if (paramInt2 == 3)
    {
      localView = this.a.b.findViewById(2131378810);
      if (localView.getVisibility() == 0)
      {
        if (paramInt1 == 0) {
          ((TextView)localView.findViewById(2131369249)).setText(HardCodeUtil.a(2131693524));
        } else if (paramInt1 == 1) {
          ((TextView)localView.findViewById(2131369249)).setText(HardCodeUtil.a(2131712832));
        } else if (paramInt1 == 2) {
          ((TextView)localView.findViewById(2131369249)).setText(HardCodeUtil.a(2131712981));
        }
        localView.clearAnimation();
        localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        localAlphaAnimation.setDuration(250L);
        localAlphaAnimation.setAnimationListener(new ReadInJoyNewFeedsActivity.9.1(this, localView));
        localView.startAnimation(localAlphaAnimation);
      }
    }
    else
    {
      localView = this.a.b.findViewById(2131378810);
      if (localView.getVisibility() != 0)
      {
        localView.clearAnimation();
        localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(250L);
        localAlphaAnimation.setFillAfter(true);
        localAlphaAnimation.setAnimationListener(new ReadInJoyNewFeedsActivity.9.2(this, localView));
        localView.startAnimation(localAlphaAnimation);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity.9
 * JD-Core Version:    0.7.0.1
 */
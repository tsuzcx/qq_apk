package com.tencent.mobileqq.kandian.biz.channel.banner;

import android.view.View;
import androidx.viewpager.widget.ViewPager.PageTransformer;

class ChannelTopBanner$PagerChangeTransformer
  implements ViewPager.PageTransformer
{
  private ChannelTopBanner$PagerChangeTransformer(ChannelTopBanner paramChannelTopBanner) {}
  
  public void transformPage(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    if ((this.a.d != null) && (this.a.d.getCount() == 1)) {
      return;
    }
    if ((paramFloat > -1.1F) && (paramFloat < 1.1F))
    {
      paramFloat = Math.max(0.9F, 1.0F - Math.abs(paramFloat * 0.2000001F));
      paramView.setScaleX(paramFloat);
      paramView.setScaleY(paramFloat);
      return;
    }
    paramView.setScaleX(0.9F);
    paramView.setScaleY(0.9F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.channel.banner.ChannelTopBanner.PagerChangeTransformer
 * JD-Core Version:    0.7.0.1
 */
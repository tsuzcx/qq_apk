package com.tencent.mobileqq.kandian.biz.channel.banner;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo;
import com.tencent.mobileqq.widget.ViewPagerScroller;
import java.util.List;

public class ChannelBottomBanner
  extends ChannelTopBanner
{
  public ChannelBottomBanner(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  protected View a()
  {
    View localView = new View(this.a);
    if (this.f == null)
    {
      this.f = new LinearLayout.LayoutParams(UIUtils.a(this.a, 6.0F), UIUtils.a(this.a, 6.0F));
      this.f.leftMargin = UIUtils.a(this.a, 4.0F);
      this.h = getResources().getDrawable(2130840066);
      this.i = getResources().getDrawable(2130840065);
    }
    localView.setLayoutParams(this.f);
    localView.setBackgroundDrawable(this.h);
    return localView;
  }
  
  protected void a(Activity paramActivity)
  {
    LayoutInflater.from(paramActivity).inflate(2131626007, this, true);
    this.b = ((RollViewPager)findViewById(2131449829));
    this.b.setOffscreenPageLimit(5);
    this.e = ((LinearLayout)findViewById(2131437397));
    this.b.setOnPageChangeListener(new ChannelTopBanner.RollerChangeListener(this));
    this.b.setOnTouchStateChangeListener(new ChannelBottomBanner.1(this));
    this.d = new BannerAdapter(paramActivity, this.b, BannerAdapter.b);
    this.b.setAdapter(this.d);
    paramActivity = new ViewPagerScroller(this.a, new LinearInterpolator());
    paramActivity.a(400);
    paramActivity.a(this.b);
  }
  
  public void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, TopBannerInfo paramTopBannerInfo)
  {
    if (this.d != null)
    {
      if (paramTopBannerInfo.items.size() > 0)
      {
        this.d.a(paramTopBannerInfo);
        b();
        a(true);
        return;
      }
      a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.channel.banner.ChannelBottomBanner
 * JD-Core Version:    0.7.0.1
 */
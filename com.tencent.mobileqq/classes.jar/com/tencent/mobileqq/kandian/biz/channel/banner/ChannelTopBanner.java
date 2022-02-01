package com.tencent.mobileqq.kandian.biz.channel.banner;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.ProteusSupportUtilBase;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo.DynamicItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.ViewPagerScroller;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChannelTopBanner
  extends RelativeLayout
{
  private static final Set<String> m = new HashSet();
  protected Context a;
  protected RollViewPager b;
  protected boolean c = true;
  protected BannerAdapter d;
  protected LinearLayout e;
  protected LinearLayout.LayoutParams f;
  protected View[] g;
  protected Drawable h;
  protected Drawable i;
  protected int j;
  protected ViewPager.SimpleOnPageChangeListener k;
  protected Handler l = new ChannelTopBanner.1(this, Looper.getMainLooper());
  private LinearLayout n;
  private boolean o = true;
  private boolean p = false;
  private ChannelTopBanner.PagerChangeTransformer q;
  
  public ChannelTopBanner(Activity paramActivity)
  {
    super(paramActivity);
    this.a = paramActivity;
    a(paramActivity);
  }
  
  private String a(TopBannerInfo paramTopBannerInfo)
  {
    if (paramTopBannerInfo == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramTopBannerInfo.mChannelId);
    localStringBuilder.append("_");
    localStringBuilder.append(paramTopBannerInfo.mCookie);
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt)
  {
    View localView1 = this.d.a(paramInt);
    View localView2 = this.d.a(paramInt - 1);
    View localView3 = this.d.a(paramInt + 1);
    if ((this.q != null) && (this.d.getCount() > 1))
    {
      this.q.transformPage(localView1, 0.0F);
      this.q.transformPage(localView2, -1.0F);
      this.q.transformPage(localView3, 1.0F);
    }
  }
  
  private void a(View paramView)
  {
    this.n.addView(paramView);
  }
  
  private void a(TemplateBean paramTemplateBean)
  {
    ReadinjoyReportUtils.a(paramTemplateBean, null, "expose_T");
  }
  
  protected View a()
  {
    View localView = new View(this.a);
    if (this.f == null)
    {
      this.f = new LinearLayout.LayoutParams(UIUtils.a(this.a, 11.0F), UIUtils.a(this.a, 2.0F));
      this.f.leftMargin = UIUtils.a(this.a, 6.0F);
      this.h = getResources().getDrawable(2130851332);
      this.i = getResources().getDrawable(2130851333);
    }
    localView.setLayoutParams(this.f);
    localView.setBackgroundDrawable(this.h);
    return localView;
  }
  
  protected void a(Activity paramActivity)
  {
    LayoutInflater.from(paramActivity).inflate(2131626013, this, true);
    this.b = ((RollViewPager)findViewById(2131449896));
    this.b.setOffscreenPageLimit(5);
    this.b.setPageMargin(ViewUtils.dip2px(-10.0F));
    this.e = ((LinearLayout)findViewById(2131437397));
    this.b.setOnPageChangeListener(new ChannelTopBanner.RollerChangeListener(this));
    this.b.setOnTouchStateChangeListener(new ChannelTopBanner.2(this));
    this.d = new BannerAdapter(paramActivity, this.b, BannerAdapter.a);
    this.q = new ChannelTopBanner.PagerChangeTransformer(this, null);
    this.b.setPageTransformer(true, this.q);
    this.b.setAdapter(this.d);
    paramActivity = new ViewPagerScroller(this.a, new LinearInterpolator());
    paramActivity.a(400);
    paramActivity.a(this.b);
    setClipChildren(false);
    this.n = ((LinearLayout)findViewById(2131437394));
  }
  
  public void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, TopBannerInfo paramTopBannerInfo)
  {
    if (this.d != null) {
      if (paramTopBannerInfo.items.size() > 0)
      {
        this.d.a(paramTopBannerInfo);
        b();
        a(true);
      }
      else
      {
        a(false);
      }
    }
    this.n.removeAllViews();
    if (paramTopBannerInfo.dynamicItems.size() > 0)
    {
      boolean bool = m.contains(a(paramTopBannerInfo));
      m.add(a(paramTopBannerInfo));
      int i1 = 0;
      while (i1 < paramTopBannerInfo.dynamicItems.size())
      {
        TopBannerInfo.DynamicItem localDynamicItem = (TopBannerInfo.DynamicItem)paramTopBannerInfo.dynamicItems.get(i1);
        if ((localDynamicItem != null) && (!TextUtils.isEmpty(localDynamicItem.a)))
        {
          QLog.d("ChannelTopBanner", 2, new Object[] { "json = ", localDynamicItem.a });
          ProteusItemView localProteusItemView = ProteusSupportUtilBase.a(paramReadInJoyBaseAdapter.F(), "default_feeds", ProteusSupportUtilBase.a(localDynamicItem.a));
          if (localProteusItemView != null)
          {
            ProteusSupportUtilBase.a(localProteusItemView, paramReadInJoyBaseAdapter.F(), "default_feeds", localDynamicItem.a);
            a(localProteusItemView);
            if ((bool ^ true)) {
              a(localProteusItemView.getTemplateBean());
            }
          }
          else
          {
            QLog.d("ChannelTopBanner", 2, "refreshBanner, header is null.");
          }
        }
        else
        {
          QLog.d("ChannelTopBanner", 2, "refreshBanner, dynamicJSON is null.");
        }
        i1 += 1;
      }
    }
    QLog.d("ChannelTopBanner", 2, "refreshBanner, dynamicItems is null.");
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.setVisibility(0);
      this.e.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
    this.e.setVisibility(8);
  }
  
  public void b()
  {
    int i2 = this.d.c();
    if (i2 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelTopBanner", 2, "startRoll error, the count of avatars is 0...");
      }
      return;
    }
    this.e.removeAllViews();
    if (i2 > 1)
    {
      this.g = new View[i2];
      int i1 = 0;
      while (i1 < i2)
      {
        this.g[i1] = a();
        this.e.addView(this.g[i1]);
        i1 += 1;
      }
      this.g[0].setBackgroundDrawable(this.i);
      this.j = 1;
      this.b.setCurrentItem(this.j, false);
      e();
    }
    else
    {
      f();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChannelTopBanner", 2, "startRoll is called successfully");
    }
  }
  
  public void c()
  {
    e();
  }
  
  public void d()
  {
    f();
  }
  
  protected void e()
  {
    this.o = false;
    if (this.p)
    {
      this.l.removeCallbacksAndMessages(null);
      Handler localHandler = this.l;
      localHandler.sendMessageDelayed(localHandler.obtainMessage(), 4000L);
    }
  }
  
  protected void f()
  {
    this.o = true;
    this.l.removeCallbacksAndMessages(null);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.p = true;
    if (!this.o)
    {
      this.l.removeCallbacksAndMessages(null);
      localObject = this.l;
      ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(), 4000L);
    }
    Object localObject = this.d;
    if (localObject != null) {
      ((BannerAdapter)localObject).a();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.p = false;
    this.l.removeCallbacksAndMessages(null);
  }
  
  public void setOnPageChangeListener(ViewPager.SimpleOnPageChangeListener paramSimpleOnPageChangeListener)
  {
    this.k = paramSimpleOnPageChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.channel.banner.ChannelTopBanner
 * JD-Core Version:    0.7.0.1
 */
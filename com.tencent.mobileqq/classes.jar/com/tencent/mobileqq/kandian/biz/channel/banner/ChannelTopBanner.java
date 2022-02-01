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
  private static final Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  protected int a;
  protected Context a;
  protected Drawable a;
  protected Handler a;
  protected LinearLayout.LayoutParams a;
  protected LinearLayout a;
  protected ViewPager.SimpleOnPageChangeListener a;
  protected BannerAdapter a;
  private ChannelTopBanner.PagerChangeTransformer jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner$PagerChangeTransformer;
  protected RollViewPager a;
  protected boolean a;
  protected View[] a;
  protected Drawable b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c = false;
  
  public ChannelTopBanner(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new ChannelTopBanner.1(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
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
    View localView1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerBannerAdapter.a(paramInt);
    View localView2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerBannerAdapter.a(paramInt - 1);
    View localView3 = this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerBannerAdapter.a(paramInt + 1);
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner$PagerChangeTransformer != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerBannerAdapter.getCount() > 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner$PagerChangeTransformer.transformPage(localView1, 0.0F);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner$PagerChangeTransformer.transformPage(localView2, -1.0F);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner$PagerChangeTransformer.transformPage(localView3, 1.0F);
    }
  }
  
  private void a(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(paramView);
  }
  
  private void a(TemplateBean paramTemplateBean)
  {
    ReadinjoyReportUtils.a(paramTemplateBean, null, "expose_T");
  }
  
  protected View a()
  {
    View localView = new View(this.jdField_a_of_type_AndroidContentContext);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 11.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 2.0F));
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.leftMargin = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 6.0F);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130849627);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130849628);
    }
    localView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
    localView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    return localView;
  }
  
  public void a()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerBannerAdapter.a();
    if (j == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelTopBanner", 2, "startRoll error, the count of avatars is 0...");
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (j > 1)
    {
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[j];
      int i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_ArrayOfAndroidViewView[i] = a();
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ArrayOfAndroidViewView[i]);
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfAndroidViewView[0].setBackgroundDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager.setCurrentItem(this.jdField_a_of_type_Int, false);
      d();
    }
    else
    {
      e();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChannelTopBanner", 2, "startRoll is called successfully");
    }
  }
  
  protected void a(Activity paramActivity)
  {
    LayoutInflater.from(paramActivity).inflate(2131559970, this, true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager = ((RollViewPager)findViewById(2131380907));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager.setOffscreenPageLimit(5);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager.setPageMargin(ViewUtils.a(-10.0F));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370213));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager.setOnPageChangeListener(new ChannelTopBanner.RollerChangeListener(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager.setOnTouchStateChangeListener(new ChannelTopBanner.2(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerBannerAdapter = new BannerAdapter(paramActivity, this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager, BannerAdapter.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner$PagerChangeTransformer = new ChannelTopBanner.PagerChangeTransformer(this, null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager.setPageTransformer(true, this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerChannelTopBanner$PagerChangeTransformer);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerBannerAdapter);
    paramActivity = new ViewPagerScroller(this.jdField_a_of_type_AndroidContentContext, new LinearInterpolator());
    paramActivity.a(400);
    paramActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager);
    setClipChildren(false);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370211));
  }
  
  public void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, TopBannerInfo paramTopBannerInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerBannerAdapter != null) {
      if (paramTopBannerInfo.items.size() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerBannerAdapter.a(paramTopBannerInfo);
        a();
        a(true);
      }
      else
      {
        a(false);
      }
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (paramTopBannerInfo.dynamicItems.size() > 0)
    {
      boolean bool = jdField_a_of_type_JavaUtilSet.contains(a(paramTopBannerInfo));
      jdField_a_of_type_JavaUtilSet.add(a(paramTopBannerInfo));
      int i = 0;
      while (i < paramTopBannerInfo.dynamicItems.size())
      {
        TopBannerInfo.DynamicItem localDynamicItem = (TopBannerInfo.DynamicItem)paramTopBannerInfo.dynamicItems.get(i);
        if ((localDynamicItem != null) && (!TextUtils.isEmpty(localDynamicItem.a)))
        {
          QLog.d("ChannelTopBanner", 2, new Object[] { "json = ", localDynamicItem.a });
          ProteusItemView localProteusItemView = ProteusSupportUtilBase.a(paramReadInJoyBaseAdapter.a(), "default_feeds", ProteusSupportUtilBase.a(localDynamicItem.a));
          if (localProteusItemView != null)
          {
            ProteusSupportUtilBase.a(localProteusItemView, paramReadInJoyBaseAdapter.a(), "default_feeds", localDynamicItem.a);
            a(localProteusItemView);
            if ((bool ^ true)) {
              a(localProteusItemView.a());
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
        i += 1;
      }
    }
    QLog.d("ChannelTopBanner", 2, "refreshBanner, dynamicItems is null.");
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public void b()
  {
    d();
  }
  
  public void c()
  {
    e();
  }
  
  protected void d()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.c)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
      localHandler.sendMessageDelayed(localHandler.obtainMessage(), 4000L);
    }
  }
  
  protected void e()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.c = true;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      localObject = this.jdField_a_of_type_AndroidOsHandler;
      ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(), 4000L);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerBannerAdapter;
    if (localObject != null) {
      ((BannerAdapter)localObject).a();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.c = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void setOnPageChangeListener(ViewPager.SimpleOnPageChangeListener paramSimpleOnPageChangeListener)
  {
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$SimpleOnPageChangeListener = paramSimpleOnPageChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.channel.banner.ChannelTopBanner
 * JD-Core Version:    0.7.0.1
 */
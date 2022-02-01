package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.tencent.mobileqq.kandian.biz.channel.banner.RollViewPager;
import com.tencent.mobileqq.kandian.glue.businesshandler.DiandianTopConfigManager;
import com.tencent.mobileqq.kandian.repo.comment.entity.DiandianTopConfig;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.widget.MeasureGridView;
import com.tencent.mobileqq.widget.ViewPagerScroller;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyDiandianHeaderController
  extends HeaderViewController
{
  protected int a;
  protected Context a;
  public ColorDrawable a;
  protected Handler a;
  protected View a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private RollViewPager jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager;
  private ReadInJoyDiandianHeaderController.ViewPagerAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController$ViewPagerAdapter;
  private SubscribedListHeaderController jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerSubscribedListHeaderController;
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyDiandianHeaderController.2(this);
  private List<DiandianTopConfig> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private View jdField_b_of_type_AndroidViewView;
  private List<MeasureGridView> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  private View c;
  
  public ReadInJoyDiandianHeaderController(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    this.jdField_a_of_type_AndroidOsHandler = new ReadInJoyDiandianHeaderController.1(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560177, null);
    this.c = this.jdField_b_of_type_AndroidViewView.findViewById(2131379042);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager = ((RollViewPager)this.jdField_b_of_type_AndroidViewView.findViewById(2131380851));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController$ViewPagerAdapter = new ReadInJoyDiandianHeaderController.ViewPagerAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyDiandianHeaderController$ViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager.setOnPageChangeListener(new ReadInJoyDiandianHeaderController.RollerChangeListener(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager.setOnTouchStateChangeListener(new ReadInJoyDiandianHeaderController.3(this));
    ViewPagerScroller localViewPagerScroller = new ViewPagerScroller(this.jdField_a_of_type_AndroidContentContext, new LinearInterpolator());
    localViewPagerScroller.a(600);
    localViewPagerScroller.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizChannelBannerRollViewPager);
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131368110);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131378081));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerSubscribedListHeaderController = new SubscribedListHeaderController((Activity)paramContext, this.jdField_a_of_type_AndroidWidgetFrameLayout);
  }
  
  private View a(int paramInt)
  {
    MeasureGridView localMeasureGridView = new MeasureGridView(this.jdField_a_of_type_AndroidContentContext);
    localMeasureGridView.setSelector(new ColorDrawable(0));
    ReadInJoyDiandianHeaderController.HeaderListAdapter localHeaderListAdapter = new ReadInJoyDiandianHeaderController.HeaderListAdapter(this, this.jdField_a_of_type_JavaUtilList, paramInt);
    localMeasureGridView.setNumColumns(2);
    localMeasureGridView.setAdapter(localHeaderListAdapter);
    return localMeasureGridView;
  }
  
  private void h()
  {
    DiandianTopConfigManager.a().a();
  }
  
  protected void a() {}
  
  public void a(ListView paramListView)
  {
    paramListView.addHeaderView(this.jdField_b_of_type_AndroidViewView, 2);
    h();
  }
  
  public void b()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public void c()
  {
    super.c();
  }
  
  public void d()
  {
    super.d();
    g();
  }
  
  protected void f()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    localHandler.sendMessageDelayed(localHandler.obtainMessage(), 3000L);
  }
  
  protected void g()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyDiandianHeaderController
 * JD-Core Version:    0.7.0.1
 */
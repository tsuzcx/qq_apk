package com.tencent.mobileqq.nearby.now.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.now.ActCallBack;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.nearby.now.IStoryPlayController;
import com.tencent.mobileqq.nearby.now.ProgressControler;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class StuffContainerView
  extends RelativeLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  public Activity a;
  public ImageView a;
  public AppInterface a;
  public ActCallBack a;
  public IStoryPlayController a;
  public ProgressControler a;
  public CustomViewPager a;
  public QQStoryVideoPlayerErrorView a;
  protected SplitedProgressBar a;
  protected StuffContainerView.GestureListener a;
  protected StuffContainerView.OnCloseListener a;
  public VideoPlayerPagerAdapter a;
  public boolean a;
  private long b = 0L;
  
  public StuffContainerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StuffContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public StuffContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    a(paramContext);
  }
  
  public VideoData a()
  {
    VideoPlayerPagerAdapter localVideoPlayerPagerAdapter = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter;
    if (localVideoPlayerPagerAdapter != null)
    {
      CustomViewPager localCustomViewPager = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager;
      if (localCustomViewPager != null) {
        return localVideoPlayerPagerAdapter.a(localCustomViewPager.getCurrentItem());
      }
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowIStoryPlayController.doOnPause();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowIStoryPlayController.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(((IResourceUtil)QRoute.api(IResourceUtil.class)).getQQNearbyNowVideoPlayerLayout(), this, true);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager = ((CustomViewPager)localView.findViewById(((IResourceUtil)QRoute.api(IResourceUtil.class)).getVideoViewPager()));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewSplitedProgressBar = ((SplitedProgressBar)localView.findViewById(((IResourceUtil)QRoute.api(IResourceUtil.class)).getVideoSplitProgressBar()));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)localView.findViewById(((IResourceUtil)QRoute.api(IResourceUtil.class)).getOutsideErrorView()));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.getLayoutParams();
    localLayoutParams.height = ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).getScreenHeight(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.getContext());
    localLayoutParams.width = ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).getScreenWidth(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.getContext());
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.requestLayout();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setOnClickListener(new StuffContainerView.1(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(((IResourceUtil)QRoute.api(IResourceUtil.class)).getCloseIcon()));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new StuffContainerView.2(this));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowProgressControler = new ProgressControler(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewSplitedProgressBar);
    paramContext = new GestureDetector(paramContext, new StuffContainerView.OnGestureListener(this, null));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.setClickable(true);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.setOnTouchListener(new StuffContainerView.3(this, paramContext));
    ((Activity)getContext()).getWindow().getDecorView().addOnLayoutChangeListener(new StuffContainerView.4(this));
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowIStoryPlayController = ((IStoryPlayController)QRoute.api(IStoryPlayController.class)).init(getContext(), this, this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter, paramBundle, this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqNearbyNowActCallBack);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.setOnPageChangeListener((ViewPager.OnPageChangeListener)this.jdField_a_of_type_ComTencentMobileqqNearbyNowIStoryPlayController);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowIStoryPlayController, paramBundle);
    setGestureListener((StuffContainerView.GestureListener)this.jdField_a_of_type_ComTencentMobileqqNearbyNowIStoryPlayController);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter = new VideoPlayerPagerAdapter(getContext(), paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_ComTencentCommonAppAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.setPageMargin(1);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowIStoryPlayController.doOnResume();
  }
  
  public void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowIStoryPlayController.initialize(paramBundle);
  }
  
  public void b(boolean paramBoolean)
  {
    SplitedProgressBar localSplitedProgressBar = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewSplitedProgressBar;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 4;
    }
    localSplitedProgressBar.setVisibility(i);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowIStoryPlayController.doOnDestroy();
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
    int j = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem();
    int i = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem() >= this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.getCount() - 1) {
      i = 0;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem());
    String str;
    if (localObject != null) {
      str = ((VideoData)localObject).jdField_a_of_type_JavaLangString;
    } else {
      str = "0";
    }
    long l;
    if (localObject != null) {
      l = ((VideoData)localObject).jdField_a_of_type_Long;
    } else {
      l = 0L;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("player quit report module=short_video, action=view_quit, obj1=");
      ((StringBuilder)localObject).append(j + 1);
      ((StringBuilder)localObject).append(", obj3=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", obj4=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append(", res2=");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(", anchor=");
      ((StringBuilder)localObject).append(l);
      QLog.i("Native_ShortVideo_Report", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void d()
  {
    StuffContainerView.OnCloseListener localOnCloseListener = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$OnCloseListener;
    if (localOnCloseListener != null) {
      localOnCloseListener.a(0);
    }
  }
  
  public void e() {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == ((IResourceUtil)QRoute.api(IResourceUtil.class)).getCloseIcon())
    {
      StuffContainerView.OnCloseListener localOnCloseListener = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$OnCloseListener;
      if (localOnCloseListener != null) {
        localOnCloseListener.a(0);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNowIStoryPlayController.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void setApp(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void setCallBack(ActCallBack paramActCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowActCallBack = paramActCallBack;
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.setCurrentItem(paramInt, paramBoolean);
  }
  
  public void setGestureListener(StuffContainerView.GestureListener paramGestureListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$GestureListener = paramGestureListener;
  }
  
  public void setOnCloseListener(StuffContainerView.OnCloseListener paramOnCloseListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$OnCloseListener = paramOnCloseListener;
    VideoPlayerPagerAdapter localVideoPlayerPagerAdapter = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter;
    if (localVideoPlayerPagerAdapter != null) {
      localVideoPlayerPagerAdapter.a(paramOnCloseListener);
    }
  }
  
  public void setStatusBarHeight(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewSplitedProgressBar.getLayoutParams();
    localLayoutParams.topMargin += paramInt;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewSplitedProgressBar.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.StuffContainerView
 * JD-Core Version:    0.7.0.1
 */
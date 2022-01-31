package com.tencent.mobileqq.nearby.now.view;

import afcy;
import afcz;
import afda;
import afdb;
import afdc;
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
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.ActCallBack;
import com.tencent.mobileqq.nearby.now.ProgressControler;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.qphone.base.util.QLog;

public class StuffContainerView
  extends RelativeLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public Activity a;
  public ImageView a;
  public QQAppInterface a;
  public ActCallBack a;
  public ProgressControler a;
  public StoryPlayController a;
  public CustomViewPager a;
  public QQStoryVideoPlayerErrorView a;
  protected SplitedProgressBar a;
  public StuffContainerView.GestureListener a;
  public StuffContainerView.OnCloseListener a;
  public VideoPlayerPagerAdapter a;
  public boolean a;
  private long b;
  
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
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    a(paramContext);
  }
  
  public VideoData a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem());
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.c();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2130970472, this, true);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager = ((CustomViewPager)localView.findViewById(2131370630));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewSplitedProgressBar = ((SplitedProgressBar)localView.findViewById(2131364837));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)localView.findViewById(2131370631));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.getLayoutParams();
    localLayoutParams.height = UITools.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.getContext());
    localLayoutParams.width = UITools.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.getContext());
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.requestLayout();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setOnClickListener(new afcy(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370622));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new afcz(this));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowProgressControler = new ProgressControler(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewSplitedProgressBar);
    paramContext = new GestureDetector(paramContext, new afdc(this, null));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.setClickable(true);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.setOnTouchListener(new afda(this, paramContext));
    ((Activity)getContext()).getWindow().getDecorView().addOnLayoutChangeListener(new afdb(this));
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController = new StoryPlayController(getContext(), this, this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter, paramBundle, this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqNearbyNowActCallBack);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.setOnPageChangeListener(this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController, paramBundle);
    setGestureListener(this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter = new VideoPlayerPagerAdapter(getContext(), paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.setPageMargin(1);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.b();
  }
  
  public void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.a(paramBundle);
  }
  
  public void b(boolean paramBoolean)
  {
    SplitedProgressBar localSplitedProgressBar = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewSplitedProgressBar;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localSplitedProgressBar.setVisibility(i);
      return;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.d();
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
    int j = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem();
    int i;
    VideoData localVideoData;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem() >= this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.getCount() - 1)
    {
      i = 0;
      localVideoData = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem());
      if (localVideoData == null) {
        break label172;
      }
      str = localVideoData.jdField_a_of_type_JavaLangString;
      label76:
      if (localVideoData == null) {
        break label180;
      }
    }
    label172:
    label180:
    for (long l = localVideoData.jdField_a_of_type_Long;; l = 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Native_ShortVideo_Report", 2, "player quit report module=short_video, action=view_quit, obj1=" + (j + 1) + ", obj3=" + i + ", obj4=" + this.jdField_a_of_type_Long + ", res2=" + str + ", anchor=" + l);
      }
      return;
      i = 1;
      break;
      str = "0";
      break label76;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$OnCloseListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$OnCloseListener.a(0);
    }
  }
  
  public void e() {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131370622) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$OnCloseListener != null)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$OnCloseListener.a(0);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.a(paramInt, paramKeyEvent);
  }
  
  public void setApp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
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
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(paramOnCloseListener);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.StuffContainerView
 * JD-Core Version:    0.7.0.1
 */
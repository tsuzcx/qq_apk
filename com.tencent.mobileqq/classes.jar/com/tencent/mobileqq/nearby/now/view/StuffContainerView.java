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
import atgi;
import atgl;
import atkf;
import atkg;
import atkh;
import atki;
import atkj;
import atkk;
import atkl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.qphone.base.util.QLog;
import muc;

public class StuffContainerView
  extends RelativeLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  public Activity a;
  public ImageView a;
  public atgi a;
  public atgl a;
  public atkj a;
  public atkk a;
  public QQAppInterface a;
  public StoryPlayController a;
  public CustomViewPager a;
  public QQStoryVideoPlayerErrorView a;
  protected SplitedProgressBar a;
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
    View localView = LayoutInflater.from(paramContext).inflate(2131560878, this, true);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager = ((CustomViewPager)localView.findViewById(2131379128));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewSplitedProgressBar = ((SplitedProgressBar)localView.findViewById(2131379085));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)localView.findViewById(2131371166));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.getLayoutParams();
    localLayoutParams.height = muc.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.getContext());
    localLayoutParams.width = muc.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.getContext());
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.requestLayout();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setOnClickListener(new atkf(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364274));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new atkg(this));
    this.jdField_a_of_type_Atgl = new atgl(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewSplitedProgressBar);
    paramContext = new GestureDetector(paramContext, new atkl(this, null));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.setClickable(true);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.setOnTouchListener(new atkh(this, paramContext));
    ((Activity)getContext()).getWindow().getDecorView().addOnLayoutChangeListener(new atki(this));
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController = new StoryPlayController(getContext(), this, this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter, paramBundle, this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atgi);
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
    if (this.jdField_a_of_type_Atkk != null) {
      this.jdField_a_of_type_Atkk.a(0);
    }
  }
  
  public void e() {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131364274) && (this.jdField_a_of_type_Atkk != null)) {
      this.jdField_a_of_type_Atkk.a(0);
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
  
  public void setCallBack(atgi paramatgi)
  {
    this.jdField_a_of_type_Atgi = paramatgi;
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.setCurrentItem(paramInt, paramBoolean);
  }
  
  public void setGestureListener(atkj paramatkj)
  {
    this.jdField_a_of_type_Atkj = paramatkj;
  }
  
  public void setOnCloseListener(atkk paramatkk)
  {
    this.jdField_a_of_type_Atkk = paramatkk;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(paramatkk);
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
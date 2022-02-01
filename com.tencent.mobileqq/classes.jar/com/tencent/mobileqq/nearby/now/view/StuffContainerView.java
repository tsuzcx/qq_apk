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
  public Activity a;
  public AppInterface b;
  public CustomViewPager c;
  protected SplitedProgressBar d;
  protected StuffContainerView.OnCloseListener e;
  protected StuffContainerView.GestureListener f;
  public VideoPlayerPagerAdapter g;
  public ProgressControler h;
  public IStoryPlayController i;
  public QQStoryVideoPlayerErrorView j;
  public boolean k = false;
  public ActCallBack l;
  public ImageView m;
  private long n = 0L;
  private int o;
  private long p = 0L;
  
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
    this.a = ((Activity)paramContext);
    a(paramContext);
  }
  
  public void a()
  {
    this.k = false;
    this.i.doOnPause();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.i.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(((IResourceUtil)QRoute.api(IResourceUtil.class)).getQQNearbyNowVideoPlayerLayout(), this, true);
    this.c = ((CustomViewPager)localView.findViewById(((IResourceUtil)QRoute.api(IResourceUtil.class)).getVideoViewPager()));
    this.d = ((SplitedProgressBar)localView.findViewById(((IResourceUtil)QRoute.api(IResourceUtil.class)).getVideoSplitProgressBar()));
    this.j = ((QQStoryVideoPlayerErrorView)localView.findViewById(((IResourceUtil)QRoute.api(IResourceUtil.class)).getOutsideErrorView()));
    ViewGroup.LayoutParams localLayoutParams = this.j.getLayoutParams();
    localLayoutParams.height = ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).getScreenHeight(this.j.getContext());
    localLayoutParams.width = ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).getScreenWidth(this.j.getContext());
    this.j.setLayoutParams(localLayoutParams);
    this.j.requestLayout();
    this.j.setOnClickListener(new StuffContainerView.1(this));
    this.m = ((ImageView)localView.findViewById(((IResourceUtil)QRoute.api(IResourceUtil.class)).getCloseIcon()));
    this.m.setOnClickListener(new StuffContainerView.2(this));
    this.h = new ProgressControler(this.d);
    paramContext = new GestureDetector(paramContext, new StuffContainerView.OnGestureListener(this, null));
    this.c.setClickable(true);
    this.c.setOnTouchListener(new StuffContainerView.3(this, paramContext));
    ((Activity)getContext()).getWindow().getDecorView().addOnLayoutChangeListener(new StuffContainerView.4(this));
    this.n = System.currentTimeMillis();
  }
  
  public void a(Bundle paramBundle)
  {
    this.i = ((IStoryPlayController)QRoute.api(IStoryPlayController.class)).init(getContext(), this, this.g, paramBundle, this.j, this.b, this.l);
    this.c.setOnPageChangeListener((ViewPager.OnPageChangeListener)this.i);
    this.g.a(this.i, paramBundle);
    setGestureListener((StuffContainerView.GestureListener)this.i);
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = new VideoPlayerPagerAdapter(getContext(), paramBoolean);
    this.g.f = this.b;
    this.c.setPageMargin(1);
    this.c.setAdapter(this.g);
  }
  
  public void b()
  {
    this.k = true;
    this.i.doOnResume();
  }
  
  public void b(Bundle paramBundle)
  {
    this.i.initialize(paramBundle);
  }
  
  public void b(boolean paramBoolean)
  {
    SplitedProgressBar localSplitedProgressBar = this.d;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 4;
    }
    localSplitedProgressBar.setVisibility(i1);
  }
  
  public void c()
  {
    this.i.doOnDestroy();
    this.n = (System.currentTimeMillis() - this.n);
    int i2 = this.c.getCurrentItem();
    int i1 = 1;
    if (this.c.getCurrentItem() >= this.g.getCount() - 1) {
      i1 = 0;
    }
    Object localObject = this.g.c(this.c.getCurrentItem());
    String str;
    if (localObject != null) {
      str = ((VideoData)localObject).c;
    } else {
      str = "0";
    }
    long l1;
    if (localObject != null) {
      l1 = ((VideoData)localObject).i;
    } else {
      l1 = 0L;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("player quit report module=short_video, action=view_quit, obj1=");
      ((StringBuilder)localObject).append(i2 + 1);
      ((StringBuilder)localObject).append(", obj3=");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(", obj4=");
      ((StringBuilder)localObject).append(this.n);
      ((StringBuilder)localObject).append(", res2=");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(", anchor=");
      ((StringBuilder)localObject).append(l1);
      QLog.i("Native_ShortVideo_Report", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void d()
  {
    StuffContainerView.OnCloseListener localOnCloseListener = this.e;
    if (localOnCloseListener != null) {
      localOnCloseListener.a(0);
    }
  }
  
  public void e() {}
  
  public VideoData getCurrentVideoData()
  {
    VideoPlayerPagerAdapter localVideoPlayerPagerAdapter = this.g;
    if (localVideoPlayerPagerAdapter != null)
    {
      CustomViewPager localCustomViewPager = this.c;
      if (localCustomViewPager != null) {
        return localVideoPlayerPagerAdapter.c(localCustomViewPager.getCurrentItem());
      }
    }
    return null;
  }
  
  public int getViewPagerCurrentIndex()
  {
    return this.c.getCurrentItem();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == ((IResourceUtil)QRoute.api(IResourceUtil.class)).getCloseIcon())
    {
      StuffContainerView.OnCloseListener localOnCloseListener = this.e;
      if (localOnCloseListener != null) {
        localOnCloseListener.a(0);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.i.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void setApp(AppInterface paramAppInterface)
  {
    this.b = paramAppInterface;
  }
  
  public void setCallBack(ActCallBack paramActCallBack)
  {
    this.l = paramActCallBack;
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    this.c.setCurrentItem(paramInt, paramBoolean);
  }
  
  public void setGestureListener(StuffContainerView.GestureListener paramGestureListener)
  {
    this.f = paramGestureListener;
  }
  
  public void setOnCloseListener(StuffContainerView.OnCloseListener paramOnCloseListener)
  {
    this.e = paramOnCloseListener;
    VideoPlayerPagerAdapter localVideoPlayerPagerAdapter = this.g;
    if (localVideoPlayerPagerAdapter != null) {
      localVideoPlayerPagerAdapter.a(paramOnCloseListener);
    }
  }
  
  public void setStatusBarHeight(int paramInt)
  {
    this.o = paramInt;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
    localLayoutParams.topMargin += paramInt;
    this.d.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.StuffContainerView
 * JD-Core Version:    0.7.0.1
 */
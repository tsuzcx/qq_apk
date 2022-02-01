package com.tencent.richmediabrowser.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.richmediabrowser.api.event.IBrowserItemAnimationEvent;
import com.tencent.richmediabrowser.api.event.IBrowserItemClickEvent;
import com.tencent.richmediabrowser.api.event.IBrowserItemScrollEvent;
import com.tencent.richmediabrowser.api.event.IDecoratorViewEvent;
import com.tencent.richmediabrowser.api.event.IPictureScaleEvent;
import com.tencent.richmediabrowser.core.IBaseViewBuilder;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.utils.ScreenUtils;

public class BrowserBaseView
  implements View.OnLongClickListener, IBrowserItemAnimationEvent, IBrowserItemScrollEvent, IPictureScaleEvent, IBaseViewBuilder
{
  public BrowserBasePresenter basePresenter;
  private IDecoratorViewEvent decoratorViewEvent;
  public boolean isInEnterAnim;
  public boolean isInExitAnim;
  public IBrowserItemAnimationEvent itemAnimationListener;
  public IBrowserItemClickEvent itemClickEventListener;
  public RelativeLayout mBrowserItemView;
  public Context mContext;
  public int mScreenHeightPx;
  public int mScreenWidthPx;
  public int midScreenWidth;
  public IPictureScaleEvent pictureScaleEventListener;
  public IBrowserItemScrollEvent scrollEventListener;
  
  public BrowserBaseView(Context paramContext, BrowserBasePresenter paramBrowserBasePresenter)
  {
    this.mContext = paramContext;
    if (paramBrowserBasePresenter.getRecyclerView() != null)
    {
      this.mScreenWidthPx = paramBrowserBasePresenter.getRecyclerView().getWidth();
      this.mScreenHeightPx = paramBrowserBasePresenter.getRecyclerView().getHeight();
    }
    this.basePresenter = paramBrowserBasePresenter;
  }
  
  public void bindView(int paramInt)
  {
    IDecoratorViewEvent localIDecoratorViewEvent = this.decoratorViewEvent;
    if (localIDecoratorViewEvent != null) {
      localIDecoratorViewEvent.a(paramInt);
    }
  }
  
  public void buildComplete() {}
  
  public void buildParams(Intent paramIntent)
  {
    this.midScreenWidth = (ScreenUtils.getScreenWidth(this.mContext) / 2);
    initParams(paramIntent);
  }
  
  public void buildView() {}
  
  public Rect getAnimationEndDstRect()
  {
    IBrowserItemAnimationEvent localIBrowserItemAnimationEvent = this.itemAnimationListener;
    if (localIBrowserItemAnimationEvent != null) {
      return localIBrowserItemAnimationEvent.getAnimationEndDstRect();
    }
    return null;
  }
  
  public View getView(View paramView, ViewGroup paramViewGroup)
  {
    IDecoratorViewEvent localIDecoratorViewEvent = this.decoratorViewEvent;
    if (localIDecoratorViewEvent != null) {
      return localIDecoratorViewEvent.a(paramView, paramViewGroup);
    }
    return null;
  }
  
  public void initParams(Intent paramIntent)
  {
    IDecoratorViewEvent localIDecoratorViewEvent = this.decoratorViewEvent;
    if (localIDecoratorViewEvent != null) {
      localIDecoratorViewEvent.a(paramIntent);
    }
  }
  
  public boolean isNeedDisallowInterceptEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean needEnterRectAnimation()
  {
    IBrowserItemAnimationEvent localIBrowserItemAnimationEvent = this.itemAnimationListener;
    if (localIBrowserItemAnimationEvent != null) {
      return localIBrowserItemAnimationEvent.needEnterRectAnimation();
    }
    return false;
  }
  
  public boolean needExitRectAnimation()
  {
    IBrowserItemAnimationEvent localIBrowserItemAnimationEvent = this.itemAnimationListener;
    if (localIBrowserItemAnimationEvent != null) {
      return localIBrowserItemAnimationEvent.needExitRectAnimation();
    }
    return false;
  }
  
  public void onClickEvent()
  {
    IBrowserItemClickEvent localIBrowserItemClickEvent = this.itemClickEventListener;
    if (localIBrowserItemClickEvent != null)
    {
      localIBrowserItemClickEvent.onClickEvent();
      return;
    }
    this.basePresenter.back();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.basePresenter.getRecyclerView() != null)
    {
      int i = this.basePresenter.getRecyclerView().getWidth();
      int j = this.basePresenter.getRecyclerView().getHeight();
      if ((i != this.mScreenWidthPx) || (j != this.mScreenHeightPx))
      {
        this.mScreenWidthPx = i;
        this.mScreenHeightPx = j;
        URLDrawable.clearMemoryCache();
      }
    }
  }
  
  public void onDestroy()
  {
    setDecoratorViewEvent(null);
    setBrowserItemClickListener(null);
    setBrowserItemScrollEventListener(null);
    setPictureScaleEventListener(null);
    setBrowserItemAnimationListener(null);
  }
  
  public void onDestroyView(int paramInt, View paramView)
  {
    IDecoratorViewEvent localIDecoratorViewEvent = this.decoratorViewEvent;
    if (localIDecoratorViewEvent != null) {
      localIDecoratorViewEvent.a(paramInt, paramView);
    }
  }
  
  public void onDoubleTap(int paramInt)
  {
    IPictureScaleEvent localIPictureScaleEvent = this.pictureScaleEventListener;
    if (localIPictureScaleEvent != null) {
      localIPictureScaleEvent.onDoubleTap(paramInt);
    }
  }
  
  public void onEnterAnimationEnd()
  {
    IBrowserItemAnimationEvent localIBrowserItemAnimationEvent = this.itemAnimationListener;
    if (localIBrowserItemAnimationEvent != null) {
      localIBrowserItemAnimationEvent.onEnterAnimationEnd();
    }
  }
  
  public void onEnterAnimationStart()
  {
    IBrowserItemAnimationEvent localIBrowserItemAnimationEvent = this.itemAnimationListener;
    if (localIBrowserItemAnimationEvent != null) {
      localIBrowserItemAnimationEvent.onEnterAnimationStart();
    }
  }
  
  public void onExitAnimationEnd()
  {
    IBrowserItemAnimationEvent localIBrowserItemAnimationEvent = this.itemAnimationListener;
    if (localIBrowserItemAnimationEvent != null) {
      localIBrowserItemAnimationEvent.onExitAnimationEnd();
    }
  }
  
  public void onExitAnimationStart()
  {
    IBrowserItemAnimationEvent localIBrowserItemAnimationEvent = this.itemAnimationListener;
    if (localIBrowserItemAnimationEvent != null) {
      localIBrowserItemAnimationEvent.onExitAnimationStart();
    }
  }
  
  public void onItemSelected(int paramInt)
  {
    IDecoratorViewEvent localIDecoratorViewEvent = this.decoratorViewEvent;
    if (localIDecoratorViewEvent != null) {
      localIDecoratorViewEvent.b(paramInt);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    paramView = this.itemClickEventListener;
    if (paramView != null)
    {
      paramView.onLongClickEvent();
      return true;
    }
    return false;
  }
  
  public void onScale(int paramInt)
  {
    IPictureScaleEvent localIPictureScaleEvent = this.pictureScaleEventListener;
    if (localIPictureScaleEvent != null) {
      localIPictureScaleEvent.onScale(paramInt);
    }
  }
  
  public void onScaleBegin(int paramInt)
  {
    IPictureScaleEvent localIPictureScaleEvent = this.pictureScaleEventListener;
    if (localIPictureScaleEvent != null) {
      localIPictureScaleEvent.onScaleBegin(paramInt);
    }
  }
  
  public void onScaleEnd(int paramInt)
  {
    IPictureScaleEvent localIPictureScaleEvent = this.pictureScaleEventListener;
    if (localIPictureScaleEvent != null) {
      localIPictureScaleEvent.onScaleEnd(paramInt);
    }
  }
  
  public void onScrollEnd()
  {
    IBrowserItemScrollEvent localIBrowserItemScrollEvent = this.scrollEventListener;
    if (localIBrowserItemScrollEvent != null) {
      localIBrowserItemScrollEvent.onScrollEnd();
    }
  }
  
  public void onScrollHalfScreenWidth()
  {
    IBrowserItemScrollEvent localIBrowserItemScrollEvent = this.scrollEventListener;
    if (localIBrowserItemScrollEvent != null) {
      localIBrowserItemScrollEvent.onScrollHalfScreenWidth();
    }
  }
  
  public void onScrollStart()
  {
    IBrowserItemScrollEvent localIBrowserItemScrollEvent = this.scrollEventListener;
    if (localIBrowserItemScrollEvent != null) {
      localIBrowserItemScrollEvent.onScrollStart();
    }
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData) {}
  
  public void setBrowserItemAnimationListener(IBrowserItemAnimationEvent paramIBrowserItemAnimationEvent)
  {
    this.itemAnimationListener = paramIBrowserItemAnimationEvent;
  }
  
  public void setBrowserItemClickListener(IBrowserItemClickEvent paramIBrowserItemClickEvent)
  {
    this.itemClickEventListener = paramIBrowserItemClickEvent;
  }
  
  public void setBrowserItemScrollEventListener(IBrowserItemScrollEvent paramIBrowserItemScrollEvent)
  {
    this.scrollEventListener = paramIBrowserItemScrollEvent;
  }
  
  public void setDecoratorViewEvent(IDecoratorViewEvent paramIDecoratorViewEvent)
  {
    this.decoratorViewEvent = paramIDecoratorViewEvent;
  }
  
  public void setPictureScaleEventListener(IPictureScaleEvent paramIPictureScaleEvent)
  {
    this.pictureScaleEventListener = paramIPictureScaleEvent;
  }
  
  public void updateUI()
  {
    IDecoratorViewEvent localIDecoratorViewEvent = this.decoratorViewEvent;
    if (localIDecoratorViewEvent != null) {
      localIDecoratorViewEvent.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.BrowserBaseView
 * JD-Core Version:    0.7.0.1
 */
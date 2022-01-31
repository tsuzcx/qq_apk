package com.tencent.plato.sdk.widget;

import android.content.Context;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.sdk.render.IPView;
import com.tencent.plato.sdk.render.data.BlockElementData;

public abstract interface IPullToRefresh<T extends View>
{
  public abstract PullToRefreshBase.Mode getCurrentMode();
  
  public abstract boolean getFilterTouchEvents();
  
  public abstract BlockElementData getLoadMoreElement();
  
  public abstract PullToRefreshBase.Mode getMode();
  
  public abstract BlockElementData getRefreshElement();
  
  public abstract T getRefreshableView();
  
  public abstract boolean getShowViewWhileRefreshing();
  
  public abstract PullToRefreshBase.State getState();
  
  public abstract boolean isPullToRefreshEnabled();
  
  public abstract boolean isPullToRefreshOverScrollEnabled();
  
  public abstract boolean isRefreshing();
  
  public abstract boolean isScrollingWhileRefreshingEnabled();
  
  public abstract void onRefreshComplete();
  
  public abstract void setEventCallBack(RefreshStateCallback paramRefreshStateCallback);
  
  public abstract void setFilterTouchEvents(boolean paramBoolean);
  
  public abstract void setLoadMoreElement(IPlatoRuntime paramIPlatoRuntime, BlockElementData paramBlockElementData);
  
  public abstract void setLoadMoreView(Context paramContext, IPView paramIPView);
  
  public abstract void setMode(PullToRefreshBase.Mode paramMode);
  
  public abstract void setOnPullEventListener(PullToRefreshBase.OnPullEventListener<T> paramOnPullEventListener);
  
  public abstract void setOnRefreshListener(PullToRefreshBase.OnRefreshListener2<T> paramOnRefreshListener2);
  
  public abstract void setOnRefreshListener(PullToRefreshBase.OnRefreshListener<T> paramOnRefreshListener);
  
  public abstract void setPullToRefreshOverScrollEnabled(boolean paramBoolean);
  
  public abstract void setRefreshElement(IPlatoRuntime paramIPlatoRuntime, BlockElementData paramBlockElementData);
  
  public abstract void setRefreshView(Context paramContext, IPView paramIPView);
  
  public abstract void setRefreshing();
  
  public abstract void setRefreshing(boolean paramBoolean);
  
  public abstract void setScrollAnimationInterpolator(Interpolator paramInterpolator);
  
  public abstract void setScrollingWhileRefreshingEnabled(boolean paramBoolean);
  
  public abstract void setShowViewWhileRefreshing(boolean paramBoolean);
  
  public abstract void setUseDefaultLoadMoreView();
  
  public abstract void setUseDefaultRefreshView();
  
  public abstract void updateLoadMoreElement(IPlatoRuntime paramIPlatoRuntime, BlockElementData paramBlockElementData);
  
  public abstract void updateRefreshElement(IPlatoRuntime paramIPlatoRuntime, BlockElementData paramBlockElementData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.sdk.widget.IPullToRefresh
 * JD-Core Version:    0.7.0.1
 */
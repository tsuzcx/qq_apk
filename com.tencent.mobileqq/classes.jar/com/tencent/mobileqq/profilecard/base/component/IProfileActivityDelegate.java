package com.tencent.mobileqq.profilecard.base.component;

import android.view.ViewGroup;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.view.PullToZoomHeaderListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public abstract interface IProfileActivityDelegate
{
  public abstract void addProfileScrollListener(AbsListView.OnScrollListener paramOnScrollListener);
  
  public abstract void checkAndSwitch2Friend(boolean paramBoolean1, boolean paramBoolean2, String paramString);
  
  public abstract PullToZoomHeaderListView getListView();
  
  public abstract IProfileConfig getProfileConfig();
  
  public abstract ViewGroup getRootView();
  
  public abstract void notifyCardUpdate();
  
  public abstract void notifyCardUpdate(Card paramCard);
  
  public abstract void removeProfileScrollListener(AbsListView.OnScrollListener paramOnScrollListener);
  
  public abstract void requestUpdateCard();
  
  public abstract void scrollToListTop();
  
  public abstract void scrollToMoreInfoView(int paramInt);
  
  public abstract void setInterceptTouchEvent(boolean paramBoolean);
  
  public abstract void setRemark(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
 * JD-Core Version:    0.7.0.1
 */
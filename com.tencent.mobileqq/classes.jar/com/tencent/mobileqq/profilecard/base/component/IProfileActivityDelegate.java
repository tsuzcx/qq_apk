package com.tencent.mobileqq.profilecard.base.component;

import com.tencent.widget.AbsListView.OnScrollListener;

public abstract interface IProfileActivityDelegate
{
  public abstract void addFriend();
  
  public abstract void addProfileScrollListener(AbsListView.OnScrollListener paramOnScrollListener);
  
  public abstract void notifyCardUpdate();
  
  public abstract void removeProfileScrollListener(AbsListView.OnScrollListener paramOnScrollListener);
  
  public abstract void requestUpdateCard();
  
  public abstract void scrollToMoreInfoView(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate
 * JD-Core Version:    0.7.0.1
 */
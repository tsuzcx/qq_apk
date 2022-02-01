package com.tencent.mobileqq.profilecard.activity;

import android.view.ViewGroup;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.view.PullToZoomHeaderListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class FriendProfileCardActivity$9
  implements IProfileActivityDelegate
{
  FriendProfileCardActivity$9(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void addProfileScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    FriendProfileCardActivity.access$1800(this.this$0, paramOnScrollListener);
  }
  
  public void checkAndSwitch2Friend(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    FriendProfileCardActivity.access$1100(this.this$0, paramBoolean1, paramBoolean2, paramString);
  }
  
  public PullToZoomHeaderListView getListView()
  {
    return FriendProfileCardActivity.access$1500(this.this$0);
  }
  
  public IProfileConfig getProfileConfig()
  {
    return FriendProfileCardActivity.access$1300(this.this$0);
  }
  
  public ViewGroup getRootView()
  {
    return (ViewGroup)FriendProfileCardActivity.access$1400(this.this$0);
  }
  
  public void notifyCardUpdate()
  {
    FriendProfileCardActivity.access$100(this.this$0, null);
  }
  
  public void notifyCardUpdate(Card paramCard)
  {
    FriendProfileCardActivity.access$100(this.this$0, paramCard);
  }
  
  public void removeProfileScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    FriendProfileCardActivity.access$1900(this.this$0, paramOnScrollListener);
  }
  
  public void requestUpdateCard()
  {
    FriendProfileCardActivity.access$1200(this.this$0, 0L, null, null, false);
  }
  
  public void scrollToListTop()
  {
    FriendProfileCardActivity.access$1600(this.this$0);
  }
  
  public void scrollToMoreInfoView(int paramInt)
  {
    FriendProfileCardActivity.access$1700(this.this$0, paramInt);
  }
  
  public void setInterceptTouchEvent(boolean paramBoolean)
  {
    FriendProfileCardActivity.access$2000(this.this$0, paramBoolean);
  }
  
  public void setRemark(String paramString)
  {
    FriendProfileCardActivity.access$2100(this.this$0, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.activity.FriendProfileCardActivity.9
 * JD-Core Version:    0.7.0.1
 */
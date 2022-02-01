package com.tencent.mobileqq.onlinestatus.binder;

import android.view.View;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.widget.SwipListView.RightIconMenuListener;

class AccountOnlineStateBinder$1
  implements SwipListView.RightIconMenuListener
{
  AccountOnlineStateBinder$1(AccountOnlineStateBinder paramAccountOnlineStateBinder) {}
  
  public void onRightIconMenuHide(View paramView)
  {
    if (AccountOnlineStateBinder.a(this.a) != null) {
      AccountOnlineStateBinder.a(this.a).setInterceptTouchFlag(true);
    }
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    if (AccountOnlineStateBinder.a(this.a) != null) {
      AccountOnlineStateBinder.a(this.a).setInterceptTouchFlag(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.binder.AccountOnlineStateBinder.1
 * JD-Core Version:    0.7.0.1
 */
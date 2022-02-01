package com.tencent.mobileqq.onlinestatus;

import android.view.View;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.widget.SwipListView.RightIconMenuListener;

class AccountOnlineStateActivity$2
  implements SwipListView.RightIconMenuListener
{
  AccountOnlineStateActivity$2(AccountOnlineStateActivity paramAccountOnlineStateActivity) {}
  
  public void onRightIconMenuHide(View paramView)
  {
    if (AccountOnlineStateActivity.a(this.a) != null) {
      AccountOnlineStateActivity.a(this.a).setInterceptTouchFlag(true);
    }
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    if (AccountOnlineStateActivity.a(this.a) != null) {
      AccountOnlineStateActivity.a(this.a).setInterceptTouchFlag(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.utils.CampusHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ProfileCardExtendFriendView$5$1
  implements View.OnClickListener
{
  ProfileCardExtendFriendView$5$1(ProfileCardExtendFriendView.5 param5) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.authState == 1L) {
      QQToast.a(this.a.this$0.getContext(), 0, 2131698710, 1).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.a.a.authState == 0L) || (this.a.a.authState == 3L)) {
        CampusHelper.a((FriendProfileCardActivity)ProfileCardExtendFriendView.a(this.a.this$0), this.a.a.idx, this.a.a.schoolName, this.a.a.schoolId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardExtendFriendView.5.1
 * JD-Core Version:    0.7.0.1
 */
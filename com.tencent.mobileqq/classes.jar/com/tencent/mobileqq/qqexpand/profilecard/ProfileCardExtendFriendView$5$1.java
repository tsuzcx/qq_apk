package com.tencent.mobileqq.qqexpand.profilecard;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;
import com.tencent.mobileqq.widget.QQToast;

class ProfileCardExtendFriendView$5$1
  implements View.OnClickListener
{
  ProfileCardExtendFriendView$5$1(ProfileCardExtendFriendView.5 param5) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.authState == 1L)
    {
      QQToast.a(this.a.this$0.getContext(), 0, 1913061378, 1).a();
      return;
    }
    if ((this.a.a.authState == 0L) || (this.a.a.authState == 3L)) {
      CampusHelper.a((Activity)ProfileCardExtendFriendView.a(this.a.this$0), this.a.a.idx, this.a.a.schoolName, this.a.a.schoolId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.profilecard.ProfileCardExtendFriendView.5.1
 * JD-Core Version:    0.7.0.1
 */
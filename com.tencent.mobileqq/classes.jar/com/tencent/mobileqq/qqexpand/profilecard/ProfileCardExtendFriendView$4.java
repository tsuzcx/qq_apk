package com.tencent.mobileqq.qqexpand.profilecard;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;
import com.tencent.mobileqq.widget.QQToast;

class ProfileCardExtendFriendView$4
  extends ClickableSpan
{
  ProfileCardExtendFriendView$4(ProfileCardExtendFriendView paramProfileCardExtendFriendView, Card paramCard) {}
  
  public void onClick(@NonNull View paramView)
  {
    if (this.a.authState == 1L)
    {
      QQToast.makeText(this.b.getContext(), 0, 1913061381, 1).show();
      return;
    }
    if ((this.a.authState == 0L) || (this.a.authState == 3L)) {
      CampusHelper.a((Activity)ProfileCardExtendFriendView.i(this.b), this.a.idx, this.a.schoolName, this.a.schoolId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.profilecard.ProfileCardExtendFriendView.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.qqexpand.profilecard;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class ProfileCardExtendFriendView$1
  implements View.OnLayoutChangeListener
{
  ProfileCardExtendFriendView$1(ProfileCardExtendFriendView paramProfileCardExtendFriendView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (!ProfileCardExtendFriendView.a(this.a))
    {
      this.a.removeOnLayoutChangeListener(this);
      return;
    }
    if ((ProfileCardExtendFriendView.a(this.a)) && (ProfileCardExtendFriendView.b(this.a)) && (ProfileCardExtendFriendView.c(this.a) == 0) && (ProfileCardExtendFriendView.d(this.a) == 0))
    {
      paramView = this.a;
      paramInt1 = paramInt4 - paramInt2;
      paramInt2 = paramInt8 - paramInt6;
      ProfileCardExtendFriendView.a(paramView, Math.max(paramInt1, paramInt2));
      ProfileCardExtendFriendView.b(this.a, Math.min(paramInt1, paramInt2));
      this.a.removeOnLayoutChangeListener(this);
      ProfileCardExtendFriendView.e(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.profilecard.ProfileCardExtendFriendView.1
 * JD-Core Version:    0.7.0.1
 */
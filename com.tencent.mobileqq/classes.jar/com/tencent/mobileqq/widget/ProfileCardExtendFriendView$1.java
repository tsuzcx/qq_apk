package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class ProfileCardExtendFriendView$1
  implements View.OnLayoutChangeListener
{
  ProfileCardExtendFriendView$1(ProfileCardExtendFriendView paramProfileCardExtendFriendView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (!ProfileCardExtendFriendView.a(this.a)) {
      this.a.removeOnLayoutChangeListener(this);
    }
    while ((!ProfileCardExtendFriendView.a(this.a)) || (!ProfileCardExtendFriendView.b(this.a)) || (ProfileCardExtendFriendView.a(this.a) != 0) || (ProfileCardExtendFriendView.b(this.a) != 0)) {
      return;
    }
    ProfileCardExtendFriendView.a(this.a, Math.max(paramInt4 - paramInt2, paramInt8 - paramInt6));
    ProfileCardExtendFriendView.b(this.a, Math.min(paramInt4 - paramInt2, paramInt8 - paramInt6));
    this.a.removeOnLayoutChangeListener(this);
    ProfileCardExtendFriendView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardExtendFriendView.1
 * JD-Core Version:    0.7.0.1
 */
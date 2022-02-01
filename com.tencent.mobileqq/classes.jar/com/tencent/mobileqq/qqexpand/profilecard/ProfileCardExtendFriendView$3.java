package com.tencent.mobileqq.qqexpand.profilecard;

import android.view.View;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ProfileCardExtendFriendView$3
  implements ActionSheet.OnButtonClickListener
{
  ProfileCardExtendFriendView$3(ProfileCardExtendFriendView paramProfileCardExtendFriendView) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if ((ProfileCardExtendFriendView.f(this.a)) && (!ProfileCardExtendFriendView.g(this.a)))
    {
      if (paramInt == 0)
      {
        this.a.a(false, true);
        VasWebviewUtil.a("strangers_makefriend", "card_actionsheet", "", 0, "", "1");
      }
    }
    else if ((!ProfileCardExtendFriendView.f(this.a)) && (ProfileCardExtendFriendView.g(this.a)))
    {
      if (paramInt == 0)
      {
        this.a.a(true, false);
        VasWebviewUtil.a("strangers_makefriend", "card_actionsheet", "", 0, "", "2");
      }
    }
    else if ((ProfileCardExtendFriendView.g(this.a)) && (ProfileCardExtendFriendView.f(this.a)))
    {
      if (paramInt == 0)
      {
        this.a.a(false, true);
        VasWebviewUtil.a("strangers_makefriend", "card_actionsheet", "", 0, "", "1");
      }
      else if (paramInt == 1)
      {
        this.a.a(true, false);
        VasWebviewUtil.a("strangers_makefriend", "card_actionsheet", "", 0, "", "2");
      }
    }
    else if ((!ProfileCardExtendFriendView.f(this.a)) && (!ProfileCardExtendFriendView.g(this.a)) && (paramInt == 0))
    {
      this.a.a(false, false);
      VasWebviewUtil.a("strangers_makefriend", "card_actionsheet", "", 0, "", "3");
    }
    VasWebviewUtil.a("strangers_makefriend", "card_actionsheet", "", 0, "", "4");
    ProfileCardExtendFriendView.h(this.a).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.profilecard.ProfileCardExtendFriendView.3
 * JD-Core Version:    0.7.0.1
 */
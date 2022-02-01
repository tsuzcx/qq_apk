package com.tencent.mobileqq.qqexpand.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;

class ExtendFriendOldProfileEditFragment$6
  implements View.OnClickListener
{
  ExtendFriendOldProfileEditFragment$6(ExtendFriendOldProfileEditFragment paramExtendFriendOldProfileEditFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.getQBaseActivity() != null)
    {
      if (ExtendFriendOldProfileEditFragment.n(this.a) != null) {
        paramView = ((IExpandManager)ExtendFriendOldProfileEditFragment.n(this.a).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).I();
      } else {
        paramView = "";
      }
      CampusHelper.a(this.a.getQBaseActivity(), paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendOldProfileEditFragment.6
 * JD-Core Version:    0.7.0.1
 */
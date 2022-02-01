package com.tencent.mobileqq.qqexpand.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;

class ExpandProfileEditFragment$6
  implements View.OnClickListener
{
  ExpandProfileEditFragment$6(ExpandProfileEditFragment paramExpandProfileEditFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.getQBaseActivity() != null)
    {
      if (ExpandProfileEditFragment.a(this.a) != null) {
        paramView = ((IExpandManager)ExpandProfileEditFragment.a(this.a).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).i();
      } else {
        paramView = "";
      }
      CampusHelper.a(this.a.getQBaseActivity(), paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandProfileEditFragment.6
 * JD-Core Version:    0.7.0.1
 */
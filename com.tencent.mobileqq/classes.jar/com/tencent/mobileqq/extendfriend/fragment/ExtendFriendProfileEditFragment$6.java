package com.tencent.mobileqq.extendfriend.fragment;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.utils.CampusHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ExtendFriendProfileEditFragment$6
  implements View.OnClickListener
{
  ExtendFriendProfileEditFragment$6(ExtendFriendProfileEditFragment paramExtendFriendProfileEditFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.getActivity() != null)
    {
      String str = "";
      if (this.a.getActivity().app != null) {
        str = ((ExtendFriendManager)this.a.getActivity().app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).h();
      }
      CampusHelper.a(this.a.getActivity(), str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.6
 * JD-Core Version:    0.7.0.1
 */
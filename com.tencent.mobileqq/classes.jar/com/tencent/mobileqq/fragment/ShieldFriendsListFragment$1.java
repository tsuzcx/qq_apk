package com.tencent.mobileqq.fragment;

import android.support.v4.app.FragmentActivity;
import anvk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.ArrayList;

class ShieldFriendsListFragment$1
  implements Runnable
{
  ShieldFriendsListFragment$1(ShieldFriendsListFragment paramShieldFriendsListFragment) {}
  
  public void run()
  {
    ArrayList localArrayList = ((anvk)this.this$0.getActivity().app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a();
    if (this.this$0.getActivity() == null) {
      return;
    }
    this.this$0.getActivity().runOnUiThread(new ShieldFriendsListFragment.1.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.ShieldFriendsListFragment.1
 * JD-Core Version:    0.7.0.1
 */
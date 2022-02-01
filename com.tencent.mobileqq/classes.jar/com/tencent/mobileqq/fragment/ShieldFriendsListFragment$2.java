package com.tencent.mobileqq.fragment;

import android.content.res.Resources;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class ShieldFriendsListFragment$2
  extends FriendListObserver
{
  ShieldFriendsListFragment$2(ShieldFriendsListFragment paramShieldFriendsListFragment) {}
  
  protected void onUpdateFriendShieldFlag(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    super.onUpdateFriendShieldFlag(paramLong, paramBoolean1, paramBoolean2, paramBoolean3, paramString);
    if (!paramBoolean2)
    {
      if (ShieldFriendsListFragment.a(this.a, paramLong, paramBoolean1 ^ true)) {
        QQToast.a(BaseApplication.getContext(), HardCodeUtil.a(2131713872), 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299168));
      }
    }
    else
    {
      if (ShieldFriendsListFragment.a(this.a).a(String.valueOf(paramLong)))
      {
        ShieldFriendsListFragment.a(this.a, paramLong, paramBoolean1);
        return;
      }
      paramString = ((FriendsManager)this.a.getBaseActivity().app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(String.valueOf(paramLong));
      if ((paramString != null) && (!paramString.isShield()))
      {
        ShieldFriendsListFragment.a(this.a).a(paramString);
        ShieldFriendsListFragment.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.ShieldFriendsListFragment.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.extendfriend.fragment;

import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.extendfriend.bean.StrangerInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

class ExtendFriendSearchFragment$2
  extends FriendListObserver
{
  ExtendFriendSearchFragment$2(ExtendFriendSearchFragment paramExtendFriendSearchFragment) {}
  
  public void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSearchFragment", 2, String.format("onUpdateAddFriend isSuccess=%s addSuccess=%s reqestUin=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString }));
    }
    paramString = this.a.a.a(this.a.c);
    if ((paramString != null) && (!paramString.mAddFriendVerified))
    {
      paramString.mAddFriendVerified = true;
      ExtendFriendSearchFragment.a(this.a).post(new ExtendFriendSearchFragment.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment.2
 * JD-Core Version:    0.7.0.1
 */
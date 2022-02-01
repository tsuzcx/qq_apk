package com.tencent.mobileqq.qqexpand.fragment;

import android.os.Bundle;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

class ExtendFriendSquareFragment$1
  extends FriendObserver
{
  ExtendFriendSquareFragment$1(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onUpdateAddFriend isSuccess=%s addSuccess=%s reqestUin=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString }));
    }
    paramString = this.a.a.a(this.a.d);
    if ((paramString != null) && (!paramString.mAddFriendVerified))
    {
      paramString.mAddFriendVerified = true;
      ExtendFriendSquareFragment.a(this.a).post(new ExtendFriendSquareFragment.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSquareFragment.1
 * JD-Core Version:    0.7.0.1
 */
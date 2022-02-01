package com.tencent.mobileqq.newfriend.ui.fragment;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.newfriend.data.AddFriendBlockedInfo;
import com.tencent.mobileqq.newfriend.observer.NewFriendVerificationObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class NewFriendVerifyBlockedListFragment$2
  extends NewFriendVerificationObserver
{
  NewFriendVerifyBlockedListFragment$2(NewFriendVerifyBlockedListFragment paramNewFriendVerifyBlockedListFragment) {}
  
  public void a(boolean paramBoolean, List<AddFriendBlockedInfo> paramList, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("onGetAddFriendBlockedList, success=");
      paramList.append(paramBoolean);
      QLog.i("BlockedListFragment", 2, paramList.toString());
    }
    if ((paramBoolean) && (NewFriendVerifyBlockedListFragment.a(this.a) != null) && (!NewFriendVerifyBlockedListFragment.a(this.a).isFinishing()) && (NewFriendVerifyBlockedListFragment.a(this.a) != null))
    {
      if (NewFriendVerifyBlockedListFragment.a(this.a) == null) {
        return;
      }
      this.a.a.removeMessages(1);
      this.a.a.sendEmptyMessage(1);
    }
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.a.a.removeMessages(1);
      this.a.a.sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.fragment.NewFriendVerifyBlockedListFragment.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.extendfriend.fragment;

import com.tencent.mobileqq.extendfriend.bean.MatchFeedInfo;
import com.tencent.mobileqq.extendfriend.bean.StrangerInfo;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ExtendFriendSearchFragment$1
  extends ExtendFriendObserver
{
  ExtendFriendSearchFragment$1(ExtendFriendSearchFragment paramExtendFriendSearchFragment) {}
  
  public void onGetSquareStrangerList(boolean paramBoolean1, long paramLong, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<StrangerInfo> paramList, MatchFeedInfo paramMatchFeedInfo)
  {
    if (this.a.b != paramLong) {
      return;
    }
    try
    {
      ExtendFriendSearchFragment.a(this.a, 1);
      ExtendFriendSearchFragment.a(this.a, paramBoolean1, paramString, paramBoolean2, paramArrayOfByte, paramBoolean3, paramBoolean4, paramInt, paramList, paramMatchFeedInfo);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ExtendFriendSearchFragment", 1, "onGetSquareStrangerList exception", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment.1
 * JD-Core Version:    0.7.0.1
 */
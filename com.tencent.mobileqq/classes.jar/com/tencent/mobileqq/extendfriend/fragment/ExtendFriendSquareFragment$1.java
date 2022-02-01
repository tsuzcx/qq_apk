package com.tencent.mobileqq.extendfriend.fragment;

import com.tencent.mobileqq.extendfriend.bean.MatchFeedInfo;
import com.tencent.mobileqq.extendfriend.bean.MatchInfo;
import com.tencent.mobileqq.extendfriend.bean.StrangerInfo;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ExtendFriendSquareFragment$1
  extends ExtendFriendObserver
{
  ExtendFriendSquareFragment$1(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void onGetSquareStrangerList(boolean paramBoolean1, long paramLong, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<StrangerInfo> paramList, MatchFeedInfo paramMatchFeedInfo)
  {
    if (this.a.b != paramLong) {
      return;
    }
    try
    {
      ExtendFriendSquareFragment.a(this.a, 1);
      ExtendFriendSquareFragment.a(this.a, paramBoolean1, paramString, paramBoolean2, paramArrayOfByte, paramBoolean3, paramBoolean4, paramInt, paramList, paramMatchFeedInfo);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ExtendFriendSquareFragment", 1, "onGetSquareStrangerList exception", paramString);
    }
  }
  
  public void onLimitChatResourceStateUpdate(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onLimitChatResourceStateUpdate, isReady = " + paramBoolean);
    }
    ExtendFriendSquareFragment.a(this.a);
  }
  
  public void onMatchResponse(boolean paramBoolean, int paramInt1, int paramInt2, MatchInfo paramMatchInfo, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onMatchResponse success=%s match_op=%s retCode=%s info=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramMatchInfo }));
    }
  }
  
  public void onUpdateCampusCertificateStatus(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onUpdateCampusCertificateStatus isSuccess=%s scene=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if ((paramBoolean) && (paramInt == 1)) {
      ExtendFriendSquareFragment.b(this.a);
    }
    if (paramBoolean) {
      ExtendFriendSquareFragment.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment.1
 * JD-Core Version:    0.7.0.1
 */
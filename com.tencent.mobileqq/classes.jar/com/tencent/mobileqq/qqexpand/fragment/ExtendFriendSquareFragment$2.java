package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qqexpand.bean.match.MatchFeedInfo;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ExtendFriendSquareFragment$2
  extends ExpandObserver
{
  ExtendFriendSquareFragment$2(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onUpdateCampusCertificateStatus isSuccess=%s scene=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if ((paramBoolean) && (paramInt == 1)) {
      ExtendFriendSquareFragment.c(this.a);
    }
    if (paramBoolean) {
      ExtendFriendSquareFragment.b(this.a);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, MatchInfo paramMatchInfo, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onMatchResponse success=%s match_op=%s retCode=%s info=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramMatchInfo }));
    }
  }
  
  protected void a(boolean paramBoolean1, long paramLong, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<StrangerInfo> paramList, MatchFeedInfo paramMatchFeedInfo)
  {
    if (this.a.O != paramLong) {
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
  
  protected void f(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLimitChatResourceStateUpdate, isReady = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("ExtendFriendSquareFragment", 2, localStringBuilder.toString());
    }
    ExtendFriendSquareFragment.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSquareFragment.2
 * JD-Core Version:    0.7.0.1
 */
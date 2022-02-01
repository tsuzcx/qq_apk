package com.tencent.mobileqq.profile.vote;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.statistics.ReportController;

class VoteHelper$1
  implements Runnable
{
  VoteHelper$1(VoteHelper paramVoteHelper, long paramLong1, int paramInt, boolean paramBoolean, long paramLong2) {}
  
  public void run()
  {
    boolean bool = ((FriendsManager)this.this$0.c.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(Long.toString(this.a));
    int i;
    if (this.b == 2)
    {
      if (bool) {
        i = 5;
      } else {
        i = 6;
      }
    }
    else if (bool) {
      i = 7;
    } else {
      i = 8;
    }
    int j;
    if (PraiseManager.a(this.this$0.c) > 0)
    {
      if (this.c) {
        j = 2;
      } else {
        j = 3;
      }
    }
    else if (this.c) {
      j = 0;
    } else {
      j = 1;
    }
    ReportController.b(this.this$0.c, "CliOper", "", "", "P_prof", "Prof_good", i, 1, j, Long.toString(this.d), "1", this.this$0.c.getCurrentAccountUin(), Long.toString(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.vote.VoteHelper.1
 * JD-Core Version:    0.7.0.1
 */
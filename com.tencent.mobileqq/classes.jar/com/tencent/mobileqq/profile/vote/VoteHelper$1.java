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
    int j = 2;
    boolean bool = ((FriendsManager)this.this$0.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(Long.toString(this.jdField_a_of_type_Long));
    int i;
    if (this.jdField_a_of_type_Int == 2) {
      if (bool)
      {
        i = 5;
        if (PraiseManager.a(this.this$0.a) <= 0) {
          break label140;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label135;
        }
      }
    }
    for (;;)
    {
      ReportController.b(this.this$0.a, "CliOper", "", "", "P_prof", "Prof_good", i, 1, j, Long.toString(this.b), "1", this.this$0.a.getCurrentAccountUin(), Long.toString(this.jdField_a_of_type_Long));
      return;
      i = 6;
      break;
      if (bool)
      {
        i = 7;
        break;
      }
      i = 8;
      break;
      label135:
      j = 3;
      continue;
      label140:
      if (this.jdField_a_of_type_Boolean) {
        j = 0;
      } else {
        j = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.vote.VoteHelper.1
 * JD-Core Version:    0.7.0.1
 */
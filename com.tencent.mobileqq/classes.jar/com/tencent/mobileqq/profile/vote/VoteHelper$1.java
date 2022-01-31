package com.tencent.mobileqq.profile.vote;

import alto;
import awwy;
import azqs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.like.PraiseManager;

public class VoteHelper$1
  implements Runnable
{
  public VoteHelper$1(awwy paramawwy, long paramLong1, int paramInt, boolean paramBoolean, long paramLong2) {}
  
  public void run()
  {
    int j = 2;
    boolean bool = ((alto)this.this$0.a.getManager(51)).b(Long.toString(this.jdField_a_of_type_Long));
    int i;
    if (this.jdField_a_of_type_Int == 2) {
      if (bool)
      {
        i = 5;
        if (PraiseManager.a(this.this$0.a) <= 0) {
          break label139;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label134;
        }
      }
    }
    for (;;)
    {
      azqs.b(this.this$0.a, "CliOper", "", "", "P_prof", "Prof_good", i, 1, j, Long.toString(this.b), "1", this.this$0.a.getCurrentAccountUin(), Long.toString(this.jdField_a_of_type_Long));
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
      label134:
      j = 3;
      continue;
      label139:
      if (this.jdField_a_of_type_Boolean) {
        j = 0;
      } else {
        j = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.vote.VoteHelper.1
 * JD-Core Version:    0.7.0.1
 */
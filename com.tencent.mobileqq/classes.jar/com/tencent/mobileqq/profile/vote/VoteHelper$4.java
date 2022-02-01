package com.tencent.mobileqq.profile.vote;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.util.VoteUtil;
import com.tencent.qphone.base.util.QLog;

class VoteHelper$4
  implements Runnable
{
  VoteHelper$4(VoteHelper paramVoteHelper, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateCardProfileFromDb uin:");
      ((StringBuilder)localObject).append(this.a);
      QLog.i("VisitorsActivity.VoteHelper", 2, ((StringBuilder)localObject).toString());
    }
    CardProfile localCardProfile = VoteUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a, 2);
    Object localObject = localCardProfile;
    if (localCardProfile == null) {
      localObject = VoteUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a, 3);
    }
    if (localObject != null)
    {
      ((CardProfile)localObject).updateTime(System.currentTimeMillis() / 1000L);
      this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(9, localObject).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.vote.VoteHelper.4
 * JD-Core Version:    0.7.0.1
 */
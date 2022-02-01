package com.tencent.mobileqq.kandian.repo.report;

import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager.Companion;

class UserOperationModule$6
  implements Runnable
{
  UserOperationModule$6(UserOperationModule paramUserOperationModule, int paramInt1, String paramString1, String paramString2, int paramInt2, boolean paramBoolean) {}
  
  public void run()
  {
    RIJPushNotifyManager.Companion.a().showPushNotifyDialog(this.a, this.b, this.c, this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.report.UserOperationModule.6
 * JD-Core Version:    0.7.0.1
 */
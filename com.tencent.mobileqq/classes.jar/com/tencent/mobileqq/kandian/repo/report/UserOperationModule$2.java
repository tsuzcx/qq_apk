package com.tencent.mobileqq.kandian.repo.report;

import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager.Companion;

class UserOperationModule$2
  implements Runnable
{
  UserOperationModule$2(UserOperationModule paramUserOperationModule, String paramString) {}
  
  public void run()
  {
    RIJPushNotifyManager.Companion.a().dismiss(true, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.report.UserOperationModule.2
 * JD-Core Version:    0.7.0.1
 */
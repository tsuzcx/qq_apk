package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;

class KandianMergeManager$19
  implements Runnable
{
  KandianMergeManager$19(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.b = AppConstants.NEW_KANDIAN_UIN;
    localSessionInfo.a = 1008;
    ChatActivityFacade.a(KandianMergeManager.c(this.this$0), localSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.19
 * JD-Core Version:    0.7.0.1
 */
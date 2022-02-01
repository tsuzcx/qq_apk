package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;

class KandianMergeManager$28
  implements Runnable
{
  KandianMergeManager$28(KandianMergeManager paramKandianMergeManager, String paramString, int paramInt) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.b = AppConstants.NEW_KANDIAN_UIN;
    localSessionInfo.a = 1008;
    ChatActivityFacade.a(KandianMergeManager.c(this.this$0), localSessionInfo);
    KandianMergeManager.c(this.this$0).getMessageFacade().a(this.a, this.b, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.28
 * JD-Core Version:    0.7.0.1
 */
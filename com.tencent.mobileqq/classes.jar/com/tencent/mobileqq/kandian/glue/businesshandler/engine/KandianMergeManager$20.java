package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;

class KandianMergeManager$20
  implements Runnable
{
  KandianMergeManager$20(KandianMergeManager paramKandianMergeManager, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    KandianMergeManager.c(this.this$0).getMessageFacade().a(AppConstants.KANDIAN_MERGE_UIN, 7220, false, false);
    if (this.a.extInt == 2)
    {
      KandianMergeManager.c(this.this$0).getMessageFacade().h(AppConstants.KANDIAN_MERGE_UIN, 7220, this.a.uniseq);
      if (KandianMergeManager.h(this.this$0).get() > 0) {
        this.this$0.d(2);
      }
    }
    else
    {
      if (this.a.extInt == 1)
      {
        SessionInfo localSessionInfo = new SessionInfo();
        localSessionInfo.b = AppConstants.NEW_KANDIAN_UIN;
        localSessionInfo.a = 1008;
        ChatActivityFacade.a(KandianMergeManager.c(this.this$0), localSessionInfo);
        return;
      }
      if (this.a.extInt == 5) {
        KandianMergeManager.c(this.this$0).getMessageFacade().h(AppConstants.KANDIAN_MERGE_UIN, 7220, this.a.uniseq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.20
 * JD-Core Version:    0.7.0.1
 */
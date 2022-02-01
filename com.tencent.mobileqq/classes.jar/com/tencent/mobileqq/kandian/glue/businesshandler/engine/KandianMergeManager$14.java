package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;

class KandianMergeManager$14
  implements Runnable
{
  KandianMergeManager$14(KandianMergeManager paramKandianMergeManager, QQMessageFacade paramQQMessageFacade, String paramString1, String paramString2, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.a.r(AppConstants.KANDIAN_MERGE_UIN, 7220);
    if (localMessageRecord != null) {
      localMessageRecord = KandianMergeManager.a(this.this$0, localMessageRecord, this.b, this.c, this.d, this.e);
    } else {
      localMessageRecord = KandianMergeManager.a(this.this$0, this.b, this.c, this.d);
    }
    if (localMessageRecord != null)
    {
      RIJKanDianFolderStatus.updateLastKandianMsgRecord(localMessageRecord);
      this.a.a(localMessageRecord, KandianMergeManager.c(this.this$0).getCurrentUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.14
 * JD-Core Version:    0.7.0.1
 */
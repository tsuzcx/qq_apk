package com.tencent.mobileqq.kandian.biz.push;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.feeds.entity.RedPntInfoForReport;

final class RIJKanDianFolderStatus$1
  implements Runnable
{
  RIJKanDianFolderStatus$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = this.a.getMessageFacade();
    if (localObject == null) {
      return;
    }
    MessageRecord localMessageRecord = ((QQMessageFacade)localObject).b(AppConstants.KANDIAN_MERGE_UIN, 7220);
    localObject = localMessageRecord;
    if (RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.a != null) {
      if (localMessageRecord != null)
      {
        localObject = localMessageRecord;
        if (localMessageRecord.time > RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.a.time) {}
      }
      else
      {
        localObject = RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.a;
      }
    }
    RIJKanDianFolderStatus.updateKandianFolderStatus(this.a, (MessageRecord)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus.1
 * JD-Core Version:    0.7.0.1
 */
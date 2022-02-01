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
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.b(AppConstants.KANDIAN_MERGE_UIN, 7220);
    if (localMessageRecord != null) {
      localMessageRecord = KandianMergeManager.a(this.this$0, localMessageRecord, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
    } else {
      localMessageRecord = KandianMergeManager.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
    }
    if (localMessageRecord != null)
    {
      RIJKanDianFolderStatus.updateLastKandianMsgRecord(localMessageRecord);
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(localMessageRecord, KandianMergeManager.a(this.this$0).getCurrentUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.14
 * JD-Core Version:    0.7.0.1
 */
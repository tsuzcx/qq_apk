package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJWeiShiLegacyUtils$createMsgForWeishi$1
  implements Runnable
{
  RIJWeiShiLegacyUtils$createMsgForWeishi$1(QQMessageFacade paramQQMessageFacade, String paramString, long paramLong, QQAppInterface paramQQAppInterface) {}
  
  public final void run()
  {
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.b(AppConstants.WEISHI_UIN, 1008);
    if (localMessageRecord != null)
    {
      localMessageRecord = RIJWeiShiLegacyUtils.a(RIJWeiShiLegacyUtils.a, localMessageRecord, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
      if (localMessageRecord != null) {}
    }
    else
    {
      localMessageRecord = RIJWeiShiLegacyUtils.a.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
    }
    if (localMessageRecord != null) {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.RIJWeiShiLegacyUtils.createMsgForWeishi.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ecshop.view.controller;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.ecshop.view.EcshopAdViewHelper.DeleteMsgListener;
import com.tencent.mobileqq.ecshop.view.adcard.AdCardModel;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import mqq.app.AppRuntime;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/data/MessageRecord;", "kotlin.jvm.PlatformType", "delete", "com/tencent/mobileqq/ecshop/view/controller/AdViewPagerController$initMsgData$adCardController$1$1"}, k=3, mv={1, 1, 16})
final class AdViewPagerController$initMsgData$$inlined$apply$lambda$1
  implements EcshopAdViewHelper.DeleteMsgListener
{
  AdViewPagerController$initMsgData$$inlined$apply$lambda$1(AdViewPagerController paramAdViewPagerController, AdCardModel paramAdCardModel, List paramList, IEcshopMessageApi paramIEcshopMessageApi) {}
  
  public final void a(MessageRecord paramMessageRecord)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("delete before msgList.size = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
    QLog.d("AdViewPagerController", 1, localStringBuilder.toString());
    ((IMessageFacade)AppUtils.a().getRuntimeService(IMessageFacade.class, "")).removeMsgByMessageRecord(paramMessageRecord, false);
    paramMessageRecord = AdViewPagerController.a(this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerAdViewPagerController);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("delete after msgList.size = ");
    localStringBuilder.append(paramMessageRecord.size());
    QLog.d("AdViewPagerController", 1, localStringBuilder.toString());
    AdViewPagerController.a(this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerAdViewPagerController);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.controller.AdViewPagerController.initMsgData..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */
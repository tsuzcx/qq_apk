package com.tencent.mobileqq.ecshop.view;

import android.content.Context;
import android.view.View;
import com.tencent.ad.tangram.AdError;
import com.tencent.gdtad.api.feedback.GdtFeedbackListener;
import com.tencent.gdtad.api.feedback.GdtFeedbackResultParams;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopPublicAccountChatPieTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class EcshopAdViewHelper$2
  implements GdtFeedbackListener
{
  EcshopAdViewHelper$2(EcshopAdViewHelper paramEcshopAdViewHelper, EcshopAdViewHelper.DeleteMsgListener paramDeleteMsgListener, MessageRecord paramMessageRecord, Context paramContext, View paramView, String paramString) {}
  
  public void a(GdtFeedbackResultParams paramGdtFeedbackResultParams)
  {
    int i = paramGdtFeedbackResultParams.jdField_a_of_type_ComTencentAdTangramAdError.getErrorCode();
    int j = paramGdtFeedbackResultParams.jdField_a_of_type_Int;
    paramGdtFeedbackResultParams = new StringBuilder();
    paramGdtFeedbackResultParams.append("errorCode = ");
    paramGdtFeedbackResultParams.append(i);
    paramGdtFeedbackResultParams.append(" ; action = ");
    paramGdtFeedbackResultParams.append(j);
    QLog.d("Ecshop_EcshopAdViewHelper", 1, paramGdtFeedbackResultParams.toString());
    if ((i == 0) && (j == 3))
    {
      paramGdtFeedbackResultParams = this.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopAdViewHelper$DeleteMsgListener;
      if (paramGdtFeedbackResultParams != null)
      {
        paramGdtFeedbackResultParams.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        return;
      }
      ((IEcshopPublicAccountChatPieTempApi)QRoute.api(IEcshopPublicAccountChatPieTempApi.class)).startDelAnimAndDelMsg((ChatMessage)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      return;
    }
    if (i != 0) {
      this.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopAdViewHelper.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopAdViewHelper$DeleteMsgListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.EcshopAdViewHelper.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;

class MessengerService$IncomingHandler$9
  extends CallBacker
{
  MessengerService$IncomingHandler$9(MessengerService.IncomingHandler paramIncomingHandler, MessengerService paramMessengerService, QQAppInterface paramQQAppInterface) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((paramLong == 15L) && ("cardWZ.zip".equals(paramString1)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a != null)
      {
        paramString1 = new Bundle();
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a.putString("cmd", "card_download_wzry_template");
        paramString1.putInt("result", paramInt1);
        paramString1.putString("message", paramString3);
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a.putBundle("response", paramString1);
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a);
        this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a = null;
      }
      paramString1 = (IVasQuickUpdateService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
      if (paramString1 != null) {
        paramString1.removeCallBacker(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.9
 * JD-Core Version:    0.7.0.1
 */
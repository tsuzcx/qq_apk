package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.floatscr.ColorScreenConfig;
import com.tencent.mobileqq.vas.VasManager.CompleteListener;
import com.tencent.mobileqq.vas.VasMonitorDT;
import com.tencent.mobileqq.vas.VasMonitorHandler;

class MessengerService$IncomingHandler$4
  implements VasManager.CompleteListener<ColorScreenConfig>
{
  MessengerService$IncomingHandler$4(MessengerService.IncomingHandler paramIncomingHandler, int paramInt, SVIPHandler paramSVIPHandler, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void a(ColorScreenConfig paramColorScreenConfig, Object paramObject)
  {
    paramObject = new Bundle();
    paramObject.putInt("id", this.jdField_a_of_type_Int);
    if ((paramColorScreenConfig != null) || (this.jdField_a_of_type_Int == 0))
    {
      paramObject.putInt("result", 0);
      this.jdField_a_of_type_ComTencentMobileqqAppSVIPHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", paramObject);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
      VasMonitorHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "individual_v2_colorscreen_set_fail", "0", "", Integer.toString(this.jdField_a_of_type_Int), null, null, 0.0F, 0.0F);
      VasMonitorDT.a("individual_v2_colorscreen_set_fail", "id:" + this.jdField_a_of_type_Int);
      paramObject.putInt("result", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.4
 * JD-Core Version:    0.7.0.1
 */
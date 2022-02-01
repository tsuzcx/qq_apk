package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.floatscr.ColorScreenConfig;
import com.tencent.mobileqq.vas.VasManager.CompleteListener;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.util.VasMonitorDT;

class MessengerService$IncomingHandler$4
  implements VasManager.CompleteListener<ColorScreenConfig>
{
  MessengerService$IncomingHandler$4(MessengerService.IncomingHandler paramIncomingHandler, int paramInt, ISVIPHandler paramISVIPHandler, QQAppInterface paramQQAppInterface, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void a(ColorScreenConfig paramColorScreenConfig, Object paramObject)
  {
    paramObject = new Bundle();
    paramObject.putInt("id", this.jdField_a_of_type_Int);
    if (paramColorScreenConfig == null)
    {
      int i = this.jdField_a_of_type_Int;
      if (i != 0)
      {
        VasMonitorHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "individual_v2_colorscreen_set_fail", "0", "", Integer.toString(i), null, null, 0.0F, 0.0F);
        paramColorScreenConfig = new StringBuilder();
        paramColorScreenConfig.append("id:");
        paramColorScreenConfig.append(this.jdField_a_of_type_Int);
        VasMonitorDT.a("individual_v2_colorscreen_set_fail", paramColorScreenConfig.toString());
        paramObject.putInt("result", 1);
        break label125;
      }
    }
    paramObject.putInt("result", 0);
    this.jdField_a_of_type_ComTencentMobileqqVasSvipApiISVIPHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int);
    label125:
    this.jdField_a_of_type_AndroidOsBundle.putBundle("response", paramObject);
    this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.4
 * JD-Core Version:    0.7.0.1
 */
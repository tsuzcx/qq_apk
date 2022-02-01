package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import cooperation.qqfav.util.HandlerPlus;

class AuthorityActivity$8$6
  implements Runnable
{
  AuthorityActivity$8$6(AuthorityActivity.8 param8, String paramString) {}
  
  public void run()
  {
    ForwardStatisticsReporter.a("KEY_GET_APP_ADS_PIC");
    Bitmap localBitmap = AuthorityActivity.a(this.jdField_a_of_type_JavaLangString);
    ForwardStatisticsReporter.a("KEY_GET_APP_ADS_PIC", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$8.a.jdField_a_of_type_ComTencentOpenModelAccountInfo);
    if (localBitmap != null)
    {
      Message localMessage = new Message();
      localMessage.obj = localBitmap;
      localMessage.what = 9;
      this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$8.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityActivity.8.6
 * JD-Core Version:    0.7.0.1
 */
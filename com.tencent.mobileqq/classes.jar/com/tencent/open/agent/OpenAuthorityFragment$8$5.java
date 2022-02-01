package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import cooperation.qqfav.util.HandlerPlus;

class OpenAuthorityFragment$8$5
  implements Runnable
{
  OpenAuthorityFragment$8$5(OpenAuthorityFragment.8 param8, String paramString) {}
  
  public void run()
  {
    ForwardStatisticsReporter.a("KEY_GET_APP_ADS_PIC");
    Bitmap localBitmap = OpenAuthorityFragment.a(this.jdField_a_of_type_JavaLangString);
    ForwardStatisticsReporter.a("KEY_GET_APP_ADS_PIC", OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment$8.a));
    if (localBitmap != null)
    {
      Message localMessage = new Message();
      localMessage.obj = localBitmap;
      localMessage.what = 9;
      this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment$8.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.8.5
 * JD-Core Version:    0.7.0.1
 */
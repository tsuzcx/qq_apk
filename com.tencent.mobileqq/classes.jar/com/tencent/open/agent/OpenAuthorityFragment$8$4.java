package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.biz.webviewplugin.Share.IconUrlSize;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.qqfav.util.HandlerPlus;

class OpenAuthorityFragment$8$4
  implements Runnable
{
  OpenAuthorityFragment$8$4(OpenAuthorityFragment.8 param8, Share.IconUrlSize paramIconUrlSize) {}
  
  public void run()
  {
    ForwardStatisticsReporter.a("KEY_GET_APP_ICON");
    Bitmap localBitmap = OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentBizWebviewpluginShare$IconUrlSize.a.get());
    ForwardStatisticsReporter.a("KEY_GET_APP_ICON", OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment$8.a));
    OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment$8.a).a(OpenAuthorityFragment.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment$8.a), localBitmap);
    if (localBitmap != null)
    {
      Message localMessage = new Message();
      localMessage.obj = localBitmap;
      localMessage.what = 4;
      this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityFragment$8.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.8.4
 * JD-Core Version:    0.7.0.1
 */
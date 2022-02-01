package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import cooperation.qqfav.util.HandlerPlus;

class AuthorityActivity$8$5
  implements Runnable
{
  AuthorityActivity$8$5(AuthorityActivity.8 param8, GetAppInfoProto.MsgIconsurl paramMsgIconsurl) {}
  
  public void run()
  {
    ForwardStatisticsReporter.a("KEY_GET_APP_ICON");
    Bitmap localBitmap = AuthorityActivity.a(this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$MsgIconsurl.url.get());
    ForwardStatisticsReporter.a("KEY_GET_APP_ICON", this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$8.a.jdField_a_of_type_ComTencentOpenModelAccountInfo);
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$8.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(AuthorityActivity.e, localBitmap);
    if (localBitmap != null)
    {
      Message localMessage = new Message();
      localMessage.obj = localBitmap;
      localMessage.what = 4;
      this.jdField_a_of_type_ComTencentOpenAgentAuthorityActivity$8.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityActivity.8.5
 * JD-Core Version:    0.7.0.1
 */
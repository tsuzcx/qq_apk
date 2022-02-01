package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;

class BindGroupConfirmActivity$2$1
  implements Runnable
{
  BindGroupConfirmActivity$2$1(BindGroupConfirmActivity.2 param2, GetAppInfoProto.MsgIconsurl paramMsgIconsurl) {}
  
  public void run()
  {
    Bitmap localBitmap = AuthorityUtil.a(this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$MsgIconsurl.url.get());
    if (localBitmap != null)
    {
      Message localMessage = new Message();
      localMessage.obj = localBitmap;
      localMessage.what = 4;
      this.jdField_a_of_type_ComTencentOpenAgentBindGroupConfirmActivity$2.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity.2.1
 * JD-Core Version:    0.7.0.1
 */
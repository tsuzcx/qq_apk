package com.tencent.mobileqq.mini.mainpage;

import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeObserver;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0x87a.RspBody;
import tencent.im.oidb.oidb_0x87c.RspBody;

class AddPhoneNumberFragment$2$1
  extends MiniAppSendSmsCodeObserver
{
  AddPhoneNumberFragment$2$1(AddPhoneNumberFragment.2 param2) {}
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    super.onFailedResponse(paramString1, paramInt, paramString2);
    AppBrandTask.runTaskOnUiThread(new AddPhoneNumberFragment.2.1.1(this, paramString2));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("send onFailedResponse cmd : ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", code : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("; message : ");
    localStringBuilder.append(paramString2);
    QLog.e("AddPhoneNumberFragment", 1, localStringBuilder.toString());
  }
  
  public void sendSmsCodeSuccess(oidb_0x87a.RspBody paramRspBody)
  {
    super.sendSmsCodeSuccess(paramRspBody);
    QLog.d("AddPhoneNumberFragment", 1, "send success");
    if (paramRspBody != null)
    {
      AddPhoneNumberFragment.access$102(this.this$1.this$0, paramRspBody.uint32_resend_interval.get());
      int i = 60;
      if (paramRspBody.uint32_resend_interval.get() > 0) {
        i = paramRspBody.uint32_resend_interval.get();
      }
      AddPhoneNumberFragment.access$200(this.this$1.this$0, i);
    }
  }
  
  public void verifySmsCodeSuccess(oidb_0x87c.RspBody paramRspBody)
  {
    super.verifySmsCodeSuccess(paramRspBody);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.2.1
 * JD-Core Version:    0.7.0.1
 */
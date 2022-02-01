package com.tencent.mobileqq.mini.mainpage;

import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeObserver;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0x87c.RspBody;

class AddPhoneNumberFragment$8$1
  extends MiniAppSendSmsCodeObserver
{
  AddPhoneNumberFragment$8$1(AddPhoneNumberFragment.8 param8) {}
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    super.onFailedResponse(paramString1, paramInt, paramString2);
    AppBrandTask.runTaskOnUiThread(new AddPhoneNumberFragment.8.1.2(this, paramString2));
    QLog.e("AddPhoneNumberFragment", 1, "verify onFailedResponse cmd : " + paramString1 + ", code : " + paramInt + "; message : " + paramString2);
  }
  
  public void verifySmsCodeSuccess(oidb_0x87c.RspBody paramRspBody)
  {
    int i = 1;
    super.verifySmsCodeSuccess(paramRspBody);
    QLog.d("AddPhoneNumberFragment", 1, "verify success");
    paramRspBody = MiniAppCmdUtil.getInstance();
    String str1 = AddPhoneNumberFragment.access$1200(this.this$1.this$0);
    String str2 = AddPhoneNumberFragment.access$000(this.this$1.this$0);
    if (AddPhoneNumberFragment.access$700(this.this$1.this$0)) {}
    for (;;)
    {
      paramRspBody.addPhoneNumber(str1, str2, "+86", i, new AddPhoneNumberFragment.8.1.1(this));
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.AddPhoneNumberFragment.8.1
 * JD-Core Version:    0.7.0.1
 */
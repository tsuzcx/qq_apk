package com.tencent.mobileqq.wxmini.impl.ui;

import com.tencent.luggage.wxaapi.TdiAuthErrCode;
import com.tencent.luggage.wxaapi.TdiAuthListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class PreloadingFragment$5$1
  implements TdiAuthListener
{
  PreloadingFragment$5$1(PreloadingFragment.5 param5, long paramLong) {}
  
  public void onAuthFinish(TdiAuthErrCode paramTdiAuthErrCode, String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.a;
    Object localObject1 = this.b.e;
    String str = this.b.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramTdiAuthErrCode);
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(l1 - l2);
    PreloadingFragment.a((PreloadingFragment)localObject1, "wx_sendAuth_result", str, (String)localObject2, localStringBuilder.toString(), "");
    if (paramTdiAuthErrCode == TdiAuthErrCode.WechatTdi_Auth_Err_OK)
    {
      paramTdiAuthErrCode = new StringBuilder();
      paramTdiAuthErrCode.append("sendAuth success launchWeixinMiniAppById appid;");
      paramTdiAuthErrCode.append(this.b.a);
      QLog.d("wxmini.PreloadingFragment", 1, paramTdiAuthErrCode.toString());
      PreloadingFragment.a(this.b.e, this.b.b, this.b.a, this.b.c, this.b.d);
      return;
    }
    if (paramTdiAuthErrCode == TdiAuthErrCode.WechatTdi_Auth_Err_WechatNotInstalled)
    {
      PreloadingFragment.a(this.b.e, this.b.b);
      return;
    }
    if (paramTdiAuthErrCode == TdiAuthErrCode.WechatTdi_Auth_Err_WechatVersionTooLow)
    {
      PreloadingFragment.b(this.b.e, this.b.b);
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("sendAuth fail errCode:");
    ((StringBuilder)localObject1).append(paramTdiAuthErrCode);
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(paramString);
    QLog.e("wxmini.PreloadingFragment", 1, ((StringBuilder)localObject1).toString());
    ThreadManager.getUIHandler().post(new PreloadingFragment.5.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.PreloadingFragment.5.1
 * JD-Core Version:    0.7.0.1
 */
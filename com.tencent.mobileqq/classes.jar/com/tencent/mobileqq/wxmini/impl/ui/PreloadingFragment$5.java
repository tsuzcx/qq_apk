package com.tencent.mobileqq.wxmini.impl.ui;

import android.content.Context;
import com.tencent.luggage.wxaapi.TdiAuthCheckStateListener;
import com.tencent.luggage.wxaapi.TdiAuthState;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.mobileqq.wxmini.impl.WxMiniSDKImpl;
import com.tencent.qphone.base.util.QLog;

class PreloadingFragment$5
  implements TdiAuthCheckStateListener
{
  PreloadingFragment$5(PreloadingFragment paramPreloadingFragment, String paramString1, Context paramContext, String paramString2, int paramInt) {}
  
  public void onStateChecked(TdiAuthState paramTdiAuthState, String paramString)
  {
    if (paramTdiAuthState == TdiAuthState.WechatTdi_Auth_State_OK)
    {
      paramTdiAuthState = new StringBuilder();
      paramTdiAuthState.append("checkAuthState success launchWeixinMiniAppById appid:");
      paramTdiAuthState.append(this.a);
      QLog.d("wxmini.PreloadingFragment", 1, paramTdiAuthState.toString());
      PreloadingFragment.a(this.e, this.b, this.a, this.c, this.d);
      return;
    }
    QLog.e("wxmini.PreloadingFragment", 1, "checkAuthState fail ");
    PreloadingFragment.a(this.e, 3);
    long l = System.currentTimeMillis();
    PreloadingFragment.a(this.e, "wx_sendAuth", this.a, "", "", "");
    WxMiniSDKImpl.a.c().sendAuth(new PreloadingFragment.5.1(this, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.PreloadingFragment.5
 * JD-Core Version:    0.7.0.1
 */
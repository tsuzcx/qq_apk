package com.tencent.mobileqq.wxmini.impl.ui;

import android.content.Context;
import com.tencent.luggage.wxaapi.TdiAuthCheckStateListener;
import com.tencent.luggage.wxaapi.TdiAuthState;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.mobileqq.wxmini.impl.WxMiniSDKImpl;
import com.tencent.qphone.base.util.QLog;

class PreloadingFragment$3
  implements TdiAuthCheckStateListener
{
  PreloadingFragment$3(PreloadingFragment paramPreloadingFragment, String paramString, int paramInt1, Context paramContext, int paramInt2) {}
  
  public void onStateChecked(TdiAuthState paramTdiAuthState, String paramString)
  {
    if (paramTdiAuthState == TdiAuthState.WechatTdi_Auth_State_OK)
    {
      paramTdiAuthState = new StringBuilder();
      paramTdiAuthState.append("checkAuthState success launchByQRRawData url:");
      paramTdiAuthState.append(this.a);
      QLog.d("wxmini.PreloadingFragment", 1, paramTdiAuthState.toString());
      int i = this.b;
      if (1 == i)
      {
        PreloadingFragment.a(this.e, this.c, this.a, this.d);
        return;
      }
      if (2 == i)
      {
        PreloadingFragment.b(this.e, this.c, this.a, this.d);
        return;
      }
      paramTdiAuthState = new StringBuilder();
      paramTdiAuthState.append("startWxMiniApp unkown type:");
      paramTdiAuthState.append(this.b);
      QLog.e("wxmini.PreloadingFragment", 1, paramTdiAuthState.toString());
      PreloadingFragment.d(this.e);
      return;
    }
    QLog.d("wxmini.PreloadingFragment", 1, "checkAuthState fail ");
    PreloadingFragment.a(this.e, 3);
    long l = System.currentTimeMillis();
    PreloadingFragment.a(this.e, "wx_sendAuth", this.a, "", "", "");
    WxMiniSDKImpl.a.c().sendAuth(new PreloadingFragment.3.1(this, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.PreloadingFragment.3
 * JD-Core Version:    0.7.0.1
 */
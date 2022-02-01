package com.tencent.mobileqq.teamwork;

import android.content.Intent;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;

class TeamWorkForceShare$2$1$1
  implements WXShareHelper.WXShareListener
{
  TeamWorkForceShare$2$1$1(TeamWorkForceShare.2.1 param1) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((TeamWorkForceShare.b(this.a.a.this$0) == null) || (!TeamWorkForceShare.b(this.a.a.this$0).equals(paramBaseResp.transaction))) {
      return;
    }
    QLog.d(TeamWorkForceShare.a(), 1, "wx rsp = " + paramBaseResp.errCode);
    if (this.a.a.a) {}
    for (byte b = 86;; b = 120)
    {
      TeamWorkForceShare.a(this.a.a.this$0).onActivityResult(new Intent(), b, paramBaseResp.errCode);
      WXShareHelper.a().b(this);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkForceShare.2.1.1
 * JD-Core Version:    0.7.0.1
 */
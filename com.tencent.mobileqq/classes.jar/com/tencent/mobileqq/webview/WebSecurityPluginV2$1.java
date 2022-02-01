package com.tencent.mobileqq.webview;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

class WebSecurityPluginV2$1
  implements ITroopMemberApiClientApi.Callback
{
  WebSecurityPluginV2$1(WebSecurityPluginV2 paramWebSecurityPluginV2, String paramString, boolean paramBoolean) {}
  
  public void callback(Bundle paramBundle)
  {
    if (this.c.isDestroy) {
      return;
    }
    if (!TextUtils.equals(this.c.b, this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WebSecurityPluginV2", 2, "receive check result but not current url");
      }
      return;
    }
    int i = paramBundle.getInt("result", -1);
    Object localObject2 = null;
    Object localObject1 = null;
    if (i == 0)
    {
      int j = paramBundle.getInt("jumpResult");
      int k = paramBundle.getInt("level");
      int m = paramBundle.getInt("subLevel");
      int n = paramBundle.getInt("umrType");
      long l = paramBundle.getLong("operationBit");
      localObject2 = this.c;
      int i1 = ((WebSecurityPluginV2)localObject2).c;
      if (k == 15) {
        i = 1;
      } else {
        i = 0;
      }
      ((WebSecurityPluginV2)localObject2).c = (i1 & i);
      if (j == 0)
      {
        paramBundle = (Bundle)localObject1;
        if (!this.b) {
          paramBundle = this.a;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("check pass l=");
        ((StringBuilder)localObject1).append(k);
        QLog.i("UrlCheckLog", 1, ((StringBuilder)localObject1).toString());
      }
      else
      {
        paramBundle = paramBundle.getString("jumpUrl");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("check finish jr=");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append(", l=");
        ((StringBuilder)localObject1).append(k);
        ((StringBuilder)localObject1).append(", sl=");
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append(", umr=");
        ((StringBuilder)localObject1).append(n);
        QLog.i("UrlCheckLog", 1, ((StringBuilder)localObject1).toString());
      }
      this.c.a(l);
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append("check fail r=");
      paramBundle.append(i);
      QLog.i("UrlCheckLog", 1, paramBundle.toString());
      paramBundle = (Bundle)localObject2;
      if (!this.b) {
        paramBundle = this.a;
      }
    }
    if (!TextUtils.isEmpty(paramBundle))
    {
      localObject1 = this.c.mRuntime.a();
      if (localObject1 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("now jump url=");
        ((StringBuilder)localObject2).append(Util.b(paramBundle, new String[0]));
        QLog.i("WebSecurityPluginV2", 1, ((StringBuilder)localObject2).toString());
        this.c.a = paramBundle;
        ((CustomWebView)localObject1).loadUrl(paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebSecurityPluginV2.1
 * JD-Core Version:    0.7.0.1
 */
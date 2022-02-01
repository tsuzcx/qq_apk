package com.tencent.mobileqq.webview;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

class WebSecurityPluginV2$1
  implements TroopMemberApiClient.Callback
{
  WebSecurityPluginV2$1(WebSecurityPluginV2 paramWebSecurityPluginV2, String paramString, boolean paramBoolean) {}
  
  public void callback(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewWebSecurityPluginV2.isDestroy) {}
    do
    {
      return;
      if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqWebviewWebSecurityPluginV2.b, this.jdField_a_of_type_JavaLangString)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("WebSecurityPluginV2", 2, "receive check result but not current url");
    return;
    int i = paramBundle.getInt("result", -1);
    int j;
    int k;
    int m;
    int n;
    long l;
    Object localObject;
    if (i == 0)
    {
      j = paramBundle.getInt("jumpResult");
      k = paramBundle.getInt("level");
      m = paramBundle.getInt("subLevel");
      n = paramBundle.getInt("umrType");
      l = paramBundle.getLong("operationBit");
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewWebSecurityPluginV2;
      int i1 = ((WebSecurityPluginV2)localObject).jdField_a_of_type_Boolean;
      if (k == 15)
      {
        i = 1;
        label116:
        ((WebSecurityPluginV2)localObject).jdField_a_of_type_Boolean = (i & i1);
        if (j != 0) {
          break label252;
        }
        if (this.jdField_a_of_type_Boolean) {
          break label362;
        }
      }
    }
    label167:
    label360:
    label362:
    for (paramBundle = this.jdField_a_of_type_JavaLangString;; paramBundle = null)
    {
      QLog.i("UrlCheckLog", 1, "check pass l=" + k);
      this.jdField_a_of_type_ComTencentMobileqqWebviewWebSecurityPluginV2.a(l);
      for (;;)
      {
        if (TextUtils.isEmpty(paramBundle)) {
          break label360;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewWebSecurityPluginV2.mRuntime.a();
        if (localObject == null) {
          break;
        }
        QLog.i("WebSecurityPluginV2", 1, "now jump url=" + Util.b(paramBundle, new String[0]));
        this.jdField_a_of_type_ComTencentMobileqqWebviewWebSecurityPluginV2.jdField_a_of_type_JavaLangString = paramBundle;
        ((CustomWebView)localObject).loadUrl(paramBundle);
        return;
        i = 0;
        break label116;
        label252:
        paramBundle = paramBundle.getString("jumpUrl");
        QLog.i("UrlCheckLog", 1, "check finish jr=" + j + ", l=" + k + ", sl=" + m + ", umr=" + n);
        break label167;
        QLog.i("UrlCheckLog", 1, "check fail r=" + i);
        if (!this.jdField_a_of_type_Boolean) {
          paramBundle = this.jdField_a_of_type_JavaLangString;
        } else {
          paramBundle = null;
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebSecurityPluginV2.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.mini.appbrand.ui;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.utils.JumpForwardPkgManager;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class MiniAppWebviewFragment$1
  extends WebKernelCallBackProxy
{
  MiniAppWebviewFragment$1(MiniAppWebviewFragment paramMiniAppWebviewFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public boolean interceptStartLoadUrl()
  {
    Object localObject = this.this$0.getIntent().getStringArrayListExtra("key_url_black_list");
    if (!JumpForwardPkgManager.a().a(MiniAppWebviewFragment.access$000(this.this$0)))
    {
      MiniAppWebviewFragment localMiniAppWebviewFragment = this.this$0;
      if (!MiniAppWebviewFragment.access$200(localMiniAppWebviewFragment, MiniAppWebviewFragment.access$100(localMiniAppWebviewFragment), (ArrayList)localObject))
      {
        if (this.this$0.getIntent().hasExtra("key_header")) {
          localObject = (HashMap)this.this$0.getIntent().getSerializableExtra("key_header");
        } else {
          localObject = null;
        }
        if (TextUtils.isEmpty(MiniAppWebviewFragment.access$500(this.this$0))) {
          break label190;
        }
        if ((localObject != null) && (((HashMap)localObject).size() > 0))
        {
          MiniAppWebviewFragment.access$700(this.this$0).loadUrl(MiniAppWebviewFragment.access$600(this.this$0), (Map)localObject);
          return true;
        }
        MiniAppWebviewFragment.access$900(this.this$0).loadUrl(MiniAppWebviewFragment.access$800(this.this$0));
        return true;
      }
    }
    MiniAppWebviewFragment.access$300(this.this$0).loadUrl("file:///android_asset/error.html");
    QLog.d("MiniAppWebviewFragment", 1, new Object[] { "url:", MiniAppWebviewFragment.access$400(this.this$0), "in black" });
    label190:
    return true;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (!this.this$0.isDestroyed())
    {
      if (MiniAppWebviewFragment.access$1000(this.this$0) == null) {
        return true;
      }
      ArrayList localArrayList = this.this$0.getIntent().getStringArrayListExtra("key_url_black_list");
      if (MiniAppWebviewFragment.access$200(this.this$0, paramString, localArrayList))
      {
        MiniAppWebviewFragment.access$1100(this.this$0).loadUrl("file:///android_asset/error.html");
        QLog.d("MiniAppWebviewFragment", 1, new Object[] { "url:", MiniAppWebviewFragment.access$1200(this.this$0), "in black" });
        return true;
      }
      return this.webViewKernelCallBack.shouldOverrideUrlLoading(paramWebView, paramString);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.MiniAppWebviewFragment.1
 * JD-Core Version:    0.7.0.1
 */
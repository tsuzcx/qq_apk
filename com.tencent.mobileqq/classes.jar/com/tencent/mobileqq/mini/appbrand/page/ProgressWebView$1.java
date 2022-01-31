package com.tencent.mobileqq.mini.appbrand.page;

import android.net.Uri;
import android.text.TextUtils;
import bbcv;
import bbgg;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebView;
import nae;

class ProgressWebView$1
  extends WebChromeClient
{
  ProgressWebView$1(ProgressWebView paramProgressWebView) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    QLog.e("ProgressWebView_js", 1, paramConsoleMessage.message());
    return super.onConsoleMessage(paramConsoleMessage);
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    bbcv.a(ProgressWebView.access$100(this.this$0).activity, paramString2, 2131690596, 2131694793, new ProgressWebView.1.2(this, paramJsResult), new ProgressWebView.1.3(this, paramJsResult)).show();
    return true;
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
    QLog.d("ProgressWebView", 1, "onProgressChanged : " + paramInt);
    if ((ProgressWebView.access$100(this.this$0).pageContainer != null) && (ProgressWebView.access$100(this.this$0).pageContainer.getCurrentPage() != null) && (ProgressWebView.access$100(this.this$0).pageContainer.getCurrentPage().getNavBar() != null))
    {
      ProgressWebView.access$100(this.this$0).pageContainer.getCurrentPage().getNavBar().updateProgress((byte)1);
      if (paramInt == 100) {
        ProgressWebView.access$100(this.this$0).pageContainer.getCurrentPage().getNavBar().updateProgress((byte)2);
      }
    }
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
    QLog.d("ProgressWebView", 2, "onReceivedTitle title : " + paramString);
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("about:blank"))) {
      AppBrandTask.runTaskOnUiThread(new ProgressWebView.1.1(this, paramString));
    }
  }
  
  public boolean onShowFileChooser(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    if (ProgressWebView.access$200(this.this$0) == null) {
      ProgressWebView.access$202(this.this$0, new nae());
    }
    if (ProgressWebView.access$300(this.this$0) != null)
    {
      MiniAppController.getInstance().setActivityResultListener(new ProgressWebView.1.4(this));
      return ProgressWebView.access$200(this.this$0).a(ProgressWebView.access$300(this.this$0), 2019, paramValueCallback, paramFileChooserParams);
    }
    return super.onShowFileChooser(paramWebView, paramValueCallback, paramFileChooserParams);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    if (ProgressWebView.access$200(this.this$0) == null) {
      ProgressWebView.access$202(this.this$0, new nae());
    }
    if (ProgressWebView.access$300(this.this$0) != null)
    {
      MiniAppController.getInstance().setActivityResultListener(new ProgressWebView.1.5(this));
      ProgressWebView.access$200(this.this$0).a(ProgressWebView.access$300(this.this$0), 2019, paramValueCallback, paramString1, paramString2);
      return;
    }
    super.openFileChooser(paramValueCallback, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.1
 * JD-Core Version:    0.7.0.1
 */
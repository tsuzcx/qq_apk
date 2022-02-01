package com.tencent.qqmini.miniapp.widget;

import Override;
import android.net.Uri;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.JsBridgeController;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmini.miniapp.R.string;
import com.tencent.qqmini.miniapp.util.FileChooserHelper;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebView;

class InnerWebView$2
  extends WebChromeClient
{
  InnerWebView$2(InnerWebView paramInnerWebView) {}
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    QMLog.e("InnerWebView_js", paramConsoleMessage.message());
    return super.onConsoleMessage(paramConsoleMessage);
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    DialogUtil.createCustomDialog(InnerWebView.access$600(this.this$0).getAttachedActivity(), 230, "", paramString2, R.string.mini_sdk_cancel, R.string.mini_sdk_ok, new InnerWebView.2.1(this, paramJsResult), new InnerWebView.2.2(this, paramJsResult)).show();
    return true;
  }
  
  @Override
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    if (JsBridgeController.getInstance().shouldIntercept(paramWebView, paramString2, paramString1, paramJsPromptResult)) {
      return true;
    }
    return super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    JsInjector.getInstance().onProgressChanged(paramWebView, paramInt);
    super.onProgressChanged(paramWebView, paramInt);
    InnerWebView.access$500(this.this$0, paramInt);
  }
  
  public void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
    InnerWebView.access$400(this.this$0, paramString);
  }
  
  public boolean onShowFileChooser(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    if (InnerWebView.access$700(this.this$0) == null) {
      InnerWebView.access$702(this.this$0, new FileChooserHelper());
    }
    if (InnerWebView.access$800(this.this$0) != null)
    {
      ActivityResultManager.g().addActivityResultListener(new InnerWebView.2.3(this));
      return InnerWebView.access$700(this.this$0).onShowFileChooser(InnerWebView.access$800(this.this$0), 2019, paramValueCallback, paramFileChooserParams);
    }
    return super.onShowFileChooser(paramWebView, paramValueCallback, paramFileChooserParams);
  }
  
  public void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    if (InnerWebView.access$700(this.this$0) == null) {
      InnerWebView.access$702(this.this$0, new FileChooserHelper());
    }
    if (InnerWebView.access$800(this.this$0) != null)
    {
      ActivityResultManager.g().addActivityResultListener(new InnerWebView.2.4(this));
      InnerWebView.access$700(this.this$0).showFileChooser(InnerWebView.access$800(this.this$0), 2019, paramValueCallback, paramString1, paramString2);
      return;
    }
    super.openFileChooser(paramValueCallback, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.InnerWebView.2
 * JD-Core Version:    0.7.0.1
 */
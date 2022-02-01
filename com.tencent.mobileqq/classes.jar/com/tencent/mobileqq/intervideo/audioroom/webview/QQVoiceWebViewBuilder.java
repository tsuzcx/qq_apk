package com.tencent.mobileqq.intervideo.audioroom.webview;

import android.content.ContextWrapper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.intervideo.audioroom.utils.QQVoiceUtil;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQVoiceWebViewBuilder
{
  private QQVoiceWebViewBuilder.InnerAbsWebView a;
  protected QQVoiceWebView mQQVoiceWebView;
  
  public QQVoiceWebViewBuilder(ContextWrapper paramContextWrapper)
  {
    this(paramContextWrapper, null);
  }
  
  public QQVoiceWebViewBuilder(ContextWrapper paramContextWrapper, QQVoiceWebView paramQQVoiceWebView)
  {
    paramContextWrapper = QQVoiceUtil.getActFromShadowContext(paramContextWrapper);
    this.a = new QQVoiceWebViewBuilder.InnerAbsWebView(this, paramContextWrapper, paramContextWrapper, (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    this.mQQVoiceWebView = paramQQVoiceWebView;
  }
  
  protected void addJavaScript(List<BaseQQVoiceWebViewPlugin> paramList) {}
  
  public QQVoiceWebView getWebView()
  {
    return this.mQQVoiceWebView;
  }
  
  public void initWebView()
  {
    this.a.a(this.mQQVoiceWebView);
    onWebViewReady();
  }
  
  public void onCreate()
  {
    this.a.onCreate();
  }
  
  public void onDestroy()
  {
    this.a.onDestroy();
  }
  
  protected void onPageFinished(QQVoiceWebView paramQQVoiceWebView, String paramString) {}
  
  protected void onPageStarted(QQVoiceWebView paramQQVoiceWebView, String paramString) {}
  
  public void onPause()
  {
    this.a.onPause();
  }
  
  protected void onReceivedError(QQVoiceWebView paramQQVoiceWebView, String paramString1, int paramInt, String paramString2) {}
  
  public void onResume()
  {
    this.a.onResume();
  }
  
  protected void onWebViewReady() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.webview.QQVoiceWebViewBuilder
 * JD-Core Version:    0.7.0.1
 */
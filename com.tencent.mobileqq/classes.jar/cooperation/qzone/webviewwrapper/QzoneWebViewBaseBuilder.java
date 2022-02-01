package cooperation.qzone.webviewwrapper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ProgressBar;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.util.IWebViewBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.webviewplugin.QZoneWebViewPlugin;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class QzoneWebViewBaseBuilder
  extends AbsWebView
  implements IWebViewBuilder
{
  public static final CommonJsPluginFactory QZONE_SHOW_COMMON_JS = new QzoneWebViewBaseBuilder.1();
  protected Intent mIntent;
  private boolean mIsSmallWebview = true;
  protected int mWebViewResId;
  private QzoneWebViewBaseBuilder.WebviewStatusListener mWebviewStatusListener;
  
  public QzoneWebViewBaseBuilder(Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface, boolean paramBoolean)
  {
    super(paramContext, paramActivity, paramAppInterface);
    this.mIntent = paramIntent;
    this.mIsSmallWebview = paramBoolean;
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    if (this.mPluginList == null) {
      this.mPluginList = new ArrayList();
    }
    this.mPluginList.add(new QZoneWebViewPlugin());
  }
  
  public void buildBottomBar() {}
  
  public void buildContentView(Bundle paramBundle) {}
  
  public void buildData() {}
  
  public void buildLayout() {}
  
  public void buildTitleBar() {}
  
  public final void buildWebView(AppRuntime paramAppRuntime)
  {
    super.buildBaseWebView(paramAppRuntime);
    onWebViewReady();
  }
  
  public void callJs(String paramString)
  {
    if (this.mWebview != null) {
      this.mWebview.callJs(paramString);
    }
  }
  
  public void finish() {}
  
  public boolean handleMessageImp(Message paramMessage)
  {
    return false;
  }
  
  protected CommonJsPluginFactory myCommonJsPlugins()
  {
    if (this.mIsSmallWebview) {
      return QZONE_SHOW_COMMON_JS;
    }
    return new CommonJsPluginFactory();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onBackPressed()
  {
    super.doOnBackPressed(this.mInterface);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.doOnCreate(this.mIntent);
  }
  
  public void onDestroy()
  {
    try
    {
      super.doOnDestroy();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    paramWebView = this.mWebviewStatusListener;
    if (paramWebView != null) {}
    try
    {
      paramWebView.onPageFinished();
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  public void onPause()
  {
    super.doOnPause();
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    paramWebView = this.mWebviewStatusListener;
    if (paramWebView != null) {}
    try
    {
      paramWebView.onReceiveError(paramInt, paramString1, paramString2);
      return;
    }
    catch (Exception paramWebView) {}
  }
  
  public void onResume()
  {
    super.doOnResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStop() {}
  
  public void onWebViewReady() {}
  
  public void onWindowFocusChanged(boolean paramBoolean) {}
  
  public void preInitWebviewPlugin()
  {
    super.preInitPluginEngine();
  }
  
  public void setProgressBar(ProgressBar paramProgressBar)
  {
    this.mLoadProgress = paramProgressBar;
  }
  
  public void setWebView(TouchWebView paramTouchWebView)
  {
    this.mWebview = paramTouchWebView;
  }
  
  public void setWebViewResId(int paramInt)
  {
    this.mWebViewResId = paramInt;
  }
  
  public void setWebviewStatusListener(QzoneWebViewBaseBuilder.WebviewStatusListener paramWebviewStatusListener)
  {
    this.mWebviewStatusListener = paramWebviewStatusListener;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadUrl in shouldOverrideUrlLoading url=");
      localStringBuilder.append(paramString);
      QLog.d("QzoneWebViewBaseBuilder", 2, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("jsbridge://"))) {
      return true;
    }
    paramWebView.loadUrl(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewwrapper.QzoneWebViewBaseBuilder
 * JD-Core Version:    0.7.0.1
 */
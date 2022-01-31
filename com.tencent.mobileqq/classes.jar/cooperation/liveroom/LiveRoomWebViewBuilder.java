package cooperation.liveroom;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bayq;
import bays;
import bbdc;
import bbdg;
import bbpa;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import mkw;

public class LiveRoomWebViewBuilder
  extends bayq
{
  public static final String TAG = "LiveRoomWebViewBuilder";
  private final WebAccelerateHelper.CommonJsPluginFactory LIVEROOM_COMMON_JS = new LiveRoomWebViewBuilder.1(this);
  protected mkw authConfig = mkw.a();
  private boolean loading;
  private ArrayList<WebViewPlugin> mBussinessPluginList;
  private View mContentView;
  private LiveRoomWebViewBuilder.WebviewCallback mWebviewCallback;
  private String sdkVersion = "0.0.0";
  
  public LiveRoomWebViewBuilder(Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramIntent, paramAppInterface);
    this.sdkVersion = paramIntent.getStringExtra("version");
  }
  
  private Resources getResources()
  {
    return this.mInActivity.getResources();
  }
  
  public void bindBussinessWebViewPlugin(ArrayList<WebViewPlugin> paramArrayList)
  {
    this.mBussinessPluginList = paramArrayList;
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    if ((paramArrayList != null) && (this.mBussinessPluginList != null) && (this.mBussinessPluginList.size() > 0)) {
      paramArrayList.addAll(this.mBussinessPluginList);
    }
  }
  
  public void buildLayout()
  {
    this.mContentView = buildLayoutOnly();
  }
  
  @TargetApi(14)
  public View buildLayoutOnly()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2131497014, null);
    this.mViewRoot = localView.findViewById(2131313550);
    if (this.mViewRoot == null) {
      return localView;
    }
    if ((this.bNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT >= 14)) {
      this.mViewRoot.setFitsSystemWindows(this.bFitSystemWindow);
    }
    this.titleContainer = ((FrameLayout)this.mViewRoot.findViewById(2131311572));
    this.bottomContainer = ((FrameLayout)this.mViewRoot.findViewById(2131297810));
    this.webviewContainer = ((RelativeLayout)this.mViewRoot.findViewById(2131313565));
    this.mLoadProgress = ((ProgressBar)this.mViewRoot.findViewById(2131309309));
    this.maskView = this.mViewRoot.findViewById(2131313568);
    this.contentContainer = ((LinearLayout)this.mViewRoot.findViewById(2131299142));
    if ((this.mIntent != null) && (!this.mIntent.getBooleanExtra("webview_hide_progress", false)))
    {
      this.mLoadingProgressBar = ((WebViewProgressBar)this.mViewRoot.findViewById(2131306308));
      this.mProgressBarController = new bbpa();
      this.mLoadingProgressBar.setController(this.mProgressBarController);
      if ((this.mIsFirstOnPageStart) && (this.mProgressBarController != null) && (this.mProgressBarController.b() != 0)) {
        this.mProgressBarController.a((byte)0);
      }
    }
    this.mWebview = new TouchWebView(this.mContext);
    this.mWebview.setId(2131313562);
    WebSettings localWebSettings = this.mWebview.getSettings();
    String str1 = " gflive/" + this.sdkVersion;
    StringBuilder localStringBuilder = new StringBuilder();
    String str2 = localWebSettings.getUserAgentString();
    String str3 = getUAMark();
    if (this.mWebview.getX5WebViewExtension() != null) {}
    for (boolean bool = true;; bool = false)
    {
      localWebSettings.setUserAgentString(bbdc.a(str2, str3, bool) + " gflivesdk" + str1);
      localWebSettings.setMixedContentMode(0);
      this.webviewContainer.addView(this.mWebview, new RelativeLayout.LayoutParams(-1, -1));
      return localView;
    }
  }
  
  public void buildTitleBar()
  {
    this.titleContainer.setBackgroundColor(getResources().getColor(17170445));
    bays localbays = new bays();
    localbays.a = this.webviewContainer;
    localbays.b = this.titleContainer;
    setTittlebarImmersive(true, localbays);
  }
  
  public Object doInterceptRequest(WebView paramWebView, String paramString)
  {
    if (this.mWebviewCallback != null) {
      return this.mWebviewCallback.doInterceptRequest(paramString);
    }
    return super.doInterceptRequest(paramWebView, paramString);
  }
  
  public View getContainer()
  {
    return this.mContentView;
  }
  
  public Object getObject(String paramString)
  {
    if ("progressBar".equals(paramString)) {
      return this.mLoadProgress;
    }
    return null;
  }
  
  public String getUAMark()
  {
    return "LiveRoom";
  }
  
  public WebAccelerateHelper.CommonJsPluginFactory myCommonJsPlugins()
  {
    return this.LIVEROOM_COMMON_JS;
  }
  
  public void onImmersive(boolean paramBoolean, bays parambays)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LiveRoomWebViewBuilder", 2, "onImmersive");
    }
    if (paramBoolean)
    {
      if (this.mSystemBarComp != null) {
        this.mSystemBarComp.setgetStatusBarVisible(false, 0);
      }
      if (parambays.b != null) {
        parambays.b.getBackground().setAlpha(0);
      }
    }
    do
    {
      return;
      if (this.mSystemBarComp != null) {
        this.mSystemBarComp.setgetStatusBarVisible(true, 0);
      }
      if (parambays.b != null) {
        parambays.b.setBackgroundResource(2130848801);
      }
    } while (this.mTitleBar == null);
    this.mTitleBar.a(255, 0);
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    paramJsResult.cancel();
    return true;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (this.loading)
    {
      this.loading = false;
      showProgressBar(false);
      LiveRoomHelper.report("webViewBuilder", "webView", "pageFinish", NetConnInfoCenter.getServerTimeMillis() - LiveRoomHelper.startTime);
      LiveRoomHelper.doReport();
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    setmTimeBeforeLoadUrl(System.currentTimeMillis());
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    this.loading = true;
    LiveRoomHelper.report("webViewBuilder", "webView", "pageStart", NetConnInfoCenter.getServerTimeMillis() - LiveRoomHelper.startTime);
  }
  
  public void onWebViewReady()
  {
    LiveRoomHelper.report("webViewBuilder", "webView", "webViewReady", NetConnInfoCenter.getServerTimeMillis() - LiveRoomHelper.startTime);
  }
  
  public void setWebViewCallback(LiveRoomWebViewBuilder.WebviewCallback paramWebviewCallback)
  {
    this.mWebviewCallback = paramWebviewCallback;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    paramWebView.loadUrl(paramString);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomWebViewBuilder
 * JD-Core Version:    0.7.0.1
 */
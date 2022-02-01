package cooperation.liveroom;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.webview.WebViewBaseBuilder;
import com.tencent.mobileqq.webview.WebViewBaseBuilder.ImmersiveParam;
import com.tencent.mobileqq.webview.swift.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.ui.WebViewTitlerBar;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;

public class LiveRoomWebViewBuilder
  extends WebViewBaseBuilder
{
  public static final String TAG = "LiveRoomWebViewBuilder";
  private final CommonJsPluginFactory LIVEROOM_COMMON_JS = new LiveRoomWebViewBuilder.1(this);
  protected AuthorizeConfig authConfig = AuthorizeConfig.a();
  private boolean loading = false;
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
    if (paramArrayList != null)
    {
      ArrayList localArrayList = this.mBussinessPluginList;
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        paramArrayList.addAll(this.mBussinessPluginList);
      }
    }
  }
  
  public void buildLayout()
  {
    this.mContentView = buildLayoutOnly();
  }
  
  @TargetApi(14)
  public View buildLayoutOnly()
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2131629664, null);
    this.mViewRoot = localView.findViewById(2131450072);
    if (this.mViewRoot == null) {
      return localView;
    }
    boolean bool2 = this.bNeedStatusTrans;
    boolean bool1 = true;
    if ((bool2) && (ImmersiveUtils.isSupporImmersive() == 1) && (Build.VERSION.SDK_INT >= 14)) {
      this.mViewRoot.setFitsSystemWindows(this.bFitSystemWindow);
    }
    this.titleContainer = ((FrameLayout)this.mViewRoot.findViewById(2131447506));
    this.bottomContainer = ((FrameLayout)this.mViewRoot.findViewById(2131429656));
    this.webviewContainer = ((RelativeLayout)this.mViewRoot.findViewById(2131450091));
    this.mLoadProgress = ((ProgressBar)this.mViewRoot.findViewById(2131444560));
    this.maskView = this.mViewRoot.findViewById(2131450095);
    this.contentContainer = ((LinearLayout)this.mViewRoot.findViewById(2131431340));
    if ((this.mIntent != null) && (!this.mIntent.getBooleanExtra("webview_hide_progress", false)))
    {
      this.mLoadingProgressBar = ((WebViewProgressBar)this.mViewRoot.findViewById(2131440738));
      this.mProgressBarController = new WebViewProgressBarController();
      this.mLoadingProgressBar.setController(this.mProgressBarController);
      if ((isIsFirstOnPageStart()) && (this.mProgressBarController != null) && (this.mProgressBarController.d() != 0)) {
        this.mProgressBarController.a((byte)0);
      }
    }
    this.mWebview = new TouchWebView(this.mContext);
    this.mWebview.setId(2131450088);
    WebSettings localWebSettings = this.mWebview.getSettings();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" gflive/");
    ((StringBuilder)localObject).append(this.sdkVersion);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = localWebSettings.getUserAgentString();
    String str2 = getUAMark();
    if (this.mWebview.getX5WebViewExtension() == null) {
      bool1 = false;
    }
    localStringBuilder.append(SwiftWebViewUtils.a(str1, str2, bool1));
    localStringBuilder.append(" gflivesdk");
    localStringBuilder.append((String)localObject);
    localWebSettings.setUserAgentString(localStringBuilder.toString());
    localWebSettings.setMixedContentMode(0);
    this.webviewContainer.addView(this.mWebview, new RelativeLayout.LayoutParams(-1, -1));
    return localView;
  }
  
  public void buildTitleBar()
  {
    this.titleContainer.setBackgroundColor(getResources().getColor(17170445));
    WebViewBaseBuilder.ImmersiveParam localImmersiveParam = new WebViewBaseBuilder.ImmersiveParam();
    localImmersiveParam.a = this.webviewContainer;
    localImmersiveParam.b = this.titleContainer;
    setTittlebarImmersive(true, localImmersiveParam);
  }
  
  public Object doInterceptRequest(WebView paramWebView, String paramString)
  {
    LiveRoomWebViewBuilder.WebviewCallback localWebviewCallback = this.mWebviewCallback;
    if (localWebviewCallback != null) {
      return localWebviewCallback.doInterceptRequest(paramString);
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
  
  protected String getUAMark()
  {
    return "LiveRoom";
  }
  
  protected CommonJsPluginFactory myCommonJsPlugins()
  {
    return this.LIVEROOM_COMMON_JS;
  }
  
  protected void onImmersive(boolean paramBoolean, WebViewBaseBuilder.ImmersiveParam paramImmersiveParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LiveRoomWebViewBuilder", 2, "onImmersive");
    }
    if (paramBoolean)
    {
      if (this.mSystemBarComp != null) {
        this.mSystemBarComp.setgetStatusBarVisible(false, 0);
      }
      if (paramImmersiveParam.b != null) {
        paramImmersiveParam.b.getBackground().setAlpha(0);
      }
    }
    else
    {
      if (this.mSystemBarComp != null) {
        this.mSystemBarComp.setgetStatusBarVisible(true, 0);
      }
      if (paramImmersiveParam.b != null) {
        paramImmersiveParam.b.setBackgroundResource(2130852228);
      }
      if (this.mTitleBar != null) {
        this.mTitleBar.a(255, 0);
      }
    }
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
    setTimeBeforeLoadUrl(System.currentTimeMillis());
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
    Object localObject1 = Uri.parse(paramString);
    Object localObject2 = ((Uri)localObject1).getScheme();
    if ((this.mInActivity != null) && (!this.mInActivity.isFinishing()) && (this.authConfig.d(paramWebView.getUrl(), (String)localObject2).booleanValue()))
    {
      localObject2 = new Intent("android.intent.action.VIEW", (Uri)localObject1);
      ((Intent)localObject2).addFlags(268435456);
      try
      {
        localObject1 = this.mInActivity.getPackageManager();
        if (localObject1 == null) {
          return false;
        }
        Object localObject3 = ((Intent)localObject2).resolveActivityInfo((PackageManager)localObject1, 0);
        localObject1 = "";
        if (localObject3 != null) {
          localObject1 = ((ActivityInfo)localObject3).packageName;
        }
        localObject3 = this.mInActivity.getClass().getName();
        StartAppCheckHandler.a("scheme", paramWebView.getUrl(), (String)localObject1, "1", "web", (String)localObject3);
        try
        {
          JefsClass.getInstance().a(this.mInActivity, (Intent)localObject2, paramString, new LiveRoomWebViewBuilder.2(this, (Intent)localObject2));
          return true;
        }
        catch (Throwable paramWebView)
        {
          QLog.e("LiveRoomWebViewBuilder", 1, paramWebView, new Object[0]);
          return true;
        }
        return false;
      }
      catch (Exception paramWebView)
      {
        QLog.e("LiveRoomWebViewBuilder", 1, "afterWebViewEngineHandleOverrideUrl error!", paramWebView);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomWebViewBuilder
 * JD-Core Version:    0.7.0.1
 */
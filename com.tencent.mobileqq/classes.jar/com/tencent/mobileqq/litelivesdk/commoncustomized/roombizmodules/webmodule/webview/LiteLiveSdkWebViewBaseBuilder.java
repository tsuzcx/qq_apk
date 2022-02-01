package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.api.IPublicAccountWebviewPlugin;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.biz.webviewplugin.ShareApiPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.ilive.litepages.room.webmodule.js.AppJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.js.MiscJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.js.RecordJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.js.UIJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.BaseLiteJSModule;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.confess.ConfessPlugin;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.LiteLiveJsProvider;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vaswebviewplugin.QQIliveJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginContainer;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.util.IWebViewBuilder;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;

public class LiteLiveSdkWebViewBaseBuilder
  extends AbsWebView
  implements WebViewPluginContainer, SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderContext, IWebViewBuilder, WebUiUtils.WebShareInterface, WebUiUtils.WebUiMethodInterface
{
  private static List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  public long a;
  protected Intent a;
  private View jdField_a_of_type_AndroidViewView;
  protected AuthorizeConfig a;
  private Share jdField_a_of_type_ComTencentBizWebviewpluginShare;
  private JsBizAdapter jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter;
  private LiteLiveJsProvider jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider;
  private LiteLiveSdkWebViewBaseBuilder.WebviewStatusListener jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder$WebviewStatusListener;
  private LiveBusinessJsInterface jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiveBusinessJsInterface;
  public final SwiftBrowserComponentsProvider a;
  
  static
  {
    jdField_a_of_type_JavaUtilList.add("vaslive");
  }
  
  public LiteLiveSdkWebViewBaseBuilder(Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface, boolean paramBoolean, JsBizAdapter paramJsBizAdapter, LiteLiveJsProvider paramLiteLiveJsProvider, LiveBusinessJsInterface paramLiveBusinessJsInterface, View paramView)
  {
    super(paramContext, paramActivity, paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider = a();
    this.jdField_a_of_type_Long = 8996L;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter = paramJsBizAdapter;
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider = paramLiteLiveJsProvider;
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiveBusinessJsInterface = paramLiveBusinessJsInterface;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
    paramAppInterface = paramActivity.getIntent();
    paramIntent = paramAppInterface;
    if (paramAppInterface == null)
    {
      paramIntent = new Intent();
      paramActivity.setIntent(paramIntent);
    }
    paramIntent.putExtra("big_brother_source_key", "biz_src_jc_vip");
    ThreadCenter.postLogicTask(new LiteLiveSdkWebViewBaseBuilder.1(this, paramContext));
  }
  
  private void a(Context paramContext)
  {
    AppJavascriptInterface localAppJavascriptInterface = new AppJavascriptInterface(paramContext, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter);
    RecordJavascriptInterface localRecordJavascriptInterface = new RecordJavascriptInterface(paramContext, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter);
    UIJavascriptInterface localUIJavascriptInterface = new UIJavascriptInterface(paramContext, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter);
    paramContext = new MiscJavascriptInterface(paramContext, this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter);
    a(localAppJavascriptInterface);
    a(localRecordJavascriptInterface);
    a(localUIJavascriptInterface);
    a(paramContext);
  }
  
  private void a(BaseLiteJSModule paramBaseLiteJSModule)
  {
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a(paramBaseLiteJSModule);
  }
  
  private boolean a(String paramString)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiveBusinessJsInterface;
    if (localObject1 != null) {
      localObject1 = ((LiveBusinessJsInterface)localObject1).a(paramString);
    } else {
      localObject1 = null;
    }
    HashMap localHashMap;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = Uri.parse(paramString);
      localHashMap = new HashMap();
      localObject2 = ((Uri)localObject1).getQueryParameterNames().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        str1 = (String)((Iterator)localObject2).next();
        paramString = ((Uri)localObject1).getQueryParameter(str1);
        if (paramString == null) {
          paramString = "";
        }
        localHashMap.put(str1, paramString);
      }
      String str1 = ((Uri)localObject1).getAuthority();
      String str2 = ((Uri)localObject1).getPath();
      localObject2 = localHashMap;
      localObject1 = str1;
      paramString = str2;
      if (str2 != null)
      {
        paramString = str2.substring(1);
        localObject2 = localHashMap;
        localObject1 = str1;
      }
    }
    else
    {
      localObject2 = ((WebJsParams)localObject1).a();
      paramString = ((WebJsParams)localObject1).b();
      localHashMap = ((WebJsParams)localObject1).a();
      localObject1 = localObject2;
      localObject2 = localHashMap;
    }
    return this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider.a((String)localObject1, paramString, (Map)localObject2);
  }
  
  public Share a()
  {
    return b();
  }
  
  public SwiftBrowserComponentsProvider a()
  {
    return new SwiftBrowserComponentsProvider(this, 447, null);
  }
  
  public void a()
  {
    super.doOnResume();
  }
  
  public void a(Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter = paramJsBizAdapter;
    ThreadCenter.postLogicTask(new LiteLiveSdkWebViewBaseBuilder.2(this, paramContext));
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    this.mWebview = paramTouchWebView;
  }
  
  public void a(LiteLiveSdkWebViewBaseBuilder.WebviewStatusListener paramWebviewStatusListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder$WebviewStatusListener = paramWebviewStatusListener;
  }
  
  public void a(String paramString)
  {
    if (this.mWebview != null) {
      this.mWebview.callJs(paramString);
    }
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    Object localObject1 = Uri.parse(paramString);
    Object localObject2 = ((Uri)localObject1).getScheme();
    if ((this.mInActivity != null) && (!this.mInActivity.isFinishing()) && (this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramWebView.getUrl(), (String)localObject2).booleanValue()))
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
          JefsClass.getInstance().a(this.mInActivity, (Intent)localObject2, paramString, new LiteLiveSdkWebViewBaseBuilder.4(this, (Intent)localObject2));
          return true;
        }
        catch (Throwable paramWebView)
        {
          QLog.e("AbsWebView", 1, paramWebView, new Object[0]);
          return true;
        }
        return false;
      }
      catch (Exception paramWebView)
      {
        QLog.e("AbsWebView", 1, "afterWebViewEngineHandleOverrideUrl error!", paramWebView);
        return true;
      }
    }
  }
  
  protected Share b()
  {
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare == null)
    {
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare = new Share(this.mInterface, this.mInActivity);
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(this);
    }
    return this.jdField_a_of_type_ComTencentBizWebviewpluginShare;
  }
  
  public void b()
  {
    super.doOnPause();
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    if (this.mPluginList != null)
    {
      this.mPluginList.add((WebViewPlugin)((IQzoneWebViewPluginHelper)QRoute.api(IQzoneWebViewPluginHelper.class)).getQzoneWebViewPlugin());
      this.mPluginList.add(new WebViewJumpPlugin());
      this.mPluginList.add(new ConfessPlugin());
      this.mPluginList.add(new QQApiPlugin());
      this.mPluginList.add(new UiApiPlugin());
      this.mPluginList.add(new ShareApiPlugin());
      this.mPluginList.add(new VasCommonJsPlugin());
      this.mPluginList.add((WebViewPlugin)QRoute.api(IPublicAccountWebviewPlugin.class));
      this.mPluginList.add(new QQIliveJsPlugin());
    }
  }
  
  public void buildBottomBar() {}
  
  public void buildContentView(Bundle paramBundle) {}
  
  public void buildData() {}
  
  public void buildLayout() {}
  
  public void buildTitleBar() {}
  
  public final void buildWebView(AppRuntime paramAppRuntime)
  {
    super.buildBaseWebView(paramAppRuntime);
    paramAppRuntime = jdField_a_of_type_JavaUtilList.iterator();
    while (paramAppRuntime.hasNext())
    {
      Object localObject = (String)paramAppRuntime.next();
      localObject = this.mWebview.getPluginEngine().a((String)localObject);
      if ((localObject instanceof LiteLiveJsInterface)) {
        ((LiteLiveJsInterface)localObject).onInitJsAdapter(this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter);
      }
    }
    this.mWebview.getPluginEngine().a(this);
    this.mWebview.setWebViewClient(new LiteLiveSdkWebViewBaseBuilder.3(this, this.mWebview.getPluginEngine()));
    onWebViewReady();
  }
  
  public void c()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AbsWebView", 2, "doOnDestroy");
      }
      if (this.mWebview != null)
      {
        if ((BusinessManager.a.a().a) || (BusinessManager.a.a().b)) {
          WebViewPool.a.a(this.mWebview);
        }
        this.mWebview = null;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    LiteLiveJsProvider localLiteLiveJsProvider = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleLiteLiveJsProvider;
    if (localLiteLiveJsProvider != null) {
      localLiteLiveJsProvider.a();
    }
  }
  
  public void destroy()
  {
    Share localShare = this.jdField_a_of_type_ComTencentBizWebviewpluginShare;
    if (localShare != null) {
      localShare.destroy();
    }
  }
  
  public String getCurrentUrl()
  {
    String str2 = this.mUrl;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (this.mWebview != null)
      {
        if (!TextUtils.isEmpty(this.mWebview.getUrl())) {
          return this.mWebview.getUrl();
        }
        str1 = this.mInActivity.getIntent().getStringExtra("url");
      }
    }
    return str1;
  }
  
  public Activity getHostActivity()
  {
    return this.mInActivity;
  }
  
  public WebView getHostWebView()
  {
    return this.mWebview;
  }
  
  public String getShareUrl()
  {
    return b().getShareUrl();
  }
  
  public WebViewProvider getWebViewProvider()
  {
    return null;
  }
  
  public boolean isActivityResume()
  {
    return false;
  }
  
  protected CommonJsPluginFactory myCommonJsPlugins()
  {
    return new CommonJsPluginFactory();
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    paramWebView = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder$WebviewStatusListener;
    if (paramWebView != null) {
      try
      {
        paramWebView.a();
        return;
      }
      catch (Exception paramWebView)
      {
        paramString = new StringBuilder();
        paramString.append("onPageFinished error ");
        paramString.append(paramWebView);
        QLog.e("AbsWebView", 1, paramString.toString());
      }
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    paramWebView = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewLiteLiveSdkWebViewBaseBuilder$WebviewStatusListener;
    if (paramWebView != null) {
      try
      {
        paramWebView.a(paramInt, paramString1, paramString2);
        return;
      }
      catch (Exception paramWebView)
      {
        paramString1 = new StringBuilder();
        paramString1.append("onReceivedError error ");
        paramString1.append(paramWebView);
        QLog.e("AbsWebView", 1, paramString1.toString());
      }
    }
  }
  
  public void onWebViewReady() {}
  
  public final int pluginStartActivityForResult(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte)
  {
    paramByte = switchRequestCode(paramWebViewPlugin, (byte)1);
    if (paramByte == -1)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("AbsWebView", 2, "pluginStartActivityForResult not handled");
        return paramByte;
      }
    }
    else if (this.mInActivity != null) {
      this.mInActivity.startActivityForResult(paramIntent, 15001);
    }
    return paramByte;
  }
  
  public void preInitWebviewPlugin()
  {
    super.preInitPluginEngine();
  }
  
  public void reset()
  {
    b().reset();
  }
  
  public boolean setShareUrl(String paramString)
  {
    return b().setShareUrl(paramString);
  }
  
  public boolean setSummary(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    return b().setSummary(paramString1, paramString2, paramString3, paramString4, paramBundle);
  }
  
  public boolean shareStructMsgForH5(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    return false;
  }
  
  public void showActionSheet()
  {
    QLog.d("AbsWebView", 1, "ilive show action sheet ");
    SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(4);
    if (localSwiftBrowserShareMenuHandler != null)
    {
      if ((localSwiftBrowserShareMenuHandler.a != null) && (localSwiftBrowserShareMenuHandler.a.getIntent() != null)) {
        localSwiftBrowserShareMenuHandler.a.getIntent().putExtra("big_brother_source_key", "biz_src_jc_vip");
      }
      localSwiftBrowserShareMenuHandler.b = false;
      localSwiftBrowserShareMenuHandler.c = true;
      localSwiftBrowserShareMenuHandler.a(false);
      localSwiftBrowserShareMenuHandler.a(b(), this.jdField_a_of_type_Long, false, false);
    }
  }
  
  public final int switchRequestCode(WebViewPlugin paramWebViewPlugin, byte paramByte)
  {
    CustomWebView localCustomWebView = paramWebViewPlugin.mRuntime.a();
    if (localCustomWebView == null) {
      return -1;
    }
    if (localCustomWebView.getPluginEngine() == null) {
      return -1;
    }
    int i = WebViewUtil.a(paramWebViewPlugin);
    if (i == -1)
    {
      if (QLog.isColorLevel())
      {
        paramWebViewPlugin = new StringBuilder();
        paramWebViewPlugin.append("switchRequestCode failed: webView index=");
        paramWebViewPlugin.append(0);
        paramWebViewPlugin.append(", pluginIndex=");
        paramWebViewPlugin.append(i);
        QLog.d("AbsWebView", 2, paramWebViewPlugin.toString());
      }
      return -1;
    }
    return i << 8 & 0xFF00 | 0x0 | paramByte & 0xFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.LiteLiveSdkWebViewBaseBuilder
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.ecshopassit.BusinessReporter;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.QzonePlugin;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.activities.SingleTaskQQBrowser;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerViewModel;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.haoliyou.JefsClass.Cancelable;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleQZoneUIUtil;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ScreenShotUtil;
import com.tencent.mobileqq.utils.JumpForwardPkgManager;
import com.tencent.mobileqq.vas.URLInterceptManager;
import com.tencent.mobileqq.wbapi.WBShareHelper;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.injector.IWebViewSurfaceInjector;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.mobileqq.webview.swift.utils.WebViewJumpUtils;
import com.tencent.mobileqq.webview.webso.WebSoScreenshot;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.sdk.WebView;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService;
import cooperation.qzone.report.lp.LpReportInfo_dc02216;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.opengroup.AppUrlOpenGroup.ReqBody;

public class WebViewSurfaceInjectorImpl
  implements IWebViewSurfaceInjector
{
  private boolean a = false;
  private int b = 0;
  private String c = "";
  private boolean d = false;
  private JefsClass.Cancelable e;
  private int f;
  private int g;
  private volatile boolean h = false;
  
  private void a(WebViewProvider paramWebViewProvider, Intent paramIntent, int paramInt1, int paramInt2)
  {
    QLog.d("WebViewSurfaceInjectorImpl", 1, "Activity result  to weibo plugin.");
    if (paramWebViewProvider.getWebView() == null)
    {
      QLog.d("WebViewSurfaceInjectorImpl", 1, "Activity result weibo null == webView.");
      return;
    }
    paramWebViewProvider = paramWebViewProvider.getWebView().getPluginEngine();
    if (paramWebViewProvider == null)
    {
      QLog.d("WebViewSurfaceInjectorImpl", 1, "Activity result weibo null == engine.");
      return;
    }
    paramWebViewProvider = paramWebViewProvider.b("share");
    if (paramWebViewProvider == null)
    {
      QLog.d("WebViewSurfaceInjectorImpl", 1, "Activity result weibo null == plugin.");
      return;
    }
    paramWebViewProvider.onActivityResult(paramIntent, (byte)paramInt1, paramInt2);
  }
  
  private boolean a(CustomWebView paramCustomWebView, SwiftIphoneTitleBarUI paramSwiftIphoneTitleBarUI)
  {
    if (paramCustomWebView != null)
    {
      if ((paramSwiftIphoneTitleBarUI.t != null) && (paramSwiftIphoneTitleBarUI.t.c))
      {
        paramCustomWebView.callJs4OpenApi(paramSwiftIphoneTitleBarUI.t, 0, new String[] { "" });
        return true;
      }
      if (!TextUtils.isEmpty(paramSwiftIphoneTitleBarUI.r))
      {
        paramCustomWebView.callJs(paramSwiftIphoneTitleBarUI.r, new String[] { "" });
        return true;
      }
      if (paramSwiftIphoneTitleBarUI.s != null)
      {
        DoraemonUtil.b(paramSwiftIphoneTitleBarUI.s, APIParam.a);
        return true;
      }
    }
    return false;
  }
  
  private void h(WebViewProvider paramWebViewProvider)
  {
    NewerGuideBannerViewModel.a(paramWebViewProvider.getIntent().getStringExtra("source_from"));
  }
  
  private void i(WebViewProvider paramWebViewProvider)
  {
    if (!this.h)
    {
      this.h = true;
      paramWebViewProvider = paramWebViewProvider.getIntent().getStringExtra("url");
      if (WebSoUtils.b(paramWebViewProvider)) {
        ThreadManager.postImmediately(new WebViewSurfaceInjectorImpl.7(this, paramWebViewProvider), null, false);
      }
    }
  }
  
  void a(int paramInt, String paramString, BusinessObserver paramBusinessObserver, WebViewProvider paramWebViewProvider)
  {
    AppUrlOpenGroup.ReqBody localReqBody = new AppUrlOpenGroup.ReqBody();
    localReqBody.uint32_appid.set(paramInt);
    localReqBody.bytes_url.set(ByteStringMicro.copyFromUtf8(paramWebViewProvider.getCurrentUrl()));
    localReqBody.bytes_param.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = new NewIntent(BaseApplicationImpl.getApplication(), ProtoServlet.class);
    paramString.putExtra("cmd", "GroupOpen.CheckAppUrl");
    paramString.putExtra("data", localReqBody.toByteArray());
    paramString.setObserver(paramBusinessObserver);
    paramWebViewProvider.getAppRuntime().startServlet(paramString);
  }
  
  public void a(WebViewProvider paramWebViewProvider)
  {
    Object localObject = new Intent("tencent.notify.foreground");
    ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
    ((Intent)localObject).putExtra("selfuin", paramWebViewProvider.getUin());
    ((Intent)localObject).putExtra("AccountInfoSync", "mobileqq.web");
    ((Intent)localObject).putExtra("classname", getClass().getName());
    BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    localObject = BridgeHelper.a(paramWebViewProvider.getHostActivity(), paramWebViewProvider.getUin()).a("buscard_registerNFC");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || ("true".equals(localObject))) {
      ActivityLifecycle.onResume(paramWebViewProvider.getHostActivity());
    }
    ThreadManager.executeOnSubThread(new WebViewSurfaceInjectorImpl.1(this, paramWebViewProvider));
    if ((this.d) && (SimpleQZoneUIUtil.a())) {
      QzoneOnlineTimeCollectRptService.getInstance().beginTrace(1);
    }
  }
  
  public void a(WebViewProvider paramWebViewProvider, Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(WebViewProvider paramWebViewProvider, Bundle paramBundle, TouchWebView paramTouchWebView)
  {
    paramBundle = (SwiftBrowserStatistics)paramWebViewProvider.getComponentProvider().a(-2);
    MobileReportManager.getInstance().reportH5Trace(paramWebViewProvider.getCurrentUrl(), 130, System.currentTimeMillis() - paramBundle.d, "0", paramBundle.aQ, paramBundle.aR);
  }
  
  public void a(WebViewProvider paramWebViewProvider, View paramView)
  {
    SwiftBrowserUIStyleHandler localSwiftBrowserUIStyleHandler = (SwiftBrowserUIStyleHandler)paramWebViewProvider.getComponentProvider().a(2);
    SwiftIphoneTitleBarUI localSwiftIphoneTitleBarUI = localSwiftBrowserUIStyleHandler.g;
    SwiftBrowserUIStyle localSwiftBrowserUIStyle = localSwiftBrowserUIStyleHandler.f;
    if ((paramView != localSwiftIphoneTitleBarUI.h) && (paramView != localSwiftIphoneTitleBarUI.g))
    {
      if (paramView == localSwiftIphoneTitleBarUI.f)
      {
        paramView = paramWebViewProvider.getCurrentUrl();
        if ((paramView != null) && (paramView.contains("checkin/index")))
        {
          paramView = new Intent();
          paramView.setAction("SignInSbumited");
          BaseApplicationImpl.getApplication().sendBroadcast(paramView);
        }
        if (!a(paramWebViewProvider.getWebView(), localSwiftIphoneTitleBarUI)) {
          if (localSwiftBrowserUIStyle.u)
          {
            paramWebViewProvider.doOnBackEvent();
          }
          else
          {
            ReportCenter.a().a("", "", "", "1000", "100", "0", false);
            paramWebViewProvider.showActionSheet();
          }
        }
        if (localSwiftBrowserUIStyleHandler.s != null)
        {
          paramWebViewProvider = localSwiftBrowserUIStyleHandler.s.getParent();
          if ((paramWebViewProvider != null) && ((paramWebViewProvider instanceof ViewGroup))) {
            ((ViewGroup)paramWebViewProvider).removeView(localSwiftBrowserUIStyleHandler.s);
          }
        }
      }
      else
      {
        if (paramView == localSwiftBrowserUIStyleHandler.h.f)
        {
          if (localSwiftBrowserUIStyle.U)
          {
            LpReportInfo_dc02216.reportExit();
            if (paramWebViewProvider.getWebView() != null)
            {
              paramView = paramWebViewProvider.getWebView().getPluginEngine();
              if ((paramView != null) && (paramView.a(paramWebViewProvider.getCurrentUrl(), 8589934615L, null)))
              {
                localSwiftBrowserUIStyleHandler.h.d.setVisibility(8);
                localSwiftBrowserUIStyleHandler.h.a(localSwiftBrowserUIStyleHandler.h.c, true);
                localSwiftBrowserUIStyleHandler.h.k.setVisibility(8);
                return;
              }
            }
          }
          localSwiftBrowserUIStyleHandler.h.d.setVisibility(8);
          localSwiftBrowserUIStyleHandler.h.a(localSwiftBrowserUIStyleHandler.h.c, true);
          localSwiftBrowserUIStyleHandler.h.k.setVisibility(8);
          paramWebViewProvider.getHostActivity().finish();
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "exit", "", "", "");
          return;
        }
        if (paramView == localSwiftBrowserUIStyleHandler.h.h)
        {
          if (SwiftBrowserShareMenuHandler.x != -1L) {
            SwiftBrowserShareMenuHandler.x = -1L;
          }
          localSwiftBrowserUIStyleHandler.h.d.setVisibility(8);
          localSwiftBrowserUIStyleHandler.h.a(localSwiftBrowserUIStyleHandler.h.c, true);
          localSwiftBrowserUIStyleHandler.h.k.setVisibility(8);
          paramWebViewProvider.showActionSheet();
          ReportCenter.a().a("", "", "", "1000", "100", "0", false);
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "share", "", "", "");
          if (localSwiftBrowserUIStyle.U) {
            LpReportInfo_dc02216.reportShare();
          }
        }
        else if (paramView == localSwiftBrowserUIStyleHandler.h.j)
        {
          paramView = new Intent(paramWebViewProvider.getHostActivity(), QQBrowserActivity.class);
          paramView.putExtra("key_isReadModeEnabled", true);
          paramView.putExtra("url", "https://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155");
          paramWebViewProvider.getHostActivity().startActivity(paramView);
          paramWebViewProvider.getHostActivity().finish();
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "mUIStyleHandler.moreGame", "https://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("zivonchen", 2, "QQBrowserActivity 1 loadUrl = https://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155");
          }
        }
        else if (paramView == localSwiftBrowserUIStyleHandler.h.i)
        {
          localSwiftBrowserUIStyleHandler.h.d.setVisibility(8);
          localSwiftBrowserUIStyleHandler.h.a(localSwiftBrowserUIStyleHandler.h.c, true);
          localSwiftBrowserUIStyleHandler.h.k.setVisibility(8);
          if ((paramWebViewProvider instanceof WebUiUtils.WebShareInterface))
          {
            paramView = (Share)((WebUiUtils.WebShareInterface)paramWebViewProvider).getShare();
            if ((paramView != null) && (!TextUtils.isEmpty(paramView.Z))) {
              paramWebViewProvider.getWebView().callJs(paramView.Z, new String[] { "" });
            }
            if (QLog.isColorLevel()) {
              QLog.d("WebViewSurfaceInjectorImpl", 2, "call js function getShare().mOnShareHandler");
            }
          }
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "senddesk", "", "", "");
          if (localSwiftBrowserUIStyle.U) {
            LpReportInfo_dc02216.reportExit();
          }
        }
        else if (paramView == localSwiftBrowserUIStyleHandler.h.g)
        {
          localSwiftBrowserUIStyleHandler.h.d.setVisibility(8);
          localSwiftBrowserUIStyleHandler.h.a(localSwiftBrowserUIStyleHandler.h.c, true);
          localSwiftBrowserUIStyleHandler.h.k.setVisibility(8);
          if (localSwiftBrowserUIStyle.T)
          {
            if (TextUtils.isEmpty(paramWebViewProvider.getWebView().getTitle())) {
              paramView = HardCodeUtil.a(2131913816);
            } else {
              paramView = paramWebViewProvider.getWebView().getTitle();
            }
            WebViewJumpUtils.a(String.format(HardCodeUtil.a(2131913811), new Object[] { paramView }), 2130838358, null, SingleTaskQQBrowser.class.getName(), paramWebViewProvider);
            ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "fold", "", "", "");
            return;
          }
          if (localSwiftBrowserUIStyle.S) {
            WebViewJumpUtils.b(paramWebViewProvider);
          }
        }
        else if (paramView == localSwiftBrowserUIStyleHandler.q)
        {
          paramView = new HashMap();
          paramView.put("intent", paramWebViewProvider.getIntent());
          paramWebViewProvider.getWebView().getPluginEngine().a(paramWebViewProvider.getWebView().getUrl(), 8589934622L, paramView);
        }
      }
    }
    else
    {
      if (SwiftBrowserShareMenuHandler.x != -1L) {
        SwiftBrowserShareMenuHandler.x = -1L;
      }
      paramView = new Intent();
      paramView.setAction("SignInSbumited");
      BaseApplicationImpl.getApplication().sendBroadcast(paramView);
      if (!a(paramWebViewProvider.getWebView(), localSwiftIphoneTitleBarUI))
      {
        ReportCenter.a().a("", "", "", "1000", "100", "0", false);
        paramWebViewProvider.showActionSheet();
      }
      if (localSwiftBrowserUIStyleHandler.s != null)
      {
        paramWebViewProvider = localSwiftBrowserUIStyleHandler.s.getParent();
        if ((paramWebViewProvider != null) && ((paramWebViewProvider instanceof ViewGroup))) {
          ((ViewGroup)paramWebViewProvider).removeView(localSwiftBrowserUIStyleHandler.s);
        }
      }
    }
  }
  
  public void a(WebViewProvider paramWebViewProvider, WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    paramWebView = (SwiftBrowserStatistics)paramWebViewProvider.getComponentProvider().a(-2);
    MobileReportManager.getInstance().reportH5Trace(paramWebViewProvider.getCurrentUrl(), 132, System.currentTimeMillis() - paramWebView.d, String.valueOf(paramInt), paramWebView.aQ, paramWebView.aR);
  }
  
  public void a(WebViewProvider paramWebViewProvider, WebView paramWebView, SslError paramSslError)
  {
    paramWebView = (SwiftBrowserStatistics)paramWebViewProvider.getComponentProvider().a(-2);
    MobileReportManager.getInstance().reportH5Trace(paramWebViewProvider.getCurrentUrl(), 132, System.currentTimeMillis() - paramWebView.d, String.valueOf(paramSslError.getPrimaryError()), paramWebView.aQ, paramWebView.aR);
  }
  
  public void a(WebViewProvider paramWebViewProvider, WebView paramWebView, String paramString)
  {
    this.a = true;
    this.b = 100;
    SwiftBrowserStatistics localSwiftBrowserStatistics = (SwiftBrowserStatistics)paramWebViewProvider.getComponentProvider().a(-2);
    if (localSwiftBrowserStatistics.au)
    {
      MobileReportManager.getInstance().reportH5Trace(paramString, 131, localSwiftBrowserStatistics.ab - localSwiftBrowserStatistics.Y, "0", localSwiftBrowserStatistics.aQ, localSwiftBrowserStatistics.aR);
      MobileReportManager.getInstance().reportH5Trace(paramString, 129, localSwiftBrowserStatistics.ab - localSwiftBrowserStatistics.d, "0", localSwiftBrowserStatistics.aQ, localSwiftBrowserStatistics.aR);
    }
    paramWebViewProvider = paramWebViewProvider.getHostActivity();
    if ((paramWebViewProvider instanceof QQBrowserActivity)) {
      ((QQBrowserActivity)paramWebViewProvider).onPageFinished(paramWebView, paramString);
    }
    if ((paramWebView instanceof CustomWebView)) {
      BusinessReporter.a((CustomWebView)paramWebView);
    }
  }
  
  public void a(WebViewProvider paramWebViewProvider, WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((!this.a) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).articleReport(paramString, this.b, this.c))) {
      this.a = true;
    }
  }
  
  public void a(WebViewProvider paramWebViewProvider, String paramString, GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.indexOf(':') == -1)
      {
        localObject = paramString;
        if (paramWebViewProvider.getWebView() != null)
        {
          localObject = paramString;
          if (paramWebViewProvider.getWebView().getX5WebViewExtension() != null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("https://");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append("/");
            localObject = ((StringBuilder)localObject).toString();
          }
        }
      }
    }
    boolean bool2 = AuthorizeConfig.a().a((String)localObject, "publicAccount.getLocation");
    if (paramWebViewProvider.getWebView() != null) {
      paramString = Util.a(paramWebViewProvider.getWebView().getUrl(), 2);
    } else {
      paramString = "";
    }
    paramWebViewProvider = paramWebViewProvider.getUin();
    boolean bool3 = ((IPublicAccountJavascriptInterface)QRoute.api(IPublicAccountJavascriptInterface.class)).getLocationPermissionGrant(paramWebViewProvider, paramString);
    boolean bool1;
    if ((bool3) && (bool2)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebViewSurfaceInjectorImpl", 2, new Object[] { "onGeolocationPermissionsShowPrompt allow:", Boolean.valueOf(bool2), " granted:", Boolean.valueOf(bool3), " hasRight:", Boolean.valueOf(bool1), " uin:", paramWebViewProvider, " urlHost:", paramString });
    }
    paramGeolocationPermissionsCallback.invoke((String)localObject, bool1, false);
  }
  
  public boolean a(WebViewProvider paramWebViewProvider, int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (paramInt2 == -1) {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 11)
        {
          if (paramInt1 != 28675) {
            break label166;
          }
          localObject = paramIntent.getStringExtra("DELETE_BLOG");
          if (paramWebViewProvider.getWebView() != null) {
            paramWebViewProvider.getWebView().loadUrl((String)localObject);
          }
        }
        if (paramIntent != null)
        {
          boolean bool = paramIntent.getBooleanExtra("click_long_screen_shot", false);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("REQUEST_TO_SCREEN_SHOT_PAGE. clickLongScreenShot is ");
          ((StringBuilder)localObject).append(bool);
          QLog.d("WebViewSurfaceInjectorImpl", 1, ((StringBuilder)localObject).toString());
          if ((bool) && (paramWebViewProvider.getWebView() != null))
          {
            QLog.d("WebViewSurfaceInjectorImpl", 1, "start screen long shot");
            ScreenShotUtil.b(paramWebViewProvider.getWebView(), new WebViewSurfaceInjectorImpl.6(this, paramWebViewProvider));
          }
        }
      }
      else
      {
        QfavBuilder.a(paramWebViewProvider.getHostActivity(), paramIntent);
        return true;
      }
    }
    label166:
    if ((!TextUtils.isEmpty(paramWebViewProvider.getCurrentUrl())) && (paramWebViewProvider.getCurrentUrl().contains("closeSpecialLogic=1")) && (paramIntent != null) && (paramIntent.getBooleanExtra("closeSpecialLogic", false)))
    {
      paramWebViewProvider.getHostActivity().setResult(-1, paramIntent);
      paramWebViewProvider.getHostActivity().finish();
      return true;
    }
    if (paramInt1 == 21)
    {
      localObject = AIOUtils.a(new Intent(paramWebViewProvider.getHostActivity(), SplashActivity.class), null);
      if (paramIntent != null)
      {
        ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
        paramWebViewProvider.getHostActivity().startActivity((Intent)localObject);
      }
      return true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResult, requestCode=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", resultCode=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("WebViewSurfaceInjectorImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (WBShareHelper.a(paramIntent, paramInt1))
    {
      a(paramWebViewProvider, paramIntent, paramInt1, paramInt2);
      return true;
    }
    return false;
  }
  
  public boolean a(WebViewProvider paramWebViewProvider, int paramInt, Intent paramIntent)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    if (paramIntent == null) {
      return true;
    }
    String str = paramIntent.getStringExtra("callbackSn");
    paramIntent = paramIntent.getStringExtra("result");
    CustomWebView localCustomWebView = paramWebViewProvider.getWebView();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:window.JsBridge&&JsBridge.callback('");
    localStringBuilder.append(str);
    localStringBuilder.append("',{'r':0,'result':");
    localStringBuilder.append(paramIntent);
    localStringBuilder.append("});");
    localCustomWebView.loadUrl(localStringBuilder.toString());
    try
    {
      ((QzonePlugin)paramWebViewProvider.getWebView().getPluginEngine().a(QzonePlugin.a, true)).b(paramIntent);
      return true;
    }
    catch (Exception paramWebViewProvider)
    {
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onActivityResult: mPayActionException=");
        paramIntent.append(paramWebViewProvider.getMessage());
        QLog.d("WebViewSurfaceInjectorImpl", 2, paramIntent.toString());
      }
    }
    return true;
  }
  
  public boolean a(WebViewProvider paramWebViewProvider, Intent paramIntent)
  {
    Object localObject;
    if ("actionSelectPicture".equals(paramIntent.getStringExtra("keyAction")))
    {
      int i = -1;
      int j = paramIntent.getIntExtra("requestCode", -1);
      int k = j >> 8 & 0xFF;
      if (k > 0)
      {
        if (paramWebViewProvider.getWebView() != null)
        {
          localObject = paramWebViewProvider.getWebView().getPluginEngine();
          if (localObject != null)
          {
            localObject = ((WebViewPluginEngine)localObject).a(k, true);
            if (localObject != null)
            {
              if (!paramIntent.hasExtra("PhotoConst.PHOTO_PATHS")) {
                i = 0;
              }
              ((WebViewPlugin)localObject).onActivityResult(paramIntent, (byte)(j & 0xFF), i);
              return true;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.w("WebViewSurfaceInjectorImpl", 2, "Caution! activity result not handled!");
        }
      }
    }
    if ("actionSelectPicture".equals(paramIntent.getStringExtra("keyAction"))) {
      return true;
    }
    if ("android.nfc.action.TECH_DISCOVERED".equals(paramIntent.getAction())) {
      return true;
    }
    if (paramIntent.getBooleanExtra("fromNotification", false)) {
      return true;
    }
    if (paramIntent.getBooleanExtra("keyFromUpdateAvatar", false))
    {
      localObject = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (localObject != null)
      {
        paramWebViewProvider = new Bundle();
        paramWebViewProvider.putString("path", (String)localObject);
        paramWebViewProvider = DataFactory.a("ipc_update_avatar", "", 0, paramWebViewProvider);
        ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(paramWebViewProvider);
        return true;
      }
    }
    boolean bool = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnNewIntent, isPhotoPlusEditSend = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("WebViewSurfaceInjectorImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      paramIntent.removeExtra("PhotoConst.SEND_FLAG");
      localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = (String)((ArrayList)localObject).get(0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("editScreenShotBack:");
        localStringBuilder.append((String)localObject);
        QLog.d("WebViewSurfaceInjectorImpl", 2, localStringBuilder.toString());
        paramWebViewProvider = (SwiftBrowserScreenShotHandler)paramWebViewProvider.getComponentProvider().a(64);
        if (paramWebViewProvider != null) {
          paramWebViewProvider.a((String)localObject, paramIntent.getStringExtra("image_path"), paramIntent.getIntExtra("EditPicType", 0));
        }
      }
    }
    return false;
  }
  
  public void b(WebViewProvider paramWebViewProvider)
  {
    String str = BridgeHelper.a(paramWebViewProvider.getHostActivity(), paramWebViewProvider.getUin()).a("buscard_registerNFC");
    if ((TextUtils.isEmpty(str)) || ("true".equals(str))) {
      ActivityLifecycle.onPause(paramWebViewProvider.getHostActivity());
    }
    if ((this.d) && (SimpleQZoneUIUtil.a())) {
      QzoneOnlineTimeCollectRptService.getInstance().closeTrace();
    }
  }
  
  public void b(WebViewProvider paramWebViewProvider, Bundle paramBundle)
  {
    Util.f("Web_IPCSetup");
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).doBindService(BaseApplicationImpl.getApplication());
    }
    Util.g("Web_IPCSetup");
    if ((((SwiftBrowserUIStyleHandler)paramWebViewProvider.getComponentProvider().a(2)).f.c & 0x400000) > 0L)
    {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new WebViewSurfaceInjectorImpl.3(this, 0, false, false, 600000L, false, false, "webview"));
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new WebViewSurfaceInjectorImpl.4(this, 0, true, false, 600000L, false, false, "webview"));
    }
  }
  
  public void b(WebViewProvider paramWebViewProvider, WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    h(paramWebViewProvider);
  }
  
  /* Error */
  public boolean b(WebViewProvider paramWebViewProvider, WebView paramWebView, String paramString)
  {
    // Byte code:
    //   0: invokestatic 362	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: ldc_w 950
    //   8: invokestatic 646	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   11: checkcast 950	com/tencent/mobileqq/qwallet/utils/IPayInterceptApi
    //   14: aload_3
    //   15: aload_1
    //   16: checkcast 952	com/tencent/mobileqq/webview/swift/WebViewFragment
    //   19: invokeinterface 956 3 0
    //   24: istore 6
    //   26: new 661	java/lang/StringBuilder
    //   29: dup
    //   30: ldc_w 958
    //   33: invokespecial 959	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: astore 8
    //   38: aload 8
    //   40: iload 6
    //   42: invokevirtual 734	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 8
    //   48: ldc_w 961
    //   51: invokevirtual 668	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 8
    //   57: invokestatic 362	java/lang/System:currentTimeMillis	()J
    //   60: lload 4
    //   62: lsub
    //   63: invokevirtual 964	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 8
    //   69: ldc_w 966
    //   72: invokevirtual 668	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: ldc 38
    //   78: iconst_1
    //   79: aload 8
    //   81: invokevirtual 673	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 968	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: iload 6
    //   89: ifeq +5 -> 94
    //   92: iconst_1
    //   93: ireturn
    //   94: new 129	android/content/Intent
    //   97: dup
    //   98: ldc_w 970
    //   101: aload_3
    //   102: invokestatic 976	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   105: invokespecial 979	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   108: astore 9
    //   110: aload 9
    //   112: ldc_w 980
    //   115: invokevirtual 984	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   118: pop
    //   119: aload 9
    //   121: ldc 141
    //   123: aload_1
    //   124: invokeinterface 179 1 0
    //   129: invokevirtual 262	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   132: pop
    //   133: aload 9
    //   135: aload_1
    //   136: invokeinterface 287 1 0
    //   141: invokevirtual 988	android/app/Activity:getPackageManager	()Landroid/content/pm/PackageManager;
    //   144: iconst_0
    //   145: invokevirtual 992	android/content/Intent:resolveActivityInfo	(Landroid/content/pm/PackageManager;I)Landroid/content/pm/ActivityInfo;
    //   148: astore 8
    //   150: aload 8
    //   152: ifnull +216 -> 368
    //   155: aload 8
    //   157: getfield 997	android/content/pm/ActivityInfo:packageName	Ljava/lang/String;
    //   160: astore 8
    //   162: goto +3 -> 165
    //   165: ldc_w 999
    //   168: aload_2
    //   169: invokevirtual 1002	com/tencent/smtt/sdk/WebView:getUrl	()Ljava/lang/String;
    //   172: aload 8
    //   174: ldc_w 1004
    //   177: ldc_w 492
    //   180: aload_1
    //   181: invokeinterface 287 1 0
    //   186: invokevirtual 272	java/lang/Object:getClass	()Ljava/lang/Class;
    //   189: invokevirtual 277	java/lang/Class:getName	()Ljava/lang/String;
    //   192: invokestatic 1009	com/tencent/mobileqq/app/StartAppCheckHandler:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   195: aload_1
    //   196: invokeinterface 125 1 0
    //   201: astore_2
    //   202: aload_2
    //   203: ldc_w 1011
    //   206: iconst_0
    //   207: invokevirtual 729	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   210: istore 6
    //   212: aload_2
    //   213: ldc_w 1013
    //   216: ldc2_w 509
    //   219: invokevirtual 1017	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   222: lstore 4
    //   224: aload 9
    //   226: ldc_w 1011
    //   229: iload 6
    //   231: invokevirtual 524	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   234: pop
    //   235: aload 9
    //   237: ldc_w 1013
    //   240: lload 4
    //   242: invokevirtual 1020	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   245: pop
    //   246: aload_0
    //   247: getfield 1022	com/tencent/mobileqq/webview/swift/WebViewSurfaceInjectorImpl:e	Lcom/tencent/mobileqq/haoliyou/JefsClass$Cancelable;
    //   250: ifnull +10 -> 260
    //   253: aload_0
    //   254: getfield 1022	com/tencent/mobileqq/webview/swift/WebViewSurfaceInjectorImpl:e	Lcom/tencent/mobileqq/haoliyou/JefsClass$Cancelable;
    //   257: invokevirtual 1026	com/tencent/mobileqq/haoliyou/JefsClass$Cancelable:a	()V
    //   260: aload_1
    //   261: invokeinterface 125 1 0
    //   266: ldc_w 1028
    //   269: iconst_0
    //   270: invokevirtual 729	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   273: istore 7
    //   275: invokestatic 1033	com/tencent/mobileqq/haoliyou/JefsClass:getInstance	()Lcom/tencent/mobileqq/haoliyou/JefsClass;
    //   278: astore_2
    //   279: aload_1
    //   280: invokeinterface 287 1 0
    //   285: astore 10
    //   287: aload_0
    //   288: aload_2
    //   289: aload 10
    //   291: aload 9
    //   293: aload_3
    //   294: new 1035	com/tencent/mobileqq/webview/swift/WebViewSurfaceInjectorImpl$2
    //   297: dup
    //   298: aload_0
    //   299: aload_1
    //   300: aload 9
    //   302: iload 7
    //   304: aload 8
    //   306: iload 6
    //   308: lload 4
    //   310: invokespecial 1038	com/tencent/mobileqq/webview/swift/WebViewSurfaceInjectorImpl$2:<init>	(Lcom/tencent/mobileqq/webview/swift/WebViewSurfaceInjectorImpl;Lcom/tencent/mobileqq/webview/swift/WebViewProvider;Landroid/content/Intent;ZLjava/lang/String;ZJ)V
    //   313: invokevirtual 1041	com/tencent/mobileqq/haoliyou/JefsClass:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;Ljava/lang/Runnable;)Lcom/tencent/mobileqq/haoliyou/JefsClass$Cancelable;
    //   316: putfield 1022	com/tencent/mobileqq/webview/swift/WebViewSurfaceInjectorImpl:e	Lcom/tencent/mobileqq/haoliyou/JefsClass$Cancelable;
    //   319: goto +21 -> 340
    //   322: astore_1
    //   323: goto +4 -> 327
    //   326: astore_1
    //   327: ldc 38
    //   329: astore_2
    //   330: aload_2
    //   331: iconst_1
    //   332: aload_1
    //   333: iconst_0
    //   334: anewarray 4	java/lang/Object
    //   337: invokestatic 1044	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   340: iconst_1
    //   341: ireturn
    //   342: astore_1
    //   343: goto +14 -> 357
    //   346: astore_1
    //   347: ldc 38
    //   349: astore_2
    //   350: goto +7 -> 357
    //   353: astore_1
    //   354: ldc 38
    //   356: astore_2
    //   357: aload_2
    //   358: iconst_1
    //   359: ldc_w 1046
    //   362: aload_1
    //   363: invokestatic 1049	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   366: iconst_1
    //   367: ireturn
    //   368: ldc 28
    //   370: astore 8
    //   372: goto -207 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	this	WebViewSurfaceInjectorImpl
    //   0	375	1	paramWebViewProvider	WebViewProvider
    //   0	375	2	paramWebView	WebView
    //   0	375	3	paramString	String
    //   3	306	4	l	long
    //   24	283	6	bool1	boolean
    //   273	30	7	bool2	boolean
    //   36	335	8	localObject	Object
    //   108	193	9	localIntent	Intent
    //   285	5	10	localActivity	Activity
    // Exception table:
    //   from	to	target	type
    //   287	319	322	java/lang/Throwable
    //   260	287	326	java/lang/Throwable
    //   330	340	342	java/lang/Exception
    //   287	319	346	java/lang/Exception
    //   119	150	353	java/lang/Exception
    //   155	162	353	java/lang/Exception
    //   165	260	353	java/lang/Exception
    //   260	287	353	java/lang/Exception
  }
  
  public void c(WebViewProvider paramWebViewProvider)
  {
    Object localObject = (SwiftBrowserStatistics)paramWebViewProvider.getComponentProvider().a(-2);
    MobileReportManager.getInstance().reportH5Trace(paramWebViewProvider.getCurrentUrl(), 133, System.currentTimeMillis() - ((SwiftBrowserStatistics)localObject).ab, "0", ((SwiftBrowserStatistics)localObject).aQ, ((SwiftBrowserStatistics)localObject).aR);
    h(paramWebViewProvider);
    paramWebViewProvider = Long.valueOf(paramWebViewProvider.getIntent().getLongExtra("Gif_msg_uniseq_key", 0L));
    if (paramWebViewProvider.longValue() > 0L)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("Gif_msg_uniseq_key", paramWebViewProvider.longValue());
      paramWebViewProvider = DataFactory.a("close_annimate", null, -1, (Bundle)localObject);
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramWebViewProvider);
    }
    paramWebViewProvider = this.e;
    if (paramWebViewProvider != null) {
      paramWebViewProvider.a();
    }
    if (QQBrowserActivity.sQQBrowserActivityCounter == 0)
    {
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).doUnbindService(BaseApplicationImpl.getApplication());
      com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.CrashStepStatsEntry.h = -1;
    }
  }
  
  public void c(WebViewProvider paramWebViewProvider, Bundle paramBundle)
  {
    paramBundle = paramWebViewProvider.getIntent().getExtras();
    if (paramBundle != null)
    {
      boolean bool = paramBundle.getBoolean("isOpeningQunApp");
      this.f = paramBundle.getInt("appid");
      this.g = paramBundle.getInt("troopid");
      Object localObject = paramBundle.getString("extraParams");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      if (Boolean.valueOf(bool).booleanValue())
      {
        localObject = ((SwiftBrowserUIStyleHandler)paramWebViewProvider.getComponentProvider().a(2)).g;
        if (!SwiftWebViewUtils.d()) {
          ((SwiftIphoneTitleBarUI)localObject).d.setText(paramWebViewProvider.getResource().getString(2131887812));
        } else if (((SwiftIphoneTitleBarUI)localObject).d.getBackground() == null) {
          ((SwiftIphoneTitleBarUI)localObject).d.setText(paramWebViewProvider.getResource().getString(2131887812));
        }
        a(this.f, paramBundle, new WebViewSurfaceInjectorImpl.5(this, paramWebViewProvider, (SwiftIphoneTitleBarUI)localObject), paramWebViewProvider);
      }
    }
  }
  
  public boolean c(WebViewProvider paramWebViewProvider, WebView paramWebView, String paramString)
  {
    paramWebView = SwiftWebViewUtils.b(paramString);
    if ((("http".equals(paramWebView)) || ("data".equals(paramWebView))) && ((paramWebViewProvider.getHostActivity() instanceof QQBrowserActivity))) {
      if ((paramWebViewProvider.getAppRuntime() != null) && (paramWebViewProvider.getAppRuntime().getManager(QQManagerFactory.URL_INTECEPT_MANAGER) != null))
      {
        paramWebView = ((URLInterceptManager)paramWebViewProvider.getAppRuntime().getManager(QQManagerFactory.URL_INTECEPT_MANAGER)).a(paramString);
        if (paramWebView != null)
        {
          paramString = new Intent(paramWebViewProvider.getHostActivity(), JumpActivity.class);
          paramString.setData(Uri.parse(paramWebView));
          paramString.putExtra("from", "webview");
          paramWebViewProvider.getHostActivity().startActivity(paramString);
          return true;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("WebViewSurfaceInjectorImpl", 2, "URLInterceptManager = null");
      }
    }
    return false;
  }
  
  void d(WebViewProvider paramWebViewProvider)
  {
    String str = paramWebViewProvider.getIntent().getStringExtra("url");
    if (WebSoUtils.b(str)) {
      WebSoScreenshot.a(paramWebViewProvider.getHostActivity(), str);
    }
  }
  
  public void d(WebViewProvider paramWebViewProvider, Bundle paramBundle) {}
  
  public void e(WebViewProvider paramWebViewProvider)
  {
    if (paramWebViewProvider.getIntent().getBooleanExtra("flow_key_from_guide", false))
    {
      Intent localIntent = new Intent();
      localIntent.setClass(BaseApplicationImpl.getApplication(), SplashActivity.class);
      localIntent.putExtra("tab_index", FrameControllerUtil.a);
      localIntent.addFlags(67108864);
      paramWebViewProvider.getHostActivity().startActivity(localIntent);
    }
  }
  
  public void e(WebViewProvider paramWebViewProvider, Bundle paramBundle)
  {
    d(paramWebViewProvider);
  }
  
  public void f(WebViewProvider paramWebViewProvider)
  {
    ((SwiftBrowserShareMenuHandler)paramWebViewProvider.getComponentProvider().a(4)).i();
  }
  
  public boolean g(WebViewProvider paramWebViewProvider)
  {
    if (JumpForwardPkgManager.a().a(paramWebViewProvider.getCurrentUrl()))
    {
      paramWebViewProvider.getWebView().loadUrl("file:///android_asset/error.html");
      QLog.d("WebViewSurfaceInjectorImpl", 1, new Object[] { "url:", paramWebViewProvider.getCurrentUrl(), "in black" });
      return false;
    }
    if (!TextUtils.isEmpty(paramWebViewProvider.getCurrentUrl())) {
      paramWebViewProvider.getWebView().loadUrl(paramWebViewProvider.getCurrentUrl());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewSurfaceInjectorImpl
 * JD-Core Version:    0.7.0.1
 */
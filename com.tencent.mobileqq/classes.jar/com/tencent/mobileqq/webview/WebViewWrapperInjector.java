package com.tencent.mobileqq.webview;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor;
import com.tencent.mobileqq.activity.springfestival.js.SpringHbUrlInterceptor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webview.swift.IWebViewWrapperInjector;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.TbsAccelerator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class WebViewWrapperInjector
  implements IWebViewWrapperInjector
{
  public WebResourceResponse a(WebView paramWebView, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramString1.startsWith("mqqpa://resourceid/")) {
      return ((IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class)).getWebResponse(paramString1);
    }
    return SpringHbUrlInterceptor.a(paramString1);
  }
  
  public void a(Bundle paramBundle, WebView paramWebView, String paramString)
  {
    ArrayList localArrayList;
    boolean bool1;
    String str2;
    boolean bool2;
    boolean bool3;
    StringBuilder localStringBuilder;
    try
    {
      localArrayList = (ArrayList)paramBundle.get("recognised-text");
      bool1 = paramBundle.getBoolean("virtual-keyboard", false);
      str2 = paramBundle.getString("normal-input-value-change");
      bool2 = paramBundle.getBoolean("password-start-input", false);
      bool3 = paramBundle.getBoolean("password-input-show", false);
      localStringBuilder = new StringBuilder(128);
      if (localArrayList != null)
      {
        paramBundle = localArrayList.iterator();
        while (paramBundle.hasNext())
        {
          localStringBuilder.append((String)paramBundle.next()).append(",");
          continue;
          return;
        }
      }
    }
    catch (Throwable paramBundle)
    {
      QLog.e("WebViewWrapperInjector", 2, "onFakeLoginRecognised ", paramBundle);
    }
    paramBundle = "";
    String str1 = "";
    if (paramWebView != null)
    {
      paramBundle = paramWebView.getOriginalUrl();
      str1 = paramWebView.getUrl();
      SwiftBrowserStatistics.a(paramBundle, str1, localStringBuilder.toString(), str2, bool2, bool3, bool1);
    }
    if (((localArrayList != null) && (localArrayList.size() > 0)) || (bool1) || (!TextUtils.isEmpty(str2))) {
      if (paramWebView == null) {
        break label278;
      }
    }
    label278:
    for (paramWebView = paramWebView.getTitle();; paramWebView = "")
    {
      SwiftBrowserStatistics.a(paramBundle, str1, paramWebView, paramString);
      localStringBuilder.append(" hasVirtualKB:").append(bool1);
      localStringBuilder.append(" inputText:").append(str2);
      localStringBuilder.append(" passwdTyped:").append(bool2);
      localStringBuilder.append(" showPasswdInput:").append(bool3);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("WebViewWrapperInjector", 2, new Object[] { "onFakeLoginRecognised ", localStringBuilder.toString() });
      return;
    }
  }
  
  public void a(TouchWebView paramTouchWebView, Intent paramIntent, long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramTouchWebView.getX5WebViewExtension() != null)
    {
      AIOOpenWebMonitor.b(paramIntent, "use_x5", "1");
      if (SwiftBrowserStatistics.x) {
        break label77;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebViewWrapperInjector", 2, new Object[] { "sReportPerformance:", Boolean.valueOf(SwiftBrowserStatistics.x), " cost:", Long.valueOf(SwiftWebAccelerator.TbsAccelerator.a) });
      }
      return;
      AIOOpenWebMonitor.b(paramIntent, "use_x5", "2");
      break;
      label77:
      paramTouchWebView = new HashMap(5);
      paramTouchWebView.put("createWebview", String.valueOf(paramLong1));
      paramTouchWebView.put("initWebClient", String.valueOf(paramLong2));
      paramTouchWebView.put("setWebSetting", String.valueOf(paramLong3));
      paramTouchWebView.put("coreInit", String.valueOf(SwiftWebAccelerator.TbsAccelerator.a));
      paramTouchWebView.put("coldStart", String.valueOf(SwiftBrowserStatistics.s));
      StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(null, "actWebviewInit", true, 0L, 0L, paramTouchWebView, null);
    }
  }
  
  public void a(WebView paramWebView, String paramString, Intent paramIntent)
  {
    AIOOpenWebMonitor.b(paramIntent);
  }
  
  public boolean a(String paramString)
  {
    return (paramString.startsWith("mqqpa://resourceid/")) || (SpringHbUrlInterceptor.a(paramString));
  }
  
  public void b(WebView paramWebView, String paramString, Intent paramIntent)
  {
    AIOOpenWebMonitor.b(paramIntent, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebViewWrapperInjector
 * JD-Core Version:    0.7.0.1
 */
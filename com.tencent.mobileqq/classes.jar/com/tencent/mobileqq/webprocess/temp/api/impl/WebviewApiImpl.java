package com.tencent.mobileqq.webprocess.temp.api.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.webprocess.temp.api.IWebviewApi;
import com.tencent.mobileqq.webview.sonic.SonicRuntimeImpl;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentContext;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.smtt.sdk.WebView;
import com.tencent.sonic.sdk.SonicRuntime;
import mqq.app.MobileQQ;

public class WebviewApiImpl
  implements IWebviewApi
{
  public SonicRuntime createSonicRuntime()
  {
    return new SonicRuntimeImpl(MobileQQ.getContext());
  }
  
  public String getDnsFileName()
  {
    return ClubContentJsonTask.e.a;
  }
  
  public String getQUA(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return SwiftWebViewUtils.a(SwiftWebViewUtils.b("x5prefetch_1.0"), paramString2, paramBoolean);
    }
    return SwiftWebViewUtils.a(paramString1, paramString2, paramBoolean);
  }
  
  public int getWebViewDialogMultiLineLayout()
  {
    return 2131559085;
  }
  
  public int getWebViewPreloadMode(Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramContext instanceof SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter)) {
      localObject1 = (SwiftBrowserStatistics)((SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter)paramContext).getComponentProvider().a(-2);
    }
    while (localObject1 != null) {
      if (((SwiftBrowserStatistics)localObject1).w)
      {
        return 2;
        localObject1 = localObject2;
        if ((paramContext instanceof SwiftWebViewFragmentSupporter))
        {
          paramContext = ((SwiftWebViewFragmentSupporter)paramContext).getCurrentWebViewFragment();
          localObject1 = localObject2;
          if (paramContext != null) {
            localObject1 = (SwiftBrowserStatistics)paramContext.getComponentProvider().a(-2);
          }
        }
      }
      else
      {
        if (SwiftBrowserStatistics.s) {
          return 1;
        }
        return 0;
      }
    }
    return 0;
  }
  
  public void monitorLoadUrl(Intent paramIntent, String paramString)
  {
    AIOOpenWebMonitor.a(paramIntent, paramString);
  }
  
  public void preCheckOffline(String paramString)
  {
    SwiftBrowserOfflineHandler localSwiftBrowserOfflineHandler = SwiftBrowserOfflineHandler.a(paramString);
    if (localSwiftBrowserOfflineHandler != null) {
      localSwiftBrowserOfflineHandler.a(new WebviewApiImpl.3(this), paramString);
    }
  }
  
  public View preloadWebView()
  {
    WebBrowserViewContainer localWebBrowserViewContainer = new WebBrowserViewContainer(MobileQQ.sMobileQQ);
    localWebBrowserViewContainer.a(false);
    return localWebBrowserViewContainer;
  }
  
  public void removeLastUinCookies(String paramString)
  {
    BrowserAppInterface.a(paramString);
  }
  
  public void reportSchema(String paramString1, String paramString2, int paramInt)
  {
    SwiftBrowserStatistics.a(paramString1, paramString2, paramInt);
  }
  
  public void showPerformanceDialogWhenDebugMode(Object paramObject)
  {
    SwiftBrowserComponentsProvider.SwiftBrowserComponentContext localSwiftBrowserComponentContext = (SwiftBrowserComponentsProvider.SwiftBrowserComponentContext)paramObject;
    SwiftBrowserStatistics localSwiftBrowserStatistics = (SwiftBrowserStatistics)localSwiftBrowserComponentContext.a().a(-2);
    StringBuilder localStringBuilder = new StringBuilder("页面地址:\r\n" + localSwiftBrowserComponentContext.a().getUrl() + "\r\n\r\n关键步骤耗时统计记录:\r\n");
    Object localObject;
    if (localSwiftBrowserStatistics.w)
    {
      paramObject = HardCodeUtil.a(2131714573);
      localStringBuilder.append("加载模式:").append(paramObject).append("\r\n");
      if ((!localSwiftBrowserStatistics.w) && (SwiftBrowserStatistics.t))
      {
        localObject = localStringBuilder.append("是否完全预加载:");
        if (!SwiftBrowserStatistics.t) {
          break label702;
        }
        paramObject = "是";
        label124:
        ((StringBuilder)localObject).append(paramObject).append("\r\n");
      }
      localObject = HardCodeUtil.a(2131714567);
      paramObject = localObject;
      if (-1 != localSwiftBrowserStatistics.a) {}
      switch (localSwiftBrowserStatistics.a)
      {
      default: 
        paramObject = localObject;
        label202:
        localStringBuilder.append("页面模式:").append(paramObject).append("\r\n");
        localObject = localStringBuilder.append("是否命中WebView缓存:");
        if (localSwiftBrowserStatistics.u)
        {
          paramObject = "是";
          label238:
          ((StringBuilder)localObject).append(paramObject).append("\r\n");
          localObject = localStringBuilder.append("是否命中BrowserView缓存:");
          if (!localSwiftBrowserStatistics.v) {
            break label744;
          }
        }
        break;
      }
    }
    label702:
    label744:
    for (paramObject = "是";; paramObject = "否")
    {
      ((StringBuilder)localObject).append(paramObject).append("\r\n");
      if ((!localSwiftBrowserStatistics.w) && (SwiftBrowserStatistics.s))
      {
        localStringBuilder.append("预加载进程响应耗时:").append(SwiftBrowserStatistics.V).append("ms.\r\n");
        localStringBuilder.append("预加载默认处理耗时:").append(SwiftBrowserStatistics.W).append("ms.\r\n");
        localStringBuilder.append("预加载完全处理耗时:").append(SwiftBrowserStatistics.X).append("ms.\r\n");
        localStringBuilder.append("预加载X5环境处理耗时:").append(SwiftBrowserStatistics.Y).append("ms.\r\n");
        localStringBuilder.append("预创建WebView处理耗时:").append(SwiftBrowserStatistics.Z).append("ms.\r\n");
        localStringBuilder.append("预热WebView处理耗时:").append(SwiftBrowserStatistics.aa).append("ms.\r\n");
        localStringBuilder.append("预创建BrowserView处理耗时:").append(SwiftBrowserStatistics.ab).append("ms.\r\n");
      }
      localStringBuilder.append("点击响应打点:").append(localSwiftBrowserStatistics.c - localSwiftBrowserStatistics.b).append("ms.\r\n");
      localStringBuilder.append("终端处理打点:").append(localSwiftBrowserStatistics.r - localSwiftBrowserStatistics.b).append("ms.\r\n");
      localStringBuilder.append("资源加载打点:").append(localSwiftBrowserStatistics.ac).append("ms.\r\n");
      localStringBuilder.append("主资源首行打点:").append(localSwiftBrowserStatistics.ad).append("ms.\r\n");
      localStringBuilder.append("首屏可见打点:").append(localSwiftBrowserStatistics.ae).append("ms.\r\n");
      localStringBuilder.append("首屏可交互打点:").append(localSwiftBrowserStatistics.af).append("ms.\r\n");
      paramObject = localStringBuilder.toString();
      localObject = DialogUtil.a(localSwiftBrowserComponentContext.a(), 230);
      ((QQCustomDialog)localObject).setContentView(2131559085);
      ((QQCustomDialog)localObject).getMessageTextView().setMovementMethod(ScrollingMovementMethod.getInstance());
      ((QQCustomDialog)localObject).setTitle(HardCodeUtil.a(2131714564));
      ((QQCustomDialog)localObject).setMessage(paramObject);
      ((QQCustomDialog)localObject).getMessageTextView().setMaxLines(20);
      ((QQCustomDialog)localObject).getMessageTextView().setEllipsize(TextUtils.TruncateAt.END);
      ((QQCustomDialog)localObject).setPositiveButton("Close", new WebviewApiImpl.1(this));
      ((QQCustomDialog)localObject).setNegativeButton("Copy", new WebviewApiImpl.2(this, localSwiftBrowserComponentContext, paramObject));
      ((QQCustomDialog)localObject).show();
      return;
      if (SwiftBrowserStatistics.s)
      {
        paramObject = HardCodeUtil.a(2131714566);
        break;
      }
      paramObject = HardCodeUtil.a(2131714568);
      break;
      paramObject = "否";
      break label124;
      paramObject = "Sonic首次加载";
      break label202;
      paramObject = "Sonic模板变更";
      break label202;
      paramObject = "Sonic数据更新";
      break label202;
      paramObject = "Sonic完全缓存";
      break label202;
      paramObject = "否";
      break label238;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.temp.api.impl.WebviewApiImpl
 * JD-Core Version:    0.7.0.1
 */
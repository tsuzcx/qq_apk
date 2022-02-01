package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview;

import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WebViewPool
{
  public static WebViewPool a = new WebViewPool();
  private List<WebViewPool.WebviewModel> b = new ArrayList();
  
  private TouchWebView a(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    LogFactory.a().c("WebViewPool", "-------createNewWebview------");
    WebViewPool.WebviewModel localWebviewModel = new WebViewPool.WebviewModel(this);
    localWebviewModel.a = new TouchWebView(BaseApplicationImpl.getContext());
    LogInterface localLogInterface = LogFactory.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-------createNewWebview------totalStamp = ");
    localStringBuilder.append(System.currentTimeMillis() - l);
    localLogInterface.c("WebViewPool", localStringBuilder.toString());
    if (paramBoolean) {
      localWebviewModel.b = false;
    } else {
      localWebviewModel.b = true;
    }
    this.b.add(localWebviewModel);
    return localWebviewModel.a;
  }
  
  public void a()
  {
    LogFactory.a().c("WebViewPool", "-------preload------");
    ThreadManager.executeOnFileThread(new WebViewPool.1(this));
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    LogFactory.a().c("WebViewPool", "-------recycle------");
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      WebViewPool.WebviewModel localWebviewModel = (WebViewPool.WebviewModel)localIterator.next();
      if (localWebviewModel.a.hashCode() == paramTouchWebView.hashCode())
      {
        WebViewPluginEngine localWebViewPluginEngine = paramTouchWebView.getPluginEngine();
        if (localWebViewPluginEngine != null)
        {
          localWebViewPluginEngine.a(paramTouchWebView.getUrl(), 8589934596L, null);
          localWebViewPluginEngine.d();
        }
        localWebviewModel.a.stopLoading();
        localWebviewModel.a.loadUrlOriginal("about:blank");
        paramTouchWebView.resetForReuse();
        paramTouchWebView.onPause();
        localWebviewModel.b = false;
      }
    }
  }
  
  public TouchWebView b()
  {
    LogFactory.a().c("WebViewPool", "-------getWebView------");
    if (this.b.size() != 0)
    {
      Object localObject = BusinessManager.a.b();
      if ((localObject != null) && (((BusinessConfig)localObject).k))
      {
        localObject = this.b.iterator();
        while (((Iterator)localObject).hasNext())
        {
          WebViewPool.WebviewModel localWebviewModel = (WebViewPool.WebviewModel)((Iterator)localObject).next();
          if (!localWebviewModel.b)
          {
            localWebviewModel.b = true;
            return localWebviewModel.a;
          }
        }
        return a(false);
      }
      if ((localObject != null) && (((BusinessConfig)localObject).l)) {
        a(((WebViewPool.WebviewModel)this.b.get(0)).a);
      }
      return ((WebViewPool.WebviewModel)this.b.get(0)).a;
    }
    return a(false);
  }
  
  public void c()
  {
    LogFactory.a().c("WebViewPool", "-------clear------");
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      WebViewPool.WebviewModel localWebviewModel = (WebViewPool.WebviewModel)localIterator.next();
      WebViewPluginEngine localWebViewPluginEngine = localWebviewModel.a.getPluginEngine();
      if (localWebViewPluginEngine != null)
      {
        localWebViewPluginEngine.a(localWebviewModel.a.getUrl(), 8589934596L, null);
        localWebViewPluginEngine.d();
      }
      localWebviewModel.a.stopLoading();
      localWebviewModel.a.loadUrlOriginal("about:blank");
      localWebviewModel.a.clearView();
      localWebviewModel.a.destroy();
    }
    this.b.clear();
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebViewPool
 * JD-Core Version:    0.7.0.1
 */
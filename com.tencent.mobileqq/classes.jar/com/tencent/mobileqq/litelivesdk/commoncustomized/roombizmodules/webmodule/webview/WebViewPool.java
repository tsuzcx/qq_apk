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
  public static WebViewPool a;
  private List<WebViewPool.WebviewModel> a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedRoombizmodulesWebmoduleWebviewWebViewPool = new WebViewPool();
  }
  
  private WebViewPool()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private TouchWebView a(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    LogFactory.a().c("WebViewPool", "-------createNewWebview------");
    WebViewPool.WebviewModel localWebviewModel = new WebViewPool.WebviewModel(this);
    localWebviewModel.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView(BaseApplicationImpl.getContext());
    LogInterface localLogInterface = LogFactory.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-------createNewWebview------totalStamp = ");
    localStringBuilder.append(System.currentTimeMillis() - l);
    localLogInterface.c("WebViewPool", localStringBuilder.toString());
    if (paramBoolean) {
      localWebviewModel.jdField_a_of_type_Boolean = false;
    } else {
      localWebviewModel.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_JavaUtilList.add(localWebviewModel);
    return localWebviewModel.jdField_a_of_type_ComTencentBizUiTouchWebView;
  }
  
  public TouchWebView a()
  {
    LogFactory.a().c("WebViewPool", "-------getWebView------");
    if (this.jdField_a_of_type_JavaUtilList.size() != 0)
    {
      if (BusinessManager.a.a().jdField_a_of_type_Boolean)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          WebViewPool.WebviewModel localWebviewModel = (WebViewPool.WebviewModel)localIterator.next();
          if (!localWebviewModel.jdField_a_of_type_Boolean)
          {
            localWebviewModel.jdField_a_of_type_Boolean = true;
            return localWebviewModel.jdField_a_of_type_ComTencentBizUiTouchWebView;
          }
        }
        return a(false);
      }
      if (BusinessManager.a.a().b) {
        a(((WebViewPool.WebviewModel)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_ComTencentBizUiTouchWebView);
      }
      return ((WebViewPool.WebviewModel)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_ComTencentBizUiTouchWebView;
    }
    return a(false);
  }
  
  public void a()
  {
    LogFactory.a().c("WebViewPool", "-------preload------");
    ThreadManager.executeOnFileThread(new WebViewPool.1(this));
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    LogFactory.a().c("WebViewPool", "-------recycle------");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      WebViewPool.WebviewModel localWebviewModel = (WebViewPool.WebviewModel)localIterator.next();
      if (localWebviewModel.jdField_a_of_type_ComTencentBizUiTouchWebView.hashCode() == paramTouchWebView.hashCode())
      {
        WebViewPluginEngine localWebViewPluginEngine = paramTouchWebView.getPluginEngine();
        if (localWebViewPluginEngine != null)
        {
          localWebViewPluginEngine.a(paramTouchWebView.getUrl(), 8589934596L, null);
          localWebViewPluginEngine.b();
        }
        localWebviewModel.jdField_a_of_type_ComTencentBizUiTouchWebView.stopLoading();
        localWebviewModel.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrlOriginal("about:blank");
        paramTouchWebView.resetForReuse();
        paramTouchWebView.onPause();
        localWebviewModel.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void b()
  {
    LogFactory.a().c("WebViewPool", "-------clear------");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      WebViewPool.WebviewModel localWebviewModel = (WebViewPool.WebviewModel)localIterator.next();
      WebViewPluginEngine localWebViewPluginEngine = localWebviewModel.jdField_a_of_type_ComTencentBizUiTouchWebView.getPluginEngine();
      if (localWebViewPluginEngine != null)
      {
        localWebViewPluginEngine.a(localWebviewModel.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl(), 8589934596L, null);
        localWebViewPluginEngine.b();
      }
      localWebviewModel.jdField_a_of_type_ComTencentBizUiTouchWebView.stopLoading();
      localWebviewModel.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrlOriginal("about:blank");
      localWebviewModel.jdField_a_of_type_ComTencentBizUiTouchWebView.clearView();
      localWebviewModel.jdField_a_of_type_ComTencentBizUiTouchWebView.destroy();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebViewPool
 * JD-Core Version:    0.7.0.1
 */
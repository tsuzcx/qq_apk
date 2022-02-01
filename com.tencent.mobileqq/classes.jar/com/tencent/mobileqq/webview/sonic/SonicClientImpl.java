package com.tencent.mobileqq.webview.sonic;

import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasBaseWebviewUtil;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;
import com.tencent.sonic.sdk.SonicSession;
import com.tencent.sonic.sdk.SonicSessionClient;
import com.tencent.sonic.sdk.SonicSessionStatistics;
import java.util.HashMap;

public class SonicClientImpl
  extends SonicSessionClient
{
  public static final String TAG = "sonicSdkImpl_SonicClientImpl";
  final SonicSession session;
  CustomWebView webView;
  
  public SonicClientImpl(SonicSession paramSonicSession)
  {
    this.session = paramSonicSession;
  }
  
  public void bindWebView(CustomWebView paramCustomWebView)
  {
    this.webView = paramCustomWebView;
    this.webView.setSonicClient(this);
  }
  
  public void clearHistory()
  {
    Object localObject1 = this.webView;
    if (localObject1 != null) {
      try
      {
        WebBackForwardList localWebBackForwardList = ((CustomWebView)localObject1).copyBackForwardList();
        Object localObject2;
        if ((localWebBackForwardList != null) && (localWebBackForwardList.getSize() > 1))
        {
          int i = localWebBackForwardList.getSize() - 1;
          localObject1 = null;
          long l = this.session.sId;
          while (i > -1)
          {
            Uri localUri = Uri.parse(localWebBackForwardList.getItemAtIndex(i).getOriginalUrl());
            localObject2 = localObject1;
            if (localUri != null)
            {
              localObject2 = localObject1;
              if (localUri.isHierarchical())
              {
                localObject2 = localUri.getQueryParameter("_sonic_id");
                if ((String.valueOf(l).equals(localObject1)) && (((String)localObject1).equals(localObject2)))
                {
                  this.webView.clearHistory();
                  return;
                }
              }
            }
            i -= 1;
            localObject1 = localObject2;
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("clearHistory error:");
        ((StringBuilder)localObject2).append(localException.getMessage());
        QLog.e("sonicSdkImpl_SonicClientImpl", 1, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public void destroy()
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool) {
      QLog.d("sonicSdkImpl_SonicClientImpl", 2, "destroy");
    }
    int j = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    if (j == 0) {
      j = -1;
    }
    Object localObject1 = this.webView;
    if (localObject1 != null)
    {
      localObject2 = ((CustomWebView)localObject1).getContext();
      localObject1 = localObject2;
      if ((localObject2 instanceof MutableContextWrapper)) {
        localObject1 = ((MutableContextWrapper)localObject2).getBaseContext();
      }
      if ((localObject1 instanceof SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter))
      {
        localObject1 = (SwiftBrowserStatistics)((SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter)localObject1).getComponentProvider().a(-2);
      }
      else
      {
        if ((localObject1 instanceof SwiftWebViewFragmentSupporter))
        {
          localObject1 = ((SwiftWebViewFragmentSupporter)localObject1).getCurrentWebViewFragment();
          if (localObject1 != null)
          {
            localObject1 = (SwiftBrowserStatistics)((WebViewFragment)localObject1).getComponentProvider().a(-2);
            break label153;
          }
        }
        localObject1 = null;
      }
      label153:
      if (localObject1 != null)
      {
        if (!((SwiftBrowserStatistics)localObject1).aH) {
          if (SwiftBrowserStatistics.aD) {
            i = 1;
          } else {
            i = 0;
          }
        }
        break label187;
      }
    }
    i = 0;
    label187:
    localObject1 = this.session.getStatistics();
    Object localObject2 = ((SonicSessionStatistics)localObject1).srcUrl;
    int k = ((SonicSessionStatistics)localObject1).finalMode;
    int m = ((SonicSessionStatistics)localObject1).originalMode;
    long l1 = ((SonicSessionStatistics)localObject1).sonicStartTime;
    long l2 = ((SonicSessionStatistics)localObject1).sonicFlowStartTime;
    long l3 = ((SonicSessionStatistics)localObject1).cacheVerifyTime;
    long l4 = ((SonicSessionStatistics)localObject1).connectionFlowStartTime;
    long l5 = ((SonicSessionStatistics)localObject1).connectionConnectTime;
    long l6 = ((SonicSessionStatistics)localObject1).connectionRespondTime;
    long l7 = ((SonicSessionStatistics)localObject1).connectionFlowFinishTime;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((SonicSessionStatistics)localObject1).isDirectAddress);
    localStringBuilder.append("");
    VasBaseWebviewUtil.doSonicSpeedReport("SonicReport", "SonicSpeed", (String)localObject2, k, m, l1, l2, l3, l4, l5, l6, l7, 0L, 0L, 0L, 0L, j, i, localStringBuilder.toString(), "");
    this.session.destroy();
    this.webView = null;
  }
  
  public SonicSession getSession()
  {
    return this.session;
  }
  
  public void loadDataWithBaseUrl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    CustomWebView localCustomWebView = this.webView;
    if (localCustomWebView != null) {
      localCustomWebView.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    }
  }
  
  public void loadDataWithBaseUrlAndHeader(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, HashMap<String, String> paramHashMap)
  {
    CustomWebView localCustomWebView = this.webView;
    if (localCustomWebView != null) {
      localCustomWebView.loadDataWithBaseURLAndHeader(paramString1, paramString2, paramString3, paramString4, paramString5, paramHashMap);
    }
  }
  
  public void loadUrl(String paramString, Bundle paramBundle)
  {
    paramBundle = this.webView;
    if (paramBundle != null)
    {
      paramBundle.setForceLoadUrl(true);
      this.webView.loadUrlOriginal(paramString);
      this.webView.setForceLoadUrl(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.sonic.SonicClientImpl
 * JD-Core Version:    0.7.0.1
 */
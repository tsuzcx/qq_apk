package com.tencent.mobileqq.webview.sonic;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtils;
import com.tencent.mobileqq.webprocess.temp.api.IWebviewApi;
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
    if (this.webView != null) {}
    try
    {
      WebBackForwardList localWebBackForwardList = this.webView.copyBackForwardList();
      int i;
      Object localObject1;
      long l;
      if ((localWebBackForwardList != null) && (localWebBackForwardList.getSize() > 1))
      {
        i = localWebBackForwardList.getSize();
        localObject1 = null;
        l = this.session.sId;
        i -= 1;
      }
      for (;;)
      {
        if (i > -1)
        {
          localObject2 = Uri.parse(localWebBackForwardList.getItemAtIndex(i).getOriginalUrl());
          if ((localObject2 != null) && (((Uri)localObject2).isHierarchical()))
          {
            String str = ((Uri)localObject2).getQueryParameter("_sonic_id");
            localObject2 = str;
            if (!String.valueOf(l).equals(localObject1)) {
              break label134;
            }
            localObject2 = str;
            if (!localObject1.equals(str)) {
              break label134;
            }
            this.webView.clearHistory();
          }
        }
        else
        {
          return;
        }
        Object localObject2 = localObject1;
        label134:
        i -= 1;
        localObject1 = localObject2;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("sonicSdkImpl_SonicClientImpl", 1, "clearHistory error:" + localException.getMessage());
    }
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("sonicSdkImpl_SonicClientImpl", 2, "destroy");
    }
    int j = NetworkUtil.a(BaseApplication.getContext());
    int i = j;
    if (j == 0) {
      i = -1;
    }
    j = 0;
    Object localObject;
    if (this.webView != null)
    {
      localObject = this.webView.getContext();
      if (!(localObject instanceof MutableContextWrapper)) {
        break label174;
      }
      localObject = ((MutableContextWrapper)localObject).getBaseContext();
    }
    label174:
    for (;;)
    {
      j = ((IWebviewApi)QRoute.api(IWebviewApi.class)).getWebViewPreloadMode((Context)localObject);
      localObject = this.session.getStatistics();
      VasWebviewUtils.a("SonicReport", "SonicSpeed", ((SonicSessionStatistics)localObject).srcUrl, ((SonicSessionStatistics)localObject).finalMode, ((SonicSessionStatistics)localObject).originalMode, ((SonicSessionStatistics)localObject).sonicStartTime, ((SonicSessionStatistics)localObject).sonicFlowStartTime, ((SonicSessionStatistics)localObject).cacheVerifyTime, ((SonicSessionStatistics)localObject).connectionFlowStartTime, ((SonicSessionStatistics)localObject).connectionConnectTime, ((SonicSessionStatistics)localObject).connectionRespondTime, ((SonicSessionStatistics)localObject).connectionFlowFinishTime, 0L, 0L, 0L, 0L, i, j, ((SonicSessionStatistics)localObject).isDirectAddress + "", "");
      this.session.destroy();
      this.webView = null;
      return;
    }
  }
  
  public SonicSession getSession()
  {
    return this.session;
  }
  
  public void loadDataWithBaseUrl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (this.webView != null) {
      this.webView.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    }
  }
  
  public void loadDataWithBaseUrlAndHeader(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, HashMap<String, String> paramHashMap)
  {
    if (this.webView != null) {
      this.webView.loadDataWithBaseURLAndHeader(paramString1, paramString2, paramString3, paramString4, paramString5, paramHashMap);
    }
  }
  
  public void loadUrl(String paramString, Bundle paramBundle)
  {
    if (this.webView != null)
    {
      this.webView.setForceLoadUrl(true);
      this.webView.loadUrlOriginal(paramString);
      this.webView.setForceLoadUrl(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.sonic.SonicClientImpl
 * JD-Core Version:    0.7.0.1
 */
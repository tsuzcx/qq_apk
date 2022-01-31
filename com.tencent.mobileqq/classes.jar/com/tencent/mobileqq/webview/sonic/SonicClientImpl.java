package com.tencent.mobileqq.webview.sonic;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import bdin;
import begc;
import beho;
import behu;
import beiy;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
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
    int i = bdin.a(BaseApplication.getContext());
    int j = i;
    if (i == 0) {
      j = -1;
    }
    int k = 0;
    i = k;
    Object localObject;
    if (this.webView != null)
    {
      Context localContext = this.webView.getContext();
      localObject = localContext;
      if ((localContext instanceof MutableContextWrapper)) {
        localObject = ((MutableContextWrapper)localContext).getBaseContext();
      }
      if (!(localObject instanceof behu)) {
        break label226;
      }
      localObject = (beiy)((behu)localObject).b().a(-2);
    }
    for (;;)
    {
      i = k;
      if (localObject != null)
      {
        if (!((beiy)localObject).w) {
          break label269;
        }
        i = 2;
      }
      for (;;)
      {
        localObject = this.session.getStatistics();
        VasWebviewUtil.doSonicSpeedReport("SonicReport", "SonicSpeed", ((SonicSessionStatistics)localObject).srcUrl, ((SonicSessionStatistics)localObject).finalMode, ((SonicSessionStatistics)localObject).originalMode, ((SonicSessionStatistics)localObject).sonicStartTime, ((SonicSessionStatistics)localObject).sonicFlowStartTime, ((SonicSessionStatistics)localObject).cacheVerifyTime, ((SonicSessionStatistics)localObject).connectionFlowStartTime, ((SonicSessionStatistics)localObject).connectionConnectTime, ((SonicSessionStatistics)localObject).connectionRespondTime, ((SonicSessionStatistics)localObject).connectionFlowFinishTime, 0L, 0L, 0L, 0L, j, i, ((SonicSessionStatistics)localObject).isDirectAddress + "", "");
        this.session.destroy();
        this.webView = null;
        return;
        label226:
        if (!(localObject instanceof begc)) {
          break label285;
        }
        localObject = ((begc)localObject).b();
        if (localObject == null) {
          break label285;
        }
        localObject = (beiy)((WebViewFragment)localObject).b().a(-2);
        break;
        label269:
        if (beiy.s) {
          i = 1;
        } else {
          i = 0;
        }
      }
      label285:
      localObject = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.sonic.SonicClientImpl
 * JD-Core Version:    0.7.0.1
 */
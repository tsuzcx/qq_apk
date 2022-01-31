package com.tencent.mobileqq.webview.sonic;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
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
  CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView;
  final SonicSession jdField_a_of_type_ComTencentSonicSdkSonicSession;
  
  public SonicClientImpl(SonicSession paramSonicSession)
  {
    this.jdField_a_of_type_ComTencentSonicSdkSonicSession = paramSonicSession;
  }
  
  public SonicSession a()
  {
    return this.jdField_a_of_type_ComTencentSonicSdkSonicSession;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("sonicSdkImpl_SonicClientImpl", 2, "destroy");
    }
    int i = NetworkUtil.a(BaseApplication.getContext());
    int j = i;
    if (i == 0) {
      j = -1;
    }
    int k = 0;
    i = k;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null)
    {
      Context localContext = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getContext();
      localObject = localContext;
      if ((localContext instanceof MutableContextWrapper)) {
        localObject = ((MutableContextWrapper)localContext).getBaseContext();
      }
      if (!(localObject instanceof SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter)) {
        break label226;
      }
      localObject = (SwiftBrowserStatistics)((SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter)localObject).b().a(-2);
    }
    for (;;)
    {
      i = k;
      if (localObject != null)
      {
        if (!((SwiftBrowserStatistics)localObject).s) {
          break label269;
        }
        i = 2;
      }
      for (;;)
      {
        localObject = this.jdField_a_of_type_ComTencentSonicSdkSonicSession.getStatistics();
        VasWebviewUtil.doSonicSpeedReport("SonicReport", "SonicSpeed", ((SonicSessionStatistics)localObject).srcUrl, ((SonicSessionStatistics)localObject).finalMode, ((SonicSessionStatistics)localObject).originalMode, ((SonicSessionStatistics)localObject).sonicStartTime, ((SonicSessionStatistics)localObject).sonicFlowStartTime, ((SonicSessionStatistics)localObject).cacheVerifyTime, ((SonicSessionStatistics)localObject).connectionFlowStartTime, ((SonicSessionStatistics)localObject).connectionConnectTime, ((SonicSessionStatistics)localObject).connectionRespondTime, ((SonicSessionStatistics)localObject).connectionFlowFinishTime, 0L, 0L, 0L, 0L, j, i, ((SonicSessionStatistics)localObject).isDirectAddress + "", "");
        this.jdField_a_of_type_ComTencentSonicSdkSonicSession.destroy();
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
        return;
        label226:
        if (!(localObject instanceof SwiftWebViewFragmentSupporter)) {
          break label285;
        }
        localObject = ((SwiftWebViewFragmentSupporter)localObject).b();
        if (localObject == null) {
          break label285;
        }
        localObject = (SwiftBrowserStatistics)((WebViewFragment)localObject).b().a(-2);
        break;
        label269:
        if (SwiftBrowserStatistics.o) {
          i = 1;
        } else {
          i = 0;
        }
      }
      label285:
      localObject = null;
    }
  }
  
  public void a(CustomWebView paramCustomWebView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.setSonicClient(this);
  }
  
  public void clearHistory()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {}
    try
    {
      WebBackForwardList localWebBackForwardList = this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.copyBackForwardList();
      int i;
      Object localObject1;
      long l;
      if ((localWebBackForwardList != null) && (localWebBackForwardList.getSize() > 1))
      {
        i = localWebBackForwardList.getSize();
        localObject1 = null;
        l = this.jdField_a_of_type_ComTencentSonicSdkSonicSession.sId;
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
            this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.clearHistory();
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
  
  public void loadDataWithBaseUrl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    }
  }
  
  public void loadDataWithBaseUrlAndHeader(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, HashMap paramHashMap)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramHashMap);
    }
  }
  
  public void loadUrl(String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.webview.sonic.SonicClientImpl
 * JD-Core Version:    0.7.0.1
 */
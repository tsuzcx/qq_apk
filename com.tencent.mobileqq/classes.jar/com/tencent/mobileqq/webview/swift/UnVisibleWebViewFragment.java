package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.WebViewWrapperForDoc;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;

public class UnVisibleWebViewFragment
  extends WebViewFragment
{
  private WebViewWrapperForDoc a;
  
  public static WebViewFragment a(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    paramIntent = new UnVisibleWebViewFragment();
    paramIntent.setArguments(localBundle);
    return paramIntent;
  }
  
  private void a(String paramString)
  {
    CookieManager localCookieManager = CookieManager.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preloading_id=");
    localStringBuilder.append(TeamWorkHandlerUtils.a(paramString));
    localCookieManager.setCookie(".docs.qq.com", localStringBuilder.toString());
    CookieSyncManager.createInstance(BaseApplicationImpl.getApplication());
    CookieSyncManager.getInstance().sync();
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onDestroy");
    }
    Object localObject = getStatistics();
    this.isDestroyed = true;
    ((SwiftBrowserStatistics)localObject).av = true;
    localObject = this.a;
    if (localObject != null)
    {
      ((WebViewWrapperForDoc)localObject).b();
      this.a = null;
      this.webView = null;
    }
    this.mApp = null;
  }
  
  public WebViewWrapper createWebViewWrapper(boolean paramBoolean)
  {
    WebViewWrapperForDoc localWebViewWrapperForDoc = new WebViewWrapperForDoc(getAppRuntime(), super.getActivity(), getWebViewKernelCallBack(), this.intent, paramBoolean);
    this.a = localWebViewWrapperForDoc;
    return localWebViewWrapperForDoc;
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new UnVisibleWebViewFragment.1(this, this.webViewSurface);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater.setVisibility(8);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.UnVisibleWebViewFragment
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy.EventCallback;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.NetworkTimeoutInfo;

@ProxyService(proxy=SpecialProxy.class)
public class SpecialProxyImpl
  implements SpecialProxy
{
  private void a(Bundle paramBundle, SpecialProxy.EventCallback paramEventCallback)
  {
    if (paramBundle == null)
    {
      if (paramEventCallback != null) {
        paramEventCallback.onResult(false, null);
      }
      return;
    }
    paramBundle.setClassLoader(MiniAppInfo.class.getClassLoader());
    paramBundle = MiniSdkUtil.a((MiniAppInfo)paramBundle.getParcelable("mini_appinfo"));
    if (paramBundle == null)
    {
      if (paramEventCallback != null) {
        paramEventCallback.onResult(false, null);
      }
      return;
    }
    MiniAppUtils.notityPullDownEntryInMainProcess(paramBundle);
    if (paramEventCallback != null) {
      paramEventCallback.onResult(true, null);
    }
  }
  
  private void b(Bundle paramBundle, SpecialProxy.EventCallback paramEventCallback)
  {
    if (paramBundle == null)
    {
      if (paramEventCallback != null) {
        paramEventCallback.onResult(false, null);
      }
      return;
    }
    paramBundle.setClassLoader(MiniAppInfo.class.getClassLoader());
    paramBundle = (NetworkTimeoutInfo)paramBundle.getParcelable("NetworkTimeOutInfo");
    if (paramBundle == null)
    {
      if (paramEventCallback != null) {
        paramEventCallback.onResult(false, null);
      }
      return;
    }
    paramEventCallback = new StringBuilder();
    paramEventCallback.append("Specialproxy onInitNetworkInfo :");
    paramEventCallback.append(paramBundle.toString());
    QLog.e("SpecialProxyImpl", 1, paramEventCallback.toString());
    MiniOkHttpClientFactory.init(paramBundle.request, paramBundle.uploadFile, paramBundle.downloadFile);
  }
  
  public boolean sendEventToHost(int paramInt, Bundle paramBundle, SpecialProxy.EventCallback paramEventCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("receive event from minisdk, event:");
    localStringBuilder.append(paramInt);
    QLog.i("SpecialProxyImpl", 1, localStringBuilder.toString());
    if (1 == paramInt) {}
    try
    {
      a(paramBundle, paramEventCallback);
      return true;
    }
    catch (Throwable paramBundle)
    {
      label61:
      break label61;
    }
    if (2 == paramInt)
    {
      b(paramBundle, paramEventCallback);
      return true;
      QLog.e("SpecialProxyImpl", 1, "exception when receive event from minisdk", paramBundle);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.SpecialProxyImpl
 * JD-Core Version:    0.7.0.1
 */
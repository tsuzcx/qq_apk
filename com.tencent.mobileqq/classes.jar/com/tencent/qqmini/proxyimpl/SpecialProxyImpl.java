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
    if (paramBundle == null) {
      if (paramEventCallback != null) {
        paramEventCallback.onResult(false, null);
      }
    }
    do
    {
      do
      {
        return;
        paramBundle.setClassLoader(MiniAppInfo.class.getClassLoader());
        paramBundle = MiniSdkUtil.a((MiniAppInfo)paramBundle.getParcelable("mini_appinfo"));
        if (paramBundle != null) {
          break;
        }
      } while (paramEventCallback == null);
      paramEventCallback.onResult(false, null);
      return;
      MiniAppUtils.notityPullDownEntryInMainProcess(paramBundle);
    } while (paramEventCallback == null);
    paramEventCallback.onResult(true, null);
  }
  
  private void b(Bundle paramBundle, SpecialProxy.EventCallback paramEventCallback)
  {
    if (paramBundle == null) {
      if (paramEventCallback != null) {
        paramEventCallback.onResult(false, null);
      }
    }
    do
    {
      return;
      paramBundle.setClassLoader(MiniAppInfo.class.getClassLoader());
      paramBundle = (NetworkTimeoutInfo)paramBundle.getParcelable("NetworkTimeOutInfo");
      if (paramBundle != null) {
        break;
      }
    } while (paramEventCallback == null);
    paramEventCallback.onResult(false, null);
    return;
    QLog.e("SpecialProxyImpl", 1, "Specialproxy onInitNetworkInfo :" + paramBundle.toString());
    MiniOkHttpClientFactory.init(paramBundle.request, paramBundle.uploadFile, paramBundle.downloadFile);
  }
  
  public boolean sendEventToHost(int paramInt, Bundle paramBundle, SpecialProxy.EventCallback paramEventCallback)
  {
    QLog.i("SpecialProxyImpl", 1, "receive event from minisdk, event:" + paramInt);
    if (1 == paramInt) {}
    try
    {
      a(paramBundle, paramEventCallback);
      return true;
    }
    catch (Throwable paramBundle)
    {
      QLog.e("SpecialProxyImpl", 1, "exception when receive event from minisdk", paramBundle);
    }
    if (2 == paramInt)
    {
      b(paramBundle, paramEventCallback);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.SpecialProxyImpl
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.thumbplayer.datatransport;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy;
import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy.IPreloadListener;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.ArrayList;

public class TPPreloadProxyImpl
  implements ITPPreloadProxy
{
  private static final int LOD_P2P_TIMES = 3;
  private static final String TAG = "TPPreloadProxyImpl";
  private boolean loadProxySucc = false;
  private Context mContext;
  private ITPDownloadProxy mDownloadProxy;
  private TPPreloadProxyImpl.InnerProxyListener mInnerProxyListener = new TPPreloadProxyImpl.InnerProxyListener(this, null);
  private ITPPreloadProxy.IPreloadListener mPreloadListener = new TPPlayProxyListenerEmptyImpl("TPPreloadProxyImpl");
  private int mServiceType;
  
  public TPPreloadProxyImpl(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mServiceType = paramInt;
    initProxy();
  }
  
  private void initProxy()
  {
    int i = 3;
    while ((i > 0) && (!this.loadProxySucc))
    {
      int j = i;
      try
      {
        ITPProxyManagerAdapter localITPProxyManagerAdapter = TPProxyGlobalManager.getInstance().getPlayerProxy(this.mServiceType);
        if (localITPProxyManagerAdapter != null)
        {
          j = i;
          if (localITPProxyManagerAdapter.getDownloadProxy() != null)
          {
            j = i;
            this.mDownloadProxy = localITPProxyManagerAdapter.getDownloadProxy();
            j = i;
            this.mDownloadProxy.setLogListener(this.mInnerProxyListener);
            j = i;
            this.mDownloadProxy.setUserData("qq_is_vip", Boolean.valueOf(TPPlayerConfig.isUserIsVip()));
            j = i;
            if (!TextUtils.isEmpty(TPPlayerConfig.getUserUin()))
            {
              j = i;
              this.mDownloadProxy.setUserData("user_uin", TPPlayerConfig.getUserUin());
            }
            j = i;
            if (!TextUtils.isEmpty(TPPlayerConfig.getAppVersionName(this.mContext)))
            {
              j = i;
              this.mDownloadProxy.setUserData("app_version_name", TPPlayerConfig.getAppVersionName(this.mContext));
            }
            j = i;
            if (TPPlayerConfig.getBuildNumber(this.mContext) != -1L)
            {
              j = i;
              this.mDownloadProxy.setUserData("app_version_code", String.valueOf(TPPlayerConfig.getBuildNumber(this.mContext)));
            }
            j = i;
            this.mDownloadProxy.setUserData("carrier_pesudo_code", TPPlayerConfig.getUserUpc());
            j = i;
            this.mDownloadProxy.setUserData("carrier_pesudo_state", Integer.valueOf(TPPlayerConfig.getUserUpcState()));
            j = i;
            this.mDownloadProxy.setUserData("external_network_ip", TPPlayerConfig.getOutNetIp());
            j = i;
            this.loadProxySucc = true;
            return;
          }
        }
        i -= 1;
        j = i;
        TPLogUtil.e("TPPreloadProxyImpl", "p2p so load failed");
      }
      catch (Exception localException)
      {
        i = j - 1;
        TPLogUtil.e("TPPreloadProxyImpl", localException);
      }
    }
  }
  
  public String getPlayErrorCodeStr(int paramInt)
  {
    return null;
  }
  
  public boolean isAvailable()
  {
    return (this.mDownloadProxy != null) && (this.loadProxySucc);
  }
  
  public void pushEvent(int paramInt)
  {
    if (!isAvailable()) {
      return;
    }
    try
    {
      this.mDownloadProxy.pushEvent(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPPreloadProxyImpl", localThrowable);
    }
  }
  
  public void setPreloadListener(ITPPreloadProxy.IPreloadListener paramIPreloadListener)
  {
    if (paramIPreloadListener == null)
    {
      this.mPreloadListener = new TPPlayProxyListenerEmptyImpl("TPPreloadProxyImpl");
      return;
    }
    this.mPreloadListener = paramIPreloadListener;
  }
  
  public int startClipPreload(String paramString, ArrayList<TPDownloadParamData> paramArrayList)
  {
    return 0;
  }
  
  public int startPreload(String paramString, TPDownloadParamData paramTPDownloadParamData, ITPPreloadProxy.IPreloadListener paramIPreloadListener)
  {
    if (!isAvailable())
    {
      initProxy();
      if (isAvailable()) {}
    }
    while (paramTPDownloadParamData == null) {
      return -1;
    }
    paramTPDownloadParamData = TPProxyUtils.convertProxyDownloadParams(null, paramTPDownloadParamData);
    try
    {
      int i = this.mDownloadProxy.startPreload(paramString, paramTPDownloadParamData, new TPPreloadProxyImpl.1(this, paramIPreloadListener));
      return i;
    }
    catch (Throwable paramString)
    {
      TPLogUtil.e("TPPreloadProxyImpl", paramString);
    }
    return -1;
  }
  
  public void stopPreload(int paramInt)
  {
    if (this.mDownloadProxy == null) {
      return;
    }
    try
    {
      this.mDownloadProxy.stopPreload(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPPreloadProxyImpl", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.TPPreloadProxyImpl
 * JD-Core Version:    0.7.0.1
 */
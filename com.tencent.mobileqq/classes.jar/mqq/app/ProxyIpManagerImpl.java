package mqq.app;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.serverconfig.ProxyIpChannel;
import com.tencent.msf.service.protocol.serverconfig.ProxyIpInfo;
import com.tencent.msf.service.protocol.serverconfig.ProxyIpList;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.ProxyIpManager;
import mqq.manager.ProxyIpManager.ProxyIp;

public class ProxyIpManagerImpl
  implements ProxyIpManager
{
  private static final int MSG_NOTIFY_PROXY_IP_CHANGED = 10000;
  private static final String SP_KEY_PROXYIP = "_key_proxyip_";
  private static final String TAG = "ProxyIpManagerImpl";
  private final AppRuntime mApp;
  private Handler mHandler = new ProxyIpManagerImpl.1(this, Looper.getMainLooper());
  private MsfStore mMsfStore;
  private ArrayList<ProxyIpList> mProxyIpCache;
  
  public ProxyIpManagerImpl(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.mMsfStore = new MsfStore();
    this.mMsfStore.init(BaseApplication.getContext());
    reloadCache(this.mApp.getAccount(), true);
  }
  
  public List<ProxyIpManager.ProxyIp> getProxyIp(int paramInt)
  {
    if (!isMobileNetWork(this.mApp.getApplication()))
    {
      QLog.d("ProxyIpManagerImpl", 1, "Load local proxy ip failed, uin:" + MsfSdkUtils.getShortUin(this.mApp.getAccount()) + " type: " + paramInt + " reason: not mobile network!");
      return null;
    }
    if ((this.mProxyIpCache != null) && (this.mProxyIpCache.size() > 0))
    {
      Object localObject1 = this.mProxyIpCache.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ProxyIpList)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((ProxyIpList)localObject2).uService_type == paramInt))
        {
          if ((((ProxyIpList)localObject2).vIplist != null) && (((ProxyIpList)localObject2).vIplist.size() > 0))
          {
            localObject1 = new ArrayList();
            localObject2 = ((ProxyIpList)localObject2).vIplist.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              ProxyIpInfo localProxyIpInfo = (ProxyIpInfo)((Iterator)localObject2).next();
              ProxyIpManager.ProxyIp localProxyIp = new ProxyIpManager.ProxyIp();
              localProxyIp.type = localProxyIpInfo.uType;
              localProxyIp.ip = StringUtils.getIpAddrFromInt(localProxyIpInfo.uIp);
              localProxyIp.port = localProxyIpInfo.uPort;
              ((ArrayList)localObject1).add(localProxyIp);
            }
            QLog.d("ProxyIpManagerImpl", 1, "Load local proxy ip succ, uin: " + MsfSdkUtils.getShortUin(this.mApp.getAccount()) + " type: " + paramInt + " iplist: " + ((ArrayList)localObject1).toString());
            return localObject1;
          }
          QLog.d("ProxyIpManagerImpl", 1, "Load local proxy ip failed, uin: " + MsfSdkUtils.getShortUin(this.mApp.getAccount()) + " type: " + paramInt + " reason: ip list is null!");
          return null;
        }
      }
    }
    QLog.d("ProxyIpManagerImpl", 1, "Load local proxy ip failed, uin: " + MsfSdkUtils.getShortUin(this.mApp.getAccount()) + " type: " + paramInt + " reason: ip cache is null!");
    return null;
  }
  
  public boolean isMobileNetWork(Context paramContext)
  {
    try
    {
      boolean bool = isMobileNetworkInfo(((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo());
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public boolean isMobileNetworkInfo(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {}
    while ((paramNetworkInfo.getType() != 0) && (50 != paramNetworkInfo.getType())) {
      return false;
    }
    return true;
  }
  
  public void onDestroy() {}
  
  public void reloadCache(String paramString, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(this.mApp.getAccount())))
    {
      QLog.d("ProxyIpManagerImpl", 1, "Load local proxy ip failed: uin is mismatch with app account");
      return;
    }
    Object localObject = "_key_proxyip_" + this.mApp.getAccount();
    for (;;)
    {
      try
      {
        MsfStore.getNativeConfigStore().loadConfig(this.mApp.getApplication(), false);
        localObject = MsfStore.getNativeConfigStore().getConfig((String)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        localObject = new JceInputStream(HexUtil.hexStr2Bytes((String)localObject));
        ProxyIpChannel localProxyIpChannel = new ProxyIpChannel();
        localProxyIpChannel.readFrom((JceInputStream)localObject);
        if ((localProxyIpChannel == null) || (localProxyIpChannel.vProxy_iplists == null) || (localProxyIpChannel.vProxy_iplists.size() <= 0)) {
          continue;
        }
        this.mProxyIpCache = localProxyIpChannel.vProxy_iplists;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        QLog.d("ProxyIpManagerImpl", 1, "Load local proxy ip failed, uin: " + MsfSdkUtils.getShortUin(paramString) + " " + localThrowable.getMessage());
        continue;
        this.mProxyIpCache = null;
        QLog.d("ProxyIpManagerImpl", 1, "Load local proxy ip failed, uin: " + MsfSdkUtils.getShortUin(paramString) + " config is empty");
        continue;
      }
      this.mHandler.sendEmptyMessageDelayed(10000, 100L);
      return;
      QLog.d("ProxyIpManagerImpl", 1, "Load local proxy ip failed, uin: " + MsfSdkUtils.getShortUin(paramString) + " Parsed proxy ip is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.ProxyIpManagerImpl
 * JD-Core Version:    0.7.0.1
 */
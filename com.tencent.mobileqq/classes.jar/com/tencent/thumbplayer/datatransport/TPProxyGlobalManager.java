package com.tencent.thumbplayer.datatransport;

import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import com.tencent.thumbplayer.utils.TPGlobalEventNofication;
import com.tencent.thumbplayer.utils.TPGlobalEventNofication.OnGlobalEventChangeListener;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor.OnNetStatusChangeListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class TPProxyGlobalManager
  implements TPGlobalEventNofication.OnGlobalEventChangeListener, TPNetworkChangeMonitor.OnNetStatusChangeListener
{
  private static final String TAG = "TPProxyGlobalManager";
  private int mAppBackOrFront = 0;
  private HashMap<Integer, ITPProxyManagerAdapter> mServiceTypeDownloadProxyMap;
  private String mUpc = "";
  private int mUpcState = 0;
  
  private TPProxyGlobalManager()
  {
    if (this.mServiceTypeDownloadProxyMap == null) {
      this.mServiceTypeDownloadProxyMap = new HashMap();
    }
    TPGlobalEventNofication.addEventListener(this);
    TPNetworkChangeMonitor.getInstance().addOnNetStatusChangeListener(this);
  }
  
  public static TPProxyGlobalManager getInstance()
  {
    return TPProxyGlobalManager.InstanceHolder.access$100();
  }
  
  private void pushAllProxyManagerEvent(int paramInt)
  {
    Iterator localIterator = this.mServiceTypeDownloadProxyMap.values().iterator();
    while (localIterator.hasNext()) {
      ((ITPProxyManagerAdapter)localIterator.next()).pushEvent(paramInt);
    }
  }
  
  private void pushAllProxyManagerUpcChanged(String paramString, int paramInt)
  {
    this.mUpc = paramString;
    this.mUpcState = paramInt;
    Iterator localIterator = this.mServiceTypeDownloadProxyMap.values().iterator();
    while (localIterator.hasNext())
    {
      ITPProxyManagerAdapter localITPProxyManagerAdapter = (ITPProxyManagerAdapter)localIterator.next();
      localITPProxyManagerAdapter.getDownloadProxy().setUserData("carrier_pesudo_code", paramString);
      localITPProxyManagerAdapter.getDownloadProxy().setUserData("carrier_pesudo_state", Integer.valueOf(paramInt));
    }
  }
  
  public ITPProxyManagerAdapter getPlayerProxy(int paramInt)
  {
    if (paramInt < 0) {}
    ITPDownloadProxy localITPDownloadProxy;
    do
    {
      return null;
      if (this.mServiceTypeDownloadProxyMap.containsKey(Integer.valueOf(paramInt))) {
        return (ITPProxyManagerAdapter)this.mServiceTypeDownloadProxyMap.get(Integer.valueOf(paramInt));
      }
      localITPDownloadProxy = TPDownloadProxyFactory.getTPDownloadProxy(paramInt);
    } while (localITPDownloadProxy == null);
    try
    {
      if (localITPDownloadProxy.init(TPPlayerMgr.getAppContext(), TPProxyUtils.getProxyInitParam(TPPlayerMgr.getAppContext(), paramInt)) < 0)
      {
        TPLogUtil.i("TPProxyGlobalManager", "downloadProxy init failed with status:" + localITPDownloadProxy);
        return null;
      }
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.i("TPProxyGlobalManager", "init proxy failed:" + localThrowable);
      return null;
    }
    localThrowable.setLogListener(new TPProxyGlobalManager.1(this));
    int i = TPNetworkChangeMonitor.getNetworkStatus();
    if (i == 1)
    {
      localThrowable.pushEvent(1);
      localThrowable.pushEvent(10);
    }
    for (;;)
    {
      localThrowable.pushEvent(this.mAppBackOrFront);
      localThrowable.setUserData("carrier_pesudo_code", this.mUpc);
      localThrowable.setUserData("carrier_pesudo_state", Integer.valueOf(this.mUpcState));
      TPProxyManagerAdapterImpl localTPProxyManagerAdapterImpl = new TPProxyManagerAdapterImpl(localThrowable);
      this.mServiceTypeDownloadProxyMap.put(Integer.valueOf(paramInt), localTPProxyManagerAdapterImpl);
      return localTPProxyManagerAdapterImpl;
      if (i == 2)
      {
        localTPProxyManagerAdapterImpl.pushEvent(2);
        localTPProxyManagerAdapterImpl.pushEvent(9);
      }
      else if (i == 3)
      {
        localTPProxyManagerAdapterImpl.pushEvent(2);
        localTPProxyManagerAdapterImpl.pushEvent(10);
      }
    }
  }
  
  public void onEvent(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    TPLogUtil.i("TPProxyGlobalManager", "onEvent eventId: " + paramInt1 + ", arg1: " + paramInt2 + ", arg2: " + paramInt3 + ", object" + paramObject);
    switch (paramInt1)
    {
    default: 
      return;
    case 100001: 
      this.mAppBackOrFront = 13;
      pushAllProxyManagerEvent(13);
      return;
    case 100002: 
      this.mAppBackOrFront = 14;
      pushAllProxyManagerEvent(14);
      return;
    }
    pushAllProxyManagerUpcChanged((String)paramObject, paramInt2);
  }
  
  public void onStatusChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 == 1)
    {
      pushAllProxyManagerEvent(1);
      pushAllProxyManagerEvent(10);
    }
    do
    {
      return;
      if (paramInt2 == 2)
      {
        pushAllProxyManagerEvent(2);
        pushAllProxyManagerEvent(9);
        return;
      }
    } while (paramInt2 != 3);
    pushAllProxyManagerEvent(2);
    pushAllProxyManagerEvent(10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.TPProxyGlobalManager
 * JD-Core Version:    0.7.0.1
 */
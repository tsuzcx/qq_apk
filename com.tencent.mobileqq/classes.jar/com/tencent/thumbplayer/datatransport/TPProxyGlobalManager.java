package com.tencent.thumbplayer.datatransport;

import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager;
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
    if (paramInt < 0) {
      return null;
    }
    if (this.mServiceTypeDownloadProxyMap.containsKey(Integer.valueOf(paramInt))) {
      return (ITPProxyManagerAdapter)this.mServiceTypeDownloadProxyMap.get(Integer.valueOf(paramInt));
    }
    Object localObject = TPDownloadProxyFactory.getTPDownloadProxy(paramInt);
    if (localObject != null) {
      try
      {
        if (((ITPDownloadProxy)localObject).init(TPPlayerMgr.getAppContext(), TPProxyUtils.getProxyInitParam(TPPlayerMgr.getAppContext(), paramInt)) < 0)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("downloadProxy init failed with status:");
          localStringBuilder.append(localObject);
          TPLogUtil.i("TPProxyGlobalManager", localStringBuilder.toString());
          return null;
        }
        ((ITPDownloadProxy)localObject).setLogListener(new TPProxyGlobalManager.1(this));
        int i = TPNetworkChangeMonitor.getNetworkStatus();
        if (i == 1)
        {
          ((ITPDownloadProxy)localObject).pushEvent(1);
          ((ITPDownloadProxy)localObject).pushEvent(10);
        }
        else if (i == 2)
        {
          ((ITPDownloadProxy)localObject).pushEvent(2);
          ((ITPDownloadProxy)localObject).pushEvent(9);
        }
        else if (i == 3)
        {
          ((ITPDownloadProxy)localObject).pushEvent(2);
          ((ITPDownloadProxy)localObject).pushEvent(10);
        }
        ((ITPDownloadProxy)localObject).pushEvent(this.mAppBackOrFront);
        ((ITPDownloadProxy)localObject).setUserData("carrier_pesudo_code", this.mUpc);
        ((ITPDownloadProxy)localObject).setUserData("carrier_pesudo_state", Integer.valueOf(this.mUpcState));
        localObject = new TPProxyManagerAdapterImpl((ITPDownloadProxy)localObject);
        this.mServiceTypeDownloadProxyMap.put(Integer.valueOf(paramInt), localObject);
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("init proxy failed:");
        localStringBuilder.append(localThrowable);
        TPLogUtil.i("TPProxyGlobalManager", localStringBuilder.toString());
      }
    }
    return null;
  }
  
  public void onEvent(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEvent eventId: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", arg1: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", arg2: ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(", object");
    localStringBuilder.append(paramObject);
    TPLogUtil.i("TPProxyGlobalManager", localStringBuilder.toString());
    switch (paramInt1)
    {
    default: 
      return;
    case 100003: 
      pushAllProxyManagerUpcChanged((String)paramObject, paramInt2);
      return;
    case 100002: 
      this.mAppBackOrFront = 14;
      pushAllProxyManagerEvent(14);
      return;
    }
    this.mAppBackOrFront = 13;
    pushAllProxyManagerEvent(13);
  }
  
  public void onStatusChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 == 1)
    {
      pushAllProxyManagerEvent(1);
      pushAllProxyManagerEvent(10);
      return;
    }
    if (paramInt2 == 2)
    {
      pushAllProxyManagerEvent(2);
      pushAllProxyManagerEvent(9);
      return;
    }
    if (paramInt2 == 3)
    {
      pushAllProxyManagerEvent(2);
      pushAllProxyManagerEvent(10);
    }
  }
  
  public void setUpdatePlayerInfoInterval(int paramInt)
  {
    TPListenerManager.getInstance().setUpdatePlayerInfoInterval(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.TPProxyGlobalManager
 * JD-Core Version:    0.7.0.1
 */
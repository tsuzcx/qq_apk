package com.tencent.mobileqq.onlinestatus.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.AutoReplyManagerImpl;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.AutoStatusManager;
import com.tencent.mobileqq.onlinestatus.manager.IAutoReplyManager;
import com.tencent.mobileqq.onlinestatus.manager.IAutoStatusManager;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineMusicStatusManager;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.manager.IStatusManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineMusicStatusManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class OnlineStatusManagerServiceImpl
  implements IOnlineStatusManagerService
{
  private HashMap<String, IStatusManager> mMgrMaps = new HashMap(4, 0.75F);
  
  public <T extends IStatusManager> T getManager(Class<T> paramClass)
  {
    return (IStatusManager)this.mMgrMaps.get(paramClass.getName());
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime.isLogin())
    {
      HashMap localHashMap = this.mMgrMaps;
      String str = IOnlineStatusDataManager.class.getName();
      paramAppRuntime = (AppInterface)paramAppRuntime;
      localHashMap.put(str, new OnlineStatusDataManager(paramAppRuntime));
      this.mMgrMaps.put(IAutoStatusManager.class.getName(), new AutoStatusManager(paramAppRuntime));
      this.mMgrMaps.put(IOnlineMusicStatusManager.class.getName(), new OnlineMusicStatusManager(paramAppRuntime));
      this.mMgrMaps.put(IOnlineStatusPermissionManager.class.getName(), new OnlineStatusPermissionManager(paramAppRuntime));
      this.mMgrMaps.put(IAutoReplyManager.class.getName(), new AutoReplyManagerImpl(paramAppRuntime));
    }
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.mMgrMaps.values().iterator();
    while (localIterator.hasNext()) {
      ((IStatusManager)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.api.impl.OnlineStatusManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */
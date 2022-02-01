package com.tencent.mobileqq.friend.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.friend.api.IFriendExtensionService;
import com.tencent.mobileqq.friend.cache.ExtensionInfoCache;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class FriendExtensionServiceImpl
  implements IFriendExtensionService
{
  private static final String TAG = "FriendExtensionServiceImpl";
  private EntityManager mEntityManager;
  private ExtensionInfoCache mExtensionCache;
  
  public static FriendExtensionServiceImpl getService(AppRuntime paramAppRuntime)
  {
    return (FriendExtensionServiceImpl)paramAppRuntime.getRuntimeService(IFriendExtensionService.class, "all");
  }
  
  public List<ExtensionInfo> getAllExtensionInfo()
  {
    return this.mExtensionCache.a();
  }
  
  public ExtensionInfo getExtensionInfo(String paramString)
  {
    return getExtensionInfo(paramString, true);
  }
  
  public ExtensionInfo getExtensionInfo(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ExtensionInfo localExtensionInfo = this.mExtensionCache.a(paramString);
    Object localObject = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      localObject = localExtensionInfo;
      if (paramBoolean)
      {
        localObject = localExtensionInfo;
        if (!this.mExtensionCache.a())
        {
          localExtensionInfo = this.mExtensionCache.b(paramString);
          localObject = localExtensionInfo;
          if (localExtensionInfo == null)
          {
            localObject = localExtensionInfo;
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("getExtensionInfoFromDB is null| friendUin: ");
              ((StringBuilder)localObject).append(paramString);
              QLog.d("FriendExtensionServiceImpl", 2, ((StringBuilder)localObject).toString());
              localObject = localExtensionInfo;
            }
          }
        }
      }
    }
    return localObject;
  }
  
  public void initCache()
  {
    this.mExtensionCache.a();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mEntityManager = paramAppRuntime.getEntityManagerFactory().createEntityManager();
    this.mExtensionCache = new ExtensionInfoCache(paramAppRuntime, this.mEntityManager);
  }
  
  public void onDestroy()
  {
    this.mEntityManager.close();
  }
  
  public boolean saveExtensionInfo(ExtensionInfo paramExtensionInfo)
  {
    if (paramExtensionInfo == null)
    {
      QLog.d("FriendExtensionServiceImpl", 1, "updateExtensionInfo| info == null");
      return false;
    }
    this.mExtensionCache.a(paramExtensionInfo);
    return this.mExtensionCache.a(paramExtensionInfo);
  }
  
  public boolean saveExtensionInfoList(List<ExtensionInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ExtensionInfo localExtensionInfo = (ExtensionInfo)localIterator.next();
        this.mExtensionCache.a(localExtensionInfo);
      }
      return this.mExtensionCache.a(paramList);
    }
    QLog.d("FriendExtensionServiceImpl", 1, "updateExtensionInfoList| infoList is empty!");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.api.impl.FriendExtensionServiceImpl
 * JD-Core Version:    0.7.0.1
 */
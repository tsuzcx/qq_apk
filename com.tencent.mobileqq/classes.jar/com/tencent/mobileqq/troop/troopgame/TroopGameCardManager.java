package com.tencent.mobileqq.troop.troopgame;

import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService.CallbackInMainThread;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class TroopGameCardManager
  implements Manager
{
  private AppRuntime a;
  private EntityManager b;
  private LruCache<String, MemberGradeLevelInfo> c = new LruCache(1000);
  
  public TroopGameCardManager(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
    this.b = paramAppRuntime.getEntityManagerFactory().createEntityManager();
  }
  
  private MemberGradeLevelInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardManager", 2, "getMemberGradeLevelInfo arg is invalid");
      }
      return null;
    }
    Object localObject2 = (MemberGradeLevelInfo)this.c.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (MemberGradeLevelInfo)this.b.find(MemberGradeLevelInfo.class, paramString);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getMemberGradeLevelInfo info = ");
      if (localObject1 == null) {
        paramString = "null";
      } else {
        paramString = ((MemberGradeLevelInfo)localObject1).toString();
      }
      ((StringBuilder)localObject2).append(paramString);
      QLog.d("TroopGameCardManager", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  private boolean b(Entity paramEntity)
  {
    boolean bool2 = this.b.isOpen();
    boolean bool1 = false;
    if (bool2)
    {
      if (paramEntity.getStatus() == 1000)
      {
        this.b.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
        return bool1;
      }
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.b.update(paramEntity);
      }
    }
    return false;
  }
  
  protected void a(Entity paramEntity)
  {
    ThreadManager.excute(new TroopGameCardManager.2(this, paramEntity), 32, null, true);
  }
  
  public void a(MemberGradeLevelInfo paramMemberGradeLevelInfo)
  {
    if ((paramMemberGradeLevelInfo != null) && (!TextUtils.isEmpty(paramMemberGradeLevelInfo.memberuin)))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveMemberGradeLevelInfo memberuin = ");
        localStringBuilder.append(paramMemberGradeLevelInfo.memberuin);
        localStringBuilder.append(", level = ");
        localStringBuilder.append(paramMemberGradeLevelInfo.gradeLevel);
        QLog.d("TroopGameCardManager", 2, localStringBuilder.toString());
      }
      if (this.c == null) {
        this.c = new LruCache(1000);
      }
      this.c.put(paramMemberGradeLevelInfo.memberuin, paramMemberGradeLevelInfo);
      a(paramMemberGradeLevelInfo);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardManager", 2, "saveMemberGradeLevelInfo arg is null");
    }
  }
  
  public void a(String paramString, ITroopGameCardService.CallbackInMainThread paramCallbackInMainThread)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramCallbackInMainThread == null) {
        return;
      }
      ThreadManager.excute(new TroopGameCardManager.1(this, paramString, paramCallbackInMainThread), 32, null, true);
    }
  }
  
  public void onDestroy()
  {
    this.a = null;
    EntityManager localEntityManager = this.b;
    if (localEntityManager != null) {
      localEntityManager.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopGameCardManager
 * JD-Core Version:    0.7.0.1
 */
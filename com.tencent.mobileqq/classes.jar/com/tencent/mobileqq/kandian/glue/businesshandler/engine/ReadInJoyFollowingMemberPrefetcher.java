package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.db.struct.ReadinjoyFollowingUserBriefInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule;
import com.tencent.mobileqq.kandian.repo.follow.FollowingMember;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ReadInJoyFollowingMemberPrefetcher
  extends ReadInJoyObserver
{
  private WeakReference<AppInterface> a;
  private WeakReference<FollowListInfoModule> b;
  private Set<Long> c = new HashSet();
  private boolean d = true;
  private long e = 0L;
  private boolean f = false;
  private boolean g = false;
  
  public ReadInJoyFollowingMemberPrefetcher(AppInterface paramAppInterface, FollowListInfoModule paramFollowListInfoModule)
  {
    this.a = new WeakReference(paramAppInterface);
    this.b = new WeakReference(paramFollowListInfoModule);
    ThreadManager.executeOnSubThread(new ReadInJoyFollowingMemberPrefetcher.1(this));
  }
  
  private void a(long paramLong)
  {
    Object localObject = (AppInterface)this.a.get();
    if (localObject != null)
    {
      this.e = paramLong;
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_public_account_with_cuin_");
      localStringBuilder.append(((AppInterface)localObject).getAccount());
      localObject = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 4);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putLong("readinjoy_last_request_prefetch_following_time", paramLong).commit();
      }
    }
  }
  
  private void a(EntityManager paramEntityManager, long paramLong, int paramInt)
  {
    if (paramEntityManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyFollowingMemberPrefetcher", 0, "update follow status error, entity manager is null!");
      }
      return;
    }
    if ((paramInt != 1) && (paramInt != 0))
    {
      paramEntityManager.persistOrReplace(new ReadinjoyFollowingUserBriefInfo(paramLong, paramInt));
      this.c.add(Long.valueOf(paramLong));
      return;
    }
    ReadinjoyFollowingUserBriefInfo localReadinjoyFollowingUserBriefInfo = (ReadinjoyFollowingUserBriefInfo)paramEntityManager.find(ReadinjoyFollowingUserBriefInfo.class, String.valueOf(paramLong));
    if (localReadinjoyFollowingUserBriefInfo != null) {
      paramEntityManager.remove(localReadinjoyFollowingUserBriefInfo);
    }
    this.c.remove(Long.valueOf(paramLong));
  }
  
  private void a(List<FollowingMember> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    Object localObject = (AppInterface)this.a.get();
    if (localObject != null)
    {
      localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((EntityManager)localObject, ((FollowingMember)paramList.next()).a().longValue(), paramInt);
      }
    }
  }
  
  private void a(List<FollowingMember> paramList, boolean paramBoolean)
  {
    if (this.d)
    {
      q();
      this.d = false;
    }
    a(System.currentTimeMillis());
    a(paramList, 2);
    if (!paramBoolean)
    {
      this.f = false;
      return;
    }
    paramList = (FollowListInfoModule)this.b.get();
    if (paramList != null) {
      paramList.a(1000, 1, true);
    }
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyFollowingMemberPrefetcher", 0, "clear all following members in cache and db");
    }
    this.c.clear();
    AppInterface localAppInterface = (AppInterface)this.a.get();
    if (localAppInterface != null) {
      localAppInterface.getEntityManagerFactory().createEntityManager().drop(ReadinjoyFollowingUserBriefInfo.class);
    }
  }
  
  private void r()
  {
    Object localObject1 = (AppInterface)this.a.get();
    if (localObject1 != null)
    {
      Object localObject2 = BaseApplicationImpl.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_public_account_with_cuin_");
      localStringBuilder.append(((AppInterface)localObject1).getAccount());
      localObject2 = ((BaseApplication)localObject2).getSharedPreferences(localStringBuilder.toString(), 4);
      if (localObject2 != null) {
        this.e = ((SharedPreferences)localObject2).getLong("readinjoy_last_request_prefetch_following_time", 0L);
      }
      this.c.clear();
      localObject1 = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager().query(ReadinjoyFollowingUserBriefInfo.class);
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ReadinjoyFollowingUserBriefInfo)((Iterator)localObject1).next();
          this.c.add(Long.valueOf(((ReadinjoyFollowingUserBriefInfo)localObject2).uin));
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, List<FollowingMember> paramList, long paramLong, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      ThreadManager.executeOnSubThread(new ReadInJoyFollowingMemberPrefetcher.3(this, paramList));
    }
  }
  
  public void b(long paramLong, int paramInt)
  {
    AppInterface localAppInterface = (AppInterface)this.a.get();
    if (localAppInterface != null) {
      a(localAppInterface.getEntityManagerFactory().createEntityManager(), paramLong, paramInt);
    }
  }
  
  public void b(boolean paramBoolean1, List<FollowingMember> paramList, long paramLong, boolean paramBoolean2)
  {
    if (this.f)
    {
      if (!paramBoolean1) {
        return;
      }
      ThreadManager.executeOnSubThread(new ReadInJoyFollowingMemberPrefetcher.2(this, paramList, paramBoolean2));
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if ((this.b.get() != null) && ((p()) || (paramBoolean))) {
      ThreadManager.executeOnSubThread(new ReadInJoyFollowingMemberPrefetcher.4(this, paramBoolean));
    }
  }
  
  public void m()
  {
    this.d = true;
  }
  
  public long n()
  {
    return this.e;
  }
  
  public void o()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyFollowingMemberPrefetcher", 0, "uninitialize");
      }
      this.g = true;
      ReadInJoyLogicEngineEventDispatcher.a().b(this);
      return;
    }
    finally {}
  }
  
  public boolean p()
  {
    return System.currentTimeMillis() - n() > 86400000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyFollowingMemberPrefetcher
 * JD-Core Version:    0.7.0.1
 */
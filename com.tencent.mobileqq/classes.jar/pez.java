import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyFollowingMemberPrefetcher.1;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyFollowingMemberPrefetcher.2;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyFollowingMemberPrefetcher.3;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyFollowingMemberPrefetcher.4;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyFollowingUserBriefInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class pez
  extends pfh
{
  private long jdField_a_of_type_Long;
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private Set<Long> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean = true;
  private WeakReference<ppo> jdField_b_of_type_JavaLangRefWeakReference;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public pez(AppInterface paramAppInterface, ppo paramppo)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramppo);
    ThreadManager.executeOnSubThread(new ReadInJoyFollowingMemberPrefetcher.1(this));
  }
  
  private void a(long paramLong)
  {
    Object localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null)
    {
      this.jdField_a_of_type_Long = paramLong;
      localObject = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + ((AppInterface)localObject).getAccount(), 4);
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
    if ((paramInt == 1) || (paramInt == 0))
    {
      ReadinjoyFollowingUserBriefInfo localReadinjoyFollowingUserBriefInfo = (ReadinjoyFollowingUserBriefInfo)paramEntityManager.find(ReadinjoyFollowingUserBriefInfo.class, String.valueOf(paramLong));
      if (localReadinjoyFollowingUserBriefInfo != null) {
        paramEntityManager.remove(localReadinjoyFollowingUserBriefInfo);
      }
      this.jdField_a_of_type_JavaUtilSet.remove(Long.valueOf(paramLong));
      return;
    }
    paramEntityManager.persistOrReplace(new ReadinjoyFollowingUserBriefInfo(paramLong, paramInt));
    this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramLong));
  }
  
  private void a(List<qwb> paramList, int paramInt)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      Object localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null)
      {
        localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          a((EntityManager)localObject, ((qwb)paramList.next()).a().longValue(), paramInt);
        }
      }
    }
  }
  
  private void a(List<qwb> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      q();
      this.jdField_a_of_type_Boolean = false;
    }
    a(System.currentTimeMillis());
    a(paramList, 2);
    if (!paramBoolean) {
      this.jdField_b_of_type_Boolean = false;
    }
    do
    {
      return;
      paramList = (ppo)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    } while (paramList == null);
    paramList.a(1000, 1, true);
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyFollowingMemberPrefetcher", 0, "clear all following members in cache and db");
    }
    this.jdField_a_of_type_JavaUtilSet.clear();
    AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAppInterface != null) {
      localAppInterface.getEntityManagerFactory().createEntityManager().drop(ReadinjoyFollowingUserBriefInfo.class);
    }
  }
  
  private void r()
  {
    Object localObject1 = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 != null)
    {
      Object localObject2 = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + ((AppInterface)localObject1).getAccount(), 4);
      if (localObject2 != null) {
        this.jdField_a_of_type_Long = ((SharedPreferences)localObject2).getLong("readinjoy_last_request_prefetch_following_time", 0L);
      }
      this.jdField_a_of_type_JavaUtilSet.clear();
      localObject1 = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager().query(ReadinjoyFollowingUserBriefInfo.class);
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ReadinjoyFollowingUserBriefInfo)((Iterator)localObject1).next();
          this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(((ReadinjoyFollowingUserBriefInfo)localObject2).uin));
        }
      }
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a(long paramLong, int paramInt)
  {
    AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAppInterface != null) {
      a(localAppInterface.getEntityManagerFactory().createEntityManager(), paramLong, paramInt);
    }
  }
  
  public void a(boolean paramBoolean1, List<qwb> paramList, long paramLong, boolean paramBoolean2)
  {
    if ((!this.jdField_b_of_type_Boolean) || (!paramBoolean1)) {
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyFollowingMemberPrefetcher.2(this, paramList, paramBoolean2));
  }
  
  public boolean a()
  {
    return System.currentTimeMillis() - a() > 86400000L;
  }
  
  public void b(boolean paramBoolean1, List<qwb> paramList, long paramLong, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      ThreadManager.executeOnSubThread(new ReadInJoyFollowingMemberPrefetcher.3(this, paramList));
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && ((a()) || (paramBoolean))) {
      ThreadManager.executeOnSubThread(new ReadInJoyFollowingMemberPrefetcher.4(this, paramBoolean));
    }
  }
  
  public void d()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyFollowingMemberPrefetcher", 0, "uninitialize");
      }
      this.c = true;
      pfd.a().b(this);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pez
 * JD-Core Version:    0.7.0.1
 */
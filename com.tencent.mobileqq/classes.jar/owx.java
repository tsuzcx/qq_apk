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
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class owx
  extends oxe
{
  private long jdField_a_of_type_Long;
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private Set<Long> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean = true;
  private WeakReference<pfw> jdField_b_of_type_JavaLangRefWeakReference;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public owx(AppInterface paramAppInterface, pfw parampfw)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(parampfw);
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
  
  private void a(awbw paramawbw, long paramLong, int paramInt)
  {
    if (paramawbw == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyFollowingMemberPrefetcher", 0, "update follow status error, entity manager is null!");
      }
      return;
    }
    if ((paramInt == 1) || (paramInt == 0))
    {
      ReadinjoyFollowingUserBriefInfo localReadinjoyFollowingUserBriefInfo = (ReadinjoyFollowingUserBriefInfo)paramawbw.a(ReadinjoyFollowingUserBriefInfo.class, String.valueOf(paramLong));
      if (localReadinjoyFollowingUserBriefInfo != null) {
        paramawbw.b(localReadinjoyFollowingUserBriefInfo);
      }
      this.jdField_a_of_type_JavaUtilSet.remove(Long.valueOf(paramLong));
      return;
    }
    paramawbw.b(new ReadinjoyFollowingUserBriefInfo(paramLong, paramInt));
    this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramLong));
  }
  
  private void a(List<qkw> paramList, int paramInt)
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
          a((awbw)localObject, ((qkw)paramList.next()).a().longValue(), paramInt);
        }
      }
    }
  }
  
  private void a(List<qkw> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      p();
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
      paramList = (pfw)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    } while (paramList == null);
    paramList.a(1000, 1, true);
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyFollowingMemberPrefetcher", 0, "clear all following members in cache and db");
    }
    this.jdField_a_of_type_JavaUtilSet.clear();
    AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAppInterface != null) {
      localAppInterface.getEntityManagerFactory().createEntityManager().a(ReadinjoyFollowingUserBriefInfo.class);
    }
  }
  
  private void q()
  {
    Object localObject1 = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 != null)
    {
      Object localObject2 = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + ((AppInterface)localObject1).getAccount(), 4);
      if (localObject2 != null) {
        this.jdField_a_of_type_Long = ((SharedPreferences)localObject2).getLong("readinjoy_last_request_prefetch_following_time", 0L);
      }
      this.jdField_a_of_type_JavaUtilSet.clear();
      localObject1 = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager().a(ReadinjoyFollowingUserBriefInfo.class);
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
  
  public void a(boolean paramBoolean1, List<qkw> paramList, long paramLong, boolean paramBoolean2)
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
  
  public boolean a(Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyFollowingMemberPrefetcher", 0, "[isFollowingPgcUin] uin:" + paramLong + ", size:" + this.jdField_a_of_type_JavaUtilSet.size());
    }
    return this.jdField_a_of_type_JavaUtilSet.contains(paramLong);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b(boolean paramBoolean1, List<qkw> paramList, long paramLong, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      ThreadManager.executeOnSubThread(new ReadInJoyFollowingMemberPrefetcher.3(this, paramList));
    }
  }
  
  public void c()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyFollowingMemberPrefetcher", 0, "uninitialize");
      }
      this.c = true;
      oxb.a().b(this);
      return;
    }
    finally {}
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && ((a()) || (paramBoolean))) {
      ThreadManager.executeOnSubThread(new ReadInJoyFollowingMemberPrefetcher.4(this, paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     owx
 * JD-Core Version:    0.7.0.1
 */
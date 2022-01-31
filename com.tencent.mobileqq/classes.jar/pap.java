import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule.1;
import com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule.2;
import com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule.3;
import com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule.4;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class pap
{
  private int jdField_a_of_type_Int = -1;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private final String jdField_a_of_type_JavaLangString = "FollowCoverInfoModule";
  private HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private qdt jdField_a_of_type_Qdt;
  
  public pap(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    b();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Int == -1) {
      ThreadManager.executeOnFileThread(new FollowCoverInfoModule.1(this));
    }
  }
  
  public int a()
  {
    int i = 0;
    SharedPreferences localSharedPreferences = bhvh.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, false);
    if (localSharedPreferences != null) {
      i = localSharedPreferences.getInt("follow_tab_enter_topic_reddot_time", 0);
    }
    return i;
  }
  
  public String a()
  {
    SharedPreferences localSharedPreferences = bhvh.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, false);
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString("follow_tab_last_refresh_cookie", "");
    }
    return "";
  }
  
  public HashMap<Long, Long> a()
  {
    try
    {
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      return localHashMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      if (QLog.isColorLevel()) {
        QLog.d("FollowCoverInfoModule", 2, "topic update exp clear");
      }
      ThreadManager.executeOnFileThread(new FollowCoverInfoModule.3(this));
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    Object localObject = bhvh.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putInt("follow_tab_user_topic_reddot_update_num", paramInt);
        bhvh.a((SharedPreferences.Editor)localObject, true);
        QLog.d("FollowCoverInfoModule", 2, "update user topic reddot update num : " + paramInt);
      }
    }
  }
  
  public void a(Long paramLong)
  {
    try
    {
      Long localLong = Long.valueOf(System.currentTimeMillis());
      this.jdField_a_of_type_JavaUtilHashMap.put(paramLong, localLong);
      if (QLog.isColorLevel()) {
        QLog.d("FollowCoverInfoModule", 2, "topic update exp set " + paramLong + " " + localLong);
      }
      ThreadManager.executeOnFileThread(new FollowCoverInfoModule.4(this, new HashMap(this.jdField_a_of_type_JavaUtilHashMap)));
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    Object localObject = bhvh.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putString("follow_tab_last_refresh_cookie", paramString);
        bhvh.a((SharedPreferences.Editor)localObject, true);
        QLog.d("FollowCoverInfoModule", 2, "updateLastRefreshCookie cookie : " + paramString);
      }
    }
  }
  
  public void a(qdt paramqdt)
  {
    StringBuilder localStringBuilder;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Qdt = paramqdt;
        if (paramqdt == null)
        {
          i = 0;
          this.jdField_a_of_type_Int = i;
          if (!QLog.isColorLevel()) {
            break label151;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("topic update save info exists ").append(this.jdField_a_of_type_Int).append(" size ");
          if ((paramqdt == null) || (paramqdt.a == null)) {
            break;
          }
          localStringBuilder.append(paramqdt.a.size()).append(" ");
          Iterator localIterator = paramqdt.a.iterator();
          if (!localIterator.hasNext()) {
            break label141;
          }
          localStringBuilder.append(((qdv)localIterator.next()).jdField_a_of_type_Int).append(" ");
          continue;
        }
        int i = 1;
      }
      finally {}
    }
    localStringBuilder.append("0");
    label141:
    QLog.d("FollowCoverInfoModule", 2, localStringBuilder.toString());
    label151:
    ThreadManager.executeOnFileThread(new FollowCoverInfoModule.2(this, paramqdt));
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = bhvh.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("follow_tab_user_topic_follow_state", paramBoolean);
        bhvh.a((SharedPreferences.Editor)localObject, true);
        QLog.d("FollowCoverInfoModule", 2, "update user follow state : " + paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pap
 * JD-Core Version:    0.7.0.1
 */
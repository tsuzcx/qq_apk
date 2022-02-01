import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule.1;
import com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule.2;
import com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule.4;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class puv
{
  private int jdField_a_of_type_Int = -1;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private rga jdField_a_of_type_Rga;
  
  public puv(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    a();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Int == -1) {
      ThreadManager.executeOnFileThread(new FollowCoverInfoModule.1(this));
    }
  }
  
  public int a()
  {
    int i = 0;
    SharedPreferences localSharedPreferences = bkwm.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, false);
    if (localSharedPreferences != null) {
      i = localSharedPreferences.getInt("follow_tab_enter_topic_reddot_time", 0);
    }
    return i;
  }
  
  public String a()
  {
    SharedPreferences localSharedPreferences = bkwm.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, false);
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
  
  public void a(int paramInt)
  {
    Object localObject = bkwm.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putInt("follow_tab_user_topic_reddot_update_num", paramInt);
        bkwm.a((SharedPreferences.Editor)localObject, true);
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
    Object localObject = bkwm.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putString("follow_tab_last_refresh_cookie", paramString);
        bkwm.a((SharedPreferences.Editor)localObject, true);
        QLog.d("FollowCoverInfoModule", 2, "updateLastRefreshCookie cookie : " + paramString);
      }
    }
  }
  
  public void a(rga paramrga)
  {
    StringBuilder localStringBuilder;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Rga = paramrga;
        if (paramrga == null)
        {
          i = 0;
          this.jdField_a_of_type_Int = i;
          if (!QLog.isColorLevel()) {
            break label151;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("topic update save info exists ").append(this.jdField_a_of_type_Int).append(" size ");
          if ((paramrga == null) || (paramrga.a == null)) {
            break;
          }
          localStringBuilder.append(paramrga.a.size()).append(" ");
          Iterator localIterator = paramrga.a.iterator();
          if (!localIterator.hasNext()) {
            break label141;
          }
          localStringBuilder.append(((rgc)localIterator.next()).jdField_a_of_type_Int).append(" ");
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
    ThreadManager.executeOnFileThread(new FollowCoverInfoModule.2(this, paramrga));
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = bkwm.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("follow_tab_user_topic_follow_state", paramBoolean);
        bkwm.a((SharedPreferences.Editor)localObject, true);
        QLog.d("FollowCoverInfoModule", 2, "update user follow state : " + paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     puv
 * JD-Core Version:    0.7.0.1
 */
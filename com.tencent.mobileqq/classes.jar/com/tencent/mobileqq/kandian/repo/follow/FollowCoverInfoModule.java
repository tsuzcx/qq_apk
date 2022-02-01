package com.tencent.mobileqq.kandian.repo.follow;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class FollowCoverInfoModule
{
  private int jdField_a_of_type_Int = -1;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private TopicRecommendFeedsInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo = null;
  private HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public FollowCoverInfoModule(AppInterface paramAppInterface)
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
    SharedPreferences localSharedPreferences = RIJSPUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, false);
    if (localSharedPreferences != null) {
      return localSharedPreferences.getInt("follow_tab_enter_topic_reddot_time", 0);
    }
    return 0;
  }
  
  public String a()
  {
    SharedPreferences localSharedPreferences = RIJSPUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, false);
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
    Object localObject = RIJSPUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putInt("follow_tab_user_topic_reddot_update_num", paramInt);
        RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("update user topic reddot update num : ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("FollowCoverInfoModule", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo = paramTopicRecommendFeedsInfo;
      if (paramTopicRecommendFeedsInfo != null) {
        break label178;
      }
      i = 0;
    }
    finally
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        Iterator localIterator;
        for (;;)
        {
          throw paramTopicRecommendFeedsInfo;
        }
        label178:
        int i = 1;
      }
    }
    this.jdField_a_of_type_Int = i;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("topic update save info exists ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" size ");
      if ((paramTopicRecommendFeedsInfo != null) && (paramTopicRecommendFeedsInfo.a != null))
      {
        localStringBuilder.append(paramTopicRecommendFeedsInfo.a.size());
        localStringBuilder.append(" ");
        localIterator = paramTopicRecommendFeedsInfo.a.iterator();
      }
      while (localIterator.hasNext())
      {
        localStringBuilder.append(((TopicRecommendFeedsInfo.TopicRecommendInfo)localIterator.next()).jdField_a_of_type_Int);
        localStringBuilder.append(" ");
        continue;
        localStringBuilder.append("0");
      }
      QLog.d("FollowCoverInfoModule", 2, localStringBuilder.toString());
    }
    ThreadManager.executeOnFileThread(new FollowCoverInfoModule.2(this, paramTopicRecommendFeedsInfo));
  }
  
  public void a(String paramString)
  {
    Object localObject = RIJSPUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putString("follow_tab_last_refresh_cookie", paramString);
        RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateLastRefreshCookie cookie : ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("FollowCoverInfoModule", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = RIJSPUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("follow_tab_user_topic_follow_state", paramBoolean);
        RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("update user follow state : ");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("FollowCoverInfoModule", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.follow.FollowCoverInfoModule
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.campuscircle;

import abwi;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import mqq.manager.Manager;

public class CampusCircleManager
  implements Manager
{
  public long a;
  public QQAppInterface a;
  public CampusCircleHandler a;
  public CampusCircleManager.TopicPublishSession a;
  public HashMap a;
  public Set a;
  
  public CampusCircleManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleHandler = ((CampusCircleHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(108));
  }
  
  public CampusCircleManager.TopicPublishSession a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession == null) || (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_Long != paramLong)) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession;
  }
  
  public List a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CampusCircleManager", 2, String.format(Locale.getDefault(), "getCampusTopics nFromType: %d tag: %s", new Object[] { Integer.valueOf(paramInt), paramString }));
    }
    String str = null;
    if (paramInt == 1) {
      str = String.format(Locale.getDefault(), "%s_%s_%d", new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "campus_topics_cache_filename", Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      return (List)FileUtils.a(str);
      if (paramInt == 2) {
        str = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "campus_topics_cache_filename", paramString });
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession = new CampusCircleManager.TopicPublishSession();
    this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicPublisher = new CampusCircleManager.CampusTopicPublisher(this, this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession);
    if (QLog.isColorLevel()) {
      QLog.d("CampusCircleManager", 2, "onCreateTopicSesstion, sessionid=" + this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_Long);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onPublishFeedCall, mCurTopicSession.sessionID=");
      if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession == null) {
        break label100;
      }
    }
    label100:
    for (long l = this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_Long;; l = -1L)
    {
      QLog.d("CampusCircleManager", 2, l + ",sessionId=" + paramLong + ",isSucc=" + paramBoolean);
      if ((this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession != null) && (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_Long == paramLong) && (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicReq != null)) {
        break;
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession;
    if (paramBoolean) {}
    for (int i = 4;; i = 5)
    {
      ((CampusCircleManager.TopicPublishSession)localObject).a(i);
      return;
    }
  }
  
  public void a(CampusCircleManager.CampusTopicReq paramCampusTopicReq)
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleManager", 2, "publishCampusTopic, mCurTopicSession is null");
      }
      return;
    }
    ThreadManager.post(new abwi(this, paramCampusTopicReq), 8, null, true);
  }
  
  public void a(List paramList, int paramInt, String paramString)
  {
    String str = null;
    if (paramInt == 1) {
      str = String.format(Locale.getDefault(), "%s_%s_%d", new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "campus_topics_cache_filename", Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      if ((paramList != null) && (!TextUtils.isEmpty(str))) {
        FileUtils.a(str, paramList);
      }
      return;
      if (paramInt == 2) {
        str = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "campus_topics_cache_filename", paramString });
      }
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CampusCircleManager", 2, "cancelPublishCampusFeed");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleManager", 2, "cancelPublishCampusFeed, mCurTopicSession is null");
      }
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicPublisher.b();
  }
  
  public void b()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onDestroyTopicSesstion, sessionid=");
      if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession == null) {
        break label71;
      }
    }
    label71:
    for (long l = this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_Long;; l = -1L)
    {
      QLog.d("CampusCircleManager", 2, l);
      if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicPublisher.b();
        this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession = null;
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCircleManager
 * JD-Core Version:    0.7.0.1
 */
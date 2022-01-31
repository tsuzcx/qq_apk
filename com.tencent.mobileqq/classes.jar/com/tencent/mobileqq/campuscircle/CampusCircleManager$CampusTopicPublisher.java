package com.tencent.mobileqq.campuscircle;

import abwj;
import abwk;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CampusCircleManager$CampusTopicPublisher
{
  public CampusCircleManager.TopicPublishSession a;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new abwj(this);
  HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  
  public CampusCircleManager$CampusTopicPublisher(CampusCircleManager paramCampusCircleManager, CampusCircleManager.TopicPublishSession paramTopicPublishSession)
  {
    this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession = paramTopicPublishSession;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
  }
  
  private void a(CampusCircleManager.PicInfo paramPicInfo)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager.jdField_a_of_type_JavaUtilSet.contains(paramPicInfo.md5);
    if (QLog.isColorLevel()) {
      QLog.d("CampusCircleManager", 2, "Publisher.uploadPhoto(), md5=" + paramPicInfo.md5 + ",isUploading=" + bool);
    }
    if (!bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager.jdField_a_of_type_JavaUtilSet.add(paramPicInfo.md5);
      paramPicInfo = new abwk(this, paramPicInfo);
      this.jdField_a_of_type_JavaUtilHashSet.add(paramPicInfo);
      ThreadManager.post(paramPicInfo, 8, null, true);
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CampusCircleManager", 2, "Publisher.publishCampusTopic");
    }
    if (!a()) {
      return;
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleHandler.a(this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicReq);
    CampusCircleManager.TopicPublishSession localTopicPublishSession = this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession;
    if (bool) {}
    for (int i = 3;; i = 5)
    {
      localTopicPublishSession.a(i);
      return;
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CampusCircleManager", 2, "Publisher.removePhotoUploadHandler");
    }
    this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CampusCircleManager", 2, "Publisher.cancelUpload");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicReq;
    if (localObject != null)
    {
      localObject = ((CampusCircleManager.CampusTopicReq)localObject).picInfos.iterator();
      while (((Iterator)localObject).hasNext())
      {
        CampusCircleManager.PicInfo localPicInfo = (CampusCircleManager.PicInfo)((Iterator)localObject).next();
        this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localPicInfo.md5, this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_Long);
      }
      localObject = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (((Iterator)localObject).hasNext()) {
        ThreadManager.remove((abwk)((Iterator)localObject).next());
      }
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CampusCircleManager", 2, "Publisher.notifyFail()");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession != null) {
      this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.a(5);
    }
    this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleHandler.a(2, false, null);
    CampusCircleHelper.a(this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "actPublishCampusFeed", paramInt, this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager.jdField_a_of_type_Long);
  }
  
  public void a(CampusCircleManager.CampusTopicReq paramCampusTopicReq)
  {
    CampusCircleManager.CampusTopicReq localCampusTopicReq = this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.b;
    int i;
    if ((localCampusTopicReq == null) || (localCampusTopicReq.currSendState == 6))
    {
      paramCampusTopicReq.retryCnt = 0;
      this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicReq = paramCampusTopicReq;
      i = 0;
      if (a()) {
        break label134;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleManager", 2, "Publisher.startPublishing check wrong");
      }
    }
    label134:
    do
    {
      return;
      if ((localCampusTopicReq.checkEqual(paramCampusTopicReq)) && (localCampusTopicReq.currSendState == 5))
      {
        i = localCampusTopicReq.retryCnt;
        localCampusTopicReq.retryCnt = (i + 1);
        paramCampusTopicReq.retryCnt = i;
        paramCampusTopicReq.currSendState = 0;
        this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicReq = paramCampusTopicReq;
        i = 1;
        break;
      }
      paramCampusTopicReq.retryCnt = 0;
      this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicReq = paramCampusTopicReq;
      i = 2;
      break;
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("Publisher.startPublishing, whatIf=").append(i).append(", unPublishState=");
        if (localCampusTopicReq == null) {
          break label256;
        }
      }
      for (i = localCampusTopicReq.currSendState;; i = -1)
      {
        QLog.d("CampusCircleManager", 2, i);
        this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.a(1);
        localCampusTopicReq = this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicReq;
        localObject = localCampusTopicReq.picInfos.iterator();
        while (((Iterator)localObject).hasNext())
        {
          CampusCircleManager.PicInfo localPicInfo = (CampusCircleManager.PicInfo)((Iterator)localObject).next();
          localPicInfo.md5 = FileUtils.b(localPicInfo.path);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleManager", 2, "Publisher.startPublishing, " + this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_Long + ", " + paramCampusTopicReq.getStringLog(true));
      }
      if (localCampusTopicReq.picInfos.size() == 0)
      {
        c();
        return;
      }
      int j = 0;
      if (j < localCampusTopicReq.picInfos.size())
      {
        paramCampusTopicReq = (CampusCircleManager.PicInfo)localCampusTopicReq.picInfos.get(j);
        this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.a(2);
        localObject = (String)this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager.jdField_a_of_type_JavaUtilHashMap.get(paramCampusTopicReq.md5);
        boolean bool;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramCampusTopicReq.url = ((String)localObject);
          i = 0;
          bool = true;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("CampusCircleManager", 2, "Publisher.publish, skipCurrIndex=" + bool + ",whatIf2=" + i);
          }
          j += 1;
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager.jdField_a_of_type_JavaUtilSet.contains(paramCampusTopicReq.md5))
          {
            i = 1;
            bool = true;
          }
          else
          {
            a(paramCampusTopicReq);
            i = 2;
            bool = false;
          }
        }
      }
    } while (!localCampusTopicReq.isPicsUrlReady());
    label256:
    c();
  }
  
  public boolean a()
  {
    boolean bool = true;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession == null) || (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicReq == null))
    {
      a(4);
      i = 1;
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleManager", 2, "checkTopicReq, whatif=" + i);
      }
      return bool;
      if ((this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicReq.currSendState == 6) || (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicReq.currSendState == 5))
      {
        bool = false;
        i = 2;
      }
      else
      {
        i = -1;
      }
    }
  }
  
  public void b()
  {
    b();
    d();
  }
  
  public boolean b()
  {
    if (!a()) {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleManager", 2, "Publisher.cancelPublish check wrong");
      }
    }
    CampusCircleManager.CampusTopicReq localCampusTopicReq;
    do
    {
      return false;
      localCampusTopicReq = this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicReq;
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleManager", 2, "Publisher.cancelPublish, curState=" + localCampusTopicReq.currSendState + ",lastsate=" + localCampusTopicReq.lastSendState);
      }
    } while (localCampusTopicReq.currSendState == 3);
    this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$TopicPublishSession.a(6);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCircleManager.CampusTopicPublisher
 * JD-Core Version:    0.7.0.1
 */
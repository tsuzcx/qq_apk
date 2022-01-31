package com.tencent.mobileqq.campuscircle;

import com.tencent.qphone.base.util.QLog;

public class CampusCircleManager$TopicPublishSession
{
  public long a;
  public CampusCircleManager.CampusTopicPublisher a;
  public CampusCircleManager.CampusTopicReq a;
  CampusCircleManager.CampusTopicReq b;
  CampusCircleManager.CampusTopicReq c;
  
  public CampusCircleManager$TopicPublishSession()
  {
    this.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicReq == null) {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleManager", 2, "updateCurTopicReqState,  mCurTopicReq is null");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleManager", 2, "updateCurTopicReqState, state=" + paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicReq.updateState(paramInt);
      if (paramInt == 4)
      {
        this.c = this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicReq;
        return;
      }
    } while ((paramInt != 5) && (paramInt != 6));
    if (this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicPublisher != null) {
      this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicPublisher.a();
    }
    this.b = this.jdField_a_of_type_ComTencentMobileqqCampuscircleCampusCircleManager$CampusTopicReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCircleManager.TopicPublishSession
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.now.recommend;

import com.tencent.mobileqq.now.netchannel.websso.IChannelListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class RecommendAnchorDataManager$1
  implements IChannelListener
{
  RecommendAnchorDataManager$1(RecommendAnchorDataManager paramRecommendAnchorDataManager, int paramInt, RecommendAnchorDataManager.RecommendAnchorDataCallback paramRecommendAnchorDataCallback) {}
  
  public void a(int paramInt, String paramString)
  {
    RecommendAnchorDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorDataManager, false);
    if (RecommendAnchorDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorDataManager).size() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorDataManager.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorDataManager$RecommendAnchorDataCallback, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d(RecommendAnchorDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorDataManager), 2, "Focus cmd:1718 sub cmd:100 errCode:" + paramInt + " msg:" + paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    RecommendAnchorDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorDataManager, false);
    try
    {
      RecommendAnchorDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorDataManager, 0);
      if ((this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorDataManager.a(this.jdField_a_of_type_Int, paramArrayOfByte) == -1) && (RecommendAnchorDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorDataManager).size() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorDataManager.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorDataManager$RecommendAnchorDataCallback, true);
      }
      this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorDataManager$RecommendAnchorDataCallback.a(RecommendAnchorDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorDataManager));
      RecommendAnchorDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorDataManager, System.currentTimeMillis());
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(RecommendAnchorDataManager.a(this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorDataManager), 2, "Focus cmd:1718 sub cmd:100 Exception:" + paramArrayOfByte.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.recommend.RecommendAnchorDataManager.1
 * JD-Core Version:    0.7.0.1
 */
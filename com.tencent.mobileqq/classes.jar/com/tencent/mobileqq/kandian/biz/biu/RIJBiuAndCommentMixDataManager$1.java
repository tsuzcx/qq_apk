package com.tencent.mobileqq.kandian.biz.biu;

import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IRIJBiuAndCommentMixDataManager.BiuAndCommentListener;
import com.tencent.mobileqq.kandian.repo.biu.BiuInfo;
import com.tencent.mobileqq.kandian.repo.biu.RIJNewBiuCardTransformManager;
import com.tencent.mobileqq.kandian.repo.comment.entity.RIJBiuAndCommentRespData;
import com.tencent.qphone.base.util.QLog;

class RIJBiuAndCommentMixDataManager$1
  implements Runnable
{
  RIJBiuAndCommentMixDataManager$1(RIJBiuAndCommentMixDataManager paramRIJBiuAndCommentMixDataManager, RIJBiuAndCommentRespData paramRIJBiuAndCommentRespData, int paramInt) {}
  
  public void run()
  {
    if (RIJBiuAndCommentMixDataManager.a(this.this$0) != null)
    {
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "onBiuAndCommentMixSend callBack to mBiuAndCommentListener");
      RIJBiuAndCommentMixDataManager.a(this.this$0).a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommentEntityRIJBiuAndCommentRespData);
    }
    else
    {
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "onBiuAndCommentMixSend dataManager is destory");
    }
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommentEntityRIJBiuAndCommentRespData.c() == 1))
    {
      BiuInfo localBiuInfo = RIJNewBiuCardTransformManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommentEntityRIJBiuAndCommentRespData, false);
      RIJNewBiuCardTransformManager.a().a(localBiuInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.RIJBiuAndCommentMixDataManager.1
 * JD-Core Version:    0.7.0.1
 */
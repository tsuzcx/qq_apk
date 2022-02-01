package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IGetAllUploadStatusVideosCallback;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.ILoadDBCallback;
import java.util.ArrayList;
import java.util.List;

class RIJUgcVideoPublishManager$7
  implements IRIJUgcVideoPublishService.ILoadDBCallback
{
  RIJUgcVideoPublishManager$7(RIJUgcVideoPublishManager paramRIJUgcVideoPublishManager, long paramLong, IRIJUgcVideoPublishService.IGetAllUploadStatusVideosCallback paramIGetAllUploadStatusVideosCallback) {}
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskRIJUgcVideoPublishManager;
    localObject = RIJUgcVideoPublishManager.a((RIJUgcVideoPublishManager)localObject, this.jdField_a_of_type_Long, RIJUgcVideoPublishManager.a((RIJUgcVideoPublishManager)localObject));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcApiIRIJUgcVideoPublishService$IGetAllUploadStatusVideosCallback.a((List)localObject);
    RIJUgcVideoPublishManager.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskRIJUgcVideoPublishManager).remove(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.RIJUgcVideoPublishManager.7
 * JD-Core Version:    0.7.0.1
 */
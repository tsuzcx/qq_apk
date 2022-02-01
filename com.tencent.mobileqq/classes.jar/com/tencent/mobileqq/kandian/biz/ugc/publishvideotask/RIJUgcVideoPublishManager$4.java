package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class RIJUgcVideoPublishManager$4
  implements IPublishTaskCallback
{
  RIJUgcVideoPublishManager$4(RIJUgcVideoPublishManager paramRIJUgcVideoPublishManager, UgcVideo paramUgcVideo) {}
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.getProgress();
    if (RIJUgcVideoPublishManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskRIJUgcVideoPublishManager).containsKey(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.seqId)) {
      ThreadManagerV2.getUIHandlerV2().post(new RIJUgcVideoPublishManager.4.1(this, paramInt, paramBoolean1, paramBoolean2));
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uploadCallback: taskType = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",isSuccess = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("isFinish = ");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append("errorMsg = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("progress = ");
      localStringBuilder.append(i);
      QLog.i("RIJUGC.RIJUgcVideoPublishManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.RIJUgcVideoPublishManager.4
 * JD-Core Version:    0.7.0.1
 */
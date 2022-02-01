package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.qphone.base.util.QLog;

class RIJUgcVideoPublishManager$5
  implements Runnable
{
  RIJUgcVideoPublishManager$5(RIJUgcVideoPublishManager paramRIJUgcVideoPublishManager, UgcVideo paramUgcVideo) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Publish steps hav all finished. video status =");
    localStringBuilder.append(this.a.status);
    QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, localStringBuilder.toString());
    ThreadManagerV2.getUIHandlerV2().post(new RIJUgcVideoPublishManager.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.RIJUgcVideoPublishManager.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.persistence.EntityManager;

class RIJUgcVideoPublishManager$9
  implements Runnable
{
  RIJUgcVideoPublishManager$9(RIJUgcVideoPublishManager paramRIJUgcVideoPublishManager, UgcVideo paramUgcVideo) {}
  
  public void run()
  {
    RIJUgcVideoPublishManager.a(this.this$0).persistOrReplace(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.RIJUgcVideoPublishManager.9
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IGetAllUploadStatusVideosCallback;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.ILoadDBCallback;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class RIJUgcVideoPublishManager$7
  implements IRIJUgcVideoPublishService.ILoadDBCallback
{
  RIJUgcVideoPublishManager$7(RIJUgcVideoPublishManager paramRIJUgcVideoPublishManager, long paramLong, IRIJUgcVideoPublishService.IGetAllUploadStatusVideosCallback paramIGetAllUploadStatusVideosCallback) {}
  
  public void a()
  {
    Object localObject = this.c;
    localObject = RIJUgcVideoPublishManager.a((RIJUgcVideoPublishManager)localObject, this.a, RIJUgcVideoPublishManager.e((RIJUgcVideoPublishManager)localObject));
    this.b.a((List)localObject);
    RIJUgcVideoPublishManager.f(this.c).remove(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.RIJUgcVideoPublishManager.7
 * JD-Core Version:    0.7.0.1
 */
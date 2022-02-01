package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class RIJUgcVideoPublishManager$8
  implements Runnable
{
  RIJUgcVideoPublishManager$8(RIJUgcVideoPublishManager paramRIJUgcVideoPublishManager) {}
  
  public void run()
  {
    Iterator localIterator;
    try
    {
      List localList = RIJUgcVideoPublishManager.g(this.this$0).query(UgcVideo.class, UgcVideo.class.getSimpleName(), true, "", null, null, null, "insertTime desc", null);
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadFromDB error,");
      ((StringBuilder)localObject).append(localException.toString());
      QLog.e("RIJUGC.RIJUgcVideoPublishManager", 1, ((StringBuilder)localObject).toString());
      localIterator = null;
    }
    Object localObject = new ArrayList();
    if (localIterator != null)
    {
      localIterator = localIterator.iterator();
      while (localIterator.hasNext())
      {
        UgcVideo localUgcVideo = (UgcVideo)localIterator.next();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("ugcvideo id= ");
          localStringBuilder.append(localUgcVideo.seqId);
          QLog.i("RIJUGC.RIJUgcVideoPublishManager", 2, localStringBuilder.toString());
        }
        if (localUgcVideo.status == UgcVideo.STATUS_UPLOADING) {
          localUgcVideo.status = UgcVideo.STATUS_IDLE;
        }
        localUgcVideo.compressProgress = 0;
        ((List)localObject).add(localUgcVideo);
      }
    }
    ThreadManagerV2.getUIHandlerV2().post(new RIJUgcVideoPublishManager.8.1(this, (List)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.RIJUgcVideoPublishManager.8
 * JD-Core Version:    0.7.0.1
 */
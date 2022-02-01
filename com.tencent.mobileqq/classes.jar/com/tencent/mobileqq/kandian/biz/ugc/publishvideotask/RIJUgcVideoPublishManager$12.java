package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils.IUploadActionCallback;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class RIJUgcVideoPublishManager$12
  implements RIJUgcUtils.IUploadActionCallback
{
  RIJUgcVideoPublishManager$12(RIJUgcVideoPublishManager paramRIJUgcVideoPublishManager, List paramList) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        UgcVideo localUgcVideo = (UgcVideo)((Iterator)localObject).next();
        if (localUgcVideo.pauseBySwitchNet)
        {
          localUgcVideo.pauseBySwitchNet = false;
          this.b.a(localUgcVideo, true);
        }
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showMobileNetworkDialog, isContinue=");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.RIJUgcVideoPublishManager.12
 * JD-Core Version:    0.7.0.1
 */
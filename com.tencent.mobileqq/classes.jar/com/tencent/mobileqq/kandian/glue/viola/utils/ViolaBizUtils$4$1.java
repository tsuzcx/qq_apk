package com.tencent.mobileqq.kandian.glue.viola.utils;

import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils.IUploadActionCallback;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.RIJUgcVideoPublishManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ViolaBizUtils$4$1
  implements RIJUgcUtils.IUploadActionCallback
{
  ViolaBizUtils$4$1(ViolaBizUtils.4 param4, UgcVideo paramUgcVideo, List paramList) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      RIJUgcVideoPublishManager.a(this.c.b).a(this.a, true);
      ViolaBizUtils.a(this.c.d, this.c.e, this.b, this.c.f, 0, "");
    }
    else
    {
      ViolaBizUtils.a(this.c.d, this.c.e, this.b, this.c.f, -2, "cancel upload by user on mobile net");
    }
    String str = ViolaBizUtils.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showMobileNetworkDialog, isContinue=");
    localStringBuilder.append(paramBoolean);
    QLog.i(str, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils.4.1
 * JD-Core Version:    0.7.0.1
 */
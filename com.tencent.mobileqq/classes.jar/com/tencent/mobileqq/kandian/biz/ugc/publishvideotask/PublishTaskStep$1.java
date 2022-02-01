package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import com.tencent.mobileqq.kandian.biz.ugc.editvideo.PublishVideoHelper.IPublishVideoCallback;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import java.util.List;

class PublishTaskStep$1
  implements PublishVideoHelper.IPublishVideoCallback
{
  PublishTaskStep$1(PublishTaskStep paramPublishTaskStep, UgcVideo paramUgcVideo) {}
  
  public void a(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.a.rowkey = ((String)paramList.get(0));
      paramList = this.a;
      paramList.coverProgress = 100;
      paramList.videoProgress = 100;
      paramList.compressProgress = 100;
    }
    PublishTaskStep.a(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.PublishTaskStep.1
 * JD-Core Version:    0.7.0.1
 */
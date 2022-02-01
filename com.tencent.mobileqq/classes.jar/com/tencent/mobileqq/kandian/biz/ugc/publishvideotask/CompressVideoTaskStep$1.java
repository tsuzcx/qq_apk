package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.video.compress.VideoCompressTask.VideoCompressTaskListener;
import com.tencent.mobileqq.kandian.base.video.compress.VideoMediaInfo;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.qphone.base.util.QLog;

class CompressVideoTaskStep$1
  implements VideoCompressTask.VideoCompressTaskListener
{
  CompressVideoTaskStep$1(CompressVideoTaskStep paramCompressVideoTaskStep, UgcVideo paramUgcVideo) {}
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCompressProgress, progress=");
      localStringBuilder.append(paramFloat);
      QLog.i("RIJUGC.CompressVideoTaskStep", 2, localStringBuilder.toString());
    }
    if (!CompressVideoTaskStep.a(this.b))
    {
      if (paramFloat > this.a.compressProgress) {
        this.a.compressProgress = ((int)paramFloat);
      }
      if (CompressVideoTaskStep.c(this.b) != null) {
        CompressVideoTaskStep.c(this.b).a(1, true, false, null);
      }
    }
  }
  
  public void a(int paramInt, String paramString, VideoMediaInfo paramVideoMediaInfo)
  {
    ThreadManagerV2.excute(new CompressVideoTaskStep.1.1(this, paramInt, paramString, paramVideoMediaInfo), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.CompressVideoTaskStep.1
 * JD-Core Version:    0.7.0.1
 */
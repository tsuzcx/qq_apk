package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.video.compress.VideoMediaInfo;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;

class CompressVideoTaskStep$1$1$1
  implements Runnable
{
  CompressVideoTaskStep$1$1$1(CompressVideoTaskStep.1.1 param1, String paramString) {}
  
  public void run()
  {
    boolean bool;
    if ((this.b.a != 0) && (this.b.a != 1)) {
      bool = false;
    } else {
      bool = true;
    }
    UgcVideo localUgcVideo;
    if (bool)
    {
      this.b.d.a.compressPath = this.b.b;
      this.b.d.a.fileMd5 = this.a;
      localUgcVideo = this.b.d.a;
      VideoMediaInfo localVideoMediaInfo = this.b.c;
      long l2 = 0L;
      if (localVideoMediaInfo != null) {
        l1 = this.b.c.g;
      } else {
        l1 = 0L;
      }
      localUgcVideo.fileSize = l1;
      if (!CompressVideoTaskStep.a(this.b.d.b)) {
        this.b.d.a.compressProgress = 100;
      }
      this.b.d.a.compressTime = 0L;
      if (this.b.a == 0) {
        this.b.d.a.compressTime = (System.currentTimeMillis() - this.b.d.a.startCompressTime);
      }
      localUgcVideo = this.b.d.a;
      long l1 = l2;
      if (this.b.c != null) {
        l1 = this.b.c.d;
      }
      localUgcVideo.bitrate = l1;
    }
    else
    {
      if (this.b.a == 6)
      {
        this.b.d.a.status = UgcVideo.STATUS_PAUSE;
      }
      else
      {
        this.b.d.a.status = UgcVideo.STATUS_FAILED;
        localUgcVideo = this.b.d.a;
        localUgcVideo.retryTime += 1;
      }
      CompressVideoTaskStep.a(this.b.d.b, false);
      this.b.d.a.compressProgress = 0;
      PublicAccountReportUtils.a("0X800AC65", RIJUgcUtils.a(RIJQQAppInterfaceUtil.a(), this.b.d.a).addValueSafe("compress_time", Long.valueOf(this.b.d.a.compressTime)).addValueSafe("error_code", Integer.valueOf(this.b.a)).build());
    }
    CompressVideoTaskStep.b(this.b.d.b).d(this.b.d.a);
    if (CompressVideoTaskStep.c(this.b.d.b) != null) {
      CompressVideoTaskStep.c(this.b.d.b).a(1, bool, true, null);
    }
    this.b.d.b.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.CompressVideoTaskStep.1.1.1
 * JD-Core Version:    0.7.0.1
 */
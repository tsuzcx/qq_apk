package com.tencent.mobileqq.kandian.glue.viola.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IGetAllUploadStatusVideosCallback;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.RIJUgcVideoPublishManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

final class ViolaBizUtils$5
  implements IRIJUgcVideoPublishService.IGetAllUploadStatusVideosCallback
{
  ViolaBizUtils$5(String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, BridgeModule paramBridgeModule, int paramInt2, String paramString2) {}
  
  public void a(@NotNull List<UgcVideo> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localUgcVideo = (UgcVideo)localIterator.next();
      if (TextUtils.equals(localUgcVideo.seqId, this.a)) {
        break label45;
      }
    }
    UgcVideo localUgcVideo = null;
    label45:
    if (localUgcVideo != null)
    {
      PublicAccountReportUtils.a("0X800AC61", RIJUgcUtils.a(this.b, this.c, localUgcVideo.publicType).build());
      RIJUgcVideoPublishManager.a(this.b).b(localUgcVideo);
      ViolaBizUtils.a(this.d, this.e, paramList, this.f, 0, "");
      return;
    }
    ViolaBizUtils.a(this.d, this.e, paramList, this.f, -1, "ugcVideo not exist");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils.5
 * JD-Core Version:    0.7.0.1
 */
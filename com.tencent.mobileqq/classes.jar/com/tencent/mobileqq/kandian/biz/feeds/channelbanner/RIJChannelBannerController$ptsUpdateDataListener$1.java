package com.tencent.mobileqq.kandian.biz.feeds.channelbanner;

import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelBannerInfo;
import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "jsonData", "", "kotlin.jvm.PlatformType", "onDataUpdated"}, k=3, mv={1, 1, 16})
final class RIJChannelBannerController$ptsUpdateDataListener$1
  implements PTSComposer.IPTSUpdateDataListener
{
  RIJChannelBannerController$ptsUpdateDataListener$1(RIJChannelBannerController paramRIJChannelBannerController) {}
  
  public final void onDataUpdated(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onDataUpdated] jsonData = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("RIJChannelBannerController", 1, ((StringBuilder)localObject).toString());
    localObject = RIJChannelBannerController.c(this.a);
    if (localObject != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramString, "jsonData");
      ((ChannelBannerInfo)localObject).c(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelBannerController.ptsUpdateDataListener.1
 * JD-Core Version:    0.7.0.1
 */
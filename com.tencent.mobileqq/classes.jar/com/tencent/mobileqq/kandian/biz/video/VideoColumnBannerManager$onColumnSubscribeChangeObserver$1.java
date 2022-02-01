package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.mobileqq.kandian.biz.ugc.managecolumn.ColumnSubscribeChangeObserver;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/video/VideoColumnBannerManager$onColumnSubscribeChangeObserver$1", "Lcom/tencent/mobileqq/kandian/biz/ugc/managecolumn/ColumnSubscribeChangeObserver;", "onUgcColumnSubscribeStateChange", "", "columnId", "", "subscribeAction", "subscribeCount", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoColumnBannerManager$onColumnSubscribeChangeObserver$1
  extends ColumnSubscribeChangeObserver
{
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    if (paramInt2 != 1) {
      bool = false;
    }
    VideoColumnBannerManager.a(this.a, null, paramInt1, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoColumnBannerManager.onColumnSubscribeChangeObserver.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController.IWatchInfoCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VideoDynamicInsertController$requestControllInfo$1
  implements Runnable
{
  VideoDynamicInsertController$requestControllInfo$1(VideoDynamicInsertController paramVideoDynamicInsertController) {}
  
  public final void run()
  {
    QLog.d(this.this$0.a(), 1, "requestControllInfo preloadWatchInfoInMainFeeds");
    RIJFeedsDynamicInsertController localRIJFeedsDynamicInsertController = RIJFeedsDynamicInsertController.INSTANCE;
    Object localObject = this.this$0.a();
    if (localObject != null) {
      localObject = ((VideoPlayController)localObject).a();
    } else {
      localObject = null;
    }
    localRIJFeedsDynamicInsertController.preloadWatchInfoInMainFeeds((AbsBaseArticleInfo)localObject, 1, (RIJFeedsDynamicInsertController.IWatchInfoCallback)new VideoDynamicInsertController.requestControllInfo.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoDynamicInsertController.requestControllInfo.1
 * JD-Core Version:    0.7.0.1
 */
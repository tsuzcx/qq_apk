package com.tencent.mobileqq.kandian.biz.gifvideo.base.video;

import com.tencent.mobileqq.kandian.biz.pts.listeners.OnWeChatVideoWatchLaterClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoSeeLaterController;", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController$OnStateChangeListener;", "videoPlayController", "Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;", "(Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;)V", "getVideoPlayController", "()Lcom/tencent/mobileqq/kandian/biz/gifvideo/base/video/VideoPlayController;", "setVideoPlayController", "onStateChanged", "", "oldState", "", "newState", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoSeeLaterController
  implements VideoPlayController.OnStateChangeListener
{
  @Nullable
  private VideoPlayController a;
  
  public VideoSeeLaterController(@Nullable VideoPlayController paramVideoPlayController)
  {
    this.a = paramVideoPlayController;
    paramVideoPlayController = this.a;
    if (paramVideoPlayController != null) {
      paramVideoPlayController.a((VideoPlayController.OnStateChangeListener)this);
    }
  }
  
  public void onStateChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 8) && (paramInt2 != 9)) {
      return;
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((VideoPlayController)localObject).a();
      if (localObject != null)
      {
        long l1 = VideoDataManager.a.a(((AbsBaseArticleInfo)localObject).innerUniqueID);
        long l2 = 1000;
        OnWeChatVideoWatchLaterClickListener.a((AbsBaseArticleInfo)localObject, (int)(l1 / l2), (int)(VideoDataManager.a.b(((AbsBaseArticleInfo)localObject).innerUniqueID) / l2));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoSeeLaterController
 * JD-Core Version:    0.7.0.1
 */
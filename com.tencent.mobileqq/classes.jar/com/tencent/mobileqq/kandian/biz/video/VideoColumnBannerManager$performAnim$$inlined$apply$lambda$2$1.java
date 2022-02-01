package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.mobileqq.kandian.base.view.ReadInJoyLottieDrawable;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/mobileqq/kandian/biz/video/VideoColumnBannerManager$performAnim$columnTextTranslationAnim$1$2$onAnimationEnd$1"}, k=3, mv={1, 1, 16})
final class VideoColumnBannerManager$performAnim$$inlined$apply$lambda$2$1
  implements Runnable
{
  VideoColumnBannerManager$performAnim$$inlined$apply$lambda$2$1(VideoColumnBannerManager.performAnim..inlined.apply.lambda.2 param2) {}
  
  public final void run()
  {
    ReadInJoyLottieDrawable localReadInJoyLottieDrawable = VideoColumnBannerManager.a(this.this$0.a);
    if (localReadInJoyLottieDrawable != null) {
      localReadInJoyLottieDrawable.setRepeatCount(0);
    }
    localReadInJoyLottieDrawable = VideoColumnBannerManager.a(this.this$0.a);
    if (localReadInJoyLottieDrawable != null) {
      localReadInJoyLottieDrawable.playAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoColumnBannerManager.performAnim..inlined.apply.lambda.2.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJVideoViewInterceptor$preloadData$1
  implements Runnable
{
  RIJVideoViewInterceptor$preloadData$1(RIJVideoViewInterceptor paramRIJVideoViewInterceptor, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public final void run()
  {
    try
    {
      RIJVideoViewInterceptor.a(this.this$0, this.a);
      RIJVideoViewInterceptor.b(this.this$0, this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("RIJVideoViewInterceptor", 1, "innerPreloadAvatar exception", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.RIJVideoViewInterceptor.preloadData.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.pts.view;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import mqq.os.MqqHandler;

class ReadInJoySocializeRecommendFollowView$10
  extends ReadInJoyObserver
{
  ReadInJoySocializeRecommendFollowView$10(ReadInJoySocializeRecommendFollowView paramReadInJoySocializeRecommendFollowView) {}
  
  public void a(long paramLong, boolean paramBoolean)
  {
    ReadInJoySocializeRecommendFollowView.10.1 local1 = new ReadInJoySocializeRecommendFollowView.10.1(this, paramLong, paramBoolean);
    int i;
    if (Looper.getMainLooper() == Looper.myLooper()) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      ThreadManager.getUIHandler().post(local1);
      return;
    }
    local1.run();
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    paramAbsBaseArticleInfo = new ReadInJoySocializeRecommendFollowView.10.2(this, paramAbsBaseArticleInfo, paramBoolean);
    int i;
    if (Looper.getMainLooper() == Looper.myLooper()) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      ThreadManager.getUIHandler().post(paramAbsBaseArticleInfo);
      return;
    }
    paramAbsBaseArticleInfo.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoySocializeRecommendFollowView.10
 * JD-Core Version:    0.7.0.1
 */
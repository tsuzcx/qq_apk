package com.tencent.mobileqq.kandian.biz.common;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher.ForEachObserverJob;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

final class ReadInJoyUtils$2
  implements ReadInJoyLogicEngineEventDispatcher.ForEachObserverJob
{
  ReadInJoyUtils$2(boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo, float[] paramArrayOfFloat) {}
  
  public void a(ReadInJoyObserver paramReadInJoyObserver)
  {
    paramReadInJoyObserver.a(101, this.a, new Object[] { this.b, Float.valueOf(this.c[0]), Float.valueOf(this.c[1]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils.2
 * JD-Core Version:    0.7.0.1
 */
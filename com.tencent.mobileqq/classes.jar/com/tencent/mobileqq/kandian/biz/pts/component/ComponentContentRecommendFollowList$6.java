package com.tencent.mobileqq.kandian.biz.pts.component;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import mqq.os.MqqHandler;

class ComponentContentRecommendFollowList$6
  extends ReadInJoyObserver
{
  ComponentContentRecommendFollowList$6(ComponentContentRecommendFollowList paramComponentContentRecommendFollowList) {}
  
  public void a(long paramLong, boolean paramBoolean)
  {
    ComponentContentRecommendFollowList.6.1 local1 = new ComponentContentRecommendFollowList.6.1(this, paramLong, paramBoolean);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowList.6
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.pts.component;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import mqq.os.MqqHandler;

class ComponentContentRecommendFollowGroup$4
  extends ReadInJoyObserver
{
  ComponentContentRecommendFollowGroup$4(ComponentContentRecommendFollowGroup paramComponentContentRecommendFollowGroup) {}
  
  public void a(long paramLong, boolean paramBoolean)
  {
    ComponentContentRecommendFollowGroup.4.1 local1 = new ComponentContentRecommendFollowGroup.4.1(this, paramLong, paramBoolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommendFollowGroup.4
 * JD-Core Version:    0.7.0.1
 */
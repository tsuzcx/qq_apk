package com.tencent.mobileqq.troop.recommend;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import mqq.os.MqqHandler;

class RecommendTroopListWrapper$2
  extends TroopMngObserver
{
  RecommendTroopListWrapper$2(RecommendTroopListWrapper paramRecommendTroopListWrapper) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (1 == paramInt1) {
      ThreadManager.getUIHandler().post(new RecommendTroopListWrapper.2.1(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.recommend.RecommendTroopListWrapper.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.multicard;

import com.tencent.mobileqq.multicard.manager.TroopMemberRecommendObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

class MultiCardRecommendFragment$3
  extends TroopMemberRecommendObserver
{
  MultiCardRecommendFragment$3(MultiCardRecommendFragment paramMultiCardRecommendFragment) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt, Map<Integer, List<RecommendPerson>> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopMemberRecommend.MultiCardRecommendFragment", 2, "onGetTroopMemRecommendCards, success = " + paramBoolean + ",troopUin = " + paramString + ",notifySource = " + paramInt);
    }
    if ((MultiCardRecommendFragment.a(this.a) != null) && (MultiCardRecommendFragment.a(this.a).equals(paramString)))
    {
      MultiCardRecommendFragment.a(this.a).a.clear();
      MultiCardRecommendFragment.a(this.a).a.putAll(paramMap);
      this.a.a.removeMessages(1);
      this.a.a.sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardRecommendFragment.3
 * JD-Core Version:    0.7.0.1
 */
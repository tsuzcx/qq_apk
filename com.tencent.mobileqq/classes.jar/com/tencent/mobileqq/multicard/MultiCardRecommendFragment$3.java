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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetTroopMemRecommendCards, success = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",troopUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",notifySource = ");
      localStringBuilder.append(paramInt);
      QLog.i("TroopMemberRecommend.MultiCardRecommendFragment", 2, localStringBuilder.toString());
    }
    if ((MultiCardRecommendFragment.a(this.a) != null) && (MultiCardRecommendFragment.f(this.a).equals(paramString)))
    {
      MultiCardRecommendFragment.a(this.a).a.clear();
      MultiCardRecommendFragment.a(this.a).a.putAll(paramMap);
      this.a.d.removeMessages(1);
      this.a.d.sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardRecommendFragment.3
 * JD-Core Version:    0.7.0.1
 */
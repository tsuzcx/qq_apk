package com.tencent.mobileqq.multicard;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class MultiCardRecommendFragment$4
  extends TroopObserver
{
  MultiCardRecommendFragment$4(MultiCardRecommendFragment paramMultiCardRecommendFragment) {}
  
  public void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.MultiCardRecommendFragment", 2, "onUpdateTroopGetMemberList（） troopUin =  " + paramString);
    }
    if ((paramInt1 == 9) && (paramString.equals(MultiCardRecommendFragment.a(this.a))) && (this.a.a != null)) {
      this.a.a.sendEmptyMessage(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardRecommendFragment.4
 * JD-Core Version:    0.7.0.1
 */
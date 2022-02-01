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
  
  protected void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("onUpdateTroopGetMemberList（） troopUin =  ");
      paramList.append(paramString);
      QLog.d("TroopMemberRecommend.MultiCardRecommendFragment", 2, paramList.toString());
    }
    if ((paramInt1 == 9) && (paramString.equals(MultiCardRecommendFragment.f(this.a))) && (this.a.d != null)) {
      this.a.d.sendEmptyMessage(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardRecommendFragment.4
 * JD-Core Version:    0.7.0.1
 */
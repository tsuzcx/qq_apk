package com.tencent.mobileqq.selectmember;

import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.qphone.base.util.QLog;

class TroopDiscussionTroop$2
  extends AutomatorObserver
{
  TroopDiscussionTroop$2(TroopDiscussionTroop paramTroopDiscussionTroop) {}
  
  protected void a(int paramInt)
  {
    if (paramInt != 2) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCacheInited ");
      localStringBuilder.append(paramInt);
      QLog.d("TroopDiscussionTroop", 2, localStringBuilder.toString());
    }
    if (TroopDiscussionTroop.a(this.a) != null) {
      TroopDiscussionTroop.a(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopDiscussionTroop.2
 * JD-Core Version:    0.7.0.1
 */
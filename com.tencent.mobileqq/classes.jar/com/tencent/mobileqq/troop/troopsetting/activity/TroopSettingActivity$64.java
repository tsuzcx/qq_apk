package com.tencent.mobileqq.troop.troopsetting.activity;

import com.tencent.mobileqq.apollo.handler.IApolloExtensionObserver;
import com.tencent.qphone.base.util.QLog;

class TroopSettingActivity$64
  implements IApolloExtensionObserver
{
  TroopSettingActivity$64(TroopSettingActivity paramTroopSettingActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("onGetMyTroopEffect  result = ");
      paramObject.append(paramBoolean);
      QLog.d("Q.chatopttroop", 2, paramObject.toString());
    }
    if (paramBoolean) {
      this.a.a(true);
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 26) {
      a(paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.64
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.troop.troopsetting.activity;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class TroopSettingActivity$ClearChatRecordTask
  implements Runnable
{
  WeakReference<TroopSettingActivity> a;
  
  public TroopSettingActivity$ClearChatRecordTask(TroopSettingActivity paramTroopSettingActivity)
  {
    this.a = new WeakReference(paramTroopSettingActivity);
  }
  
  public void run()
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return;
    }
    localObject1 = (TroopSettingActivity)((WeakReference)localObject1).get();
    if (localObject1 == null) {
      return;
    }
    try
    {
      if (((TroopSettingActivity)localObject1).c) {
        return;
      }
      AppInterface localAppInterface = TroopSettingActivity.a((TroopSettingActivity)localObject1);
      localObject2 = ((TroopSettingActivity)localObject1).jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
      new StringBuilder();
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).clearChatRecordTaskRun(localAppInterface, (String)localObject2, "Q.chatopttroop", ((TroopSettingActivity)localObject1).jdField_a_of_type_AndroidOsHandler, 18);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("msg history clear,  IllegalStateException");
        ((StringBuilder)localObject2).append(localIllegalStateException.toString());
        QLog.e("Q.chatopttroop", 2, ((StringBuilder)localObject2).toString());
      }
    }
    ThreadManager.getUIHandler().post(new TroopSettingActivity.ClearChatRecordTask.1(this, (TroopSettingActivity)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.ClearChatRecordTask
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.troop.troopsetting.activity;

import android.text.TextUtils;
import android.widget.Button;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TroopSettingActivity$36
  extends TroopMngObserver
{
  TroopSettingActivity$36(TroopSettingActivity paramTroopSettingActivity) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      boolean bool = false;
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData != null) {
        bool = true;
      }
      QLog.d("Q.chatopttroop", 2, new Object[] { "onTroopManagerFailed. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", hasTroopInfoData=", Boolean.valueOf(bool) });
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData == null) {
      return;
    }
    if ((1 == paramInt1) && ((this.a.isResume()) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption == 1)))
    {
      this.a.n();
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).handleJoinTroopFailed(this.a, paramInt2);
      this.a.jdField_a_of_type_JavaLangString = null;
      return;
    }
    if ((this.a.isResume()) && ((paramInt1 == 2) || (paramInt1 == 9)))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null)
      {
        TroopSettingActivity localTroopSettingActivity = this.a;
        localTroopSettingActivity.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(localTroopSettingActivity);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131692085, 1500);
      this.a.finish();
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      boolean bool = false;
      String str;
      if (TextUtils.isEmpty(paramString)) {
        str = "";
      } else {
        str = paramString;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData != null) {
        bool = true;
      }
      QLog.d("Q.chatopttroop", 2, new Object[] { "onTroopManagerSuccess. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", troopUin=", str, ", hasTroopInfoData=", Boolean.valueOf(bool) });
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData == null) {
      return;
    }
    if ((1 == paramInt1) && ((this.a.isResume()) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption == 1)))
    {
      TroopSettingActivity.a(this.a, paramInt2, paramString);
      return;
    }
    if (this.a.isResume())
    {
      if (paramInt1 == 3)
      {
        TroopSettingActivity.a(this.a, paramInt1, paramInt2);
        return;
      }
      if ((paramInt1 == 2) || (paramInt1 == 9)) {
        TroopSettingActivity.b(this.a, paramInt1, paramInt2);
      }
    }
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, String.format("onGetAddTroopWebInfo url=%s", new Object[] { paramString }));
    }
    if (!this.a.isResume()) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.a, 2, 2131718221, 1).b(this.a.getTitleBarHeight());
    }
    else
    {
      IChatSettingForTroopApi localIChatSettingForTroopApi = (IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class);
      TroopSettingActivity localTroopSettingActivity = this.a;
      localIChatSettingForTroopApi.openAddTroopWeb(localTroopSettingActivity, paramString, localTroopSettingActivity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      this.a.overridePendingTransition(2130772011, 2130772004);
    }
    this.a.finish();
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    this.a.n();
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData == null) {
      return;
    }
    if (paramLong != Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin)) {
      return;
    }
    if (paramBoolean)
    {
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      }
      if (paramTroopInfo.isOnlyTroopMemberInviteOption())
      {
        this.a.a(2131719924, 0);
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption = ((short)(byte)paramTroopInfo.cGroupOption);
      if (!this.a.isResume())
      {
        if (QLog.isColorLevel()) {
          QLog.d("qqBaseActivity", 2, "ChatSettingForTroop onSend0x88d_1_forJoinTroop_Ret return----------------");
        }
        return;
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isHomeworkTroop()) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption != 3))
      {
        TroopSettingActivity.d(this.a, 2);
        return;
      }
      TroopSettingActivity.b(this.a, null);
      return;
    }
    this.a.a(2131718739, 1);
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if ((paramBoolean) && (paramInt == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin)))
    {
      if (!this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin.equals(String.valueOf(paramLong))) {
        return;
      }
      if (this.a.c != null) {
        this.a.c.setText(2131716747);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.36
 * JD-Core Version:    0.7.0.1
 */
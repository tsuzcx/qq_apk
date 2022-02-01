package com.tencent.mobileqq.troop.troopsetting.activity;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopSettingActivity$30
  extends TroopModifyObserver
{
  TroopSettingActivity$30(TroopSettingActivity paramTroopSettingActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData == null) {
      return;
    }
    if (!Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, String.valueOf(paramLong))) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onModifyTroopInfo isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",mModifyList = ");
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_JavaUtilList);
      QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))))
    {
      this.a.jdField_a_of_type_JavaUtilList.remove(Integer.valueOf(paramInt));
      if (paramTroopInfo != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null)
      {
        paramTroopInfo = this.a;
        paramTroopInfo.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(paramTroopInfo);
      }
      if (paramBoolean)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(1, this.a.getString(2131693391), 1000);
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, this.a.getString(2131693390), 1000);
      TroopSettingActivity.c(this.a, paramInt);
      return;
    }
    if ((paramBoolean) && (paramTroopInfo != null))
    {
      localObject = this.a;
      ((TroopSettingActivity)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
      if ((((TroopSettingActivity)localObject).jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.size() == 0))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.updateForTroopInfo(paramTroopInfo, TroopSettingActivity.a(this.a).getCurrentAccountUin());
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "onModifyTroopInfo send MSG_UPDATE_INFO msg");
        }
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, paramString)) && (paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "onUpdateTroopSearchApproachPageTroopInfoUpdated ");
      }
      this.a.l();
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super.a(paramBoolean, paramString1, paramString2, paramString3, paramInt);
    if (TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, paramString1))
    {
      this.a.n();
      if (paramBoolean)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopName = true;
        this.a.a(paramString2);
        if ((this.a.isResume()) && (this.a.e))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop = false;
          paramString1 = this.a;
          paramString1.e = false;
          TroopSettingActivity.a(paramString1, paramString1.d ^ true, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop);
        }
      }
      else
      {
        if (paramInt == 1328) {
          TroopSettingActivity.o(this.a);
        }
        paramString1 = paramString3;
        if (TextUtils.isEmpty(paramString3)) {
          paramString1 = HardCodeUtil.a(2131701959);
        }
        QQToast.a(this.a, 1, paramString1, 0).b(this.a.getTitleBarHeight());
        if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopDisplayName();
          this.a.e();
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, paramString1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.30
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.troop.troopCard;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.mobileqq.troop.api.essence.ITroopEssenceService;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

class VisitorTroopCardFragment$11
  extends TroopBusinessObserver
{
  VisitorTroopCardFragment$11(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  public void onGetEssenceSwitchForShowInTroopCard(boolean paramBoolean, String paramString, TroopInfo paramTroopInfo)
  {
    if ((!paramBoolean) || (!TextUtils.equals(paramString, VisitorTroopCardFragment.a(this.a)))) {}
    do
    {
      do
      {
        return;
      } while ((paramTroopInfo == null) || (paramTroopInfo.mTroopInfoExtObj.essenceSwitch != 1));
      paramString = (ITroopEssenceService)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopEssenceService.class, "");
    } while (paramString == null);
    paramString.getEssenceMsgList(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1);
  }
  
  public void onQueryJoinTroopCanNoVerify(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    if (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VisitorTroopCardFragment.Activity", 2, "onQueryJoinTroopCanNoVerify result:" + paramBoolean);
      }
    } while (VisitorTroopCardFragment.a(this.a, paramBoolean, paramInt2));
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorTroopCardFragment.Activity", 2, "onQueryJoinTroopCanNoVerify noVerify:" + paramInt1);
      }
      this.a.b = paramInt1;
      this.a.c = paramInt2;
      if ((this.a.b == 1) && (paramInt2 == 0))
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop())
        {
          if (QLog.isColorLevel()) {
            QLog.d("VisitorTroopCardFragment.Activity", 2, "onQueryJoinTroopCanNoVerify isHomeworkTroop true");
          }
          this.a.b(1);
          return;
        }
        this.a.e();
        return;
      }
      VisitorTroopCardFragment.b(this.a);
      return;
    }
    VisitorTroopCardFragment.b(this.a);
  }
  
  public void onQueryJoinTroopWhetherHighRisk(boolean paramBoolean, String paramString, int paramInt)
  {
    if (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VisitorTroopCardFragment.Activity", 2, "onQueryJoinTroopCanNoVerify result:" + paramBoolean + "highRiskTroop" + paramInt);
      }
    } while (VisitorTroopCardFragment.a(this.a, paramBoolean, paramInt));
    if (paramBoolean) {}
    for (this.a.c = paramInt;; this.a.c = 0)
    {
      VisitorTroopCardFragment.b(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.11
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.troop.troopcard;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class TroopMoreDetailFragment$2
  extends TroopObserver
{
  TroopMoreDetailFragment$2(TroopMoreDetailFragment paramTroopMoreDetailFragment) {}
  
  protected void onGetTroopTagResult(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin)) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin.equals(paramString1)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTags = TroopInfo.getTags(paramString2);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView.setTroopInfoData(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView.b();
    }
  }
  
  protected void onOIDB0X899_1_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    super.onOIDB0X899_1_Ret(paramBoolean, paramLong1, paramInt1, paramList, paramLong2, paramInt2, paramString);
    if ((!this.a.c) && (TextUtils.equals(this.a.jdField_a_of_type_JavaLangString, String.valueOf(paramLong1))))
    {
      if (paramInt1 != 2) {
        return;
      }
      if (paramBoolean)
      {
        if ((paramList != null) && (!paramList.isEmpty()) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView != null)) {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView.a(paramList);
        }
      }
      else if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("onOIDB0X899_0_Ret, result = ");
        paramList.append(paramInt2);
        paramList.append("strErrorMsg = ");
        paramList.append(paramString);
        QLog.e("TroopMoreDetailFragment", 2, paramList.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopMoreDetailFragment.2
 * JD-Core Version:    0.7.0.1
 */
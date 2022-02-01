package com.tencent.mobileqq.troop.fragment;

import android.text.TextUtils;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class TroopMoreDetailFragment$2
  extends TroopBusinessObserver
{
  TroopMoreDetailFragment$2(TroopMoreDetailFragment paramTroopMoreDetailFragment) {}
  
  public void onGetTroopTagResult(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin.equals(paramString1)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = TroopInfo.getTags(paramString2);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.setTroopInfoData(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.b();
    }
  }
  
  public void onOIDB0X899_1_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    super.onOIDB0X899_1_Ret(paramBoolean, paramLong1, paramInt1, paramList, paramLong2, paramInt2, paramString);
    if ((this.a.b) || (!TextUtils.equals(this.a.jdField_a_of_type_JavaLangString, String.valueOf(paramLong1))) || (paramInt1 != 2)) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while ((paramList == null) || (paramList.isEmpty()) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView == null));
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.a(paramList);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("TroopMoreDetailFragment", 2, "onOIDB0X899_0_Ret, result = " + paramInt2 + "strErrorMsg = " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.fragment.TroopMoreDetailFragment.2
 * JD-Core Version:    0.7.0.1
 */
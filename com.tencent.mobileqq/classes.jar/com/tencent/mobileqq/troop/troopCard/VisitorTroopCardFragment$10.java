package com.tencent.mobileqq.troop.troopCard;

import com.tencent.mobileqq.troop.api.essence.data.TroopCardEssenceMsg;
import com.tencent.mobileqq.troop.observer.TroopApiObserver;
import com.tencent.mobileqq.troop.widget.TroopEssenceMsgView;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class VisitorTroopCardFragment$10
  extends TroopApiObserver
{
  VisitorTroopCardFragment$10(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, List<TroopCardEssenceMsg> paramList, int paramInt2)
  {
    int i;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onGetTroopEssenceMsgList troopUin = ").append(paramString).append(",source = ").append(paramInt1).append(", isSuccess = ").append(paramBoolean).append(",msgList size = ");
      if (paramList != null)
      {
        i = paramList.size();
        QLog.d("VisitorTroopCardFragment.Activity", 2, i + ",totalNum = " + paramInt2);
      }
    }
    else
    {
      if ((paramString != null) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) && (paramBoolean) && (paramInt1 == 1)) {
        break label160;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VisitorTroopCardFragment.Activity", 2, "onGetTroopEssenceMsgList mTroopEssenceMsgView  GONE");
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopEssenceMsgView != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopEssenceMsgView.setVisibility(8);
      }
    }
    label160:
    while (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopEssenceMsgView == null)
    {
      return;
      i = 0;
      break;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopEssenceMsgView.a(paramList, paramInt2, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.10
 * JD-Core Version:    0.7.0.1
 */
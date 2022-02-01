package com.tencent.mobileqq.troop.troopcard.ui;

import com.tencent.mobileqq.troop.association.api.TroopAssociationObserver;
import com.tencent.mobileqq.troop.association.data.AllianceItem;
import com.tencent.qphone.base.util.QLog;

class TroopAssociationsListWrapper$1
  extends TroopAssociationObserver
{
  TroopAssociationsListWrapper$1(TroopAssociationsListWrapper paramTroopAssociationsListWrapper) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, long paramLong, AllianceItem paramAllianceItem)
  {
    if (paramAllianceItem == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAssociationsListWrapper", 1, "TroopAssociationsListWrapper onGetRelatedTroopList: allianceItem is null");
      }
      this.a.a(paramBoolean, paramString, paramInt, null, 0, null, paramLong);
      return;
    }
    this.a.a(paramBoolean, paramString, paramInt, paramAllianceItem.nextTroopUin, paramAllianceItem.associatedTroopCount, paramAllianceItem.associatedTroopList, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopAssociationsListWrapper.1
 * JD-Core Version:    0.7.0.1
 */
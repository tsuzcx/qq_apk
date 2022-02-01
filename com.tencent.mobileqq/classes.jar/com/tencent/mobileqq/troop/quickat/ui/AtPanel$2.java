package com.tencent.mobileqq.troop.quickat.ui;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AtPanel$2
  extends TroopObserver
{
  AtPanel$2(AtPanel paramAtPanel) {}
  
  public void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, "onUpdateTroopGetMemberList troopUin=" + paramString + " isSuccess=" + paramBoolean + " reqType=" + paramInt1 + " type" + paramInt2 + " reqTimestamp=" + paramLong);
    }
    if (paramInt1 != 2) {}
    do
    {
      return;
      if ((paramString != null) && (paramString.equals(AtPanel.a(this.a).a))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AtPanel", 2, " onUpdateTroopGetMemberList troopUin =" + paramString + " mSession.troopUin=" + AtPanel.a(this.a).a);
    return;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append(" onUpdateTroopGetMemberList troopMemberInfoList =");
        if (paramList != null) {
          break label224;
        }
      }
      label224:
      for (paramInt1 = 0;; paramInt1 = paramList.size())
      {
        QLog.d("AtPanel", 2, paramInt1);
        if (AtPanel.a(this.a) != null) {
          break label235;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AtPanel", 2, " onUpdateTroopGetMemberList mPopupWindow = null");
        return;
      }
      label235:
      AtPanel.a(this.a).a(0, 2131689914);
      return;
    }
    AtPanel.a(this.a).a(paramList);
    AtPanel.a(this.a).a(AtPanel.a(this.a), AtPanel.a(this.a), AtPanel.a(this.a).G());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AtPanel.2
 * JD-Core Version:    0.7.0.1
 */
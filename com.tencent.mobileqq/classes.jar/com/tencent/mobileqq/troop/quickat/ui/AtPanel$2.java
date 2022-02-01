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
  
  protected void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("onUpdateTroopGetMemberList troopUin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" reqType=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" type");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" reqTimestamp=");
      localStringBuilder.append(paramLong);
      QLog.d("AtPanel", 2, localStringBuilder.toString());
    }
    if (paramInt1 != 2) {
      return;
    }
    if ((paramString != null) && (paramString.equals(AtPanel.a(this.a).b)))
    {
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        AtPanel.c(this.a).a(paramList);
        AtPanel.c(this.a).a(AtPanel.d(this.a), AtPanel.e(this.a), AtPanel.f(this.a).bG());
        return;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append(" onUpdateTroopGetMemberList troopMemberInfoList =");
        if (paramList == null) {
          paramInt1 = 0;
        } else {
          paramInt1 = paramList.size();
        }
        paramString.append(paramInt1);
        QLog.d("AtPanel", 2, paramString.toString());
      }
      if (AtPanel.b(this.a) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AtPanel", 2, " onUpdateTroopGetMemberList mPopupWindow = null");
        }
        return;
      }
      AtPanel.b(this.a).a(0, 2131886469);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append(" onUpdateTroopGetMemberList troopUin =");
      paramList.append(paramString);
      paramList.append(" mSession.troopUin=");
      paramList.append(AtPanel.a(this.a).b);
      QLog.d("AtPanel", 2, paramList.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AtPanel.2
 * JD-Core Version:    0.7.0.1
 */
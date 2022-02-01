package com.tencent.mobileqq.troop.troopnotification;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.utils.TroopNotifyHelper;
import com.tencent.mobileqq.troop.widget.SlideAndOverScrollRecyclerView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.StructMsg;

class TroopNotificationFragment$24$1
  implements View.OnClickListener
{
  TroopNotificationFragment$24$1(TroopNotificationFragment.24 param24) {}
  
  public void onClick(View paramView)
  {
    if (paramView != null)
    {
      if (TroopNotificationFragment.a(this.a.a) != null) {
        TroopNotificationFragment.a(this.a.a).a();
      }
      if (!Utils.a("tag_swip_icon_menu_item", paramView.getTag()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopNotificationFragment", 2, "handleDeleteItem|onClick tag is not int");
        }
      }
      else
      {
        Object localObject1 = paramView.getTag(-1);
        Object localObject2 = paramView.getTag(-2);
        if (((localObject1 instanceof Integer)) && ((localObject2 instanceof Integer)))
        {
          int i = ((Integer)localObject1).intValue();
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("handleDeleteItem|onClick position = ");
            ((StringBuilder)localObject1).append(i);
            QLog.i("TroopNotificationFragment", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = TroopNotificationFragment.24.a(this.a, i);
          if ((localObject1 instanceof MessageRecord))
          {
            localObject1 = (MessageRecord)localObject1;
            localObject2 = ((MessageForSystemMsg)localObject1).getSystemMsg();
            if (localObject2 != null)
            {
              TroopNotifyHelper.a((structmsg.StructMsg)localObject2, ((MessageRecord)localObject1).uniseq, AppConstants.TROOP_SUSPICIOUS_MSG_UIN);
              this.a.a.a.sendEmptyMessage(1017);
              TroopNotifyHelper.a((structmsg.StructMsg)localObject2, (AppInterface)TroopNotificationFragment.a(this.a.a), true);
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.i("TroopNotificationFragment", 2, "handleDeleteItem|onClick posTag or subTag is not int");
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment.24.1
 * JD-Core Version:    0.7.0.1
 */
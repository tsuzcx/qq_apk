package com.tencent.mobileqq.troop.troopnotification.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.troopnotification.adapter.NotifyAndRecAdapter.ViewHolder;
import com.tencent.mobileqq.troop.troopnotification.generalgroupnotifyparser.AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.StructMsg;

class TroopNotificationFragment$8
  implements View.OnClickListener
{
  TroopNotificationFragment$8(TroopNotificationFragment paramTroopNotificationFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof NotifyAndRecAdapter.ViewHolder))
    {
      Object localObject1 = (NotifyAndRecAdapter.ViewHolder)paramView.getTag();
      if (((NotifyAndRecAdapter.ViewHolder)localObject1).r.msg_type.get() == 2)
      {
        this.a.a((NotifyAndRecAdapter.ViewHolder)localObject1);
        Object localObject2;
        if (((NotifyAndRecAdapter.ViewHolder)localObject1).b == 82)
        {
          localObject2 = TroopNotificationFragment.f(this.a);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((NotifyAndRecAdapter.ViewHolder)localObject1).r.req_uin.get());
          localStringBuilder.append("");
          ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_public", "", "oper", "Clk_notice", 0, 0, "", "", "", localStringBuilder.toString());
        }
        if (((NotifyAndRecAdapter.ViewHolder)localObject1).b == 91)
        {
          long l2 = 0L;
          if ((((NotifyAndRecAdapter.ViewHolder)localObject1).u instanceof AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo))
          {
            localObject1 = (AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)((NotifyAndRecAdapter.ViewHolder)localObject1).u;
            localObject2 = (ITroopInfoService)TroopNotificationFragment.f(this.a).getRuntimeService(ITroopInfoService.class, "");
            long l1 = l2;
            if (localObject2 != null)
            {
              localObject2 = ((ITroopInfoService)localObject2).findTroopInfo(String.valueOf(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject1).j));
              l1 = l2;
              if (localObject2 != null) {
                l1 = ((TroopInfo)localObject2).dwGroupClassExt;
              }
            }
            ReportController.b(null, "dc00898", "", String.valueOf(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject1).j), "0X800B4B4", "0X800B4B4", 0, 0, String.valueOf(l1), "", "", "");
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.8
 * JD-Core Version:    0.7.0.1
 */
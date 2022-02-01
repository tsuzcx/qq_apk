package com.tencent.mobileqq.troop.troopnotification.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IRecommendTroopService;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.utils.RecommendTroopUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class NotifyAndRecAdapter$4
  implements View.OnClickListener
{
  NotifyAndRecAdapter$4(NotifyAndRecAdapter paramNotifyAndRecAdapter) {}
  
  public void onClick(View paramView)
  {
    RecommendTroopItem localRecommendTroopItem = (RecommendTroopItem)paramView.getTag(-1);
    if ((localRecommendTroopItem != null) && (!TextUtils.isEmpty(localRecommendTroopItem.uin)))
    {
      RecommendTroopUtils.a(this.a.e, 2, localRecommendTroopItem.uin, new NotifyAndRecAdapter.4.1(this));
      this.a.b.remove(localRecommendTroopItem);
      this.a.notifyDataSetChanged();
      if ((this.a.b != null) && (this.a.b.size() == 0)) {
        NotifyAndRecAdapter.c(this.a).sendEmptyMessage(1018);
      }
      if (NotifyAndRecAdapter.a(this.a) != null)
      {
        IRecommendTroopService localIRecommendTroopService = (IRecommendTroopService)NotifyAndRecAdapter.a(this.a).getRuntimeService(IRecommendTroopService.class, "");
        if (localIRecommendTroopService != null)
        {
          if ((this.a.b != null) && (this.a.b.size() == 0)) {
            localIRecommendTroopService.updateDBStatsus(1);
          }
          localIRecommendTroopService.delRecommendTroopFromMsg(localRecommendTroopItem.uin);
        }
      }
      ReportController.b(null, "P_CliOper", "Grp_recom", "", "msg_page", "Clk_unlike", 0, 0, localRecommendTroopItem.uin, "", "", "");
    }
    else
    {
      QLog.d("NotifyAndRecAdapter", 2, "del troop but troop is empty");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.adapter.NotifyAndRecAdapter.4
 * JD-Core Version:    0.7.0.1
 */
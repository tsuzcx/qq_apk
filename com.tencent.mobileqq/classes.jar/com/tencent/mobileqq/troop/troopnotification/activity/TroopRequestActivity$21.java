package com.tencent.mobileqq.troop.troopnotification.activity;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.stranger.api.IStrangerService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class TroopRequestActivity$21
  implements View.OnClickListener
{
  TroopRequestActivity$21(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (!TextUtils.isEmpty(this.a.e)) {
        localArrayList.add(Long.valueOf(Long.parseLong(this.a.e)));
      }
      IStrangerService localIStrangerService = (IStrangerService)TroopRequestActivity.a(this.a).getRuntimeService(IStrangerService.class, "all");
      if (localIStrangerService != null) {
        localIStrangerService.deleteStrangers(localArrayList);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.TroopRequestActivity", 2, "delete Stranger parseLong() error", localNumberFormatException);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.21
 * JD-Core Version:    0.7.0.1
 */
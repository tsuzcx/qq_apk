package com.tencent.mobileqq.troop.troopcard.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.essence.data.TroopCardEssenceMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopEssenceMsgView$1
  implements View.OnClickListener
{
  TroopEssenceMsgView$1(TroopEssenceMsgView paramTroopEssenceMsgView, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (paramView != null)
    {
      Object localObject = paramView.getTag();
      if ((localObject instanceof TroopCardEssenceMsg))
      {
        localObject = (TroopCardEssenceMsg)localObject;
        TroopEssenceMsgView.a(this.b, ((TroopCardEssenceMsg)localObject).jumpUrl);
        String str = ((TroopCardEssenceMsg)localObject).troopUin;
        if (!TextUtils.isEmpty(str))
        {
          if (this.a) {
            localObject = "1";
          } else {
            localObject = "2";
          }
          ReportController.b(null, "dc00899", "grpProfile", "", "pin", "click", 0, 0, str, (String)localObject, "", "");
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopEssenceMsgView.1
 * JD-Core Version:    0.7.0.1
 */
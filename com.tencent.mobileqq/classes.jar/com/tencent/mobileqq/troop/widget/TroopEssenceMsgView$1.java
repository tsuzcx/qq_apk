package com.tencent.mobileqq.troop.widget;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.essence.data.TroopCardEssenceMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopEssenceMsgView$1
  implements View.OnClickListener
{
  TroopEssenceMsgView$1(TroopEssenceMsgView paramTroopEssenceMsgView, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    String str;
    if (paramView != null)
    {
      localObject = paramView.getTag();
      if ((localObject instanceof TroopCardEssenceMsg))
      {
        localObject = (TroopCardEssenceMsg)localObject;
        TroopEssenceMsgView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopEssenceMsgView, ((TroopCardEssenceMsg)localObject).jumpUrl);
        str = ((TroopCardEssenceMsg)localObject).troopUin;
        if (!TextUtils.isEmpty(str)) {
          if (!this.jdField_a_of_type_Boolean) {
            break label84;
          }
        }
      }
    }
    label84:
    for (Object localObject = "1";; localObject = "2")
    {
      ReportController.b(null, "dc00899", "grpProfile", "", "pin", "click", 0, 0, str, (String)localObject, "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopEssenceMsgView.1
 * JD-Core Version:    0.7.0.1
 */
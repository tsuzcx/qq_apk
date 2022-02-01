package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class NearbyProfileDisplayTribePanel$16
  implements View.OnClickListener
{
  NearbyProfileDisplayTribePanel$16(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onClick(View paramView)
  {
    ActionSheet localActionSheet = ActionSheet.create(this.a.a);
    localActionSheet.addButton(2131717811, 1);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new NearbyProfileDisplayTribePanel.16.1(this, localActionSheet));
    localActionSheet.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.16
 * JD-Core Version:    0.7.0.1
 */
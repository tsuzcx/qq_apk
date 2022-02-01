package com.tencent.mobileqq.troop.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

class TroopAvatarWallPreviewActivity$32
  implements View.OnClickListener
{
  TroopAvatarWallPreviewActivity$32(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131427966)
    {
      if (i != 2131431689)
      {
        if (i == 2131439700) {
          TroopAvatarWallPreviewActivity.access$2100(this.a);
        }
      }
      else
      {
        ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.a, null);
        localActionSheet.addButton(2131890801, 3);
        localActionSheet.addCancelButton(2131887648);
        localActionSheet.setOnButtonClickListener(new TroopAvatarWallPreviewActivity.32.1(this, localActionSheet));
        localActionSheet.show();
      }
    }
    else {
      TroopAvatarWallPreviewActivity.access$800(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.32
 * JD-Core Version:    0.7.0.1
 */
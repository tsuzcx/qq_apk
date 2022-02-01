package com.tencent.mobileqq.troop.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

class TroopAvatarWallPreviewActivity$24
  implements View.OnClickListener
{
  TroopAvatarWallPreviewActivity$24(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362366)
    {
      if (i != 2131365474)
      {
        if (i == 2131372200) {
          TroopAvatarWallPreviewActivity.access$1700(this.a);
        }
      }
      else
      {
        ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.a, null);
        localActionSheet.addButton(2131693253, 3);
        localActionSheet.addCancelButton(2131690728);
        localActionSheet.setOnButtonClickListener(new TroopAvatarWallPreviewActivity.24.1(this, localActionSheet));
        localActionSheet.show();
      }
    }
    else {
      TroopAvatarWallPreviewActivity.access$600(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.24
 * JD-Core Version:    0.7.0.1
 */
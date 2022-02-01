package com.tencent.mobileqq.troop.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

class TroopAvatarWallPreviewActivity$21
  implements View.OnClickListener
{
  TroopAvatarWallPreviewActivity$21(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.a, null);
      localActionSheet.addButton(2131693299, 3);
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnButtonClickListener(new TroopAvatarWallPreviewActivity.21.1(this, localActionSheet));
      localActionSheet.show();
      continue;
      TroopAvatarWallPreviewActivity.c(this.a);
      continue;
      TroopAvatarWallPreviewActivity.i(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.21
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.troop.activity;

import android.view.View;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopAvatarWallEditActivity$5
  implements ActionSheet.OnButtonClickListener
{
  TroopAvatarWallEditActivity$5(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if ((paramInt == 0) && (System.currentTimeMillis() - TroopAvatarWallEditActivity.c(this.b) > 500L))
    {
      this.b.u.c(this.b.j);
      TroopAvatarWallEditActivity.a(this.b, System.currentTimeMillis());
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.5
 * JD-Core Version:    0.7.0.1
 */
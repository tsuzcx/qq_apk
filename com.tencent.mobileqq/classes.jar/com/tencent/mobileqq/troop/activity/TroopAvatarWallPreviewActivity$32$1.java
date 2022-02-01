package com.tencent.mobileqq.troop.activity;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopAvatarWallPreviewActivity$32$1
  implements ActionSheet.OnButtonClickListener
{
  TroopAvatarWallPreviewActivity$32$1(TroopAvatarWallPreviewActivity.32 param32, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      this.b.a.deletePic(this.b.a.mIndex);
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.32.1
 * JD-Core Version:    0.7.0.1
 */
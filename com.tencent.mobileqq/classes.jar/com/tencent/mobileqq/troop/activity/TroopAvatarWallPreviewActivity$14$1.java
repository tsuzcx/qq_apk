package com.tencent.mobileqq.troop.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

class TroopAvatarWallPreviewActivity$14$1
  implements Runnable
{
  TroopAvatarWallPreviewActivity$14$1(TroopAvatarWallPreviewActivity.14 param14) {}
  
  public void run()
  {
    if (this.a.a.mBottomBar == null) {
      return;
    }
    this.a.a.mBottomBar.setVisibility(0);
    if ((this.a.a.mPhotoDesc != null) && (!TextUtils.isEmpty(this.a.a.mPhotoDesc.getText()))) {
      this.a.a.mPhotoDesc.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.14.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.troop.activity;

import android.widget.ImageView;
import androidx.lifecycle.Observer;

class TroopAvatarWallPreviewActivity$7
  implements Observer<Boolean>
{
  TroopAvatarWallPreviewActivity$7(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, ImageView paramImageView) {}
  
  public void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      this.a.setImageResource(2130842656);
      return;
    }
    this.a.setImageResource(2130851656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.7
 * JD-Core Version:    0.7.0.1
 */
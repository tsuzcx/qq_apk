package com.tencent.mobileqq.troop.activity;

import com.tencent.mobileqq.activity.photo.TroopPhotoController;
import java.io.File;

class TroopAvatarWallEditActivity$15
  implements Runnable
{
  TroopAvatarWallEditActivity$15(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity, File paramFile) {}
  
  public void run()
  {
    if (!this.this$0.b.onPicPicked(this.a.getPath(), null)) {
      this.this$0.a(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.15
 * JD-Core Version:    0.7.0.1
 */
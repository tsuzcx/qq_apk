package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import bmsm;

class TroopAvatarWallPreviewActivity$1
  implements Runnable
{
  TroopAvatarWallPreviewActivity$1(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void run()
  {
    if (this.this$0.getIntent().getBooleanExtra("save_intent_to_file", false))
    {
      Intent localIntent = bmsm.a(this.this$0);
      bmsm.a(this.this$0);
      this.this$0.setIntent(localIntent);
    }
    this.this$0.runOnUiThread(new TroopAvatarWallPreviewActivity.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.1
 * JD-Core Version:    0.7.0.1
 */
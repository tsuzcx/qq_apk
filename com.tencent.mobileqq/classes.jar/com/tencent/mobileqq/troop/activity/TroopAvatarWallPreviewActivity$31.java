package com.tencent.mobileqq.troop.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class TroopAvatarWallPreviewActivity$31
  extends BroadcastReceiver
{
  TroopAvatarWallPreviewActivity$31(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getAction().equals("cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.handleQunDetailDelete"))) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity.31
 * JD-Core Version:    0.7.0.1
 */
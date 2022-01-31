package com.tencent.qqmini.nativePlugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import bjqu;
import bjqw;

class TroopAlbumPlugin$4
  implements DialogInterface.OnClickListener
{
  TroopAlbumPlugin$4(TroopAlbumPlugin paramTroopAlbumPlugin, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bjqu.a().a().d(this.val$jsonString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TroopAlbumPlugin.4
 * JD-Core Version:    0.7.0.1
 */
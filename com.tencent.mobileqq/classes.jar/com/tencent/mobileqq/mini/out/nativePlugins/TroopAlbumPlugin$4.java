package com.tencent.mobileqq.mini.out.nativePlugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import bgbz;
import bgcb;

class TroopAlbumPlugin$4
  implements DialogInterface.OnClickListener
{
  TroopAlbumPlugin$4(TroopAlbumPlugin paramTroopAlbumPlugin, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    bgbz.a().a().d(this.val$jsonString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.4
 * JD-Core Version:    0.7.0.1
 */
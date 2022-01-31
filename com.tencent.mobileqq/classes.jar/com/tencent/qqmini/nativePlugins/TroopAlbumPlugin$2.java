package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import android.os.Handler;
import bglv;
import bjqx;

class TroopAlbumPlugin$2
  implements bjqx
{
  TroopAlbumPlugin$2(TroopAlbumPlugin paramTroopAlbumPlugin, String paramString) {}
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ("cmd.troop.download.photo".equals(paramString))
    {
      paramString = paramBundle.getBundle("data");
      if (paramString.getBoolean("isOpenVip")) {
        TroopAlbumPlugin.access$1100(this.this$0).post(new TroopAlbumPlugin.2.1(this));
      }
    }
    else
    {
      return;
    }
    paramString.getInt("totalNum");
    int i = paramString.getInt("successNum");
    int j = paramString.getInt("failNum");
    boolean bool = paramString.getBoolean("isDownloadCanceled");
    paramString = paramString.getString("path");
    TroopAlbumPlugin.access$1300(this.this$0, TroopAlbumPlugin.access$1200(this.this$0).a(), i, j, paramString, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TroopAlbumPlugin.2
 * JD-Core Version:    0.7.0.1
 */
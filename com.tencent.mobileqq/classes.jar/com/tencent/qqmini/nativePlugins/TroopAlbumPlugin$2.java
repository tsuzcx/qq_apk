package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import cooperation.qzone.remote.logic.WebEventListener;

class TroopAlbumPlugin$2
  implements WebEventListener
{
  TroopAlbumPlugin$2(TroopAlbumPlugin paramTroopAlbumPlugin, String paramString) {}
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ("cmd.troop.download.photo".equals(paramString))
    {
      paramString = paramBundle.getBundle("data");
      if (paramString.getBoolean("isOpenVip"))
      {
        TroopAlbumPlugin.k(this.b).post(new TroopAlbumPlugin.2.1(this));
        return;
      }
      paramString.getInt("totalNum");
      int i = paramString.getInt("successNum");
      int j = paramString.getInt("failNum");
      boolean bool = paramString.getBoolean("isDownloadCanceled");
      paramString = paramString.getString("path");
      paramBundle = this.b;
      TroopAlbumPlugin.a(paramBundle, TroopAlbumPlugin.l(paramBundle).getAttachedActivity(), i, j, paramString, bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TroopAlbumPlugin.2
 * JD-Core Version:    0.7.0.1
 */
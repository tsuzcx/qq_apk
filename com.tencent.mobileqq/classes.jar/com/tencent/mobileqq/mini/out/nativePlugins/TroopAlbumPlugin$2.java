package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import android.os.Handler;
import bgcc;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;

class TroopAlbumPlugin$2
  implements bgcc
{
  TroopAlbumPlugin$2(TroopAlbumPlugin paramTroopAlbumPlugin, String paramString, NativePlugin.JSContext paramJSContext) {}
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ("cmd.troop.download.photo".equals(paramString))
    {
      paramString = paramBundle.getBundle("data");
      if (paramString.getBoolean("isOpenVip")) {
        TroopAlbumPlugin.access$400(this.this$0).post(new TroopAlbumPlugin.2.1(this));
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
    TroopAlbumPlugin.access$500(this.this$0, this.val$jsContext.getActivity(), i, j, paramString, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

class TroopAlbumPlugin$2$1
  implements Runnable
{
  TroopAlbumPlugin$2$1(TroopAlbumPlugin.2 param2) {}
  
  public void run()
  {
    TroopAlbumPlugin.a(this.a.b, this.a.a);
    Activity localActivity = TroopAlbumPlugin.g(this.a.b).getAttachedActivity();
    if (TroopAlbumPlugin.h(this.a.b) == null) {
      TroopAlbumPlugin.a(this.a.b, DialogUtil.a(localActivity, 230).setTitle(HardCodeUtil.a(2131912454)).setMessage(HardCodeUtil.a(2131912453)).setPositiveButton(HardCodeUtil.a(2131899883), new TroopAlbumPlugin.2.1.2(this)).setNegativeButton(localActivity.getString(2131915033), new TroopAlbumPlugin.2.1.1(this)));
    }
    if (!TroopAlbumPlugin.h(this.a.b).isShowing()) {
      TroopAlbumPlugin.h(this.a.b).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TroopAlbumPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */
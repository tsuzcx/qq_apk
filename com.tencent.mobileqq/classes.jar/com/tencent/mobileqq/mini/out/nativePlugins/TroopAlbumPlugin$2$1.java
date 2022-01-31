package com.tencent.mobileqq.mini.out.nativePlugins;

import alud;
import android.app.Activity;
import android.content.Context;
import bdgm;
import bdjz;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;

class TroopAlbumPlugin$2$1
  implements Runnable
{
  TroopAlbumPlugin$2$1(TroopAlbumPlugin.2 param2) {}
  
  public void run()
  {
    TroopAlbumPlugin.access$202(this.this$1.this$0, this.this$1.val$jsonString);
    Activity localActivity = this.this$1.val$jsContext.getActivity();
    if (TroopAlbumPlugin.access$300(this.this$1.this$0) == null) {
      TroopAlbumPlugin.access$302(this.this$1.this$0, bdgm.a(localActivity, 230).setTitle(alud.a(2131715571)).setMessage(alud.a(2131715570)).setPositiveButton(alud.a(2131715569), new TroopAlbumPlugin.2.1.2(this)).setNegativeButton(localActivity.getString(2131718535), new TroopAlbumPlugin.2.1.1(this)));
    }
    if (!TroopAlbumPlugin.access$300(this.this$1.this$0).isShowing()) {
      TroopAlbumPlugin.access$300(this.this$1.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */
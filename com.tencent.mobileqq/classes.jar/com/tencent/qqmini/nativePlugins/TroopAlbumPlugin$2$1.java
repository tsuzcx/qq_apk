package com.tencent.qqmini.nativePlugins;

import alpo;
import android.app.Activity;
import android.content.Context;
import bdcd;
import bdfq;
import bgho;

class TroopAlbumPlugin$2$1
  implements Runnable
{
  TroopAlbumPlugin$2$1(TroopAlbumPlugin.2 param2) {}
  
  public void run()
  {
    TroopAlbumPlugin.access$602(this.this$1.this$0, this.this$1.val$jsonString);
    Activity localActivity = TroopAlbumPlugin.access$700(this.this$1.this$0).a();
    if (TroopAlbumPlugin.access$800(this.this$1.this$0) == null) {
      TroopAlbumPlugin.access$802(this.this$1.this$0, bdcd.a(localActivity, 230).setTitle(alpo.a(2131715559)).setMessage(alpo.a(2131715558)).setPositiveButton(alpo.a(2131715557), new TroopAlbumPlugin.2.1.2(this)).setNegativeButton(localActivity.getString(2131718523), new TroopAlbumPlugin.2.1.1(this)));
    }
    if (!TroopAlbumPlugin.access$800(this.this$1.this$0).isShowing()) {
      TroopAlbumPlugin.access$800(this.this$1.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TroopAlbumPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */
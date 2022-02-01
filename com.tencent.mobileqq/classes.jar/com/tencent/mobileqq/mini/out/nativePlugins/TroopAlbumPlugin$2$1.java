package com.tencent.mobileqq.mini.out.nativePlugins;

import amtj;
import android.app.Activity;
import android.content.Context;
import bfur;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;
import com.tencent.mobileqq.utils.QQCustomDialog;

class TroopAlbumPlugin$2$1
  implements Runnable
{
  TroopAlbumPlugin$2$1(TroopAlbumPlugin.2 param2) {}
  
  public void run()
  {
    TroopAlbumPlugin.access$202(this.this$1.this$0, this.this$1.val$jsonString);
    Activity localActivity = this.this$1.val$jsContext.getActivity();
    if (TroopAlbumPlugin.access$300(this.this$1.this$0) == null) {
      TroopAlbumPlugin.access$302(this.this$1.this$0, bfur.a(localActivity, 230).setTitle(amtj.a(2131714193)).setMessage(amtj.a(2131714192)).setPositiveButton(amtj.a(2131714191), new TroopAlbumPlugin.2.1.2(this)).setNegativeButton(localActivity.getString(2131717041), new TroopAlbumPlugin.2.1.1(this)));
    }
    if (!TroopAlbumPlugin.access$300(this.this$1.this$0).isShowing()) {
      TroopAlbumPlugin.access$300(this.this$1.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.mini.out.nativePlugins;

import ajjy;
import android.app.Activity;
import android.content.Context;
import babr;
import bafb;
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
      TroopAlbumPlugin.access$302(this.this$1.this$0, babr.a(localActivity, 230).setTitle(ajjy.a(2131649386)).setMessage(ajjy.a(2131649385)).setPositiveButton(ajjy.a(2131649384), new TroopAlbumPlugin.2.1.2(this)).setNegativeButton(localActivity.getString(2131652318), new TroopAlbumPlugin.2.1.1(this)));
    }
    if (!TroopAlbumPlugin.access$300(this.this$1.this$0).isShowing()) {
      TroopAlbumPlugin.access$300(this.this$1.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */
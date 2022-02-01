package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;

class AudioJsPlugin$2$1
  implements IBinder.DeathRecipient
{
  AudioJsPlugin$2$1(AudioJsPlugin.2 param2, IBinder paramIBinder) {}
  
  public void binderDied()
  {
    this.val$service.unlinkToDeath(this, 0);
    AudioJsPlugin.access$2202(this.this$1.this$0, null);
    if (this.this$1.this$0.isColorLevel()) {
      this.this$1.this$0.miniLogI("[mini] AudioJsPlugin", 2, "linkToDeath binderDied");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AudioJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */
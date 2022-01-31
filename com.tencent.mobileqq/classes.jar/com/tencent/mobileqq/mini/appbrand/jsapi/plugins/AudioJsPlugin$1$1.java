package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;

class AudioJsPlugin$1$1
  implements IBinder.DeathRecipient
{
  AudioJsPlugin$1$1(AudioJsPlugin.1 param1, IBinder paramIBinder) {}
  
  public void binderDied()
  {
    this.val$service.unlinkToDeath(this, 0);
    AudioJsPlugin.access$2102(this.this$1.this$0, null);
    if (this.this$1.this$0.isColorLevel()) {
      this.this$1.this$0.miniLogI("[mini] AudioJsPlugin", 2, "linkToDeath binderDied");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AudioJsPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */
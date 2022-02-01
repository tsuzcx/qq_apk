package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.Intent;

class TraeAudioManager$3
  implements Runnable
{
  TraeAudioManager$3(TraeAudioManager paramTraeAudioManager, boolean paramBoolean) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    localIntent.putExtra("PARAM_OPERATION", "NOTIFY_DEVICECHANGABLE_UPDATE");
    localIntent.putExtra("NOTIFY_DEVICECHANGABLE_UPDATE_DATE", this.val$TAMisDeviceChangeable);
    if (this.this$0._context != null) {
      this.this$0._context.sendBroadcast(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.Intent;

class TraeAudioManager$TraeAudioManagerLooper$3
  implements Runnable
{
  TraeAudioManager$TraeAudioManagerLooper$3(TraeAudioManager.TraeAudioManagerLooper paramTraeAudioManagerLooper, int paramInt) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    localIntent.putExtra("PARAM_OPERATION", "NOTIFY_STREAMTYPE_UPDATE");
    localIntent.putExtra("EXTRA_DATA_STREAMTYPE", this.val$TAMst);
    if (this.this$1.this$0._context != null) {
      this.this$1.this$0._context.sendBroadcast(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.TraeAudioManagerLooper.3
 * JD-Core Version:    0.7.0.1
 */
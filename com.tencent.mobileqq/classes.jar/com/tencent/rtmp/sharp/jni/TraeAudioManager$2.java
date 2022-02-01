package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;

class TraeAudioManager$2
  implements Runnable
{
  TraeAudioManager$2(TraeAudioManager paramTraeAudioManager, ArrayList paramArrayList, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    localIntent.putExtra("PARAM_OPERATION", "NOTIFY_DEVICELISTUPDATE");
    localIntent.putExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST", (String[])this.val$list.toArray(new String[0]));
    localIntent.putExtra("EXTRA_DATA_CONNECTEDDEVICE", this.val$con);
    localIntent.putExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE", this.val$prevCon);
    localIntent.putExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME", this.val$_bluetoothName);
    if (this.this$0._context != null) {
      this.this$0._context.sendBroadcast(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.2
 * JD-Core Version:    0.7.0.1
 */
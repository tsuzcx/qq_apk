package dov.com.qq.im.ae.camera.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import bmbx;

public class AEEditorUIBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "AEEditorUIBroadcastReceiver";
  private AEEditorUIBroadcastReceiver.AEEditorUIListener mAEUIListener;
  private boolean mReceiverActive;
  
  public AEEditorUIBroadcastReceiver(AEEditorUIBroadcastReceiver.AEEditorUIListener paramAEEditorUIListener)
  {
    this.mAEUIListener = paramAEEditorUIListener;
  }
  
  private IntentFilter getBroadcastIntentFilter()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("AEEDITOR_GENERATE_STATUS_DELETE");
    return localIntentFilter;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      bmbx.d("AEEditorUIBroadcastReceiver", "[onReceive] : action is null");
    }
    while (!"AEEDITOR_GENERATE_STATUS_DELETE".equals(paramContext)) {
      return;
    }
    int i = paramIntent.getIntExtra("delete_position", 0);
    this.mAEUIListener.deteleMedia(i);
  }
  
  public void registerSelf(@NonNull Context paramContext)
  {
    if ((!this.mReceiverActive) && (paramContext != null))
    {
      paramContext.registerReceiver(this, getBroadcastIntentFilter());
      this.mReceiverActive = true;
    }
  }
  
  public void unRegisterSelf(@NonNull Context paramContext)
  {
    if ((this.mReceiverActive) && (paramContext != null))
    {
      paramContext.unregisterReceiver(this);
      this.mReceiverActive = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AEEditorUIBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
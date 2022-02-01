package dov.com.qq.im.ae.camera.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import bmbx;

public class AEEditorOrderBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "AEEditorOrderBroadcastReceiver";
  private AEEditorOrderBroadcastReceiver.AEEditorOrderListener mAEEditorOrderListener;
  private boolean mReceiverActive;
  
  public AEEditorOrderBroadcastReceiver(AEEditorOrderBroadcastReceiver.AEEditorOrderListener paramAEEditorOrderListener)
  {
    this.mAEEditorOrderListener = paramAEEditorOrderListener;
  }
  
  private IntentFilter getBroadcastIntentFilter()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("AEEDITOR_ORDER_CANCEL");
    localIntentFilter.addAction("AEEDITOR_ORDER_SAVE");
    localIntentFilter.addAction("AEEDITOR_ORDER_REMOVE_MISSION");
    return localIntentFilter;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getStringExtra("generate_mission");
    bmbx.b("AEEditorOrderBroadcastReceiver", "[onReceive] action :" + paramContext);
    bmbx.b("AEEditorOrderBroadcastReceiver", "[onReceive] mission :" + paramIntent);
    if ("AEEDITOR_ORDER_CANCEL".equals(paramContext)) {
      this.mAEEditorOrderListener.onAEEditorCancel(paramIntent);
    }
    while (!"AEEDITOR_ORDER_REMOVE_MISSION".equals(paramContext)) {
      return;
    }
    this.mAEEditorOrderListener.onAEEditorRemove(paramIntent);
  }
  
  public void registerSelf(Context paramContext)
  {
    if ((!this.mReceiverActive) && (paramContext != null))
    {
      paramContext.registerReceiver(this, getBroadcastIntentFilter());
      this.mReceiverActive = true;
    }
  }
  
  public void unRegisterSelf(Context paramContext)
  {
    if ((this.mReceiverActive) && (paramContext != null))
    {
      paramContext.unregisterReceiver(this);
      this.mReceiverActive = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AEEditorOrderBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
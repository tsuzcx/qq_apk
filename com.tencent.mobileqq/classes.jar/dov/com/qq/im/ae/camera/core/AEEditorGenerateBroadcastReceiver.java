package dov.com.qq.im.ae.camera.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import bmbx;

public class AEEditorGenerateBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "AEEditorGenerateBroadcastReceiver";
  private AEEditorGenerateBroadcastReceiver.AEEditorGenerateListener mAETavSessionStatusListener;
  private boolean mReceiverActive;
  
  public AEEditorGenerateBroadcastReceiver(AEEditorGenerateBroadcastReceiver.AEEditorGenerateListener paramAEEditorGenerateListener)
  {
    this.mAETavSessionStatusListener = paramAEEditorGenerateListener;
  }
  
  private IntentFilter getBroadcastIntentFilter()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("AEEDITOR_GENERATE_STATUS_ERROR");
    localIntentFilter.addAction("AEEDITOR_GENERATE_STATUS_DOWNLOADING");
    localIntentFilter.addAction("AEEDITOR_GENERATE_STATUS_READY");
    return localIntentFilter;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      bmbx.d("AEEditorGenerateBroadcastReceiver", "[onReceive] : action is null");
    }
    String str1;
    String str2;
    String str3;
    String str4;
    int i;
    String str5;
    String str6;
    String str7;
    do
    {
      float f;
      int j;
      do
      {
        return;
        str1 = paramIntent.getStringExtra("generate_materialid");
        str2 = paramIntent.getStringExtra("generate_materialname");
        str3 = paramIntent.getStringExtra("generate_filterid");
        str4 = paramIntent.getStringExtra("generate_scheme");
        i = paramIntent.getIntExtra("generate_show_circle_take_same", 0);
        str5 = paramIntent.getStringExtra("generate_mission");
        str6 = paramIntent.getStringExtra("generate_path");
        str7 = paramIntent.getStringExtra("generate_thumb_ptah");
        f = paramIntent.getFloatExtra("generate_progress", 0.0F);
        j = paramIntent.getIntExtra("generate_errorcode", 0);
        paramIntent = paramIntent.getStringExtra("generate_source_path");
        bmbx.b("AEEditorGenerateBroadcastReceiver", "[onReceive] action :" + paramContext);
        bmbx.b("AEEditorGenerateBroadcastReceiver", "[onReceive] mission :" + str5);
        bmbx.b("AEEditorGenerateBroadcastReceiver", "[onReceive] path :" + str6);
        bmbx.b("AEEditorGenerateBroadcastReceiver", "[onReceive] thumbPath :" + str7);
        bmbx.b("AEEditorGenerateBroadcastReceiver", "[onReceive] progress :" + f);
        bmbx.b("AEEditorGenerateBroadcastReceiver", "[onReceive] errorcode :" + j);
      } while (this.mAETavSessionStatusListener == null);
      if ("AEEDITOR_GENERATE_STATUS_ERROR".equals(paramContext))
      {
        this.mAETavSessionStatusListener.onAETavSessionExportError(str5, j);
        return;
      }
      if ("AEEDITOR_GENERATE_STATUS_DOWNLOADING".equals(paramContext))
      {
        this.mAETavSessionStatusListener.onAETavSessionExporting(str5, f);
        return;
      }
    } while (!"AEEDITOR_GENERATE_STATUS_READY".equals(paramContext));
    this.mAETavSessionStatusListener.onAETavSessionExportCompleted(paramIntent, str1, str2, str3, str4, i, str5, str6, str7);
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
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AEEditorGenerateBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
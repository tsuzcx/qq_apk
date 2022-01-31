package dov.com.qq.im.ae.camera.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import bkoo;
import blfg;

public class AEEditorGenerateBroadcastReceiver
  extends BroadcastReceiver
{
  private bkoo jdField_a_of_type_Bkoo;
  private boolean jdField_a_of_type_Boolean;
  
  public AEEditorGenerateBroadcastReceiver(bkoo parambkoo)
  {
    this.jdField_a_of_type_Bkoo = parambkoo;
  }
  
  private IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("AEEDITOR_GENERATE_STATUS_ERROR");
    localIntentFilter.addAction("AEEDITOR_GENERATE_STATUS_DOWNLOADING");
    localIntentFilter.addAction("AEEDITOR_GENERATE_STATUS_READY");
    return localIntentFilter;
  }
  
  public void a(@NonNull Context paramContext)
  {
    if ((!this.jdField_a_of_type_Boolean) && (paramContext != null))
    {
      paramContext.registerReceiver(this, a());
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      blfg.d("AEEditorGenerateBroadcastReceiver", "[onReceive] : action is null");
    }
    String str1;
    String str2;
    String str3;
    do
    {
      float f;
      int i;
      do
      {
        return;
        str1 = paramIntent.getStringExtra("generate_mission");
        str2 = paramIntent.getStringExtra("generate_path");
        str3 = paramIntent.getStringExtra("generate_thumb_ptah");
        f = paramIntent.getFloatExtra("generate_progress", 0.0F);
        i = paramIntent.getIntExtra("generate_thumb_ptah", 0);
        blfg.b("AEEditorGenerateBroadcastReceiver", "[onReceive] action :" + paramContext);
        blfg.b("AEEditorGenerateBroadcastReceiver", "[onReceive] mission :" + str1);
        blfg.b("AEEditorGenerateBroadcastReceiver", "[onReceive] path :" + str2);
        blfg.b("AEEditorGenerateBroadcastReceiver", "[onReceive] thumbPath :" + str3);
        blfg.b("AEEditorGenerateBroadcastReceiver", "[onReceive] progress :" + f);
        blfg.b("AEEditorGenerateBroadcastReceiver", "[onReceive] errorcode :" + i);
      } while (this.jdField_a_of_type_Bkoo == null);
      if ("AEEDITOR_GENERATE_STATUS_ERROR".equals(paramContext))
      {
        this.jdField_a_of_type_Bkoo.a(str1, i);
        return;
      }
      if ("AEEDITOR_GENERATE_STATUS_DOWNLOADING".equals(paramContext))
      {
        this.jdField_a_of_type_Bkoo.a(str1, f);
        return;
      }
    } while (!"AEEDITOR_GENERATE_STATUS_READY".equals(paramContext));
    this.jdField_a_of_type_Bkoo.a(str1, str2, str3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AEEditorGenerateBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
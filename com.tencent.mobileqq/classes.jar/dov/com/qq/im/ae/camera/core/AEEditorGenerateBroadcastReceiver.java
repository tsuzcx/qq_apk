package dov.com.qq.im.ae.camera.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import bnhu;
import bnzb;

public class AEEditorGenerateBroadcastReceiver
  extends BroadcastReceiver
{
  private bnhu jdField_a_of_type_Bnhu;
  private boolean jdField_a_of_type_Boolean;
  
  public AEEditorGenerateBroadcastReceiver(bnhu parambnhu)
  {
    this.jdField_a_of_type_Bnhu = parambnhu;
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
      bnzb.d("AEEditorGenerateBroadcastReceiver", "[onReceive] : action is null");
    }
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    do
    {
      float f;
      int i;
      do
      {
        return;
        str1 = paramIntent.getStringExtra("generate_materialid");
        str2 = paramIntent.getStringExtra("generate_materialname");
        str3 = paramIntent.getStringExtra("generate_filterid");
        str4 = paramIntent.getStringExtra("generate_scheme");
        str5 = paramIntent.getStringExtra("generate_mission");
        str6 = paramIntent.getStringExtra("generate_path");
        str7 = paramIntent.getStringExtra("generate_thumb_ptah");
        f = paramIntent.getFloatExtra("generate_progress", 0.0F);
        i = paramIntent.getIntExtra("generate_errorcode", 0);
        bnzb.b("AEEditorGenerateBroadcastReceiver", "[onReceive] action :" + paramContext);
        bnzb.b("AEEditorGenerateBroadcastReceiver", "[onReceive] mission :" + str5);
        bnzb.b("AEEditorGenerateBroadcastReceiver", "[onReceive] path :" + str6);
        bnzb.b("AEEditorGenerateBroadcastReceiver", "[onReceive] thumbPath :" + str7);
        bnzb.b("AEEditorGenerateBroadcastReceiver", "[onReceive] progress :" + f);
        bnzb.b("AEEditorGenerateBroadcastReceiver", "[onReceive] errorcode :" + i);
      } while (this.jdField_a_of_type_Bnhu == null);
      if ("AEEDITOR_GENERATE_STATUS_ERROR".equals(paramContext))
      {
        this.jdField_a_of_type_Bnhu.a(str5, i);
        return;
      }
      if ("AEEDITOR_GENERATE_STATUS_DOWNLOADING".equals(paramContext))
      {
        this.jdField_a_of_type_Bnhu.a(str5, f);
        return;
      }
    } while (!"AEEDITOR_GENERATE_STATUS_READY".equals(paramContext));
    this.jdField_a_of_type_Bnhu.a(str1, str2, str3, str4, str5, str6, str7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AEEditorGenerateBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
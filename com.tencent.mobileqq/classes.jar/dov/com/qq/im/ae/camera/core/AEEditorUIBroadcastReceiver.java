package dov.com.qq.im.ae.camera.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import bojj;
import bpam;

public class AEEditorUIBroadcastReceiver
  extends BroadcastReceiver
{
  private bojj jdField_a_of_type_Bojj;
  private boolean jdField_a_of_type_Boolean;
  
  public AEEditorUIBroadcastReceiver(bojj parambojj)
  {
    this.jdField_a_of_type_Bojj = parambojj;
  }
  
  private IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("AEEDITOR_GENERATE_STATUS_DELETE");
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
      bpam.d("AEEditorUIBroadcastReceiver", "[onReceive] : action is null");
    }
    while (!"AEEDITOR_GENERATE_STATUS_DELETE".equals(paramContext)) {
      return;
    }
    int i = paramIntent.getIntExtra("delete_position", 0);
    this.jdField_a_of_type_Bojj.a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AEEditorUIBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
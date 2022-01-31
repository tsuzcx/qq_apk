package dov.com.qq.im.ae.camera.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import bkot;
import blfg;

public class AEEditorOrderBroadcastReceiver
  extends BroadcastReceiver
{
  private bkot jdField_a_of_type_Bkot;
  private boolean jdField_a_of_type_Boolean;
  
  public AEEditorOrderBroadcastReceiver(bkot parambkot)
  {
    this.jdField_a_of_type_Bkot = parambkot;
  }
  
  private IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("AEEDITOR_ORDER_CANCEL");
    localIntentFilter.addAction("AEEDITOR_ORDER_SAVE");
    localIntentFilter.addAction("AEEDITOR_ORDER_REMOVE_MISSION");
    return localIntentFilter;
  }
  
  public void a(Context paramContext)
  {
    if ((!this.jdField_a_of_type_Boolean) && (paramContext != null))
    {
      paramContext.registerReceiver(this, a());
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void b(Context paramContext)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramContext != null))
    {
      paramContext.unregisterReceiver(this);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getStringExtra("generate_mission");
    blfg.b("AEEditorOrderBroadcastReceiver", "[onReceive] action :" + paramContext);
    blfg.b("AEEditorOrderBroadcastReceiver", "[onReceive] mission :" + paramIntent);
    if ("AEEDITOR_ORDER_CANCEL".equals(paramContext)) {
      this.jdField_a_of_type_Bkot.a(paramIntent);
    }
    do
    {
      return;
      if ("AEEDITOR_ORDER_SAVE".equals(paramContext))
      {
        this.jdField_a_of_type_Bkot.b(paramIntent);
        return;
      }
    } while (!"AEEDITOR_ORDER_REMOVE_MISSION".equals(paramContext));
    this.jdField_a_of_type_Bkot.c(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AEEditorOrderBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
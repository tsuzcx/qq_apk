package dov.com.qq.im.ae.camera.core;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import bnht;
import bnpt;
import bnzb;

public class AECircleBroadcastReceiver
  extends BroadcastReceiver
{
  private bnht jdField_a_of_type_Bnht;
  private boolean jdField_a_of_type_Boolean;
  
  public AECircleBroadcastReceiver(bnht parambnht)
  {
    this.jdField_a_of_type_Bnht = parambnht;
  }
  
  private IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction(bnpt.jdField_b_of_type_Bnpt.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(bnpt.c.jdField_b_of_type_JavaLangString);
    return localIntentFilter;
  }
  
  public void a(Activity paramActivity)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      paramActivity.registerReceiver(this, a());
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void b(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramActivity.unregisterReceiver(this);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getStringExtra("ae_camera_res_downloadfinish_path");
    if ((bnpt.jdField_b_of_type_Bnpt.jdField_b_of_type_JavaLangString.equals(paramContext)) && (this.jdField_a_of_type_Bnht != null))
    {
      this.jdField_a_of_type_Bnht.a(paramIntent);
      bnzb.a("AECircleBroadcastReceiver", "[onReceive]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECircleBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
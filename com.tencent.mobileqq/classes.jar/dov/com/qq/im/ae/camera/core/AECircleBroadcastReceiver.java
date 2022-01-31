package dov.com.qq.im.ae.camera.core;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import bkon;
import blfg;

public class AECircleBroadcastReceiver
  extends BroadcastReceiver
{
  private bkon jdField_a_of_type_Bkon;
  private boolean jdField_a_of_type_Boolean;
  
  public AECircleBroadcastReceiver(bkon parambkon)
  {
    this.jdField_a_of_type_Bkon = parambkon;
  }
  
  private IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("new_qq_android_native_short_filter_");
    localIntentFilter.addAction("new_qq_android_native_ptu_res_");
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
    if (("new_qq_android_native_short_filter_".equals(paramContext)) && (this.jdField_a_of_type_Bkon != null))
    {
      this.jdField_a_of_type_Bkon.a(paramIntent);
      blfg.a("AECircleBroadcastReceiver", "[onReceive]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECircleBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
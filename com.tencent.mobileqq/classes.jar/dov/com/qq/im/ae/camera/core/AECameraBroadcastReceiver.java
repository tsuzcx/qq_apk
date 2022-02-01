package dov.com.qq.im.ae.camera.core;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import bofh;
import borf;

public class AECameraBroadcastReceiver
  extends BroadcastReceiver
{
  private bofh a;
  
  public AECameraBroadcastReceiver(bofh parambofh)
  {
    this.a = parambofh;
  }
  
  private IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction(borf.jdField_b_of_type_Borf.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(borf.c.jdField_b_of_type_JavaLangString);
    return localIntentFilter;
  }
  
  public void a(Activity paramActivity)
  {
    paramActivity.registerReceiver(this, a());
  }
  
  public void b(Activity paramActivity)
  {
    paramActivity.unregisterReceiver(this);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.a.a();
    if ((paramContext == null) || (paramContext.isFinishing())) {}
    do
    {
      return;
      paramContext = paramIntent.getAction();
    } while (!borf.c.jdField_b_of_type_JavaLangString.equals(paramContext));
    brhe.a = true;
    this.a.q();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
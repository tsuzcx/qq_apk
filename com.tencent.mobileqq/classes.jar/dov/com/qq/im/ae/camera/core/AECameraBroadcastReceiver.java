package dov.com.qq.im.ae.camera.core;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import bndy;
import bnpt;

public class AECameraBroadcastReceiver
  extends BroadcastReceiver
{
  private bndy a;
  
  public AECameraBroadcastReceiver(bndy parambndy)
  {
    this.a = parambndy;
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
    } while (!bnpt.c.jdField_b_of_type_JavaLangString.equals(paramContext));
    bqft.a = true;
    this.a.q();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
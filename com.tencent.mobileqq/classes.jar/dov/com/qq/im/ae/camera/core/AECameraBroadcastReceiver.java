package dov.com.qq.im.ae.camera.core;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import bijd;

public class AECameraBroadcastReceiver
  extends BroadcastReceiver
{
  private bijd a;
  
  public AECameraBroadcastReceiver(bijd parambijd)
  {
    this.a = parambijd;
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
    while (!"new_qq_android_native_ptu_res_".equals(paramIntent.getAction())) {
      return;
    }
    axeh.a = true;
    this.a.r();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
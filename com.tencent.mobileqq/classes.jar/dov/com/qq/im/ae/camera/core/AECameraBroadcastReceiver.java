package dov.com.qq.im.ae.camera.core;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import bmvf;
import bmxa;
import bnkt;

public class AECameraBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "AECameraReceiver";
  private bmvf captureUnit;
  
  public AECameraBroadcastReceiver(bmvf parambmvf)
  {
    this.captureUnit = parambmvf;
  }
  
  private IntentFilter getBroadcastIntentFilter()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction(bnkt.jdField_b_of_type_Bnkt.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(bnkt.c.jdField_b_of_type_JavaLangString);
    return localIntentFilter;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.captureUnit.a();
    if ((paramContext == null) || (paramContext.isFinishing())) {}
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getAction();
        if (!bnkt.c.jdField_b_of_type_JavaLangString.equals(paramContext)) {
          break;
        }
        bpqn.a = true;
      } while (!(this.captureUnit instanceof bmxa));
      ((bmxa)this.captureUnit).aa();
      return;
    } while (!"tencent.av.v2q.StartVideoChat".equals(paramContext));
    Log.d("AECameraReceiver", "onReceive: action = " + paramContext);
  }
  
  public void registerSelf(Activity paramActivity)
  {
    paramActivity.registerReceiver(this, getBroadcastIntentFilter());
  }
  
  public void unRegisterSelf(Activity paramActivity)
  {
    paramActivity.unregisterReceiver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
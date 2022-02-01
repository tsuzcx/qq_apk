package dov.com.qq.im.ae.camera.core;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import blio;
import bljy;
import dov.com.qq.im.ae.download.AEResInfo;

public class AECameraBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "AECameraReceiver";
  private blio captureUnit;
  
  public AECameraBroadcastReceiver(blio paramblio)
  {
    this.captureUnit = paramblio;
  }
  
  private IntentFilter getBroadcastIntentFilter()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction(AEResInfo.AE_RES_BASE_PACKAGE.resPrefix);
    localIntentFilter.addAction(AEResInfo.AE_RES_ADDITIONAL_PACKAGE.resPrefix);
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
        if (!AEResInfo.AE_RES_ADDITIONAL_PACKAGE.resPrefix.equals(paramContext)) {
          break;
        }
        boav.a = true;
      } while (!(this.captureUnit instanceof bljy));
      ((bljy)this.captureUnit).R();
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
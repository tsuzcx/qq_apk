package dov.com.qq.im.ae.camera.core;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import dov.com.qq.im.ae.AEBaseCameraUnit;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.util.AEQLog;

public class AECameraBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "AECameraReceiver";
  private AEBaseCameraUnit captureUnit;
  
  public AECameraBroadcastReceiver(AEBaseCameraUnit paramAEBaseCameraUnit)
  {
    this.captureUnit = paramAEBaseCameraUnit;
  }
  
  private IntentFilter getBroadcastIntentFilter()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction(AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(AEResInfo.jdField_c_of_type_DovComQqImAeDownloadAEResInfo.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(AEResInfo.k.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(AEResInfo.j.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(AEResInfo.f.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(AEResInfo.g.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(AEResInfo.e.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(AEResInfo.d.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(AEResInfo.h.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(AEResInfo.i.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(AEResInfo.l.jdField_b_of_type_JavaLangString);
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
        paramIntent = paramIntent.getAction();
        AEQLog.a("AECameraReceiver", "AECameraBroadcastReceiver onReceive: action = " + paramIntent);
        paramContext = AEResInfo.a(paramIntent);
        if (!AEResInfo.a(paramContext)) {
          break;
        }
      } while (!(this.captureUnit instanceof AEPituCameraUnit));
      paramIntent = AEResUtil.c(paramContext);
      paramContext = paramContext.jdField_c_of_type_JavaLangString;
      AEQLog.a("AECameraReceiver", "AECameraBroadcastReceiver 收到广播 isAdittionPackage: path = " + paramIntent + " agent = " + paramContext);
      ((AEPituCameraUnit)this.captureUnit).b(paramIntent, paramContext);
      ((AEPituCameraUnit)this.captureUnit).Z();
      return;
    } while (!"tencent.av.v2q.StartVideoChat".equals(paramIntent));
    Log.d("AECameraReceiver", "AECameraBroadcastReceiver onReceive: action = " + paramIntent);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECameraBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
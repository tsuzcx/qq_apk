package dov.com.qq.im.ae.camera.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.util.AEQLog;

public class AECircleBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "AECircleBroadcastReceiver";
  private AECircleBroadcastReceiver.AEResDownLoadListener mPhotoListLogicAECircle;
  private boolean mReceiverActive = false;
  
  public AECircleBroadcastReceiver(AECircleBroadcastReceiver.AEResDownLoadListener paramAEResDownLoadListener)
  {
    this.mPhotoListLogicAECircle = paramAEResDownLoadListener;
  }
  
  private IntentFilter getBroadcastIntentFilter()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction(AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo.jdField_b_of_type_JavaLangString);
    localIntentFilter.addAction(AEResInfo.c.jdField_b_of_type_JavaLangString);
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
    paramContext = paramIntent.getAction();
    AEQLog.a("AECircleBroadcastReceiver", "AECircleBroadcastReceiver onReceive!  action = " + paramContext);
    paramIntent = paramIntent.getStringExtra("ae_camera_res_downloadfinish_path");
    if ((AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo.jdField_b_of_type_JavaLangString.equals(paramContext)) && (this.mPhotoListLogicAECircle != null))
    {
      this.mPhotoListLogicAECircle.onDownLoadFinish(paramIntent);
      AEQLog.a("AECircleBroadcastReceiver", "[onReceive]");
    }
  }
  
  public void registerSelf(Context paramContext)
  {
    if (!this.mReceiverActive)
    {
      paramContext.registerReceiver(this, getBroadcastIntentFilter());
      this.mReceiverActive = true;
    }
  }
  
  public void unRegisterSelf(Context paramContext)
  {
    if (this.mReceiverActive)
    {
      paramContext.unregisterReceiver(this);
      this.mReceiverActive = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECircleBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
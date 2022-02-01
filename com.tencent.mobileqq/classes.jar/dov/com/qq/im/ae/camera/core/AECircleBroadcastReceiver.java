package dov.com.qq.im.ae.camera.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import bnkt;
import bnrh;

public class AECircleBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "AECircleBroadcastReceiver";
  private AECircleBroadcastReceiver.AEResDownLoadListener mPhotoListLogicAECircle;
  private boolean mReceiverActive;
  
  public AECircleBroadcastReceiver(AECircleBroadcastReceiver.AEResDownLoadListener paramAEResDownLoadListener)
  {
    this.mPhotoListLogicAECircle = paramAEResDownLoadListener;
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
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getStringExtra("ae_camera_res_downloadfinish_path");
    if ((bnkt.jdField_b_of_type_Bnkt.jdField_b_of_type_JavaLangString.equals(paramContext)) && (this.mPhotoListLogicAECircle != null))
    {
      this.mPhotoListLogicAECircle.onDownLoadFinish(paramIntent);
      bnrh.a("AECircleBroadcastReceiver", "[onReceive]");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.core.AECircleBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
package dov.com.qq.im;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.setting.IQIMCameraContainer;

class QIMWebEffectCameraCaptureUnit$1
  extends BroadcastReceiver
{
  QIMWebEffectCameraCaptureUnit$1(QIMWebEffectCameraCaptureUnit paramQIMWebEffectCameraCaptureUnit) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("tencent.video.q2v.startUploadPTV".equals(paramIntent.getAction()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMWebEffectCameraCaptureUnit", 2, "receive ACTION_BLESS_UPLOAD_PTV.");
      }
      switch (paramIntent.getIntExtra("broadcastType", 1))
      {
      }
    }
    do
    {
      return;
      paramContext = QIMWebEffectCameraCaptureUnit.a(this.a).a();
    } while ((paramContext == null) || (paramContext.isFinishing()));
    paramContext.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMWebEffectCameraCaptureUnit.1
 * JD-Core Version:    0.7.0.1
 */
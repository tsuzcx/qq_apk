package dov.com.qq.im;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import blhu;
import bmbx;
import boav;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import dov.com.qq.im.ae.download.AEResInfo;

public class QIMCameraBroadcastReceiver
  extends BroadcastReceiver
{
  private blhu a;
  
  public QIMCameraBroadcastReceiver(blhu paramblhu)
  {
    this.a = paramblhu;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.a.a();
    if ((paramContext == null) || (paramContext.isFinishing())) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramContext = paramIntent.getAction();
            bmbx.b("QIMCameraBroadcastReceiver", "receive boardcast, action:" + paramContext);
            if (!"tencent.av.v2q.StartVideoChat".equals(paramContext)) {
              break;
            }
          } while ((this.a.f) || (!this.a.m));
          this.a.m();
          return;
        } while (!AEResInfo.AE_RES_ADDITIONAL_PACKAGE.resPrefix.equals(paramContext));
        boav.jdField_a_of_type_Boolean = true;
      } while (boav.jdField_a_of_type_JavaLangString == null);
      paramContext = this.a.a();
    } while (!(paramContext instanceof EffectsCameraCaptureView));
    ((EffectsCameraCaptureView)paramContext).setFaceEffect(boav.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
package dov.com.qq.im;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bigp;
import bjah;
import bkze;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;

public class QIMCameraBroadcastReceiver
  extends BroadcastReceiver
{
  private bigp a;
  
  public QIMCameraBroadcastReceiver(bigp parambigp)
  {
    this.a = parambigp;
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
            bjah.b("QIMCameraBroadcastReceiver", "receive boardcast, action:" + paramContext);
            if (!"tencent.av.v2q.StartVideoChat".equals(paramContext)) {
              break;
            }
          } while ((this.a.g) || (!this.a.n));
          this.a.r();
          return;
        } while (!"new_qq_android_native_ptu_res_".equals(paramContext));
        axeh.a = true;
      } while (bkze.a == null);
      paramContext = this.a.a();
    } while (!(paramContext instanceof EffectsCameraCaptureView));
    ((EffectsCameraCaptureView)paramContext).setFaceEffect(bkze.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
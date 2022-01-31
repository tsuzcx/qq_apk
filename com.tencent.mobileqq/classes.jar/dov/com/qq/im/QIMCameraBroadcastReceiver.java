package dov.com.qq.im;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bkil;
import blfg;
import bnko;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;

public class QIMCameraBroadcastReceiver
  extends BroadcastReceiver
{
  private bkil a;
  
  public QIMCameraBroadcastReceiver(bkil parambkil)
  {
    this.a = parambkil;
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
            blfg.b("QIMCameraBroadcastReceiver", "receive boardcast, action:" + paramContext);
            if (!"tencent.av.v2q.StartVideoChat".equals(paramContext)) {
              break;
            }
          } while ((this.a.g) || (!this.a.n));
          this.a.r();
          return;
        } while (!"new_qq_android_native_ptu_res_".equals(paramContext));
        ayzn.a = true;
      } while (bnko.a == null);
      paramContext = this.a.a();
    } while (!(paramContext instanceof EffectsCameraCaptureView));
    ((EffectsCameraCaptureView)paramContext).setFaceEffect(bnko.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
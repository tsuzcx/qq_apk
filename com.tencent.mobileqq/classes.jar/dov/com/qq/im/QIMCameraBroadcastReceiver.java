package dov.com.qq.im;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bhcs;
import bhdi;
import bjic;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;

public class QIMCameraBroadcastReceiver
  extends BroadcastReceiver
{
  private bhdi a;
  
  public QIMCameraBroadcastReceiver(bhdi parambhdi)
  {
    this.a = parambhdi;
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
            bhcs.a("QIMCameraBroadcastReceiver", 1, "receive boardcast, action:" + paramContext);
            if (!"tencent.av.v2q.StartVideoChat".equals(paramContext)) {
              break;
            }
          } while ((this.a.g) || (!this.a.n));
          this.a.v();
          return;
          if ("key_notify_filter_so_ready".equals(paramContext))
          {
            this.a.W();
            return;
          }
        } while (!"key_notify_ptures_so_ready".equals(paramContext));
        awex.a = true;
      } while (bjic.a == null);
      paramContext = this.a.a();
    } while (!(paramContext instanceof EffectsCameraCaptureView));
    ((EffectsCameraCaptureView)paramContext).setFaceEffect(bjic.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
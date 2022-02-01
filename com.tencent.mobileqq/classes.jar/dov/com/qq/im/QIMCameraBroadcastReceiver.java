package dov.com.qq.im;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bmul;
import bnkt;
import bnrh;
import bpqn;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;

public class QIMCameraBroadcastReceiver
  extends BroadcastReceiver
{
  private bmul a;
  
  public QIMCameraBroadcastReceiver(bmul parambmul)
  {
    this.a = parambmul;
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
            bnrh.b("QIMCameraBroadcastReceiver", "receive boardcast, action:" + paramContext);
            if (!"tencent.av.v2q.StartVideoChat".equals(paramContext)) {
              break;
            }
          } while ((this.a.f) || (!this.a.m));
          this.a.h();
          return;
        } while (!bnkt.c.b.equals(paramContext));
        bpqn.jdField_a_of_type_Boolean = true;
      } while (bpqn.jdField_a_of_type_JavaLangString == null);
      paramContext = this.a.a();
    } while (!(paramContext instanceof EffectsCameraCaptureView));
    ((EffectsCameraCaptureView)paramContext).setFaceEffect(bpqn.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
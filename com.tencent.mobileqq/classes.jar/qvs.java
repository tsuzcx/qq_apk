import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeController.VolumeReceiver.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class qvs
  extends BroadcastReceiver
{
  private qvs(qvo paramqvo) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime().isBackground_Stop) || (BaseApplicationImpl.getApplication().getRuntime().isBackground_Pause)) {}
    do
    {
      for (;;)
      {
        return;
        if (qvo.a(this.a) == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoVolumeController", 2, "VolumeReceiver onReceive null");
          }
        }
        else if (qvo.b(this.a)) {
          if (qvo.c(this.a))
          {
            if (QLog.isColorLevel()) {
              QLog.d("VideoVolumeController", 2, "dynamicPauseReceive true");
            }
          }
          else
          {
            int i;
            try
            {
              if (!paramIntent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) {
                break;
              }
              i = qvo.a(this.a).getStreamVolume(3);
              if (QLog.isColorLevel()) {
                QLog.d("VideoVolumeController", 2, "volume change:" + i);
              }
              if (qvo.d(this.a))
              {
                QLog.d("VideoVolumeController", 2, "volume change shield ");
                return;
              }
            }
            catch (Exception paramContext)
            {
              QLog.d("VideoVolumeController", 1, "VolumeReceiver", paramContext);
              return;
            }
            paramContext = qvo.a(this.a).iterator();
            while (paramContext.hasNext()) {
              ((qvp)paramContext.next()).a(i);
            }
          }
        }
      }
    } while (!paramIntent.getAction().equals("android.intent.action.HEADSET_PLUG"));
    boolean bool = qvo.a(this.a).isWiredHeadsetOn();
    if (qvo.e(this.a))
    {
      qvo.a(this.a, false);
      return;
    }
    qvo.b(this.a, true);
    paramContext = qvo.a(this.a).iterator();
    while (paramContext.hasNext()) {
      ((qvp)paramContext.next()).a(bool);
    }
    qvo.a(this.a).postDelayed(new VideoVolumeController.VolumeReceiver.1(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qvs
 * JD-Core Version:    0.7.0.1
 */
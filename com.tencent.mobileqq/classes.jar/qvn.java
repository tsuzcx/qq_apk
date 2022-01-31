import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl.VolumeReceiver.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class qvn
  extends BroadcastReceiver
{
  private qvn(qvk paramqvk) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime().isBackground_Stop) || (BaseApplicationImpl.getApplication().getRuntime().isBackground_Pause)) {}
    label24:
    do
    {
      do
      {
        do
        {
          do
          {
            break label24;
            break label24;
            do
            {
              return;
            } while (qvk.b(this.a));
            if (qvk.c(this.a))
            {
              qvk.b(this.a, false);
              return;
            }
            if (qvk.a(this.a) != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "VolumeReceiver onReceive null");
          return;
        } while (!qvk.d(this.a));
        if (!qvk.e(this.a)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "dynamicPauseReceive true");
      return;
      int i;
      try
      {
        if (!paramIntent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) {
          continue;
        }
        i = qvk.a(this.a).getStreamVolume(3);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "volume change:" + i);
        }
        if (qvk.f(this.a))
        {
          QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "volume change shield ");
          return;
        }
      }
      catch (Exception paramContext)
      {
        QLog.d("Q.readinjoy.video.VideoVolumeControl", 1, "VolumeReceiver", paramContext);
        return;
      }
      if (i == 0)
      {
        this.a.a(true, "system volume 0", qvk.a(this.a));
        return;
      }
      this.a.a(false, "system volume change", qvk.a(this.a));
      return;
    } while (!paramIntent.getAction().equals("android.intent.action.HEADSET_PLUG"));
    boolean bool = qvk.a(this.a).isWiredHeadsetOn();
    if (qvk.g(this.a))
    {
      qvk.c(this.a, false);
      return;
    }
    qvk.d(this.a, true);
    if (bool) {
      this.a.a(false, "headset on", qvk.a(this.a));
    }
    for (;;)
    {
      qvk.a(this.a).postDelayed(new VideoVolumeControl.VolumeReceiver.1(this), 200L);
      return;
      this.a.a(true, "headset off", qvk.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qvn
 * JD-Core Version:    0.7.0.1
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl.VolumeReceiver.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class qjl
  extends BroadcastReceiver
{
  private qjl(qji paramqji) {}
  
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
            } while (qji.b(this.a));
            if (qji.c(this.a))
            {
              qji.b(this.a, false);
              return;
            }
            if (qji.a(this.a) != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "VolumeReceiver onReceive null");
          return;
        } while (!qji.d(this.a));
        if (!qji.e(this.a)) {
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
        i = qji.a(this.a).getStreamVolume(3);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "volume change:" + i);
        }
        if (qji.f(this.a))
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
        this.a.a(true, "system volume 0", qji.a(this.a));
        return;
      }
      this.a.a(false, "system volume change", qji.a(this.a));
      return;
    } while (!paramIntent.getAction().equals("android.intent.action.HEADSET_PLUG"));
    boolean bool = qji.a(this.a).isWiredHeadsetOn();
    if (qji.g(this.a))
    {
      qji.c(this.a, false);
      return;
    }
    qji.d(this.a, true);
    if (bool) {
      this.a.a(false, "headset on", qji.a(this.a));
    }
    for (;;)
    {
      qji.a(this.a).postDelayed(new VideoVolumeControl.VolumeReceiver.1(this), 200L);
      return;
      this.a.a(true, "headset off", qji.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qjl
 * JD-Core Version:    0.7.0.1
 */
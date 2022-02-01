import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl.VolumeReceiver.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class sqs
  extends BroadcastReceiver
{
  private sqs(sqp paramsqp) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime().isBackgroundStop) || (BaseApplicationImpl.getApplication().getRuntime().isBackgroundPause)) {}
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
            } while (sqp.b(this.a));
            if (sqp.c(this.a))
            {
              sqp.b(this.a, false);
              return;
            }
            if (sqp.a(this.a) != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "VolumeReceiver onReceive null");
          return;
        } while (!sqp.d(this.a));
        if (!sqp.e(this.a)) {
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
        i = sqp.a(this.a).getStreamVolume(3);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "volume change:" + i);
        }
        if (sqp.f(this.a))
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
        this.a.a(true, "system volume 0", sqp.a(this.a));
        return;
      }
      this.a.a(false, "system volume change", sqp.a(this.a));
      return;
    } while (!paramIntent.getAction().equals("android.intent.action.HEADSET_PLUG"));
    boolean bool = sqp.a(this.a).isWiredHeadsetOn();
    if (sqp.g(this.a))
    {
      sqp.c(this.a, false);
      return;
    }
    sqp.d(this.a, true);
    if (bool) {
      this.a.a(false, "headset on", sqp.a(this.a));
    }
    for (;;)
    {
      sqp.a(this.a).postDelayed(new VideoVolumeControl.VolumeReceiver.1(this), 200L);
      return;
      this.a.a(true, "headset off", sqp.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sqs
 * JD-Core Version:    0.7.0.1
 */
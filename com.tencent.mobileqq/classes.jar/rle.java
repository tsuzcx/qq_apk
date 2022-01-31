import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl.VolumeReceiver.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class rle
  extends BroadcastReceiver
{
  private rle(rlb paramrlb) {}
  
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
            } while (rlb.b(this.a));
            if (rlb.c(this.a))
            {
              rlb.b(this.a, false);
              return;
            }
            if (rlb.a(this.a) != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "VolumeReceiver onReceive null");
          return;
        } while (!rlb.d(this.a));
        if (!rlb.e(this.a)) {
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
        i = rlb.a(this.a).getStreamVolume(3);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "volume change:" + i);
        }
        if (rlb.f(this.a))
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
        this.a.a(true, "system volume 0", rlb.a(this.a));
        return;
      }
      this.a.a(false, "system volume change", rlb.a(this.a));
      return;
    } while (!paramIntent.getAction().equals("android.intent.action.HEADSET_PLUG"));
    boolean bool = rlb.a(this.a).isWiredHeadsetOn();
    if (rlb.g(this.a))
    {
      rlb.c(this.a, false);
      return;
    }
    rlb.d(this.a, true);
    if (bool) {
      this.a.a(false, "headset on", rlb.a(this.a));
    }
    for (;;)
    {
      rlb.a(this.a).postDelayed(new VideoVolumeControl.VolumeReceiver.1(this), 200L);
      return;
      this.a.a(true, "headset off", rlb.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rle
 * JD-Core Version:    0.7.0.1
 */
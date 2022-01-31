import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class mfc
  extends BroadcastReceiver
{
  private mfc(VideoVolumeControl paramVideoVolumeControl) {}
  
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
            } while (VideoVolumeControl.b(this.a));
            if (VideoVolumeControl.c(this.a))
            {
              VideoVolumeControl.b(this.a, false);
              return;
            }
            if (VideoVolumeControl.a(this.a) != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "VolumeReceiver onReceive null");
          return;
        } while (!VideoVolumeControl.d(this.a));
        if (!VideoVolumeControl.e(this.a)) {
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
        i = VideoVolumeControl.a(this.a).getStreamVolume(3);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "volume change:" + i);
        }
        if (VideoVolumeControl.f(this.a))
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
        this.a.a(true, "system volume 0", VideoVolumeControl.a(this.a));
        return;
      }
      this.a.a(false, "system volume change", VideoVolumeControl.a(this.a));
      return;
    } while (!paramIntent.getAction().equals("android.intent.action.HEADSET_PLUG"));
    boolean bool = VideoVolumeControl.a(this.a).isWiredHeadsetOn();
    if (VideoVolumeControl.g(this.a))
    {
      VideoVolumeControl.c(this.a, false);
      return;
    }
    VideoVolumeControl.d(this.a, true);
    if (bool) {
      this.a.a(false, "headset on", VideoVolumeControl.a(this.a));
    }
    for (;;)
    {
      VideoVolumeControl.a(this.a).postDelayed(new mfd(this), 200L);
      return;
      this.a.a(true, "headset off", VideoVolumeControl.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mfc
 * JD-Core Version:    0.7.0.1
 */
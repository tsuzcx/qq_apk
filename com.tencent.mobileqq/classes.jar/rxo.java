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

public class rxo
  extends BroadcastReceiver
{
  private rxo(rxk paramrxk) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime().isBackgroundStop) || (BaseApplicationImpl.getApplication().getRuntime().isBackgroundPause)) {}
    do
    {
      for (;;)
      {
        return;
        if (rxk.a(this.a) == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoVolumeController", 2, "VolumeReceiver onReceive null");
          }
        }
        else if (rxk.b(this.a)) {
          if (rxk.c(this.a))
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
              i = rxk.a(this.a).getStreamVolume(3);
              if (QLog.isColorLevel()) {
                QLog.d("VideoVolumeController", 2, "volume change:" + i);
              }
              if (rxk.d(this.a))
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
            paramContext = rxk.a(this.a).iterator();
            while (paramContext.hasNext()) {
              ((rxl)paramContext.next()).onSystemVolumeChanged(i);
            }
          }
        }
      }
    } while (!paramIntent.getAction().equals("android.intent.action.HEADSET_PLUG"));
    boolean bool = rxk.a(this.a).isWiredHeadsetOn();
    if (rxk.e(this.a))
    {
      rxk.a(this.a, false);
      return;
    }
    rxk.b(this.a, true);
    paramContext = rxk.a(this.a).iterator();
    while (paramContext.hasNext()) {
      ((rxl)paramContext.next()).onHeadsetStateChanged(bool);
    }
    rxk.a(this.a).postDelayed(new VideoVolumeController.VolumeReceiver.1(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxo
 * JD-Core Version:    0.7.0.1
 */
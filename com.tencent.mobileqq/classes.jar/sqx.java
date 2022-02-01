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

public class sqx
  extends BroadcastReceiver
{
  private sqx(sqt paramsqt) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime().isBackgroundStop) || (BaseApplicationImpl.getApplication().getRuntime().isBackgroundPause)) {}
    do
    {
      for (;;)
      {
        return;
        if (sqt.a(this.a) == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoVolumeController", 2, "VolumeReceiver onReceive null");
          }
        }
        else if (sqt.b(this.a)) {
          if (sqt.c(this.a))
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
              i = sqt.a(this.a).getStreamVolume(3);
              if (QLog.isColorLevel()) {
                QLog.d("VideoVolumeController", 2, "volume change:" + i);
              }
              if (sqt.d(this.a))
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
            paramContext = sqt.a(this.a).iterator();
            while (paramContext.hasNext()) {
              ((squ)paramContext.next()).onSystemVolumeChanged(i);
            }
          }
        }
      }
    } while (!paramIntent.getAction().equals("android.intent.action.HEADSET_PLUG"));
    boolean bool = sqt.a(this.a).isWiredHeadsetOn();
    if (sqt.e(this.a))
    {
      sqt.a(this.a, false);
      return;
    }
    sqt.b(this.a, true);
    paramContext = sqt.a(this.a).iterator();
    while (paramContext.hasNext()) {
      ((squ)paramContext.next()).onHeadsetStateChanged(bool);
    }
    sqt.a(this.a).postDelayed(new VideoVolumeController.VolumeReceiver.1(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sqx
 * JD-Core Version:    0.7.0.1
 */
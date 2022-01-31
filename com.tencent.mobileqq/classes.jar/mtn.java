import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoVolumeControl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class mtn
  extends BroadcastReceiver
{
  private mtn(FastWebVideoVolumeControl paramFastWebVideoVolumeControl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime().isBackground_Stop) || (BaseApplicationImpl.getApplication().getRuntime().isBackground_Pause)) {}
    label24:
    int i;
    do
    {
      do
      {
        do
        {
          break label24;
          break label24;
          break label24;
          break label24;
          for (;;)
          {
            return;
            if (!FastWebVideoVolumeControl.a(this.a))
            {
              if (FastWebVideoVolumeControl.b(this.a))
              {
                FastWebVideoVolumeControl.a(this.a, false);
                return;
              }
              if (FastWebVideoVolumeControl.a(this.a) == null)
              {
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("Q.readinjoy.video.FastWebVideoVolumeControl", 2, "VolumeReceiver onReceive null");
                return;
              }
              if (!FastWebVideoVolumeControl.c(this.a)) {
                break;
              }
              if (FastWebVideoVolumeControl.d(this.a))
              {
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("Q.readinjoy.video.FastWebVideoVolumeControl", 2, "dynamicPauseReceive true");
                return;
              }
              try
              {
                if (paramIntent.getAction().equals("android.media.VOLUME_CHANGED_ACTION"))
                {
                  i = FastWebVideoVolumeControl.a(this.a).getStreamVolume(3);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.readinjoy.video.FastWebVideoVolumeControl", 2, "volume change:" + i);
                  }
                  if (!FastWebVideoVolumeControl.e(this.a)) {
                    continue;
                  }
                  QLog.d("Q.readinjoy.video.FastWebVideoVolumeControl", 2, "volume change shield ");
                }
              }
              catch (Exception paramContext)
              {
                QLog.d("Q.readinjoy.video.FastWebVideoVolumeControl", 1, "VolumeReceiver", paramContext);
                return;
              }
            }
          }
          if (paramIntent.getAction().equals("android.intent.action.HEADSET_PLUG"))
          {
            boolean bool = FastWebVideoVolumeControl.a(this.a).isWiredHeadsetOn();
            if (FastWebVideoVolumeControl.f(this.a))
            {
              FastWebVideoVolumeControl.b(this.a, false);
              return;
            }
            FastWebVideoVolumeControl.c(this.a, true);
            if (bool) {
              this.a.a(false, "headset on", FastWebVideoVolumeControl.a(this.a));
            }
            for (;;)
            {
              FastWebVideoVolumeControl.a(this.a).postDelayed(new mto(this), 200L);
              return;
              this.a.a(true, "headset off", FastWebVideoVolumeControl.a(this.a));
            }
          }
          if (paramIntent.getAction().equals("android.media.AUDIO_BECOMING_NOISY"))
          {
            this.a.a(true, "headset off from noisy", 0);
            return;
          }
        } while (!paramIntent.getAction().equals("android.media.RINGER_MODE_CHANGED"));
        i = FastWebVideoVolumeControl.a(this.a).getRingerMode();
      } while (FastWebVideoVolumeControl.b(this.a) == i);
      FastWebVideoVolumeControl.a(this.a, i);
      if ((i == 0) || (i == 1))
      {
        this.a.a(true, "ringset off", FastWebVideoVolumeControl.a(this.a));
        return;
      }
    } while (i != 2);
    this.a.a(false, "ringset on", FastWebVideoVolumeControl.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mtn
 * JD-Core Version:    0.7.0.1
 */
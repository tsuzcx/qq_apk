package com.tencent.mobileqq.kandian.glue.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class VideoVolumeControl$VolumeReceiver
  extends BroadcastReceiver
{
  private VideoVolumeControl$VolumeReceiver(VideoVolumeControl paramVideoVolumeControl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!BaseApplicationImpl.getApplication().getRuntime().isBackgroundStop)
    {
      if (BaseApplicationImpl.getApplication().getRuntime().isBackgroundPause) {
        return;
      }
      if (VideoVolumeControl.access$700(this.a)) {
        return;
      }
      if (VideoVolumeControl.access$800(this.a))
      {
        VideoVolumeControl.access$802(this.a, false);
        return;
      }
      if (VideoVolumeControl.access$100(this.a) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "VolumeReceiver onReceive null");
        }
        return;
      }
      if (!VideoVolumeControl.access$600(this.a)) {
        return;
      }
      if (VideoVolumeControl.access$900(this.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "dynamicPauseReceive true");
        }
        return;
      }
      try
      {
        if (paramIntent.getAction().equals("android.media.VOLUME_CHANGED_ACTION"))
        {
          int i = VideoVolumeControl.access$100(this.a).getStreamVolume(3);
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("volume change:");
            paramContext.append(i);
            QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, paramContext.toString());
          }
          if (VideoVolumeControl.access$1000(this.a))
          {
            QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "volume change shield ");
            return;
          }
          if (i == 0)
          {
            this.a.setMute(true, "system volume 0", VideoVolumeControl.access$1100(this.a));
            return;
          }
          this.a.setMute(false, "system volume change", VideoVolumeControl.access$1100(this.a));
          return;
        }
        if (paramIntent.getAction().equals("android.intent.action.HEADSET_PLUG"))
        {
          boolean bool = VideoVolumeControl.access$100(this.a).isWiredHeadsetOn();
          if (VideoVolumeControl.access$1200(this.a))
          {
            VideoVolumeControl.access$1202(this.a, false);
            return;
          }
          VideoVolumeControl.access$1002(this.a, true);
          if (bool) {
            this.a.setMute(false, "headset on", VideoVolumeControl.access$1100(this.a));
          } else {
            this.a.setMute(true, "headset off", VideoVolumeControl.access$1100(this.a));
          }
          VideoVolumeControl.access$1300(this.a).postDelayed(new VideoVolumeControl.VolumeReceiver.1(this), 200L);
          return;
        }
      }
      catch (Exception paramContext)
      {
        QLog.d("Q.readinjoy.video.VideoVolumeControl", 1, "VolumeReceiver", paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl.VolumeReceiver
 * JD-Core Version:    0.7.0.1
 */
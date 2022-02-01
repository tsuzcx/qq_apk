package com.tencent.mobileqq.kandian.glue.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController.EventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

class VideoVolumeController$VolumeReceiver
  extends BroadcastReceiver
{
  private VideoVolumeController$VolumeReceiver(VideoVolumeController paramVideoVolumeController) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!BaseApplicationImpl.getApplication().getRuntime().isBackgroundStop)
    {
      if (BaseApplicationImpl.getApplication().getRuntime().isBackgroundPause) {
        return;
      }
      if (VideoVolumeController.access$300(this.a) == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoVolumeController", 2, "VolumeReceiver onReceive null");
        }
        return;
      }
      if (!VideoVolumeController.access$500(this.a)) {
        return;
      }
      if (VideoVolumeController.access$600(this.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoVolumeController", 2, "dynamicPauseReceive true");
        }
        return;
      }
      try
      {
        if (paramIntent.getAction().equals("android.media.VOLUME_CHANGED_ACTION"))
        {
          int i = VideoVolumeController.access$300(this.a).getStreamVolume(3);
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("volume change:");
            paramContext.append(i);
            QLog.d("VideoVolumeController", 2, paramContext.toString());
          }
          if (VideoVolumeController.access$700(this.a))
          {
            QLog.d("VideoVolumeController", 2, "volume change shield ");
            return;
          }
          paramContext = VideoVolumeController.access$800(this.a).iterator();
          while (paramContext.hasNext()) {
            ((IVideoVolumeController.EventListener)paramContext.next()).onSystemVolumeChanged(i);
          }
        }
        if (paramIntent.getAction().equals("android.intent.action.HEADSET_PLUG"))
        {
          boolean bool = VideoVolumeController.access$300(this.a).isWiredHeadsetOn();
          if (VideoVolumeController.access$900(this.a))
          {
            VideoVolumeController.access$902(this.a, false);
            return;
          }
          VideoVolumeController.access$702(this.a, true);
          paramContext = VideoVolumeController.access$800(this.a).iterator();
          while (paramContext.hasNext()) {
            ((IVideoVolumeController.EventListener)paramContext.next()).onHeadsetStateChanged(bool);
          }
          VideoVolumeController.access$1000(this.a).postDelayed(new VideoVolumeController.VolumeReceiver.1(this), 200L);
          return;
        }
      }
      catch (Exception paramContext)
      {
        QLog.d("VideoVolumeController", 1, "VolumeReceiver", paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoVolumeController.VolumeReceiver
 * JD-Core Version:    0.7.0.1
 */
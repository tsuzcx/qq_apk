package dov.com.tencent.mobileqq.activity.shortvideo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class ShortVideoPlayActivity$7
  extends BroadcastReceiver
{
  ShortVideoPlayActivity$7(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onReceive ===>" + paramContext);
    }
    if (("android.intent.action.SCREEN_OFF".equals(paramContext)) || ("tencent.av.v2q.StartVideoChat".equals(paramContext)))
    {
      if ((this.a.a != null) && (this.a.a.isPlaying())) {
        this.a.h = true;
      }
      this.a.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.7
 * JD-Core Version:    0.7.0.1
 */
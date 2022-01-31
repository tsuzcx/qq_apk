package com.tencent.mobileqq.mini.widget.media;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.mini.utils.ScreenOffOnListener.ReceiveListener;
import com.tencent.qphone.base.util.QLog;

class MiniAppAudioPlayer$1
  implements ScreenOffOnListener.ReceiveListener
{
  MiniAppAudioPlayer$1(MiniAppAudioPlayer paramMiniAppAudioPlayer) {}
  
  public void onReceiveListener(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    QLog.i("MiniAppAudioPlayer", 2, "onReceiveListener:" + paramContext);
    if (("android.intent.action.SCREEN_OFF".equals(paramContext)) && (this.this$0.isPlaying())) {
      this.this$0.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppAudioPlayer.1
 * JD-Core Version:    0.7.0.1
 */
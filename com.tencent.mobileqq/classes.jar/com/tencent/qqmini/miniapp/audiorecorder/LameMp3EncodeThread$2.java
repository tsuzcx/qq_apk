package com.tencent.qqmini.miniapp.audiorecorder;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class LameMp3EncodeThread$2
  implements MediaPlayer.OnCompletionListener
{
  LameMp3EncodeThread$2(LameMp3EncodeThread paramLameMp3EncodeThread) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    QMLog.i(LameMp3EncodeThread.TAG, "onCompletion");
    LameMp3EncodeThread.access$000(this.this$0).sendEmptyMessage(106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.audiorecorder.LameMp3EncodeThread.2
 * JD-Core Version:    0.7.0.1
 */
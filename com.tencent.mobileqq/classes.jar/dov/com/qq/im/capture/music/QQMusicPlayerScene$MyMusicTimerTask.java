package dov.com.qq.im.capture.music;

import bhtd;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

class QQMusicPlayerScene$MyMusicTimerTask
  extends TimerTask
{
  private QQMusicPlayerScene$MyMusicTimerTask(QQMusicPlayerScene paramQQMusicPlayerScene) {}
  
  public void run()
  {
    this.this$0.a.sendEmptyMessage(1);
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicPlayerScene", 2, "MyMusicTimerTask MSG_MUSIC_REPLAY");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QQMusicPlayerScene.MyMusicTimerTask
 * JD-Core Version:    0.7.0.1
 */
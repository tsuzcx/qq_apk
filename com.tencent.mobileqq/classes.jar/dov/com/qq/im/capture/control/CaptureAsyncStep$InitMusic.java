package dov.com.qq.im.capture.control;

import com.tencent.mobileqq.app.automator.AsyncStep;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.QimMusicPlayer;

public class CaptureAsyncStep$InitMusic
  extends AsyncStep
{
  public int a()
  {
    QimMusicPlayer localQimMusicPlayer = (QimMusicPlayer)QIMManager.a().c(8);
    if (localQimMusicPlayer != null) {
      localQimMusicPlayer.c();
    }
    ((QIMMusicConfigManager)QIMManager.a(2)).forceInit();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.InitMusic
 * JD-Core Version:    0.7.0.1
 */
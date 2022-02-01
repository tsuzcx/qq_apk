package cooperation.qzone.music;

import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;

class QzoneWebMusicJsPlugin$15
  implements Runnable
{
  QzoneWebMusicJsPlugin$15(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void run()
  {
    RemoteHandleManager.getInstance().getSender().initUserInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin.15
 * JD-Core Version:    0.7.0.1
 */
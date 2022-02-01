package cooperation.qzone.music;

import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;

class QzoneWebMusicJsPlugin$20
  implements Runnable
{
  QzoneWebMusicJsPlugin$20(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void run()
  {
    RemoteHandleManager.getInstance().getSender().getPlayMode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin.20
 * JD-Core Version:    0.7.0.1
 */
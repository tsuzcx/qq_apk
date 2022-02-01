package cooperation.qzone.music;

import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;

class QzoneWebMusicJsPlugin$17
  implements Runnable
{
  QzoneWebMusicJsPlugin$17(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void run()
  {
    RemoteHandleManager.getInstance().getSender().getPlayingSong();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin.17
 * JD-Core Version:    0.7.0.1
 */
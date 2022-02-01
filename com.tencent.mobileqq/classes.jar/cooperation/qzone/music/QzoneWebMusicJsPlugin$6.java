package cooperation.qzone.music;

import awgo;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import org.json.JSONObject;

class QzoneWebMusicJsPlugin$6
  implements Runnable
{
  QzoneWebMusicJsPlugin$6(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void run()
  {
    RemoteHandleManager.getInstance().getSender().stopPlay();
    awgo.a(new JSONObject(), "stopMusicBox", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */
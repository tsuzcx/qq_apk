package cooperation.qzone.music;

import awgo;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import org.json.JSONObject;

class QzoneWebMusicJsPlugin$13
  implements Runnable
{
  QzoneWebMusicJsPlugin$13(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void run()
  {
    RemoteHandleManager.getInstance().getSender().pausePlay();
    awgo.a(new JSONObject(), "pauseFloatView", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin.13
 * JD-Core Version:    0.7.0.1
 */
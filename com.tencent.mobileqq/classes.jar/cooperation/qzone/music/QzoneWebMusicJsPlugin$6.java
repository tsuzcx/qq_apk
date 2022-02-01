package cooperation.qzone.music;

import com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleWebClient;
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
    ListenTogetherIPCModuleWebClient.a(new JSONObject(), "stopMusicBox", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */
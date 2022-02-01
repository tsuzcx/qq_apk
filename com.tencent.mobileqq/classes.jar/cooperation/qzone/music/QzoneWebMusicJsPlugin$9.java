package cooperation.qzone.music;

import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import java.util.ArrayList;

class QzoneWebMusicJsPlugin$9
  implements Runnable
{
  QzoneWebMusicJsPlugin$9(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin, int paramInt1, int paramInt2, ArrayList paramArrayList) {}
  
  public void run()
  {
    RemoteHandleManager.getInstance().getSender().playAudioList(QzoneWebMusicJsPlugin.access$200(this.this$0), this.val$_origin, this.val$_index, this.val$_shows, 102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */
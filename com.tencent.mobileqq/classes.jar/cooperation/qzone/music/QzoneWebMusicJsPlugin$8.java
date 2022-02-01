package cooperation.qzone.music;

import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import java.util.ArrayList;

class QzoneWebMusicJsPlugin$8
  implements Runnable
{
  QzoneWebMusicJsPlugin$8(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    RemoteHandleManager.getInstance().getSender().playMusicList(QzoneWebMusicJsPlugin.access$200(this.this$0), 2, this.val$_index, this.val$_songs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */
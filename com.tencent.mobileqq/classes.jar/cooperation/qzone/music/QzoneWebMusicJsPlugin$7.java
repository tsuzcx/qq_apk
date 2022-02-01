package cooperation.qzone.music;

import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import java.util.ArrayList;

class QzoneWebMusicJsPlugin$7
  implements Runnable
{
  QzoneWebMusicJsPlugin$7(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    RemoteHandleManager.getInstance().getSender().playMusicList(QzoneWebMusicJsPlugin.access$200(this.this$0), this.val$origin, 0, this.val$_list);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */
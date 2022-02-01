package cooperation.qzone.music;

import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import java.util.ArrayList;

class QzoneWebMusicJsPlugin$11
  implements Runnable
{
  QzoneWebMusicJsPlugin$11(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin, int paramInt1, int paramInt2, ArrayList paramArrayList) {}
  
  public void run()
  {
    RemoteHandleManager.getInstance().getSender().playFmBroadCastList(QzoneWebMusicJsPlugin.access$200(this.this$0), this.val$_origin, this.val$_index, this.val$_shows);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin.11
 * JD-Core Version:    0.7.0.1
 */
package cooperation.qzone.webviewplugin;

import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;

class QzoneVideoTabJsPlugin$5
  implements Runnable
{
  QzoneVideoTabJsPlugin$5(QzoneVideoTabJsPlugin paramQzoneVideoTabJsPlugin, String paramString) {}
  
  public void run()
  {
    RemoteHandleManager.getInstance().getSender().downloadVideo(this.val$videoUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneVideoTabJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */
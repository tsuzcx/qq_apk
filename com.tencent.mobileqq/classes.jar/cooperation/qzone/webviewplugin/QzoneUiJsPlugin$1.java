package cooperation.qzone.webviewplugin;

import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;

class QzoneUiJsPlugin$1
  implements Runnable
{
  QzoneUiJsPlugin$1(QzoneUiJsPlugin paramQzoneUiJsPlugin, String paramString) {}
  
  public void run()
  {
    RemoteHandleManager.getInstance().getSender().deleteTempVideo(this.val$videoPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneUiJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
package cooperation.qzone.webviewplugin;

import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;

class QzoneUiJsPlugin$2
  implements Runnable
{
  QzoneUiJsPlugin$2(QzoneUiJsPlugin paramQzoneUiJsPlugin, String paramString) {}
  
  public void run()
  {
    RemoteHandleManager.getInstance().getSender().uploadVideoForH5(this.val$jsonString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneUiJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */
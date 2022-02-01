package cooperation.qzone.webviewplugin;

import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;

class QzoneUiJsPlugin$3
  implements Runnable
{
  QzoneUiJsPlugin$3(QzoneUiJsPlugin paramQzoneUiJsPlugin, String paramString) {}
  
  public void run()
  {
    RemoteHandleManager.getInstance().getSender().getFakeFeedVideoCover(this.val$timestamp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneUiJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */
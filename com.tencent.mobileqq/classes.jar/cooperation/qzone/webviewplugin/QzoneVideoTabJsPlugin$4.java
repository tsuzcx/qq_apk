package cooperation.qzone.webviewplugin;

import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;

class QzoneVideoTabJsPlugin$4
  implements Runnable
{
  QzoneVideoTabJsPlugin$4(QzoneVideoTabJsPlugin paramQzoneVideoTabJsPlugin) {}
  
  public void run()
  {
    RemoteHandleManager.getInstance().getSender().stopAllVideo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneVideoTabJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */
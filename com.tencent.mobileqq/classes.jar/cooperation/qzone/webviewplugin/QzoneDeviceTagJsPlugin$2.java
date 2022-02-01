package cooperation.qzone.webviewplugin;

import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;

final class QzoneDeviceTagJsPlugin$2
  implements Runnable
{
  public void run()
  {
    RemoteHandleManager.getInstance().getSender().getDeviceInfos();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneDeviceTagJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */
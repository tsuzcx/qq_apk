package cooperation.qzone.webviewplugin;

import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;

class QzoneRecommedPhotoJsPlugin$3
  implements Runnable
{
  QzoneRecommedPhotoJsPlugin$3(QzoneRecommedPhotoJsPlugin paramQzoneRecommedPhotoJsPlugin) {}
  
  public void run()
  {
    RemoteHandleManager.getInstance().getSender().getLocalPhotoSwitcher();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */
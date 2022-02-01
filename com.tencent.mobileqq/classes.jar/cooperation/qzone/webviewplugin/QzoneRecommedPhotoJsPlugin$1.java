package cooperation.qzone.webviewplugin;

import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;

class QzoneRecommedPhotoJsPlugin$1
  implements Runnable
{
  QzoneRecommedPhotoJsPlugin$1(QzoneRecommedPhotoJsPlugin paramQzoneRecommedPhotoJsPlugin) {}
  
  public void run()
  {
    RemoteHandleManager.getInstance().getSender().getEventVideoAlbumState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneRecommedPhotoJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */
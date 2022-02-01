package cooperation.qzone.webviewplugin;

import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;

class QzoneDynamicAlbumPlugin$1
  implements Runnable
{
  QzoneDynamicAlbumPlugin$1(QzoneDynamicAlbumPlugin paramQzoneDynamicAlbumPlugin) {}
  
  public void run()
  {
    QzoneDynamicAlbumPlugin.access$002(QzoneDynamicAlbumPlugin.getDynamicAlbumImageSize());
    RemoteHandleManager.getInstance().getSender().getDynamicPhoto("0");
    RemoteHandleManager.getInstance().getSender().getCloudPhotoDynamic("0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.1
 * JD-Core Version:    0.7.0.1
 */
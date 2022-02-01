package cooperation.qzone.webviewplugin;

import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;

class QzoneDynamicAlbumPlugin$4
  implements Runnable
{
  QzoneDynamicAlbumPlugin$4(QzoneDynamicAlbumPlugin paramQzoneDynamicAlbumPlugin) {}
  
  public void run()
  {
    RemoteHandleManager.getInstance().getSender().cancelAllupload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.4
 * JD-Core Version:    0.7.0.1
 */
package cooperation.qzone.webviewplugin;

import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;

class QzoneDynamicAlbumPlugin$3
  implements Runnable
{
  QzoneDynamicAlbumPlugin$3(QzoneDynamicAlbumPlugin paramQzoneDynamicAlbumPlugin, String paramString) {}
  
  public void run()
  {
    RemoteHandleManager.getInstance().getSender().getDynamicselNum(this.val$cmd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin.3
 * JD-Core Version:    0.7.0.1
 */
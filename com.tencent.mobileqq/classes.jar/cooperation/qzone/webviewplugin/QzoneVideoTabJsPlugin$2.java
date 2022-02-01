package cooperation.qzone.webviewplugin;

import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import java.util.ArrayList;

class QzoneVideoTabJsPlugin$2
  implements Runnable
{
  QzoneVideoTabJsPlugin$2(QzoneVideoTabJsPlugin paramQzoneVideoTabJsPlugin, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    RemoteHandleManager.getInstance().getSender().getVideoLocalProxyUrl(this.val$urls, this.val$vids);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneVideoTabJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */
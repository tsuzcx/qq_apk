package cooperation.qzone.webviewplugin;

import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import java.util.ArrayList;

class QzoneVideoTabJsPlugin$3
  implements Runnable
{
  QzoneVideoTabJsPlugin$3(QzoneVideoTabJsPlugin paramQzoneVideoTabJsPlugin, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    RemoteHandleManager.getInstance().getSender().setVideoState(this.val$urls, this.val$states);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneVideoTabJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */
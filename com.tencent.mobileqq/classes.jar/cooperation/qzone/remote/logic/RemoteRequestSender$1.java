package cooperation.qzone.remote.logic;

import android.os.Bundle;

class RemoteRequestSender$1
  implements Runnable
{
  RemoteRequestSender$1(RemoteRequestSender paramRemoteRequestSender, Bundle paramBundle) {}
  
  public void run()
  {
    RemoteRequestSender.access$000(this.this$0).sendData("cmd.gdtreport.webview", this.val$bundle, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.remote.logic.RemoteRequestSender.1
 * JD-Core Version:    0.7.0.1
 */
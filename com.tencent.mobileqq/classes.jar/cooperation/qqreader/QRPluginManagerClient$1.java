package cooperation.qqreader;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import cooperation.qqreader.utils.Log;
import eipc.EIPCClient;
import eipc.EIPCResult;

class QRPluginManagerClient$1
  implements Runnable
{
  QRPluginManagerClient$1(QRPluginManagerClient paramQRPluginManagerClient) {}
  
  public void run()
  {
    Log.d("QRPluginManagerClient", "launchPlugin");
    Object localObject = QIPCClientHelper.getInstance().getClient().callServer("ReaderIPCModule", "download_reader_plugin", new Bundle());
    StringBuilder localStringBuilder;
    if ((localObject == null) || (!((EIPCResult)localObject).isSuccess()))
    {
      localStringBuilder = new StringBuilder().append("launchPlugin: IPC failed: ");
      if (localObject != null) {
        break label82;
      }
    }
    label82:
    for (localObject = "null";; localObject = ((EIPCResult)localObject).e.toString())
    {
      Log.a("QRPluginManagerClient", (String)localObject);
      QRPluginManagerClient.a(this.this$0, 0L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.QRPluginManagerClient.1
 * JD-Core Version:    0.7.0.1
 */
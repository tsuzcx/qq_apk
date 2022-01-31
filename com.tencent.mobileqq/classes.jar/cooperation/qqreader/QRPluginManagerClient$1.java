package cooperation.qqreader;

import android.os.Bundle;
import biuv;
import bixe;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class QRPluginManagerClient$1
  implements Runnable
{
  public QRPluginManagerClient$1(biuv parambiuv) {}
  
  public void run()
  {
    bixe.d("QRPluginManagerClient", "launchPlugin");
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
      bixe.a("QRPluginManagerClient", (String)localObject);
      biuv.a(this.this$0, 0L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.QRPluginManagerClient.1
 * JD-Core Version:    0.7.0.1
 */
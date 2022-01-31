package cooperation.qqreader;

import android.os.Bundle;
import bgtw;
import bgwf;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class QRPluginManagerClient$1
  implements Runnable
{
  public QRPluginManagerClient$1(bgtw parambgtw) {}
  
  public void run()
  {
    bgwf.d("QRPluginManagerClient", "launchPlugin");
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
      bgwf.a("QRPluginManagerClient", (String)localObject);
      bgtw.a(this.this$0, 0L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.QRPluginManagerClient.1
 * JD-Core Version:    0.7.0.1
 */
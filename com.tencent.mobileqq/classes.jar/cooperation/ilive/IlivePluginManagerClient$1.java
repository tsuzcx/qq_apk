package cooperation.ilive;

import android.os.Bundle;
import bluq;
import bmgm;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class IlivePluginManagerClient$1
  implements Runnable
{
  public void run()
  {
    bmgm.d("IlivePluginManagerClient", "launchPlugin");
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
      bmgm.a("IlivePluginManagerClient", (String)localObject);
      bluq.a(this.this$0, 0L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.IlivePluginManagerClient.1
 * JD-Core Version:    0.7.0.1
 */
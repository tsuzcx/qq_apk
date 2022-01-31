package cooperation.qqreader;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;

final class QRBridgeUtil$1
  implements Runnable
{
  public void run()
  {
    QIPCClientHelper.getInstance().getClient().callServer("ReaderIPCModule", "download_reader_plugin", new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.QRBridgeUtil.1
 * JD-Core Version:    0.7.0.1
 */
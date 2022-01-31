package cooperation.qqpim;

import android.os.Bundle;
import bfkr;
import bfkw;
import com.tencent.mobileqq.qipc.QIPCServerHelper;

public class QQPimGetTipsInfoIPC$NoticeClickTipsRunnable
  implements Runnable
{
  private QQPimGetTipsInfoIPC$NoticeClickTipsRunnable(QQPimGetTipsInfoIPC paramQQPimGetTipsInfoIPC) {}
  
  public void run()
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(bfkr.r, 3);
      QIPCServerHelper.getInstance().callClient(bfkr.b, bfkr.c, bfkr.e, localBundle, new bfkw(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqpim.QQPimGetTipsInfoIPC.NoticeClickTipsRunnable
 * JD-Core Version:    0.7.0.1
 */
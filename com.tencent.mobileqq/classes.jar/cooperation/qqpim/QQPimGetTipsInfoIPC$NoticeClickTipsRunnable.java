package cooperation.qqpim;

import android.os.Bundle;
import bgsj;
import bgso;
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
      localBundle.putInt(bgsj.r, 3);
      QIPCServerHelper.getInstance().callClient(bgsj.b, bgsj.c, bgsj.e, localBundle, new bgso(this));
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
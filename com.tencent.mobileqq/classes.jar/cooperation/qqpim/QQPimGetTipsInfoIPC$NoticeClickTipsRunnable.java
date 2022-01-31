package cooperation.qqpim;

import android.os.Bundle;
import bitz;
import biue;
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
      localBundle.putInt(bitz.r, 3);
      QIPCServerHelper.getInstance().callClient(bitz.b, bitz.c, bitz.e, localBundle, new biue(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqpim.QQPimGetTipsInfoIPC.NoticeClickTipsRunnable
 * JD-Core Version:    0.7.0.1
 */
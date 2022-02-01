package cooperation.qqpim;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCServerHelper;

class QQPimGetTipsInfoIPC$NoticeClickTipsRunnable
  implements Runnable
{
  private QQPimGetTipsInfoIPC$NoticeClickTipsRunnable(QQPimGetTipsInfoIPC paramQQPimGetTipsInfoIPC) {}
  
  public void run()
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(QQPimDefineList.r, 3);
      QIPCServerHelper.getInstance().callClient(QQPimDefineList.b, QQPimDefineList.c, QQPimDefineList.e, localBundle, new QQPimGetTipsInfoIPC.NoticeClickTipsRunnable.1(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqpim.QQPimGetTipsInfoIPC.NoticeClickTipsRunnable
 * JD-Core Version:    0.7.0.1
 */
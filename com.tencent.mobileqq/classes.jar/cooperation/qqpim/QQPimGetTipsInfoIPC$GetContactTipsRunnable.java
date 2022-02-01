package cooperation.qqpim;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCServerHelper;

class QQPimGetTipsInfoIPC$GetContactTipsRunnable
  implements Runnable
{
  private String a;
  private String b;
  
  public QQPimGetTipsInfoIPC$GetContactTipsRunnable(QQPimGetTipsInfoIPC paramQQPimGetTipsInfoIPC, String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public void run()
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString(QQPimDefineList.l, this.a);
      localBundle.putString(QQPimDefineList.m, this.b);
      QIPCServerHelper.getInstance().callClient(QQPimDefineList.b, QQPimDefineList.c, QQPimDefineList.d, localBundle, new QQPimGetTipsInfoIPC.GetContactTipsRunnable.1(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqpim.QQPimGetTipsInfoIPC.GetContactTipsRunnable
 * JD-Core Version:    0.7.0.1
 */
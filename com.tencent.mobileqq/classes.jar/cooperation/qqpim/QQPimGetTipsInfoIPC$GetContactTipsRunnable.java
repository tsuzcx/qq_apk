package cooperation.qqpim;

import android.os.Bundle;
import bgta;
import bgtd;
import com.tencent.mobileqq.qipc.QIPCServerHelper;

public class QQPimGetTipsInfoIPC$GetContactTipsRunnable
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
      localBundle.putString(bgta.l, this.a);
      localBundle.putString(bgta.m, this.b);
      QIPCServerHelper.getInstance().callClient(bgta.b, bgta.c, bgta.d, localBundle, new bgtd(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqpim.QQPimGetTipsInfoIPC.GetContactTipsRunnable
 * JD-Core Version:    0.7.0.1
 */
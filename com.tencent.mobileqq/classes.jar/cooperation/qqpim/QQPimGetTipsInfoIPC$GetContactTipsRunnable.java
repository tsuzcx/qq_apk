package cooperation.qqpim;

import android.os.Bundle;
import bfkr;
import bfku;
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
      localBundle.putString(bfkr.l, this.a);
      localBundle.putString(bfkr.m, this.b);
      QIPCServerHelper.getInstance().callClient(bfkr.b, bfkr.c, bfkr.d, localBundle, new bfku(this));
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
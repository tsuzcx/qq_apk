package cooperation.qqpim;

import android.os.Bundle;
import bmnu;
import bmnx;
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
      localBundle.putString(bmnu.l, this.a);
      localBundle.putString(bmnu.m, this.b);
      QIPCServerHelper.getInstance().callClient(bmnu.b, bmnu.c, bmnu.d, localBundle, new bmnx(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqpim.QQPimGetTipsInfoIPC.GetContactTipsRunnable
 * JD-Core Version:    0.7.0.1
 */
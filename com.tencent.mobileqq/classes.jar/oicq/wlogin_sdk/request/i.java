package oicq.wlogin_sdk.request;

import java.net.HttpURLConnection;
import oicq.wlogin_sdk.tools.util;

public class i
  implements Runnable
{
  private HttpURLConnection a;
  private boolean b = false;
  
  public i(HttpURLConnection paramHttpURLConnection)
  {
    this.a = paramHttpURLConnection;
  }
  
  public static boolean a(HttpURLConnection paramHttpURLConnection, long paramLong)
  {
    try
    {
      paramHttpURLConnection = new i(paramHttpURLConnection);
      Thread localThread = new Thread(paramHttpURLConnection);
      localThread.start();
      localThread.join(paramLong);
      boolean bool = paramHttpURLConnection.a();
      return bool;
    }
    catch (Throwable paramHttpURLConnection)
    {
      label37:
      break label37;
    }
    return false;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void run()
  {
    try
    {
      this.a.connect();
      this.b = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      util.printThrowable(localThrowable, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.request.i
 * JD-Core Version:    0.7.0.1
 */
package cooperation.vip;

import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;

final class VasC2SReporter$1
  implements Runnable
{
  VasC2SReporter$1(String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        URL localURL = new URL(this.a);
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)localURL.openConnection();
        localHttpURLConnection.setRequestMethod("POST");
        localHttpURLConnection.setConnectTimeout(10000);
        localHttpURLConnection.setReadTimeout(10000);
        localHttpURLConnection.setUseCaches(false);
        localHttpURLConnection.connect();
        int i = localHttpURLConnection.getResponseCode();
        if (i == 200)
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.i("VasC2SReporter", 1, "exposure rspCode " + i + "， request C2S isSuccess:" + bool + ", url:" + localURL);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("VasC2SReporter", 2, localException.toString());
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.VasC2SReporter.1
 * JD-Core Version:    0.7.0.1
 */
package cooperation.vip.manager;

import cooperation.qzone.util.QZLog;
import java.net.HttpURLConnection;
import java.net.URL;

public class GdtGeneralManager$4
  implements Runnable
{
  public void run()
  {
    for (;;)
    {
      try
      {
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.a).openConnection();
        localHttpURLConnection.setRequestMethod("POST");
        localHttpURLConnection.setConnectTimeout(10000);
        localHttpURLConnection.setReadTimeout(10000);
        localHttpURLConnection.setUseCaches(false);
        localHttpURLConnection.connect();
        int i = localHttpURLConnection.getResponseCode();
        if (i == 200)
        {
          bool = true;
          if (QZLog.isColorLevel()) {
            QZLog.i("GdtGeneralManager", "@getGdtInfo exporsure rspCode " + i + "， request gdt" + bool);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        if (!QZLog.isColorLevel()) {
          continue;
        }
        QZLog.w("GdtGeneralManager", 2, new Object[] { localException.toString() });
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.manager.GdtGeneralManager.4
 * JD-Core Version:    0.7.0.1
 */
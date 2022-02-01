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
    try
    {
      URL localURL = new URL(this.a);
      Object localObject = (HttpURLConnection)localURL.openConnection();
      ((HttpURLConnection)localObject).setRequestMethod("POST");
      ((HttpURLConnection)localObject).setConnectTimeout(10000);
      ((HttpURLConnection)localObject).setReadTimeout(10000);
      boolean bool = false;
      ((HttpURLConnection)localObject).setUseCaches(false);
      ((HttpURLConnection)localObject).connect();
      int i = ((HttpURLConnection)localObject).getResponseCode();
      if (i == 200) {
        bool = true;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("exposure rspCode ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("， request C2S isSuccess:");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", url:");
        ((StringBuilder)localObject).append(localURL);
        QLog.i("VasC2SReporter", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("VasC2SReporter", 2, localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.VasC2SReporter.1
 * JD-Core Version:    0.7.0.1
 */
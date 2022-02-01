package cooperation.vip.manager;

import blbc;
import cooperation.qzone.util.QZLog;
import java.net.MalformedURLException;
import java.net.URL;

public class GdtGeneralManager$4
  implements Runnable
{
  public void run()
  {
    try
    {
      URL localURL = new URL(this.a);
      this.this$0.a(localURL);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      QZLog.e("GdtGeneralManager", 2, new Object[] { localMalformedURLException.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.manager.GdtGeneralManager.4
 * JD-Core Version:    0.7.0.1
 */
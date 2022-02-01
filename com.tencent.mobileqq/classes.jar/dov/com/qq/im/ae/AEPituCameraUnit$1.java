package dov.com.qq.im.ae;

import android.os.Process;
import bndy;
import bnzb;
import java.util.concurrent.CountDownLatch;

public class AEPituCameraUnit$1
  implements Runnable
{
  public AEPituCameraUnit$1(bndy parambndy) {}
  
  public void run()
  {
    try
    {
      bnzb.b("AEPituCameraUnit", "[AEPituCameraUnit] unit init ENTER");
      Process.setThreadPriority(-2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          bnzb.b("AEPituCameraUnit", "[AEPituCameraUnit] unit init BEGIN");
          bndy.a(this.this$0);
          bnzb.b("AEPituCameraUnit", "[AEPituCameraUnit] initAEKitReport-end");
          return;
        }
        finally
        {
          bndy.a(this.this$0).countDown();
        }
        localException = localException;
        bnzb.d("AEPituCameraUnit", "[UnitAsyncInit] setThreadPriority exception: " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.1
 * JD-Core Version:    0.7.0.1
 */
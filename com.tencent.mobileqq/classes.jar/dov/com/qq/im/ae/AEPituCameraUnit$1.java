package dov.com.qq.im.ae;

import android.os.Process;
import bkle;
import blfg;
import java.util.concurrent.CountDownLatch;

public class AEPituCameraUnit$1
  implements Runnable
{
  public AEPituCameraUnit$1(bkle parambkle) {}
  
  public void run()
  {
    try
    {
      blfg.b("AEPituCameraUnit", "[AEPituCameraUnit] unit init ENTER");
      Process.setThreadPriority(-2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          blfg.b("AEPituCameraUnit", "[AEPituCameraUnit] unit init BEGIN");
          bkle.a(this.this$0);
          blfg.b("AEPituCameraUnit", "[AEPituCameraUnit] initAEKitReport-end");
          bkle.b(this.this$0);
          blfg.b("AEPituCameraUnit", "[AEPituCameraUnit] unit init END");
          return;
        }
        finally
        {
          bkle.a(this.this$0).countDown();
        }
        localException = localException;
        blfg.d("AEPituCameraUnit", "[UnitAsyncInit] setThreadPriority exception: " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.1
 * JD-Core Version:    0.7.0.1
 */
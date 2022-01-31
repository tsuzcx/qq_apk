package dov.com.qq.im.ae;

import android.os.Process;
import biim;
import bizq;
import java.util.concurrent.CountDownLatch;

public class AEPituCameraUnit$1
  implements Runnable
{
  public AEPituCameraUnit$1(biim parambiim) {}
  
  public void run()
  {
    try
    {
      bizq.b("AEPituCameraUnit", "[AEPituCameraUnit] unit init ENTER");
      Process.setThreadPriority(-2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          bizq.b("AEPituCameraUnit", "[AEPituCameraUnit] unit init BEGIN");
          biim.a(this.this$0);
          bizq.b("AEPituCameraUnit", "[AEPituCameraUnit] initAEKitReport-end");
          biim.b(this.this$0);
          bizq.b("AEPituCameraUnit", "[AEPituCameraUnit] unit init END");
          return;
        }
        finally
        {
          biim.a(this.this$0).countDown();
        }
        localException = localException;
        bizq.d("AEPituCameraUnit", "[UnitAsyncInit] setThreadPriority exception: " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.1
 * JD-Core Version:    0.7.0.1
 */
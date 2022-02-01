package dov.com.qq.im.ae;

import android.os.Process;
import bmxa;
import bnrh;
import java.util.concurrent.CountDownLatch;

public class AEPituCameraUnit$8
  implements Runnable
{
  public AEPituCameraUnit$8(bmxa parambmxa) {}
  
  public void run()
  {
    try
    {
      bnrh.b(this.this$0.a, "[AEPituCameraUnit] unit init ENTER");
      Process.setThreadPriority(-2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          bnrh.b(this.this$0.a, "[AEPituCameraUnit] unit init BEGIN");
          bmxa.b(this.this$0);
          bnrh.b(this.this$0.a, "[AEPituCameraUnit] initAEKitReport-end");
          return;
        }
        finally
        {
          bmxa.a(this.this$0).countDown();
        }
        localException = localException;
        bnrh.d(this.this$0.a, "[UnitAsyncInit] setThreadPriority exception: " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.8
 * JD-Core Version:    0.7.0.1
 */
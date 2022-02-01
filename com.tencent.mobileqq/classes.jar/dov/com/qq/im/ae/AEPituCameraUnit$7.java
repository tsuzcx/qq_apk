package dov.com.qq.im.ae;

import android.os.Process;
import bljy;
import bmbx;
import java.util.concurrent.CountDownLatch;

public class AEPituCameraUnit$7
  implements Runnable
{
  public AEPituCameraUnit$7(bljy parambljy) {}
  
  public void run()
  {
    try
    {
      bmbx.b(this.this$0.a, "[AEPituCameraUnit] unit init ENTER");
      Process.setThreadPriority(-2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          bmbx.b(this.this$0.a, "[AEPituCameraUnit] unit init BEGIN");
          bljy.c(this.this$0);
          bmbx.b(this.this$0.a, "[AEPituCameraUnit] initAEKitReport-end");
          return;
        }
        finally
        {
          bljy.a(this.this$0).countDown();
        }
        localException = localException;
        bmbx.d(this.this$0.a, "[UnitAsyncInit] setThreadPriority exception: " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.7
 * JD-Core Version:    0.7.0.1
 */
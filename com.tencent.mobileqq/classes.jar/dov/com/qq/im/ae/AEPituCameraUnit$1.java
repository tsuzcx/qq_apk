package dov.com.qq.im.ae;

import android.os.Process;
import bkpl;
import bljn;
import java.util.concurrent.CountDownLatch;

public class AEPituCameraUnit$1
  implements Runnable
{
  public AEPituCameraUnit$1(bkpl parambkpl) {}
  
  public void run()
  {
    try
    {
      bljn.b("AEPituCameraUnit", "[AEPituCameraUnit] unit init ENTER");
      Process.setThreadPriority(-2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          bljn.b("AEPituCameraUnit", "[AEPituCameraUnit] unit init BEGIN");
          bkpl.a(this.this$0);
          bljn.b("AEPituCameraUnit", "[AEPituCameraUnit] initAEKitReport-end");
          bkpl.b(this.this$0);
          bljn.b("AEPituCameraUnit", "[AEPituCameraUnit] unit init END");
          return;
        }
        finally
        {
          bkpl.a(this.this$0).countDown();
        }
        localException = localException;
        bljn.d("AEPituCameraUnit", "[UnitAsyncInit] setThreadPriority exception: " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.1
 * JD-Core Version:    0.7.0.1
 */
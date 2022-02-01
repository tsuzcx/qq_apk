package dov.com.qq.im.ae;

import android.os.Process;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.concurrent.CountDownLatch;

class AEPituCameraUnit$8
  implements Runnable
{
  AEPituCameraUnit$8(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void run()
  {
    try
    {
      AEQLog.b(this.this$0.b, "[AEPituCameraUnit] unit init ENTER");
      Process.setThreadPriority(-2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          AEQLog.b(this.this$0.b, "[AEPituCameraUnit] unit init BEGIN");
          AEPituCameraUnit.b(this.this$0);
          AEQLog.b(this.this$0.b, "[AEPituCameraUnit] initAEKitReport-end");
          return;
        }
        finally
        {
          AEPituCameraUnit.a(this.this$0).countDown();
        }
        localException = localException;
        AEQLog.d(this.this$0.b, "[UnitAsyncInit] setThreadPriority exception: " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.8
 * JD-Core Version:    0.7.0.1
 */
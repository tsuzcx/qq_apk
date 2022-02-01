package dov.com.qq.im.ae;

import android.os.Process;
import bofh;
import bpam;
import java.util.concurrent.CountDownLatch;

public class AEPituCameraUnit$1
  implements Runnable
{
  public AEPituCameraUnit$1(bofh parambofh) {}
  
  public void run()
  {
    try
    {
      bpam.b("AEPituCameraUnit", "[AEPituCameraUnit] unit init ENTER");
      Process.setThreadPriority(-2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          bpam.b("AEPituCameraUnit", "[AEPituCameraUnit] unit init BEGIN");
          bofh.a(this.this$0);
          bpam.b("AEPituCameraUnit", "[AEPituCameraUnit] initAEKitReport-end");
          return;
        }
        finally
        {
          bofh.a(this.this$0).countDown();
        }
        localException = localException;
        bpam.d("AEPituCameraUnit", "[UnitAsyncInit] setThreadPriority exception: " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.1
 * JD-Core Version:    0.7.0.1
 */
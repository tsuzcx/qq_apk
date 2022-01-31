package dov.com.qq.im.ae;

import android.os.Process;
import bijd;
import bjah;
import java.util.concurrent.CountDownLatch;

public class AEPituCameraUnit$1
  implements Runnable
{
  public AEPituCameraUnit$1(bijd parambijd) {}
  
  public void run()
  {
    try
    {
      bjah.b("AEPituCameraUnit", "[AEPituCameraUnit] unit init ENTER");
      Process.setThreadPriority(-2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          bjah.b("AEPituCameraUnit", "[AEPituCameraUnit] unit init BEGIN");
          bijd.a(this.this$0);
          bjah.b("AEPituCameraUnit", "[AEPituCameraUnit] initAEKitReport-end");
          bijd.b(this.this$0);
          bjah.b("AEPituCameraUnit", "[AEPituCameraUnit] unit init END");
          return;
        }
        finally
        {
          bijd.a(this.this$0).countDown();
        }
        localException = localException;
        bjah.d("AEPituCameraUnit", "[UnitAsyncInit] setThreadPriority exception: " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.1
 * JD-Core Version:    0.7.0.1
 */
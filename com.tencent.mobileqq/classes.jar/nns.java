import com.tencent.avgame.qav.AVGameCameraAssistant;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class nns
  extends ljr
{
  public nns(AVGameCameraAssistant paramAVGameCameraAssistant) {}
  
  protected void a(long paramLong)
  {
    try
    {
      Iterator localIterator = AVGameCameraAssistant.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        nnt localnnt = (nnt)localIterator.next();
        if (localnnt != null) {
          localnnt.a(paramLong);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("AVGameCameraAssistant", 1, "onBeforeCloseCamera", localThrowable);
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    try
    {
      Iterator localIterator = AVGameCameraAssistant.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        nnt localnnt = (nnt)localIterator.next();
        if (localnnt != null) {
          localnnt.a(paramLong, paramBoolean);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("AVGameCameraAssistant", 1, "onBeforeOpenCamera", localThrowable);
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    try
    {
      Iterator localIterator = AVGameCameraAssistant.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        nnt localnnt = (nnt)localIterator.next();
        if (localnnt != null) {
          localnnt.b(paramLong, paramBoolean);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("AVGameCameraAssistant", 1, "onAfterOpenCamera", localThrowable);
    }
  }
  
  protected void b(long paramLong, boolean paramBoolean)
  {
    try
    {
      Iterator localIterator = AVGameCameraAssistant.a(this.a).iterator();
      while (localIterator.hasNext())
      {
        nnt localnnt = (nnt)localIterator.next();
        if (localnnt != null) {
          localnnt.c(paramLong, paramBoolean);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("AVGameCameraAssistant", 1, "onAfterCloseCamera", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nns
 * JD-Core Version:    0.7.0.1
 */
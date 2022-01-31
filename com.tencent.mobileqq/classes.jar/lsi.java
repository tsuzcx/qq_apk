import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;

public abstract class lsi
  extends lsm
{
  protected Handler a;
  
  public lsi()
  {
    HandlerThread localHandlerThread = new HandlerThread("OffscreenGLThread" + (int)(Math.random() * 100.0D));
    localHandlerThread.start();
    this.a = new lsj(localHandlerThread.getLooper(), this);
  }
  
  protected abstract void a(Message paramMessage);
  
  protected void b()
  {
    super.b();
    Process.setThreadPriority(0);
    lek.c("GLContextThread", "init: ");
  }
  
  protected void d()
  {
    super.e();
    this.a.getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lsi
 * JD-Core Version:    0.7.0.1
 */
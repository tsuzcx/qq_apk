import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;

public abstract class lqc
  extends lqg
{
  protected Handler a;
  
  public lqc()
  {
    HandlerThread localHandlerThread = new HandlerThread("OffscreenGLThread" + (int)(Math.random() * 100.0D));
    localHandlerThread.start();
    this.a = new lqd(localHandlerThread.getLooper(), this);
  }
  
  protected abstract void a(Message paramMessage);
  
  protected void b()
  {
    super.b();
    Process.setThreadPriority(0);
    lcg.c("GLContextThread", "init: ");
  }
  
  protected void d()
  {
    super.e();
    this.a.getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lqc
 * JD-Core Version:    0.7.0.1
 */
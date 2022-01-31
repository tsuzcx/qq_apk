import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;

public abstract class lfq
  extends lfu
{
  protected Handler a;
  
  public lfq()
  {
    HandlerThread localHandlerThread = new HandlerThread("OffscreenGLThread" + (int)(Math.random() * 100.0D));
    localHandlerThread.start();
    this.a = new lfr(localHandlerThread.getLooper(), this);
  }
  
  protected abstract void a(Message paramMessage);
  
  protected void b()
  {
    super.b();
    Process.setThreadPriority(0);
    krx.c("GLContextThread", "init: ");
  }
  
  protected void d()
  {
    super.e();
    this.a.getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lfq
 * JD-Core Version:    0.7.0.1
 */
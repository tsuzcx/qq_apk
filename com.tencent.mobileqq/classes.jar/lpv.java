import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;

public abstract class lpv
  extends lqa
{
  protected Handler a;
  
  public lpv()
  {
    HandlerThread localHandlerThread = new HandlerThread("OffscreenGLThread" + (int)(Math.random() * 100.0D));
    localHandlerThread.start();
    this.a = new lpw(localHandlerThread.getLooper(), this);
  }
  
  protected abstract void a(Message paramMessage);
  
  protected void c()
  {
    super.c();
    Process.setThreadPriority(0);
    lbj.c("GLContextThread", "init: ");
  }
  
  protected void d()
  {
    super.f();
    this.a.getLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lpv
 * JD-Core Version:    0.7.0.1
 */
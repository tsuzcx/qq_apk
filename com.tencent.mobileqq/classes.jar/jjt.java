import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.opengl.effects.GLContextThread;
import java.lang.ref.WeakReference;

public class jjt
  extends Handler
{
  WeakReference a;
  
  public jjt(Looper paramLooper, GLContextThread paramGLContextThread)
  {
    super(paramLooper);
    this.a = new WeakReference(paramGLContextThread);
  }
  
  public void handleMessage(Message paramMessage)
  {
    GLContextThread localGLContextThread = (GLContextThread)this.a.get();
    if (localGLContextThread != null) {
      localGLContextThread.a(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jjt
 * JD-Core Version:    0.7.0.1
 */
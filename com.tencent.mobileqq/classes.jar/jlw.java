import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.opengl.effects.GLContextThread;
import java.lang.ref.WeakReference;

public class jlw
  extends Handler
{
  WeakReference a;
  
  public jlw(Looper paramLooper, GLContextThread paramGLContextThread)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jlw
 * JD-Core Version:    0.7.0.1
 */
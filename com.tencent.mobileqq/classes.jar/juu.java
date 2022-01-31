import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.ui.GLVideoView;

public class juu
  implements Runnable
{
  public juu(GLVideoView paramGLVideoView) {}
  
  public void run()
  {
    GLRootView localGLRootView = this.a.a();
    if (localGLRootView != null)
    {
      GLVideoView.e(this.a);
      localGLRootView.postDelayed(this.a.a, 80L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     juu
 * JD-Core Version:    0.7.0.1
 */
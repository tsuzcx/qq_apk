import com.tencent.av.ui.GamePlayView;
import com.tencent.mobileqq.armap.ARGLSurfaceView.SurfaceStateListener;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

public class meb
  implements ARGLSurfaceView.SurfaceStateListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  public meb(GamePlayView paramGamePlayView) {}
  
  public void onDestroy() {}
  
  public void onEGLConfigCreated(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, EGLContext paramEGLContext, long paramLong) {}
  
  public void onEGLContextDestroyed(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext) {}
  
  public void onInit(long paramLong)
  {
    GamePlayView.a(this.jdField_a_of_type_ComTencentAvUiGamePlayView, paramLong);
  }
  
  public void onPause()
  {
    QLog.d("ARZimuTask_GamePlayView", 2, "surfaceListener onPause");
  }
  
  public void onResume()
  {
    QLog.d("ARZimuTask_GamePlayView", 2, "surfaceListener onResume");
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     meb
 * JD-Core Version:    0.7.0.1
 */
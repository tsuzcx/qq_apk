package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView.Renderer;
import anjp;
import anjq;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@TargetApi(14)
public class DoodleTextureView
  extends GLTextureView
  implements GLSurfaceView.Renderer, DoodleGLCallback
{
  public int a;
  public DoodleOpController a;
  public int b = 480;
  
  public DoodleTextureView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 320;
    super.setEGLContextClientVersion(2);
    super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    super.setOpaque(false);
    super.setRenderer(this);
    super.setRenderMode(0);
  }
  
  public void a()
  {
    c();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.c(paramInt);
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    b(paramRunnable);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleTextureView", 2, "onDestroy start");
    }
    b(new anjq(this));
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.e();
    }
  }
  
  @TargetApi(17)
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController != null)
    {
      paramGL10 = (PersonalityOperator)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(102);
      if (paramGL10 != null) {
        paramGL10.a(paramInt1, paramInt2);
      }
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.d();
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    super.onSurfaceTextureDestroyed(paramSurfaceTexture);
    return true;
  }
  
  public void setOpController(DoodleOpController paramDoodleOpController)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController = paramDoodleOpController;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleOpController.a(this);
    super.b(new anjp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleTextureView
 * JD-Core Version:    0.7.0.1
 */
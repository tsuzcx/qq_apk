import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.TextureRender;

@TargetApi(16)
public class lpt
  implements lpk
{
  private int jdField_a_of_type_Int;
  public final SurfaceTexture a;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private boolean jdField_a_of_type_Boolean = true;
  private final float[] jdField_a_of_type_ArrayOfFloat;
  private final float[] b;
  
  public lpt(SurfaceTexture paramSurfaceTexture)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SurfaceTag", 2, "SurfacePreRender");
    }
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
    lok.a("SurfaceMode");
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    this.jdField_a_of_type_Boolean = true;
    this.b = new float[16];
    Matrix.setIdentityM(this.b, 0);
    Matrix.scaleM(this.b, 0, -1.0F, -1.0F, 1.0F);
  }
  
  public lpf a(loy paramloy, lok paramlok, lpf paramlpf)
  {
    try
    {
      paramlok.a(this.jdField_a_of_type_ArrayOfFloat);
      if (paramlok.jdField_a_of_type_Boolean != this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = paramlok.jdField_a_of_type_Boolean;
        if (this.jdField_a_of_type_Boolean)
        {
          Matrix.setIdentityM(this.b, 0);
          Matrix.scaleM(this.b, 0, -1.0F, -1.0F, 1.0F);
        }
      }
      else
      {
        int i = paramlok.b;
        int j = paramlok.jdField_a_of_type_Int;
        GLES20.glBindFramebuffer(36160, paramlpf.jdField_a_of_type_Int);
        GLES20.glViewport(0, 0, i, j);
        GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
        GLES20.glClear(16640);
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender != null) {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(36197, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, this.b);
        }
        GLES20.glBindFramebuffer(36160, 0);
      }
    }
    catch (Throwable paramloy)
    {
      try
      {
        for (;;)
        {
          if (Build.VERSION.SDK_INT >= 19) {
            paramlok.jdField_a_of_type_AndroidGraphicsSurfaceTexture.releaseTexImage();
          }
          return paramlpf;
          paramloy = paramloy;
          if (QLog.isDevelopLevel()) {
            QLog.i("SurfaceTag", 4, "render, surface[" + paramlok.jdField_a_of_type_AndroidGraphicsSurfaceTexture + "]", paramloy);
          }
        }
        Matrix.setIdentityM(this.b, 0);
        Matrix.scaleM(this.b, 0, 1.0F, -1.0F, 1.0F);
      }
      catch (Throwable paramloy)
      {
        while (!QLog.isDevelopLevel()) {}
        QLog.i("SurfaceTag", 4, "render", paramloy);
      }
    }
    return paramlpf;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
    this.jdField_a_of_type_Int = GlUtil.createTexture(36197);
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.detachFromGLContext();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.attachToGLContext(this.jdField_a_of_type_Int);
          if (QLog.isColorLevel()) {
            QLog.i("SurfaceTag", 2, "genTexture");
          }
          return;
          localThrowable1 = localThrowable1;
          QLog.i("SurfaceTag", 2, "genTexture1", localThrowable1);
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          QLog.i("SurfaceTag", 2, "genTexture2", localThrowable2);
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public boolean a(lok paramlok)
  {
    return (paramlok != null) && (paramlok.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) && (paramlok.jdField_a_of_type_AndroidGraphicsSurfaceTexture == this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
  }
  
  public void b() {}
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.detachFromGLContext();
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = this.jdField_a_of_type_Int;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      if (QLog.isColorLevel()) {
        QLog.i("SurfaceTag", 2, "delTexture");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("SurfaceTag", 2, "delTexture", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lpt
 * JD-Core Version:    0.7.0.1
 */
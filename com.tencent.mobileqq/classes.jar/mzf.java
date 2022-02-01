import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class mzf
{
  private volatile int jdField_a_of_type_Int;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private volatile Thread jdField_a_of_type_JavaLangThread;
  private mzg jdField_a_of_type_Mzg;
  private boolean jdField_a_of_type_Boolean;
  
  public mzf(SurfaceTexture paramSurfaceTexture, int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangThread = Thread.currentThread();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt) {}
    for (int i = 1;; i = 0)
    {
      if ((this.jdField_a_of_type_JavaLangThread == null) || ((this.jdField_a_of_type_JavaLangThread == Thread.currentThread()) && (i != 0)))
      {
        if ((i != 0) && (Build.VERSION.SDK_INT >= 16))
        {
          if ((this.jdField_a_of_type_Int != 0) && (!this.jdField_a_of_type_Boolean))
          {
            this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.detachFromGLContext();
            QLog.d("WatchTogetherSurfaceTextureHolder", 1, "attachToGLContext detach");
          }
          this.jdField_a_of_type_Int = paramInt;
        }
        if ((Build.VERSION.SDK_INT >= 16) && (!this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.attachToGLContext(paramInt);
          this.jdField_a_of_type_JavaLangThread = Thread.currentThread();
          QLog.d("WatchTogetherSurfaceTextureHolder", 1, "attachToGLContext real attch");
        }
        QLog.d("WatchTogetherSurfaceTextureHolder", 1, "attachToGLContext textureId " + paramInt + ",Thread.currentThread()):=" + Thread.currentThread());
      }
      return;
    }
  }
  
  public void a(mzg parammzg)
  {
    this.jdField_a_of_type_Mzg = parammzg;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.getTransformMatrix(paramArrayOfFloat);
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_JavaLangThread == null) && (this.jdField_a_of_type_Int == 0)) || (this.jdField_a_of_type_JavaLangThread == Thread.currentThread());
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void c()
  {
    QLog.d("WatchTogetherSurfaceTextureHolder", 1, "detachFromGLContext Thread.currentThread()):=" + Thread.currentThread());
    if (this.jdField_a_of_type_JavaLangThread != Thread.currentThread()) {
      QLog.d("WatchTogetherSurfaceTextureHolder", 1, "detachFromGLContext error", new Throwable("detachFromGLContext"));
    }
    if ((Build.VERSION.SDK_INT >= 16) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.detachFromGLContext();
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = this.jdField_a_of_type_Int;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangThread = null;
  }
  
  public void d()
  {
    QLog.d("WatchTogetherSurfaceTextureHolder", 1, "lostEglContext");
    if (this.jdField_a_of_type_Mzg != null) {
      this.jdField_a_of_type_Mzg.a(this.jdField_a_of_type_JavaLangThread);
    }
    this.jdField_a_of_type_JavaLangThread = null;
  }
  
  public void e()
  {
    QLog.d("WatchTogetherSurfaceTextureHolder", 1, "onResponsePauseMessage");
    if (this.jdField_a_of_type_Mzg != null) {
      this.jdField_a_of_type_Mzg.a();
    }
    this.jdField_a_of_type_JavaLangThread = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mzf
 * JD-Core Version:    0.7.0.1
 */
import android.annotation.SuppressLint;
import android.opengl.EGL14;
import android.os.Build.VERSION;
import javax.microedition.khronos.egl.EGL10;

public class lfu
{
  private android.opengl.EGLContext jdField_a_of_type_AndroidOpenglEGLContext;
  private android.opengl.EGLDisplay jdField_a_of_type_AndroidOpenglEGLDisplay;
  private android.opengl.EGLSurface jdField_a_of_type_AndroidOpenglEGLSurface;
  private EGL10 jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
  private javax.microedition.khronos.egl.EGLContext jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
  private javax.microedition.khronos.egl.EGLDisplay jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
  private javax.microedition.khronos.egl.EGLSurface jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface;
  
  private void a()
  {
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 = ((EGL10)javax.microedition.khronos.egl.EGLContext.getEGL());
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    Object localObject = new int[2];
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglInitialize(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (int[])localObject);
    localObject = new javax.microedition.khronos.egl.EGLConfig[1];
    int[] arrayOfInt = new int[1];
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglChooseConfig(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, new int[] { 12351, 12430, 12329, 0, 12339, 1, 12344 }, (javax.microedition.khronos.egl.EGLConfig[])localObject, 1, arrayOfInt);
    if (arrayOfInt[0] == 0) {
      krx.e("OffscreenSurface", "TROUBLE! No config found.");
    }
    localObject = localObject[0];
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglCreatePbufferSurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (javax.microedition.khronos.egl.EGLConfig)localObject, new int[] { 12375, 64, 12374, 64, 12344 });
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglCreateContext(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (javax.microedition.khronos.egl.EGLConfig)localObject, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglMakeCurrent(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 != null) && (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay != null) && (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface != null) && (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext != null))
    {
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglMakeCurrent(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglDestroySurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface);
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglDestroyContext(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglTerminate(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay);
    }
  }
  
  @SuppressLint({"NewApi"})
  private void d()
  {
    this.jdField_a_of_type_AndroidOpenglEGLDisplay = EGL14.eglGetDisplay(0);
    Object localObject = new int[2];
    EGL14.eglInitialize(this.jdField_a_of_type_AndroidOpenglEGLDisplay, (int[])localObject, 0, (int[])localObject, 1);
    localObject = new android.opengl.EGLConfig[1];
    int[] arrayOfInt = new int[1];
    EGL14.eglChooseConfig(this.jdField_a_of_type_AndroidOpenglEGLDisplay, new int[] { 12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344 }, 0, (android.opengl.EGLConfig[])localObject, 0, 1, arrayOfInt, 0);
    if (arrayOfInt[0] == 0) {
      krx.c("OffscreenSurface", "TROUBLE! No config found.");
    }
    localObject = localObject[0];
    this.jdField_a_of_type_AndroidOpenglEGLSurface = EGL14.eglCreatePbufferSurface(this.jdField_a_of_type_AndroidOpenglEGLDisplay, (android.opengl.EGLConfig)localObject, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
    this.jdField_a_of_type_AndroidOpenglEGLContext = EGL14.eglCreateContext(this.jdField_a_of_type_AndroidOpenglEGLDisplay, (android.opengl.EGLConfig)localObject, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    EGL14.eglMakeCurrent(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLSurface, this.jdField_a_of_type_AndroidOpenglEGLSurface, this.jdField_a_of_type_AndroidOpenglEGLContext);
  }
  
  @SuppressLint({"NewApi"})
  private void f()
  {
    if ((this.jdField_a_of_type_AndroidOpenglEGLDisplay != null) && (this.jdField_a_of_type_AndroidOpenglEGLSurface != null) && (this.jdField_a_of_type_AndroidOpenglEGLContext != null))
    {
      EGL14.eglMakeCurrent(this.jdField_a_of_type_AndroidOpenglEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroySurface(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLSurface);
      EGL14.eglDestroyContext(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLContext);
      EGL14.eglTerminate(this.jdField_a_of_type_AndroidOpenglEGLDisplay);
    }
  }
  
  void b()
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      d();
      return;
    }
    a();
  }
  
  public void e()
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      f();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lfu
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.rmonitor.device;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/device/EGLHelper;", "", "()V", "alpha", "", "blue", "depth", "egl", "Ljavax/microedition/khronos/egl/EGL10;", "eglContext", "Ljavax/microedition/khronos/egl/EGLContext;", "eglDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "eglSurface", "Ljavax/microedition/khronos/egl/EGLSurface;", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "green", "red", "renderType", "shareContext", "kotlin.jvm.PlatformType", "config", "", "destroy", "eglInit", "", "width", "height", "makeCurrent", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class EGLHelper
{
  public static final EGLHelper.Companion a = new EGLHelper.Companion(null);
  private final EGL10 b;
  private final EGLDisplay c;
  private EGLSurface d;
  private EGLContext e;
  private GL10 f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private final EGLContext m;
  
  public EGLHelper()
  {
    Object localObject1 = EGLContext.getEGL();
    boolean bool = localObject1 instanceof EGL10;
    Object localObject2 = null;
    if (!bool) {
      localObject1 = null;
    }
    this.b = ((EGL10)localObject1);
    EGL10 localEGL10 = this.b;
    localObject1 = localObject2;
    if (localEGL10 != null) {
      localObject1 = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    }
    this.c = ((EGLDisplay)localObject1);
    this.g = 8;
    this.h = 8;
    this.i = 8;
    this.j = 8;
    this.k = 16;
    this.l = 4;
    this.m = EGL10.EGL_NO_CONTEXT;
  }
  
  private final void b()
  {
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      localObject2 = this.c;
      EGLSurface localEGLSurface = this.d;
      ((EGL10)localObject1).eglMakeCurrent((EGLDisplay)localObject2, localEGLSurface, localEGLSurface, this.e);
    }
    localObject1 = this.e;
    if (localObject1 != null) {
      localObject1 = ((EGLContext)localObject1).getGL();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (!(localObject1 instanceof GL10)) {
      localObject2 = null;
    }
    this.f = ((GL10)localObject2);
  }
  
  public final void a()
  {
    EGL10 localEGL10 = this.b;
    if (localEGL10 != null)
    {
      localEGL10.eglMakeCurrent(this.c, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      localEGL10.eglDestroySurface(this.c, this.d);
      localEGL10.eglDestroyContext(this.c, this.e);
      localEGL10.eglTerminate(this.c);
    }
  }
  
  public final boolean a(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      int[] arrayOfInt = new int[13];
      arrayOfInt[0] = 12324;
      arrayOfInt[1] = this.g;
      arrayOfInt[2] = 12323;
      arrayOfInt[3] = this.h;
      arrayOfInt[4] = 12322;
      arrayOfInt[5] = this.i;
      arrayOfInt[6] = 12321;
      arrayOfInt[7] = this.j;
      arrayOfInt[8] = 12325;
      arrayOfInt[9] = this.k;
      arrayOfInt[10] = 12352;
      arrayOfInt[11] = this.l;
      arrayOfInt[12] = 12344;
      Object localObject2 = new int[2];
      ((EGL10)localObject1).eglInitialize(this.c, (int[])localObject2);
      localObject1 = new int[1];
      this.b.eglChooseConfig(this.c, arrayOfInt, null, 0, (int[])localObject1);
      if (localObject1[0] == 0) {
        return false;
      }
      localObject2 = new EGLConfig[localObject1[0]];
      this.b.eglChooseConfig(this.c, arrayOfInt, (EGLConfig[])localObject2, localObject1[0], (int[])localObject1);
      arrayOfInt = localObject2[0];
      this.d = this.b.eglCreatePbufferSurface(this.c, arrayOfInt, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 });
      this.e = this.b.eglCreateContext(this.c, arrayOfInt, this.m, new int[] { 12440, 2, 12344 });
      b();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.device.EGLHelper
 * JD-Core Version:    0.7.0.1
 */
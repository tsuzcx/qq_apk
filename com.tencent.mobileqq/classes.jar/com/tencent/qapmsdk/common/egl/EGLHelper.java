package com.tencent.qapmsdk.common.egl;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/egl/EGLHelper;", "", "()V", "alpha", "", "blue", "depth", "egl", "Ljavax/microedition/khronos/egl/EGL10;", "eglContext", "Ljavax/microedition/khronos/egl/EGLContext;", "eglDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "eglSurface", "Ljavax/microedition/khronos/egl/EGLSurface;", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "green", "red", "renderType", "shareContext", "kotlin.jvm.PlatformType", "config", "", "destroy", "eglInit", "", "width", "height", "makeCurrent", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class EGLHelper
{
  public static final EGLHelper.Companion Companion = new EGLHelper.Companion(null);
  private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
  private int alpha;
  private int blue;
  private int depth;
  private final EGL10 egl;
  private EGLContext eglContext;
  private final EGLDisplay eglDisplay;
  private EGLSurface eglSurface;
  private GL10 gl;
  private int green;
  private int red;
  private int renderType;
  private final EGLContext shareContext;
  
  public EGLHelper()
  {
    Object localObject3 = EGLContext.getEGL();
    Object localObject1 = localObject3;
    if (!(localObject3 instanceof EGL10)) {
      localObject1 = null;
    }
    this.egl = ((EGL10)localObject1);
    localObject3 = this.egl;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((EGL10)localObject3).eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    }
    this.eglDisplay = ((EGLDisplay)localObject1);
    this.red = 8;
    this.green = 8;
    this.blue = 8;
    this.alpha = 8;
    this.depth = 16;
    this.renderType = 4;
    this.shareContext = EGL10.EGL_NO_CONTEXT;
  }
  
  private final void makeCurrent()
  {
    Object localObject1 = this.egl;
    if (localObject1 != null) {
      ((EGL10)localObject1).eglMakeCurrent(this.eglDisplay, this.eglSurface, this.eglSurface, this.eglContext);
    }
    localObject1 = this.eglContext;
    if (localObject1 != null) {}
    for (localObject1 = ((EGLContext)localObject1).getGL();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof GL10)) {
        localObject2 = null;
      }
      this.gl = ((GL10)localObject2);
      return;
    }
  }
  
  public final void config(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.red = paramInt1;
    this.green = paramInt2;
    this.blue = paramInt3;
    this.alpha = paramInt4;
    this.depth = paramInt5;
    this.renderType = paramInt6;
  }
  
  public final void destroy()
  {
    EGL10 localEGL10 = this.egl;
    if (localEGL10 != null)
    {
      localEGL10.eglMakeCurrent(this.eglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      localEGL10.eglDestroySurface(this.eglDisplay, this.eglSurface);
      localEGL10.eglDestroyContext(this.eglDisplay, this.eglContext);
      localEGL10.eglTerminate(this.eglDisplay);
    }
  }
  
  public final boolean eglInit(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt2;
    if (this.egl != null)
    {
      arrayOfInt1 = new int[13];
      arrayOfInt1[0] = 12324;
      arrayOfInt1[1] = this.red;
      arrayOfInt1[2] = 12323;
      arrayOfInt1[3] = this.green;
      arrayOfInt1[4] = 12322;
      arrayOfInt1[5] = this.blue;
      arrayOfInt1[6] = 12321;
      arrayOfInt1[7] = this.alpha;
      arrayOfInt1[8] = 12325;
      arrayOfInt1[9] = this.depth;
      arrayOfInt1[10] = 12352;
      arrayOfInt1[11] = this.renderType;
      arrayOfInt1[12] = 12344;
      arrayOfInt2 = new int[2];
      this.egl.eglInitialize(this.eglDisplay, arrayOfInt2);
      arrayOfInt2 = new int[1];
      this.egl.eglChooseConfig(this.eglDisplay, arrayOfInt1, null, 0, arrayOfInt2);
      if (arrayOfInt2[0] == 0) {
        return false;
      }
    }
    else
    {
      return false;
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[arrayOfInt2[0]];
    this.egl.eglChooseConfig(this.eglDisplay, arrayOfInt1, arrayOfEGLConfig, arrayOfInt2[0], arrayOfInt2);
    int[] arrayOfInt1 = arrayOfEGLConfig[0];
    this.eglSurface = this.egl.eglCreatePbufferSurface(this.eglDisplay, arrayOfInt1, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 });
    this.eglContext = this.egl.eglCreateContext(this.eglDisplay, arrayOfInt1, this.shareContext, new int[] { 12440, 2, 12344 });
    makeCurrent();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.common.egl.EGLHelper
 * JD-Core Version:    0.7.0.1
 */
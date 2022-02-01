package com.tencent.ttpic.baseutils.gles;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.baseutils.report.ReportUtil;

@TargetApi(17)
public final class EglCore
{
  private static final int EGL_RECORDABLE_ANDROID = 12610;
  public static final int FLAG_RECORDABLE = 1;
  public static final int FLAG_TRY_GLES3 = 2;
  private static final String TAG = "EglCore";
  private EGLConfig mEGLConfig = null;
  private EGLContext mEGLContext = EGL14.EGL_NO_CONTEXT;
  private EGLDisplay mEGLDisplay = EGL14.EGL_NO_DISPLAY;
  private int mGlVersion = -1;
  private final Throwable throwableForStackTrace = new Throwable();
  
  public EglCore()
  {
    this(null, 0);
  }
  
  public EglCore(EGLContext paramEGLContext, int paramInt)
  {
    if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY)
    {
      Object localObject1 = paramEGLContext;
      if (paramEGLContext == null) {
        localObject1 = EGL14.EGL_NO_CONTEXT;
      }
      this.mEGLDisplay = EGL14.eglGetDisplay(0);
      if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY)
      {
        paramEGLContext = new int[2];
        if (EGL14.eglInitialize(this.mEGLDisplay, paramEGLContext, 0, paramEGLContext, 1))
        {
          if ((paramInt & 0x2) != 0)
          {
            paramEGLContext = getConfig(paramInt, 3);
            if (paramEGLContext != null)
            {
              localObject2 = EGL14.eglCreateContext(this.mEGLDisplay, paramEGLContext, (EGLContext)localObject1, new int[] { 12440, 3, 12344 }, 0);
              if (EGL14.eglGetError() == 12288)
              {
                this.mEGLConfig = paramEGLContext;
                this.mEGLContext = ((EGLContext)localObject2);
                this.mGlVersion = 3;
              }
            }
          }
          if (this.mEGLContext == EGL14.EGL_NO_CONTEXT)
          {
            paramEGLContext = getConfig(paramInt, 2);
            if (paramEGLContext != null)
            {
              localObject1 = EGL14.eglCreateContext(this.mEGLDisplay, paramEGLContext, (EGLContext)localObject1, new int[] { 12440, 2, 12344 }, 0);
              checkEglError("eglCreateContext");
              this.mEGLConfig = paramEGLContext;
              this.mEGLContext = ((EGLContext)localObject1);
              this.mGlVersion = 2;
            }
            else
            {
              throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
          }
          paramEGLContext = new int[1];
          EGL14.eglQueryContext(this.mEGLDisplay, this.mEGLContext, 12440, paramEGLContext, 0);
          localObject1 = TAG;
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("EGLContext created, client version ");
          ((StringBuilder)localObject2).append(paramEGLContext[0]);
          LogUtils.d((String)localObject1, ((StringBuilder)localObject2).toString());
          return;
        }
        this.mEGLDisplay = null;
        throw new RuntimeException("unable to initialize EGL14");
      }
      throw new RuntimeException("unable to get EGL14 display");
    }
    throw new RuntimeException("EGL already set up");
  }
  
  private void checkEglError(String paramString)
  {
    int i = EGL14.eglGetError();
    if (i != 12288)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": EGL error: 0x");
      localStringBuilder.append(Integer.toHexString(i));
      LogUtils.e(str, localStringBuilder.toString());
    }
  }
  
  private EGLConfig getConfig(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt2 >= 3) {
      i = 68;
    } else {
      i = 4;
    }
    Object localObject1 = new int[13];
    localObject1[0] = 12324;
    localObject1[1] = 8;
    localObject1[2] = 12323;
    localObject1[3] = 8;
    localObject1[4] = 12322;
    localObject1[5] = 8;
    localObject1[6] = 12321;
    localObject1[7] = 8;
    localObject1[8] = 12352;
    localObject1[9] = i;
    localObject1[10] = 12344;
    localObject1[11] = 0;
    localObject1[12] = 12344;
    if ((paramInt1 & 0x1) != 0)
    {
      localObject1[(localObject1.length - 3)] = 12610;
      localObject1[(localObject1.length - 2)] = 1;
    }
    Object localObject2 = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    if (!EGL14.eglChooseConfig(this.mEGLDisplay, (int[])localObject1, 0, (EGLConfig[])localObject2, 0, localObject2.length, arrayOfInt, 0))
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("unable to find RGB8888 / ");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(" EGLConfig");
      LogUtils.w((String)localObject1, ((StringBuilder)localObject2).toString());
      return null;
    }
    return localObject2[0];
  }
  
  public static void logCurrent(String paramString)
  {
    EGLDisplay localEGLDisplay = EGL14.eglGetCurrentDisplay();
    EGLContext localEGLContext = EGL14.eglGetCurrentContext();
    EGLSurface localEGLSurface = EGL14.eglGetCurrentSurface(12377);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Current EGL (");
    localStringBuilder.append(paramString);
    localStringBuilder.append("): display=");
    localStringBuilder.append(localEGLDisplay);
    localStringBuilder.append(", context=");
    localStringBuilder.append(localEGLContext);
    localStringBuilder.append(", surface=");
    localStringBuilder.append(localEGLSurface);
    LogUtils.i(str, localStringBuilder.toString());
  }
  
  public EGLSurface createOffscreenSurface(int paramInt1, int paramInt2)
  {
    EGLSurface localEGLSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 }, 0);
    checkEglError("eglCreatePbufferSurface");
    if (localEGLSurface != null) {
      return localEGLSurface;
    }
    throw new RuntimeException("surface was null");
  }
  
  public EGLSurface createWindowSurface(Object paramObject)
  {
    if ((!(paramObject instanceof Surface)) && (!(paramObject instanceof SurfaceTexture)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalid surface: ");
      localStringBuilder.append(paramObject);
      throw new RuntimeException(localStringBuilder.toString());
    }
    paramObject = EGL14.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, paramObject, new int[] { 12344 }, 0);
    checkEglError("eglCreateWindowSurface");
    if (paramObject != null) {
      return paramObject;
    }
    throw new RuntimeException("surface was null");
  }
  
  protected void finalize()
  {
    try
    {
      if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("WARNING: EglCore was not explicitly released -- state may be leaked, stackTrace: ");
        localStringBuilder.append(Log.getStackTraceString(this.throwableForStackTrace));
        ReportUtil.report(localStringBuilder.toString());
        release();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public EGLContext getEGLContext()
  {
    return this.mEGLContext;
  }
  
  public int getGlVersion()
  {
    return this.mGlVersion;
  }
  
  public boolean isCurrent(EGLSurface paramEGLSurface)
  {
    return (this.mEGLContext.equals(EGL14.eglGetCurrentContext())) && (paramEGLSurface.equals(EGL14.eglGetCurrentSurface(12377)));
  }
  
  public void makeCurrent(EGLSurface paramEGLSurface)
  {
    if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
      LogUtils.d(TAG, "NOTE: makeCurrent w/o display");
    }
    if (!EGL14.eglMakeCurrent(this.mEGLDisplay, paramEGLSurface, paramEGLSurface, this.mEGLContext)) {
      LogUtils.e(TAG, "eglMakeCurrent failed");
    }
  }
  
  public void makeCurrent(EGLSurface paramEGLSurface1, EGLSurface paramEGLSurface2)
  {
    if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
      LogUtils.d(TAG, "NOTE: makeCurrent w/o display");
    }
    if (EGL14.eglMakeCurrent(this.mEGLDisplay, paramEGLSurface1, paramEGLSurface2, this.mEGLContext)) {
      return;
    }
    throw new RuntimeException("eglMakeCurrent(draw,read) failed");
  }
  
  public void makeNothingCurrent()
  {
    if (EGL14.eglMakeCurrent(this.mEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT)) {
      return;
    }
    throw new RuntimeException("eglMakeCurrent failed");
  }
  
  public String queryString(int paramInt)
  {
    return EGL14.eglQueryString(this.mEGLDisplay, paramInt);
  }
  
  public int querySurface(EGLSurface paramEGLSurface, int paramInt)
  {
    int[] arrayOfInt = new int[1];
    EGL14.eglQuerySurface(this.mEGLDisplay, paramEGLSurface, paramInt, arrayOfInt, 0);
    return arrayOfInt[0];
  }
  
  public void release()
  {
    if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY)
    {
      EGL14.eglMakeCurrent(this.mEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
      if (this.mEGLContext == EGL14.EGL_NO_CONTEXT) {
        return;
      }
      EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.mEGLDisplay);
    }
    this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
    this.mEGLContext = EGL14.EGL_NO_CONTEXT;
    this.mEGLConfig = null;
  }
  
  public void releaseSurface(EGLSurface paramEGLSurface)
  {
    EGL14.eglDestroySurface(this.mEGLDisplay, paramEGLSurface);
  }
  
  @TargetApi(18)
  public void setPresentationTime(EGLSurface paramEGLSurface, long paramLong)
  {
    EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, paramEGLSurface, paramLong);
  }
  
  public boolean swapBuffers(EGLSurface paramEGLSurface)
  {
    return EGL14.eglSwapBuffers(this.mEGLDisplay, paramEGLSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.gles.EglCore
 * JD-Core Version:    0.7.0.1
 */
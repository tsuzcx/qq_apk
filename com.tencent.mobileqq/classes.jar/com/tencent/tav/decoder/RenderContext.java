package com.tencent.tav.decoder;

import android.graphics.PointF;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RenderContext
  implements IDecoderTrack.SurfaceCreator
{
  private static final int EGL_OPENGL_ES2_BIT = 4;
  private static final int EGL_RECORDABLE_ANDROID = 12610;
  private static final String TAG = "RenderContext";
  private HashMap<Surface, String> activeSurfaceCache = new HashMap();
  private EGLContext eglContext;
  private EGLDisplay eglDisplay;
  private EGLSurface eglSurface;
  private HashMap<String, Surface> freeSurfaceCache = new HashMap();
  @Nullable
  private CGRect glViewportRect;
  private int height;
  private boolean isSharedContext = false;
  private boolean pBufferEnable = false;
  @Nullable
  private RenderContextParams params;
  private volatile boolean released = false;
  private List<Surface> releasingSurfaceCache = new ArrayList();
  @Nullable
  private Surface surface;
  private long threadId = -1L;
  private HashMap<Surface, VideoTexture> videoTextureMap = new HashMap();
  private int width;
  
  public RenderContext() {}
  
  public RenderContext(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, null);
  }
  
  public RenderContext(int paramInt1, int paramInt2, Surface paramSurface)
  {
    this(paramInt1, paramInt2, paramSurface, null);
  }
  
  public RenderContext(int paramInt1, int paramInt2, @Nullable Surface paramSurface, EGLContext paramEGLContext)
  {
    this.surface = paramSurface;
    this.width = paramInt1;
    this.height = paramInt2;
    eglSetup(paramEGLContext);
    makeCurrent();
  }
  
  public static boolean checkEglActionSuccess(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("");
    for (int i = 0;; i = 1)
    {
      int j = EGL14.eglGetError();
      if (j == 12288) {
        break;
      }
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString);
      localStringBuilder2.append(": EGL error: 0x");
      localStringBuilder2.append(Integer.toHexString(j));
      Log.e("RenderContext", localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString);
      localStringBuilder2.append(": EGL error: 0x");
      localStringBuilder2.append(Integer.toHexString(j));
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (i != 0)
    {
      paramString = new StringBuilder();
      paramString.append("EGL error encountered (see log): ");
      paramString.append(localStringBuilder1.toString());
      Logger.e("RenderContext", "checkEglActionSuccess: ", new RuntimeException(paramString.toString()));
    }
    return i ^ 0x1;
  }
  
  public static void checkEglError(String paramString)
  {
    checkEglActionSuccess(paramString);
  }
  
  private void checkThread()
  {
    if (this.threadId != Thread.currentThread().getId())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("线程不对，注意EGL相关的泄露问题！threadId = ");
      localStringBuilder.append(this.threadId);
      localStringBuilder.append(", Thread.currentThread() name = ");
      localStringBuilder.append(Thread.currentThread().getName());
      Logger.e("RenderContext", localStringBuilder.toString(), new RuntimeException());
    }
  }
  
  public static int createTexture(int paramInt)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    int i = arrayOfInt[0];
    GLES20.glBindTexture(paramInt, i);
    checkEglError("glBindTexture mTextureID");
    GLES20.glTexParameterf(paramInt, 10241, 9729.0F);
    GLES20.glTexParameterf(paramInt, 10240, 9729.0F);
    GLES20.glTexParameteri(paramInt, 10242, 33071);
    GLES20.glTexParameteri(paramInt, 10243, 33071);
    checkEglError("glTexParameter");
    return i;
  }
  
  private void eglSetup(EGLContext paramEGLContext)
  {
    try
    {
      this.threadId = Thread.currentThread().getId();
      boolean bool = this.released;
      if (bool) {
        return;
      }
      try
      {
        this.eglDisplay = EGL14.eglGetDisplay(0);
        if (this.eglDisplay == EGL14.EGL_NO_DISPLAY)
        {
          Logger.e("RenderContext", "eglSetup: ", new RuntimeException("unable to get EGL14 display"));
          return;
        }
        Object localObject = new int[2];
        if (!EGL14.eglInitialize(this.eglDisplay, (int[])localObject, 0, (int[])localObject, 1))
        {
          this.eglDisplay = null;
          Logger.e("RenderContext", "eglSetup: ", new RuntimeException("unable to initialize EGL14"));
          return;
        }
        localObject = new EGLConfig[1];
        int[] arrayOfInt = new int[1];
        EGLDisplay localEGLDisplay = this.eglDisplay;
        int i = localObject.length;
        if (!EGL14.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344 }, 0, (EGLConfig[])localObject, 0, i, arrayOfInt, 0))
        {
          Logger.e("RenderContext", "eglSetup: ", new RuntimeException("unable to find RGB888+recordable ES2 EGL config"));
          return;
        }
        arrayOfInt = new int[3];
        arrayOfInt[0] = 12440;
        arrayOfInt[1] = 2;
        arrayOfInt[2] = 12344;
        if (paramEGLContext != null)
        {
          this.isSharedContext = true;
          this.eglContext = EGL14.eglCreateContext(this.eglDisplay, localObject[0], paramEGLContext, arrayOfInt, 0);
          checkEglError("eglCreateContext");
          if (this.eglContext == null) {
            Logger.e("RenderContext", "eglSetup: ", new RuntimeException("null context"));
          }
        }
        else
        {
          this.eglContext = EGL14.eglCreateContext(this.eglDisplay, localObject[0], EGL14.EGL_NO_CONTEXT, arrayOfInt, 0);
          checkEglError("eglCreateContext");
          if (this.eglContext == null)
          {
            Logger.e("RenderContext", "eglSetup: ", new RuntimeException("null context"));
            return;
          }
        }
        if (this.surface != null)
        {
          this.eglSurface = EGL14.eglCreateWindowSurface(this.eglDisplay, localObject[0], this.surface, new int[] { 12344 }, 0);
        }
        else
        {
          i = this.width;
          int j = this.height;
          this.eglSurface = EGL14.eglCreatePbufferSurface(this.eglDisplay, localObject[0], new int[] { 12375, i, 12374, j, 12344 }, 0);
        }
        if (checkEglActionSuccess("eglCreateWindowSurface")) {
          this.pBufferEnable = true;
        }
        if (this.eglSurface != null) {
          break label513;
        }
        Logger.e("RenderContext", "eglSetup: ", new RuntimeException("surface was null"));
      }
      catch (Error paramEGLContext) {}catch (Exception paramEGLContext) {}
      Logger.e("RenderContext", "eglSetup: ", paramEGLContext);
      label513:
      return;
    }
    finally {}
  }
  
  @NonNull
  public static TextureInfo newTextureInfo(float paramFloat1, float paramFloat2)
  {
    return newTextureInfo((int)paramFloat1, (int)paramFloat2);
  }
  
  public static TextureInfo newTextureInfo(int paramInt1, int paramInt2)
  {
    return newTextureInfo(paramInt1, paramInt2, false);
  }
  
  @NonNull
  public static TextureInfo newTextureInfo(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    TextureInfo localTextureInfo = new TextureInfo(createTexture(3553), 3553, paramInt1, paramInt2, null, 0);
    localTextureInfo.setFormat(6408);
    if (paramBoolean)
    {
      GLES20.glBindTexture(3553, localTextureInfo.textureID);
      GLES20.glTexImage2D(3553, 0, localTextureInfo.getFormat(), localTextureInfo.width, localTextureInfo.height, 0, localTextureInfo.getFormat(), 5121, null);
    }
    return localTextureInfo;
  }
  
  public static TextureInfo newTextureInfo(CGSize paramCGSize)
  {
    return newTextureInfo(paramCGSize.width, paramCGSize.height);
  }
  
  private void release(Surface paramSurface)
  {
    try
    {
      checkThread();
      if (paramSurface == null) {
        return;
      }
      if (this.videoTextureMap.containsKey(paramSurface)) {
        ((VideoTexture)this.videoTextureMap.remove(paramSurface)).release();
      }
      paramSurface.release();
      return;
    }
    finally {}
  }
  
  private void releaseReleadingSurface()
  {
    checkThread();
    int i = 0;
    while (i < this.releasingSurfaceCache.size())
    {
      release((Surface)this.releasingSurfaceCache.remove(i));
      i += 1;
    }
  }
  
  public Surface createOutputSurface(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      boolean bool = this.released;
      if (bool) {
        return null;
      }
      checkThread();
      releaseReleadingSurface();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("*");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append("-");
      ((StringBuilder)localObject1).append(paramInt3);
      localObject1 = ((StringBuilder)localObject1).toString();
      if (this.freeSurfaceCache.containsKey(localObject1))
      {
        localObject3 = (Surface)this.freeSurfaceCache.remove(localObject1);
        if (localObject3 != null)
        {
          this.activeSurfaceCache.put(localObject3, localObject1);
          return localObject3;
        }
      }
      makeCurrent();
      Object localObject3 = new VideoTexture(paramInt1, paramInt2, 36197, paramInt3);
      ((VideoTexture)localObject3).setRenderContext(this);
      Surface localSurface = new Surface(((VideoTexture)localObject3).surfaceTexture());
      this.videoTextureMap.put(localSurface, localObject3);
      this.activeSurfaceCache.put(localSurface, localObject1);
      return localSurface;
    }
    finally {}
  }
  
  public EGLContext eglContext()
  {
    return this.eglContext;
  }
  
  public void free(Surface paramSurface)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("free ");
      ((StringBuilder)localObject).append(Thread.currentThread().getId());
      Logger.i("RenderContext", ((StringBuilder)localObject).toString());
      if (paramSurface == null) {
        return;
      }
      localObject = (String)this.activeSurfaceCache.remove(paramSurface);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.freeSurfaceCache.containsKey(localObject);
      }
      this.releasingSurfaceCache.add(paramSurface);
      return;
    }
    finally {}
  }
  
  public long getEglSurfaceHandle()
  {
    if (this.eglSurface != null)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        return this.eglSurface.getNativeHandle();
      }
      return this.eglSurface.getHandle();
    }
    return 0L;
  }
  
  @Nullable
  public CGRect getGlViewportRect()
  {
    return this.glViewportRect;
  }
  
  @Nullable
  public RenderContextParams getParams()
  {
    return this.params;
  }
  
  public long getThreadId()
  {
    return this.threadId;
  }
  
  public int height()
  {
    return this.height;
  }
  
  public boolean isPBufferEnable()
  {
    return this.pBufferEnable;
  }
  
  public void makeCurrent()
  {
    try
    {
      checkThread();
      boolean bool = this.released;
      if (bool) {
        return;
      }
      if (!EGL14.eglMakeCurrent(this.eglDisplay, this.eglSurface, this.eglSurface, this.eglContext)) {
        checkEglError("eglMakeCurrent failed");
      }
      return;
    }
    finally {}
  }
  
  public void release()
  {
    try
    {
      checkThread();
      boolean bool = this.released;
      if (bool) {
        return;
      }
      makeCurrent();
      this.released = true;
      releaseReleadingSurface();
      Iterator localIterator = this.videoTextureMap.keySet().iterator();
      while (localIterator.hasNext()) {
        ((Surface)localIterator.next()).release();
      }
      localIterator = this.videoTextureMap.values().iterator();
      while (localIterator.hasNext()) {
        ((VideoTexture)localIterator.next()).release();
      }
      this.videoTextureMap.clear();
      try
      {
        if (EGL14.eglGetCurrentContext().equals(this.eglContext)) {
          EGL14.eglMakeCurrent(this.eglDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
        }
        EGL14.eglDestroySurface(this.eglDisplay, this.eglSurface);
        if (!this.isSharedContext) {
          EGL14.eglDestroyContext(this.eglDisplay, this.eglContext);
        }
      }
      catch (Error localError)
      {
        Logger.e("RenderContext", "release: ", localError);
      }
      catch (Exception localException)
      {
        Logger.e("RenderContext", "release: ", localException);
      }
      this.eglDisplay = null;
      this.eglContext = null;
      this.eglSurface = null;
      this.surface = null;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setParams(@Nullable RenderContextParams paramRenderContextParams)
  {
    this.params = paramRenderContextParams;
  }
  
  @RequiresApi(api=18)
  public void setPresentationTime(long paramLong)
  {
    try
    {
      boolean bool = this.released;
      if (bool) {
        return;
      }
      if (this.surface != null) {
        EGLExt.eglPresentationTimeANDROID(this.eglDisplay, this.eglSurface, paramLong * 1000L);
      }
      return;
    }
    finally {}
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
  
  public boolean swapBuffers()
  {
    try
    {
      checkThread();
      boolean bool = this.released;
      if (bool) {
        return false;
      }
      bool = EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);
      return bool;
    }
    finally {}
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RenderContext{_eglContext=");
    localStringBuilder.append(this.eglContext);
    localStringBuilder.append(", isSharedContext=");
    localStringBuilder.append(this.isSharedContext);
    localStringBuilder.append(", released=");
    localStringBuilder.append(this.released);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void updateViewport(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    makeCurrent();
    GLES20.glViewport(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void updateViewport(CGRect paramCGRect)
  {
    if (paramCGRect == null) {
      return;
    }
    this.glViewportRect = paramCGRect;
    updateViewport((int)paramCGRect.origin.x, (int)paramCGRect.origin.y, (int)paramCGRect.size.width, (int)paramCGRect.size.height);
  }
  
  public VideoTexture videoTextureForSurface(Surface paramSurface)
  {
    try
    {
      paramSurface = (VideoTexture)this.videoTextureMap.get(paramSurface);
      return paramSurface;
    }
    finally
    {
      paramSurface = finally;
      throw paramSurface;
    }
  }
  
  public int width()
  {
    return this.width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.RenderContext
 * JD-Core Version:    0.7.0.1
 */
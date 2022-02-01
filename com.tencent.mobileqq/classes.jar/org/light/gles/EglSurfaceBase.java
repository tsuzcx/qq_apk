package org.light.gles;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Map;

@TargetApi(17)
class EglSurfaceBase
{
  protected static final String TAG = EglSurfaceBase.class.getSimpleName();
  private EGLSurface mEGLSurface = EGL14.EGL_NO_SURFACE;
  protected EglCore mEglCore;
  private int mHeight = -1;
  private int mWidth = -1;
  
  protected EglSurfaceBase(EglCore paramEglCore)
  {
    this.mEglCore = paramEglCore;
  }
  
  private void checkGlError(String paramString)
  {
    if (GLES20.glGetError() != 0) {
      paramString = (StackTraceElement[])Thread.getAllStackTraces().get(Thread.currentThread());
    }
  }
  
  public void createOffscreenSurface(int paramInt1, int paramInt2)
  {
    if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) {
      throw new IllegalStateException("surface already created");
    }
    this.mEGLSurface = this.mEglCore.createOffscreenSurface(paramInt1, paramInt2);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public void createWindowSurface(Object paramObject)
  {
    if (this.mEGLSurface != EGL14.EGL_NO_SURFACE) {
      throw new IllegalStateException("surface already created");
    }
    this.mEGLSurface = this.mEglCore.createWindowSurface(paramObject);
  }
  
  public int getHeight()
  {
    if (this.mHeight < 0) {
      return this.mEglCore.querySurface(this.mEGLSurface, 12374);
    }
    return this.mHeight;
  }
  
  public int getWidth()
  {
    if (this.mWidth < 0) {
      return this.mEglCore.querySurface(this.mEGLSurface, 12375);
    }
    return this.mWidth;
  }
  
  public void makeCurrent()
  {
    this.mEglCore.makeCurrent(this.mEGLSurface);
  }
  
  public void makeCurrentReadFrom(EglSurfaceBase paramEglSurfaceBase)
  {
    this.mEglCore.makeCurrent(this.mEGLSurface, paramEglSurfaceBase.mEGLSurface);
  }
  
  public void releaseEglSurface()
  {
    this.mEglCore.releaseSurface(this.mEGLSurface);
    this.mEGLSurface = EGL14.EGL_NO_SURFACE;
    this.mHeight = -1;
    this.mWidth = -1;
  }
  
  public void saveFrame(File paramFile)
  {
    if (!this.mEglCore.isCurrent(this.mEGLSurface)) {
      throw new RuntimeException("Expected EGL context/surface is not current");
    }
    Object localObject = paramFile.toString();
    int i = getWidth();
    int j = getHeight();
    paramFile = ByteBuffer.allocateDirect(i * j * 4);
    paramFile.order(ByteOrder.LITTLE_ENDIAN);
    GLES20.glReadPixels(0, 0, i, j, 6408, 5121, paramFile);
    checkGlError("glReadPixels");
    paramFile.rewind();
    try
    {
      localObject = new BufferedOutputStream(new FileOutputStream((String)localObject));
      Bitmap localBitmap;
      if (localObject == null) {
        break label159;
      }
    }
    finally
    {
      try
      {
        localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        localBitmap.copyPixelsFromBuffer(paramFile);
        localBitmap.compress(Bitmap.CompressFormat.PNG, 90, (OutputStream)localObject);
        localBitmap.recycle();
        if (localObject != null) {
          ((BufferedOutputStream)localObject).close();
        }
        return;
      }
      finally {}
      paramFile = finally;
      localObject = null;
    }
    ((BufferedOutputStream)localObject).close();
    label159:
    throw paramFile;
  }
  
  public void setPresentationTime(long paramLong)
  {
    this.mEglCore.setPresentationTime(this.mEGLSurface, paramLong);
  }
  
  public boolean swapBuffers()
  {
    boolean bool = this.mEglCore.swapBuffers(this.mEGLSurface);
    if (!bool) {}
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.gles.EglSurfaceBase
 * JD-Core Version:    0.7.0.1
 */
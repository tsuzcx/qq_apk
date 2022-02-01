package org.light.gles;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import java.util.Map;

@TargetApi(17)
class EglSurfaceBase
{
  protected static final String TAG = "EglSurfaceBase";
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
    if (this.mEGLSurface == EGL14.EGL_NO_SURFACE)
    {
      this.mEGLSurface = this.mEglCore.createOffscreenSurface(paramInt1, paramInt2);
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      return;
    }
    throw new IllegalStateException("surface already created");
  }
  
  public void createWindowSurface(Object paramObject)
  {
    if (this.mEGLSurface == EGL14.EGL_NO_SURFACE)
    {
      this.mEGLSurface = this.mEglCore.createWindowSurface(paramObject);
      return;
    }
    throw new IllegalStateException("surface already created");
  }
  
  public int getHeight()
  {
    int j = this.mHeight;
    int i = j;
    if (j < 0) {
      i = this.mEglCore.querySurface(this.mEGLSurface, 12374);
    }
    return i;
  }
  
  public int getWidth()
  {
    int j = this.mWidth;
    int i = j;
    if (j < 0) {
      i = this.mEglCore.querySurface(this.mEGLSurface, 12375);
    }
    return i;
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
  
  /* Error */
  public void saveFrame(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	org/light/gles/EglSurfaceBase:mEglCore	Lorg/light/gles/EglCore;
    //   4: aload_0
    //   5: getfield 32	org/light/gles/EglSurfaceBase:mEGLSurface	Landroid/opengl/EGLSurface;
    //   8: invokevirtual 107	org/light/gles/EglCore:isCurrent	(Landroid/opengl/EGLSurface;)Z
    //   11: ifeq +139 -> 150
    //   14: aload_1
    //   15: invokevirtual 113	java/io/File:toString	()Ljava/lang/String;
    //   18: astore_1
    //   19: aload_0
    //   20: invokevirtual 115	org/light/gles/EglSurfaceBase:getWidth	()I
    //   23: istore_2
    //   24: aload_0
    //   25: invokevirtual 117	org/light/gles/EglSurfaceBase:getHeight	()I
    //   28: istore_3
    //   29: iload_2
    //   30: iload_3
    //   31: imul
    //   32: iconst_4
    //   33: imul
    //   34: invokestatic 123	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   37: astore 4
    //   39: aload 4
    //   41: getstatic 129	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   44: invokevirtual 133	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   47: pop
    //   48: iconst_0
    //   49: iconst_0
    //   50: iload_2
    //   51: iload_3
    //   52: sipush 6408
    //   55: sipush 5121
    //   58: aload 4
    //   60: invokestatic 137	android/opengl/GLES20:glReadPixels	(IIIIIILjava/nio/Buffer;)V
    //   63: aload_0
    //   64: ldc 138
    //   66: invokespecial 140	org/light/gles/EglSurfaceBase:checkGlError	(Ljava/lang/String;)V
    //   69: aload 4
    //   71: invokevirtual 144	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   74: pop
    //   75: new 146	java/io/BufferedOutputStream
    //   78: dup
    //   79: new 148	java/io/FileOutputStream
    //   82: dup
    //   83: aload_1
    //   84: invokespecial 149	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   87: invokespecial 152	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   90: astore_1
    //   91: iload_2
    //   92: iload_3
    //   93: getstatic 158	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   96: invokestatic 164	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   99: astore 5
    //   101: aload 5
    //   103: aload 4
    //   105: invokevirtual 168	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   108: aload 5
    //   110: getstatic 174	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   113: bipush 90
    //   115: aload_1
    //   116: invokevirtual 178	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   119: pop
    //   120: aload 5
    //   122: invokevirtual 181	android/graphics/Bitmap:recycle	()V
    //   125: aload_1
    //   126: invokevirtual 184	java/io/BufferedOutputStream:close	()V
    //   129: return
    //   130: astore 4
    //   132: goto +7 -> 139
    //   135: astore 4
    //   137: aconst_null
    //   138: astore_1
    //   139: aload_1
    //   140: ifnull +7 -> 147
    //   143: aload_1
    //   144: invokevirtual 184	java/io/BufferedOutputStream:close	()V
    //   147: aload 4
    //   149: athrow
    //   150: new 186	java/lang/RuntimeException
    //   153: dup
    //   154: ldc 188
    //   156: invokespecial 189	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	EglSurfaceBase
    //   0	160	1	paramFile	java.io.File
    //   23	69	2	i	int
    //   28	65	3	j	int
    //   37	67	4	localByteBuffer	java.nio.ByteBuffer
    //   130	1	4	localObject1	Object
    //   135	13	4	localObject2	Object
    //   99	22	5	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   91	125	130	finally
    //   75	91	135	finally
  }
  
  public void setPresentationTime(long paramLong)
  {
    this.mEglCore.setPresentationTime(this.mEGLSurface, paramLong);
  }
  
  public boolean swapBuffers()
  {
    return this.mEglCore.swapBuffers(this.mEGLSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.gles.EglSurfaceBase
 * JD-Core Version:    0.7.0.1
 */
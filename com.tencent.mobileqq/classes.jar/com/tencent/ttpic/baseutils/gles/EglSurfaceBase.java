package com.tencent.ttpic.baseutils.gles;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.device.BuildConfig;
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
    if (!BuildConfig.DEBUG) {
      return;
    }
    int i = GLES20.glGetError();
    if (i != 0)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": glError ");
      localStringBuilder.append(i);
      LogUtils.e(str, localStringBuilder.toString());
      paramString = (StackTraceElement[])Thread.getAllStackTraces().get(Thread.currentThread());
      int j = paramString.length;
      i = 0;
      while (i < j)
      {
        str = paramString[i];
        LogUtils.e(TAG, str.toString());
        i += 1;
      }
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
    //   1: getfield 38	com/tencent/ttpic/baseutils/gles/EglSurfaceBase:mEglCore	Lcom/tencent/ttpic/baseutils/gles/EglCore;
    //   4: aload_0
    //   5: getfield 32	com/tencent/ttpic/baseutils/gles/EglSurfaceBase:mEGLSurface	Landroid/opengl/EGLSurface;
    //   8: invokevirtual 140	com/tencent/ttpic/baseutils/gles/EglCore:isCurrent	(Landroid/opengl/EGLSurface;)Z
    //   11: ifeq +217 -> 228
    //   14: aload_1
    //   15: invokevirtual 143	java/io/File:toString	()Ljava/lang/String;
    //   18: astore 4
    //   20: aload_0
    //   21: invokevirtual 145	com/tencent/ttpic/baseutils/gles/EglSurfaceBase:getWidth	()I
    //   24: istore_2
    //   25: aload_0
    //   26: invokevirtual 147	com/tencent/ttpic/baseutils/gles/EglSurfaceBase:getHeight	()I
    //   29: istore_3
    //   30: iload_2
    //   31: iload_3
    //   32: imul
    //   33: iconst_4
    //   34: imul
    //   35: invokestatic 153	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   38: astore 5
    //   40: aload 5
    //   42: getstatic 159	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   45: invokevirtual 163	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   48: pop
    //   49: iconst_0
    //   50: iconst_0
    //   51: iload_2
    //   52: iload_3
    //   53: sipush 6408
    //   56: sipush 5121
    //   59: aload 5
    //   61: invokestatic 167	android/opengl/GLES20:glReadPixels	(IIIIIILjava/nio/Buffer;)V
    //   64: aload_0
    //   65: ldc 168
    //   67: invokespecial 170	com/tencent/ttpic/baseutils/gles/EglSurfaceBase:checkGlError	(Ljava/lang/String;)V
    //   70: aload 5
    //   72: invokevirtual 174	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   75: pop
    //   76: new 176	java/io/BufferedOutputStream
    //   79: dup
    //   80: new 178	java/io/FileOutputStream
    //   83: dup
    //   84: aload 4
    //   86: invokespecial 179	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   89: invokespecial 182	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   92: astore_1
    //   93: iload_2
    //   94: iload_3
    //   95: getstatic 188	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   98: invokestatic 194	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   101: astore 6
    //   103: aload 6
    //   105: aload 5
    //   107: invokevirtual 198	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   110: aload 6
    //   112: getstatic 204	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   115: bipush 90
    //   117: aload_1
    //   118: invokevirtual 208	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   121: pop
    //   122: aload 6
    //   124: invokevirtual 211	android/graphics/Bitmap:recycle	()V
    //   127: aload_1
    //   128: invokevirtual 214	java/io/BufferedOutputStream:close	()V
    //   131: getstatic 54	com/tencent/ttpic/baseutils/gles/EglSurfaceBase:TAG	Ljava/lang/String;
    //   134: astore_1
    //   135: new 56	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   142: astore 5
    //   144: aload 5
    //   146: ldc 216
    //   148: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 5
    //   154: iload_2
    //   155: invokevirtual 66	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload 5
    //   161: ldc 218
    //   163: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 5
    //   169: iload_3
    //   170: invokevirtual 66	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 5
    //   176: ldc 220
    //   178: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 5
    //   184: aload 4
    //   186: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 5
    //   192: ldc 222
    //   194: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_1
    //   199: aload 5
    //   201: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 225	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: return
    //   208: astore 4
    //   210: goto +7 -> 217
    //   213: astore 4
    //   215: aconst_null
    //   216: astore_1
    //   217: aload_1
    //   218: ifnull +7 -> 225
    //   221: aload_1
    //   222: invokevirtual 214	java/io/BufferedOutputStream:close	()V
    //   225: aload 4
    //   227: athrow
    //   228: new 227	java/lang/RuntimeException
    //   231: dup
    //   232: ldc 229
    //   234: invokespecial 230	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   237: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	EglSurfaceBase
    //   0	238	1	paramFile	java.io.File
    //   24	131	2	i	int
    //   29	141	3	j	int
    //   18	167	4	str	String
    //   208	1	4	localObject1	Object
    //   213	13	4	localObject2	Object
    //   38	162	5	localObject3	Object
    //   101	22	6	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   93	127	208	finally
    //   76	93	213	finally
  }
  
  public void setPresentationTime(long paramLong)
  {
    this.mEglCore.setPresentationTime(this.mEGLSurface, paramLong);
  }
  
  public boolean swapBuffers()
  {
    boolean bool = this.mEglCore.swapBuffers(this.mEGLSurface);
    if (!bool) {
      LogUtils.d(TAG, "WARNING: swapBuffers() failed");
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.gles.EglSurfaceBase
 * JD-Core Version:    0.7.0.1
 */
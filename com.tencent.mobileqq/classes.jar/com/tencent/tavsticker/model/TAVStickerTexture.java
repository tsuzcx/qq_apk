package com.tencent.tavsticker.model;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavsticker.log.TLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class TAVStickerTexture
  implements SurfaceTexture.OnFrameAvailableListener
{
  private static final String TAG = "TAVStickerTexture";
  private boolean frameAvailable;
  private final Object frameSyncObject = new Object();
  private int preferRotation = 0;
  private boolean quitFlag = false;
  private SurfaceTexture surfaceTexture;
  private TextureInfo textureInfo;
  private Matrix textureMatrix;
  private int textureType;
  
  public TAVStickerTexture(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, 36197, 0);
  }
  
  public TAVStickerTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, createTexture(paramInt3));
  }
  
  public TAVStickerTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.textureType = paramInt3;
    this.surfaceTexture = new SurfaceTexture(paramInt5);
    this.surfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.surfaceTexture.setOnFrameAvailableListener(this, new Handler(Looper.getMainLooper()));
    }
    else
    {
      this.surfaceTexture.setOnFrameAvailableListener(this);
      reflectLooper();
    }
    this.textureInfo = new TextureInfo(paramInt5, paramInt3, paramInt1, paramInt2, null, paramInt4);
    this.preferRotation = paramInt4;
  }
  
  public TAVStickerTexture(TextureInfo paramTextureInfo)
  {
    this.textureInfo = paramTextureInfo;
    this.surfaceTexture = new SurfaceTexture(paramTextureInfo.textureID);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.surfaceTexture.setOnFrameAvailableListener(this, new Handler(Looper.getMainLooper()));
    }
    else
    {
      this.surfaceTexture.setOnFrameAvailableListener(this);
      reflectLooper();
    }
    paramTextureInfo = new float[16];
    this.surfaceTexture.getTransformMatrix(paramTextureInfo);
    this.preferRotation = 0;
  }
  
  public static void checkEglError(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    for (int i = 0;; i = 1)
    {
      int j = EGL14.eglGetError();
      if (j == 12288) {
        break;
      }
      String str = TAG;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString);
      localStringBuilder2.append(": EGL error: 0x");
      localStringBuilder2.append(Integer.toHexString(j));
      TLog.e(str, localStringBuilder2.toString());
      localStringBuilder1.append(paramString);
      localStringBuilder1.append(": EGL error: 0x");
      localStringBuilder1.append(Integer.toHexString(j));
    }
    if (i != 0)
    {
      paramString = new StringBuilder();
      paramString.append("EGL error encountered (see log): ");
      paramString.append(localStringBuilder1);
      new RuntimeException(paramString.toString()).printStackTrace();
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
  
  private void getRotationMatrix(Matrix paramMatrix, int paramInt, float paramFloat1, float paramFloat2)
  {
    int i = paramInt % 4;
    paramInt = i;
    if (i < 0) {
      paramInt = i + 4;
    }
    float f1 = -1.0F;
    float f4;
    float f3;
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3)
        {
          f4 = 0.0F;
          f3 = 0.0F;
          paramFloat1 = 0.0F;
          paramFloat2 = 1.0F;
        }
      }
    }
    float f2;
    for (f1 = 1.0F;; f1 = 0.0F)
    {
      f2 = 0.0F;
      break;
      f4 = 1.0F;
      f3 = 0.0F;
      float f5 = -1.0F;
      paramFloat2 = 0.0F;
      f1 = 0.0F;
      f2 = paramFloat1;
      paramFloat1 = f5;
      break;
      f2 = paramFloat2;
      f4 = 0.0F;
      f5 = 0.0F;
      f3 = -1.0F;
      paramFloat2 = f1;
      f1 = f3;
      f3 = paramFloat1;
      paramFloat1 = f5;
      break;
      f3 = paramFloat2;
      f4 = -1.0F;
      paramFloat1 = 1.0F;
      paramFloat2 = 0.0F;
    }
    paramMatrix.setValues(new float[] { paramFloat2, f4, f3, paramFloat1, f1, f2, 0.0F, 0.0F, 1.0F });
  }
  
  private Matrix getTextureMatrix(SurfaceTexture paramSurfaceTexture, int paramInt)
  {
    Object localObject = new float[16];
    paramSurfaceTexture.getTransformMatrix((float[])localObject);
    float f1 = localObject[0];
    float f2 = localObject[4];
    float f3 = localObject[12];
    float f4 = localObject[1];
    float f5 = localObject[5];
    float f6 = localObject[13];
    paramSurfaceTexture = new Matrix();
    localObject = new Matrix();
    if (paramInt != 0) {
      getRotationMatrix((Matrix)localObject, paramInt, 1.0F, 1.0F);
    }
    if (((int)f1 == f1) && ((int)f4 == f4) && ((int)f2 == f2) && ((int)f5 == f5))
    {
      paramSurfaceTexture.setValues(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F });
      if (paramInt != 0) {
        paramSurfaceTexture.preConcat((Matrix)localObject);
      }
    }
    else
    {
      paramSurfaceTexture.setValues(new float[] { f1, f2, f3, f4, f5, f6, 0.0F, 0.0F, 1.0F });
    }
    if (paramInt != 0)
    {
      Matrix localMatrix = new Matrix();
      ((Matrix)localObject).invert(localMatrix);
      paramSurfaceTexture.postConcat(localMatrix);
    }
    return paramSurfaceTexture;
  }
  
  private boolean isIdentity()
  {
    Matrix localMatrix = this.textureMatrix;
    return (localMatrix == null) || (localMatrix.isIdentity());
  }
  
  private boolean isOES()
  {
    return this.textureType == 36197;
  }
  
  private void reflectLooper()
  {
    Object localObject2 = SurfaceTexture.class.getDeclaredClasses();
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      localObject1 = localObject2[i];
      if (localObject1.getName().toLowerCase().contains("handler")) {
        break label50;
      }
      i += 1;
    }
    Object localObject1 = null;
    label50:
    if (localObject1 == null) {
      return;
    }
    try
    {
      localObject1 = localObject1.getConstructor(new Class[] { SurfaceTexture.class, Looper.class }).newInstance(new Object[] { this.surfaceTexture, Looper.getMainLooper() });
      localObject2 = this.surfaceTexture.getClass().getDeclaredField("mEventHandler");
      ((Field)localObject2).setAccessible(true);
      ((Field)localObject2).set(this.surfaceTexture, localObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void releaseTextureInfo()
  {
    TextureInfo localTextureInfo = this.textureInfo;
    if (localTextureInfo != null)
    {
      localTextureInfo.release();
      this.textureInfo = null;
    }
  }
  
  public boolean awaitNewImage()
  {
    return awaitNewImage(500L);
  }
  
  public boolean awaitNewImage(long paramLong)
  {
    int i = (int)Math.ceil((float)paramLong * 1.0F / 50.0F);
    synchronized (this.frameSyncObject)
    {
      while (!this.frameAvailable)
      {
        boolean bool = this.quitFlag;
        if ((bool) || (i <= 0)) {
          break;
        }
        i -= 1;
        try
        {
          this.frameSyncObject.wait(50L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      this.frameAvailable = false;
      if (i == 0) {
        return false;
      }
      if (this.quitFlag)
      {
        this.quitFlag = false;
        return false;
      }
      checkEglError("before updateTexImage");
      this.surfaceTexture.updateTexImage();
      this.textureInfo.setTextureMatrix(getTextureMatrix(this.surfaceTexture, this.preferRotation));
      return true;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public int getPreferRotation()
  {
    return this.preferRotation;
  }
  
  public TextureInfo getTextureInfo()
  {
    return this.textureInfo;
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    synchronized (this.frameSyncObject)
    {
      if (this.frameAvailable)
      {
        new RuntimeException("frameAvailable already set, frame could be dropped").printStackTrace();
        return;
      }
      this.frameAvailable = true;
      this.frameSyncObject.notifyAll();
      return;
    }
  }
  
  public void quitIfWaiting()
  {
    synchronized (this.frameSyncObject)
    {
      this.quitFlag = true;
      this.frameSyncObject.notifyAll();
      return;
    }
  }
  
  public void release()
  {
    releaseTextureInfo();
    releaseSurfaceTexture();
  }
  
  public void releaseSurfaceTexture()
  {
    SurfaceTexture localSurfaceTexture = this.surfaceTexture;
    if (localSurfaceTexture != null)
    {
      localSurfaceTexture.release();
      this.surfaceTexture = null;
    }
  }
  
  public SurfaceTexture surfaceTexture()
  {
    return this.surfaceTexture;
  }
  
  public Matrix surfaceTextureMatrix()
  {
    if ((isIdentity()) && (isOES())) {
      this.textureMatrix = getTextureMatrix(this.surfaceTexture, this.preferRotation);
    }
    return this.textureMatrix;
  }
  
  public void updateStickerTextureSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0) && (this.textureInfo != null))
    {
      this.surfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
      this.textureInfo = new TextureInfo(this.textureInfo.textureID, this.textureInfo.textureType, paramInt1, paramInt2, this.textureInfo.getTextureMatrix(), this.textureInfo.preferRotation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerTexture
 * JD-Core Version:    0.7.0.1
 */
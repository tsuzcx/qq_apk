package com.tencent.tav.decoder;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.tav.Utils;
import com.tencent.tav.coremedia.TextureInfo;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class VideoTexture
  implements SurfaceTexture.OnFrameAvailableListener
{
  private Filter copyFilter;
  private boolean frameAvailable;
  private final Object frameSyncObject = new Object();
  private int preferRotation = 0;
  private boolean quitFlag = false;
  private RenderContext renderContext;
  private SurfaceTexture surfaceTexture;
  private TextureInfo textureInfo;
  private Matrix textureMatrix;
  private int textureType;
  
  public VideoTexture(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, 36197, 0);
  }
  
  public VideoTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, RenderContext.createTexture(paramInt3));
  }
  
  public VideoTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.textureType = paramInt3;
    this.surfaceTexture = new SurfaceTexture(paramInt5);
    if (Build.VERSION.SDK_INT >= 21) {
      this.surfaceTexture.setOnFrameAvailableListener(this, new Handler(Looper.getMainLooper()));
    }
    for (;;)
    {
      this.textureInfo = new TextureInfo(paramInt5, paramInt3, paramInt1, paramInt2, null, paramInt4);
      this.preferRotation = paramInt4;
      return;
      this.surfaceTexture.setOnFrameAvailableListener(this);
      reflectLooper();
    }
  }
  
  public VideoTexture(TextureInfo paramTextureInfo)
  {
    this.textureInfo = paramTextureInfo;
    this.surfaceTexture = new SurfaceTexture(paramTextureInfo.textureID);
    if (Build.VERSION.SDK_INT >= 21) {
      this.surfaceTexture.setOnFrameAvailableListener(this, new Handler(Looper.getMainLooper()));
    }
    for (;;)
    {
      paramTextureInfo = new float[16];
      this.surfaceTexture.getTransformMatrix(paramTextureInfo);
      this.preferRotation = 0;
      return;
      this.surfaceTexture.setOnFrameAvailableListener(this);
      reflectLooper();
    }
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
      DecoderUtils.getRotationMatrix((Matrix)localObject, paramInt, 1.0F, 1.0F);
    }
    if (((int)f1 == f1) && ((int)f4 == f4) && ((int)f2 == f2) && ((int)f5 == f5))
    {
      paramSurfaceTexture.setValues(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F });
      if (paramInt != 0) {
        paramSurfaceTexture.preConcat((Matrix)localObject);
      }
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        Matrix localMatrix = new Matrix();
        ((Matrix)localObject).invert(localMatrix);
        paramSurfaceTexture.postConcat(localMatrix);
      }
      return paramSurfaceTexture;
      paramSurfaceTexture.setValues(new float[] { f1, f2, f3, f4, f5, f6, 0.0F, 0.0F, 1.0F });
    }
  }
  
  private boolean isIdentity()
  {
    return (this.textureMatrix == null) || (this.textureMatrix.isIdentity());
  }
  
  private boolean isOES()
  {
    return this.textureType == 36197;
  }
  
  private void reflectLooper()
  {
    Object localObject3 = SurfaceTexture.class.getDeclaredClasses();
    int j = localObject3.length;
    int i = 0;
    Object localObject1;
    if (i < j)
    {
      localObject1 = localObject3[i];
      if (!localObject1.getName().toLowerCase().contains("handler")) {}
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        return;
        i += 1;
        break;
      }
      try
      {
        localObject1 = localObject1.getConstructor(new Class[] { SurfaceTexture.class, Looper.class }).newInstance(new Object[] { this.surfaceTexture, Looper.getMainLooper() });
        localObject3 = this.surfaceTexture.getClass().getDeclaredField("mEventHandler");
        ((Field)localObject3).setAccessible(true);
        ((Field)localObject3).set(this.surfaceTexture, localObject1);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      Object localObject2 = null;
    }
  }
  
  private void releaseFilter()
  {
    if (this.copyFilter != null) {
      this.copyFilter.release();
    }
  }
  
  private void releaseTextureInfo()
  {
    if (this.textureInfo != null)
    {
      this.textureInfo.release();
      this.textureInfo = null;
    }
  }
  
  boolean awaitNewImage()
  {
    return awaitNewImage(3000L);
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
    }
    RenderContext.checkEglError("before updateTexImage");
    this.surfaceTexture.updateTexImage();
    ??? = getTextureMatrix(this.surfaceTexture, this.preferRotation);
    if ((??? != null) && ("HUAWEI_ARE-AL00".equals(Utils.getPhoneName())) && (this.preferRotation == 1))
    {
      float[] arrayOfFloat = new float[9];
      ((Matrix)???).getValues(arrayOfFloat);
      ((Matrix)???).setValues(new float[] { -arrayOfFloat[4], 0.0F, arrayOfFloat[4], 0.0F, arrayOfFloat[0], arrayOfFloat[2], arrayOfFloat[6], arrayOfFloat[7], arrayOfFloat[8] });
    }
    this.textureInfo.setTextureMatrix((Matrix)???);
    return true;
  }
  
  public TextureInfo copyTexture()
  {
    if (this.copyFilter == null)
    {
      this.copyFilter = new Filter();
      this.copyFilter.setRendererWidth(this.renderContext.width());
      this.copyFilter.setRendererHeight(this.renderContext.height());
      this.copyFilter.setRenderForScreen(false);
    }
    return this.copyFilter.applyFilter(this.textureInfo, null, this.textureInfo.getTextureMatrix());
  }
  
  public int getPreferRotation()
  {
    return this.preferRotation;
  }
  
  public RenderContext getRenderContext()
  {
    return this.renderContext;
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
    releaseFilter();
  }
  
  public void releaseSurfaceTexture()
  {
    if (this.surfaceTexture != null)
    {
      this.surfaceTexture.release();
      this.surfaceTexture = null;
    }
  }
  
  public void setRenderContext(RenderContext paramRenderContext)
  {
    this.renderContext = paramRenderContext;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoTexture
 * JD-Core Version:    0.7.0.1
 */
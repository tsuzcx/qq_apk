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
  public float scaleX = 1.0F;
  public float scaleY = 1.0F;
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
  
  public VideoTexture(TextureInfo paramTextureInfo)
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
  
  private void releaseFilter()
  {
    Filter localFilter = this.copyFilter;
    if (localFilter != null) {
      localFilter.release();
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
      RenderContext.checkEglError("before updateTexImage");
      ??? = this.surfaceTexture;
      if (??? == null) {
        return false;
      }
      ((SurfaceTexture)???).updateTexImage();
      ??? = getTextureMatrix(this.surfaceTexture, this.preferRotation);
      ((Matrix)???).postScale(this.scaleX, this.scaleY);
      if ((??? != null) && ("HUAWEI_ARE-AL00".equals(Utils.getPhoneName())) && (this.preferRotation == 1))
      {
        float[] arrayOfFloat = new float[9];
        ((Matrix)???).getValues(arrayOfFloat);
        ((Matrix)???).setValues(new float[] { -arrayOfFloat[4], 0.0F, arrayOfFloat[4], 0.0F, arrayOfFloat[0], arrayOfFloat[2], arrayOfFloat[6], arrayOfFloat[7], arrayOfFloat[8] });
      }
      this.textureInfo.setTextureMatrix((Matrix)???);
      return true;
    }
    for (;;)
    {
      throw localObject2;
    }
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
    Filter localFilter = this.copyFilter;
    TextureInfo localTextureInfo = this.textureInfo;
    return localFilter.applyFilter(localTextureInfo, null, localTextureInfo.getTextureMatrix());
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
    SurfaceTexture localSurfaceTexture = this.surfaceTexture;
    if (localSurfaceTexture != null)
    {
      localSurfaceTexture.release();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoTexture
 * JD-Core Version:    0.7.0.1
 */
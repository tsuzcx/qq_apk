package com.tencent.qcircle.tavcut;

import android.content.Context;
import android.opengl.EGL14;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ttpic.openapi.filter.SimpleGLThread;
import com.tencent.view.RendererUtils;
import org.libpag.PAGFile;
import org.libpag.PAGLayer;
import org.libpag.PAGPlayer;
import org.libpag.PAGSolidLayer;
import org.libpag.PAGSurface;

public class PagTransformManager
{
  private static final String BGCOLOR = "bgcolor";
  private static final String TAG = "PagTransformManager";
  private static final String TEXTCOLOR = "textcolor";
  private static volatile PagTransformManager sInstance;
  private int mPagOutputTexture = 0;
  private PAGPlayer mPagRender;
  private PAGSurface mPagSurface = null;
  private SimpleGLThread surfaceTextureHandler = new SimpleGLThread(EGL14.eglGetCurrentContext(), "PagTransformManager");
  
  public static PagTransformManager getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new PagTransformManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private void renderPag(@Nullable PAGFile paramPAGFile, @Nullable PagTransformManager.PagTransformListener paramPagTransformListener)
  {
    if ((paramPAGFile == null) && (paramPagTransformListener != null)) {
      paramPagTransformListener.onBitmapSaveDone(null);
    }
    this.surfaceTextureHandler.postJob(new PagTransformManager.1(this, paramPAGFile, paramPagTransformListener));
  }
  
  @Nullable
  public PAGFile createThumbPagFile(@Nullable String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return null;
    }
    paramString = PAGFile.Load(paramString);
    PAGLayer[] arrayOfPAGLayer = paramString.getLayersByName("textcolor");
    int k = arrayOfPAGLayer.length;
    int j = 0;
    int i = 0;
    PAGLayer localPAGLayer;
    while (i < k)
    {
      localPAGLayer = arrayOfPAGLayer[i];
      if ((localPAGLayer instanceof PAGSolidLayer))
      {
        if (paramInt1 == 0) {
          break;
        }
        ((PAGSolidLayer)localPAGLayer).setSolidColor(paramInt1);
        paramString.setLayerIndex(localPAGLayer, paramString.getLayerIndex(localPAGLayer));
        break;
      }
      i += 1;
    }
    arrayOfPAGLayer = paramString.getLayersByName("bgcolor");
    i = arrayOfPAGLayer.length;
    paramInt1 = j;
    while (paramInt1 < i)
    {
      localPAGLayer = arrayOfPAGLayer[paramInt1];
      if ((localPAGLayer instanceof PAGSolidLayer))
      {
        if (paramInt2 == 0) {
          break;
        }
        ((PAGSolidLayer)localPAGLayer).setSolidColor(paramInt2);
        paramString.setLayerIndex(localPAGLayer, paramString.getLayerIndex(localPAGLayer));
        return paramString;
      }
      paramInt1 += 1;
    }
    return paramString;
  }
  
  public void pagFile2Bitmap(@Nullable String paramString, @Nullable PagTransformManager.PagTransformListener paramPagTransformListener)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramPagTransformListener != null) {
        paramPagTransformListener.onBitmapSaveDone(null);
      }
      return;
    }
    renderPag(PAGFile.Load(paramString), paramPagTransformListener);
  }
  
  public void pagFile2Bitmap(@Nullable PAGFile paramPAGFile, @Nullable PagTransformManager.PagTransformListener paramPagTransformListener)
  {
    renderPag(paramPAGFile, paramPagTransformListener);
  }
  
  public void pagFileFromAssets2Bitmap(@NonNull Context paramContext, @Nullable String paramString, @Nullable PagTransformManager.PagTransformListener paramPagTransformListener)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramPagTransformListener != null) {
        paramPagTransformListener.onBitmapSaveDone(null);
      }
      return;
    }
    renderPag(PAGFile.Load(paramContext.getAssets(), paramString), paramPagTransformListener);
  }
  
  public void release()
  {
    Object localObject = this.mPagSurface;
    if (localObject != null) {
      ((PAGSurface)localObject).freeCache();
    }
    localObject = this.mPagRender;
    if (localObject != null) {
      ((PAGPlayer)localObject).setSurface(null);
    }
    this.surfaceTextureHandler.destroy();
    RendererUtils.clearTexture(this.mPagOutputTexture);
    sInstance = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.PagTransformManager
 * JD-Core Version:    0.7.0.1
 */
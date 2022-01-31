package com.tencent.ttpic.filter;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.Frame.Type;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.filter.SimpleGLThread;
import com.tencent.ttpic.util.AlgoUtils;
import java.io.File;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGRenderer;
import org.libpag.PAGSurface;

@TargetApi(17)
public class PagFilter
{
  private VideoFilterBase cropFilter = new VideoFilterBase(BaseFilter.getFragmentShader(0));
  private Frame cropFrame = new Frame();
  private boolean firstFrame = true;
  private boolean firstRelease = true;
  private boolean isPagInit = false;
  private SurfaceTextureFilter oesTextureConvertFilter = new SurfaceTextureFilter();
  private Frame outputFrame = new Frame(Frame.Type.NEW);
  private String pagFilePath = "";
  private Semaphore pagFrameLock = new Semaphore(0);
  private SurfaceTexture pagOutputSurfaceTexture = null;
  private int pagOutputTexture = 0;
  private PAGRenderer pagRender = new PAGRenderer();
  private PAGSurface pagSurface = null;
  private int replaceImageIndex = 0;
  private SimpleGLThread surfaceTextureHandler;
  private float[] transformMatrix = new float[16];
  
  PagFilter(String paramString1, String paramString2)
  {
    this.pagFilePath = (paramString1 + File.separator + paramString2 + File.separator + paramString2 + ".pag");
    this.surfaceTextureHandler = new SimpleGLThread(EGL14.eglGetCurrentContext(), "PagFilterSTHT");
  }
  
  PagFilter(String paramString1, String paramString2, List<Integer> paramList)
  {
    this.pagFilePath = (paramString1 + File.separator + paramString2 + File.separator + paramString2 + ".pag");
    this.surfaceTextureHandler = new SimpleGLThread(EGL14.eglGetCurrentContext(), "PagFilterSTHT");
    if (paramList.size() > 0) {
      this.replaceImageIndex = ((Integer)paramList.get(0)).intValue();
    }
  }
  
  private boolean initPag(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    PAGFile localPAGFile;
    if (!this.isPagInit)
    {
      localPAGFile = loadPag(this.pagFilePath);
      if (localPAGFile == null) {
        bool = false;
      }
    }
    else
    {
      return bool;
    }
    this.surfaceTextureHandler.postJobSync(new PagFilter.2(this));
    this.pagOutputSurfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
    this.pagOutputSurfaceTexture.setOnFrameAvailableListener(new PagFilter.3(this));
    this.pagSurface = PAGSurface.FromSurfaceTexture(this.pagOutputSurfaceTexture, EGL14.eglGetCurrentContext());
    this.pagRender.setSurface(this.pagSurface);
    this.pagRender.setFile(localPAGFile);
    this.pagRender.setScaleMode(3);
    this.isPagInit = true;
    return true;
  }
  
  private PAGFile loadPag(String paramString)
  {
    if (paramString.startsWith("assets://")) {
      return loadPageFromAsset(paramString.substring("assets://".length()));
    }
    return loadPagFromStorage(paramString);
  }
  
  private PAGFile loadPagFromStorage(String paramString)
  {
    if (paramString != null) {
      return PAGFile.Load(paramString);
    }
    return null;
  }
  
  private PAGFile loadPageFromAsset(String paramString)
  {
    if (paramString != null) {
      return PAGFile.Load(AEModule.getContext().getAssets(), paramString);
    }
    return null;
  }
  
  private Frame renderPag(Frame paramFrame, int paramInt1, int paramInt2, double paramDouble)
  {
    PAGImage localPAGImage = PAGImage.FromTexture(paramFrame.getTextureId(), 3553, paramFrame.width, paramFrame.height);
    if (localPAGImage == null) {
      return paramFrame;
    }
    localPAGImage.setScaleMode(3);
    this.pagRender.replaceImage(this.replaceImageIndex, localPAGImage);
    this.pagRender.setProgress(paramDouble);
    this.surfaceTextureHandler.postJob(new PagFilter.1(this));
    boolean bool = false;
    try
    {
      if (!this.firstFrame) {
        bool = this.pagFrameLock.tryAcquire(1000L, TimeUnit.MILLISECONDS);
      }
      this.firstFrame = false;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        LogUtils.e(localInterruptedException);
        bool = false;
      }
      int i = (paramFrame.width - paramInt1) / 2;
      int j = (paramFrame.height - paramInt2) / 2;
      float[] arrayOfFloat = AlgoUtils.calTexCoords(i, j + paramInt2, i + paramInt1, j, paramFrame.width, paramFrame.height);
      this.cropFilter.setTexCords(arrayOfFloat);
      this.cropFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.cropFrame);
    }
    if (bool)
    {
      this.oesTextureConvertFilter.updateMatrix(this.transformMatrix);
      this.oesTextureConvertFilter.RenderProcess(this.pagOutputTexture, paramInt1, paramInt2, -1, 0.0D, this.outputFrame);
      return this.outputFrame;
    }
    return this.cropFrame;
  }
  
  public void init()
  {
    this.oesTextureConvertFilter.apply();
    this.oesTextureConvertFilter.setRotationAndFlip(0, 0, 1);
    this.cropFilter.ApplyGLSLFilter();
  }
  
  public void release()
  {
    this.outputFrame.clear();
    this.cropFrame.clear();
    if (this.pagSurface != null) {
      this.pagSurface.freeCache();
    }
    this.pagRender.setSurface(null);
    this.oesTextureConvertFilter.ClearGLSL();
    this.cropFilter.clearGLSLSelf();
    this.surfaceTextureHandler.postJobSync(new PagFilter.4(this));
    this.surfaceTextureHandler.destroy();
  }
  
  public Frame render(Frame paramFrame, int paramInt1, int paramInt2, double paramDouble)
  {
    Frame localFrame = paramFrame;
    if (initPag(paramInt1, paramInt2)) {
      localFrame = renderPag(paramFrame, paramInt1, paramInt2, paramDouble);
    }
    return localFrame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.PagFilter
 * JD-Core Version:    0.7.0.1
 */
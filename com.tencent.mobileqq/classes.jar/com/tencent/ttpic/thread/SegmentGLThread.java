package com.tencent.ttpic.thread;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.filter.ExpFilterV2;
import com.tencent.ttpic.filter.FabbyFilter;
import com.tencent.ttpic.filter.FabbyStrokeFilter;
import com.tencent.ttpic.filter.SimpleGaussionFilter;
import com.tencent.ttpic.gles.EglCore;
import com.tencent.ttpic.gles.GLSegSharedData;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.OffscreenSurface;
import com.tencent.ttpic.gles.OnSegDataReadyListener;
import com.tencent.ttpic.gles.SegmentDataPipe;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FabbyManager;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.view.RendererUtils;

@TargetApi(18)
public class SegmentGLThread
{
  private final int SEGMENT_HEIGHT = 24;
  private final int SEGMENT_WIDTH = 16;
  private ExpFilterV2 expFilter = new ExpFilterV2();
  private FabbyFilter fabbyFilter = new FabbyFilter();
  private FabbyStrokeFilter fabbyStrokeFilter = new FabbyStrokeFilter();
  private OnSegDataReadyListener listener;
  private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  private Frame mCopyFrame;
  private EglCore mCore;
  private Handler mHandler;
  private Bitmap mMaskBitmap;
  private OffscreenSurface mOffscreenSurface;
  private boolean mRunOnCpuForce = false;
  private Bitmap mSegBitmap;
  private Frame mSegFrame;
  private SimpleGaussionFilter mSimpleBlurFilter = new SimpleGaussionFilter();
  private Frame mTempFrame;
  private int[] mTempTexId = new int[2];
  private GLSegSharedData sharedData;
  
  public SegmentGLThread()
  {
    doInit(null);
  }
  
  public SegmentGLThread(final EGLContext paramEGLContext)
  {
    HandlerThread localHandlerThread = new HandlerThread("OffscreenGLThread" + (int)(Math.random() * 100.0D));
    localHandlerThread.start();
    this.mHandler = new Handler(localHandlerThread.getLooper());
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        SegmentGLThread.access$002(SegmentGLThread.this, new EglCore(paramEGLContext, 0));
        SegmentGLThread.access$102(SegmentGLThread.this, new OffscreenSurface(SegmentGLThread.this.mCore, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT));
        SegmentGLThread.this.mOffscreenSurface.makeCurrent();
        SegmentGLThread.this.doInit(paramEGLContext);
      }
    });
  }
  
  private void setAllRenderMode(int paramInt)
  {
    this.fabbyFilter.setRenderMode(paramInt);
    this.fabbyStrokeFilter.setRenderMode(paramInt);
    this.expFilter.setRenderMode(paramInt);
    this.mCopyFilter.setRenderMode(paramInt);
  }
  
  public void clearSegLig()
  {
    if (this.mHandler != null) {
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          FabbyManager.getInstance().clearSegmentBuffer();
        }
      });
    }
  }
  
  public void destroy()
  {
    if (this.mHandler != null)
    {
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          SegmentGLThread.this.doDestroy();
          SegmentGLThread.this.mOffscreenSurface.release();
          SegmentGLThread.this.mCore.release();
          SegmentGLThread.this.mHandler.getLooper().quit();
        }
      });
      return;
    }
    doDestroy();
  }
  
  public void doDestroy()
  {
    if (VideoBitmapUtil.isLegal(this.mSegBitmap))
    {
      this.mSegBitmap.recycle();
      this.mSegBitmap = null;
    }
    if (VideoBitmapUtil.isLegal(this.mMaskBitmap))
    {
      this.mMaskBitmap.recycle();
      this.mMaskBitmap = null;
    }
    this.sharedData.clear();
    this.mTempFrame.clear();
    this.mCopyFrame.clear();
    this.mSegFrame.clear();
    this.mCopyFilter.ClearGLSL();
    this.fabbyStrokeFilter.clearGLSLSelf();
    this.fabbyFilter.clearGLSLSelf();
    this.expFilter.clearGLSLSelf();
    this.mSimpleBlurFilter.clearGLSLSelf();
    GLES20.glDeleteTextures(this.mTempTexId.length, this.mTempTexId, 0);
    FabbyManager.getInstance().clearSegmentBuffer();
  }
  
  public void doInit(EGLContext paramEGLContext)
  {
    this.mCopyFilter.ApplyGLSLFilter();
    this.fabbyStrokeFilter.ApplyGLSLFilter();
    this.fabbyFilter.ApplyGLSLFilter();
    this.expFilter.ApplyGLSLFilter();
    this.mSimpleBlurFilter.ApplyGLSLFilter();
    this.sharedData = new GLSegSharedData(paramEGLContext);
    this.mTempFrame = new Frame();
    this.mCopyFrame = new Frame();
    this.mSegFrame = new Frame();
    GLES20.glGenTextures(this.mTempTexId.length, this.mTempTexId, 0);
    setAllRenderMode(1);
    FabbyManager.getInstance().compileKernel();
  }
  
  public SegmentDataPipe doSegment(Frame paramFrame)
  {
    SegmentDataPipe localSegmentDataPipe = this.sharedData.getFreeTexturePileMakeBusy();
    if (localSegmentDataPipe == null) {
      return null;
    }
    BenchUtil.benchStart("[showPreview][FABBY] segment");
    this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, localSegmentDataPipe.mTexFrame);
    this.mSimpleBlurFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mSegFrame);
    localSegmentDataPipe.mMaskFrame.bindFrame(-1, this.mSegFrame.width, this.mSegFrame.height, 0.0D);
    localSegmentDataPipe.mTimestamp = System.currentTimeMillis();
    boolean bool = FabbyManager.getInstance().isGPUSupportOpenCL();
    if ((bool) && (!this.mRunOnCpuForce) && (FabbyManager.getInstance().segmentOnTexture(this.mSegFrame.getTextureId(), localSegmentDataPipe.mMaskFrame.getTextureId(), this.mSegFrame.width, this.mSegFrame.height, false, 16, 24) != 0)) {
      this.mRunOnCpuForce = true;
    }
    if ((this.mRunOnCpuForce) || (!bool))
    {
      this.mCopyFilter.RenderProcess(this.mSegFrame.getTextureId(), 256, 384, -1, 0.0D, this.mCopyFrame);
      if (!VideoBitmapUtil.isLegal(this.mSegBitmap)) {
        this.mSegBitmap = Bitmap.createBitmap(256, 384, Bitmap.Config.ARGB_8888);
      }
      if (!VideoBitmapUtil.isLegal(this.mMaskBitmap)) {
        this.mMaskBitmap = Bitmap.createBitmap(16, 24, Bitmap.Config.ARGB_8888);
      }
      RendererUtils.saveTextureToBitmap(this.mCopyFrame.getTextureId(), 256, 384, this.mSegBitmap);
      FabbyManager.getInstance().segmentOnBitmap(this.mSegBitmap, this.mMaskBitmap, 256, 384, 16, 24);
      GlUtil.loadTexture(this.mTempTexId[0], this.mMaskBitmap);
      this.expFilter.updateParam(this.mSegFrame.width, this.mSegFrame.height, 16, 24);
      this.expFilter.RenderProcess(this.mTempTexId[0], this.mSegFrame.width, this.mSegFrame.height, -1, 0.0D, localSegmentDataPipe.mMaskFrame);
    }
    localSegmentDataPipe.makeDataReady();
    this.sharedData.makeBrotherTextureFree(localSegmentDataPipe);
    if (this.listener != null) {
      this.listener.onDataReady(localSegmentDataPipe);
    }
    BenchUtil.benchEnd("[showPreview][FABBY] segment");
    return localSegmentDataPipe;
  }
  
  public SegmentDataPipe getCurrentDataPipe()
  {
    if (this.sharedData == null) {
      return null;
    }
    return this.sharedData.getCurrentTexturePile();
  }
  
  public void initSegLig()
  {
    if (this.mHandler != null) {
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          FabbyManager.getInstance().compileKernel();
        }
      });
    }
  }
  
  public boolean needWait()
  {
    if (this.sharedData == null) {
      return true;
    }
    SegmentDataPipe[] arrayOfSegmentDataPipe = this.sharedData.mTexturePile;
    int j = arrayOfSegmentDataPipe.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label55;
      }
      SegmentDataPipe localSegmentDataPipe = arrayOfSegmentDataPipe[i];
      if ((localSegmentDataPipe.isBusy()) || (localSegmentDataPipe.isReady())) {
        break;
      }
      i += 1;
    }
    label55:
    return false;
  }
  
  public void postSegJob(final Frame paramFrame)
  {
    if (this.mHandler == null) {
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (SegmentGLThread.this.listener == null) {
          return;
        }
        SegmentGLThread.this.doSegment(paramFrame);
      }
    });
  }
  
  public void reset()
  {
    if (this.mHandler != null) {
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          SegmentGLThread.this.sharedData.reset();
        }
      });
    }
  }
  
  public void setOnDataReadyListener(OnSegDataReadyListener paramOnSegDataReadyListener)
  {
    this.listener = paramOnSegDataReadyListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.thread.SegmentGLThread
 * JD-Core Version:    0.7.0.1
 */
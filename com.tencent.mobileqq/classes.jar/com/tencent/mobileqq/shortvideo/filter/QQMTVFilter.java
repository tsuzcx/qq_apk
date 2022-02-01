package com.tencent.mobileqq.shortvideo.filter;

import android.opengl.GLES20;
import android.os.Bundle;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.mtveffects.FilmFilter;
import com.tencent.mobileqq.shortvideo.mtveffects.MTV1Filter;
import com.tencent.mobileqq.shortvideo.mtveffects.MTVBaseFilter;
import com.tencent.mobileqq.shortvideo.resource.ArtFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.LinkedList;

public class QQMTVFilter
  extends QQBaseFilter
{
  public static final String TAG = "QQMTVFilter";
  private FilterDesc mCurrentDesc;
  private MTVBaseFilter mCurrentFilter;
  private boolean mDecodeTime = false;
  private boolean mEnabled = true;
  private QQSpecialAVFilter.MusicWaveformSupporter mMusicWaveformSupporter;
  private MTVBaseFilter mOldFilter;
  private RenderBuffer mRenderFBO;
  private boolean mReset = true;
  private long mResetMs = 0L;
  private final LinkedList<Runnable> mRunOnDraw = new LinkedList();
  private boolean mWorking = false;
  
  public QQMTVFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
    SLog.d("QQMTVFilter", "QQMTVFilter start...");
  }
  
  private void checkRenderBuffer(int paramInt1, int paramInt2)
  {
    if ((this.mRenderFBO == null) || (this.mRenderFBO.getWidth() != paramInt1) || (this.mRenderFBO.getHeight() != paramInt2))
    {
      releaseRenderBuffer(this.mRenderFBO);
      this.mRenderFBO = new RenderBuffer(paramInt1, paramInt2, 33984);
      SLog.d("QQMTVFilter", "create new renderfbo, width:" + paramInt1 + " height:" + paramInt2);
    }
  }
  
  private MTVBaseFilter createFilmFilter(FilterDesc paramFilterDesc)
  {
    Object localObject;
    if (paramFilterDesc == null) {
      localObject = null;
    }
    FilmFilter localFilmFilter;
    do
    {
      return localObject;
      localObject = paramFilterDesc.getResFold(SdkContext.getInstance().getResources().getArtFilterResource().getFilterResPath());
      SLog.d("QQMTVFilter", "create film filter, res path:" + (String)localObject);
      localFilmFilter = new FilmFilter((String)localObject);
      localObject = localFilmFilter;
    } while (paramFilterDesc.bundle == null);
    long l1 = paramFilterDesc.bundle.getLong("lSeed", 0L);
    long l2 = paramFilterDesc.bundle.getLong("lZoomingTime", 1300L);
    localFilmFilter.setSeed(l1);
    localFilmFilter.setZoomingTime(l2);
    SLog.d("QQMTVFilter", "create MTV1 filter, gaussiantime:" + l2 + " seed:" + l1 + " zoomingtime:" + l2);
    return localFilmFilter;
  }
  
  private MTVBaseFilter createMTV1Filter(FilterDesc paramFilterDesc)
  {
    Object localObject;
    if (paramFilterDesc == null) {
      localObject = null;
    }
    MTV1Filter localMTV1Filter;
    do
    {
      return localObject;
      localObject = paramFilterDesc.getResFold(SdkContext.getInstance().getResources().getArtFilterResource().getFilterResPath());
      SLog.d("QQMTVFilter", "create MTV1 filter, res path:" + (String)localObject);
      localMTV1Filter = new MTV1Filter((String)localObject);
      localObject = localMTV1Filter;
    } while (paramFilterDesc.bundle == null);
    boolean bool1 = paramFilterDesc.bundle.getBoolean("bRevert", false);
    long l = paramFilterDesc.bundle.getLong("lSeed", 0L);
    boolean bool2 = paramFilterDesc.bundle.getBoolean("bShowEntrance", true);
    SLog.d("QQMTVFilter", "create MTV1 filter, brevert:" + bool1 + " seed:" + l + " bshowentrance:" + bool2);
    localMTV1Filter.revert(bool1);
    localMTV1Filter.setSeed(l);
    localMTV1Filter.setShowEntrance(bool2);
    return localMTV1Filter;
  }
  
  private long getCurrentMs()
  {
    if (this.mDecodeTime) {
      return getQQFilterRenderManager().getBusinessOperation().getOrgTimeStamp() / 1000000L;
    }
    if (this.mReset)
    {
      this.mReset = false;
      this.mResetMs = System.currentTimeMillis();
      return 0L;
    }
    return System.currentTimeMillis() - this.mResetMs;
  }
  
  private MTVBaseFilter getMTVFilter(int paramInt1, int paramInt2)
  {
    if ((this.mCurrentDesc == null) || (this.mCurrentDesc.id == -1)) {
      return null;
    }
    if (this.mOldFilter != null)
    {
      SLog.d("QQMTVFilter", "destroy old filter.");
      this.mOldFilter.onSurfaceDestroy();
      this.mOldFilter = null;
    }
    if (this.mCurrentFilter == null)
    {
      SLog.d("QQMTVFilter", "create new filter, id:" + this.mCurrentDesc.id);
      switch (this.mCurrentDesc.id)
      {
      }
    }
    for (;;)
    {
      if (this.mCurrentFilter != null) {
        this.mCurrentFilter.onSurfaceChange(paramInt1, paramInt2);
      }
      this.mReset = true;
      return this.mCurrentFilter;
      this.mCurrentFilter = createMTV1Filter(this.mCurrentDesc);
      continue;
      this.mCurrentFilter = createFilmFilter(this.mCurrentDesc);
    }
  }
  
  private boolean isMTVID(FilterDesc paramFilterDesc)
  {
    if (paramFilterDesc == null) {}
    while (QQAVImageFilterConstants.getFilterType(paramFilterDesc.id) != 4) {
      return false;
    }
    return true;
  }
  
  private void runOnDraw(Runnable paramRunnable)
  {
    synchronized (this.mRunOnDraw)
    {
      this.mRunOnDraw.addLast(paramRunnable);
      return;
    }
  }
  
  private void runPendingOnDrawTasks()
  {
    synchronized (this.mRunOnDraw)
    {
      if (!this.mRunOnDraw.isEmpty()) {
        ((Runnable)this.mRunOnDraw.removeFirst()).run();
      }
    }
  }
  
  public void enable(boolean paramBoolean)
  {
    this.mEnabled = paramBoolean;
    SLog.d("QQMTVFilter", "enable:" + this.mEnabled);
  }
  
  public boolean isFilterWork()
  {
    return this.mWorking;
  }
  
  public void onDrawFrame()
  {
    long l1 = System.currentTimeMillis();
    runPendingOnDrawTasks();
    if (!this.mEnabled)
    {
      this.mWorking = false;
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
    checkRenderBuffer(getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
    if (this.mRenderFBO == null)
    {
      this.mWorking = false;
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
    MTVBaseFilter localMTVBaseFilter = getMTVFilter(getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
    if (localMTVBaseFilter == null)
    {
      this.mWorking = false;
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
    long l2 = getCurrentMs();
    float f;
    if (this.mMusicWaveformSupporter == null)
    {
      f = getQQFilterRenderManager().getBusinessOperation().getCurrentMusicGain();
      if ((f <= 0.0F) || (f > 1.0F)) {
        break label252;
      }
    }
    for (;;)
    {
      this.mRenderFBO.recoverInitialTexId();
      this.mRenderFBO.bind();
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(17664);
      this.mRenderFBO.unbind();
      localMTVBaseFilter.onDrawFrame(this.mInputTextureID, this.mRenderFBO, l2, f);
      this.mOutputTextureID = this.mRenderFBO.getTexId();
      this.mWorking = true;
      SLog.d("QQMTVFilter", "QQMTVFilter onDrawFrame cost: " + (System.currentTimeMillis() - l1));
      return;
      f = this.mMusicWaveformSupporter.getCurrentMusicGain();
      break;
      label252:
      f = 0.0F;
    }
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    super.onSurfaceChange(paramInt1, paramInt2);
    SLog.d("QQMTVFilter", "onSurfaceChange, width:" + paramInt1 + " height:" + paramInt2);
    setCurrentId(getQQFilterRenderManager().getBusinessOperation().getCurrentAVFilterIdByType(4));
  }
  
  public void onSurfaceDestroy()
  {
    SLog.d("QQMTVFilter", "onSurfaceDestroy");
    if (this.mCurrentFilter != null)
    {
      this.mCurrentFilter.onSurfaceDestroy();
      this.mCurrentFilter = null;
    }
    if (this.mOldFilter != null)
    {
      this.mOldFilter.onSurfaceDestroy();
      this.mOldFilter = null;
    }
    this.mCurrentDesc = null;
    this.mWorking = false;
    releaseRenderBuffer(this.mRenderFBO);
  }
  
  void releaseRenderBuffer(RenderBuffer paramRenderBuffer)
  {
    if (paramRenderBuffer != null)
    {
      if (paramRenderBuffer.getTexId() >= 0) {
        GlUtil.deleteTexture(paramRenderBuffer.getTexId());
      }
      paramRenderBuffer.destroy();
    }
  }
  
  public void reset()
  {
    runOnDraw(new QQMTVFilter.2(this));
  }
  
  public void setCurrentId(FilterDesc paramFilterDesc)
  {
    if (isMTVID(paramFilterDesc))
    {
      this.mCurrentDesc = new FilterDesc(paramFilterDesc.id, paramFilterDesc.predownload, paramFilterDesc.resurl, paramFilterDesc.resMD5, paramFilterDesc.iconurl, paramFilterDesc.iconMD5, paramFilterDesc.name, 4);
      if (paramFilterDesc.bundle != null) {
        this.mCurrentDesc.bundle = new Bundle(paramFilterDesc.bundle);
      }
      this.mWorking = true;
    }
    for (;;)
    {
      if (this.mCurrentFilter != null)
      {
        this.mOldFilter = this.mCurrentFilter;
        this.mCurrentFilter = null;
      }
      return;
      this.mCurrentDesc = null;
      this.mWorking = false;
      SLog.d("QQMTVFilter", "setCurrentId, is not mtv ID.");
    }
  }
  
  public void setMusicWaveformSupporter(QQSpecialAVFilter.MusicWaveformSupporter paramMusicWaveformSupporter)
  {
    this.mMusicWaveformSupporter = paramMusicWaveformSupporter;
  }
  
  public void useFrameTime(boolean paramBoolean)
  {
    runOnDraw(new QQMTVFilter.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQMTVFilter
 * JD-Core Version:    0.7.0.1
 */
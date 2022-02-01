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
    Object localObject = this.mRenderFBO;
    if ((localObject == null) || (((RenderBuffer)localObject).getWidth() != paramInt1) || (this.mRenderFBO.getHeight() != paramInt2))
    {
      releaseRenderBuffer(this.mRenderFBO);
      this.mRenderFBO = new RenderBuffer(paramInt1, paramInt2, 33984);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("create new renderfbo, width:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" height:");
      ((StringBuilder)localObject).append(paramInt2);
      SLog.d("QQMTVFilter", ((StringBuilder)localObject).toString());
    }
  }
  
  private MTVBaseFilter createFilmFilter(FilterDesc paramFilterDesc)
  {
    if (paramFilterDesc == null) {
      return null;
    }
    Object localObject = paramFilterDesc.getResFold(SdkContext.getInstance().getResources().getArtFilterResource().getFilterResPath());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create film filter, res path:");
    localStringBuilder.append((String)localObject);
    SLog.d("QQMTVFilter", localStringBuilder.toString());
    localObject = new FilmFilter((String)localObject);
    if (paramFilterDesc.bundle != null)
    {
      long l1 = paramFilterDesc.bundle.getLong("lSeed", 0L);
      long l2 = paramFilterDesc.bundle.getLong("lZoomingTime", 1300L);
      ((FilmFilter)localObject).setSeed(l1);
      ((FilmFilter)localObject).setZoomingTime(l2);
      paramFilterDesc = new StringBuilder();
      paramFilterDesc.append("create MTV1 filter, gaussiantime:");
      paramFilterDesc.append(l2);
      paramFilterDesc.append(" seed:");
      paramFilterDesc.append(l1);
      paramFilterDesc.append(" zoomingtime:");
      paramFilterDesc.append(l2);
      SLog.d("QQMTVFilter", paramFilterDesc.toString());
    }
    return localObject;
  }
  
  private MTVBaseFilter createMTV1Filter(FilterDesc paramFilterDesc)
  {
    if (paramFilterDesc == null) {
      return null;
    }
    Object localObject = paramFilterDesc.getResFold(SdkContext.getInstance().getResources().getArtFilterResource().getFilterResPath());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create MTV1 filter, res path:");
    localStringBuilder.append((String)localObject);
    SLog.d("QQMTVFilter", localStringBuilder.toString());
    localObject = new MTV1Filter((String)localObject);
    if (paramFilterDesc.bundle != null)
    {
      boolean bool1 = paramFilterDesc.bundle.getBoolean("bRevert", false);
      long l = paramFilterDesc.bundle.getLong("lSeed", 0L);
      boolean bool2 = paramFilterDesc.bundle.getBoolean("bShowEntrance", true);
      paramFilterDesc = new StringBuilder();
      paramFilterDesc.append("create MTV1 filter, brevert:");
      paramFilterDesc.append(bool1);
      paramFilterDesc.append(" seed:");
      paramFilterDesc.append(l);
      paramFilterDesc.append(" bshowentrance:");
      paramFilterDesc.append(bool2);
      SLog.d("QQMTVFilter", paramFilterDesc.toString());
      ((MTV1Filter)localObject).revert(bool1);
      ((MTV1Filter)localObject).setSeed(l);
      ((MTV1Filter)localObject).setShowEntrance(bool2);
    }
    return localObject;
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
    Object localObject = this.mCurrentDesc;
    if (localObject != null)
    {
      if (((FilterDesc)localObject).id == -1) {
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
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("create new filter, id:");
        ((StringBuilder)localObject).append(this.mCurrentDesc.id);
        SLog.d("QQMTVFilter", ((StringBuilder)localObject).toString());
        int i = this.mCurrentDesc.id;
        if (i != 1017)
        {
          if (i == 1018) {
            this.mCurrentFilter = createFilmFilter(this.mCurrentDesc);
          }
        }
        else {
          this.mCurrentFilter = createMTV1Filter(this.mCurrentDesc);
        }
        localObject = this.mCurrentFilter;
        if (localObject != null) {
          ((MTVBaseFilter)localObject).onSurfaceChange(paramInt1, paramInt2);
        }
        this.mReset = true;
      }
      return this.mCurrentFilter;
    }
    return null;
  }
  
  private boolean isMTVID(FilterDesc paramFilterDesc)
  {
    boolean bool = false;
    if (paramFilterDesc == null) {
      return false;
    }
    if (QQAVImageFilterConstants.getFilterType(paramFilterDesc.id) == 4) {
      bool = true;
    }
    return bool;
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
      while (!this.mRunOnDraw.isEmpty()) {
        ((Runnable)this.mRunOnDraw.removeFirst()).run();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void enable(boolean paramBoolean)
  {
    this.mEnabled = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enable:");
    localStringBuilder.append(this.mEnabled);
    SLog.d("QQMTVFilter", localStringBuilder.toString());
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
    Object localObject = getMTVFilter(getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
    if (localObject == null)
    {
      this.mWorking = false;
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
    long l2 = getCurrentMs();
    QQSpecialAVFilter.MusicWaveformSupporter localMusicWaveformSupporter = this.mMusicWaveformSupporter;
    float f;
    if (localMusicWaveformSupporter == null) {
      f = getQQFilterRenderManager().getBusinessOperation().getCurrentMusicGain();
    } else {
      f = localMusicWaveformSupporter.getCurrentMusicGain();
    }
    if ((f <= 0.0F) || (f > 1.0F)) {
      f = 0.0F;
    }
    this.mRenderFBO.recoverInitialTexId();
    this.mRenderFBO.bind();
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(17664);
    this.mRenderFBO.unbind();
    ((MTVBaseFilter)localObject).onDrawFrame(this.mInputTextureID, this.mRenderFBO, l2, f);
    this.mOutputTextureID = this.mRenderFBO.getTexId();
    this.mWorking = true;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QQMTVFilter onDrawFrame cost: ");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
    SLog.d("QQMTVFilter", ((StringBuilder)localObject).toString());
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    super.onSurfaceChange(paramInt1, paramInt2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceChange, width:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" height:");
    localStringBuilder.append(paramInt2);
    SLog.d("QQMTVFilter", localStringBuilder.toString());
    setCurrentId(getQQFilterRenderManager().getBusinessOperation().getCurrentAVFilterIdByType(4));
  }
  
  public void onSurfaceDestroy()
  {
    SLog.d("QQMTVFilter", "onSurfaceDestroy");
    MTVBaseFilter localMTVBaseFilter = this.mCurrentFilter;
    if (localMTVBaseFilter != null)
    {
      localMTVBaseFilter.onSurfaceDestroy();
      this.mCurrentFilter = null;
    }
    localMTVBaseFilter = this.mOldFilter;
    if (localMTVBaseFilter != null)
    {
      localMTVBaseFilter.onSurfaceDestroy();
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
    else
    {
      this.mCurrentDesc = null;
      this.mWorking = false;
      SLog.d("QQMTVFilter", "setCurrentId, is not mtv ID.");
    }
    paramFilterDesc = this.mCurrentFilter;
    if (paramFilterDesc != null)
    {
      this.mOldFilter = paramFilterDesc;
      this.mCurrentFilter = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQMTVFilter
 * JD-Core Version:    0.7.0.1
 */
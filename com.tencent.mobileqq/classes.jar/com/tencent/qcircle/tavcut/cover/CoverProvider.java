package com.tencent.qcircle.tavcut.cover;

import android.graphics.Bitmap;
import com.tencent.qcircle.tavcut.timeline.TimelineCoverGenerator;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavkit.composition.TAVSource;
import java.util.List;

public class CoverProvider
{
  private static final String TAG = "CoverProvider";
  private CoverCache mCoverCache;
  private ICoverGenerator mCoverGenerator;
  private CoverListener mCoverListener;
  private RenderContextParams mRenderContextParams;
  
  public Bitmap getCover(int paramInt)
  {
    Object localObject = this.mCoverCache;
    if (localObject != null)
    {
      localObject = ((CoverCache)localObject).getCover(paramInt);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        return this.mCoverCache.getCover(paramInt);
      }
    }
    return null;
  }
  
  public void getCoverByIndexRange(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCoverByIndexRange: startIndex is ");
    ((StringBuilder)localObject).append(paramInt1);
    Logger.d("CoverProvider", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCoverByIndexRange: endIndex is ");
    ((StringBuilder)localObject).append(paramInt2);
    Logger.d("CoverProvider", ((StringBuilder)localObject).toString());
    localObject = this.mCoverGenerator;
    if (localObject != null) {
      ((ICoverGenerator)localObject).generateCoverByIndexRange(paramInt1, paramInt2);
    }
  }
  
  public void getCoverByTimeRange(long paramLong1, long paramLong2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCoverByTimeRange: startDurationMs is ");
    ((StringBuilder)localObject).append(paramLong1);
    Logger.d("CoverProvider", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCoverByTimeRange: endDurationMs is ");
    ((StringBuilder)localObject).append(paramLong2);
    Logger.d("CoverProvider", ((StringBuilder)localObject).toString());
    localObject = this.mCoverGenerator;
    if (localObject != null) {
      ((ICoverGenerator)localObject).generateCoverByTimeRange(paramLong1, paramLong2);
    }
  }
  
  public void init(TAVSource paramTAVSource, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init: itemDurationMs is ");
    ((StringBuilder)localObject).append(paramLong);
    Logger.d("CoverProvider", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init: coverWidth is ");
    ((StringBuilder)localObject).append(paramInt2);
    Logger.d("CoverProvider", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init: coverHeight is ");
    ((StringBuilder)localObject).append(paramInt3);
    Logger.d("CoverProvider", ((StringBuilder)localObject).toString());
    this.mCoverCache = new CoverCache();
    localObject = this.mCoverListener;
    if (localObject != null) {
      this.mCoverCache.setClipCoverListener((CoverListener)localObject);
    }
    this.mCoverGenerator = new TimelineCoverGenerator();
    this.mCoverGenerator.setCoverCache(this.mCoverCache);
    this.mCoverGenerator.setRenderContextParamas(this.mRenderContextParams);
    this.mCoverGenerator.init(paramTAVSource, paramLong, paramInt1, paramInt2, paramInt3);
  }
  
  public void init(TAVSource paramTAVSource, long paramLong, int paramInt1, int paramInt2, int paramInt3, ICoverGenerator paramICoverGenerator)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init: itemDurationMs is ");
    ((StringBuilder)localObject).append(paramLong);
    Logger.d("CoverProvider", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init: coverWidth is ");
    ((StringBuilder)localObject).append(paramInt2);
    Logger.d("CoverProvider", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init: coverHeight is ");
    ((StringBuilder)localObject).append(paramInt3);
    Logger.d("CoverProvider", ((StringBuilder)localObject).toString());
    this.mCoverCache = new CoverCache();
    localObject = this.mCoverListener;
    if (localObject != null) {
      this.mCoverCache.setClipCoverListener((CoverListener)localObject);
    }
    this.mCoverGenerator = paramICoverGenerator;
    this.mCoverGenerator.setCoverCache(this.mCoverCache);
    this.mCoverGenerator.init(paramTAVSource, paramLong, paramInt1, paramInt2, paramInt3);
  }
  
  public void init(TAVSource paramTAVSource, List<CMTime> paramList, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init: generateTimeList is ");
    ((StringBuilder)localObject).append(paramList);
    Logger.d("CoverProvider", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init: coverWidth is ");
    ((StringBuilder)localObject).append(paramInt1);
    Logger.d("CoverProvider", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init: coverHeight is ");
    ((StringBuilder)localObject).append(paramInt2);
    Logger.d("CoverProvider", ((StringBuilder)localObject).toString());
    this.mCoverCache = new CoverCache();
    localObject = this.mCoverListener;
    if (localObject != null) {
      this.mCoverCache.setClipCoverListener((CoverListener)localObject);
    }
    this.mCoverGenerator = new EditCoverGenerator();
    this.mCoverGenerator.setCoverCache(this.mCoverCache);
    this.mCoverGenerator.init(paramTAVSource, paramList, paramInt1, paramInt2);
  }
  
  public void pause()
  {
    ICoverGenerator localICoverGenerator = this.mCoverGenerator;
    if (localICoverGenerator != null) {
      localICoverGenerator.pause();
    }
  }
  
  public void release()
  {
    Object localObject = this.mCoverGenerator;
    if (localObject != null)
    {
      ((ICoverGenerator)localObject).release();
      this.mCoverGenerator = null;
    }
    localObject = this.mCoverCache;
    if (localObject != null)
    {
      ((CoverCache)localObject).release();
      this.mCoverCache = null;
    }
    this.mCoverListener = null;
  }
  
  public void resume()
  {
    ICoverGenerator localICoverGenerator = this.mCoverGenerator;
    if (localICoverGenerator != null) {
      localICoverGenerator.resume();
    }
  }
  
  public void setCoverListener(CoverListener paramCoverListener)
  {
    this.mCoverListener = paramCoverListener;
  }
  
  public void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    this.mRenderContextParams = paramRenderContextParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.cover.CoverProvider
 * JD-Core Version:    0.7.0.1
 */
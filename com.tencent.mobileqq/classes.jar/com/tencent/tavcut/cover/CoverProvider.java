package com.tencent.tavcut.cover;

import android.graphics.Bitmap;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavcut.timeline.TimelineCoverGenerator;
import com.tencent.tavcut.util.Logger;
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
    if (this.mCoverCache != null)
    {
      Bitmap localBitmap = this.mCoverCache.getCover(paramInt);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        return this.mCoverCache.getCover(paramInt);
      }
    }
    return null;
  }
  
  public void getCoverByIndexRange(int paramInt1, int paramInt2)
  {
    Logger.d("CoverProvider", "getCoverByIndexRange: startIndex is " + paramInt1);
    Logger.d("CoverProvider", "getCoverByIndexRange: endIndex is " + paramInt2);
    if (this.mCoverGenerator != null) {
      this.mCoverGenerator.generateCoverByIndexRange(paramInt1, paramInt2);
    }
  }
  
  public void getCoverByTimeRange(long paramLong1, long paramLong2)
  {
    Logger.d("CoverProvider", "getCoverByTimeRange: startDurationMs is " + paramLong1);
    Logger.d("CoverProvider", "getCoverByTimeRange: endDurationMs is " + paramLong2);
    if (this.mCoverGenerator != null) {
      this.mCoverGenerator.generateCoverByTimeRange(paramLong1, paramLong2);
    }
  }
  
  public void init(TAVSource paramTAVSource, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    Logger.d("CoverProvider", "init: itemDurationMs is " + paramLong);
    Logger.d("CoverProvider", "init: coverWidth is " + paramInt2);
    Logger.d("CoverProvider", "init: coverHeight is " + paramInt3);
    this.mCoverCache = new CoverCache();
    if (this.mCoverListener != null) {
      this.mCoverCache.setClipCoverListener(this.mCoverListener);
    }
    this.mCoverGenerator = new TimelineCoverGenerator();
    this.mCoverGenerator.setCoverCache(this.mCoverCache);
    this.mCoverGenerator.setRenderContextParamas(this.mRenderContextParams);
    this.mCoverGenerator.init(paramTAVSource, paramLong, paramInt1, paramInt2, paramInt3);
  }
  
  public void init(TAVSource paramTAVSource, long paramLong, int paramInt1, int paramInt2, int paramInt3, ICoverGenerator paramICoverGenerator)
  {
    Logger.d("CoverProvider", "init: itemDurationMs is " + paramLong);
    Logger.d("CoverProvider", "init: coverWidth is " + paramInt2);
    Logger.d("CoverProvider", "init: coverHeight is " + paramInt3);
    this.mCoverCache = new CoverCache();
    if (this.mCoverListener != null) {
      this.mCoverCache.setClipCoverListener(this.mCoverListener);
    }
    this.mCoverGenerator = paramICoverGenerator;
    this.mCoverGenerator.setCoverCache(this.mCoverCache);
    this.mCoverGenerator.init(paramTAVSource, paramLong, paramInt1, paramInt2, paramInt3);
  }
  
  public void init(TAVSource paramTAVSource, List<CMTime> paramList, int paramInt1, int paramInt2)
  {
    Logger.d("CoverProvider", "init: generateTimeList is " + paramList);
    Logger.d("CoverProvider", "init: coverWidth is " + paramInt1);
    Logger.d("CoverProvider", "init: coverHeight is " + paramInt2);
    this.mCoverCache = new CoverCache();
    if (this.mCoverListener != null) {
      this.mCoverCache.setClipCoverListener(this.mCoverListener);
    }
    this.mCoverGenerator = new EditCoverGenerator();
    this.mCoverGenerator.setCoverCache(this.mCoverCache);
    this.mCoverGenerator.init(paramTAVSource, paramList, paramInt1, paramInt2);
  }
  
  public void pause()
  {
    if (this.mCoverGenerator != null) {
      this.mCoverGenerator.pause();
    }
  }
  
  public void release()
  {
    if (this.mCoverGenerator != null)
    {
      this.mCoverGenerator.release();
      this.mCoverGenerator = null;
    }
    if (this.mCoverCache != null)
    {
      this.mCoverCache.release();
      this.mCoverCache = null;
    }
    this.mCoverListener = null;
  }
  
  public void resume()
  {
    if (this.mCoverGenerator != null) {
      this.mCoverGenerator.resume();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.cover.CoverProvider
 * JD-Core Version:    0.7.0.1
 */
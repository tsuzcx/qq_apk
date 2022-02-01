package com.tencent.tav.core;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.List;

public abstract class AssetReaderOutput
{
  protected boolean alwaysCopiesSampleData = false;
  protected int mediaType;
  private AssetReaderOutput.StatusListener statusListener;
  protected boolean supportsRandomAccess = false;
  
  void addStatusListener(AssetReaderOutput.StatusListener paramStatusListener)
  {
    this.statusListener = paramStatusListener;
  }
  
  @NonNull
  public final CMSampleBuffer copyNextSampleBuffer()
  {
    CMSampleBuffer localCMSampleBuffer = nextSampleBuffer();
    if (localCMSampleBuffer.getTime().getTimeUs() > 0L) {
      return localCMSampleBuffer;
    }
    if (localCMSampleBuffer.getState().getStateCode() == -1L)
    {
      localStatusListener = this.statusListener;
      if (localStatusListener != null) {
        localStatusListener.statusChanged(this, AssetReader.AVAssetReaderStatus.AssetReaderStatusCompleted);
      }
      return localCMSampleBuffer;
    }
    AssetReaderOutput.StatusListener localStatusListener = this.statusListener;
    if (localStatusListener != null) {
      localStatusListener.statusChanged(this, AssetReader.AVAssetReaderStatus.AssetReaderStatusFailed);
    }
    return localCMSampleBuffer;
  }
  
  long duration()
  {
    return 0L;
  }
  
  public int getMediaType()
  {
    return this.mediaType;
  }
  
  public boolean isAlwaysCopiesSampleData()
  {
    return this.alwaysCopiesSampleData;
  }
  
  public boolean isSupportsRandomAccess()
  {
    return this.supportsRandomAccess;
  }
  
  public abstract void markConfigurationAsFinal();
  
  @NonNull
  public abstract CMSampleBuffer nextSampleBuffer();
  
  abstract void release();
  
  public abstract void resetForReadingTimeRanges(List<CMTimeRange> paramList);
  
  public void setAlwaysCopiesSampleData(boolean paramBoolean)
  {
    this.alwaysCopiesSampleData = paramBoolean;
  }
  
  public void setSupportsRandomAccess(boolean paramBoolean)
  {
    this.supportsRandomAccess = paramBoolean;
  }
  
  abstract void start(@Nullable IContextCreate paramIContextCreate, AssetReader paramAssetReader);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.core.AssetReaderOutput
 * JD-Core Version:    0.7.0.1
 */
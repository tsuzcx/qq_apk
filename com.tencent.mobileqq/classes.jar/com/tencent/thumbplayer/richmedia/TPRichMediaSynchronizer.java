package com.tencent.thumbplayer.richmedia;

import android.content.Context;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizerListener;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaFeature;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaFeatureData;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaRequestExtraInfo;
import com.tencent.thumbplayer.core.richmedia.ITPNativeRichMediaProcessor;
import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaFeature;
import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaProcessor;
import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaRequestExtraInfo;
import com.tencent.thumbplayer.richmedia.plugins.TPRichMediaSynchronizerReportPlugin;
import com.tencent.thumbplayer.tplayer.plugins.TPPluginManager;

public class TPRichMediaSynchronizer
  implements ITPInnerRichMediaSynchronizer
{
  private TPRichMediaSynchronizer.TPRichMediaInnerProcessCallback mInnerProcessCallback;
  private ITPNativeRichMediaProcessor mNativeRichMediaProcessor;
  private TPRichMediaSynchronizer.TPRichMediaProcessCallback mProcessCallback;
  private TPPluginManager mTPPluginManager;
  
  public TPRichMediaSynchronizer(Context paramContext)
  {
    this.mNativeRichMediaProcessor = new TPNativeRichMediaProcessor(paramContext);
    this.mInnerProcessCallback = new TPRichMediaSynchronizer.TPRichMediaInnerProcessCallback(this);
    this.mNativeRichMediaProcessor.setInnerProcessorCallback(this.mInnerProcessCallback);
    this.mProcessCallback = new TPRichMediaSynchronizer.TPRichMediaProcessCallback(this);
    this.mNativeRichMediaProcessor.setProcessorCallback(this.mProcessCallback);
    this.mTPPluginManager = new TPPluginManager();
    this.mTPPluginManager.addPlugin(new TPRichMediaSynchronizerReportPlugin());
  }
  
  private void pushEvent(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    this.mTPPluginManager.onEvent(paramInt1, paramInt2, paramInt3, paramString, paramObject);
  }
  
  public void deselectFeatureAsync(int paramInt)
  {
    this.mNativeRichMediaProcessor.deselectFeatureAsync(paramInt);
    pushEvent(304, paramInt, 0, null, null);
  }
  
  protected void finalize()
  {
    this.mNativeRichMediaProcessor.setInnerProcessorCallback(null);
    this.mNativeRichMediaProcessor.setProcessorCallback(null);
    this.mNativeRichMediaProcessor.release();
    this.mProcessCallback.setSynchronizerListener(null);
    this.mInnerProcessCallback.setInnerSynchronizerListener(null);
    super.finalize();
  }
  
  public TPRichMediaFeatureData getCurrentPositionMsFeatureData(long paramLong, int[] paramArrayOfInt)
  {
    return new TPRichMediaFeatureData(this.mNativeRichMediaProcessor.getCurrentPositionMsFeatureData(paramLong, paramArrayOfInt));
  }
  
  public TPRichMediaFeature[] getFeatures()
  {
    TPNativeRichMediaFeature[] arrayOfTPNativeRichMediaFeature = this.mNativeRichMediaProcessor.getFeatures();
    int i = 0;
    if (arrayOfTPNativeRichMediaFeature == null) {
      return new TPRichMediaFeature[0];
    }
    TPRichMediaFeature[] arrayOfTPRichMediaFeature = new TPRichMediaFeature[arrayOfTPNativeRichMediaFeature.length];
    while (i < arrayOfTPNativeRichMediaFeature.length)
    {
      if (arrayOfTPNativeRichMediaFeature[i] == null) {
        return arrayOfTPRichMediaFeature;
      }
      arrayOfTPRichMediaFeature[i] = new TPRichMediaFeature(arrayOfTPNativeRichMediaFeature[i]);
      i += 1;
    }
    return arrayOfTPRichMediaFeature;
  }
  
  public void prepareAsync()
  {
    this.mNativeRichMediaProcessor.prepareAsync();
    pushEvent(300, 0, 0, null, null);
  }
  
  public void release()
  {
    this.mNativeRichMediaProcessor.setInnerProcessorCallback(null);
    this.mNativeRichMediaProcessor.setProcessorCallback(null);
    this.mNativeRichMediaProcessor.release();
    this.mProcessCallback.setSynchronizerListener(null);
    this.mInnerProcessCallback.setInnerSynchronizerListener(null);
    pushEvent(307, 0, 0, null, null);
    this.mTPPluginManager.release();
  }
  
  public void reset()
  {
    this.mNativeRichMediaProcessor.reset();
    pushEvent(306, 0, 0, null, null);
  }
  
  public void seek(long paramLong)
  {
    this.mNativeRichMediaProcessor.seek(paramLong);
  }
  
  public void selectFeatureAsync(int paramInt, TPRichMediaRequestExtraInfo paramTPRichMediaRequestExtraInfo)
  {
    TPNativeRichMediaRequestExtraInfo localTPNativeRichMediaRequestExtraInfo = new TPNativeRichMediaRequestExtraInfo();
    localTPNativeRichMediaRequestExtraInfo.setActOnOptional(paramTPRichMediaRequestExtraInfo.getActOnOption());
    this.mNativeRichMediaProcessor.selectFeatureAsync(paramInt, localTPNativeRichMediaRequestExtraInfo);
    pushEvent(302, paramInt, 0, null, null);
  }
  
  public void setInnerListener(ITPInnerRichMediaSynchronizer.ITPRichMediaInnerSynchronizerListener paramITPRichMediaInnerSynchronizerListener)
  {
    this.mInnerProcessCallback.setInnerSynchronizerListener(paramITPRichMediaInnerSynchronizerListener);
  }
  
  public void setListener(ITPRichMediaSynchronizerListener paramITPRichMediaSynchronizerListener)
  {
    this.mProcessCallback.setSynchronizerListener(paramITPRichMediaSynchronizerListener);
  }
  
  public void setPlaybackRate(float paramFloat)
  {
    this.mNativeRichMediaProcessor.setPlaybackRate(paramFloat);
  }
  
  public void setRichMediaSource(String paramString)
  {
    this.mNativeRichMediaProcessor.setRichMediaSource(paramString);
    pushEvent(309, 0, 0, paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.richmedia.TPRichMediaSynchronizer
 * JD-Core Version:    0.7.0.1
 */
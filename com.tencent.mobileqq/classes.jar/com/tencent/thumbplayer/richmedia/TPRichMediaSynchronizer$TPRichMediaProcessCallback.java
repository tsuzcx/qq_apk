package com.tencent.thumbplayer.richmedia;

import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizerListener;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaFeatureData;
import com.tencent.thumbplayer.core.richmedia.ITPNativeRichMediaProcessor;
import com.tencent.thumbplayer.core.richmedia.ITPNativeRichMediaProcessorCallback;
import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaFeatureData;

class TPRichMediaSynchronizer$TPRichMediaProcessCallback
  implements ITPNativeRichMediaProcessorCallback
{
  private ITPRichMediaSynchronizerListener mSynchronizerListener;
  
  TPRichMediaSynchronizer$TPRichMediaProcessCallback(TPRichMediaSynchronizer paramTPRichMediaSynchronizer) {}
  
  public void onDeselectFeatureSuccess(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor, int paramInt)
  {
    TPRichMediaSynchronizer.access$000(this.this$0, 305, paramInt, 0, null, null);
    paramITPNativeRichMediaProcessor = this.mSynchronizerListener;
    if (paramITPNativeRichMediaProcessor != null) {
      paramITPNativeRichMediaProcessor.onDeselectFeatureSuccess(this.this$0, paramInt);
    }
  }
  
  public void onRichMediaError(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor, int paramInt)
  {
    TPRichMediaSynchronizer.access$000(this.this$0, 308, paramInt, 0, null, null);
    paramITPNativeRichMediaProcessor = this.mSynchronizerListener;
    if (paramITPNativeRichMediaProcessor != null) {
      paramITPNativeRichMediaProcessor.onRichMediaError(this.this$0, paramInt);
    }
  }
  
  public void onRichMediaFeatureData(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor, int paramInt, TPNativeRichMediaFeatureData paramTPNativeRichMediaFeatureData)
  {
    paramITPNativeRichMediaProcessor = this.mSynchronizerListener;
    if (paramITPNativeRichMediaProcessor != null) {
      paramITPNativeRichMediaProcessor.onRichMediaFeatureData(this.this$0, paramInt, new TPRichMediaFeatureData(paramTPNativeRichMediaFeatureData));
    }
  }
  
  public void onRichMediaFeatureFailure(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor, int paramInt1, int paramInt2)
  {
    TPRichMediaSynchronizer.access$000(this.this$0, 310, paramInt1, paramInt2, null, null);
    paramITPNativeRichMediaProcessor = this.mSynchronizerListener;
    if (paramITPNativeRichMediaProcessor != null) {
      paramITPNativeRichMediaProcessor.onRichMediaFeatureFailure(this.this$0, paramInt1, paramInt2);
    }
  }
  
  public void onRichMediaInfo(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor, int paramInt, long paramLong1, long paramLong2, long paramLong3, Object paramObject)
  {
    paramITPNativeRichMediaProcessor = this.mSynchronizerListener;
    if (paramITPNativeRichMediaProcessor != null) {
      paramITPNativeRichMediaProcessor.onRichMediaInfo(this.this$0, paramInt, paramLong1, paramLong2, paramLong3, paramObject);
    }
  }
  
  public void onRichMediaPrepared(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor)
  {
    paramITPNativeRichMediaProcessor = this.this$0.getFeatures();
    TPRichMediaSynchronizer.access$000(this.this$0, 301, 0, 0, null, paramITPNativeRichMediaProcessor);
    paramITPNativeRichMediaProcessor = this.mSynchronizerListener;
    if (paramITPNativeRichMediaProcessor != null) {
      paramITPNativeRichMediaProcessor.onRichMediaPrepared(this.this$0);
    }
  }
  
  public void onSelectFeatureSuccess(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor, int paramInt)
  {
    TPRichMediaSynchronizer.access$000(this.this$0, 303, paramInt, 0, null, null);
    paramITPNativeRichMediaProcessor = this.mSynchronizerListener;
    if (paramITPNativeRichMediaProcessor != null) {
      paramITPNativeRichMediaProcessor.onSelectFeatureSuccess(this.this$0, paramInt);
    }
  }
  
  public void setSynchronizerListener(ITPRichMediaSynchronizerListener paramITPRichMediaSynchronizerListener)
  {
    this.mSynchronizerListener = paramITPRichMediaSynchronizerListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.richmedia.TPRichMediaSynchronizer.TPRichMediaProcessCallback
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.thumbplayer.richmedia;

import com.tencent.thumbplayer.core.richmedia.ITPNativeRichMediaInnerProcessorCallback;
import com.tencent.thumbplayer.core.richmedia.ITPNativeRichMediaProcessor;

class TPRichMediaSynchronizer$TPRichMediaInnerProcessCallback
  implements ITPNativeRichMediaInnerProcessorCallback
{
  private ITPInnerRichMediaSynchronizer.ITPRichMediaInnerSynchronizerListener mInnerSynchronizerListener;
  
  TPRichMediaSynchronizer$TPRichMediaInnerProcessCallback(TPRichMediaSynchronizer paramTPRichMediaSynchronizer) {}
  
  public long onGetCurrentPositionMs(ITPNativeRichMediaProcessor paramITPNativeRichMediaProcessor)
  {
    paramITPNativeRichMediaProcessor = this.mInnerSynchronizerListener;
    if (paramITPNativeRichMediaProcessor != null)
    {
      long l = paramITPNativeRichMediaProcessor.onGetCurrentPositionMs(this.this$0);
      TPRichMediaSynchronizer.access$000(this.this$0, 311, (int)l, 0, null, null);
      return l;
    }
    return -1L;
  }
  
  public void setInnerSynchronizerListener(ITPInnerRichMediaSynchronizer.ITPRichMediaInnerSynchronizerListener paramITPRichMediaInnerSynchronizerListener)
  {
    this.mInnerSynchronizerListener = paramITPRichMediaInnerSynchronizerListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.richmedia.TPRichMediaSynchronizer.TPRichMediaInnerProcessCallback
 * JD-Core Version:    0.7.0.1
 */
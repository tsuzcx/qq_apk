package com.tencent.thumbplayer.adapter;

import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.richmedia.ITPInnerRichMediaSynchronizer.ITPRichMediaInnerSynchronizerListener;

class TPPlayerAdapter$1
  implements ITPInnerRichMediaSynchronizer.ITPRichMediaInnerSynchronizerListener
{
  TPPlayerAdapter$1(TPPlayerAdapter paramTPPlayerAdapter) {}
  
  public long onGetCurrentPositionMs(ITPRichMediaSynchronizer paramITPRichMediaSynchronizer)
  {
    return this.this$0.getCurrentPositionMs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.TPPlayerAdapter.1
 * JD-Core Version:    0.7.0.1
 */
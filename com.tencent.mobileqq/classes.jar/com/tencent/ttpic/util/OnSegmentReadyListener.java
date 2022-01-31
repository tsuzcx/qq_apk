package com.tencent.ttpic.util;

import com.tencent.filter.Frame;
import com.tencent.ttpic.gles.SegmentDataPipe;

public abstract interface OnSegmentReadyListener
{
  public abstract SegmentDataPipe getReadyData();
  
  public abstract boolean needWait();
  
  public abstract void onTextureReady(Frame paramFrame);
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.OnSegmentReadyListener
 * JD-Core Version:    0.7.0.1
 */
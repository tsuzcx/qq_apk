package com.tencent.tkd.topicsdk.widget.videocrop;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/videocrop/FramesProcessor$OnFetchFrameListener;", "", "isInited", "", "()Z", "fetchFrameByIndex", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FramesProcessor$Frame;", "frameIndex", "", "", "startIndex", "endIndex", "init", "milliPerSec", "videoDuration", "adapter", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameAdapter;", "release", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface FramesProcessor$OnFetchFrameListener
{
  public abstract int a(int paramInt1, int paramInt2, @Nullable FrameAdapter paramFrameAdapter);
  
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.FramesProcessor.OnFetchFrameListener
 * JD-Core Version:    0.7.0.1
 */
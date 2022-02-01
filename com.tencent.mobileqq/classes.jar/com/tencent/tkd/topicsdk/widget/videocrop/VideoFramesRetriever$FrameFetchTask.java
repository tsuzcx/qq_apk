package com.tencent.tkd.topicsdk.widget.videocrop;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever$FrameFetchTask;", "", "Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;", "requestTime", "", "startTime", "", "endTime", "(Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;JII)V", "getEndTime", "()I", "setEndTime", "(I)V", "getRequestTime", "()J", "setRequestTime", "(J)V", "getStartTime", "setStartTime", "compareTo", "other", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoFramesRetriever$FrameFetchTask
  implements Comparable<FrameFetchTask>
{
  private int b;
  private long c;
  private int d;
  
  public VideoFramesRetriever$FrameFetchTask(long paramLong, int paramInt1, int paramInt2)
  {
    this.c = ???;
    this.d = paramInt2;
    int i;
    this.b = Math.min(i, VideoFramesRetriever.a(paramLong));
    ((Map)VideoFramesRetriever.b(paramLong)).put(Integer.valueOf(this.d), this);
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public int a(@Nullable FrameFetchTask paramFrameFetchTask)
  {
    long l;
    if (paramFrameFetchTask != null) {
      l = paramFrameFetchTask.c;
    } else {
      l = 0L;
    }
    return -(int)(this.c - l);
  }
  
  public final void a(long paramLong)
  {
    this.c = paramLong;
  }
  
  public final int b()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.VideoFramesRetriever.FrameFetchTask
 * JD-Core Version:    0.7.0.1
 */
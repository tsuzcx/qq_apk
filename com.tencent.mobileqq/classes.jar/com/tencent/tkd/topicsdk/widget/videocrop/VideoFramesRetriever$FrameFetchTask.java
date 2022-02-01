package com.tencent.tkd.topicsdk.widget.videocrop;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever$FrameFetchTask;", "", "Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;", "requestTime", "", "startTime", "", "endTime", "(Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFramesRetriever;JII)V", "getEndTime", "()I", "setEndTime", "(I)V", "getRequestTime", "()J", "setRequestTime", "(J)V", "getStartTime", "setStartTime", "compareTo", "other", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoFramesRetriever$FrameFetchTask
  implements Comparable<FrameFetchTask>
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private int b;
  
  public VideoFramesRetriever$FrameFetchTask(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Long = ???;
    this.b = paramInt2;
    int i;
    this.jdField_a_of_type_Int = Math.min(i, VideoFramesRetriever.a(paramLong));
    ((Map)VideoFramesRetriever.a(paramLong)).put(Integer.valueOf(this.b), this);
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(@Nullable FrameFetchTask paramFrameFetchTask)
  {
    if (paramFrameFetchTask != null) {}
    for (long l = paramFrameFetchTask.jdField_a_of_type_Long;; l = 0L) {
      return -(int)(this.jdField_a_of_type_Long - l);
    }
  }
  
  public final void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public final int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.VideoFramesRetriever.FrameFetchTask
 * JD-Core Version:    0.7.0.1
 */
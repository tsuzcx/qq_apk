package com.tencent.tavcut.resource;

import com.tencent.tavcut.model.ClipSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/resource/TemplateSegmentHelper$SegmentModel;", "", "()V", "minDuration", "", "getMinDuration", "()J", "setMinDuration", "(J)V", "timeRange", "Lcom/tencent/tavcut/resource/TemplateSegmentHelper$SegmentTimeRange;", "getTimeRange", "()Lcom/tencent/tavcut/resource/TemplateSegmentHelper$SegmentTimeRange;", "setTimeRange", "(Lcom/tencent/tavcut/resource/TemplateSegmentHelper$SegmentTimeRange;)V", "videoResourceModels", "", "Lcom/tencent/tavcut/model/ClipSource;", "getVideoResourceModels", "()Ljava/util/List;", "setVideoResourceModels", "(Ljava/util/List;)V", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class TemplateSegmentHelper$SegmentModel
{
  @NotNull
  private TemplateSegmentHelper.SegmentTimeRange a = new TemplateSegmentHelper.SegmentTimeRange(0L, 0L, 3, null);
  private long b;
  @NotNull
  private List<ClipSource> c = (List)new ArrayList();
  
  @NotNull
  public final TemplateSegmentHelper.SegmentTimeRange a()
  {
    return this.a;
  }
  
  public final void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public final void a(@NotNull TemplateSegmentHelper.SegmentTimeRange paramSegmentTimeRange)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentTimeRange, "<set-?>");
    this.a = paramSegmentTimeRange;
  }
  
  public final void a(@NotNull List<ClipSource> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "<set-?>");
    this.c = paramList;
  }
  
  @NotNull
  public final List<ClipSource> b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.resource.TemplateSegmentHelper.SegmentModel
 * JD-Core Version:    0.7.0.1
 */
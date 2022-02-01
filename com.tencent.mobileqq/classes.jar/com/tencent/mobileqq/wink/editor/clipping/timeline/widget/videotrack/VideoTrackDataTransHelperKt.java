package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.ScaleCalculator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"MIN_DURATION_US", "", "transVariableClipModelToVideoTrackModel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VideoTrackModel;", "variableClipModel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VariableClipModel;", "scaleCalculator", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScaleCalculator;", "transVideoTrackModelToClipModel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/ClipModel;", "videoTrackModel", "isChanged", "", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class VideoTrackDataTransHelperKt
{
  @NotNull
  public static final ClipModel a(@NotNull VideoTrackModel paramVideoTrackModel, @NotNull ScaleCalculator paramScaleCalculator, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoTrackModel, "videoTrackModel");
    Intrinsics.checkParameterIsNotNull(paramScaleCalculator, "scaleCalculator");
    if (paramBoolean)
    {
      paramScaleCalculator = (Function2)new VideoTrackDataTransHelperKt.transVideoTrackModelToClipModel..inlined.run.lambda.1(paramBoolean, paramScaleCalculator);
      long l1 = ((Number)paramScaleCalculator.invoke(Integer.valueOf(paramVideoTrackModel.h()), Long.valueOf(paramVideoTrackModel.n().d().d()))).longValue();
      long l2 = ((Number)paramScaleCalculator.invoke(Integer.valueOf(paramVideoTrackModel.e()), Long.valueOf(paramVideoTrackModel.n().d().c()))).longValue();
      paramScaleCalculator = paramVideoTrackModel.n().d();
      float f1 = (float)paramScaleCalculator.g();
      float f2 = (float)(paramScaleCalculator.c() - l2) / paramScaleCalculator.a();
      paramScaleCalculator = paramVideoTrackModel.b();
      int i = paramVideoTrackModel.c();
      String str = paramVideoTrackModel.d();
      long l3 = (f1 - f2);
      return new ClipModel(paramScaleCalculator, i, str, new TimeData(l2, l1, l1, ((float)l1 / paramVideoTrackModel.n().d().a()), l3, paramVideoTrackModel.n().d().h(), paramVideoTrackModel.n().d().i()), paramVideoTrackModel.n().g());
    }
    return new ClipModel(paramVideoTrackModel.n().a(), paramVideoTrackModel.n().b(), paramVideoTrackModel.n().c(), paramVideoTrackModel.n().d(), paramVideoTrackModel.n().g());
  }
  
  @NotNull
  public static final VideoTrackModel a(@NotNull VariableClipModel paramVariableClipModel, @NotNull ScaleCalculator paramScaleCalculator)
  {
    Intrinsics.checkParameterIsNotNull(paramVariableClipModel, "variableClipModel");
    Intrinsics.checkParameterIsNotNull(paramScaleCalculator, "scaleCalculator");
    int i;
    if (paramVariableClipModel.b() == 0)
    {
      localObject = paramVariableClipModel.d();
      i = paramScaleCalculator.b(((float)((TimeData)localObject).c() - (float)(((TimeData)localObject).g() - ((TimeData)localObject).i()) * ((TimeData)localObject).a()));
    }
    else
    {
      i = paramScaleCalculator.b(paramVariableClipModel.d().c());
    }
    int j;
    if (paramVariableClipModel.b() == 0)
    {
      localObject = paramVariableClipModel.d();
      j = paramScaleCalculator.b(((float)(((TimeData)localObject).h() - ((TimeData)localObject).g()) * ((TimeData)localObject).a()));
    }
    else
    {
      localObject = paramVariableClipModel.d();
      j = paramScaleCalculator.b(((float)(10000000L - ((TimeData)localObject).g()) * ((TimeData)localObject).a()));
    }
    int k = paramScaleCalculator.b(paramVariableClipModel.d().c());
    Object localObject = paramVariableClipModel.a();
    int m = paramVariableClipModel.b();
    String str = paramVariableClipModel.c();
    int n = paramScaleCalculator.b(paramVariableClipModel.d().d());
    int i1 = paramScaleCalculator.b(1000000L);
    return new VideoTrackModel((String)localObject, m, str, k, k - i, i, n, j, paramScaleCalculator.b(paramVariableClipModel.e()), paramScaleCalculator.b(paramVariableClipModel.f()), paramVariableClipModel.d().e(), i1, paramVariableClipModel, paramVariableClipModel.g());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackDataTransHelperKt
 * JD-Core Version:    0.7.0.1
 */
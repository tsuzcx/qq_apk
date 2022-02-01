package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "path", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoCapturePresenter$confirmClick$1
  extends Lambda
  implements Function1<String, Unit>
{
  VideoCapturePresenter$confirmClick$1(OutputPicListener paramOutputPicListener)
  {
    super(1);
  }
  
  public final void invoke(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    this.$outputPicListener.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCapturePresenter.confirmClick.1
 * JD-Core Version:    0.7.0.1
 */
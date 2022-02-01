package com.tencent.mobileqq.kandian.biz.publisher.impls;

import com.tencent.tkd.topicsdk.interfaces.IVideoCompressor.Callback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "needCompress", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoCompressor$needCompress$1
  extends Lambda
  implements Function1<Boolean, Unit>
{
  VideoCompressor$needCompress$1(IVideoCompressor.Callback paramCallback)
  {
    super(1);
  }
  
  public final void invoke(boolean paramBoolean)
  {
    this.$callback.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.VideoCompressor.needCompress.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.kandian.biz.publisher.impls;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoCompressor$checkNeedCompress$1$1
  extends Lambda
  implements Function0<Unit>
{
  VideoCompressor$checkNeedCompress$1$1(VideoCompressor.checkNeedCompress.1 param1, boolean paramBoolean)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.this$0.$callback.invoke(Boolean.valueOf(this.$needCompress));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.VideoCompressor.checkNeedCompress.1.1
 * JD-Core Version:    0.7.0.1
 */
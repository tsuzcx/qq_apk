package com.tencent.mobileqq.kandian.biz.publisher.impls;

import com.tencent.mobileqq.kandian.base.video.compress.VideoCompressUtil;
import com.tencent.mobileqq.kandian.base.video.compress.VideoMediaInfo;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoCompressor$checkNeedCompress$1
  extends Lambda
  implements Function0<Unit>
{
  VideoCompressor$checkNeedCompress$1(String paramString, Function1 paramFunction1)
  {
    super(0);
  }
  
  public final void invoke()
  {
    ThreadManagerKt.a((Function0)new VideoCompressor.checkNeedCompress.1.1(this, VideoCompressUtil.a(VideoMediaInfo.a(this.$path))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.VideoCompressor.checkNeedCompress.1
 * JD-Core Version:    0.7.0.1
 */
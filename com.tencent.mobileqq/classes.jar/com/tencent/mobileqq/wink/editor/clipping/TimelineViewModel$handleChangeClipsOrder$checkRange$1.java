package com.tencent.mobileqq.wink.editor.clipping;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "index", "", "invoke"}, k=3, mv={1, 1, 16})
final class TimelineViewModel$handleChangeClipsOrder$checkRange$1
  extends Lambda
  implements Function1<Integer, Boolean>
{
  TimelineViewModel$handleChangeClipsOrder$checkRange$1(List paramList)
  {
    super(1);
  }
  
  public final boolean invoke(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < this.$videos.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.TimelineViewModel.handleChangeClipsOrder.checkRange.1
 * JD-Core Version:    0.7.0.1
 */
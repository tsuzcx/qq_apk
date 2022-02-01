package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"attractPointPair", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/AttractPoint;", "updateAttractPoint", "", "startPoint", "endPoint", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class DragModelKt
{
  private static Pair<AttractPoint, AttractPoint> a;
  
  public static final void a(@Nullable AttractPoint paramAttractPoint1, @Nullable AttractPoint paramAttractPoint2)
  {
    Pair localPair = a;
    if (localPair == null)
    {
      a = new Pair(paramAttractPoint1, paramAttractPoint2);
      return;
    }
    Object localObject = null;
    if (paramAttractPoint1 != null)
    {
      if (localPair != null) {
        paramAttractPoint1 = Pair.copy$default(localPair, paramAttractPoint1, null, 2, null);
      } else {
        paramAttractPoint1 = null;
      }
      a = paramAttractPoint1;
    }
    if (paramAttractPoint2 != null)
    {
      localPair = a;
      paramAttractPoint1 = localObject;
      if (localPair != null) {
        paramAttractPoint1 = Pair.copy$default(localPair, null, paramAttractPoint2, 1, null);
      }
      a = paramAttractPoint1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragModelKt
 * JD-Core Version:    0.7.0.1
 */
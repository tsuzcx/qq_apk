package com.tencent.mobileqq.wink.editor.transition;

import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "invoke"}, k=3, mv={1, 1, 16})
final class TransitionModelExKt$bindVideoWithTransition$getVideoId$1
  extends Lambda
  implements Function1<Integer, String>
{
  TransitionModelExKt$bindVideoWithTransition$getVideoId$1(List paramList)
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(int paramInt)
  {
    Object localObject = (MediaClip)CollectionsKt.getOrNull(this.$videos, paramInt);
    if (localObject != null)
    {
      localObject = ((MediaClip)localObject).resource;
      if (localObject != null)
      {
        localObject = ((ResourceModel)localObject).id;
        if (localObject != null) {
          return localObject;
        }
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.transition.TransitionModelExKt.bindVideoWithTransition.getVideoId.1
 * JD-Core Version:    0.7.0.1
 */
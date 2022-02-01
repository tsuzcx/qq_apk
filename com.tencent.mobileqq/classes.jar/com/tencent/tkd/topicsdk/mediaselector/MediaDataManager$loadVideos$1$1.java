package com.tencent.tkd.topicsdk.mediaselector;

import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class MediaDataManager$loadVideos$1$1
  extends Lambda
  implements Function0<Unit>
{
  MediaDataManager$loadVideos$1$1(MediaDataManager.loadVideos.1 param1, ArrayList paramArrayList, HashMap paramHashMap)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.this$0.$callback.invoke(this.$allMediaList, this.$allMediaMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.MediaDataManager.loadVideos.1.1
 * JD-Core Version:    0.7.0.1
 */
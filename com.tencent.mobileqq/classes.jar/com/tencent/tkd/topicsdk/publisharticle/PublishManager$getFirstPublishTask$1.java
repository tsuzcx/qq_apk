package com.tencent.tkd.topicsdk.publisharticle;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishManager$getFirstPublishTask$1
  extends Lambda
  implements Function0<Unit>
{
  PublishManager$getFirstPublishTask$1(Function1 paramFunction1)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Function1 localFunction1 = this.$callback;
    Object localObject = (PublishManager.PublishTask)CollectionsKt.firstOrNull((List)PublishManager.a(PublishManager.a));
    if (localObject != null) {}
    for (localObject = ((PublishManager.PublishTask)localObject).a();; localObject = null)
    {
      localFunction1.invoke(localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.getFirstPublishTask.1
 * JD-Core Version:    0.7.0.1
 */
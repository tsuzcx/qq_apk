package com.tencent.tkd.topicsdk.publisharticle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishManager$initData$1$2
  extends Lambda
  implements Function0<Unit>
{
  PublishManager$initData$1$2(PublishManager.initData.1 param1)
  {
    super(0);
  }
  
  public final void invoke()
  {
    PublishManager.a(PublishManager.a, true);
    Object localObject = this.this$0.$finishCallback;
    if (localObject != null) {
      localObject = (Unit)((Function0)localObject).invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.initData.1.2
 * JD-Core Version:    0.7.0.1
 */
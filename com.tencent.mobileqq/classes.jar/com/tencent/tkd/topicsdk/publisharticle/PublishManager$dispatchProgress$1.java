package com.tencent.tkd.topicsdk.publisharticle;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishManager$dispatchProgress$1
  extends Lambda
  implements Function0<Unit>
{
  PublishManager$dispatchProgress$1(String paramString, int paramInt)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Iterator localIterator = ((Iterable)PublishManager.b(PublishManager.a)).iterator();
    while (localIterator.hasNext()) {
      ((PublishManager.IPublishArticleListener)localIterator.next()).a(this.$publishId, this.$progress);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.dispatchProgress.1
 * JD-Core Version:    0.7.0.1
 */
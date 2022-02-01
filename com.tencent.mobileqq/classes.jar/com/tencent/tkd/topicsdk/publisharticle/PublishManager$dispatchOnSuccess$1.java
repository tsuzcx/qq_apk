package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.interfaces.IPublishManager.IPublishListener;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishManager$dispatchOnSuccess$1
  extends Lambda
  implements Function0<Unit>
{
  PublishManager$dispatchOnSuccess$1(PublishArticleInfo paramPublishArticleInfo, GlobalPublisherConfig paramGlobalPublisherConfig, String paramString)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.$articleInfo.setPublishing(false);
    PublishManager.a.a(this.$articleInfo.getPublishId());
    Iterator localIterator = ((Iterable)PublishManager.b(PublishManager.a)).iterator();
    while (localIterator.hasNext()) {
      ((PublishManager.IPublishArticleListener)localIterator.next()).a(this.$globalPublisherConfig, this.$articleInfo, this.$serverPublishData);
    }
    localIterator = ((Iterable)PublishManager.c(PublishManager.a)).iterator();
    while (localIterator.hasNext()) {
      ((IPublishManager.IPublishListener)localIterator.next()).a(this.$articleInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.dispatchOnSuccess.1
 * JD-Core Version:    0.7.0.1
 */
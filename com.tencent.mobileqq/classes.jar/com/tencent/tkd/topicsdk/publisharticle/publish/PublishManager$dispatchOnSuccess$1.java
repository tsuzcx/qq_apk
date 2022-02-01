package com.tencent.tkd.topicsdk.publisharticle.publish;

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
  PublishManager$dispatchOnSuccess$1(PublishArticleInfo paramPublishArticleInfo, PublishStage paramPublishStage, GlobalPublisherConfig paramGlobalPublisherConfig, String paramString)
  {
    super(0);
  }
  
  public final void invoke()
  {
    this.$info.setPublishing(false);
    PublishManager.a.b(this.$info.getPublishId());
    Iterator localIterator = ((Iterable)PublishManager.c(PublishManager.a)).iterator();
    while (localIterator.hasNext()) {
      ((PublishManager.IPublishArticleListener)localIterator.next()).a(this.$stage, this.$config, this.$info, this.$serverPublishData);
    }
    localIterator = ((Iterable)PublishManager.d(PublishManager.a)).iterator();
    while (localIterator.hasNext()) {
      ((IPublishManager.IPublishListener)localIterator.next()).a(this.$info);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publish.PublishManager.dispatchOnSuccess.1
 * JD-Core Version:    0.7.0.1
 */
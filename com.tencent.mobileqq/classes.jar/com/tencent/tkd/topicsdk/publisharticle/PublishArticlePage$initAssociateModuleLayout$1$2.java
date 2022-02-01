package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.framework.TLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "topicInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initAssociateModuleLayout$1$2
  extends Lambda
  implements Function1<TopicInfo, Unit>
{
  PublishArticlePage$initAssociateModuleLayout$1$2(PublishArticlePage.initAssociateModuleLayout.1 param1)
  {
    super(1);
  }
  
  public final void invoke(@NotNull TopicInfo paramTopicInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "topicInfo");
    TLog.a("PublishArticleFragment", "select topic, topic=" + paramTopicInfo);
    PublishArticlePage.a(this.this$0.a, paramTopicInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.initAssociateModuleLayout.1.2
 * JD-Core Version:    0.7.0.1
 */
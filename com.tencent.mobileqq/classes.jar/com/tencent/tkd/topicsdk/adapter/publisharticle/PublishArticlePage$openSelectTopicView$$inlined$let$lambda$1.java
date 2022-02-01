package com.tencent.tkd.topicsdk.adapter.publisharticle;

import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.widget.dialog.SlidingUpDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "topicInfo", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "invoke", "com/tencent/tkd/topicsdk/adapter/publisharticle/PublishArticlePage$openSelectTopicView$1$1"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$openSelectTopicView$$inlined$let$lambda$1
  extends Lambda
  implements Function1<TopicInfo, Unit>
{
  PublishArticlePage$openSelectTopicView$$inlined$let$lambda$1(SlidingUpDialog paramSlidingUpDialog, long paramLong, Function1 paramFunction1)
  {
    super(1);
  }
  
  public final void invoke(@NotNull TopicInfo paramTopicInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicInfo, "topicInfo");
    this.$selectTopicCallback$inlined.invoke(paramTopicInfo);
    this.$dialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.publisharticle.PublishArticlePage.openSelectTopicView..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */
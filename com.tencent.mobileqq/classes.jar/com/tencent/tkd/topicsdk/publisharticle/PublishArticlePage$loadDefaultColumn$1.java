package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.TopicInfo;
import com.tencent.tkd.topicsdk.widget.AddToTopicLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuccess", "", "list", "", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "total", "", "<anonymous parameter 3>", "errorCode", "errorMsg", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$loadDefaultColumn$1
  extends Lambda
  implements Function6<Boolean, List<? extends TopicInfo>, Integer, Boolean, Integer, String, Unit>
{
  PublishArticlePage$loadDefaultColumn$1(PublishArticlePage paramPublishArticlePage)
  {
    super(6);
  }
  
  public final void invoke(boolean paramBoolean1, @NotNull List<TopicInfo> paramList, int paramInt1, boolean paramBoolean2, int paramInt2, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    if (paramBoolean1) {
      PublishArticlePage.a(this.this$0).setSelectedTopic((TopicInfo)paramList.get(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.loadDefaultColumn.1
 * JD-Core Version:    0.7.0.1
 */
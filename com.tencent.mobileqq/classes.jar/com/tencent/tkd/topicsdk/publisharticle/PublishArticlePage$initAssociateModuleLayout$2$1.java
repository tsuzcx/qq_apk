package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import com.tencent.tkd.topicsdk.framework.TLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "communityInfo", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePage$initAssociateModuleLayout$2$1
  extends Lambda
  implements Function1<CommunityInfo, Unit>
{
  PublishArticlePage$initAssociateModuleLayout$2$1(PublishArticlePage.initAssociateModuleLayout.2 param2)
  {
    super(1);
  }
  
  public final void invoke(@NotNull CommunityInfo paramCommunityInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramCommunityInfo, "communityInfo");
    TLog.a("PublishArticleFragment", "select community, communityInfo=" + paramCommunityInfo);
    PublishArticlePage.a(this.this$0.a, paramCommunityInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePage.initAssociateModuleLayout.2.1
 * JD-Core Version:    0.7.0.1
 */
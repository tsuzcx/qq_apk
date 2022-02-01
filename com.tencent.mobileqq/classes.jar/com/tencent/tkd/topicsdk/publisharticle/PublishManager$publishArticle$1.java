package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "errorMsg", "", "id", "serverPublishData", "invoke"}, k=3, mv={1, 1, 16})
final class PublishManager$publishArticle$1
  extends Lambda
  implements Function4<Integer, String, String, String, Unit>
{
  PublishManager$publishArticle$1(PublishArticleInfo paramPublishArticleInfo, GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    super(4);
  }
  
  public final void invoke(int paramInt, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "errorMsg");
    Intrinsics.checkParameterIsNotNull(paramString2, "id");
    Intrinsics.checkParameterIsNotNull(paramString3, "serverPublishData");
    ThreadManagerKt.a((Function0)new PublishManager.publishArticle.1.1(this, paramString2, paramInt, paramString1, paramString3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.publishArticle.1
 * JD-Core Version:    0.7.0.1
 */
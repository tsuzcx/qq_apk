package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "needBind", "", "accountInfo", "Lcom/tencent/tkd/topicsdk/publisharticle/BindAccountInfo;", "protocolUrl", "", "needRealNameConfirm", "realNameConfirmUrl", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePresenter$checkAccountBindStatus$1
  extends Lambda
  implements Function5<Boolean, BindAccountInfo, String, Boolean, String, Unit>
{
  PublishArticlePresenter$checkAccountBindStatus$1(PublishArticlePresenter paramPublishArticlePresenter)
  {
    super(5);
  }
  
  public final void invoke(boolean paramBoolean1, @NotNull BindAccountInfo paramBindAccountInfo, @NotNull String paramString1, boolean paramBoolean2, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramBindAccountInfo, "accountInfo");
    Intrinsics.checkParameterIsNotNull(paramString1, "protocolUrl");
    Intrinsics.checkParameterIsNotNull(paramString2, "realNameConfirmUrl");
    ThreadManagerKt.a((Function0)new PublishArticlePresenter.checkAccountBindStatus.1.1(this, paramBoolean1, paramBindAccountInfo, paramString1, paramBoolean2, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePresenter.checkAccountBindStatus.1
 * JD-Core Version:    0.7.0.1
 */
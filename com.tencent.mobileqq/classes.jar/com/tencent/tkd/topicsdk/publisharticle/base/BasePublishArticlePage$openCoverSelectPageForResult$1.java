package com.tencent.tkd.topicsdk.publisharticle.base;

import com.tencent.tkd.topicsdk.coverselect.CoverSelectData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/tkd/topicsdk/coverselect/CoverSelectData;", "invoke"}, k=3, mv={1, 1, 16})
final class BasePublishArticlePage$openCoverSelectPageForResult$1
  extends Lambda
  implements Function1<CoverSelectData, Unit>
{
  BasePublishArticlePage$openCoverSelectPageForResult$1(Function1 paramFunction1)
  {
    super(1);
  }
  
  public final void invoke(@NotNull CoverSelectData paramCoverSelectData)
  {
    Intrinsics.checkParameterIsNotNull(paramCoverSelectData, "it");
    this.$callback.invoke(paramCoverSelectData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.base.BasePublishArticlePage.openCoverSelectPageForResult.1
 * JD-Core Version:    0.7.0.1
 */
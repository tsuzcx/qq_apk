package com.tencent.tkd.topicsdk.mvp;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "BEAN", "COOKIE", "list", "", "invoke"}, k=3, mv={1, 1, 16})
final class ListModel$loadFirstPage$1
  extends Lambda
  implements Function1<List<? extends BEAN>, Unit>
{
  ListModel$loadFirstPage$1(ListModel paramListModel, Function6 paramFunction6)
  {
    super(1);
  }
  
  public final void invoke(@NotNull List<? extends BEAN> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    ListModel.a(this.this$0, paramList, this.$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mvp.ListModel.loadFirstPage.1
 * JD-Core Version:    0.7.0.1
 */
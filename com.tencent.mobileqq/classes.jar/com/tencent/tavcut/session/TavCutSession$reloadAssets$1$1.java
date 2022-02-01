package com.tencent.tavcut.session;

import com.tencent.tavcut.composition.dataprocessor.RenderDataManager;
import com.tencent.tavcut.composition.model.component.Timeline;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "timeLines", "", "Lcom/tencent/tavcut/composition/model/component/Timeline;", "update", "", "invoke"}, k=3, mv={1, 1, 16})
final class TavCutSession$reloadAssets$1$1
  extends Lambda
  implements Function2<List<? extends Timeline>, Boolean, Unit>
{
  TavCutSession$reloadAssets$1$1(TavCutSession.reloadAssets.1 param1)
  {
    super(2);
  }
  
  public final void invoke(@NotNull List<Timeline> paramList, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "timeLines");
    TavCutSession.b(this.this$0.this$0).a(paramList);
    TavCutSession.g(this.this$0.this$0);
    TavCutSession.a(this.this$0.this$0, paramBoolean);
    TavCutSession.c(this.this$0.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.session.TavCutSession.reloadAssets.1.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tavcut.session;

import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.BooleanRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "update", "", "invoke", "com/tencent/tavcut/session/TavCutSession$updateComponentsToLight$1$1$1", "com/tencent/tavcut/session/TavCutSession$$special$$inlined$forEach$lambda$1"}, k=3, mv={1, 1, 16})
final class TavCutSession$updateComponentsToLight$$inlined$forEach$lambda$1
  extends Lambda
  implements Function1<Boolean, Unit>
{
  TavCutSession$updateComponentsToLight$$inlined$forEach$lambda$1(Map.Entry paramEntry, TavCutSession paramTavCutSession, Ref.BooleanRef paramBooleanRef)
  {
    super(1);
  }
  
  public final void invoke(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.$updatePlayer$inlined.element = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.session.TavCutSession.updateComponentsToLight..inlined.forEach.lambda.1
 * JD-Core Version:    0.7.0.1
 */
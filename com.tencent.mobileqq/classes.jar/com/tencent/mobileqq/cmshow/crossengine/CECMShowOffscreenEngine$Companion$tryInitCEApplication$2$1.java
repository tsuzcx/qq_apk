package com.tencent.mobileqq.cmshow.crossengine;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class CECMShowOffscreenEngine$Companion$tryInitCEApplication$2$1
  extends Lambda
  implements Function0<Unit>
{
  CECMShowOffscreenEngine$Companion$tryInitCEApplication$2$1(CECMShowOffscreenEngine.Companion.tryInitCEApplication.2 param2, int paramInt)
  {
    super(0);
  }
  
  public final void invoke()
  {
    if (this.$resultCode != 0)
    {
      this.this$0.a.invoke(Boolean.valueOf(false), null);
      return;
    }
    CECMShowOffscreenEngine.Companion.a(CECMShowOffscreenEngine.a);
    this.this$0.a.invoke(Boolean.valueOf(true), CECMShowOffscreenEngine.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenEngine.Companion.tryInitCEApplication.2.1
 * JD-Core Version:    0.7.0.1
 */
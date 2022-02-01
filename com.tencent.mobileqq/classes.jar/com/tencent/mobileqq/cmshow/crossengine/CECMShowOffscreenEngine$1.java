package com.tencent.mobileqq.cmshow.crossengine;

import com.tencent.crossengine.CEApplication;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "result", "", "ceApp", "Lcom/tencent/crossengine/CEApplication;", "invoke"}, k=3, mv={1, 1, 16})
final class CECMShowOffscreenEngine$1
  extends Lambda
  implements Function2<Boolean, CEApplication, Unit>
{
  CECMShowOffscreenEngine$1(CECMShowOffscreenEngine paramCECMShowOffscreenEngine)
  {
    super(2);
  }
  
  public final void invoke(boolean paramBoolean, @Nullable CEApplication paramCEApplication)
  {
    if ((paramBoolean) && (paramCEApplication != null)) {
      CECMShowOffscreenEngine.a(this.this$0, paramCEApplication);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenEngine.1
 * JD-Core Version:    0.7.0.1
 */
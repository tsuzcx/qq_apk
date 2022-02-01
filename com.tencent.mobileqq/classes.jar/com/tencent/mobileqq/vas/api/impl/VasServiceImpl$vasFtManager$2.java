package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager;
import com.tencent.mobileqq.vas.treasurecard.api.impl.VasFTManagerImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/vas/treasurecard/api/IVasFTManager;", "invoke"}, k=3, mv={1, 1, 16})
final class VasServiceImpl$vasFtManager$2
  extends Lambda
  implements Function0<IVasFTManager>
{
  VasServiceImpl$vasFtManager$2(VasServiceImpl paramVasServiceImpl)
  {
    super(0);
  }
  
  @NotNull
  public final IVasFTManager invoke()
  {
    return (IVasFTManager)VasServiceImpl.access$dynamicCall(this.this$0, new VasFTManagerImpl());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.VasServiceImpl.vasFtManager.2
 * JD-Core Version:    0.7.0.1
 */
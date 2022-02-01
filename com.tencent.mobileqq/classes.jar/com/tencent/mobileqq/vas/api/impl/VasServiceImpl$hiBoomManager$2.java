package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.hiboom.api.impl.HiBoomManagerImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/hiboom/api/impl/HiBoomManagerImpl;", "invoke"}, k=3, mv={1, 1, 16})
final class VasServiceImpl$hiBoomManager$2
  extends Lambda
  implements Function0<HiBoomManagerImpl>
{
  VasServiceImpl$hiBoomManager$2(VasServiceImpl paramVasServiceImpl)
  {
    super(0);
  }
  
  @NotNull
  public final HiBoomManagerImpl invoke()
  {
    VasServiceImpl.access$isInMainProcess(this.this$0);
    return new HiBoomManagerImpl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.VasServiceImpl.hiBoomManager.2
 * JD-Core Version:    0.7.0.1
 */
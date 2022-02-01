package com.tencent.timi.game.initer.impl;

import com.tencent.mobileqq.vas.api.IVasTempApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class LibraryInitManager$loadPAGWithIPC$2
  extends Lambda
  implements Function0<Unit>
{
  LibraryInitManager$loadPAGWithIPC$2(IVasTempApi paramIVasTempApi)
  {
    super(0);
  }
  
  public final void invoke()
  {
    LibraryInitManager.a(LibraryInitManager.a, this.$api.initPagSo());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.initer.impl.LibraryInitManager.loadPAGWithIPC.2
 * JD-Core Version:    0.7.0.1
 */
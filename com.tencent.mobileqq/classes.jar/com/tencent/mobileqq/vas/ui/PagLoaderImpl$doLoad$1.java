package com.tencent.mobileqq.vas.ui;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class PagLoaderImpl$doLoad$1
  extends Lambda
  implements Function0<Unit>
{
  PagLoaderImpl$doLoad$1(PagLoaderImpl paramPagLoaderImpl, Function0 paramFunction0)
  {
    super(0);
  }
  
  public final void invoke()
  {
    if (!PagLoaderImpl.a(this.this$0))
    {
      Object localObject = IVasTempApi.Companion;
      localObject = QRoute.api(IVasTempApi.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IVasTempApi::class.java)");
      if (((IVasTempApi)localObject).initPagSo()) {
        this.$block.invoke();
      }
    }
    PagLoaderImpl.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.PagLoaderImpl.doLoad.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.vas.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke", "com/tencent/mobileqq/vas/ui/PagLoaderImpl$syncLoad$1$1"}, k=3, mv={1, 1, 16})
final class PagLoaderImpl$syncLoad$$inlined$synchronized$lambda$1
  extends Lambda
  implements Function0<Unit>
{
  PagLoaderImpl$syncLoad$$inlined$synchronized$lambda$1(PagLoaderImpl paramPagLoaderImpl, AbsAsyncLoadProxy.LoaderCallback paramLoaderCallback)
  {
    super(0);
  }
  
  public final void invoke()
  {
    synchronized (PagLoaderImpl.a(this.this$0))
    {
      PagLoaderImpl.a(this.this$0, true);
      PagLoaderImpl.a(this.this$0);
      Unit localUnit = Unit.INSTANCE;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.PagLoaderImpl.syncLoad..inlined.synchronized.lambda.1
 * JD-Core Version:    0.7.0.1
 */
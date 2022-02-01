package com.tencent.mobileqq.vas.ui;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/PagLoaderImpl;", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$Loader;", "()V", "isLoad", "", "isLoading", "loaderListener", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$LoaderCallback;", "Lkotlin/collections/ArrayList;", "needLoad", "doLoad", "", "block", "Lkotlin/Function0;", "isLoaded", "notifyListener", "syncLoad", "callback", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public final class PagLoaderImpl
  implements AbsAsyncLoadProxy.Loader
{
  private boolean a;
  private boolean b;
  private boolean c;
  private final ArrayList<AbsAsyncLoadProxy.LoaderCallback> d = new ArrayList();
  
  private final void b()
  {
    if (this.d.isEmpty()) {
      return;
    }
    Iterator localIterator = ((Iterable)this.d).iterator();
    while (localIterator.hasNext()) {
      ((AbsAsyncLoadProxy.LoaderCallback)localIterator.next()).a();
    }
    this.d.clear();
  }
  
  public void a(@NotNull AbsAsyncLoadProxy.LoaderCallback paramLoaderCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramLoaderCallback, "callback");
    this.c = true;
    synchronized (this.d)
    {
      if (this.a)
      {
        paramLoaderCallback.a();
        b();
        return;
      }
      this.d.add(paramLoaderCallback);
      if (!this.b)
      {
        this.b = true;
        a((Function0)new PagLoaderImpl.syncLoad..inlined.synchronized.lambda.1(this, paramLoaderCallback));
      }
      paramLoaderCallback = Unit.INSTANCE;
      return;
    }
  }
  
  public final void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    try
    {
      Object localObject = IVasTempApi.Companion;
      localObject = QRoute.api(IVasTempApi.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IVasTempApi::class.java)");
      ((IVasTempApi)localObject).requestPagDownload((Function0)new PagLoaderImpl.doLoad.1(this, paramFunction0));
      return;
    }
    catch (Throwable paramFunction0)
    {
      QLog.e(PagViewProxy.d.a(), 1, paramFunction0, new Object[0]);
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.PagLoaderImpl
 * JD-Core Version:    0.7.0.1
 */
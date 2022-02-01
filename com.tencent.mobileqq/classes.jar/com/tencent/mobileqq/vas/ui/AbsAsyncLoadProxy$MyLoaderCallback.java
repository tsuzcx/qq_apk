package com.tencent.mobileqq.vas.ui;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$MyLoaderCallback;", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy$LoaderCallback;", "drawableRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncLoadProxy;", "(Ljava/lang/ref/WeakReference;)V", "getDrawableRef", "()Ljava/lang/ref/WeakReference;", "onLoadFailed", "", "onLoadSucceed", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
final class AbsAsyncLoadProxy$MyLoaderCallback
  implements AbsAsyncLoadProxy.LoaderCallback
{
  @NotNull
  private final WeakReference<AbsAsyncLoadProxy<?>> a;
  
  public AbsAsyncLoadProxy$MyLoaderCallback(@NotNull WeakReference<AbsAsyncLoadProxy<?>> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void a()
  {
    AbsAsyncLoadProxy localAbsAsyncLoadProxy = (AbsAsyncLoadProxy)this.a.get();
    if (localAbsAsyncLoadProxy != null) {
      AbsAsyncLoadProxy.a(localAbsAsyncLoadProxy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.AbsAsyncLoadProxy.MyLoaderCallback
 * JD-Core Version:    0.7.0.1
 */
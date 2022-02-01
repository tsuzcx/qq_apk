package com.tencent.mobileqq.vas.ui;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/AbsAsyncDrawable$MyAsyncLoaderCallback;", "Lcom/tencent/mobileqq/vas/ui/ILoaderSucessCallback;", "drawableRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncDrawable;", "(Ljava/lang/ref/WeakReference;)V", "getDrawableRef", "()Ljava/lang/ref/WeakReference;", "onLoadSucceed", "", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
final class AbsAsyncDrawable$MyAsyncLoaderCallback
  implements ILoaderSucessCallback
{
  @NotNull
  private final WeakReference<AbsAsyncDrawable> a;
  
  public AbsAsyncDrawable$MyAsyncLoaderCallback(@NotNull WeakReference<AbsAsyncDrawable> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void a()
  {
    AbsAsyncDrawable localAbsAsyncDrawable = (AbsAsyncDrawable)this.a.get();
    if (localAbsAsyncDrawable != null) {
      localAbsAsyncDrawable.b((Function0)new AbsAsyncDrawable.MyAsyncLoaderCallback.onLoadSucceed.1.1(localAbsAsyncDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.AbsAsyncDrawable.MyAsyncLoaderCallback
 * JD-Core Version:    0.7.0.1
 */
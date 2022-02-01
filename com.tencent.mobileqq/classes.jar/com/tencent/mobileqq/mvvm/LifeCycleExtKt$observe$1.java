package com.tencent.mobileqq.mvvm;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "it", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V"}, k=3, mv={1, 1, 16})
final class LifeCycleExtKt$observe$1<T>
  implements Observer<T>
{
  LifeCycleExtKt$observe$1(Function1 paramFunction1) {}
  
  public final void onChanged(T paramT)
  {
    if (paramT != null) {
      this.a.invoke(paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mvvm.LifeCycleExtKt.observe.1
 * JD-Core Version:    0.7.0.1
 */
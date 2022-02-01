package com.tencent.videocut.utils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/utils/LiveDataExtKt$observeOnce$3$1", "Landroidx/lifecycle/Observer;", "onChanged", "", "t", "(Ljava/lang/Object;)V", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class LiveDataExtKt$observeOnce$3$1
  implements Observer<T>
{
  public void onChanged(T paramT)
  {
    this.a.b.onChanged(paramT);
    if (((Boolean)this.a.c.invoke(paramT)).booleanValue()) {
      this.a.a.removeObserver((Observer)this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.LiveDataExtKt.observeOnce.3.1
 * JD-Core Version:    0.7.0.1
 */
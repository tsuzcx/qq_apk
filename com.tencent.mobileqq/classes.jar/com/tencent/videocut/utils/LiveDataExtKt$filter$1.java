package com.tencent.videocut.utils;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V"}, k=3, mv={1, 4, 2})
final class LiveDataExtKt$filter$1<T>
  implements Observer<T>
{
  public final void onChanged(T paramT)
  {
    if (((Boolean)this.a.invoke(paramT)).booleanValue()) {
      this.b.setValue(paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.LiveDataExtKt.filter.1
 * JD-Core Version:    0.7.0.1
 */
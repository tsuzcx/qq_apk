package com.tencent.mobileqq.guild.util.livedata;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "it", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V"}, k=3, mv={1, 1, 16})
final class LiveDataExtKt$observeNonNull$1<T>
  implements Observer<T>
{
  public final void onChanged(T paramT)
  {
    if (paramT != null) {
      this.a.invoke(paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.livedata.LiveDataExtKt.observeNonNull.1
 * JD-Core Version:    0.7.0.1
 */
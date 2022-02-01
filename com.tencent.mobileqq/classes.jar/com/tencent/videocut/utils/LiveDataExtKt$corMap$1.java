package com.tencent.videocut.utils;

import androidx.arch.core.util.Function;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroidx/lifecycle/LiveData;", "Y", "kotlin.jvm.PlatformType", "X", "x", "apply", "(Ljava/lang/Object;)Landroidx/lifecycle/LiveData;"}, k=3, mv={1, 4, 2})
final class LiveDataExtKt$corMap$1<I, O>
  implements Function<X, LiveData<Y>>
{
  public final LiveData<Y> a(X paramX)
  {
    return CoroutineLiveDataKt.liveData$default(this.a, 0L, (Function2)new LiveDataExtKt.corMap.1.1(this, paramX, null), 2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.LiveDataExtKt.corMap.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.timi.game.initer.impl;

import com.tencent.timi.game.initer.api.OnPAGLibraryLoadedListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.util.WeakReference;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lmqq/util/WeakReference;", "Lcom/tencent/timi/game/initer/api/OnPAGLibraryLoadedListener;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class LibraryInitManager$unregisterOnPAGLibraryLoadedListener$1
  extends Lambda
  implements Function1<WeakReference<OnPAGLibraryLoadedListener>, Boolean>
{
  LibraryInitManager$unregisterOnPAGLibraryLoadedListener$1(OnPAGLibraryLoadedListener paramOnPAGLibraryLoadedListener)
  {
    super(1);
  }
  
  public final boolean invoke(WeakReference<OnPAGLibraryLoadedListener> paramWeakReference)
  {
    return Intrinsics.areEqual((OnPAGLibraryLoadedListener)paramWeakReference.get(), this.$listener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.initer.impl.LibraryInitManager.unregisterOnPAGLibraryLoadedListener.1
 * JD-Core Version:    0.7.0.1
 */
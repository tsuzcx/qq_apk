package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"lazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "lock", "", "mode", "Lkotlin/LazyThreadSafetyMode;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/LazyKt")
public class LazyKt__LazyJVMKt
{
  @NotNull
  public static final <T> Lazy<T> lazy(@Nullable Object paramObject, @NotNull Function0<? extends T> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "initializer");
    return (Lazy)new SynchronizedLazyImpl(paramFunction0, paramObject);
  }
  
  @NotNull
  public static final <T> Lazy<T> lazy(@NotNull LazyThreadSafetyMode paramLazyThreadSafetyMode, @NotNull Function0<? extends T> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramLazyThreadSafetyMode, "mode");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "initializer");
    switch (LazyKt.WhenMappings.$EnumSwitchMapping$0[paramLazyThreadSafetyMode.ordinal()])
    {
    default: 
      throw new NoWhenBranchMatchedException();
    case 1: 
      return (Lazy)new SynchronizedLazyImpl(paramFunction0, null, 2, null);
    case 2: 
      return (Lazy)new SafePublicationLazyImpl(paramFunction0);
    }
    return (Lazy)new UnsafeLazyImpl(paramFunction0);
  }
  
  @NotNull
  public static final <T> Lazy<T> lazy(@NotNull Function0<? extends T> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "initializer");
    return (Lazy)new SynchronizedLazyImpl(paramFunction0, null, 2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.LazyKt__LazyJVMKt
 * JD-Core Version:    0.7.0.1
 */
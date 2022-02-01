package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface StorageManager
{
  public abstract <T> T compute(@NotNull Function0<? extends T> paramFunction0);
  
  @NotNull
  public abstract <K, V> CacheWithNotNullValues<K, V> createCacheWithNotNullValues();
  
  @NotNull
  public abstract <T> NotNullLazyValue<T> createLazyValue(@NotNull Function0<? extends T> paramFunction0);
  
  @NotNull
  public abstract <T> NotNullLazyValue<T> createLazyValueWithPostCompute(@NotNull Function0<? extends T> paramFunction0, @Nullable Function1<? super Boolean, ? extends T> paramFunction1, @NotNull Function1<? super T, Unit> paramFunction11);
  
  @NotNull
  public abstract <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(@NotNull Function1<? super K, ? extends V> paramFunction1);
  
  @NotNull
  public abstract <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(@NotNull Function1<? super K, ? extends V> paramFunction1);
  
  @NotNull
  public abstract <T> NullableLazyValue<T> createNullableLazyValue(@NotNull Function0<? extends T> paramFunction0);
  
  @NotNull
  public abstract <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(@NotNull Function0<? extends T> paramFunction0, @NotNull T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.storage.StorageManager
 * JD-Core Version:    0.7.0.1
 */
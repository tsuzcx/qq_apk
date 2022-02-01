package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

public abstract interface CacheWithNotNullValues<K, V>
{
  @NotNull
  public abstract V computeIfAbsent(K paramK, @NotNull Function0<? extends V> paramFunction0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues
 * JD-Core Version:    0.7.0.1
 */
package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Collection;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SmartSet$Companion
{
  @JvmStatic
  @NotNull
  public final <T> SmartSet<T> create()
  {
    return new SmartSet(null);
  }
  
  @JvmStatic
  @NotNull
  public final <T> SmartSet<T> create(@NotNull Collection<? extends T> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "set");
    SmartSet localSmartSet = new SmartSet(null);
    localSmartSet.addAll(paramCollection);
    return localSmartSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion
 * JD-Core Version:    0.7.0.1
 */
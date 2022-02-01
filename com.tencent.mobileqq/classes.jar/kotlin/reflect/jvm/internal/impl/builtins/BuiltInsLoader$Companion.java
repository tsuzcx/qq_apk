package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

public final class BuiltInsLoader$Companion
{
  @NotNull
  private static final Lazy Instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0)BuiltInsLoader.Companion.Instance.2.INSTANCE);
  
  @NotNull
  public final BuiltInsLoader getInstance()
  {
    return (BuiltInsLoader)Instance$delegate.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader.Companion
 * JD-Core Version:    0.7.0.1
 */
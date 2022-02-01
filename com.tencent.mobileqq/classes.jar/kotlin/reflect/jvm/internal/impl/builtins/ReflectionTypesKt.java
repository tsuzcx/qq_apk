package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public final class ReflectionTypesKt
{
  @NotNull
  private static final FqName KOTLIN_REFLECT_FQ_NAME = new FqName("kotlin.reflect");
  @NotNull
  private static final String K_FUNCTION_PREFIX = "KFunction";
  @NotNull
  private static final String K_MUTABLE_PROPERTY_PREFIX = "KMutableProperty";
  @NotNull
  private static final String K_PROPERTY_PREFIX = "KProperty";
  @NotNull
  private static final String K_SUSPEND_FUNCTION_PREFIX = "KSuspendFunction";
  @NotNull
  private static final List<String> PREFIXES = CollectionsKt.listOf(new String[] { K_PROPERTY_PREFIX, K_MUTABLE_PROPERTY_PREFIX, K_FUNCTION_PREFIX, K_SUSPEND_FUNCTION_PREFIX });
  
  static
  {
    K_MUTABLE_PROPERTY_PREFIX = "KMutableProperty";
  }
  
  @NotNull
  public static final FqName getKOTLIN_REFLECT_FQ_NAME()
  {
    return KOTLIN_REFLECT_FQ_NAME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypesKt
 * JD-Core Version:    0.7.0.1
 */
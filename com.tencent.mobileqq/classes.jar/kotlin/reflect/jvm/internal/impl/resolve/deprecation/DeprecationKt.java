package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey;
import org.jetbrains.annotations.NotNull;

public final class DeprecationKt
{
  @NotNull
  private static final CallableDescriptor.UserDataKey<Object> DEPRECATED_FUNCTION_KEY = (CallableDescriptor.UserDataKey)new DeprecationKt.DEPRECATED_FUNCTION_KEY.1();
  
  @NotNull
  public static final CallableDescriptor.UserDataKey<Object> getDEPRECATED_FUNCTION_KEY()
  {
    return DEPRECATED_FUNCTION_KEY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.deprecation.DeprecationKt
 * JD-Core Version:    0.7.0.1
 */
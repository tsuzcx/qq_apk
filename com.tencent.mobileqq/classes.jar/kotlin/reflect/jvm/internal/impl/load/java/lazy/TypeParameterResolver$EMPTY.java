package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeParameterResolver$EMPTY
  implements TypeParameterResolver
{
  public static final EMPTY INSTANCE = new EMPTY();
  
  @Nullable
  public TypeParameterDescriptor resolveTypeParameter(@NotNull JavaTypeParameter paramJavaTypeParameter)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaTypeParameter, "javaTypeParameter");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver.EMPTY
 * JD-Core Version:    0.7.0.1
 */
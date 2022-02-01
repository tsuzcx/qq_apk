package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ReflectJavaType
  implements JavaType
{
  public static final ReflectJavaType.Factory Factory = new ReflectJavaType.Factory(null);
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof ReflectJavaType)) && (Intrinsics.areEqual(getReflectType(), ((ReflectJavaType)paramObject).getReflectType()));
  }
  
  @NotNull
  protected abstract Type getReflectType();
  
  public int hashCode()
  {
    return getReflectType().hashCode();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(": ");
    localStringBuilder.append(getReflectType());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
 * JD-Core Version:    0.7.0.1
 */
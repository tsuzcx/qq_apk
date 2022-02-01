package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ConstantValue<T>
{
  private final T value;
  
  public ConstantValue(T paramT)
  {
    this.value = paramT;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((ConstantValue)this != paramObject)
    {
      Object localObject2 = getValue();
      boolean bool = paramObject instanceof ConstantValue;
      Object localObject1 = null;
      if (!bool) {
        paramObject = null;
      }
      ConstantValue localConstantValue = (ConstantValue)paramObject;
      paramObject = localObject1;
      if (localConstantValue != null) {
        paramObject = localConstantValue.getValue();
      }
      if (!Intrinsics.areEqual(localObject2, paramObject)) {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public abstract KotlinType getType(@NotNull ModuleDescriptor paramModuleDescriptor);
  
  public T getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    Object localObject = getValue();
    if (localObject != null) {
      return localObject.hashCode();
    }
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    return String.valueOf(getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
 * JD-Core Version:    0.7.0.1
 */
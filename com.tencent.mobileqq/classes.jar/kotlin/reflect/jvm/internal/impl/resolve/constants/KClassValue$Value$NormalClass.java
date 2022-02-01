package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KClassValue$Value$NormalClass
  extends KClassValue.Value
{
  @NotNull
  private final ClassLiteralValue value;
  
  public KClassValue$Value$NormalClass(@NotNull ClassLiteralValue paramClassLiteralValue)
  {
    super(null);
    this.value = paramClassLiteralValue;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof NormalClass))
      {
        paramObject = (NormalClass)paramObject;
        if (Intrinsics.areEqual(this.value, paramObject.value)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getArrayDimensions()
  {
    return this.value.getArrayNestedness();
  }
  
  @NotNull
  public final ClassId getClassId()
  {
    return this.value.getClassId();
  }
  
  @NotNull
  public final ClassLiteralValue getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    ClassLiteralValue localClassLiteralValue = this.value;
    if (localClassLiteralValue != null) {
      return localClassLiteralValue.hashCode();
    }
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NormalClass(value=");
    localStringBuilder.append(this.value);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.NormalClass
 * JD-Core Version:    0.7.0.1
 */
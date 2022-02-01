package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KClassValue$Value$LocalClass
  extends KClassValue.Value
{
  @NotNull
  private final KotlinType type;
  
  public KClassValue$Value$LocalClass(@NotNull KotlinType paramKotlinType)
  {
    super(null);
    this.type = paramKotlinType;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LocalClass))
      {
        paramObject = (LocalClass)paramObject;
        if (Intrinsics.areEqual(this.type, paramObject.type)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final KotlinType getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    KotlinType localKotlinType = this.type;
    if (localKotlinType != null) {
      return localKotlinType.hashCode();
    }
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocalClass(type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.LocalClass
 * JD-Core Version:    0.7.0.1
 */
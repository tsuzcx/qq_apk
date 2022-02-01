package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class TypeAndDefaultQualifiers
{
  @Nullable
  private final JavaTypeQualifiers defaultQualifiers;
  @NotNull
  private final KotlinType type;
  
  public TypeAndDefaultQualifiers(@NotNull KotlinType paramKotlinType, @Nullable JavaTypeQualifiers paramJavaTypeQualifiers)
  {
    this.type = paramKotlinType;
    this.defaultQualifiers = paramJavaTypeQualifiers;
  }
  
  @NotNull
  public final KotlinType component1()
  {
    return this.type;
  }
  
  @Nullable
  public final JavaTypeQualifiers component2()
  {
    return this.defaultQualifiers;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TypeAndDefaultQualifiers))
      {
        paramObject = (TypeAndDefaultQualifiers)paramObject;
        if ((Intrinsics.areEqual(this.type, paramObject.type)) && (Intrinsics.areEqual(this.defaultQualifiers, paramObject.defaultQualifiers))) {}
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
    Object localObject = this.type;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.defaultQualifiers;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TypeAndDefaultQualifiers(type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", defaultQualifiers=");
    localStringBuilder.append(this.defaultQualifiers);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeAndDefaultQualifiers
 * JD-Core Version:    0.7.0.1
 */
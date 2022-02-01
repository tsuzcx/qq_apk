package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaToKotlinClassMap$PlatformMutabilityMapping
{
  @NotNull
  private final ClassId javaClass;
  @NotNull
  private final ClassId kotlinMutable;
  @NotNull
  private final ClassId kotlinReadOnly;
  
  public JavaToKotlinClassMap$PlatformMutabilityMapping(@NotNull ClassId paramClassId1, @NotNull ClassId paramClassId2, @NotNull ClassId paramClassId3)
  {
    this.javaClass = paramClassId1;
    this.kotlinReadOnly = paramClassId2;
    this.kotlinMutable = paramClassId3;
  }
  
  @NotNull
  public final ClassId component1()
  {
    return this.javaClass;
  }
  
  @NotNull
  public final ClassId component2()
  {
    return this.kotlinReadOnly;
  }
  
  @NotNull
  public final ClassId component3()
  {
    return this.kotlinMutable;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof PlatformMutabilityMapping))
      {
        paramObject = (PlatformMutabilityMapping)paramObject;
        if ((Intrinsics.areEqual(this.javaClass, paramObject.javaClass)) && (Intrinsics.areEqual(this.kotlinReadOnly, paramObject.kotlinReadOnly)) && (Intrinsics.areEqual(this.kotlinMutable, paramObject.kotlinMutable))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final ClassId getJavaClass()
  {
    return this.javaClass;
  }
  
  public int hashCode()
  {
    ClassId localClassId = this.javaClass;
    int k = 0;
    int i;
    if (localClassId != null) {
      i = localClassId.hashCode();
    } else {
      i = 0;
    }
    localClassId = this.kotlinReadOnly;
    int j;
    if (localClassId != null) {
      j = localClassId.hashCode();
    } else {
      j = 0;
    }
    localClassId = this.kotlinMutable;
    if (localClassId != null) {
      k = localClassId.hashCode();
    }
    return (i * 31 + j) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlatformMutabilityMapping(javaClass=");
    localStringBuilder.append(this.javaClass);
    localStringBuilder.append(", kotlinReadOnly=");
    localStringBuilder.append(this.kotlinReadOnly);
    localStringBuilder.append(", kotlinMutable=");
    localStringBuilder.append(this.kotlinMutable);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping
 * JD-Core Version:    0.7.0.1
 */
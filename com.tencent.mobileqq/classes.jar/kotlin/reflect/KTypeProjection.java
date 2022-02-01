package kotlin.reflect;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KTypeProjection;", "", "variance", "Lkotlin/reflect/KVariance;", "type", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "getType", "()Lkotlin/reflect/KType;", "getVariance", "()Lkotlin/reflect/KVariance;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public final class KTypeProjection
{
  public static final KTypeProjection.Companion Companion = new KTypeProjection.Companion(null);
  @NotNull
  private static final KTypeProjection STAR = new KTypeProjection(null, null);
  @Nullable
  private final KType type;
  @Nullable
  private final KVariance variance;
  
  public KTypeProjection(@Nullable KVariance paramKVariance, @Nullable KType paramKType)
  {
    this.variance = paramKVariance;
    this.type = paramKType;
  }
  
  @Nullable
  public final KVariance component1()
  {
    return this.variance;
  }
  
  @Nullable
  public final KType component2()
  {
    return this.type;
  }
  
  @NotNull
  public final KTypeProjection copy(@Nullable KVariance paramKVariance, @Nullable KType paramKType)
  {
    return new KTypeProjection(paramKVariance, paramKType);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof KTypeProjection))
      {
        paramObject = (KTypeProjection)paramObject;
        if ((Intrinsics.areEqual(this.variance, paramObject.variance)) && (Intrinsics.areEqual(this.type, paramObject.type))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @Nullable
  public final KType getType()
  {
    return this.type;
  }
  
  @Nullable
  public final KVariance getVariance()
  {
    return this.variance;
  }
  
  public int hashCode()
  {
    Object localObject = this.variance;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.type;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KTypeProjection(variance=");
    localStringBuilder.append(this.variance);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.reflect.KTypeProjection
 * JD-Core Version:    0.7.0.1
 */
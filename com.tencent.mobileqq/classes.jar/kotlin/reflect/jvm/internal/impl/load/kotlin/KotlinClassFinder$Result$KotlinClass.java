package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KotlinClassFinder$Result$KotlinClass
  extends KotlinClassFinder.Result
{
  @NotNull
  private final KotlinJvmBinaryClass kotlinJvmBinaryClass;
  
  public KotlinClassFinder$Result$KotlinClass(@NotNull KotlinJvmBinaryClass paramKotlinJvmBinaryClass)
  {
    super(null);
    this.kotlinJvmBinaryClass = paramKotlinJvmBinaryClass;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof KotlinClass))
      {
        paramObject = (KotlinClass)paramObject;
        if (Intrinsics.areEqual(this.kotlinJvmBinaryClass, paramObject.kotlinJvmBinaryClass)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final KotlinJvmBinaryClass getKotlinJvmBinaryClass()
  {
    return this.kotlinJvmBinaryClass;
  }
  
  public int hashCode()
  {
    KotlinJvmBinaryClass localKotlinJvmBinaryClass = this.kotlinJvmBinaryClass;
    if (localKotlinJvmBinaryClass != null) {
      return localKotlinJvmBinaryClass.hashCode();
    }
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KotlinClass(kotlinJvmBinaryClass=");
    localStringBuilder.append(this.kotlinJvmBinaryClass);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder.Result.KotlinClass
 * JD-Core Version:    0.7.0.1
 */
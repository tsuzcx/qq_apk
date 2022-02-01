package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class EnhancementResult<T>
{
  @Nullable
  private final Annotations enhancementAnnotations;
  private final T result;
  
  public EnhancementResult(T paramT, @Nullable Annotations paramAnnotations)
  {
    this.result = paramT;
    this.enhancementAnnotations = paramAnnotations;
  }
  
  public final T component1()
  {
    return this.result;
  }
  
  @Nullable
  public final Annotations component2()
  {
    return this.enhancementAnnotations;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof EnhancementResult))
      {
        paramObject = (EnhancementResult)paramObject;
        if ((Intrinsics.areEqual(this.result, paramObject.result)) && (Intrinsics.areEqual(this.enhancementAnnotations, paramObject.enhancementAnnotations))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Object localObject = this.result;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.enhancementAnnotations;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EnhancementResult(result=");
    localStringBuilder.append(this.result);
    localStringBuilder.append(", enhancementAnnotations=");
    localStringBuilder.append(this.enhancementAnnotations);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.EnhancementResult
 * JD-Core Version:    0.7.0.1
 */
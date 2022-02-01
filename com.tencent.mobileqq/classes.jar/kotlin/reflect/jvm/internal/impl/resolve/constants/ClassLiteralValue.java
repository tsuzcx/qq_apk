package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ClassLiteralValue
{
  private final int arrayNestedness;
  @NotNull
  private final ClassId classId;
  
  public ClassLiteralValue(@NotNull ClassId paramClassId, int paramInt)
  {
    this.classId = paramClassId;
    this.arrayNestedness = paramInt;
  }
  
  @NotNull
  public final ClassId component1()
  {
    return this.classId;
  }
  
  public final int component2()
  {
    return this.arrayNestedness;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ClassLiteralValue))
      {
        paramObject = (ClassLiteralValue)paramObject;
        if ((Intrinsics.areEqual(this.classId, paramObject.classId)) && (this.arrayNestedness == paramObject.arrayNestedness)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getArrayNestedness()
  {
    return this.arrayNestedness;
  }
  
  @NotNull
  public final ClassId getClassId()
  {
    return this.classId;
  }
  
  public int hashCode()
  {
    ClassId localClassId = this.classId;
    int i;
    if (localClassId != null) {
      i = localClassId.hashCode();
    } else {
      i = 0;
    }
    return i * 31 + this.arrayNestedness;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject = new StringBuilder();
    int k = this.arrayNestedness;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      ((StringBuilder)localObject).append("kotlin/Array<");
      i += 1;
    }
    ((StringBuilder)localObject).append(this.classId);
    k = this.arrayNestedness;
    i = j;
    while (i < k)
    {
      ((StringBuilder)localObject).append(">");
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "StringBuilder().apply(builderAction).toString()");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue
 * JD-Core Version:    0.7.0.1
 */
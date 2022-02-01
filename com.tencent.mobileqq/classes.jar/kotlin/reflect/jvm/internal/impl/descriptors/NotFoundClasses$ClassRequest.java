package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class NotFoundClasses$ClassRequest
{
  @NotNull
  private final ClassId classId;
  @NotNull
  private final List<Integer> typeParametersCount;
  
  public NotFoundClasses$ClassRequest(@NotNull ClassId paramClassId, @NotNull List<Integer> paramList)
  {
    this.classId = paramClassId;
    this.typeParametersCount = paramList;
  }
  
  @NotNull
  public final ClassId component1()
  {
    return this.classId;
  }
  
  @NotNull
  public final List<Integer> component2()
  {
    return this.typeParametersCount;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ClassRequest))
      {
        paramObject = (ClassRequest)paramObject;
        if ((Intrinsics.areEqual(this.classId, paramObject.classId)) && (Intrinsics.areEqual(this.typeParametersCount, paramObject.typeParametersCount))) {}
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
    Object localObject = this.classId;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.typeParametersCount;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ClassRequest(classId=");
    localStringBuilder.append(this.classId);
    localStringBuilder.append(", typeParametersCount=");
    localStringBuilder.append(this.typeParametersCount);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.ClassRequest
 * JD-Core Version:    0.7.0.1
 */
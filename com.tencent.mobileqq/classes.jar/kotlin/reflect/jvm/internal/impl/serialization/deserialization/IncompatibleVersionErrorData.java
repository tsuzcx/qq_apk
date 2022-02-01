package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IncompatibleVersionErrorData<T extends BinaryVersion>
{
  @NotNull
  private final T actualVersion;
  @NotNull
  private final ClassId classId;
  @NotNull
  private final T expectedVersion;
  @NotNull
  private final String filePath;
  
  public IncompatibleVersionErrorData(@NotNull T paramT1, @NotNull T paramT2, @NotNull String paramString, @NotNull ClassId paramClassId)
  {
    this.actualVersion = paramT1;
    this.expectedVersion = paramT2;
    this.filePath = paramString;
    this.classId = paramClassId;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof IncompatibleVersionErrorData))
      {
        paramObject = (IncompatibleVersionErrorData)paramObject;
        if ((Intrinsics.areEqual(this.actualVersion, paramObject.actualVersion)) && (Intrinsics.areEqual(this.expectedVersion, paramObject.expectedVersion)) && (Intrinsics.areEqual(this.filePath, paramObject.filePath)) && (Intrinsics.areEqual(this.classId, paramObject.classId))) {}
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
    Object localObject = this.actualVersion;
    int m = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.expectedVersion;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.filePath;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.classId;
    if (localObject != null) {
      m = localObject.hashCode();
    }
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IncompatibleVersionErrorData(actualVersion=");
    localStringBuilder.append(this.actualVersion);
    localStringBuilder.append(", expectedVersion=");
    localStringBuilder.append(this.expectedVersion);
    localStringBuilder.append(", filePath=");
    localStringBuilder.append(this.filePath);
    localStringBuilder.append(", classId=");
    localStringBuilder.append(this.classId);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData
 * JD-Core Version:    0.7.0.1
 */
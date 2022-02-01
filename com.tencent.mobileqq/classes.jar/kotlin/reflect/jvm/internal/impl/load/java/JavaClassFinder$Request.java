package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaClassFinder$Request
{
  @NotNull
  private final ClassId classId;
  @Nullable
  private final JavaClass outerClass;
  @Nullable
  private final byte[] previouslyFoundClassFileContent;
  
  public JavaClassFinder$Request(@NotNull ClassId paramClassId, @Nullable byte[] paramArrayOfByte, @Nullable JavaClass paramJavaClass)
  {
    this.classId = paramClassId;
    this.previouslyFoundClassFileContent = paramArrayOfByte;
    this.outerClass = paramJavaClass;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Request))
      {
        paramObject = (Request)paramObject;
        if ((Intrinsics.areEqual(this.classId, paramObject.classId)) && (Intrinsics.areEqual(this.previouslyFoundClassFileContent, paramObject.previouslyFoundClassFileContent)) && (Intrinsics.areEqual(this.outerClass, paramObject.outerClass))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final ClassId getClassId()
  {
    return this.classId;
  }
  
  public int hashCode()
  {
    Object localObject = this.classId;
    int k = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.previouslyFoundClassFileContent;
    int j;
    if (localObject != null) {
      j = Arrays.hashCode((byte[])localObject);
    } else {
      j = 0;
    }
    localObject = this.outerClass;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return (i * 31 + j) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request(classId=");
    localStringBuilder.append(this.classId);
    localStringBuilder.append(", previouslyFoundClassFileContent=");
    localStringBuilder.append(Arrays.toString(this.previouslyFoundClassFileContent));
    localStringBuilder.append(", outerClass=");
    localStringBuilder.append(this.outerClass);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder.Request
 * JD-Core Version:    0.7.0.1
 */
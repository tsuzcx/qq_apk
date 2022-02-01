package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class ClassDeserializer$ClassKey
{
  @Nullable
  private final ClassData classData;
  @NotNull
  private final ClassId classId;
  
  public ClassDeserializer$ClassKey(@NotNull ClassId paramClassId, @Nullable ClassData paramClassData)
  {
    this.classId = paramClassId;
    this.classData = paramClassData;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof ClassKey)) && (Intrinsics.areEqual(this.classId, ((ClassKey)paramObject).classId));
  }
  
  @Nullable
  public final ClassData getClassData()
  {
    return this.classData;
  }
  
  @NotNull
  public final ClassId getClassId()
  {
    return this.classId;
  }
  
  public int hashCode()
  {
    return this.classId.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.ClassKey
 * JD-Core Version:    0.7.0.1
 */
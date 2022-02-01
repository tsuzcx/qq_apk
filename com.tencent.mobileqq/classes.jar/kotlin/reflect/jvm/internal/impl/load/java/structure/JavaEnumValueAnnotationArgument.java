package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.Nullable;

public abstract interface JavaEnumValueAnnotationArgument
  extends JavaAnnotationArgument
{
  @Nullable
  public abstract Name getEntryName();
  
  @Nullable
  public abstract ClassId getEnumClassId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument
 * JD-Core Version:    0.7.0.1
 */
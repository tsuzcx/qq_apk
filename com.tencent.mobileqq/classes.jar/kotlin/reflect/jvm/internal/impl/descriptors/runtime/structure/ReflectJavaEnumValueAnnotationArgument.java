package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaEnumValueAnnotationArgument
  extends ReflectJavaAnnotationArgument
  implements JavaEnumValueAnnotationArgument
{
  private final Enum<?> value;
  
  public ReflectJavaEnumValueAnnotationArgument(@Nullable Name paramName, @NotNull Enum<?> paramEnum)
  {
    super(paramName);
    this.value = paramEnum;
  }
  
  @Nullable
  public Name getEntryName()
  {
    return Name.identifier(this.value.name());
  }
  
  @Nullable
  public ClassId getEnumClassId()
  {
    Class localClass = this.value.getClass();
    if (!localClass.isEnum()) {
      localClass = localClass.getEnclosingClass();
    }
    Intrinsics.checkExpressionValueIsNotNull(localClass, "enumClass");
    return ReflectClassUtilKt.getClassId(localClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaEnumValueAnnotationArgument
 * JD-Core Version:    0.7.0.1
 */
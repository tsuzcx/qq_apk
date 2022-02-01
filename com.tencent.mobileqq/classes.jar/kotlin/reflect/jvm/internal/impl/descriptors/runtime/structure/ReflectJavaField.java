package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import org.jetbrains.annotations.NotNull;

public final class ReflectJavaField
  extends ReflectJavaMember
  implements JavaField
{
  @NotNull
  private final Field member;
  
  public ReflectJavaField(@NotNull Field paramField)
  {
    this.member = paramField;
  }
  
  public boolean getHasConstantNotNullInitializer()
  {
    return false;
  }
  
  @NotNull
  public Field getMember()
  {
    return this.member;
  }
  
  @NotNull
  public ReflectJavaType getType()
  {
    ReflectJavaType.Factory localFactory = ReflectJavaType.Factory;
    Type localType = getMember().getGenericType();
    Intrinsics.checkExpressionValueIsNotNull(localType, "member.genericType");
    return localFactory.create(localType);
  }
  
  public boolean isEnumEntry()
  {
    return getMember().isEnumConstant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField
 * JD-Core Version:    0.7.0.1
 */
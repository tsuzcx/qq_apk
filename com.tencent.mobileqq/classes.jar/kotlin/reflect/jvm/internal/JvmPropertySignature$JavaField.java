package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/JvmPropertySignature$JavaField;", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "getField", "()Ljava/lang/reflect/Field;", "asString", "", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class JvmPropertySignature$JavaField
  extends JvmPropertySignature
{
  @NotNull
  private final Field field;
  
  public JvmPropertySignature$JavaField(@NotNull Field paramField)
  {
    super(null);
    this.field = paramField;
  }
  
  @NotNull
  public String asString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(JvmAbi.getterName(this.field.getName()));
    localStringBuilder.append("()");
    Class localClass = this.field.getType();
    Intrinsics.checkExpressionValueIsNotNull(localClass, "field.type");
    localStringBuilder.append(ReflectClassUtilKt.getDesc(localClass));
    return localStringBuilder.toString();
  }
  
  @NotNull
  public final Field getField()
  {
    return this.field;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.JvmPropertySignature.JavaField
 * JD-Core Version:    0.7.0.1
 */
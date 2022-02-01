package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Field;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/lang/reflect/Field;", "R", "invoke"}, k=3, mv={1, 1, 16})
final class KPropertyImpl$_javaField$1
  extends Lambda
  implements Function0<Field>
{
  KPropertyImpl$_javaField$1(KPropertyImpl paramKPropertyImpl)
  {
    super(0);
  }
  
  @Nullable
  public final Field invoke()
  {
    Object localObject = RuntimeTypeMapper.INSTANCE.mapPropertySignature(this.this$0.getDescriptor());
    JvmMemberSignature.Field localField;
    if ((localObject instanceof JvmPropertySignature.KotlinProperty))
    {
      localObject = (JvmPropertySignature.KotlinProperty)localObject;
      PropertyDescriptor localPropertyDescriptor = ((JvmPropertySignature.KotlinProperty)localObject).getDescriptor();
      localField = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.INSTANCE, ((JvmPropertySignature.KotlinProperty)localObject).getProto(), ((JvmPropertySignature.KotlinProperty)localObject).getNameResolver(), ((JvmPropertySignature.KotlinProperty)localObject).getTypeTable(), false, 8, null);
      if (localField == null) {
        break label177;
      }
      if ((!JvmAbi.isPropertyWithBackingFieldInOuterClass(localPropertyDescriptor)) && (!JvmProtoBufUtil.isMovedFromInterfaceCompanion(((JvmPropertySignature.KotlinProperty)localObject).getProto())))
      {
        localObject = localPropertyDescriptor.getContainingDeclaration();
        if ((localObject instanceof ClassDescriptor)) {
          localObject = UtilKt.toJavaClass((ClassDescriptor)localObject);
        } else {
          localObject = this.this$0.getContainer().getJClass();
        }
      }
      else
      {
        localObject = this.this$0.getContainer().getJClass().getEnclosingClass();
      }
      if (localObject == null) {
        break label177;
      }
    }
    try
    {
      localObject = ((Class)localObject).getDeclaredField(localField.getName());
      return localObject;
    }
    catch (NoSuchFieldException localNoSuchFieldException) {}
    if ((localObject instanceof JvmPropertySignature.JavaField)) {
      return ((JvmPropertySignature.JavaField)localObject).getField();
    }
    if ((localObject instanceof JvmPropertySignature.JavaMethodProperty)) {
      return null;
    }
    if ((localObject instanceof JvmPropertySignature.MappedKotlinProperty)) {
      label177:
      return null;
    }
    throw new NoWhenBranchMatchedException();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KPropertyImpl._javaField.1
 * JD-Core Version:    0.7.0.1
 */
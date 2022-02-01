package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

final class JavaTypeResolverKt$getErasedUpperBound$1
  extends Lambda
  implements Function0<SimpleType>
{
  JavaTypeResolverKt$getErasedUpperBound$1(TypeParameterDescriptor paramTypeParameterDescriptor)
  {
    super(0);
  }
  
  @NotNull
  public final SimpleType invoke()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Can't compute erased upper bound of type parameter `");
    ((StringBuilder)localObject).append(this.$this_getErasedUpperBound);
    ((StringBuilder)localObject).append('`');
    localObject = ErrorUtils.createErrorType(((StringBuilder)localObject).toString());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ErrorUtils.createErrorTy… type parameter `$this`\")");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt.getErasedUpperBound.1
 * JD-Core Version:    0.7.0.1
 */
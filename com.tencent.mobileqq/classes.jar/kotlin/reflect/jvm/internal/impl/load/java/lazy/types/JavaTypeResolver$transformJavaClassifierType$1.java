package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

final class JavaTypeResolver$transformJavaClassifierType$1
  extends Lambda
  implements Function0<SimpleType>
{
  JavaTypeResolver$transformJavaClassifierType$1(JavaClassifierType paramJavaClassifierType)
  {
    super(0);
  }
  
  @NotNull
  public final SimpleType invoke()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unresolved java class ");
    ((StringBuilder)localObject).append(this.$javaType.getPresentableText());
    localObject = ErrorUtils.createErrorType(((StringBuilder)localObject).toString());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ErrorUtils.createErrorTy…vaType.presentableText}\")");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver.transformJavaClassifierType.1
 * JD-Core Version:    0.7.0.1
 */
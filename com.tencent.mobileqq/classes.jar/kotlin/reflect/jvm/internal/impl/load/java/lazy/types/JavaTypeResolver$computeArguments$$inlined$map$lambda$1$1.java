package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

final class JavaTypeResolver$computeArguments$$inlined$map$lambda$1$1
  extends Lambda
  implements Function0<KotlinType>
{
  JavaTypeResolver$computeArguments$$inlined$map$lambda$1$1(JavaTypeResolver.computeArguments..inlined.map.lambda.1 param1)
  {
    super(0);
  }
  
  @NotNull
  public final KotlinType invoke()
  {
    Object localObject = this.this$0.$constructor$inlined.getDeclarationDescriptor();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject, "constructor.declarationDescriptor!!");
    localObject = ((ClassifierDescriptor)localObject).getDefaultType();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "constructor.declarationDescriptor!!.defaultType");
    return TypeUtilsKt.replaceArgumentsWithStarProjections((KotlinType)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver.computeArguments..inlined.map.lambda.1.1
 * JD-Core Version:    0.7.0.1
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;

final class JavaTypeResolver$computeArguments$$inlined$map$lambda$1
  extends Lambda
  implements Function0<KotlinType>
{
  JavaTypeResolver$computeArguments$$inlined$map$lambda$1(TypeParameterDescriptor paramTypeParameterDescriptor, JavaTypeResolver paramJavaTypeResolver, JavaTypeAttributes paramJavaTypeAttributes, TypeConstructor paramTypeConstructor, boolean paramBoolean)
  {
    super(0);
  }
  
  @NotNull
  public final KotlinType invoke()
  {
    TypeParameterDescriptor localTypeParameterDescriptor = this.$parameter;
    Intrinsics.checkExpressionValueIsNotNull(localTypeParameterDescriptor, "parameter");
    return JavaTypeResolverKt.getErasedUpperBound(localTypeParameterDescriptor, this.$attr$inlined.getUpperBoundOfTypeParameter(), (Function0)new JavaTypeResolver.computeArguments..inlined.map.lambda.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver.computeArguments..inlined.map.lambda.1
 * JD-Core Version:    0.7.0.1
 */
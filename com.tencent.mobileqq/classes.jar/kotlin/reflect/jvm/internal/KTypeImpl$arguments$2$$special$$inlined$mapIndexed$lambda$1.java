package kotlin.reflect.jvm.internal;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/lang/reflect/Type;", "invoke", "kotlin/reflect/jvm/internal/KTypeImpl$arguments$2$1$type$1"}, k=3, mv={1, 1, 16})
final class KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1
  extends Lambda
  implements Function0<Type>
{
  KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1(int paramInt, KTypeImpl.arguments.2 param2, Lazy paramLazy, KProperty paramKProperty)
  {
    super(0);
  }
  
  @NotNull
  public final Type invoke()
  {
    Object localObject1 = this.this$0.this$0.getJavaType$kotlin_reflection();
    if ((localObject1 instanceof Class))
    {
      localObject1 = (Class)localObject1;
      if (((Class)localObject1).isArray()) {
        localObject1 = ((Class)localObject1).getComponentType();
      } else {
        localObject1 = Object.class;
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "if (javaType.isArray) ja…Type else Any::class.java");
      return (Type)localObject1;
    }
    if ((localObject1 instanceof GenericArrayType))
    {
      if (this.$i == 0)
      {
        localObject1 = ((GenericArrayType)localObject1).getGenericComponentType();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "javaType.genericComponentType");
        return localObject1;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Array type has been queried for a non-0th argument: ");
      ((StringBuilder)localObject1).append(this.this$0.this$0);
      throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject1).toString()));
    }
    if ((localObject1 instanceof ParameterizedType))
    {
      localObject1 = this.$parameterizedTypeArguments$inlined;
      Object localObject2 = this.$parameterizedTypeArguments$metadata$inlined;
      localObject1 = (Type)((List)((Lazy)localObject1).getValue()).get(this.$i);
      if ((localObject1 instanceof WildcardType))
      {
        localObject2 = (WildcardType)localObject1;
        localObject1 = ((WildcardType)localObject2).getLowerBounds();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "argument.lowerBounds");
        localObject1 = (Type)ArraysKt.firstOrNull((Object[])localObject1);
        if (localObject1 == null)
        {
          localObject1 = ((WildcardType)localObject2).getUpperBounds();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "argument.upperBounds");
          localObject1 = (Type)ArraysKt.first((Object[])localObject1);
        }
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "if (argument !is Wildcar…ument.upperBounds.first()");
      return localObject1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Non-generic type has been queried for arguments: ");
    ((StringBuilder)localObject1).append(this.this$0.this$0);
    throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject1).toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KTypeImpl.arguments.2..special..inlined.mapIndexed.lambda.1
 * JD-Core Version:    0.7.0.1
 */
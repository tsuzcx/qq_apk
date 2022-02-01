package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/lang/reflect/Type;", "T", "", "invoke", "kotlin/reflect/jvm/internal/KClassImpl$Data$supertypes$2$1$1"}, k=3, mv={1, 1, 16})
final class KClassImpl$Data$supertypes$2$$special$$inlined$mapTo$lambda$1
  extends Lambda
  implements Function0<Type>
{
  KClassImpl$Data$supertypes$2$$special$$inlined$mapTo$lambda$1(KotlinType paramKotlinType, KClassImpl.Data.supertypes.2 param2)
  {
    super(0);
  }
  
  @NotNull
  public final Type invoke()
  {
    Object localObject1 = this.$kotlinType.getConstructor().getDeclarationDescriptor();
    if ((localObject1 instanceof ClassDescriptor))
    {
      localObject2 = UtilKt.toJavaClass((ClassDescriptor)localObject1);
      if (localObject2 != null)
      {
        if (Intrinsics.areEqual(this.this$0.this$0.this$0.getJClass().getSuperclass(), localObject2))
        {
          localObject1 = this.this$0.this$0.this$0.getJClass().getGenericSuperclass();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "jClass.genericSuperclass");
          return localObject1;
        }
        Class[] arrayOfClass = this.this$0.this$0.this$0.getJClass().getInterfaces();
        Intrinsics.checkExpressionValueIsNotNull(arrayOfClass, "jClass.interfaces");
        int i = ArraysKt.indexOf(arrayOfClass, localObject2);
        if (i >= 0)
        {
          localObject1 = this.this$0.this$0.this$0.getJClass().getGenericInterfaces()[i];
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "jClass.genericInterfaces[index]");
          return localObject1;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("No superclass of ");
        ((StringBuilder)localObject2).append(this.this$0.this$0);
        ((StringBuilder)localObject2).append(" in Java reflection for ");
        ((StringBuilder)localObject2).append(localObject1);
        throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject2).toString()));
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Unsupported superclass of ");
      ((StringBuilder)localObject2).append(this.this$0.this$0);
      ((StringBuilder)localObject2).append(": ");
      ((StringBuilder)localObject2).append(localObject1);
      throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject2).toString()));
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Supertype not a class: ");
    ((StringBuilder)localObject2).append(localObject1);
    throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject2).toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KClassImpl.Data.supertypes.2..special..inlined.mapTo.lambda.1
 * JD-Core Version:    0.7.0.1
 */
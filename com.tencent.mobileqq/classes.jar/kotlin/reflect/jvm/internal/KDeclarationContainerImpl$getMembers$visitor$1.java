package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/reflect/jvm/internal/KDeclarationContainerImpl$getMembers$visitor$1", "Lkotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorVisitorEmptyBodies;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "visitConstructorDescriptor", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "data", "(Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "visitFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "visitPropertyDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class KDeclarationContainerImpl$getMembers$visitor$1
  extends DeclarationDescriptorVisitorEmptyBodies<KCallableImpl<?>, Unit>
{
  @NotNull
  public KCallableImpl<?> visitConstructorDescriptor(@NotNull ConstructorDescriptor paramConstructorDescriptor, @NotNull Unit paramUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramConstructorDescriptor, "descriptor");
    Intrinsics.checkParameterIsNotNull(paramUnit, "data");
    paramUnit = new StringBuilder();
    paramUnit.append("No constructors should appear in this scope: ");
    paramUnit.append(paramConstructorDescriptor);
    throw ((Throwable)new IllegalStateException(paramUnit.toString()));
  }
  
  @NotNull
  public KCallableImpl<?> visitFunctionDescriptor(@NotNull FunctionDescriptor paramFunctionDescriptor, @NotNull Unit paramUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "descriptor");
    Intrinsics.checkParameterIsNotNull(paramUnit, "data");
    return (KCallableImpl)new KFunctionImpl(this.this$0, paramFunctionDescriptor);
  }
  
  @NotNull
  public KCallableImpl<?> visitPropertyDescriptor(@NotNull PropertyDescriptor paramPropertyDescriptor, @NotNull Unit paramUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramPropertyDescriptor, "descriptor");
    Intrinsics.checkParameterIsNotNull(paramUnit, "data");
    return (KCallableImpl)KDeclarationContainerImpl.access$createProperty(this.this$0, paramPropertyDescriptor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KDeclarationContainerImpl.getMembers.visitor.1
 * JD-Core Version:    0.7.0.1
 */
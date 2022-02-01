package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"expectedReceiverType", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getExpectedReceiverType", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;)Lorg/jetbrains/kotlin/types/KotlinType;", "coerceToExpectedReceiverType", "", "descriptor", "createInlineClassAwareCallerIfNeeded", "Lkotlin/reflect/jvm/internal/calls/Caller;", "M", "Ljava/lang/reflect/Member;", "isDefault", "", "getBoxMethod", "Ljava/lang/reflect/Method;", "Ljava/lang/Class;", "getUnboxMethod", "hasInlineClassReceiver", "toInlineClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;", "kotlin-reflection"}, k=2, mv={1, 1, 16})
public final class InlineClassAwareCallerKt
{
  @Nullable
  public static final Object coerceToExpectedReceiverType(@Nullable Object paramObject, @NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "descriptor");
    if (((paramCallableMemberDescriptor instanceof PropertyDescriptor)) && (InlineClassesUtilsKt.isUnderlyingPropertyOfInlineClass((VariableDescriptor)paramCallableMemberDescriptor))) {
      return paramObject;
    }
    Object localObject2 = getExpectedReceiverType(paramCallableMemberDescriptor);
    Object localObject1 = paramObject;
    if (localObject2 != null)
    {
      localObject2 = toInlineClass((KotlinType)localObject2);
      localObject1 = paramObject;
      if (localObject2 != null)
      {
        paramCallableMemberDescriptor = getUnboxMethod((Class)localObject2, paramCallableMemberDescriptor);
        localObject1 = paramObject;
        if (paramCallableMemberDescriptor != null) {
          localObject1 = paramCallableMemberDescriptor.invoke(paramObject, new Object[0]);
        }
      }
    }
    return localObject1;
  }
  
  @NotNull
  public static final <M extends Member> Caller<M> createInlineClassAwareCallerIfNeeded(@NotNull Caller<? extends M> paramCaller, @NotNull CallableMemberDescriptor paramCallableMemberDescriptor, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCaller, "$this$createInlineClassAwareCallerIfNeeded");
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "descriptor");
    boolean bool = InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfInlineClass((CallableDescriptor)paramCallableMemberDescriptor);
    int j = 0;
    if (!bool)
    {
      localObject1 = paramCallableMemberDescriptor.getValueParameters();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "descriptor.valueParameters");
      localObject1 = (Iterable)localObject1;
      if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty())) {}
      Object localObject2;
      do
      {
        while (!((Iterator)localObject1).hasNext())
        {
          i = 0;
          break;
          localObject1 = ((Iterable)localObject1).iterator();
        }
        localObject2 = (ValueParameterDescriptor)((Iterator)localObject1).next();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "it");
        localObject2 = ((ValueParameterDescriptor)localObject2).getType();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.type");
      } while (!InlineClassesUtilsKt.isInlineClassType((KotlinType)localObject2));
      i = 1;
      if (i == 0)
      {
        localObject1 = paramCallableMemberDescriptor.getReturnType();
        if ((localObject1 == null) || (InlineClassesUtilsKt.isInlineClassType((KotlinType)localObject1) != true))
        {
          i = j;
          if ((paramCaller instanceof BoundCaller)) {
            break label189;
          }
          i = j;
          if (!hasInlineClassReceiver(paramCallableMemberDescriptor)) {
            break label189;
          }
        }
      }
    }
    int i = 1;
    label189:
    Object localObject1 = paramCaller;
    if (i != 0) {
      localObject1 = (Caller)new InlineClassAwareCaller(paramCallableMemberDescriptor, paramCaller, paramBoolean);
    }
    return localObject1;
  }
  
  @NotNull
  public static final Method getBoxMethod(@NotNull Class<?> paramClass, @NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "$this$getBoxMethod");
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "descriptor");
    try
    {
      localObject = paramClass.getDeclaredMethod("box-impl", new Class[] { getUnboxMethod(paramClass, paramCallableMemberDescriptor).getReturnType() });
      Intrinsics.checkExpressionValueIsNotNull(localObject, "getDeclaredMethod(\"box\" …d(descriptor).returnType)");
      return localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Object localObject;
      label42:
      break label42;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No box method found in inline class: ");
    ((StringBuilder)localObject).append(paramClass);
    ((StringBuilder)localObject).append(" (calling ");
    ((StringBuilder)localObject).append(paramCallableMemberDescriptor);
    ((StringBuilder)localObject).append(')');
    throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject).toString()));
  }
  
  private static final KotlinType getExpectedReceiverType(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Object localObject2 = paramCallableMemberDescriptor.getExtensionReceiverParameter();
    ReceiverParameterDescriptor localReceiverParameterDescriptor = paramCallableMemberDescriptor.getDispatchReceiverParameter();
    Object localObject1 = null;
    if (localObject2 != null) {
      return ((ReceiverParameterDescriptor)localObject2).getType();
    }
    if (localReceiverParameterDescriptor == null) {
      return null;
    }
    if ((paramCallableMemberDescriptor instanceof ConstructorDescriptor)) {
      return localReceiverParameterDescriptor.getType();
    }
    localObject2 = paramCallableMemberDescriptor.getContainingDeclaration();
    paramCallableMemberDescriptor = (CallableMemberDescriptor)localObject2;
    if (!(localObject2 instanceof ClassDescriptor)) {
      paramCallableMemberDescriptor = null;
    }
    localObject2 = (ClassDescriptor)paramCallableMemberDescriptor;
    paramCallableMemberDescriptor = localObject1;
    if (localObject2 != null) {
      paramCallableMemberDescriptor = ((ClassDescriptor)localObject2).getDefaultType();
    }
    return (KotlinType)paramCallableMemberDescriptor;
  }
  
  @NotNull
  public static final Method getUnboxMethod(@NotNull Class<?> paramClass, @NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "$this$getUnboxMethod");
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "descriptor");
    try
    {
      localObject = paramClass.getDeclaredMethod("unbox-impl", new Class[0]);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "getDeclaredMethod(\"unbox…FOR_INLINE_CLASS_MEMBERS)");
      return localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Object localObject;
      label31:
      break label31;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No unbox method found in inline class: ");
    ((StringBuilder)localObject).append(paramClass);
    ((StringBuilder)localObject).append(" (calling ");
    ((StringBuilder)localObject).append(paramCallableMemberDescriptor);
    ((StringBuilder)localObject).append(')');
    throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject).toString()));
  }
  
  private static final boolean hasInlineClassReceiver(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    paramCallableMemberDescriptor = getExpectedReceiverType(paramCallableMemberDescriptor);
    return (paramCallableMemberDescriptor != null) && (InlineClassesUtilsKt.isInlineClassType(paramCallableMemberDescriptor) == true);
  }
  
  @Nullable
  public static final Class<?> toInlineClass(@Nullable DeclarationDescriptor paramDeclarationDescriptor)
  {
    if ((paramDeclarationDescriptor instanceof ClassDescriptor))
    {
      ClassDescriptor localClassDescriptor = (ClassDescriptor)paramDeclarationDescriptor;
      if (localClassDescriptor.isInline())
      {
        Object localObject = UtilKt.toJavaClass(localClassDescriptor);
        if (localObject != null) {
          return localObject;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Class object for the class ");
        ((StringBuilder)localObject).append(localClassDescriptor.getName());
        ((StringBuilder)localObject).append(" cannot be found (classId=");
        ((StringBuilder)localObject).append(DescriptorUtilsKt.getClassId((ClassifierDescriptor)paramDeclarationDescriptor));
        ((StringBuilder)localObject).append(')');
        throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject).toString()));
      }
    }
    return null;
  }
  
  @Nullable
  public static final Class<?> toInlineClass(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$toInlineClass");
    return toInlineClass((DeclarationDescriptor)paramKotlinType.getConstructor().getDeclarationDescriptor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt
 * JD-Core Version:    0.7.0.1
 */
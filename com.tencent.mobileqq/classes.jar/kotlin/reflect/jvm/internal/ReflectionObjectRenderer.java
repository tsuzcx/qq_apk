package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/ReflectionObjectRenderer;", "", "()V", "renderer", "Lkotlin/reflect/jvm/internal/impl/renderer/DescriptorRenderer;", "renderCallable", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "renderFunction", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "renderLambda", "invoke", "renderParameter", "parameter", "Lkotlin/reflect/jvm/internal/KParameterImpl;", "renderProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "renderType", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "renderTypeParameter", "typeParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "appendReceiverType", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "receiver", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "appendReceivers", "callable", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class ReflectionObjectRenderer
{
  public static final ReflectionObjectRenderer INSTANCE = new ReflectionObjectRenderer();
  private static final DescriptorRenderer renderer = DescriptorRenderer.FQ_NAMES_IN_TYPES;
  
  private final void appendReceiverType(@NotNull StringBuilder paramStringBuilder, ReceiverParameterDescriptor paramReceiverParameterDescriptor)
  {
    if (paramReceiverParameterDescriptor != null)
    {
      paramReceiverParameterDescriptor = paramReceiverParameterDescriptor.getType();
      Intrinsics.checkExpressionValueIsNotNull(paramReceiverParameterDescriptor, "receiver.type");
      paramStringBuilder.append(renderType(paramReceiverParameterDescriptor));
      paramStringBuilder.append(".");
    }
  }
  
  private final void appendReceivers(@NotNull StringBuilder paramStringBuilder, CallableDescriptor paramCallableDescriptor)
  {
    ReceiverParameterDescriptor localReceiverParameterDescriptor = UtilKt.getInstanceReceiverParameter(paramCallableDescriptor);
    paramCallableDescriptor = paramCallableDescriptor.getExtensionReceiverParameter();
    appendReceiverType(paramStringBuilder, localReceiverParameterDescriptor);
    int i;
    if ((localReceiverParameterDescriptor != null) && (paramCallableDescriptor != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramStringBuilder.append("(");
    }
    appendReceiverType(paramStringBuilder, paramCallableDescriptor);
    if (i != 0) {
      paramStringBuilder.append(")");
    }
  }
  
  private final String renderCallable(CallableDescriptor paramCallableDescriptor)
  {
    if ((paramCallableDescriptor instanceof PropertyDescriptor)) {
      return renderProperty((PropertyDescriptor)paramCallableDescriptor);
    }
    if ((paramCallableDescriptor instanceof FunctionDescriptor)) {
      return renderFunction((FunctionDescriptor)paramCallableDescriptor);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Illegal callable: ");
    localStringBuilder.append(paramCallableDescriptor);
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
  }
  
  @NotNull
  public final String renderFunction(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "descriptor");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fun ");
    INSTANCE.appendReceivers(localStringBuilder, (CallableDescriptor)paramFunctionDescriptor);
    Object localObject = renderer;
    Name localName = paramFunctionDescriptor.getName();
    Intrinsics.checkExpressionValueIsNotNull(localName, "descriptor.name");
    localStringBuilder.append(((DescriptorRenderer)localObject).renderName(localName, true));
    localObject = paramFunctionDescriptor.getValueParameters();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "descriptor.valueParameters");
    CollectionsKt.joinTo$default((Iterable)localObject, (Appendable)localStringBuilder, (CharSequence)", ", (CharSequence)"(", (CharSequence)")", 0, null, (Function1)ReflectionObjectRenderer.renderFunction.1.1.INSTANCE, 48, null);
    localStringBuilder.append(": ");
    localObject = INSTANCE;
    paramFunctionDescriptor = paramFunctionDescriptor.getReturnType();
    if (paramFunctionDescriptor == null) {
      Intrinsics.throwNpe();
    }
    Intrinsics.checkExpressionValueIsNotNull(paramFunctionDescriptor, "descriptor.returnType!!");
    localStringBuilder.append(((ReflectionObjectRenderer)localObject).renderType(paramFunctionDescriptor));
    paramFunctionDescriptor = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramFunctionDescriptor, "StringBuilder().apply(builderAction).toString()");
    return paramFunctionDescriptor;
  }
  
  @NotNull
  public final String renderLambda(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "invoke");
    StringBuilder localStringBuilder = new StringBuilder();
    INSTANCE.appendReceivers(localStringBuilder, (CallableDescriptor)paramFunctionDescriptor);
    Object localObject = paramFunctionDescriptor.getValueParameters();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "invoke.valueParameters");
    CollectionsKt.joinTo$default((Iterable)localObject, (Appendable)localStringBuilder, (CharSequence)", ", (CharSequence)"(", (CharSequence)")", 0, null, (Function1)ReflectionObjectRenderer.renderLambda.1.1.INSTANCE, 48, null);
    localStringBuilder.append(" -> ");
    localObject = INSTANCE;
    paramFunctionDescriptor = paramFunctionDescriptor.getReturnType();
    if (paramFunctionDescriptor == null) {
      Intrinsics.throwNpe();
    }
    Intrinsics.checkExpressionValueIsNotNull(paramFunctionDescriptor, "invoke.returnType!!");
    localStringBuilder.append(((ReflectionObjectRenderer)localObject).renderType(paramFunctionDescriptor));
    paramFunctionDescriptor = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramFunctionDescriptor, "StringBuilder().apply(builderAction).toString()");
    return paramFunctionDescriptor;
  }
  
  @NotNull
  public final String renderParameter(@NotNull KParameterImpl paramKParameterImpl)
  {
    Intrinsics.checkParameterIsNotNull(paramKParameterImpl, "parameter");
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramKParameterImpl.getKind();
    int i = ReflectionObjectRenderer.WhenMappings.$EnumSwitchMapping$0[localObject.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("parameter #");
          ((StringBuilder)localObject).append(paramKParameterImpl.getIndex());
          ((StringBuilder)localObject).append(' ');
          ((StringBuilder)localObject).append(paramKParameterImpl.getName());
          localStringBuilder.append(((StringBuilder)localObject).toString());
        }
      }
      else {
        localStringBuilder.append("instance parameter");
      }
    }
    else {
      localStringBuilder.append("extension receiver parameter");
    }
    localStringBuilder.append(" of ");
    localStringBuilder.append(INSTANCE.renderCallable((CallableDescriptor)paramKParameterImpl.getCallable().getDescriptor()));
    paramKParameterImpl = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramKParameterImpl, "StringBuilder().apply(builderAction).toString()");
    return paramKParameterImpl;
  }
  
  @NotNull
  public final String renderProperty(@NotNull PropertyDescriptor paramPropertyDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramPropertyDescriptor, "descriptor");
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramPropertyDescriptor.isVar()) {
      localObject = "var ";
    } else {
      localObject = "val ";
    }
    localStringBuilder.append((String)localObject);
    INSTANCE.appendReceivers(localStringBuilder, (CallableDescriptor)paramPropertyDescriptor);
    Object localObject = renderer;
    Name localName = paramPropertyDescriptor.getName();
    Intrinsics.checkExpressionValueIsNotNull(localName, "descriptor.name");
    localStringBuilder.append(((DescriptorRenderer)localObject).renderName(localName, true));
    localStringBuilder.append(": ");
    localObject = INSTANCE;
    paramPropertyDescriptor = paramPropertyDescriptor.getType();
    Intrinsics.checkExpressionValueIsNotNull(paramPropertyDescriptor, "descriptor.type");
    localStringBuilder.append(((ReflectionObjectRenderer)localObject).renderType(paramPropertyDescriptor));
    paramPropertyDescriptor = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramPropertyDescriptor, "StringBuilder().apply(builderAction).toString()");
    return paramPropertyDescriptor;
  }
  
  @NotNull
  public final String renderType(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "type");
    return renderer.renderType(paramKotlinType);
  }
  
  @NotNull
  public final String renderTypeParameter(@NotNull TypeParameterDescriptor paramTypeParameterDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeParameterDescriptor, "typeParameter");
    StringBuilder localStringBuilder = new StringBuilder();
    Variance localVariance = paramTypeParameterDescriptor.getVariance();
    int i = ReflectionObjectRenderer.WhenMappings.$EnumSwitchMapping$1[localVariance.ordinal()];
    if (i != 1) {
      if (i != 2)
      {
        if (i == 3) {
          localStringBuilder.append("out ");
        }
      }
      else {
        localStringBuilder.append("in ");
      }
    }
    localStringBuilder.append(paramTypeParameterDescriptor.getName());
    paramTypeParameterDescriptor = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramTypeParameterDescriptor, "StringBuilder().apply(builderAction).toString()");
    return paramTypeParameterDescriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.ReflectionObjectRenderer
 * JD-Core Version:    0.7.0.1
 */
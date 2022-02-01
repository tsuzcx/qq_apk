package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class FlexibleTypeImpl
  extends FlexibleType
  implements CustomTypeVariable
{
  public static final FlexibleTypeImpl.Companion Companion = new FlexibleTypeImpl.Companion(null);
  @JvmField
  public static boolean RUN_SLOW_ASSERTIONS;
  private boolean assertionsDone;
  
  public FlexibleTypeImpl(@NotNull SimpleType paramSimpleType1, @NotNull SimpleType paramSimpleType2)
  {
    super(paramSimpleType1, paramSimpleType2);
  }
  
  private final void runAssertions()
  {
    if (RUN_SLOW_ASSERTIONS)
    {
      if (this.assertionsDone) {
        return;
      }
      this.assertionsDone = true;
      boolean bool = FlexibleTypesKt.isFlexible((KotlinType)getLowerBound());
      StringBuilder localStringBuilder;
      if ((_Assertions.ENABLED) && (!(bool ^ true)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Lower bound of a flexible type can not be flexible: ");
        localStringBuilder.append(getLowerBound());
        throw ((Throwable)new AssertionError(localStringBuilder.toString()));
      }
      bool = FlexibleTypesKt.isFlexible((KotlinType)getUpperBound());
      if ((_Assertions.ENABLED) && (!(bool ^ true)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Upper bound of a flexible type can not be flexible: ");
        localStringBuilder.append(getUpperBound());
        throw ((Throwable)new AssertionError(localStringBuilder.toString()));
      }
      bool = Intrinsics.areEqual(getLowerBound(), getUpperBound());
      if ((_Assertions.ENABLED) && (!(true ^ bool)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Lower and upper bounds are equal: ");
        localStringBuilder.append(getLowerBound());
        localStringBuilder.append(" == ");
        localStringBuilder.append(getUpperBound());
        throw ((Throwable)new AssertionError(localStringBuilder.toString()));
      }
      bool = KotlinTypeChecker.DEFAULT.isSubtypeOf((KotlinType)getLowerBound(), (KotlinType)getUpperBound());
      if (_Assertions.ENABLED)
      {
        if (bool) {
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Lower bound ");
        localStringBuilder.append(getLowerBound());
        localStringBuilder.append(" of a flexible type must be a subtype of the upper bound ");
        localStringBuilder.append(getUpperBound());
        throw ((Throwable)new AssertionError(localStringBuilder.toString()));
      }
    }
  }
  
  @NotNull
  public SimpleType getDelegate()
  {
    runAssertions();
    return getLowerBound();
  }
  
  public boolean isTypeVariable()
  {
    return ((getLowerBound().getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor)) && (Intrinsics.areEqual(getLowerBound().getConstructor(), getUpperBound().getConstructor()));
  }
  
  @NotNull
  public UnwrappedType makeNullableAsSpecified(boolean paramBoolean)
  {
    return KotlinTypeFactory.flexibleType(getLowerBound().makeNullableAsSpecified(paramBoolean), getUpperBound().makeNullableAsSpecified(paramBoolean));
  }
  
  @NotNull
  public FlexibleType refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    Object localObject = paramKotlinTypeRefiner.refineType((KotlinType)getLowerBound());
    if (localObject != null)
    {
      localObject = (SimpleType)localObject;
      paramKotlinTypeRefiner = paramKotlinTypeRefiner.refineType((KotlinType)getUpperBound());
      if (paramKotlinTypeRefiner != null) {
        return (FlexibleType)new FlexibleTypeImpl((SimpleType)localObject, (SimpleType)paramKotlinTypeRefiner);
      }
      throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
  }
  
  @NotNull
  public String render(@NotNull DescriptorRenderer paramDescriptorRenderer, @NotNull DescriptorRendererOptions paramDescriptorRendererOptions)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorRenderer, "renderer");
    Intrinsics.checkParameterIsNotNull(paramDescriptorRendererOptions, "options");
    if (paramDescriptorRendererOptions.getDebugMode())
    {
      paramDescriptorRendererOptions = new StringBuilder();
      paramDescriptorRendererOptions.append('(');
      paramDescriptorRendererOptions.append(paramDescriptorRenderer.renderType((KotlinType)getLowerBound()));
      paramDescriptorRendererOptions.append("..");
      paramDescriptorRendererOptions.append(paramDescriptorRenderer.renderType((KotlinType)getUpperBound()));
      paramDescriptorRendererOptions.append(')');
      return paramDescriptorRendererOptions.toString();
    }
    return paramDescriptorRenderer.renderFlexibleType(paramDescriptorRenderer.renderType((KotlinType)getLowerBound()), paramDescriptorRenderer.renderType((KotlinType)getUpperBound()), TypeUtilsKt.getBuiltIns(this));
  }
  
  @NotNull
  public UnwrappedType replaceAnnotations(@NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "newAnnotations");
    return KotlinTypeFactory.flexibleType(getLowerBound().replaceAnnotations(paramAnnotations), getUpperBound().replaceAnnotations(paramAnnotations));
  }
  
  @NotNull
  public KotlinType substitutionResult(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "replacement");
    UnwrappedType localUnwrappedType = paramKotlinType.unwrap();
    if ((localUnwrappedType instanceof FlexibleType))
    {
      paramKotlinType = localUnwrappedType;
    }
    else
    {
      if (!(localUnwrappedType instanceof SimpleType)) {
        break label57;
      }
      paramKotlinType = (SimpleType)localUnwrappedType;
      paramKotlinType = KotlinTypeFactory.flexibleType(paramKotlinType, paramKotlinType.makeNullableAsSpecified(true));
    }
    return (KotlinType)TypeWithEnhancementKt.inheritEnhancement(paramKotlinType, (KotlinType)localUnwrappedType);
    label57:
    throw new NoWhenBranchMatchedException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.FlexibleTypeImpl
 * JD-Core Version:    0.7.0.1
 */
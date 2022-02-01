package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptorKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KotlinTypeFactory
{
  @NotNull
  private static final Function1<KotlinTypeRefiner, SimpleType> EMPTY_REFINED_TYPE_FACTORY = (Function1)KotlinTypeFactory.EMPTY_REFINED_TYPE_FACTORY.1.INSTANCE;
  public static final KotlinTypeFactory INSTANCE = new KotlinTypeFactory();
  
  @JvmStatic
  @NotNull
  public static final SimpleType computeExpandedType(@NotNull TypeAliasDescriptor paramTypeAliasDescriptor, @NotNull List<? extends TypeProjection> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeAliasDescriptor, "$this$computeExpandedType");
    Intrinsics.checkParameterIsNotNull(paramList, "arguments");
    return new TypeAliasExpander((TypeAliasExpansionReportStrategy)TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false).expand(TypeAliasExpansion.Companion.create(null, paramTypeAliasDescriptor, paramList), Annotations.Companion.getEMPTY());
  }
  
  private final MemberScope computeMemberScope(TypeConstructor paramTypeConstructor, List<? extends TypeProjection> paramList, KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    ClassifierDescriptor localClassifierDescriptor = paramTypeConstructor.getDeclarationDescriptor();
    if ((localClassifierDescriptor instanceof TypeParameterDescriptor)) {
      return localClassifierDescriptor.getDefaultType().getMemberScope();
    }
    if ((localClassifierDescriptor instanceof ClassDescriptor))
    {
      if (paramKotlinTypeRefiner == null) {
        paramKotlinTypeRefiner = DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtilsKt.getModule((DeclarationDescriptor)localClassifierDescriptor));
      }
      if (paramList.isEmpty()) {
        return ModuleAwareClassDescriptorKt.getRefinedUnsubstitutedMemberScopeIfPossible((ClassDescriptor)localClassifierDescriptor, paramKotlinTypeRefiner);
      }
      return ModuleAwareClassDescriptorKt.getRefinedMemberScopeIfPossible((ClassDescriptor)localClassifierDescriptor, TypeConstructorSubstitution.Companion.create(paramTypeConstructor, paramList), paramKotlinTypeRefiner);
    }
    if ((localClassifierDescriptor instanceof TypeAliasDescriptor))
    {
      paramTypeConstructor = new StringBuilder();
      paramTypeConstructor.append("Scope for abbreviation: ");
      paramTypeConstructor.append(((TypeAliasDescriptor)localClassifierDescriptor).getName());
      paramTypeConstructor = ErrorUtils.createErrorScope(paramTypeConstructor.toString(), true);
      Intrinsics.checkExpressionValueIsNotNull(paramTypeConstructor, "ErrorUtils.createErrorSc…{descriptor.name}\", true)");
      return paramTypeConstructor;
    }
    paramList = new StringBuilder();
    paramList.append("Unsupported classifier: ");
    paramList.append(localClassifierDescriptor);
    paramList.append(" for constructor: ");
    paramList.append(paramTypeConstructor);
    throw ((Throwable)new IllegalStateException(paramList.toString()));
  }
  
  @JvmStatic
  @NotNull
  public static final UnwrappedType flexibleType(@NotNull SimpleType paramSimpleType1, @NotNull SimpleType paramSimpleType2)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleType1, "lowerBound");
    Intrinsics.checkParameterIsNotNull(paramSimpleType2, "upperBound");
    if (Intrinsics.areEqual(paramSimpleType1, paramSimpleType2)) {
      return (UnwrappedType)paramSimpleType1;
    }
    return (UnwrappedType)new FlexibleTypeImpl(paramSimpleType1, paramSimpleType2);
  }
  
  @JvmStatic
  @NotNull
  public static final SimpleType integerLiteralType(@NotNull Annotations paramAnnotations, @NotNull IntegerLiteralTypeConstructor paramIntegerLiteralTypeConstructor, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "annotations");
    Intrinsics.checkParameterIsNotNull(paramIntegerLiteralTypeConstructor, "constructor");
    paramIntegerLiteralTypeConstructor = (TypeConstructor)paramIntegerLiteralTypeConstructor;
    List localList = CollectionsKt.emptyList();
    MemberScope localMemberScope = ErrorUtils.createErrorScope("Scope for integer literal type", true);
    Intrinsics.checkExpressionValueIsNotNull(localMemberScope, "ErrorUtils.createErrorSc…eger literal type\", true)");
    return simpleTypeWithNonTrivialMemberScope(paramAnnotations, paramIntegerLiteralTypeConstructor, localList, paramBoolean, localMemberScope);
  }
  
  private final KotlinTypeFactory.ExpandedTypeOrRefinedConstructor refineConstructor(TypeConstructor paramTypeConstructor, KotlinTypeRefiner paramKotlinTypeRefiner, List<? extends TypeProjection> paramList)
  {
    paramTypeConstructor = paramTypeConstructor.getDeclarationDescriptor();
    if (paramTypeConstructor != null)
    {
      paramTypeConstructor = paramKotlinTypeRefiner.refineDescriptor((DeclarationDescriptor)paramTypeConstructor);
      if (paramTypeConstructor != null)
      {
        if ((paramTypeConstructor instanceof TypeAliasDescriptor)) {
          return new KotlinTypeFactory.ExpandedTypeOrRefinedConstructor(computeExpandedType((TypeAliasDescriptor)paramTypeConstructor, paramList), null);
        }
        paramTypeConstructor = paramTypeConstructor.getTypeConstructor().refine(paramKotlinTypeRefiner);
        Intrinsics.checkExpressionValueIsNotNull(paramTypeConstructor, "descriptor.typeConstruct…refine(kotlinTypeRefiner)");
        return new KotlinTypeFactory.ExpandedTypeOrRefinedConstructor(null, paramTypeConstructor);
      }
    }
    return null;
  }
  
  @JvmStatic
  @NotNull
  public static final SimpleType simpleNotNullType(@NotNull Annotations paramAnnotations, @NotNull ClassDescriptor paramClassDescriptor, @NotNull List<? extends TypeProjection> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "annotations");
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "descriptor");
    Intrinsics.checkParameterIsNotNull(paramList, "arguments");
    paramClassDescriptor = paramClassDescriptor.getTypeConstructor();
    Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "descriptor.typeConstructor");
    return simpleType$default(paramAnnotations, paramClassDescriptor, paramList, false, null, 16, null);
  }
  
  @JvmStatic
  @JvmOverloads
  @NotNull
  public static final SimpleType simpleType(@NotNull Annotations paramAnnotations, @NotNull TypeConstructor paramTypeConstructor, @NotNull List<? extends TypeProjection> paramList, boolean paramBoolean, @Nullable KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "annotations");
    Intrinsics.checkParameterIsNotNull(paramTypeConstructor, "constructor");
    Intrinsics.checkParameterIsNotNull(paramList, "arguments");
    if ((paramAnnotations.isEmpty()) && (paramList.isEmpty()) && (!paramBoolean) && (paramTypeConstructor.getDeclarationDescriptor() != null))
    {
      paramAnnotations = paramTypeConstructor.getDeclarationDescriptor();
      if (paramAnnotations == null) {
        Intrinsics.throwNpe();
      }
      Intrinsics.checkExpressionValueIsNotNull(paramAnnotations, "constructor.declarationDescriptor!!");
      paramAnnotations = paramAnnotations.getDefaultType();
      Intrinsics.checkExpressionValueIsNotNull(paramAnnotations, "constructor.declarationDescriptor!!.defaultType");
      return paramAnnotations;
    }
    return simpleTypeWithNonTrivialMemberScope(paramAnnotations, paramTypeConstructor, paramList, paramBoolean, INSTANCE.computeMemberScope(paramTypeConstructor, paramList, paramKotlinTypeRefiner), (Function1)new KotlinTypeFactory.simpleType.1(paramTypeConstructor, paramList, paramAnnotations, paramBoolean));
  }
  
  @JvmStatic
  @NotNull
  public static final SimpleType simpleTypeWithNonTrivialMemberScope(@NotNull Annotations paramAnnotations, @NotNull TypeConstructor paramTypeConstructor, @NotNull List<? extends TypeProjection> paramList, boolean paramBoolean, @NotNull MemberScope paramMemberScope)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "annotations");
    Intrinsics.checkParameterIsNotNull(paramTypeConstructor, "constructor");
    Intrinsics.checkParameterIsNotNull(paramList, "arguments");
    Intrinsics.checkParameterIsNotNull(paramMemberScope, "memberScope");
    paramTypeConstructor = new SimpleTypeImpl(paramTypeConstructor, paramList, paramBoolean, paramMemberScope, (Function1)new KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope.1(paramTypeConstructor, paramList, paramAnnotations, paramBoolean, paramMemberScope));
    if (paramAnnotations.isEmpty()) {
      return (SimpleType)paramTypeConstructor;
    }
    return (SimpleType)new AnnotatedSimpleType((SimpleType)paramTypeConstructor, paramAnnotations);
  }
  
  @JvmStatic
  @NotNull
  public static final SimpleType simpleTypeWithNonTrivialMemberScope(@NotNull Annotations paramAnnotations, @NotNull TypeConstructor paramTypeConstructor, @NotNull List<? extends TypeProjection> paramList, boolean paramBoolean, @NotNull MemberScope paramMemberScope, @NotNull Function1<? super KotlinTypeRefiner, ? extends SimpleType> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "annotations");
    Intrinsics.checkParameterIsNotNull(paramTypeConstructor, "constructor");
    Intrinsics.checkParameterIsNotNull(paramList, "arguments");
    Intrinsics.checkParameterIsNotNull(paramMemberScope, "memberScope");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "refinedTypeFactory");
    paramTypeConstructor = new SimpleTypeImpl(paramTypeConstructor, paramList, paramBoolean, paramMemberScope, paramFunction1);
    if (paramAnnotations.isEmpty()) {
      return (SimpleType)paramTypeConstructor;
    }
    return (SimpleType)new AnnotatedSimpleType((SimpleType)paramTypeConstructor, paramAnnotations);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory
 * JD-Core Version:    0.7.0.1
 */
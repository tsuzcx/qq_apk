package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TypeUtils
{
  public static final SimpleType CANT_INFER_FUNCTION_PARAM_TYPE = ErrorUtils.createErrorType("Cannot be inferred");
  public static final SimpleType DONT_CARE = ErrorUtils.createErrorTypeWithCustomDebugName("DONT_CARE");
  @NotNull
  public static final SimpleType NO_EXPECTED_TYPE = new TypeUtils.SpecialType("NO_EXPECTED_TYPE");
  public static final SimpleType UNIT_EXPECTED_TYPE = new TypeUtils.SpecialType("UNIT_EXPECTED_TYPE");
  
  public static boolean acceptsNullable(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(28);
    }
    if (paramKotlinType.isMarkedNullable()) {
      return true;
    }
    return (FlexibleTypesKt.isFlexible(paramKotlinType)) && (acceptsNullable(FlexibleTypesKt.asFlexibleType(paramKotlinType).getUpperBound()));
  }
  
  public static boolean contains(@Nullable KotlinType paramKotlinType, @NotNull Function1<UnwrappedType, Boolean> paramFunction1)
  {
    if (paramFunction1 == null) {
      $$$reportNull$$$0(43);
    }
    return contains(paramKotlinType, paramFunction1, new HashSet());
  }
  
  private static boolean contains(@Nullable KotlinType paramKotlinType, @NotNull Function1<UnwrappedType, Boolean> paramFunction1, HashSet<KotlinType> paramHashSet)
  {
    if (paramFunction1 == null) {
      $$$reportNull$$$0(44);
    }
    if (paramKotlinType == null) {
      return false;
    }
    if (paramHashSet.contains(paramKotlinType)) {
      return false;
    }
    paramHashSet.add(paramKotlinType);
    UnwrappedType localUnwrappedType = paramKotlinType.unwrap();
    if (((Boolean)paramFunction1.invoke(localUnwrappedType)).booleanValue()) {
      return true;
    }
    if ((localUnwrappedType instanceof FlexibleType)) {
      localObject = (FlexibleType)localUnwrappedType;
    } else {
      localObject = null;
    }
    if ((localObject != null) && ((contains(((FlexibleType)localObject).getLowerBound(), paramFunction1, paramHashSet)) || (contains(((FlexibleType)localObject).getUpperBound(), paramFunction1, paramHashSet)))) {
      return true;
    }
    if (((localUnwrappedType instanceof DefinitelyNotNullType)) && (contains(((DefinitelyNotNullType)localUnwrappedType).getOriginal(), paramFunction1, paramHashSet))) {
      return true;
    }
    Object localObject = paramKotlinType.getConstructor();
    if ((localObject instanceof IntersectionTypeConstructor))
    {
      paramKotlinType = ((IntersectionTypeConstructor)localObject).getSupertypes().iterator();
      while (paramKotlinType.hasNext()) {
        if (contains((KotlinType)paramKotlinType.next(), paramFunction1, paramHashSet)) {
          return true;
        }
      }
      return false;
    }
    paramKotlinType = paramKotlinType.getArguments().iterator();
    for (;;)
    {
      if (paramKotlinType.hasNext())
      {
        localObject = (TypeProjection)paramKotlinType.next();
        if (((TypeProjection)localObject).isStarProjection()) {
          continue;
        }
        localObject = ((TypeProjection)localObject).getType();
      }
      try
      {
        boolean bool = contains((KotlinType)localObject, paramFunction1, paramHashSet);
        if (bool) {
          return true;
        }
      }
      catch (Throwable paramKotlinType) {}
    }
    return false;
    for (;;)
    {
      throw paramKotlinType;
    }
  }
  
  @Nullable
  public static KotlinType createSubstitutedSupertype(@NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2, @NotNull TypeSubstitutor paramTypeSubstitutor)
  {
    if (paramKotlinType1 == null) {
      $$$reportNull$$$0(20);
    }
    if (paramKotlinType2 == null) {
      $$$reportNull$$$0(21);
    }
    if (paramTypeSubstitutor == null) {
      $$$reportNull$$$0(22);
    }
    paramKotlinType2 = paramTypeSubstitutor.substitute(paramKotlinType2, Variance.INVARIANT);
    if (paramKotlinType2 != null) {
      return makeNullableIfNeeded(paramKotlinType2, paramKotlinType1.isMarkedNullable());
    }
    return null;
  }
  
  @Nullable
  public static ClassDescriptor getClassDescriptor(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(30);
    }
    paramKotlinType = paramKotlinType.getConstructor().getDeclarationDescriptor();
    if ((paramKotlinType instanceof ClassDescriptor)) {
      return (ClassDescriptor)paramKotlinType;
    }
    return null;
  }
  
  @NotNull
  public static List<TypeProjection> getDefaultTypeProjections(@NotNull List<TypeParameterDescriptor> paramList)
  {
    if (paramList == null) {
      $$$reportNull$$$0(16);
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new TypeProjectionImpl(((TypeParameterDescriptor)paramList.next()).getDefaultType()));
    }
    paramList = CollectionsKt.toList(localArrayList);
    if (paramList == null) {
      $$$reportNull$$$0(17);
    }
    return paramList;
  }
  
  @NotNull
  public static List<KotlinType> getImmediateSupertypes(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(18);
    }
    TypeSubstitutor localTypeSubstitutor = TypeSubstitutor.create(paramKotlinType);
    Object localObject = paramKotlinType.getConstructor().getSupertypes();
    ArrayList localArrayList = new ArrayList(((Collection)localObject).size());
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      KotlinType localKotlinType = createSubstitutedSupertype(paramKotlinType, (KotlinType)((Iterator)localObject).next(), localTypeSubstitutor);
      if (localKotlinType != null) {
        localArrayList.add(localKotlinType);
      }
    }
    return localArrayList;
  }
  
  @Nullable
  public static TypeParameterDescriptor getTypeParameterDescriptorOrNull(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(62);
    }
    if ((paramKotlinType.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor)) {
      return (TypeParameterDescriptor)paramKotlinType.getConstructor().getDeclarationDescriptor();
    }
    return null;
  }
  
  public static boolean hasNullableSuperType(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(29);
    }
    if ((paramKotlinType.getConstructor().getDeclarationDescriptor() instanceof ClassDescriptor)) {
      return false;
    }
    paramKotlinType = getImmediateSupertypes(paramKotlinType).iterator();
    while (paramKotlinType.hasNext()) {
      if (isNullableType((KotlinType)paramKotlinType.next())) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isDontCarePlaceholder(@Nullable KotlinType paramKotlinType)
  {
    return (paramKotlinType != null) && (paramKotlinType.getConstructor() == DONT_CARE.getConstructor());
  }
  
  public static boolean isNullableType(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(27);
    }
    if (paramKotlinType.isMarkedNullable()) {
      return true;
    }
    if ((FlexibleTypesKt.isFlexible(paramKotlinType)) && (isNullableType(FlexibleTypesKt.asFlexibleType(paramKotlinType).getUpperBound()))) {
      return true;
    }
    if (isTypeParameter(paramKotlinType)) {
      return hasNullableSuperType(paramKotlinType);
    }
    paramKotlinType = paramKotlinType.getConstructor();
    if ((paramKotlinType instanceof IntersectionTypeConstructor))
    {
      paramKotlinType = paramKotlinType.getSupertypes().iterator();
      while (paramKotlinType.hasNext()) {
        if (isNullableType((KotlinType)paramKotlinType.next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean isTypeParameter(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(59);
    }
    return (getTypeParameterDescriptorOrNull(paramKotlinType) != null) || ((paramKotlinType.getConstructor() instanceof NewTypeVariableConstructor));
  }
  
  @NotNull
  public static KotlinType makeNotNullable(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(2);
    }
    return makeNullableAsSpecified(paramKotlinType, false);
  }
  
  @NotNull
  public static KotlinType makeNullable(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(1);
    }
    return makeNullableAsSpecified(paramKotlinType, true);
  }
  
  @NotNull
  public static KotlinType makeNullableAsSpecified(@NotNull KotlinType paramKotlinType, boolean paramBoolean)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(3);
    }
    paramKotlinType = paramKotlinType.unwrap().makeNullableAsSpecified(paramBoolean);
    if (paramKotlinType == null) {
      $$$reportNull$$$0(4);
    }
    return paramKotlinType;
  }
  
  @NotNull
  public static KotlinType makeNullableIfNeeded(@NotNull KotlinType paramKotlinType, boolean paramBoolean)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(8);
    }
    if (paramBoolean) {
      return makeNullable(paramKotlinType);
    }
    if (paramKotlinType == null) {
      $$$reportNull$$$0(9);
    }
    return paramKotlinType;
  }
  
  @NotNull
  public static SimpleType makeNullableIfNeeded(@NotNull SimpleType paramSimpleType, boolean paramBoolean)
  {
    if (paramSimpleType == null) {
      $$$reportNull$$$0(5);
    }
    if (paramBoolean)
    {
      paramSimpleType = paramSimpleType.makeNullableAsSpecified(true);
      if (paramSimpleType == null) {
        $$$reportNull$$$0(6);
      }
      return paramSimpleType;
    }
    if (paramSimpleType == null) {
      $$$reportNull$$$0(7);
    }
    return paramSimpleType;
  }
  
  @NotNull
  public static TypeProjection makeStarProjection(@NotNull TypeParameterDescriptor paramTypeParameterDescriptor)
  {
    if (paramTypeParameterDescriptor == null) {
      $$$reportNull$$$0(45);
    }
    return new StarProjectionImpl(paramTypeParameterDescriptor);
  }
  
  @NotNull
  public static SimpleType makeUnsubstitutedType(ClassifierDescriptor paramClassifierDescriptor, MemberScope paramMemberScope, Function1<KotlinTypeRefiner, SimpleType> paramFunction1)
  {
    if (ErrorUtils.isError(paramClassifierDescriptor))
    {
      paramMemberScope = new StringBuilder();
      paramMemberScope.append("Unsubstituted type for ");
      paramMemberScope.append(paramClassifierDescriptor);
      paramClassifierDescriptor = ErrorUtils.createErrorType(paramMemberScope.toString());
      if (paramClassifierDescriptor == null) {
        $$$reportNull$$$0(11);
      }
      return paramClassifierDescriptor;
    }
    return makeUnsubstitutedType(paramClassifierDescriptor.getTypeConstructor(), paramMemberScope, paramFunction1);
  }
  
  @NotNull
  public static SimpleType makeUnsubstitutedType(@NotNull TypeConstructor paramTypeConstructor, @NotNull MemberScope paramMemberScope, @NotNull Function1<KotlinTypeRefiner, SimpleType> paramFunction1)
  {
    if (paramTypeConstructor == null) {
      $$$reportNull$$$0(12);
    }
    if (paramMemberScope == null) {
      $$$reportNull$$$0(13);
    }
    if (paramFunction1 == null) {
      $$$reportNull$$$0(14);
    }
    List localList = getDefaultTypeProjections(paramTypeConstructor.getParameters());
    paramTypeConstructor = KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(Annotations.Companion.getEMPTY(), paramTypeConstructor, localList, false, paramMemberScope, paramFunction1);
    if (paramTypeConstructor == null) {
      $$$reportNull$$$0(15);
    }
    return paramTypeConstructor;
  }
  
  public static boolean noExpectedType(@NotNull KotlinType paramKotlinType)
  {
    boolean bool = false;
    if (paramKotlinType == null) {
      $$$reportNull$$$0(0);
    }
    if ((paramKotlinType == NO_EXPECTED_TYPE) || (paramKotlinType == UNIT_EXPECTED_TYPE)) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeUtils
 * JD-Core Version:    0.7.0.1
 */
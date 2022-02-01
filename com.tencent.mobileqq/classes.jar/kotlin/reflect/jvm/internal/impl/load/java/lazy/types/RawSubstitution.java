package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

public final class RawSubstitution
  extends TypeSubstitution
{
  public static final RawSubstitution INSTANCE = new RawSubstitution();
  private static final JavaTypeAttributes lowerTypeAttr = JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 3, null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND);
  private static final JavaTypeAttributes upperTypeAttr = JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 3, null).withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);
  
  private final Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor(SimpleType paramSimpleType, ClassDescriptor paramClassDescriptor, JavaTypeAttributes paramJavaTypeAttributes)
  {
    boolean bool = paramSimpleType.getConstructor().getParameters().isEmpty();
    Object localObject1 = Boolean.valueOf(false);
    if (bool) {
      return TuplesKt.to(paramSimpleType, localObject1);
    }
    Object localObject2 = (KotlinType)paramSimpleType;
    if (KotlinBuiltIns.isArray((KotlinType)localObject2))
    {
      paramJavaTypeAttributes = (TypeProjection)paramSimpleType.getArguments().get(0);
      paramClassDescriptor = paramJavaTypeAttributes.getProjectionKind();
      paramJavaTypeAttributes = paramJavaTypeAttributes.getType();
      Intrinsics.checkExpressionValueIsNotNull(paramJavaTypeAttributes, "componentTypeProjection.type");
      paramClassDescriptor = CollectionsKt.listOf(new TypeProjectionImpl(paramClassDescriptor, eraseType(paramJavaTypeAttributes)));
      return TuplesKt.to(KotlinTypeFactory.simpleType$default(paramSimpleType.getAnnotations(), paramSimpleType.getConstructor(), paramClassDescriptor, paramSimpleType.isMarkedNullable(), null, 16, null), localObject1);
    }
    if (KotlinTypeKt.isError((KotlinType)localObject2))
    {
      paramClassDescriptor = new StringBuilder();
      paramClassDescriptor.append("Raw error type: ");
      paramClassDescriptor.append(paramSimpleType.getConstructor());
      return TuplesKt.to(ErrorUtils.createErrorType(paramClassDescriptor.toString()), localObject1);
    }
    localObject1 = paramClassDescriptor.getMemberScope((TypeSubstitution)INSTANCE);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "declaration.getMemberScope(RawSubstitution)");
    localObject2 = paramSimpleType.getAnnotations();
    TypeConstructor localTypeConstructor = paramClassDescriptor.getTypeConstructor();
    Intrinsics.checkExpressionValueIsNotNull(localTypeConstructor, "declaration.typeConstructor");
    Object localObject3 = paramClassDescriptor.getTypeConstructor();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "declaration.typeConstructor");
    localObject3 = ((TypeConstructor)localObject3).getParameters();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "declaration.typeConstructor.parameters");
    Object localObject4 = (Iterable)localObject3;
    localObject3 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject4, 10));
    localObject4 = ((Iterable)localObject4).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      TypeParameterDescriptor localTypeParameterDescriptor = (TypeParameterDescriptor)((Iterator)localObject4).next();
      RawSubstitution localRawSubstitution = INSTANCE;
      Intrinsics.checkExpressionValueIsNotNull(localTypeParameterDescriptor, "parameter");
      ((Collection)localObject3).add(computeProjection$default(localRawSubstitution, localTypeParameterDescriptor, paramJavaTypeAttributes, null, 4, null));
    }
    return TuplesKt.to(KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope((Annotations)localObject2, localTypeConstructor, (List)localObject3, paramSimpleType.isMarkedNullable(), (MemberScope)localObject1, (Function1)new RawSubstitution.eraseInflexibleBasedOnClassDescriptor.2(paramClassDescriptor, paramSimpleType, paramJavaTypeAttributes)), Boolean.valueOf(true));
  }
  
  private final KotlinType eraseType(KotlinType paramKotlinType)
  {
    Object localObject2 = paramKotlinType.getConstructor().getDeclarationDescriptor();
    if ((localObject2 instanceof TypeParameterDescriptor)) {
      return eraseType(JavaTypeResolverKt.getErasedUpperBound$default((TypeParameterDescriptor)localObject2, null, null, 3, null));
    }
    if ((localObject2 instanceof ClassDescriptor))
    {
      Object localObject1 = FlexibleTypesKt.upperIfFlexible(paramKotlinType).getConstructor().getDeclarationDescriptor();
      if ((localObject1 instanceof ClassDescriptor))
      {
        Pair localPair = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.lowerIfFlexible(paramKotlinType), (ClassDescriptor)localObject2, lowerTypeAttr);
        localObject2 = (SimpleType)localPair.component1();
        boolean bool1 = ((Boolean)localPair.component2()).booleanValue();
        paramKotlinType = eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.upperIfFlexible(paramKotlinType), (ClassDescriptor)localObject1, upperTypeAttr);
        localObject1 = (SimpleType)paramKotlinType.component1();
        boolean bool2 = ((Boolean)paramKotlinType.component2()).booleanValue();
        if ((!bool1) && (!bool2)) {
          paramKotlinType = KotlinTypeFactory.flexibleType((SimpleType)localObject2, (SimpleType)localObject1);
        } else {
          paramKotlinType = (UnwrappedType)new RawTypeImpl((SimpleType)localObject2, (SimpleType)localObject1);
        }
        return (KotlinType)paramKotlinType;
      }
      paramKotlinType = new StringBuilder();
      paramKotlinType.append("For some reason declaration for upper bound is not a class ");
      paramKotlinType.append("but \"");
      paramKotlinType.append(localObject1);
      paramKotlinType.append("\" while for lower it's \"");
      paramKotlinType.append(localObject2);
      paramKotlinType.append('"');
      throw ((Throwable)new IllegalStateException(paramKotlinType.toString().toString()));
    }
    paramKotlinType = new StringBuilder();
    paramKotlinType.append("Unexpected declaration kind: ");
    paramKotlinType.append(localObject2);
    throw ((Throwable)new IllegalStateException(paramKotlinType.toString().toString()));
  }
  
  @NotNull
  public final TypeProjection computeProjection(@NotNull TypeParameterDescriptor paramTypeParameterDescriptor, @NotNull JavaTypeAttributes paramJavaTypeAttributes, @NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeParameterDescriptor, "parameter");
    Intrinsics.checkParameterIsNotNull(paramJavaTypeAttributes, "attr");
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "erasedUpperBound");
    Object localObject = paramJavaTypeAttributes.getFlexibility();
    int i = RawSubstitution.WhenMappings.$EnumSwitchMapping$0[localObject.ordinal()];
    if (i != 1)
    {
      if ((i != 2) && (i != 3)) {
        throw new NoWhenBranchMatchedException();
      }
      if (!paramTypeParameterDescriptor.getVariance().getAllowsOutPosition()) {
        return (TypeProjection)new TypeProjectionImpl(Variance.INVARIANT, (KotlinType)DescriptorUtilsKt.getBuiltIns((DeclarationDescriptor)paramTypeParameterDescriptor).getNothingType());
      }
      localObject = paramKotlinType.getConstructor().getParameters();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "erasedUpperBound.constructor.parameters");
      if ((((Collection)localObject).isEmpty() ^ true)) {
        paramTypeParameterDescriptor = (TypeProjection)new TypeProjectionImpl(Variance.OUT_VARIANCE, paramKotlinType);
      } else {
        paramTypeParameterDescriptor = JavaTypeResolverKt.makeStarProjection(paramTypeParameterDescriptor, paramJavaTypeAttributes);
      }
      return paramTypeParameterDescriptor;
    }
    return (TypeProjection)new TypeProjectionImpl(Variance.INVARIANT, paramKotlinType);
  }
  
  @NotNull
  public TypeProjectionImpl get(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "key");
    return new TypeProjectionImpl(eraseType(paramKotlinType));
  }
  
  public boolean isEmpty()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution
 * JD-Core Version:    0.7.0.1
 */
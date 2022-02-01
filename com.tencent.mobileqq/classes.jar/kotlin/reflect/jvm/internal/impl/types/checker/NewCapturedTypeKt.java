package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NewCapturedTypeKt
{
  @Nullable
  public static final SimpleType captureFromArguments(@NotNull SimpleType paramSimpleType, @NotNull CaptureStatus paramCaptureStatus)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleType, "type");
    Intrinsics.checkParameterIsNotNull(paramCaptureStatus, "status");
    if (paramSimpleType.getArguments().size() != paramSimpleType.getConstructor().getParameters().size()) {
      return null;
    }
    List localList = paramSimpleType.getArguments();
    Object localObject1 = (Iterable)localList;
    boolean bool = localObject1 instanceof Collection;
    int j = 0;
    int k = 1;
    if ((bool) && (((Collection)localObject1).isEmpty()))
    {
      i = k;
    }
    else
    {
      localObject2 = ((Iterable)localObject1).iterator();
      do
      {
        i = k;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        if (((TypeProjection)((Iterator)localObject2).next()).getProjectionKind() == Variance.INVARIANT) {
          i = 1;
        } else {
          i = 0;
        }
      } while (i != 0);
      i = 0;
    }
    if (i != 0) {
      return null;
    }
    Object localObject2 = paramSimpleType.getConstructor().getParameters();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "type.constructor.parameters");
    localObject1 = (Iterable)CollectionsKt.zip((Iterable)localObject1, (Iterable)localObject2);
    Object localObject3 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    Object localObject4 = ((Iterable)localObject1).iterator();
    Object localObject5;
    while (((Iterator)localObject4).hasNext())
    {
      localObject1 = (Pair)((Iterator)localObject4).next();
      localObject2 = (TypeProjection)((Pair)localObject1).component1();
      localObject5 = (TypeParameterDescriptor)((Pair)localObject1).component2();
      if (((TypeProjection)localObject2).getProjectionKind() == Variance.INVARIANT)
      {
        localObject1 = localObject2;
      }
      else
      {
        if ((!((TypeProjection)localObject2).isStarProjection()) && (((TypeProjection)localObject2).getProjectionKind() == Variance.IN_VARIANCE)) {
          localObject1 = ((TypeProjection)localObject2).getType().unwrap();
        } else {
          localObject1 = null;
        }
        Intrinsics.checkExpressionValueIsNotNull(localObject5, "parameter");
        localObject1 = TypeUtilsKt.asTypeProjection((KotlinType)new NewCapturedType(paramCaptureStatus, (UnwrappedType)localObject1, (TypeProjection)localObject2, (TypeParameterDescriptor)localObject5));
      }
      ((Collection)localObject3).add(localObject1);
    }
    paramCaptureStatus = (List)localObject3;
    localObject1 = TypeConstructorSubstitution.Companion.create(paramSimpleType.getConstructor(), paramCaptureStatus).buildSubstitutor();
    k = ((Collection)localList).size();
    int i = j;
    while (i < k)
    {
      localObject2 = (TypeProjection)localList.get(i);
      localObject3 = (TypeProjection)paramCaptureStatus.get(i);
      if (((TypeProjection)localObject2).getProjectionKind() != Variance.INVARIANT)
      {
        localObject4 = paramSimpleType.getConstructor().getParameters().get(i);
        Intrinsics.checkExpressionValueIsNotNull(localObject4, "type.constructor.parameters[index]");
        localObject4 = ((TypeParameterDescriptor)localObject4).getUpperBounds();
        Intrinsics.checkExpressionValueIsNotNull(localObject4, "type.constructor.parameters[index].upperBounds");
        localObject5 = (Iterable)localObject4;
        localObject4 = (Collection)new ArrayList();
        localObject5 = ((Iterable)localObject5).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          KotlinType localKotlinType = (KotlinType)((Iterator)localObject5).next();
          ((Collection)localObject4).add(NewKotlinTypeChecker.Companion.getDefault().transformToNewType(((TypeSubstitutor)localObject1).safeSubstitute(localKotlinType, Variance.INVARIANT).unwrap()));
        }
        localObject4 = (List)localObject4;
        if ((!((TypeProjection)localObject2).isStarProjection()) && (((TypeProjection)localObject2).getProjectionKind() == Variance.OUT_VARIANCE)) {
          ((Collection)localObject4).add(NewKotlinTypeChecker.Companion.getDefault().transformToNewType(((TypeProjection)localObject2).getType().unwrap()));
        }
        localObject2 = ((TypeProjection)localObject3).getType();
        if (localObject2 != null) {
          ((NewCapturedType)localObject2).getConstructor().initializeSupertypes((List)localObject4);
        }
      }
      else
      {
        i += 1;
        continue;
      }
      throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
    }
    return KotlinTypeFactory.simpleType$default(paramSimpleType.getAnnotations(), paramSimpleType.getConstructor(), paramCaptureStatus, paramSimpleType.isMarkedNullable(), null, 16, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeKt
 * JD-Core Version:    0.7.0.1
 */
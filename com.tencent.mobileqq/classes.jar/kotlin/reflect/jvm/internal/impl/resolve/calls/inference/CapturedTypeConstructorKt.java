package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

public final class CapturedTypeConstructorKt
{
  private static final TypeProjection createCapturedIfNeeded(@NotNull TypeProjection paramTypeProjection, TypeParameterDescriptor paramTypeParameterDescriptor)
  {
    if (paramTypeParameterDescriptor != null)
    {
      if (paramTypeProjection.getProjectionKind() == Variance.INVARIANT) {
        return paramTypeProjection;
      }
      if (paramTypeParameterDescriptor.getVariance() == paramTypeProjection.getProjectionKind())
      {
        if (paramTypeProjection.isStarProjection())
        {
          paramTypeParameterDescriptor = LockBasedStorageManager.NO_LOCKS;
          Intrinsics.checkExpressionValueIsNotNull(paramTypeParameterDescriptor, "LockBasedStorageManager.NO_LOCKS");
          return (TypeProjection)new TypeProjectionImpl((KotlinType)new LazyWrappedType(paramTypeParameterDescriptor, (Function0)new CapturedTypeConstructorKt.createCapturedIfNeeded.1(paramTypeProjection)));
        }
        return (TypeProjection)new TypeProjectionImpl(paramTypeProjection.getType());
      }
      return (TypeProjection)new TypeProjectionImpl(createCapturedType(paramTypeProjection));
    }
    return paramTypeProjection;
  }
  
  @NotNull
  public static final KotlinType createCapturedType(@NotNull TypeProjection paramTypeProjection)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeProjection, "typeProjection");
    return (KotlinType)new CapturedType(paramTypeProjection, null, false, null, 14, null);
  }
  
  public static final boolean isCaptured(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$isCaptured");
    return paramKotlinType.getConstructor() instanceof CapturedTypeConstructor;
  }
  
  @NotNull
  public static final TypeSubstitution wrapWithCapturingSubstitution(@NotNull TypeSubstitution paramTypeSubstitution, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeSubstitution, "$this$wrapWithCapturingSubstitution");
    if ((paramTypeSubstitution instanceof IndexedParametersSubstitution))
    {
      Object localObject1 = (IndexedParametersSubstitution)paramTypeSubstitution;
      paramTypeSubstitution = ((IndexedParametersSubstitution)localObject1).getParameters();
      Object localObject2 = (Iterable)ArraysKt.zip(((IndexedParametersSubstitution)localObject1).getArguments(), ((IndexedParametersSubstitution)localObject1).getParameters());
      localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject2).next();
        ((Collection)localObject1).add(createCapturedIfNeeded((TypeProjection)localPair.getFirst(), (TypeParameterDescriptor)localPair.getSecond()));
      }
      localObject1 = ((Collection)localObject1).toArray(new TypeProjection[0]);
      if (localObject1 != null) {
        return (TypeSubstitution)new IndexedParametersSubstitution(paramTypeSubstitution, (TypeProjection[])localObject1, paramBoolean);
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    return (TypeSubstitution)new CapturedTypeConstructorKt.wrapWithCapturingSubstitution.2(paramTypeSubstitution, paramBoolean, paramTypeSubstitution);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt
 * JD-Core Version:    0.7.0.1
 */
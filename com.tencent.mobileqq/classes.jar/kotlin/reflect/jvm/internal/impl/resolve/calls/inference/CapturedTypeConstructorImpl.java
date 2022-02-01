package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CapturedTypeConstructorImpl
  implements CapturedTypeConstructor
{
  @Nullable
  private NewCapturedTypeConstructor newTypeConstructor;
  @NotNull
  private final TypeProjection projection;
  
  public CapturedTypeConstructorImpl(@NotNull TypeProjection paramTypeProjection)
  {
    this.projection = paramTypeProjection;
    int i;
    if (getProjection().getProjectionKind() != Variance.INVARIANT) {
      i = 1;
    } else {
      i = 0;
    }
    if (_Assertions.ENABLED)
    {
      if (i != 0) {
        return;
      }
      paramTypeProjection = new StringBuilder();
      paramTypeProjection.append("Only nontrivial projections can be captured, not: ");
      paramTypeProjection.append(getProjection());
      throw ((Throwable)new AssertionError(paramTypeProjection.toString()));
    }
  }
  
  @NotNull
  public KotlinBuiltIns getBuiltIns()
  {
    KotlinBuiltIns localKotlinBuiltIns = getProjection().getType().getConstructor().getBuiltIns();
    Intrinsics.checkExpressionValueIsNotNull(localKotlinBuiltIns, "projection.type.constructor.builtIns");
    return localKotlinBuiltIns;
  }
  
  @Nullable
  public Void getDeclarationDescriptor()
  {
    return null;
  }
  
  @Nullable
  public final NewCapturedTypeConstructor getNewTypeConstructor()
  {
    return this.newTypeConstructor;
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getParameters()
  {
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public TypeProjection getProjection()
  {
    return this.projection;
  }
  
  @NotNull
  public Collection<KotlinType> getSupertypes()
  {
    KotlinType localKotlinType;
    if (getProjection().getProjectionKind() == Variance.OUT_VARIANCE) {
      localKotlinType = getProjection().getType();
    } else {
      localKotlinType = (KotlinType)getBuiltIns().getNullableAnyType();
    }
    Intrinsics.checkExpressionValueIsNotNull(localKotlinType, "if (projection.projectio… builtIns.nullableAnyType");
    return (Collection)CollectionsKt.listOf(localKotlinType);
  }
  
  public boolean isDenotable()
  {
    return false;
  }
  
  @NotNull
  public CapturedTypeConstructorImpl refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    paramKotlinTypeRefiner = getProjection().refine(paramKotlinTypeRefiner);
    Intrinsics.checkExpressionValueIsNotNull(paramKotlinTypeRefiner, "projection.refine(kotlinTypeRefiner)");
    return new CapturedTypeConstructorImpl(paramKotlinTypeRefiner);
  }
  
  public final void setNewTypeConstructor(@Nullable NewCapturedTypeConstructor paramNewCapturedTypeConstructor)
  {
    this.newTypeConstructor = paramNewCapturedTypeConstructor;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CapturedTypeConstructor(");
    localStringBuilder.append(getProjection());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorImpl
 * JD-Core Version:    0.7.0.1
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NewCapturedTypeConstructor
  implements CapturedTypeConstructor
{
  private final Lazy _supertypes$delegate;
  private final NewCapturedTypeConstructor original;
  @NotNull
  private final TypeProjection projection;
  private Function0<? extends List<? extends UnwrappedType>> supertypesComputation;
  @Nullable
  private final TypeParameterDescriptor typeParameter;
  
  public NewCapturedTypeConstructor(@NotNull TypeProjection paramTypeProjection, @NotNull List<? extends UnwrappedType> paramList, @Nullable NewCapturedTypeConstructor paramNewCapturedTypeConstructor)
  {
    this(paramTypeProjection, (Function0)new NewCapturedTypeConstructor.1(paramList), paramNewCapturedTypeConstructor, null, 8, null);
  }
  
  public NewCapturedTypeConstructor(@NotNull TypeProjection paramTypeProjection, @Nullable Function0<? extends List<? extends UnwrappedType>> paramFunction0, @Nullable NewCapturedTypeConstructor paramNewCapturedTypeConstructor, @Nullable TypeParameterDescriptor paramTypeParameterDescriptor)
  {
    this.projection = paramTypeProjection;
    this.supertypesComputation = paramFunction0;
    this.original = paramNewCapturedTypeConstructor;
    this.typeParameter = paramTypeParameterDescriptor;
    this._supertypes$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0)new NewCapturedTypeConstructor._supertypes.2(this));
  }
  
  private final List<UnwrappedType> get_supertypes()
  {
    return (List)this._supertypes$delegate.getValue();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((NewCapturedTypeConstructor)this == paramObject) {
      return true;
    }
    Object localObject2 = getClass();
    Object localObject1;
    if (paramObject != null) {
      localObject1 = paramObject.getClass();
    } else {
      localObject1 = null;
    }
    if ((Intrinsics.areEqual(localObject2, localObject1) ^ true)) {
      return false;
    }
    if (paramObject != null)
    {
      localObject1 = (NewCapturedTypeConstructor)paramObject;
      paramObject = this.original;
      if (paramObject == null) {
        paramObject = this;
      }
      localObject2 = ((NewCapturedTypeConstructor)localObject1).original;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
      return paramObject == localObject1;
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
  }
  
  @NotNull
  public KotlinBuiltIns getBuiltIns()
  {
    KotlinType localKotlinType = getProjection().getType();
    Intrinsics.checkExpressionValueIsNotNull(localKotlinType, "projection.type");
    return TypeUtilsKt.getBuiltIns(localKotlinType);
  }
  
  @Nullable
  public ClassifierDescriptor getDeclarationDescriptor()
  {
    return null;
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
  public List<UnwrappedType> getSupertypes()
  {
    List localList = get_supertypes();
    if (localList != null) {
      return localList;
    }
    return CollectionsKt.emptyList();
  }
  
  public int hashCode()
  {
    NewCapturedTypeConstructor localNewCapturedTypeConstructor = this.original;
    if (localNewCapturedTypeConstructor != null) {
      return localNewCapturedTypeConstructor.hashCode();
    }
    return super.hashCode();
  }
  
  public final void initializeSupertypes(@NotNull List<? extends UnwrappedType> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "supertypes");
    int i;
    if (this.supertypesComputation == null) {
      i = 1;
    } else {
      i = 0;
    }
    if ((_Assertions.ENABLED) && (i == 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Already initialized! oldValue = ");
      localStringBuilder.append(this.supertypesComputation);
      localStringBuilder.append(", newValue = ");
      localStringBuilder.append(paramList);
      throw ((Throwable)new AssertionError(localStringBuilder.toString()));
    }
    this.supertypesComputation = ((Function0)new NewCapturedTypeConstructor.initializeSupertypes.2(paramList));
  }
  
  public boolean isDenotable()
  {
    return false;
  }
  
  @NotNull
  public NewCapturedTypeConstructor refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    TypeProjection localTypeProjection = getProjection().refine(paramKotlinTypeRefiner);
    Intrinsics.checkExpressionValueIsNotNull(localTypeProjection, "projection.refine(kotlinTypeRefiner)");
    if (this.supertypesComputation != null) {
      paramKotlinTypeRefiner = (Function0)new NewCapturedTypeConstructor.refine..inlined.let.lambda.1(this, paramKotlinTypeRefiner);
    } else {
      paramKotlinTypeRefiner = null;
    }
    NewCapturedTypeConstructor localNewCapturedTypeConstructor = this.original;
    if (localNewCapturedTypeConstructor == null) {
      localNewCapturedTypeConstructor = this;
    }
    return new NewCapturedTypeConstructor(localTypeProjection, paramKotlinTypeRefiner, localNewCapturedTypeConstructor, this.typeParameter);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CapturedType(");
    localStringBuilder.append(getProjection());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor
 * JD-Core Version:    0.7.0.1
 */
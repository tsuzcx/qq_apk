package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractTypeConstructor
  implements TypeConstructor
{
  private final NotNullLazyValue<AbstractTypeConstructor.Supertypes> supertypes;
  
  public AbstractTypeConstructor(@NotNull StorageManager paramStorageManager)
  {
    this.supertypes = paramStorageManager.createLazyValueWithPostCompute((Function0)new AbstractTypeConstructor.supertypes.1(this), (Function1)AbstractTypeConstructor.supertypes.2.INSTANCE, (Function1)new AbstractTypeConstructor.supertypes.3(this));
  }
  
  private final Collection<KotlinType> computeNeighbours(@NotNull TypeConstructor paramTypeConstructor, boolean paramBoolean)
  {
    if (!(paramTypeConstructor instanceof AbstractTypeConstructor)) {
      localObject = null;
    } else {
      localObject = paramTypeConstructor;
    }
    Object localObject = (AbstractTypeConstructor)localObject;
    if (localObject != null)
    {
      localObject = CollectionsKt.plus(((AbstractTypeConstructor.Supertypes)((AbstractTypeConstructor)localObject).supertypes.invoke()).getAllSupertypes(), (Iterable)((AbstractTypeConstructor)localObject).getAdditionalNeighboursInSupertypeGraph(paramBoolean));
      if (localObject != null) {
        return (Collection)localObject;
      }
    }
    paramTypeConstructor = paramTypeConstructor.getSupertypes();
    Intrinsics.checkExpressionValueIsNotNull(paramTypeConstructor, "supertypes");
    return paramTypeConstructor;
  }
  
  @NotNull
  protected abstract Collection<KotlinType> computeSupertypes();
  
  @Nullable
  protected KotlinType defaultSupertypeIfEmpty()
  {
    return null;
  }
  
  @NotNull
  protected Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean paramBoolean)
  {
    return (Collection)CollectionsKt.emptyList();
  }
  
  @NotNull
  public abstract ClassifierDescriptor getDeclarationDescriptor();
  
  @NotNull
  protected abstract SupertypeLoopChecker getSupertypeLoopChecker();
  
  @NotNull
  public List<KotlinType> getSupertypes()
  {
    return ((AbstractTypeConstructor.Supertypes)this.supertypes.invoke()).getSupertypesWithoutCycles();
  }
  
  @NotNull
  public TypeConstructor refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    return (TypeConstructor)new AbstractTypeConstructor.ModuleViewTypeConstructor(this, paramKotlinTypeRefiner);
  }
  
  protected void reportScopesLoopError(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "type");
  }
  
  protected void reportSupertypeLoopError(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "type");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
 * JD-Core Version:    0.7.0.1
 */
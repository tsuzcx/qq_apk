package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Set;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractTypeCheckerContext
  implements TypeSystemContext
{
  private int argumentsDepth;
  @Nullable
  private ArrayDeque<SimpleTypeMarker> supertypesDeque;
  private boolean supertypesLocked;
  @Nullable
  private Set<SimpleTypeMarker> supertypesSet;
  
  @Nullable
  public Boolean addSubtypeConstraint(@NotNull KotlinTypeMarker paramKotlinTypeMarker1, @NotNull KotlinTypeMarker paramKotlinTypeMarker2)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker1, "subType");
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker2, "superType");
    return null;
  }
  
  public abstract boolean areEqualTypeConstructors(@NotNull TypeConstructorMarker paramTypeConstructorMarker1, @NotNull TypeConstructorMarker paramTypeConstructorMarker2);
  
  public final void clear()
  {
    Object localObject = this.supertypesDeque;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((ArrayDeque)localObject).clear();
    localObject = this.supertypesSet;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((Set)localObject).clear();
    this.supertypesLocked = false;
  }
  
  @Nullable
  public List<SimpleTypeMarker> fastCorrespondingSupertypes(@NotNull SimpleTypeMarker paramSimpleTypeMarker, @NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$fastCorrespondingSupertypes");
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "constructor");
    return TypeSystemContext.DefaultImpls.fastCorrespondingSupertypes(this, paramSimpleTypeMarker, paramTypeConstructorMarker);
  }
  
  @NotNull
  public TypeArgumentMarker get(@NotNull TypeArgumentListMarker paramTypeArgumentListMarker, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeArgumentListMarker, "$this$get");
    return TypeSystemContext.DefaultImpls.get(this, paramTypeArgumentListMarker, paramInt);
  }
  
  @Nullable
  public TypeArgumentMarker getArgumentOrNull(@NotNull SimpleTypeMarker paramSimpleTypeMarker, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$getArgumentOrNull");
    return TypeSystemContext.DefaultImpls.getArgumentOrNull(this, paramSimpleTypeMarker, paramInt);
  }
  
  @NotNull
  public AbstractTypeCheckerContext.LowerCapturedTypePolicy getLowerCapturedTypePolicy(@NotNull SimpleTypeMarker paramSimpleTypeMarker, @NotNull CapturedTypeMarker paramCapturedTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "subType");
    Intrinsics.checkParameterIsNotNull(paramCapturedTypeMarker, "superType");
    return AbstractTypeCheckerContext.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER;
  }
  
  @Nullable
  public final ArrayDeque<SimpleTypeMarker> getSupertypesDeque()
  {
    return this.supertypesDeque;
  }
  
  @Nullable
  public final Set<SimpleTypeMarker> getSupertypesSet()
  {
    return this.supertypesSet;
  }
  
  public boolean hasFlexibleNullability(@NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$hasFlexibleNullability");
    return TypeSystemContext.DefaultImpls.hasFlexibleNullability(this, paramKotlinTypeMarker);
  }
  
  public boolean identicalArguments(@NotNull SimpleTypeMarker paramSimpleTypeMarker1, @NotNull SimpleTypeMarker paramSimpleTypeMarker2)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker1, "a");
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker2, "b");
    return TypeSystemContext.DefaultImpls.identicalArguments(this, paramSimpleTypeMarker1, paramSimpleTypeMarker2);
  }
  
  public final void initialize()
  {
    boolean bool = this.supertypesLocked;
    if ((_Assertions.ENABLED) && (!(bool ^ true))) {
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
    this.supertypesLocked = true;
    if (this.supertypesDeque == null) {
      this.supertypesDeque = new ArrayDeque(4);
    }
    if (this.supertypesSet == null) {
      this.supertypesSet = ((Set)SmartSet.Companion.create());
    }
  }
  
  public abstract boolean isAllowedTypeVariable(@NotNull KotlinTypeMarker paramKotlinTypeMarker);
  
  public boolean isClassType(@NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$isClassType");
    return TypeSystemContext.DefaultImpls.isClassType(this, paramSimpleTypeMarker);
  }
  
  public boolean isDefinitelyNotNullType(@NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$isDefinitelyNotNullType");
    return TypeSystemContext.DefaultImpls.isDefinitelyNotNullType(this, paramKotlinTypeMarker);
  }
  
  public boolean isDynamic(@NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$isDynamic");
    return TypeSystemContext.DefaultImpls.isDynamic(this, paramKotlinTypeMarker);
  }
  
  public abstract boolean isErrorTypeEqualsToAnything();
  
  public boolean isIntegerLiteralType(@NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$isIntegerLiteralType");
    return TypeSystemContext.DefaultImpls.isIntegerLiteralType(this, paramSimpleTypeMarker);
  }
  
  public boolean isNothing(@NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$isNothing");
    return TypeSystemContext.DefaultImpls.isNothing(this, paramKotlinTypeMarker);
  }
  
  public abstract boolean isStubTypeEqualsToAnything();
  
  @NotNull
  public SimpleTypeMarker lowerBoundIfFlexible(@NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$lowerBoundIfFlexible");
    return TypeSystemContext.DefaultImpls.lowerBoundIfFlexible(this, paramKotlinTypeMarker);
  }
  
  @NotNull
  public KotlinTypeMarker prepareType(@NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "type");
    return paramKotlinTypeMarker;
  }
  
  @NotNull
  public KotlinTypeMarker refineType(@NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "type");
    return paramKotlinTypeMarker;
  }
  
  public int size(@NotNull TypeArgumentListMarker paramTypeArgumentListMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeArgumentListMarker, "$this$size");
    return TypeSystemContext.DefaultImpls.size(this, paramTypeArgumentListMarker);
  }
  
  @NotNull
  public abstract AbstractTypeCheckerContext.SupertypesPolicy substitutionSupertypePolicy(@NotNull SimpleTypeMarker paramSimpleTypeMarker);
  
  @NotNull
  public TypeConstructorMarker typeConstructor(@NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$typeConstructor");
    return TypeSystemContext.DefaultImpls.typeConstructor(this, paramKotlinTypeMarker);
  }
  
  @NotNull
  public SimpleTypeMarker upperBoundIfFlexible(@NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$upperBoundIfFlexible");
    return TypeSystemContext.DefaultImpls.upperBoundIfFlexible(this, paramKotlinTypeMarker);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext
 * JD-Core Version:    0.7.0.1
 */
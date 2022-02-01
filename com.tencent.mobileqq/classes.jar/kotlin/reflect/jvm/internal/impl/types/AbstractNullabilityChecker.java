package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import org.jetbrains.annotations.NotNull;

public final class AbstractNullabilityChecker
{
  public static final AbstractNullabilityChecker INSTANCE = new AbstractNullabilityChecker();
  
  private final boolean isApplicableAsEndNode(@NotNull AbstractTypeCheckerContext paramAbstractTypeCheckerContext, SimpleTypeMarker paramSimpleTypeMarker, TypeConstructorMarker paramTypeConstructorMarker)
  {
    if (paramAbstractTypeCheckerContext.isNothing((KotlinTypeMarker)paramSimpleTypeMarker)) {
      return true;
    }
    if (paramAbstractTypeCheckerContext.isMarkedNullable(paramSimpleTypeMarker)) {
      return false;
    }
    if ((paramAbstractTypeCheckerContext.isStubTypeEqualsToAnything()) && (paramAbstractTypeCheckerContext.isStubType(paramSimpleTypeMarker))) {
      return true;
    }
    return paramAbstractTypeCheckerContext.isEqualTypeConstructors(paramAbstractTypeCheckerContext.typeConstructor(paramSimpleTypeMarker), paramTypeConstructorMarker);
  }
  
  private final boolean runIsPossibleSubtype(@NotNull AbstractTypeCheckerContext paramAbstractTypeCheckerContext, SimpleTypeMarker paramSimpleTypeMarker1, SimpleTypeMarker paramSimpleTypeMarker2)
  {
    if (AbstractTypeChecker.RUN_SLOW_ASSERTIONS)
    {
      int i;
      if ((!paramAbstractTypeCheckerContext.isSingleClassifierType(paramSimpleTypeMarker1)) && (!paramAbstractTypeCheckerContext.isIntersection(paramAbstractTypeCheckerContext.typeConstructor(paramSimpleTypeMarker1))) && (!paramAbstractTypeCheckerContext.isAllowedTypeVariable((KotlinTypeMarker)paramSimpleTypeMarker1))) {
        i = 0;
      } else {
        i = 1;
      }
      if ((_Assertions.ENABLED) && (i == 0))
      {
        paramAbstractTypeCheckerContext = new StringBuilder();
        paramAbstractTypeCheckerContext.append("Not singleClassifierType and not intersection subType: ");
        paramAbstractTypeCheckerContext.append(paramSimpleTypeMarker1);
        throw ((Throwable)new AssertionError(paramAbstractTypeCheckerContext.toString()));
      }
      if ((!paramAbstractTypeCheckerContext.isSingleClassifierType(paramSimpleTypeMarker2)) && (!paramAbstractTypeCheckerContext.isAllowedTypeVariable((KotlinTypeMarker)paramSimpleTypeMarker2))) {
        i = 0;
      } else {
        i = 1;
      }
      if ((_Assertions.ENABLED) && (i == 0))
      {
        paramAbstractTypeCheckerContext = new StringBuilder();
        paramAbstractTypeCheckerContext.append("Not singleClassifierType superType: ");
        paramAbstractTypeCheckerContext.append(paramSimpleTypeMarker2);
        throw ((Throwable)new AssertionError(paramAbstractTypeCheckerContext.toString()));
      }
    }
    if (paramAbstractTypeCheckerContext.isMarkedNullable(paramSimpleTypeMarker2)) {
      return true;
    }
    if (paramAbstractTypeCheckerContext.isDefinitelyNotNullType((KotlinTypeMarker)paramSimpleTypeMarker1)) {
      return true;
    }
    if (hasNotNullSupertype(paramAbstractTypeCheckerContext, paramSimpleTypeMarker1, (AbstractTypeCheckerContext.SupertypesPolicy)AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE)) {
      return true;
    }
    if (paramAbstractTypeCheckerContext.isDefinitelyNotNullType((KotlinTypeMarker)paramSimpleTypeMarker2)) {
      return false;
    }
    if (hasNotNullSupertype(paramAbstractTypeCheckerContext, paramSimpleTypeMarker2, (AbstractTypeCheckerContext.SupertypesPolicy)AbstractTypeCheckerContext.SupertypesPolicy.UpperIfFlexible.INSTANCE)) {
      return false;
    }
    if (paramAbstractTypeCheckerContext.isClassType(paramSimpleTypeMarker1)) {
      return false;
    }
    return hasPathByNotMarkedNullableNodes(paramAbstractTypeCheckerContext, paramSimpleTypeMarker1, paramAbstractTypeCheckerContext.typeConstructor(paramSimpleTypeMarker2));
  }
  
  public final boolean hasNotNullSupertype(@NotNull AbstractTypeCheckerContext paramAbstractTypeCheckerContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker, @NotNull AbstractTypeCheckerContext.SupertypesPolicy paramSupertypesPolicy)
  {
    Intrinsics.checkParameterIsNotNull(paramAbstractTypeCheckerContext, "$this$hasNotNullSupertype");
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "type");
    Intrinsics.checkParameterIsNotNull(paramSupertypesPolicy, "supertypesPolicy");
    int i;
    if (((paramAbstractTypeCheckerContext.isClassType(paramSimpleTypeMarker)) && (!paramAbstractTypeCheckerContext.isMarkedNullable(paramSimpleTypeMarker))) || (paramAbstractTypeCheckerContext.isDefinitelyNotNullType((KotlinTypeMarker)paramSimpleTypeMarker))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return true;
    }
    paramAbstractTypeCheckerContext.initialize();
    ArrayDeque localArrayDeque = paramAbstractTypeCheckerContext.getSupertypesDeque();
    if (localArrayDeque == null) {
      Intrinsics.throwNpe();
    }
    Set localSet = paramAbstractTypeCheckerContext.getSupertypesSet();
    if (localSet == null) {
      Intrinsics.throwNpe();
    }
    localArrayDeque.push(paramSimpleTypeMarker);
    while ((((Collection)localArrayDeque).isEmpty() ^ true)) {
      if (localSet.size() <= 1000)
      {
        Object localObject = (SimpleTypeMarker)localArrayDeque.pop();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "current");
        if (localSet.add(localObject))
        {
          AbstractTypeCheckerContext.SupertypesPolicy localSupertypesPolicy;
          if (paramAbstractTypeCheckerContext.isMarkedNullable((SimpleTypeMarker)localObject)) {
            localSupertypesPolicy = (AbstractTypeCheckerContext.SupertypesPolicy)AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE;
          } else {
            localSupertypesPolicy = paramSupertypesPolicy;
          }
          if (!(Intrinsics.areEqual(localSupertypesPolicy, AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE) ^ true)) {
            localSupertypesPolicy = null;
          }
          if (localSupertypesPolicy != null)
          {
            localObject = paramAbstractTypeCheckerContext.supertypes(paramAbstractTypeCheckerContext.typeConstructor((SimpleTypeMarker)localObject)).iterator();
            while (((Iterator)localObject).hasNext())
            {
              SimpleTypeMarker localSimpleTypeMarker = localSupertypesPolicy.transformType(paramAbstractTypeCheckerContext, (KotlinTypeMarker)((Iterator)localObject).next());
              if (((paramAbstractTypeCheckerContext.isClassType(localSimpleTypeMarker)) && (!paramAbstractTypeCheckerContext.isMarkedNullable(localSimpleTypeMarker))) || (paramAbstractTypeCheckerContext.isDefinitelyNotNullType((KotlinTypeMarker)localSimpleTypeMarker))) {
                i = 1;
              } else {
                i = 0;
              }
              if (i != 0)
              {
                paramAbstractTypeCheckerContext.clear();
                return true;
              }
              localArrayDeque.add(localSimpleTypeMarker);
            }
          }
        }
      }
      else
      {
        paramAbstractTypeCheckerContext = new StringBuilder();
        paramAbstractTypeCheckerContext.append("Too many supertypes for type: ");
        paramAbstractTypeCheckerContext.append(paramSimpleTypeMarker);
        paramAbstractTypeCheckerContext.append(". Supertypes = ");
        paramAbstractTypeCheckerContext.append(CollectionsKt.joinToString$default((Iterable)localSet, null, null, null, 0, null, null, 63, null));
        throw ((Throwable)new IllegalStateException(paramAbstractTypeCheckerContext.toString().toString()));
      }
    }
    paramAbstractTypeCheckerContext.clear();
    return false;
  }
  
  public final boolean hasPathByNotMarkedNullableNodes(@NotNull AbstractTypeCheckerContext paramAbstractTypeCheckerContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker, @NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramAbstractTypeCheckerContext, "$this$hasPathByNotMarkedNullableNodes");
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "start");
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "end");
    if (INSTANCE.isApplicableAsEndNode(paramAbstractTypeCheckerContext, paramSimpleTypeMarker, paramTypeConstructorMarker)) {
      return true;
    }
    paramAbstractTypeCheckerContext.initialize();
    ArrayDeque localArrayDeque = paramAbstractTypeCheckerContext.getSupertypesDeque();
    if (localArrayDeque == null) {
      Intrinsics.throwNpe();
    }
    Set localSet = paramAbstractTypeCheckerContext.getSupertypesSet();
    if (localSet == null) {
      Intrinsics.throwNpe();
    }
    localArrayDeque.push(paramSimpleTypeMarker);
    while ((((Collection)localArrayDeque).isEmpty() ^ true)) {
      if (localSet.size() <= 1000)
      {
        Object localObject2 = (SimpleTypeMarker)localArrayDeque.pop();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "current");
        if (localSet.add(localObject2))
        {
          if (paramAbstractTypeCheckerContext.isMarkedNullable((SimpleTypeMarker)localObject2)) {
            localObject1 = AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE;
          } else {
            localObject1 = AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
          }
          Object localObject1 = (AbstractTypeCheckerContext.SupertypesPolicy)localObject1;
          if (!(Intrinsics.areEqual(localObject1, AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE) ^ true)) {
            localObject1 = null;
          }
          if (localObject1 != null)
          {
            localObject2 = paramAbstractTypeCheckerContext.supertypes(paramAbstractTypeCheckerContext.typeConstructor((SimpleTypeMarker)localObject2)).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              SimpleTypeMarker localSimpleTypeMarker = ((AbstractTypeCheckerContext.SupertypesPolicy)localObject1).transformType(paramAbstractTypeCheckerContext, (KotlinTypeMarker)((Iterator)localObject2).next());
              if (INSTANCE.isApplicableAsEndNode(paramAbstractTypeCheckerContext, localSimpleTypeMarker, paramTypeConstructorMarker))
              {
                paramAbstractTypeCheckerContext.clear();
                return true;
              }
              localArrayDeque.add(localSimpleTypeMarker);
            }
          }
        }
      }
      else
      {
        paramAbstractTypeCheckerContext = new StringBuilder();
        paramAbstractTypeCheckerContext.append("Too many supertypes for type: ");
        paramAbstractTypeCheckerContext.append(paramSimpleTypeMarker);
        paramAbstractTypeCheckerContext.append(". Supertypes = ");
        paramAbstractTypeCheckerContext.append(CollectionsKt.joinToString$default((Iterable)localSet, null, null, null, 0, null, null, 63, null));
        throw ((Throwable)new IllegalStateException(paramAbstractTypeCheckerContext.toString().toString()));
      }
    }
    paramAbstractTypeCheckerContext.clear();
    return false;
  }
  
  public final boolean isPossibleSubtype(@NotNull AbstractTypeCheckerContext paramAbstractTypeCheckerContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker1, @NotNull SimpleTypeMarker paramSimpleTypeMarker2)
  {
    Intrinsics.checkParameterIsNotNull(paramAbstractTypeCheckerContext, "context");
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker1, "subType");
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker2, "superType");
    return runIsPossibleSubtype(paramAbstractTypeCheckerContext, paramSimpleTypeMarker1, paramSimpleTypeMarker2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.AbstractNullabilityChecker
 * JD-Core Version:    0.7.0.1
 */
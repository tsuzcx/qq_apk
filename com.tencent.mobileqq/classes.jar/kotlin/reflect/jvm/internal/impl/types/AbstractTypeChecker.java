package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AbstractTypeChecker
{
  public static final AbstractTypeChecker INSTANCE = new AbstractTypeChecker();
  @JvmField
  public static boolean RUN_SLOW_ASSERTIONS;
  
  private final Boolean checkSubtypeForIntegerLiteralType(@NotNull AbstractTypeCheckerContext paramAbstractTypeCheckerContext, SimpleTypeMarker paramSimpleTypeMarker1, SimpleTypeMarker paramSimpleTypeMarker2)
  {
    if ((!paramAbstractTypeCheckerContext.isIntegerLiteralType(paramSimpleTypeMarker1)) && (!paramAbstractTypeCheckerContext.isIntegerLiteralType(paramSimpleTypeMarker2))) {
      return null;
    }
    AbstractTypeChecker.checkSubtypeForIntegerLiteralType.1 local1 = new AbstractTypeChecker.checkSubtypeForIntegerLiteralType.1(paramAbstractTypeCheckerContext);
    if ((paramAbstractTypeCheckerContext.isIntegerLiteralType(paramSimpleTypeMarker1)) && (paramAbstractTypeCheckerContext.isIntegerLiteralType(paramSimpleTypeMarker2))) {
      return Boolean.valueOf(true);
    }
    if (paramAbstractTypeCheckerContext.isIntegerLiteralType(paramSimpleTypeMarker1))
    {
      if (local1.invoke(paramSimpleTypeMarker1, paramSimpleTypeMarker2, false)) {
        return Boolean.valueOf(true);
      }
    }
    else if ((paramAbstractTypeCheckerContext.isIntegerLiteralType(paramSimpleTypeMarker2)) && (local1.invoke(paramSimpleTypeMarker2, paramSimpleTypeMarker1, true))) {
      return Boolean.valueOf(true);
    }
    return null;
  }
  
  private final Boolean checkSubtypeForSpecialCases(@NotNull AbstractTypeCheckerContext paramAbstractTypeCheckerContext, SimpleTypeMarker paramSimpleTypeMarker1, SimpleTypeMarker paramSimpleTypeMarker2)
  {
    KotlinTypeMarker localKotlinTypeMarker2 = (KotlinTypeMarker)paramSimpleTypeMarker1;
    boolean bool1 = paramAbstractTypeCheckerContext.isError(localKotlinTypeMarker2);
    boolean bool2 = true;
    Boolean localBoolean = Boolean.valueOf(true);
    if ((!bool1) && (!paramAbstractTypeCheckerContext.isError((KotlinTypeMarker)paramSimpleTypeMarker2)))
    {
      if ((!paramAbstractTypeCheckerContext.isStubType(paramSimpleTypeMarker1)) && (!paramAbstractTypeCheckerContext.isStubType(paramSimpleTypeMarker2)))
      {
        CapturedTypeMarker localCapturedTypeMarker = paramAbstractTypeCheckerContext.asCapturedType(paramSimpleTypeMarker2);
        KotlinTypeMarker localKotlinTypeMarker1;
        if (localCapturedTypeMarker != null) {
          localKotlinTypeMarker1 = paramAbstractTypeCheckerContext.lowerType(localCapturedTypeMarker);
        } else {
          localKotlinTypeMarker1 = null;
        }
        if ((localCapturedTypeMarker != null) && (localKotlinTypeMarker1 != null))
        {
          paramSimpleTypeMarker1 = paramAbstractTypeCheckerContext.getLowerCapturedTypePolicy(paramSimpleTypeMarker1, localCapturedTypeMarker);
          int i = AbstractTypeChecker.WhenMappings.$EnumSwitchMapping$1[paramSimpleTypeMarker1.ordinal()];
          if (i != 1)
          {
            if ((i == 2) && (isSubtypeOf(paramAbstractTypeCheckerContext, localKotlinTypeMarker2, localKotlinTypeMarker1))) {
              return localBoolean;
            }
          }
          else {
            return Boolean.valueOf(isSubtypeOf(paramAbstractTypeCheckerContext, localKotlinTypeMarker2, localKotlinTypeMarker1));
          }
        }
        paramSimpleTypeMarker1 = paramAbstractTypeCheckerContext.typeConstructor(paramSimpleTypeMarker2);
        if (paramAbstractTypeCheckerContext.isIntersection(paramSimpleTypeMarker1))
        {
          bool1 = paramAbstractTypeCheckerContext.isMarkedNullable(paramSimpleTypeMarker2);
          if ((_Assertions.ENABLED) && (!(bool1 ^ true)))
          {
            paramAbstractTypeCheckerContext = new StringBuilder();
            paramAbstractTypeCheckerContext.append("Intersection type should not be marked nullable!: ");
            paramAbstractTypeCheckerContext.append(paramSimpleTypeMarker2);
            throw ((Throwable)new AssertionError(paramAbstractTypeCheckerContext.toString()));
          }
          paramSimpleTypeMarker1 = (Iterable)paramAbstractTypeCheckerContext.supertypes(paramSimpleTypeMarker1);
          if (((paramSimpleTypeMarker1 instanceof Collection)) && (((Collection)paramSimpleTypeMarker1).isEmpty()))
          {
            bool1 = bool2;
          }
          else
          {
            paramSimpleTypeMarker1 = paramSimpleTypeMarker1.iterator();
            do
            {
              bool1 = bool2;
              if (!paramSimpleTypeMarker1.hasNext()) {
                break;
              }
              paramSimpleTypeMarker2 = (KotlinTypeMarker)paramSimpleTypeMarker1.next();
            } while (INSTANCE.isSubtypeOf(paramAbstractTypeCheckerContext, localKotlinTypeMarker2, paramSimpleTypeMarker2));
            bool1 = false;
          }
          return Boolean.valueOf(bool1);
        }
        return null;
      }
      return Boolean.valueOf(paramAbstractTypeCheckerContext.isStubTypeEqualsToAnything());
    }
    if (paramAbstractTypeCheckerContext.isErrorTypeEqualsToAnything()) {
      return localBoolean;
    }
    if ((paramAbstractTypeCheckerContext.isMarkedNullable(paramSimpleTypeMarker1)) && (!paramAbstractTypeCheckerContext.isMarkedNullable(paramSimpleTypeMarker2))) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes((TypeSystemContext)paramAbstractTypeCheckerContext, (KotlinTypeMarker)paramAbstractTypeCheckerContext.withNullability(paramSimpleTypeMarker1, false), (KotlinTypeMarker)paramAbstractTypeCheckerContext.withNullability(paramSimpleTypeMarker2, false)));
  }
  
  private final List<SimpleTypeMarker> collectAllSupertypesWithGivenTypeConstructor(@NotNull AbstractTypeCheckerContext paramAbstractTypeCheckerContext, SimpleTypeMarker paramSimpleTypeMarker, TypeConstructorMarker paramTypeConstructorMarker)
  {
    Object localObject1 = paramAbstractTypeCheckerContext.fastCorrespondingSupertypes(paramSimpleTypeMarker, paramTypeConstructorMarker);
    if (localObject1 != null) {
      return localObject1;
    }
    if ((!paramAbstractTypeCheckerContext.isClassTypeConstructor(paramTypeConstructorMarker)) && (paramAbstractTypeCheckerContext.isClassType(paramSimpleTypeMarker))) {
      return CollectionsKt.emptyList();
    }
    if (paramAbstractTypeCheckerContext.isCommonFinalClassConstructor(paramTypeConstructorMarker))
    {
      if (paramAbstractTypeCheckerContext.areEqualTypeConstructors(paramAbstractTypeCheckerContext.typeConstructor(paramSimpleTypeMarker), paramTypeConstructorMarker))
      {
        paramAbstractTypeCheckerContext = paramAbstractTypeCheckerContext.captureFromArguments(paramSimpleTypeMarker, CaptureStatus.FOR_SUBTYPING);
        if (paramAbstractTypeCheckerContext != null) {
          paramSimpleTypeMarker = paramAbstractTypeCheckerContext;
        }
        return CollectionsKt.listOf(paramSimpleTypeMarker);
      }
      return CollectionsKt.emptyList();
    }
    List localList = (List)new SmartList();
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
          localObject1 = paramAbstractTypeCheckerContext.captureFromArguments((SimpleTypeMarker)localObject2, CaptureStatus.FOR_SUBTYPING);
          if (localObject1 == null) {
            localObject1 = localObject2;
          }
          if (paramAbstractTypeCheckerContext.areEqualTypeConstructors(paramAbstractTypeCheckerContext.typeConstructor((SimpleTypeMarker)localObject1), paramTypeConstructorMarker))
          {
            localList.add(localObject1);
            localObject1 = (AbstractTypeCheckerContext.SupertypesPolicy)AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE;
          }
          else if (paramAbstractTypeCheckerContext.argumentsCount((KotlinTypeMarker)localObject1) == 0)
          {
            localObject1 = (AbstractTypeCheckerContext.SupertypesPolicy)AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
          }
          else
          {
            localObject1 = paramAbstractTypeCheckerContext.substitutionSupertypePolicy((SimpleTypeMarker)localObject1);
          }
          if (!(Intrinsics.areEqual(localObject1, AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE) ^ true)) {
            localObject1 = null;
          }
          if (localObject1 != null)
          {
            localObject2 = paramAbstractTypeCheckerContext.supertypes(paramAbstractTypeCheckerContext.typeConstructor((SimpleTypeMarker)localObject2)).iterator();
            while (((Iterator)localObject2).hasNext()) {
              localArrayDeque.add(((AbstractTypeCheckerContext.SupertypesPolicy)localObject1).transformType(paramAbstractTypeCheckerContext, (KotlinTypeMarker)((Iterator)localObject2).next()));
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
    return localList;
  }
  
  private final List<SimpleTypeMarker> collectAndFilter(@NotNull AbstractTypeCheckerContext paramAbstractTypeCheckerContext, SimpleTypeMarker paramSimpleTypeMarker, TypeConstructorMarker paramTypeConstructorMarker)
  {
    return selectOnlyPureKotlinSupertypes(paramAbstractTypeCheckerContext, collectAllSupertypesWithGivenTypeConstructor(paramAbstractTypeCheckerContext, paramSimpleTypeMarker, paramTypeConstructorMarker));
  }
  
  private final boolean completeIsSubTypeOf(@NotNull AbstractTypeCheckerContext paramAbstractTypeCheckerContext, KotlinTypeMarker paramKotlinTypeMarker1, KotlinTypeMarker paramKotlinTypeMarker2)
  {
    Boolean localBoolean = checkSubtypeForSpecialCases(paramAbstractTypeCheckerContext, paramAbstractTypeCheckerContext.lowerBoundIfFlexible(paramKotlinTypeMarker1), paramAbstractTypeCheckerContext.upperBoundIfFlexible(paramKotlinTypeMarker2));
    if (localBoolean != null)
    {
      boolean bool = localBoolean.booleanValue();
      paramAbstractTypeCheckerContext.addSubtypeConstraint(paramKotlinTypeMarker1, paramKotlinTypeMarker2);
      return bool;
    }
    localBoolean = paramAbstractTypeCheckerContext.addSubtypeConstraint(paramKotlinTypeMarker1, paramKotlinTypeMarker2);
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    return isSubtypeOfForSingleClassifierType(paramAbstractTypeCheckerContext, paramAbstractTypeCheckerContext.lowerBoundIfFlexible(paramKotlinTypeMarker1), paramAbstractTypeCheckerContext.upperBoundIfFlexible(paramKotlinTypeMarker2));
  }
  
  private final boolean hasNothingSupertype(@NotNull AbstractTypeCheckerContext paramAbstractTypeCheckerContext, SimpleTypeMarker paramSimpleTypeMarker)
  {
    Object localObject1 = paramAbstractTypeCheckerContext.typeConstructor(paramSimpleTypeMarker);
    if (paramAbstractTypeCheckerContext.isClassTypeConstructor((TypeConstructorMarker)localObject1)) {
      return paramAbstractTypeCheckerContext.isNothingConstructor((TypeConstructorMarker)localObject1);
    }
    if (paramAbstractTypeCheckerContext.isNothingConstructor(paramAbstractTypeCheckerContext.typeConstructor(paramSimpleTypeMarker))) {
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
          if (paramAbstractTypeCheckerContext.isClassType((SimpleTypeMarker)localObject2)) {
            localObject1 = (AbstractTypeCheckerContext.SupertypesPolicy)AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE;
          } else {
            localObject1 = (AbstractTypeCheckerContext.SupertypesPolicy)AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
          }
          if (!(Intrinsics.areEqual(localObject1, AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE) ^ true)) {
            localObject1 = null;
          }
          if (localObject1 != null)
          {
            localObject2 = paramAbstractTypeCheckerContext.supertypes(paramAbstractTypeCheckerContext.typeConstructor((SimpleTypeMarker)localObject2)).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              SimpleTypeMarker localSimpleTypeMarker = ((AbstractTypeCheckerContext.SupertypesPolicy)localObject1).transformType(paramAbstractTypeCheckerContext, (KotlinTypeMarker)((Iterator)localObject2).next());
              if (paramAbstractTypeCheckerContext.isNothingConstructor(paramAbstractTypeCheckerContext.typeConstructor(localSimpleTypeMarker)))
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
  
  private final boolean isCommonDenotableType(@NotNull AbstractTypeCheckerContext paramAbstractTypeCheckerContext, KotlinTypeMarker paramKotlinTypeMarker)
  {
    return (paramAbstractTypeCheckerContext.isDenotable(paramAbstractTypeCheckerContext.typeConstructor(paramKotlinTypeMarker))) && (!paramAbstractTypeCheckerContext.isDynamic(paramKotlinTypeMarker)) && (!paramAbstractTypeCheckerContext.isDefinitelyNotNullType(paramKotlinTypeMarker)) && (Intrinsics.areEqual(paramAbstractTypeCheckerContext.typeConstructor(paramAbstractTypeCheckerContext.lowerBoundIfFlexible(paramKotlinTypeMarker)), paramAbstractTypeCheckerContext.typeConstructor(paramAbstractTypeCheckerContext.upperBoundIfFlexible(paramKotlinTypeMarker))));
  }
  
  private final boolean isSubtypeOfForSingleClassifierType(@NotNull AbstractTypeCheckerContext paramAbstractTypeCheckerContext, SimpleTypeMarker paramSimpleTypeMarker1, SimpleTypeMarker paramSimpleTypeMarker2)
  {
    if (RUN_SLOW_ASSERTIONS)
    {
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
    if (!AbstractNullabilityChecker.INSTANCE.isPossibleSubtype(paramAbstractTypeCheckerContext, paramSimpleTypeMarker1, paramSimpleTypeMarker2)) {
      return false;
    }
    Object localObject1 = (KotlinTypeMarker)paramSimpleTypeMarker1;
    Object localObject3 = paramAbstractTypeCheckerContext.lowerBoundIfFlexible((KotlinTypeMarker)localObject1);
    Object localObject2 = (KotlinTypeMarker)paramSimpleTypeMarker2;
    localObject3 = checkSubtypeForIntegerLiteralType(paramAbstractTypeCheckerContext, (SimpleTypeMarker)localObject3, paramAbstractTypeCheckerContext.upperBoundIfFlexible((KotlinTypeMarker)localObject2));
    if (localObject3 != null)
    {
      boolean bool = ((Boolean)localObject3).booleanValue();
      paramAbstractTypeCheckerContext.addSubtypeConstraint((KotlinTypeMarker)localObject1, (KotlinTypeMarker)localObject2);
      return bool;
    }
    localObject2 = paramAbstractTypeCheckerContext.typeConstructor(paramSimpleTypeMarker2);
    if ((paramAbstractTypeCheckerContext.isEqualTypeConstructors(paramAbstractTypeCheckerContext.typeConstructor(paramSimpleTypeMarker1), (TypeConstructorMarker)localObject2)) && (paramAbstractTypeCheckerContext.parametersCount((TypeConstructorMarker)localObject2) == 0)) {
      return true;
    }
    if (paramAbstractTypeCheckerContext.isAnyConstructor(paramAbstractTypeCheckerContext.typeConstructor(paramSimpleTypeMarker2))) {
      return true;
    }
    localObject3 = findCorrespondingSupertypes(paramAbstractTypeCheckerContext, paramSimpleTypeMarker1, (TypeConstructorMarker)localObject2);
    int i = ((List)localObject3).size();
    if (i != 0)
    {
      if (i != 1)
      {
        ArgumentList localArgumentList = new ArgumentList(paramAbstractTypeCheckerContext.parametersCount((TypeConstructorMarker)localObject2));
        int m = paramAbstractTypeCheckerContext.parametersCount((TypeConstructorMarker)localObject2);
        int j = 0;
        i = 0;
        while (j < m)
        {
          if ((i == 0) && (paramAbstractTypeCheckerContext.getVariance(paramAbstractTypeCheckerContext.getParameter((TypeConstructorMarker)localObject2, j)) == TypeVariance.OUT)) {
            i = 0;
          } else {
            i = 1;
          }
          if (i == 0)
          {
            localObject1 = (Iterable)localObject3;
            Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
            Iterator localIterator = ((Iterable)localObject1).iterator();
            while (localIterator.hasNext())
            {
              SimpleTypeMarker localSimpleTypeMarker = (SimpleTypeMarker)localIterator.next();
              localObject1 = paramAbstractTypeCheckerContext.getArgumentOrNull(localSimpleTypeMarker, j);
              if (localObject1 != null)
              {
                int k;
                if (paramAbstractTypeCheckerContext.getVariance((TypeArgumentMarker)localObject1) == TypeVariance.INV) {
                  k = 1;
                } else {
                  k = 0;
                }
                if (k == 0) {
                  localObject1 = null;
                }
                if (localObject1 != null)
                {
                  localObject1 = paramAbstractTypeCheckerContext.getType((TypeArgumentMarker)localObject1);
                  if (localObject1 != null)
                  {
                    localCollection.add(localObject1);
                    continue;
                  }
                }
              }
              paramAbstractTypeCheckerContext = new StringBuilder();
              paramAbstractTypeCheckerContext.append("Incorrect type: ");
              paramAbstractTypeCheckerContext.append(localSimpleTypeMarker);
              paramAbstractTypeCheckerContext.append(", subType: ");
              paramAbstractTypeCheckerContext.append(paramSimpleTypeMarker1);
              paramAbstractTypeCheckerContext.append(", superType: ");
              paramAbstractTypeCheckerContext.append(paramSimpleTypeMarker2);
              throw ((Throwable)new IllegalStateException(paramAbstractTypeCheckerContext.toString().toString()));
            }
            localArgumentList.add(paramAbstractTypeCheckerContext.asTypeArgument(paramAbstractTypeCheckerContext.intersectTypes((List)localCollection)));
          }
          j += 1;
        }
        if ((i == 0) && (isSubtypeForSameConstructor(paramAbstractTypeCheckerContext, (TypeArgumentListMarker)localArgumentList, paramSimpleTypeMarker2))) {
          return true;
        }
        paramSimpleTypeMarker1 = (Iterable)localObject3;
        if (((paramSimpleTypeMarker1 instanceof Collection)) && (((Collection)paramSimpleTypeMarker1).isEmpty())) {}
        do
        {
          while (!paramSimpleTypeMarker1.hasNext())
          {
            return false;
            paramSimpleTypeMarker1 = paramSimpleTypeMarker1.iterator();
          }
          localObject1 = (SimpleTypeMarker)paramSimpleTypeMarker1.next();
        } while (!INSTANCE.isSubtypeForSameConstructor(paramAbstractTypeCheckerContext, paramAbstractTypeCheckerContext.asArgumentList((SimpleTypeMarker)localObject1), paramSimpleTypeMarker2));
        return true;
      }
      return isSubtypeForSameConstructor(paramAbstractTypeCheckerContext, paramAbstractTypeCheckerContext.asArgumentList((SimpleTypeMarker)CollectionsKt.first((List)localObject3)), paramSimpleTypeMarker2);
    }
    return hasNothingSupertype(paramAbstractTypeCheckerContext, paramSimpleTypeMarker1);
  }
  
  private final List<SimpleTypeMarker> selectOnlyPureKotlinSupertypes(@NotNull AbstractTypeCheckerContext paramAbstractTypeCheckerContext, List<? extends SimpleTypeMarker> paramList)
  {
    if (paramList.size() < 2) {
      return paramList;
    }
    Object localObject1 = (Iterable)paramList;
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    for (;;)
    {
      boolean bool = ((Iterator)localObject1).hasNext();
      int k = 1;
      if (!bool) {
        break;
      }
      Object localObject2 = ((Iterator)localObject1).next();
      TypeArgumentListMarker localTypeArgumentListMarker = paramAbstractTypeCheckerContext.asArgumentList((SimpleTypeMarker)localObject2);
      TypeSystemContext localTypeSystemContext = (TypeSystemContext)paramAbstractTypeCheckerContext;
      int m = localTypeSystemContext.size(localTypeArgumentListMarker);
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        if (paramAbstractTypeCheckerContext.asFlexibleType(paramAbstractTypeCheckerContext.getType(localTypeSystemContext.get(localTypeArgumentListMarker, i))) == null) {
          j = 1;
        } else {
          j = 0;
        }
        if (j == 0)
        {
          j = 0;
          break;
        }
        i += 1;
      }
      if (j != 0) {
        localCollection.add(localObject2);
      }
    }
    paramAbstractTypeCheckerContext = (List)localCollection;
    if ((((Collection)paramAbstractTypeCheckerContext).isEmpty() ^ true)) {
      return paramAbstractTypeCheckerContext;
    }
    return paramList;
  }
  
  @Nullable
  public final TypeVariance effectiveVariance(@NotNull TypeVariance paramTypeVariance1, @NotNull TypeVariance paramTypeVariance2)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeVariance1, "declared");
    Intrinsics.checkParameterIsNotNull(paramTypeVariance2, "useSite");
    if (paramTypeVariance1 == TypeVariance.INV) {
      return paramTypeVariance2;
    }
    if (paramTypeVariance2 == TypeVariance.INV) {
      return paramTypeVariance1;
    }
    if (paramTypeVariance1 == paramTypeVariance2) {
      return paramTypeVariance1;
    }
    return null;
  }
  
  public final boolean equalTypes(@NotNull AbstractTypeCheckerContext paramAbstractTypeCheckerContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker1, @NotNull KotlinTypeMarker paramKotlinTypeMarker2)
  {
    Intrinsics.checkParameterIsNotNull(paramAbstractTypeCheckerContext, "context");
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker1, "a");
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker2, "b");
    boolean bool = true;
    if (paramKotlinTypeMarker1 == paramKotlinTypeMarker2) {
      return true;
    }
    if ((INSTANCE.isCommonDenotableType(paramAbstractTypeCheckerContext, paramKotlinTypeMarker1)) && (INSTANCE.isCommonDenotableType(paramAbstractTypeCheckerContext, paramKotlinTypeMarker2)))
    {
      KotlinTypeMarker localKotlinTypeMarker1 = paramAbstractTypeCheckerContext.refineType(paramKotlinTypeMarker1);
      KotlinTypeMarker localKotlinTypeMarker2 = paramAbstractTypeCheckerContext.refineType(paramKotlinTypeMarker2);
      SimpleTypeMarker localSimpleTypeMarker = paramAbstractTypeCheckerContext.lowerBoundIfFlexible(localKotlinTypeMarker1);
      if (!paramAbstractTypeCheckerContext.areEqualTypeConstructors(paramAbstractTypeCheckerContext.typeConstructor(localKotlinTypeMarker1), paramAbstractTypeCheckerContext.typeConstructor(localKotlinTypeMarker2))) {
        return false;
      }
      if (paramAbstractTypeCheckerContext.argumentsCount((KotlinTypeMarker)localSimpleTypeMarker) == 0)
      {
        if (!paramAbstractTypeCheckerContext.hasFlexibleNullability(localKotlinTypeMarker1))
        {
          if (paramAbstractTypeCheckerContext.hasFlexibleNullability(localKotlinTypeMarker2)) {
            return true;
          }
          if (paramAbstractTypeCheckerContext.isMarkedNullable(localSimpleTypeMarker) == paramAbstractTypeCheckerContext.isMarkedNullable(paramAbstractTypeCheckerContext.lowerBoundIfFlexible(localKotlinTypeMarker2))) {
            return true;
          }
          bool = false;
        }
        return bool;
      }
    }
    return (INSTANCE.isSubtypeOf(paramAbstractTypeCheckerContext, paramKotlinTypeMarker1, paramKotlinTypeMarker2)) && (INSTANCE.isSubtypeOf(paramAbstractTypeCheckerContext, paramKotlinTypeMarker2, paramKotlinTypeMarker1));
  }
  
  @NotNull
  public final List<SimpleTypeMarker> findCorrespondingSupertypes(@NotNull AbstractTypeCheckerContext paramAbstractTypeCheckerContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker, @NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramAbstractTypeCheckerContext, "$this$findCorrespondingSupertypes");
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "subType");
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "superConstructor");
    if (paramAbstractTypeCheckerContext.isClassType(paramSimpleTypeMarker)) {
      return collectAndFilter(paramAbstractTypeCheckerContext, paramSimpleTypeMarker, paramTypeConstructorMarker);
    }
    if ((!paramAbstractTypeCheckerContext.isClassTypeConstructor(paramTypeConstructorMarker)) && (!paramAbstractTypeCheckerContext.isIntegerLiteralTypeConstructor(paramTypeConstructorMarker))) {
      return collectAllSupertypesWithGivenTypeConstructor(paramAbstractTypeCheckerContext, paramSimpleTypeMarker, paramTypeConstructorMarker);
    }
    Object localObject3 = new SmartList();
    paramAbstractTypeCheckerContext.initialize();
    ArrayDeque localArrayDeque = paramAbstractTypeCheckerContext.getSupertypesDeque();
    if (localArrayDeque == null) {
      Intrinsics.throwNpe();
    }
    Object localObject2 = paramAbstractTypeCheckerContext.getSupertypesSet();
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    localArrayDeque.push(paramSimpleTypeMarker);
    while ((((Collection)localArrayDeque).isEmpty() ^ true)) {
      if (((Set)localObject2).size() <= 1000)
      {
        Object localObject4 = (SimpleTypeMarker)localArrayDeque.pop();
        Intrinsics.checkExpressionValueIsNotNull(localObject4, "current");
        if (((Set)localObject2).add(localObject4))
        {
          if (paramAbstractTypeCheckerContext.isClassType((SimpleTypeMarker)localObject4))
          {
            ((SmartList)localObject3).add(localObject4);
            localObject1 = (AbstractTypeCheckerContext.SupertypesPolicy)AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE;
          }
          else
          {
            localObject1 = (AbstractTypeCheckerContext.SupertypesPolicy)AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
          }
          if (!(Intrinsics.areEqual(localObject1, AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE) ^ true)) {
            localObject1 = null;
          }
          if (localObject1 != null)
          {
            localObject4 = paramAbstractTypeCheckerContext.supertypes(paramAbstractTypeCheckerContext.typeConstructor((SimpleTypeMarker)localObject4)).iterator();
            while (((Iterator)localObject4).hasNext()) {
              localArrayDeque.add(((AbstractTypeCheckerContext.SupertypesPolicy)localObject1).transformType(paramAbstractTypeCheckerContext, (KotlinTypeMarker)((Iterator)localObject4).next()));
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
        paramAbstractTypeCheckerContext.append(CollectionsKt.joinToString$default((Iterable)localObject2, null, null, null, 0, null, null, 63, null));
        throw ((Throwable)new IllegalStateException(paramAbstractTypeCheckerContext.toString().toString()));
      }
    }
    paramAbstractTypeCheckerContext.clear();
    Object localObject1 = (Iterable)localObject3;
    paramSimpleTypeMarker = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (SimpleTypeMarker)((Iterator)localObject1).next();
      localObject3 = INSTANCE;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "it");
      CollectionsKt.addAll(paramSimpleTypeMarker, (Iterable)((AbstractTypeChecker)localObject3).collectAndFilter(paramAbstractTypeCheckerContext, (SimpleTypeMarker)localObject2, paramTypeConstructorMarker));
    }
    return (List)paramSimpleTypeMarker;
  }
  
  public final boolean isSubtypeForSameConstructor(@NotNull AbstractTypeCheckerContext paramAbstractTypeCheckerContext, @NotNull TypeArgumentListMarker paramTypeArgumentListMarker, @NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramAbstractTypeCheckerContext, "$this$isSubtypeForSameConstructor");
    Intrinsics.checkParameterIsNotNull(paramTypeArgumentListMarker, "capturedSubArguments");
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "superType");
    TypeConstructorMarker localTypeConstructorMarker = paramAbstractTypeCheckerContext.typeConstructor(paramSimpleTypeMarker);
    int k = paramAbstractTypeCheckerContext.parametersCount(localTypeConstructorMarker);
    int i = 0;
    while (i < k)
    {
      Object localObject2 = paramAbstractTypeCheckerContext.getArgument((KotlinTypeMarker)paramSimpleTypeMarker, i);
      Object localObject1;
      if (!paramAbstractTypeCheckerContext.isStarProjection((TypeArgumentMarker)localObject2))
      {
        KotlinTypeMarker localKotlinTypeMarker = paramAbstractTypeCheckerContext.getType((TypeArgumentMarker)localObject2);
        localObject1 = paramAbstractTypeCheckerContext.get(paramTypeArgumentListMarker, i);
        if (paramAbstractTypeCheckerContext.getVariance((TypeArgumentMarker)localObject1) == TypeVariance.INV) {
          j = 1;
        } else {
          j = 0;
        }
        if ((_Assertions.ENABLED) && (j == 0))
        {
          paramAbstractTypeCheckerContext = new StringBuilder();
          paramAbstractTypeCheckerContext.append("Incorrect sub argument: ");
          paramAbstractTypeCheckerContext.append(localObject1);
          throw ((Throwable)new AssertionError(paramAbstractTypeCheckerContext.toString()));
        }
        localObject1 = paramAbstractTypeCheckerContext.getType((TypeArgumentMarker)localObject1);
        localObject2 = effectiveVariance(paramAbstractTypeCheckerContext.getVariance(paramAbstractTypeCheckerContext.getParameter(localTypeConstructorMarker, i)), paramAbstractTypeCheckerContext.getVariance((TypeArgumentMarker)localObject2));
        if (localObject2 == null) {
          break label365;
        }
        if (AbstractTypeCheckerContext.access$getArgumentsDepth$p(paramAbstractTypeCheckerContext) > 100) {
          break label324;
        }
        AbstractTypeCheckerContext.access$setArgumentsDepth$p(paramAbstractTypeCheckerContext, AbstractTypeCheckerContext.access$getArgumentsDepth$p(paramAbstractTypeCheckerContext) + 1);
        int j = AbstractTypeChecker.WhenMappings.$EnumSwitchMapping$0[localObject2.ordinal()];
        boolean bool;
        if (j != 1)
        {
          if (j != 2)
          {
            if (j == 3) {
              bool = INSTANCE.isSubtypeOf(paramAbstractTypeCheckerContext, localKotlinTypeMarker, (KotlinTypeMarker)localObject1);
            } else {
              throw new NoWhenBranchMatchedException();
            }
          }
          else {
            bool = INSTANCE.isSubtypeOf(paramAbstractTypeCheckerContext, (KotlinTypeMarker)localObject1, localKotlinTypeMarker);
          }
        }
        else {
          bool = INSTANCE.equalTypes(paramAbstractTypeCheckerContext, (KotlinTypeMarker)localObject1, localKotlinTypeMarker);
        }
        AbstractTypeCheckerContext.access$setArgumentsDepth$p(paramAbstractTypeCheckerContext, AbstractTypeCheckerContext.access$getArgumentsDepth$p(paramAbstractTypeCheckerContext) - 1);
        if (!bool) {
          return false;
        }
      }
      i += 1;
      continue;
      label324:
      paramAbstractTypeCheckerContext = new StringBuilder();
      paramAbstractTypeCheckerContext.append("Arguments depth is too high. Some related argument: ");
      paramAbstractTypeCheckerContext.append(localObject1);
      throw ((Throwable)new IllegalStateException(paramAbstractTypeCheckerContext.toString().toString()));
      label365:
      return paramAbstractTypeCheckerContext.isErrorTypeEqualsToAnything();
    }
    return true;
  }
  
  public final boolean isSubtypeOf(@NotNull AbstractTypeCheckerContext paramAbstractTypeCheckerContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker1, @NotNull KotlinTypeMarker paramKotlinTypeMarker2)
  {
    Intrinsics.checkParameterIsNotNull(paramAbstractTypeCheckerContext, "context");
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker1, "subType");
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker2, "superType");
    if (paramKotlinTypeMarker1 == paramKotlinTypeMarker2) {
      return true;
    }
    return INSTANCE.completeIsSubTypeOf(paramAbstractTypeCheckerContext, paramAbstractTypeCheckerContext.prepareType(paramAbstractTypeCheckerContext.refineType(paramKotlinTypeMarker1)), paramAbstractTypeCheckerContext.prepareType(paramAbstractTypeCheckerContext.refineType(paramKotlinTypeMarker2)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker
 * JD-Core Version:    0.7.0.1
 */
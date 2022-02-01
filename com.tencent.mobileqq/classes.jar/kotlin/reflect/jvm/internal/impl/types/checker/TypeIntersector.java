package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.List<+Lkotlin.reflect.jvm.internal.impl.types.SimpleType;>;
import java.util.Set;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor.Companion;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

public final class TypeIntersector
{
  public static final TypeIntersector INSTANCE = new TypeIntersector();
  
  private final Collection<SimpleType> filterTypes(Collection<? extends SimpleType> paramCollection, Function2<? super SimpleType, ? super SimpleType, Boolean> paramFunction2)
  {
    paramCollection = new ArrayList(paramCollection);
    Iterator localIterator = paramCollection.iterator();
    Intrinsics.checkExpressionValueIsNotNull(localIterator, "filteredTypes.iterator()");
    while (localIterator.hasNext())
    {
      SimpleType localSimpleType1 = (SimpleType)localIterator.next();
      Object localObject = (Iterable)paramCollection;
      boolean bool = localObject instanceof Collection;
      int j = 0;
      int i;
      if ((bool) && (((Collection)localObject).isEmpty()))
      {
        i = j;
      }
      else
      {
        localObject = ((Iterable)localObject).iterator();
        do
        {
          i = j;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          SimpleType localSimpleType2 = (SimpleType)((Iterator)localObject).next();
          if (localSimpleType2 != localSimpleType1)
          {
            Intrinsics.checkExpressionValueIsNotNull(localSimpleType2, "lower");
            Intrinsics.checkExpressionValueIsNotNull(localSimpleType1, "upper");
            if (((Boolean)paramFunction2.invoke(localSimpleType2, localSimpleType1)).booleanValue())
            {
              i = 1;
              continue;
            }
          }
          i = 0;
        } while (i == 0);
        i = 1;
      }
      if (i != 0) {
        localIterator.remove();
      }
    }
    return (Collection)paramCollection;
  }
  
  private final SimpleType intersectTypesWithoutIntersectionType(Set<? extends SimpleType> paramSet)
  {
    if (paramSet.size() == 1) {
      return (SimpleType)CollectionsKt.single((Iterable)paramSet);
    }
    Function0 localFunction0 = (Function0)new TypeIntersector.intersectTypesWithoutIntersectionType.errorMessage.1(paramSet);
    paramSet = (Collection)paramSet;
    Collection localCollection = filterTypes(paramSet, (Function2)new TypeIntersector.intersectTypesWithoutIntersectionType.filteredEqualTypes.1((TypeIntersector)this));
    boolean bool = localCollection.isEmpty();
    if ((_Assertions.ENABLED) && (!(bool ^ true))) {
      throw ((Throwable)new AssertionError(localFunction0.invoke()));
    }
    SimpleType localSimpleType = IntegerLiteralTypeConstructor.Companion.findIntersectionType(localCollection);
    if (localSimpleType != null) {
      return localSimpleType;
    }
    localCollection = filterTypes(localCollection, (Function2)new TypeIntersector.intersectTypesWithoutIntersectionType.filteredSuperAndEqualTypes.1(NewKotlinTypeChecker.Companion.getDefault()));
    bool = localCollection.isEmpty();
    if ((_Assertions.ENABLED) && (!(true ^ bool))) {
      throw ((Throwable)new AssertionError(localFunction0.invoke()));
    }
    if (localCollection.size() < 2) {
      return (SimpleType)CollectionsKt.single((Iterable)localCollection);
    }
    return new IntersectionTypeConstructor(paramSet).createType();
  }
  
  private final boolean isStrictSupertype(KotlinType paramKotlinType1, KotlinType paramKotlinType2)
  {
    NewKotlinTypeCheckerImpl localNewKotlinTypeCheckerImpl = NewKotlinTypeChecker.Companion.getDefault();
    return (localNewKotlinTypeCheckerImpl.isSubtypeOf(paramKotlinType1, paramKotlinType2)) && (!localNewKotlinTypeCheckerImpl.isSubtypeOf(paramKotlinType2, paramKotlinType1));
  }
  
  @NotNull
  public final SimpleType intersectTypes$descriptors(@NotNull List<? extends SimpleType> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "types");
    int i;
    if (paramList.size() > 1) {
      i = 1;
    } else {
      i = 0;
    }
    if ((_Assertions.ENABLED) && (i == 0))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Size should be at least 2, but it is ");
      ((StringBuilder)localObject1).append(paramList.size());
      throw ((Throwable)new AssertionError(((StringBuilder)localObject1).toString()));
    }
    Object localObject2 = new ArrayList();
    Object localObject3 = paramList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (SimpleType)((Iterator)localObject3).next();
      if ((((SimpleType)localObject4).getConstructor() instanceof IntersectionTypeConstructor))
      {
        paramList = ((SimpleType)localObject4).getConstructor().getSupertypes();
        Intrinsics.checkExpressionValueIsNotNull(paramList, "type.constructor.supertypes");
        paramList = (Iterable)paramList;
        Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramList, 10));
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          paramList = (KotlinType)localIterator.next();
          Intrinsics.checkExpressionValueIsNotNull(paramList, "it");
          localObject1 = FlexibleTypesKt.upperIfFlexible(paramList);
          paramList = (List<? extends SimpleType>)localObject1;
          if (((SimpleType)localObject4).isMarkedNullable()) {
            paramList = ((SimpleType)localObject1).makeNullableAsSpecified(true);
          }
          localCollection.add(paramList);
        }
        ((ArrayList)localObject2).addAll((Collection)localCollection);
      }
      else
      {
        ((ArrayList)localObject2).add(localObject4);
      }
    }
    Object localObject1 = (Iterable)localObject2;
    paramList = TypeIntersector.ResultNullability.START;
    localObject2 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      paramList = paramList.combine((UnwrappedType)((Iterator)localObject2).next());
    }
    localObject3 = (Collection)new LinkedHashSet();
    Object localObject4 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject2 = (SimpleType)((Iterator)localObject4).next();
      localObject1 = localObject2;
      if (paramList == TypeIntersector.ResultNullability.NOT_NULL) {
        localObject1 = SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull((SimpleType)localObject2);
      }
      ((Collection)localObject3).add(localObject1);
    }
    return intersectTypesWithoutIntersectionType((Set)localObject3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector
 * JD-Core Version:    0.7.0.1
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

public final class IntersectionTypeKt
{
  @NotNull
  public static final UnwrappedType intersectTypes(@NotNull List<? extends UnwrappedType> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "types");
    int i = paramList.size();
    if (i != 0)
    {
      if (i != 1)
      {
        Object localObject2 = (Iterable)paramList;
        Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
        Iterator localIterator = ((Iterable)localObject2).iterator();
        i = 0;
        int j = 0;
        while (localIterator.hasNext())
        {
          localObject1 = (UnwrappedType)localIterator.next();
          if ((i == 0) && (!KotlinTypeKt.isError((KotlinType)localObject1))) {
            i = 0;
          } else {
            i = 1;
          }
          if ((localObject1 instanceof SimpleType))
          {
            localObject1 = (SimpleType)localObject1;
          }
          else
          {
            if (!(localObject1 instanceof FlexibleType)) {
              break label161;
            }
            if (DynamicTypesKt.isDynamic((KotlinType)localObject1)) {
              return localObject1;
            }
            localObject1 = ((FlexibleType)localObject1).getLowerBound();
            j = 1;
          }
          localCollection.add(localObject1);
          continue;
          label161:
          throw new NoWhenBranchMatchedException();
        }
        Object localObject1 = (List)localCollection;
        if (i != 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Intersection of error types: ");
          ((StringBuilder)localObject1).append(paramList);
          paramList = ErrorUtils.createErrorType(((StringBuilder)localObject1).toString());
          Intrinsics.checkExpressionValueIsNotNull(paramList, "ErrorUtils.createErrorTy… of error types: $types\")");
          return (UnwrappedType)paramList;
        }
        if (j == 0) {
          return (UnwrappedType)TypeIntersector.INSTANCE.intersectTypes$descriptors((List)localObject1);
        }
        paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramList.add(FlexibleTypesKt.upperIfFlexible((KotlinType)((Iterator)localObject2).next()));
        }
        paramList = (List)paramList;
        return KotlinTypeFactory.flexibleType(TypeIntersector.INSTANCE.intersectTypes$descriptors((List)localObject1), TypeIntersector.INSTANCE.intersectTypes$descriptors(paramList));
      }
      return (UnwrappedType)CollectionsKt.single(paramList);
    }
    paramList = (Throwable)new IllegalStateException("Expected some types".toString());
    for (;;)
    {
      throw paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.IntersectionTypeKt
 * JD-Core Version:    0.7.0.1
 */
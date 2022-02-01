package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion;
import org.jetbrains.annotations.NotNull;

public final class OverridingUtilsKt
{
  public static final <D extends CallableDescriptor> void retainMostSpecificInEachOverridableGroup(@NotNull Collection<D> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$retainMostSpecificInEachOverridableGroup");
    Collection localCollection = selectMostSpecificInEachOverridableGroup(paramCollection, (Function1)OverridingUtilsKt.retainMostSpecificInEachOverridableGroup.newResult.1.INSTANCE);
    if (paramCollection.size() == localCollection.size()) {
      return;
    }
    paramCollection.retainAll(localCollection);
  }
  
  @NotNull
  public static final <H> Collection<H> selectMostSpecificInEachOverridableGroup(@NotNull Collection<? extends H> paramCollection, @NotNull Function1<? super H, ? extends CallableDescriptor> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$selectMostSpecificInEachOverridableGroup");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "descriptorByHandle");
    if (paramCollection.size() <= 1) {
      return paramCollection;
    }
    paramCollection = new LinkedList(paramCollection);
    SmartSet localSmartSet = SmartSet.Companion.create();
    for (;;)
    {
      Object localObject2 = (Collection)paramCollection;
      if (!(((Collection)localObject2).isEmpty() ^ true)) {
        break;
      }
      Object localObject3 = CollectionsKt.first((List)paramCollection);
      Object localObject1 = SmartSet.Companion.create();
      Object localObject4 = OverridingUtil.extractMembersOverridableInBothWays(localObject3, (Collection)localObject2, paramFunction1, (Function1)new OverridingUtilsKt.selectMostSpecificInEachOverridableGroup.overridableGroup.1((SmartSet)localObject1));
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "OverridingUtil.extractMe…nflictedHandles.add(it) }");
      if ((((Collection)localObject4).size() == 1) && (((SmartSet)localObject1).isEmpty()))
      {
        localObject1 = CollectionsKt.single((Iterable)localObject4);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "overridableGroup.single()");
        localSmartSet.add(localObject1);
      }
      else
      {
        localObject2 = OverridingUtil.selectMostSpecificMember((Collection)localObject4, paramFunction1);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "OverridingUtil.selectMos…roup, descriptorByHandle)");
        localObject3 = (CallableDescriptor)paramFunction1.invoke(localObject2);
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          Object localObject5 = ((Iterator)localObject4).next();
          Intrinsics.checkExpressionValueIsNotNull(localObject5, "it");
          if (!OverridingUtil.isMoreSpecific((CallableDescriptor)localObject3, (CallableDescriptor)paramFunction1.invoke(localObject5))) {
            ((Collection)localObject1).add(localObject5);
          }
        }
        localObject1 = (Collection)localObject1;
        if ((((Collection)localObject1).isEmpty() ^ true)) {
          localSmartSet.addAll((Collection)localObject1);
        }
        localSmartSet.add(localObject2);
      }
    }
    return (Collection)localSmartSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt
 * JD-Core Version:    0.7.0.1
 */
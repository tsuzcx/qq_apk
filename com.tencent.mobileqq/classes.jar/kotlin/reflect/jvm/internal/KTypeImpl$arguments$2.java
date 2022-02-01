package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KTypeProjection.Companion;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/KTypeProjection;", "invoke"}, k=3, mv={1, 1, 16})
final class KTypeImpl$arguments$2
  extends Lambda
  implements Function0<List<? extends KTypeProjection>>
{
  KTypeImpl$arguments$2(KTypeImpl paramKTypeImpl)
  {
    super(0);
  }
  
  @NotNull
  public final List<KTypeProjection> invoke()
  {
    Object localObject1 = this.this$0.getType().getArguments();
    if (((List)localObject1).isEmpty()) {
      return CollectionsKt.emptyList();
    }
    Lazy localLazy = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0)new KTypeImpl.arguments.2.parameterizedTypeArguments.2(this));
    localObject1 = (Iterable)localObject1;
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    int i = 0;
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject1 = (TypeProjection)localObject1;
      if (((TypeProjection)localObject1).isStarProjection())
      {
        localObject1 = KTypeProjection.Companion.getSTAR();
      }
      else
      {
        Object localObject2 = ((TypeProjection)localObject1).getType();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "typeProjection.type");
        localObject2 = new KTypeImpl((KotlinType)localObject2, (Function0)new KTypeImpl.arguments.2..special..inlined.mapIndexed.lambda.1(i, this, localLazy, null));
        localObject1 = ((TypeProjection)localObject1).getProjectionKind();
        int j = KTypeImpl.WhenMappings.$EnumSwitchMapping$0[localObject1.ordinal()];
        if (j != 1)
        {
          if (j != 2)
          {
            if (j == 3) {
              localObject1 = KTypeProjection.Companion.covariant((KType)localObject2);
            } else {
              throw new NoWhenBranchMatchedException();
            }
          }
          else {
            localObject1 = KTypeProjection.Companion.contravariant((KType)localObject2);
          }
        }
        else {
          localObject1 = KTypeProjection.Companion.invariant((KType)localObject2);
        }
      }
      localCollection.add(localObject1);
      i += 1;
    }
    return (List)localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KTypeImpl.arguments.2
 * JD-Core Version:    0.7.0.1
 */
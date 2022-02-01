package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/KType;", "kotlin.jvm.PlatformType", "", "current", "getNeighbors"}, k=3, mv={1, 1, 16})
final class KClasses$allSupertypes$1<N>
  implements DFS.Neighbors<KType>
{
  public static final 1 INSTANCE = new 1();
  
  @NotNull
  public final Iterable<KType> getNeighbors(KType paramKType)
  {
    Object localObject2 = paramKType.getClassifier();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof KClass)) {
      localObject1 = null;
    }
    localObject1 = (KClass)localObject1;
    if (localObject1 != null)
    {
      localObject2 = ((KClass)localObject1).getSupertypes();
      if (paramKType.getArguments().isEmpty()) {
        return (Iterable)localObject2;
      }
      if (paramKType != null)
      {
        localObject1 = TypeSubstitutor.create(((KTypeImpl)paramKType).getType());
        Object localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
        Iterator localIterator = ((Iterable)localObject3).iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (KType)localIterator.next();
          if (localObject3 != null)
          {
            KotlinType localKotlinType = ((TypeSubstitutor)localObject1).substitute(((KTypeImpl)localObject3).getType(), Variance.INVARIANT);
            if (localKotlinType != null)
            {
              Intrinsics.checkExpressionValueIsNotNull(localKotlinType, "substitutor.substitute((…: $supertype ($current)\")");
              ((Collection)localObject2).add(new KTypeImpl(localKotlinType, (Function0)KClasses.allSupertypes.1.1.1.1.INSTANCE));
            }
            else
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Type substitution failed: ");
              ((StringBuilder)localObject1).append(localObject3);
              ((StringBuilder)localObject1).append(" (");
              ((StringBuilder)localObject1).append(paramKType);
              ((StringBuilder)localObject1).append(')');
              throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject1).toString()));
            }
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
          }
        }
        return (Iterable)localObject2;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Supertype not a class: ");
    ((StringBuilder)localObject1).append(paramKType);
    paramKType = (Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject1).toString());
    for (;;)
    {
      throw paramKType;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.full.KClasses.allSupertypes.1
 * JD-Core Version:    0.7.0.1
 */
package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "invoke"}, k=3, mv={1, 1, 16})
final class KTypeParameterImpl$upperBounds$2
  extends Lambda
  implements Function0<List<? extends KTypeImpl>>
{
  KTypeParameterImpl$upperBounds$2(KTypeParameterImpl paramKTypeParameterImpl)
  {
    super(0);
  }
  
  @NotNull
  public final List<KTypeImpl> invoke()
  {
    Object localObject1 = this.this$0.getDescriptor().getUpperBounds();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "descriptor.upperBounds");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      KotlinType localKotlinType = (KotlinType)((Iterator)localObject2).next();
      Intrinsics.checkExpressionValueIsNotNull(localKotlinType, "kotlinType");
      ((Collection)localObject1).add(new KTypeImpl(localKotlinType, (Function0)new KTypeParameterImpl.upperBounds.2..special..inlined.map.lambda.1(this)));
    }
    return (List)localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KTypeParameterImpl.upperBounds.2
 * JD-Core Version:    0.7.0.1
 */
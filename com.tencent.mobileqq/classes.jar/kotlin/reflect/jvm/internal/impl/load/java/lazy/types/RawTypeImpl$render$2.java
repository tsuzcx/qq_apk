package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;

final class RawTypeImpl$render$2
  extends Lambda
  implements Function1<KotlinType, List<? extends String>>
{
  RawTypeImpl$render$2(DescriptorRenderer paramDescriptorRenderer)
  {
    super(1);
  }
  
  @NotNull
  public final List<String> invoke(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "type");
    Object localObject = (Iterable)paramKotlinType.getArguments();
    paramKotlinType = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TypeProjection localTypeProjection = (TypeProjection)((Iterator)localObject).next();
      paramKotlinType.add(this.$renderer.renderTypeProjection(localTypeProjection));
    }
    return (List)paramKotlinType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl.render.2
 * JD-Core Version:    0.7.0.1
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor.Capability;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class KotlinTypeRefinerKt
{
  @NotNull
  private static final ModuleDescriptor.Capability<Ref<KotlinTypeRefiner>> REFINER_CAPABILITY = new ModuleDescriptor.Capability("KotlinTypeRefiner");
  
  @NotNull
  public static final ModuleDescriptor.Capability<Ref<KotlinTypeRefiner>> getREFINER_CAPABILITY()
  {
    return REFINER_CAPABILITY;
  }
  
  @NotNull
  public static final List<KotlinType> refineTypes(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner, @NotNull Iterable<? extends KotlinType> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "$this$refineTypes");
    Intrinsics.checkParameterIsNotNull(paramIterable, "types");
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramIterable, 10));
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localCollection.add(paramKotlinTypeRefiner.refineType((KotlinType)paramIterable.next()));
    }
    return (List)localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt
 * JD-Core Version:    0.7.0.1
 */
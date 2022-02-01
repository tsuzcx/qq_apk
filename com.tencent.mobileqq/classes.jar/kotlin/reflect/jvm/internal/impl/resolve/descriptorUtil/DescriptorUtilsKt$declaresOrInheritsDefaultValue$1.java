package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors;
import org.jetbrains.annotations.NotNull;

final class DescriptorUtilsKt$declaresOrInheritsDefaultValue$1<N>
  implements DFS.Neighbors<N>
{
  public static final 1 INSTANCE = new 1();
  
  @NotNull
  public final List<ValueParameterDescriptor> getNeighbors(ValueParameterDescriptor paramValueParameterDescriptor)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramValueParameterDescriptor, "current");
    Object localObject = (Iterable)paramValueParameterDescriptor.getOverriddenDescriptors();
    paramValueParameterDescriptor = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramValueParameterDescriptor.add(((ValueParameterDescriptor)((Iterator)localObject).next()).getOriginal());
    }
    return (List)paramValueParameterDescriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.declaresOrInheritsDefaultValue.1
 * JD-Core Version:    0.7.0.1
 */
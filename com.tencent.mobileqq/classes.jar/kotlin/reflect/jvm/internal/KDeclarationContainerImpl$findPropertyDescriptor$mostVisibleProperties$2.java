package kotlin.reflect.jvm.internal;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "first", "Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;", "kotlin.jvm.PlatformType", "second", "compare"}, k=3, mv={1, 1, 16})
final class KDeclarationContainerImpl$findPropertyDescriptor$mostVisibleProperties$2<T>
  implements Comparator<Visibility>
{
  public static final 2 INSTANCE = new 2();
  
  public final int compare(Visibility paramVisibility1, Visibility paramVisibility2)
  {
    paramVisibility1 = Visibilities.compare(paramVisibility1, paramVisibility2);
    if (paramVisibility1 != null) {
      return paramVisibility1.intValue();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KDeclarationContainerImpl.findPropertyDescriptor.mostVisibleProperties.2
 * JD-Core Version:    0.7.0.1
 */
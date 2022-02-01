package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1
  extends Lambda
  implements Function0<String>
{
  TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1(Set paramSet)
  {
    super(0);
  }
  
  @NotNull
  public final String invoke()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("This collections cannot be empty! input types: ");
    localStringBuilder.append(CollectionsKt.joinToString$default((Iterable)this.$inputTypes, null, null, null, 0, null, null, 63, null));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.intersectTypesWithoutIntersectionType.errorMessage.1
 * JD-Core Version:    0.7.0.1
 */
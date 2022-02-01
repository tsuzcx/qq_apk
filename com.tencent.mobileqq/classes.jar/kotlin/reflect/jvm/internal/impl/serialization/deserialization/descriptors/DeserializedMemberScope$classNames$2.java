package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

final class DeserializedMemberScope$classNames$2
  extends Lambda
  implements Function0<Set<? extends Name>>
{
  DeserializedMemberScope$classNames$2(Function0 paramFunction0)
  {
    super(0);
  }
  
  @NotNull
  public final Set<Name> invoke()
  {
    return CollectionsKt.toSet((Iterable)this.$classNames.invoke());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.classNames.2
 * JD-Core Version:    0.7.0.1
 */
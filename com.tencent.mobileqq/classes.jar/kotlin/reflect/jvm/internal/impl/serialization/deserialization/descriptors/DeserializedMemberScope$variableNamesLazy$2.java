package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

final class DeserializedMemberScope$variableNamesLazy$2
  extends Lambda
  implements Function0<Set<? extends Name>>
{
  DeserializedMemberScope$variableNamesLazy$2(DeserializedMemberScope paramDeserializedMemberScope)
  {
    super(0);
  }
  
  @NotNull
  public final Set<Name> invoke()
  {
    return SetsKt.plus(DeserializedMemberScope.access$getPropertyProtosBytes$p(this.this$0).keySet(), (Iterable)this.this$0.getNonDeclaredVariableNames());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.variableNamesLazy.2
 * JD-Core Version:    0.7.0.1
 */
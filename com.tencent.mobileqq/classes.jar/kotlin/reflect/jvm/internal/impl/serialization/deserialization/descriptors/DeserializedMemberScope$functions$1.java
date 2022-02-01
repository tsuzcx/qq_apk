package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

final class DeserializedMemberScope$functions$1
  extends Lambda
  implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>>
{
  DeserializedMemberScope$functions$1(DeserializedMemberScope paramDeserializedMemberScope)
  {
    super(1);
  }
  
  @NotNull
  public final Collection<SimpleFunctionDescriptor> invoke(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "it");
    return DeserializedMemberScope.access$computeFunctions(this.this$0, paramName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.functions.1
 * JD-Core Version:    0.7.0.1
 */
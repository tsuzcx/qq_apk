package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class DeserializedMemberScope$typeAliasByName$1
  extends Lambda
  implements Function1<Name, TypeAliasDescriptor>
{
  DeserializedMemberScope$typeAliasByName$1(DeserializedMemberScope paramDeserializedMemberScope)
  {
    super(1);
  }
  
  @Nullable
  public final TypeAliasDescriptor invoke(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "it");
    return DeserializedMemberScope.access$createTypeAlias(this.this$0, paramName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.typeAliasByName.1
 * JD-Core Version:    0.7.0.1
 */
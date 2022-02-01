package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ContractDeserializer$Companion$DEFAULT$1
  implements ContractDeserializer
{
  @Nullable
  public Pair deserializeContractFromFunction(@NotNull ProtoBuf.Function paramFunction, @NotNull FunctionDescriptor paramFunctionDescriptor, @NotNull TypeTable paramTypeTable, @NotNull TypeDeserializer paramTypeDeserializer)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction, "proto");
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "ownerFunction");
    Intrinsics.checkParameterIsNotNull(paramTypeTable, "typeTable");
    Intrinsics.checkParameterIsNotNull(paramTypeDeserializer, "typeDeserializer");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer.Companion.DEFAULT.1
 * JD-Core Version:    0.7.0.1
 */
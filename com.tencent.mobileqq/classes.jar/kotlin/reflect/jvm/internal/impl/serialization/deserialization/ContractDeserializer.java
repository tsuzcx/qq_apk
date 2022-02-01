package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface ContractDeserializer
{
  public static final ContractDeserializer.Companion Companion = ContractDeserializer.Companion.$$INSTANCE;
  
  @Nullable
  public abstract Pair<CallableDescriptor.UserDataKey<?>, Object> deserializeContractFromFunction(@NotNull ProtoBuf.Function paramFunction, @NotNull FunctionDescriptor paramFunctionDescriptor, @NotNull TypeTable paramTypeTable, @NotNull TypeDeserializer paramTypeDeserializer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer
 * JD-Core Version:    0.7.0.1
 */
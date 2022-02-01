package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableMessage;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProtoBufUtilKt
{
  @Nullable
  public static final <M extends GeneratedMessageLite.ExtendableMessage<M>, T> T getExtensionOrNull(@NotNull GeneratedMessageLite.ExtendableMessage<M> paramExtendableMessage, @NotNull GeneratedMessageLite.GeneratedExtension<M, T> paramGeneratedExtension)
  {
    Intrinsics.checkParameterIsNotNull(paramExtendableMessage, "$this$getExtensionOrNull");
    Intrinsics.checkParameterIsNotNull(paramGeneratedExtension, "extension");
    if (paramExtendableMessage.hasExtension(paramGeneratedExtension)) {
      return paramExtendableMessage.getExtension(paramGeneratedExtension);
    }
    return null;
  }
  
  @Nullable
  public static final <M extends GeneratedMessageLite.ExtendableMessage<M>, T> T getExtensionOrNull(@NotNull GeneratedMessageLite.ExtendableMessage<M> paramExtendableMessage, @NotNull GeneratedMessageLite.GeneratedExtension<M, List<T>> paramGeneratedExtension, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramExtendableMessage, "$this$getExtensionOrNull");
    Intrinsics.checkParameterIsNotNull(paramGeneratedExtension, "extension");
    if (paramInt < paramExtendableMessage.getExtensionCount(paramGeneratedExtension)) {
      return paramExtendableMessage.getExtension(paramGeneratedExtension, paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt
 * JD-Core Version:    0.7.0.1
 */
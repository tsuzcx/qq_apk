package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import org.jetbrains.annotations.NotNull;

final class DeserializedClassDescriptor$DeserializedClassMemberScope$computeNonDeclaredFunctions$1
  extends Lambda
  implements Function1<SimpleFunctionDescriptor, Boolean>
{
  DeserializedClassDescriptor$DeserializedClassMemberScope$computeNonDeclaredFunctions$1(DeserializedClassDescriptor.DeserializedClassMemberScope paramDeserializedClassMemberScope)
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull SimpleFunctionDescriptor paramSimpleFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleFunctionDescriptor, "it");
    return this.this$0.getC().getComponents().getPlatformDependentDeclarationFilter().isFunctionAvailable((ClassDescriptor)this.this$0.this$0, paramSimpleFunctionDescriptor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope.computeNonDeclaredFunctions.1
 * JD-Core Version:    0.7.0.1
 */
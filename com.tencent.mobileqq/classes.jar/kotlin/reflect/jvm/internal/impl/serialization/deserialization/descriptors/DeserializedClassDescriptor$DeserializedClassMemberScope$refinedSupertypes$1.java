package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

final class DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1
  extends Lambda
  implements Function0<Collection<? extends KotlinType>>
{
  DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1(DeserializedClassDescriptor.DeserializedClassMemberScope paramDeserializedClassMemberScope)
  {
    super(0);
  }
  
  @NotNull
  public final Collection<KotlinType> invoke()
  {
    return DeserializedClassDescriptor.DeserializedClassMemberScope.access$getKotlinTypeRefiner$p(this.this$0).refineSupertypes((ClassDescriptor)DeserializedClassDescriptor.DeserializedClassMemberScope.access$getClassDescriptor$p(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope.refinedSupertypes.1
 * JD-Core Version:    0.7.0.1
 */
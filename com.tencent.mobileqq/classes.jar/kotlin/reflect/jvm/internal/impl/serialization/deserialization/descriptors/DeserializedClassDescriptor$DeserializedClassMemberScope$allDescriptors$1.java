package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Companion;
import org.jetbrains.annotations.NotNull;

final class DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1
  extends Lambda
  implements Function0<Collection<? extends DeclarationDescriptor>>
{
  DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1(DeserializedClassDescriptor.DeserializedClassMemberScope paramDeserializedClassMemberScope)
  {
    super(0);
  }
  
  @NotNull
  public final Collection<DeclarationDescriptor> invoke()
  {
    return this.this$0.computeDescriptors(DescriptorKindFilter.ALL, MemberScope.Companion.getALL_NAME_FILTER(), (LookupLocation)NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope.allDescriptors.1
 * JD-Core Version:    0.7.0.1
 */
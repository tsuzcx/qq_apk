package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

final class DeserializedClassDescriptor$EnumEntryClassDescriptors$enumMemberNames$1
  extends Lambda
  implements Function0<Set<? extends Name>>
{
  DeserializedClassDescriptor$EnumEntryClassDescriptors$enumMemberNames$1(DeserializedClassDescriptor.EnumEntryClassDescriptors paramEnumEntryClassDescriptors)
  {
    super(0);
  }
  
  @NotNull
  public final Set<Name> invoke()
  {
    return DeserializedClassDescriptor.EnumEntryClassDescriptors.access$computeEnumMemberNames(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.EnumEntryClassDescriptors.enumMemberNames.1
 * JD-Core Version:    0.7.0.1
 */
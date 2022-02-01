package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1
  extends Lambda
  implements Function1<Name, EnumEntrySyntheticClassDescriptor>
{
  DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1(DeserializedClassDescriptor.EnumEntryClassDescriptors paramEnumEntryClassDescriptors)
  {
    super(1);
  }
  
  @Nullable
  public final EnumEntrySyntheticClassDescriptor invoke(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    ProtoBuf.EnumEntry localEnumEntry = (ProtoBuf.EnumEntry)DeserializedClassDescriptor.EnumEntryClassDescriptors.access$getEnumEntryProtos$p(this.this$0).get(paramName);
    if (localEnumEntry != null) {
      return EnumEntrySyntheticClassDescriptor.create(this.this$0.this$0.getC().getStorageManager(), (ClassDescriptor)this.this$0.this$0, paramName, DeserializedClassDescriptor.EnumEntryClassDescriptors.access$getEnumMemberNames$p(this.this$0), (Annotations)new DeserializedAnnotations(this.this$0.this$0.getC().getStorageManager(), (Function0)new DeserializedClassDescriptor.EnumEntryClassDescriptors.enumEntryByName.1..special..inlined.let.lambda.1(localEnumEntry, this, paramName)), SourceElement.NO_SOURCE);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.EnumEntryClassDescriptors.enumEntryByName.1
 * JD-Core Version:    0.7.0.1
 */
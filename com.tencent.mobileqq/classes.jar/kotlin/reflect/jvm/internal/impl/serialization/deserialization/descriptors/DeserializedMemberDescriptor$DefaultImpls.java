package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Companion;
import org.jetbrains.annotations.NotNull;

public final class DeserializedMemberDescriptor$DefaultImpls
{
  @NotNull
  public static List<VersionRequirement> getVersionRequirements(DeserializedMemberDescriptor paramDeserializedMemberDescriptor)
  {
    return VersionRequirement.Companion.create(paramDeserializedMemberDescriptor.getProto(), paramDeserializedMemberDescriptor.getNameResolver(), paramDeserializedMemberDescriptor.getVersionRequirementTable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */
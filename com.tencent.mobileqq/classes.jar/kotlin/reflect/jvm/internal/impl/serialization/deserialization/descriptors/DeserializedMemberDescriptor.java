package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;

public abstract interface DeserializedMemberDescriptor
  extends MemberDescriptor, DescriptorWithContainerSource
{
  @NotNull
  public abstract NameResolver getNameResolver();
  
  @NotNull
  public abstract MessageLite getProto();
  
  @NotNull
  public abstract TypeTable getTypeTable();
  
  @NotNull
  public abstract VersionRequirementTable getVersionRequirementTable();
  
  @NotNull
  public abstract List<VersionRequirement> getVersionRequirements();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor
 * JD-Core Version:    0.7.0.1
 */
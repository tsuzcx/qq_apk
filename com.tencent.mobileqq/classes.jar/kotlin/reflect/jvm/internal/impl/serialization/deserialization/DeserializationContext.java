package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionSpecificBehaviorKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeserializationContext
{
  @NotNull
  private final DeserializationComponents components;
  @Nullable
  private final DeserializedContainerSource containerSource;
  @NotNull
  private final DeclarationDescriptor containingDeclaration;
  @NotNull
  private final MemberDeserializer memberDeserializer;
  @NotNull
  private final BinaryVersion metadataVersion;
  @NotNull
  private final NameResolver nameResolver;
  @NotNull
  private final TypeDeserializer typeDeserializer;
  @NotNull
  private final TypeTable typeTable;
  @NotNull
  private final VersionRequirementTable versionRequirementTable;
  
  public DeserializationContext(@NotNull DeserializationComponents paramDeserializationComponents, @NotNull NameResolver paramNameResolver, @NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull TypeTable paramTypeTable, @NotNull VersionRequirementTable paramVersionRequirementTable, @NotNull BinaryVersion paramBinaryVersion, @Nullable DeserializedContainerSource paramDeserializedContainerSource, @Nullable TypeDeserializer paramTypeDeserializer, @NotNull List<ProtoBuf.TypeParameter> paramList)
  {
    this.components = paramDeserializationComponents;
    this.nameResolver = paramNameResolver;
    this.containingDeclaration = paramDeclarationDescriptor;
    this.typeTable = paramTypeTable;
    this.versionRequirementTable = paramVersionRequirementTable;
    this.metadataVersion = paramBinaryVersion;
    this.containerSource = paramDeserializedContainerSource;
    paramDeserializationComponents = new StringBuilder();
    paramDeserializationComponents.append("Deserializer for \"");
    paramDeserializationComponents.append(this.containingDeclaration.getName());
    paramDeserializationComponents.append('"');
    paramNameResolver = paramDeserializationComponents.toString();
    paramDeserializationComponents = this.containerSource;
    if (paramDeserializationComponents != null)
    {
      paramDeserializationComponents = paramDeserializationComponents.getPresentableString();
      if (paramDeserializationComponents != null) {}
    }
    else
    {
      paramDeserializationComponents = "[container not found]";
    }
    this.typeDeserializer = new TypeDeserializer(this, paramTypeDeserializer, paramList, paramNameResolver, paramDeserializationComponents, false, 32, null);
    this.memberDeserializer = new MemberDeserializer(this);
  }
  
  @NotNull
  public final DeserializationContext childContext(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull List<ProtoBuf.TypeParameter> paramList, @NotNull NameResolver paramNameResolver, @NotNull TypeTable paramTypeTable, @NotNull VersionRequirementTable paramVersionRequirementTable, @NotNull BinaryVersion paramBinaryVersion)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "descriptor");
    Intrinsics.checkParameterIsNotNull(paramList, "typeParameterProtos");
    Intrinsics.checkParameterIsNotNull(paramNameResolver, "nameResolver");
    Intrinsics.checkParameterIsNotNull(paramTypeTable, "typeTable");
    Intrinsics.checkParameterIsNotNull(paramVersionRequirementTable, "versionRequirementTable");
    Intrinsics.checkParameterIsNotNull(paramBinaryVersion, "metadataVersion");
    DeserializationComponents localDeserializationComponents = this.components;
    if (!VersionSpecificBehaviorKt.isVersionRequirementTableWrittenCorrectly(paramBinaryVersion)) {
      paramVersionRequirementTable = this.versionRequirementTable;
    }
    return new DeserializationContext(localDeserializationComponents, paramNameResolver, paramDeclarationDescriptor, paramTypeTable, paramVersionRequirementTable, paramBinaryVersion, this.containerSource, this.typeDeserializer, paramList);
  }
  
  @NotNull
  public final DeserializationComponents getComponents()
  {
    return this.components;
  }
  
  @Nullable
  public final DeserializedContainerSource getContainerSource()
  {
    return this.containerSource;
  }
  
  @NotNull
  public final DeclarationDescriptor getContainingDeclaration()
  {
    return this.containingDeclaration;
  }
  
  @NotNull
  public final MemberDeserializer getMemberDeserializer()
  {
    return this.memberDeserializer;
  }
  
  @NotNull
  public final NameResolver getNameResolver()
  {
    return this.nameResolver;
  }
  
  @NotNull
  public final StorageManager getStorageManager()
  {
    return this.components.getStorageManager();
  }
  
  @NotNull
  public final TypeDeserializer getTypeDeserializer()
  {
    return this.typeDeserializer;
  }
  
  @NotNull
  public final TypeTable getTypeTable()
  {
    return this.typeTable;
  }
  
  @NotNull
  public final VersionRequirementTable getVersionRequirementTable()
  {
    return this.versionRequirementTable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext
 * JD-Core Version:    0.7.0.1
 */
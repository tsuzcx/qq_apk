package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public abstract class DeserializedPackageFragment
  extends PackageFragmentDescriptorImpl
{
  @NotNull
  private final StorageManager storageManager;
  
  public DeserializedPackageFragment(@NotNull FqName paramFqName, @NotNull StorageManager paramStorageManager, @NotNull ModuleDescriptor paramModuleDescriptor)
  {
    super(paramModuleDescriptor, paramFqName);
    this.storageManager = paramStorageManager;
  }
  
  @NotNull
  public abstract ClassDataFinder getClassDataFinder();
  
  public boolean hasTopLevelClass(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    MemberScope localMemberScope = getMemberScope();
    return ((localMemberScope instanceof DeserializedMemberScope)) && (((DeserializedMemberScope)localMemberScope).getClassNames$deserialization().contains(paramName));
  }
  
  public abstract void initialize(@NotNull DeserializationComponents paramDeserializationComponents);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment
 * JD-Core Version:    0.7.0.1
 */
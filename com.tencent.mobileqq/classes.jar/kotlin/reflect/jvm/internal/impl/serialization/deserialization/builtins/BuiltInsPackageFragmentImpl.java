package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment;
import kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

public final class BuiltInsPackageFragmentImpl
  extends DeserializedPackageFragmentImpl
  implements BuiltInsPackageFragment
{
  public static final BuiltInsPackageFragmentImpl.Companion Companion = new BuiltInsPackageFragmentImpl.Companion(null);
  private final boolean isFallback;
  
  private BuiltInsPackageFragmentImpl(FqName paramFqName, StorageManager paramStorageManager, ModuleDescriptor paramModuleDescriptor, ProtoBuf.PackageFragment paramPackageFragment, BuiltInsBinaryVersion paramBuiltInsBinaryVersion, boolean paramBoolean)
  {
    super(paramFqName, paramStorageManager, paramModuleDescriptor, paramPackageFragment, (BinaryVersion)paramBuiltInsBinaryVersion, null);
    this.isFallback = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl
 * JD-Core Version:    0.7.0.1
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolverImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class DeserializedPackageFragmentImpl
  extends DeserializedPackageFragment
{
  private MemberScope _memberScope;
  private ProtoBuf.PackageFragment _proto;
  @NotNull
  private final ProtoBasedClassDataFinder classDataFinder;
  private final DeserializedContainerSource containerSource;
  private final BinaryVersion metadataVersion;
  @NotNull
  private final NameResolverImpl nameResolver;
  
  public DeserializedPackageFragmentImpl(@NotNull FqName paramFqName, @NotNull StorageManager paramStorageManager, @NotNull ModuleDescriptor paramModuleDescriptor, @NotNull ProtoBuf.PackageFragment paramPackageFragment, @NotNull BinaryVersion paramBinaryVersion, @Nullable DeserializedContainerSource paramDeserializedContainerSource)
  {
    super(paramFqName, paramStorageManager, paramModuleDescriptor);
    this.metadataVersion = paramBinaryVersion;
    this.containerSource = paramDeserializedContainerSource;
    paramFqName = paramPackageFragment.getStrings();
    Intrinsics.checkExpressionValueIsNotNull(paramFqName, "proto.strings");
    paramStorageManager = paramPackageFragment.getQualifiedNames();
    Intrinsics.checkExpressionValueIsNotNull(paramStorageManager, "proto.qualifiedNames");
    this.nameResolver = new NameResolverImpl(paramFqName, paramStorageManager);
    this.classDataFinder = new ProtoBasedClassDataFinder(paramPackageFragment, (NameResolver)this.nameResolver, this.metadataVersion, (Function1)new DeserializedPackageFragmentImpl.classDataFinder.1(this));
    this._proto = paramPackageFragment;
  }
  
  @NotNull
  public ProtoBasedClassDataFinder getClassDataFinder()
  {
    return this.classDataFinder;
  }
  
  @NotNull
  public MemberScope getMemberScope()
  {
    MemberScope localMemberScope = this._memberScope;
    if (localMemberScope == null) {
      Intrinsics.throwUninitializedPropertyAccessException("_memberScope");
    }
    return localMemberScope;
  }
  
  public void initialize(@NotNull DeserializationComponents paramDeserializationComponents)
  {
    Intrinsics.checkParameterIsNotNull(paramDeserializationComponents, "components");
    Object localObject = this._proto;
    if (localObject != null)
    {
      this._proto = ((ProtoBuf.PackageFragment)null);
      PackageFragmentDescriptor localPackageFragmentDescriptor = (PackageFragmentDescriptor)this;
      localObject = ((ProtoBuf.PackageFragment)localObject).getPackage();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "proto.`package`");
      this._memberScope = ((MemberScope)new DeserializedPackageMemberScope(localPackageFragmentDescriptor, (ProtoBuf.Package)localObject, (NameResolver)this.nameResolver, this.metadataVersion, this.containerSource, paramDeserializationComponents, (Function0)new DeserializedPackageFragmentImpl.initialize.1(this)));
      return;
    }
    throw ((Throwable)new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl
 * JD-Core Version:    0.7.0.1
 */
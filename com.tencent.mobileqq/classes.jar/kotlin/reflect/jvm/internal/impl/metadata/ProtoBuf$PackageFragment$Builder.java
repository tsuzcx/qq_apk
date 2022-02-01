package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder;

public final class ProtoBuf$PackageFragment$Builder
  extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf.PackageFragment, Builder>
  implements ProtoBuf.PackageFragmentOrBuilder
{
  private int bitField0_;
  private List<ProtoBuf.Class> class__ = Collections.emptyList();
  private ProtoBuf.Package package_ = ProtoBuf.Package.getDefaultInstance();
  private ProtoBuf.QualifiedNameTable qualifiedNames_ = ProtoBuf.QualifiedNameTable.getDefaultInstance();
  private ProtoBuf.StringTable strings_ = ProtoBuf.StringTable.getDefaultInstance();
  
  private ProtoBuf$PackageFragment$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void ensureClass_IsMutable()
  {
    if ((this.bitField0_ & 0x8) != 8)
    {
      this.class__ = new ArrayList(this.class__);
      this.bitField0_ |= 0x8;
    }
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.PackageFragment build()
  {
    ProtoBuf.PackageFragment localPackageFragment = buildPartial();
    if (localPackageFragment.isInitialized()) {
      return localPackageFragment;
    }
    throw newUninitializedMessageException(localPackageFragment);
  }
  
  public ProtoBuf.PackageFragment buildPartial()
  {
    ProtoBuf.PackageFragment localPackageFragment = new ProtoBuf.PackageFragment(this, null);
    int k = this.bitField0_;
    int j = 1;
    if ((k & 0x1) != 1) {
      j = 0;
    }
    ProtoBuf.PackageFragment.access$21602(localPackageFragment, this.strings_);
    int i = j;
    if ((k & 0x2) == 2) {
      i = j | 0x2;
    }
    ProtoBuf.PackageFragment.access$21702(localPackageFragment, this.qualifiedNames_);
    j = i;
    if ((k & 0x4) == 4) {
      j = i | 0x4;
    }
    ProtoBuf.PackageFragment.access$21802(localPackageFragment, this.package_);
    if ((this.bitField0_ & 0x8) == 8)
    {
      this.class__ = Collections.unmodifiableList(this.class__);
      this.bitField0_ &= 0xFFFFFFF7;
    }
    ProtoBuf.PackageFragment.access$21902(localPackageFragment, this.class__);
    ProtoBuf.PackageFragment.access$22002(localPackageFragment, j);
    return localPackageFragment;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.Class getClass_(int paramInt)
  {
    return (ProtoBuf.Class)this.class__.get(paramInt);
  }
  
  public int getClass_Count()
  {
    return this.class__.size();
  }
  
  public ProtoBuf.PackageFragment getDefaultInstanceForType()
  {
    return ProtoBuf.PackageFragment.getDefaultInstance();
  }
  
  public ProtoBuf.Package getPackage()
  {
    return this.package_;
  }
  
  public ProtoBuf.QualifiedNameTable getQualifiedNames()
  {
    return this.qualifiedNames_;
  }
  
  public boolean hasPackage()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public boolean hasQualifiedNames()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public final boolean isInitialized()
  {
    if ((hasQualifiedNames()) && (!getQualifiedNames().isInitialized())) {
      return false;
    }
    if ((hasPackage()) && (!getPackage().isInitialized())) {
      return false;
    }
    int i = 0;
    while (i < getClass_Count())
    {
      if (!getClass_(i).isInitialized()) {
        return false;
      }
      i += 1;
    }
    return extensionsAreInitialized();
  }
  
  public Builder mergeFrom(ProtoBuf.PackageFragment paramPackageFragment)
  {
    if (paramPackageFragment == ProtoBuf.PackageFragment.getDefaultInstance()) {
      return this;
    }
    if (paramPackageFragment.hasStrings()) {
      mergeStrings(paramPackageFragment.getStrings());
    }
    if (paramPackageFragment.hasQualifiedNames()) {
      mergeQualifiedNames(paramPackageFragment.getQualifiedNames());
    }
    if (paramPackageFragment.hasPackage()) {
      mergePackage(paramPackageFragment.getPackage());
    }
    if (!ProtoBuf.PackageFragment.access$21900(paramPackageFragment).isEmpty()) {
      if (this.class__.isEmpty())
      {
        this.class__ = ProtoBuf.PackageFragment.access$21900(paramPackageFragment);
        this.bitField0_ &= 0xFFFFFFF7;
      }
      else
      {
        ensureClass_IsMutable();
        this.class__.addAll(ProtoBuf.PackageFragment.access$21900(paramPackageFragment));
      }
    }
    mergeExtensionFields(paramPackageFragment);
    setUnknownFields(getUnknownFields().concat(ProtoBuf.PackageFragment.access$22100(paramPackageFragment)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 233	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 239 3 0
    //   12: checkcast 77	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 123	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 242	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 77	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 123	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$PackageFragment$Builder;
    //   55: pop
    //   56: aload_2
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	Builder
    //   0	58	1	paramCodedInputStream	kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream
    //   0	58	2	paramExtensionRegistryLite	kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite
    //   1	29	3	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	16	28	finally
    //   35	43	28	finally
    //   2	16	34	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException
    //   43	45	45	finally
  }
  
  public Builder mergePackage(ProtoBuf.Package paramPackage)
  {
    if (((this.bitField0_ & 0x4) == 4) && (this.package_ != ProtoBuf.Package.getDefaultInstance())) {
      this.package_ = ProtoBuf.Package.newBuilder(this.package_).mergeFrom(paramPackage).buildPartial();
    } else {
      this.package_ = paramPackage;
    }
    this.bitField0_ |= 0x4;
    return this;
  }
  
  public Builder mergeQualifiedNames(ProtoBuf.QualifiedNameTable paramQualifiedNameTable)
  {
    if (((this.bitField0_ & 0x2) == 2) && (this.qualifiedNames_ != ProtoBuf.QualifiedNameTable.getDefaultInstance())) {
      this.qualifiedNames_ = ProtoBuf.QualifiedNameTable.newBuilder(this.qualifiedNames_).mergeFrom(paramQualifiedNameTable).buildPartial();
    } else {
      this.qualifiedNames_ = paramQualifiedNameTable;
    }
    this.bitField0_ |= 0x2;
    return this;
  }
  
  public Builder mergeStrings(ProtoBuf.StringTable paramStringTable)
  {
    if (((this.bitField0_ & 0x1) == 1) && (this.strings_ != ProtoBuf.StringTable.getDefaultInstance())) {
      this.strings_ = ProtoBuf.StringTable.newBuilder(this.strings_).mergeFrom(paramStringTable).buildPartial();
    } else {
      this.strings_ = paramStringTable;
    }
    this.bitField0_ |= 0x1;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment.Builder
 * JD-Core Version:    0.7.0.1
 */
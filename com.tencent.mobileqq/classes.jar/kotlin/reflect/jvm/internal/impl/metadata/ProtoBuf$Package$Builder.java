package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder;

public final class ProtoBuf$Package$Builder
  extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf.Package, Builder>
  implements ProtoBuf.PackageOrBuilder
{
  private int bitField0_;
  private List<ProtoBuf.Function> function_ = Collections.emptyList();
  private List<ProtoBuf.Property> property_ = Collections.emptyList();
  private List<ProtoBuf.TypeAlias> typeAlias_ = Collections.emptyList();
  private ProtoBuf.TypeTable typeTable_ = ProtoBuf.TypeTable.getDefaultInstance();
  private ProtoBuf.VersionRequirementTable versionRequirementTable_ = ProtoBuf.VersionRequirementTable.getDefaultInstance();
  
  private ProtoBuf$Package$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void ensureFunctionIsMutable()
  {
    if ((this.bitField0_ & 0x1) != 1)
    {
      this.function_ = new ArrayList(this.function_);
      this.bitField0_ |= 0x1;
    }
  }
  
  private void ensurePropertyIsMutable()
  {
    if ((this.bitField0_ & 0x2) != 2)
    {
      this.property_ = new ArrayList(this.property_);
      this.bitField0_ |= 0x2;
    }
  }
  
  private void ensureTypeAliasIsMutable()
  {
    if ((this.bitField0_ & 0x4) != 4)
    {
      this.typeAlias_ = new ArrayList(this.typeAlias_);
      this.bitField0_ |= 0x4;
    }
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.Package build()
  {
    ProtoBuf.Package localPackage = buildPartial();
    if (localPackage.isInitialized()) {
      return localPackage;
    }
    throw newUninitializedMessageException(localPackage);
  }
  
  public ProtoBuf.Package buildPartial()
  {
    ProtoBuf.Package localPackage = new ProtoBuf.Package(this, null);
    int k = this.bitField0_;
    int i = 1;
    if ((k & 0x1) == 1)
    {
      this.function_ = Collections.unmodifiableList(this.function_);
      this.bitField0_ &= 0xFFFFFFFE;
    }
    ProtoBuf.Package.access$11002(localPackage, this.function_);
    if ((this.bitField0_ & 0x2) == 2)
    {
      this.property_ = Collections.unmodifiableList(this.property_);
      this.bitField0_ &= 0xFFFFFFFD;
    }
    ProtoBuf.Package.access$11102(localPackage, this.property_);
    if ((this.bitField0_ & 0x4) == 4)
    {
      this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
      this.bitField0_ &= 0xFFFFFFFB;
    }
    ProtoBuf.Package.access$11202(localPackage, this.typeAlias_);
    if ((k & 0x8) != 8) {
      i = 0;
    }
    ProtoBuf.Package.access$11302(localPackage, this.typeTable_);
    int j = i;
    if ((k & 0x10) == 16) {
      j = i | 0x2;
    }
    ProtoBuf.Package.access$11402(localPackage, this.versionRequirementTable_);
    ProtoBuf.Package.access$11502(localPackage, j);
    return localPackage;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.Package getDefaultInstanceForType()
  {
    return ProtoBuf.Package.getDefaultInstance();
  }
  
  public ProtoBuf.Function getFunction(int paramInt)
  {
    return (ProtoBuf.Function)this.function_.get(paramInt);
  }
  
  public int getFunctionCount()
  {
    return this.function_.size();
  }
  
  public ProtoBuf.Property getProperty(int paramInt)
  {
    return (ProtoBuf.Property)this.property_.get(paramInt);
  }
  
  public int getPropertyCount()
  {
    return this.property_.size();
  }
  
  public ProtoBuf.TypeAlias getTypeAlias(int paramInt)
  {
    return (ProtoBuf.TypeAlias)this.typeAlias_.get(paramInt);
  }
  
  public int getTypeAliasCount()
  {
    return this.typeAlias_.size();
  }
  
  public ProtoBuf.TypeTable getTypeTable()
  {
    return this.typeTable_;
  }
  
  public boolean hasTypeTable()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public final boolean isInitialized()
  {
    int i = 0;
    while (i < getFunctionCount())
    {
      if (!getFunction(i).isInitialized()) {
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < getPropertyCount())
    {
      if (!getProperty(i).isInitialized()) {
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < getTypeAliasCount())
    {
      if (!getTypeAlias(i).isInitialized()) {
        return false;
      }
      i += 1;
    }
    if ((hasTypeTable()) && (!getTypeTable().isInitialized())) {
      return false;
    }
    return extensionsAreInitialized();
  }
  
  public Builder mergeFrom(ProtoBuf.Package paramPackage)
  {
    if (paramPackage == ProtoBuf.Package.getDefaultInstance()) {
      return this;
    }
    if (!ProtoBuf.Package.access$11000(paramPackage).isEmpty()) {
      if (this.function_.isEmpty())
      {
        this.function_ = ProtoBuf.Package.access$11000(paramPackage);
        this.bitField0_ &= 0xFFFFFFFE;
      }
      else
      {
        ensureFunctionIsMutable();
        this.function_.addAll(ProtoBuf.Package.access$11000(paramPackage));
      }
    }
    if (!ProtoBuf.Package.access$11100(paramPackage).isEmpty()) {
      if (this.property_.isEmpty())
      {
        this.property_ = ProtoBuf.Package.access$11100(paramPackage);
        this.bitField0_ &= 0xFFFFFFFD;
      }
      else
      {
        ensurePropertyIsMutable();
        this.property_.addAll(ProtoBuf.Package.access$11100(paramPackage));
      }
    }
    if (!ProtoBuf.Package.access$11200(paramPackage).isEmpty()) {
      if (this.typeAlias_.isEmpty())
      {
        this.typeAlias_ = ProtoBuf.Package.access$11200(paramPackage);
        this.bitField0_ &= 0xFFFFFFFB;
      }
      else
      {
        ensureTypeAliasIsMutable();
        this.typeAlias_.addAll(ProtoBuf.Package.access$11200(paramPackage));
      }
    }
    if (paramPackage.hasTypeTable()) {
      mergeTypeTable(paramPackage.getTypeTable());
    }
    if (paramPackage.hasVersionRequirementTable()) {
      mergeVersionRequirementTable(paramPackage.getVersionRequirementTable());
    }
    mergeExtensionFields(paramPackage);
    setUnknownFields(getUnknownFields().concat(ProtoBuf.Package.access$11600(paramPackage)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 253	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 259 3 0
    //   12: checkcast 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 126	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 262	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 126	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package$Builder;
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
  
  public Builder mergeTypeTable(ProtoBuf.TypeTable paramTypeTable)
  {
    if (((this.bitField0_ & 0x8) == 8) && (this.typeTable_ != ProtoBuf.TypeTable.getDefaultInstance())) {
      this.typeTable_ = ProtoBuf.TypeTable.newBuilder(this.typeTable_).mergeFrom(paramTypeTable).buildPartial();
    } else {
      this.typeTable_ = paramTypeTable;
    }
    this.bitField0_ |= 0x8;
    return this;
  }
  
  public Builder mergeVersionRequirementTable(ProtoBuf.VersionRequirementTable paramVersionRequirementTable)
  {
    if (((this.bitField0_ & 0x10) == 16) && (this.versionRequirementTable_ != ProtoBuf.VersionRequirementTable.getDefaultInstance())) {
      this.versionRequirementTable_ = ProtoBuf.VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(paramVersionRequirementTable).buildPartial();
    } else {
      this.versionRequirementTable_ = paramVersionRequirementTable;
    }
    this.bitField0_ |= 0x10;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package.Builder
 * JD-Core Version:    0.7.0.1
 */
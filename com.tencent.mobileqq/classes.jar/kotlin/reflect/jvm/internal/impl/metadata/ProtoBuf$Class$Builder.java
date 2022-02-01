package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder;

public final class ProtoBuf$Class$Builder
  extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf.Class, Builder>
  implements ProtoBuf.ClassOrBuilder
{
  private int bitField0_;
  private int companionObjectName_;
  private List<ProtoBuf.Constructor> constructor_ = Collections.emptyList();
  private List<ProtoBuf.EnumEntry> enumEntry_ = Collections.emptyList();
  private int flags_ = 6;
  private int fqName_;
  private List<ProtoBuf.Function> function_ = Collections.emptyList();
  private List<Integer> nestedClassName_ = Collections.emptyList();
  private List<ProtoBuf.Property> property_ = Collections.emptyList();
  private List<Integer> sealedSubclassFqName_ = Collections.emptyList();
  private List<Integer> supertypeId_ = Collections.emptyList();
  private List<ProtoBuf.Type> supertype_ = Collections.emptyList();
  private List<ProtoBuf.TypeAlias> typeAlias_ = Collections.emptyList();
  private List<ProtoBuf.TypeParameter> typeParameter_ = Collections.emptyList();
  private ProtoBuf.TypeTable typeTable_ = ProtoBuf.TypeTable.getDefaultInstance();
  private ProtoBuf.VersionRequirementTable versionRequirementTable_ = ProtoBuf.VersionRequirementTable.getDefaultInstance();
  private List<Integer> versionRequirement_ = Collections.emptyList();
  
  private ProtoBuf$Class$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void ensureConstructorIsMutable()
  {
    if ((this.bitField0_ & 0x80) != 128)
    {
      this.constructor_ = new ArrayList(this.constructor_);
      this.bitField0_ |= 0x80;
    }
  }
  
  private void ensureEnumEntryIsMutable()
  {
    if ((this.bitField0_ & 0x800) != 2048)
    {
      this.enumEntry_ = new ArrayList(this.enumEntry_);
      this.bitField0_ |= 0x800;
    }
  }
  
  private void ensureFunctionIsMutable()
  {
    if ((this.bitField0_ & 0x100) != 256)
    {
      this.function_ = new ArrayList(this.function_);
      this.bitField0_ |= 0x100;
    }
  }
  
  private void ensureNestedClassNameIsMutable()
  {
    if ((this.bitField0_ & 0x40) != 64)
    {
      this.nestedClassName_ = new ArrayList(this.nestedClassName_);
      this.bitField0_ |= 0x40;
    }
  }
  
  private void ensurePropertyIsMutable()
  {
    if ((this.bitField0_ & 0x200) != 512)
    {
      this.property_ = new ArrayList(this.property_);
      this.bitField0_ |= 0x200;
    }
  }
  
  private void ensureSealedSubclassFqNameIsMutable()
  {
    if ((this.bitField0_ & 0x1000) != 4096)
    {
      this.sealedSubclassFqName_ = new ArrayList(this.sealedSubclassFqName_);
      this.bitField0_ |= 0x1000;
    }
  }
  
  private void ensureSupertypeIdIsMutable()
  {
    if ((this.bitField0_ & 0x20) != 32)
    {
      this.supertypeId_ = new ArrayList(this.supertypeId_);
      this.bitField0_ |= 0x20;
    }
  }
  
  private void ensureSupertypeIsMutable()
  {
    if ((this.bitField0_ & 0x10) != 16)
    {
      this.supertype_ = new ArrayList(this.supertype_);
      this.bitField0_ |= 0x10;
    }
  }
  
  private void ensureTypeAliasIsMutable()
  {
    if ((this.bitField0_ & 0x400) != 1024)
    {
      this.typeAlias_ = new ArrayList(this.typeAlias_);
      this.bitField0_ |= 0x400;
    }
  }
  
  private void ensureTypeParameterIsMutable()
  {
    if ((this.bitField0_ & 0x8) != 8)
    {
      this.typeParameter_ = new ArrayList(this.typeParameter_);
      this.bitField0_ |= 0x8;
    }
  }
  
  private void ensureVersionRequirementIsMutable()
  {
    if ((this.bitField0_ & 0x4000) != 16384)
    {
      this.versionRequirement_ = new ArrayList(this.versionRequirement_);
      this.bitField0_ |= 0x4000;
    }
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.Class build()
  {
    ProtoBuf.Class localClass = buildPartial();
    if (localClass.isInitialized()) {
      return localClass;
    }
    throw newUninitializedMessageException(localClass);
  }
  
  public ProtoBuf.Class buildPartial()
  {
    ProtoBuf.Class localClass = new ProtoBuf.Class(this, null);
    int k = this.bitField0_;
    int j = 1;
    if ((k & 0x1) != 1) {
      j = 0;
    }
    ProtoBuf.Class.access$8902(localClass, this.flags_);
    int i = j;
    if ((k & 0x2) == 2) {
      i = j | 0x2;
    }
    ProtoBuf.Class.access$9002(localClass, this.fqName_);
    j = i;
    if ((k & 0x4) == 4) {
      j = i | 0x4;
    }
    ProtoBuf.Class.access$9102(localClass, this.companionObjectName_);
    if ((this.bitField0_ & 0x8) == 8)
    {
      this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
      this.bitField0_ &= 0xFFFFFFF7;
    }
    ProtoBuf.Class.access$9202(localClass, this.typeParameter_);
    if ((this.bitField0_ & 0x10) == 16)
    {
      this.supertype_ = Collections.unmodifiableList(this.supertype_);
      this.bitField0_ &= 0xFFFFFFEF;
    }
    ProtoBuf.Class.access$9302(localClass, this.supertype_);
    if ((this.bitField0_ & 0x20) == 32)
    {
      this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
      this.bitField0_ &= 0xFFFFFFDF;
    }
    ProtoBuf.Class.access$9402(localClass, this.supertypeId_);
    if ((this.bitField0_ & 0x40) == 64)
    {
      this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
      this.bitField0_ &= 0xFFFFFFBF;
    }
    ProtoBuf.Class.access$9502(localClass, this.nestedClassName_);
    if ((this.bitField0_ & 0x80) == 128)
    {
      this.constructor_ = Collections.unmodifiableList(this.constructor_);
      this.bitField0_ &= 0xFFFFFF7F;
    }
    ProtoBuf.Class.access$9602(localClass, this.constructor_);
    if ((this.bitField0_ & 0x100) == 256)
    {
      this.function_ = Collections.unmodifiableList(this.function_);
      this.bitField0_ &= 0xFFFFFEFF;
    }
    ProtoBuf.Class.access$9702(localClass, this.function_);
    if ((this.bitField0_ & 0x200) == 512)
    {
      this.property_ = Collections.unmodifiableList(this.property_);
      this.bitField0_ &= 0xFFFFFDFF;
    }
    ProtoBuf.Class.access$9802(localClass, this.property_);
    if ((this.bitField0_ & 0x400) == 1024)
    {
      this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
      this.bitField0_ &= 0xFFFFFBFF;
    }
    ProtoBuf.Class.access$9902(localClass, this.typeAlias_);
    if ((this.bitField0_ & 0x800) == 2048)
    {
      this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
      this.bitField0_ &= 0xFFFFF7FF;
    }
    ProtoBuf.Class.access$10002(localClass, this.enumEntry_);
    if ((this.bitField0_ & 0x1000) == 4096)
    {
      this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
      this.bitField0_ &= 0xFFFFEFFF;
    }
    ProtoBuf.Class.access$10102(localClass, this.sealedSubclassFqName_);
    i = j;
    if ((k & 0x2000) == 8192) {
      i = j | 0x8;
    }
    ProtoBuf.Class.access$10202(localClass, this.typeTable_);
    if ((this.bitField0_ & 0x4000) == 16384)
    {
      this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
      this.bitField0_ &= 0xFFFFBFFF;
    }
    ProtoBuf.Class.access$10302(localClass, this.versionRequirement_);
    j = i;
    if ((k & 0x8000) == 32768) {
      j = i | 0x10;
    }
    ProtoBuf.Class.access$10402(localClass, this.versionRequirementTable_);
    ProtoBuf.Class.access$10502(localClass, j);
    return localClass;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.Constructor getConstructor(int paramInt)
  {
    return (ProtoBuf.Constructor)this.constructor_.get(paramInt);
  }
  
  public int getConstructorCount()
  {
    return this.constructor_.size();
  }
  
  public ProtoBuf.Class getDefaultInstanceForType()
  {
    return ProtoBuf.Class.getDefaultInstance();
  }
  
  public ProtoBuf.EnumEntry getEnumEntry(int paramInt)
  {
    return (ProtoBuf.EnumEntry)this.enumEntry_.get(paramInt);
  }
  
  public int getEnumEntryCount()
  {
    return this.enumEntry_.size();
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
  
  public ProtoBuf.Type getSupertype(int paramInt)
  {
    return (ProtoBuf.Type)this.supertype_.get(paramInt);
  }
  
  public int getSupertypeCount()
  {
    return this.supertype_.size();
  }
  
  public ProtoBuf.TypeAlias getTypeAlias(int paramInt)
  {
    return (ProtoBuf.TypeAlias)this.typeAlias_.get(paramInt);
  }
  
  public int getTypeAliasCount()
  {
    return this.typeAlias_.size();
  }
  
  public ProtoBuf.TypeParameter getTypeParameter(int paramInt)
  {
    return (ProtoBuf.TypeParameter)this.typeParameter_.get(paramInt);
  }
  
  public int getTypeParameterCount()
  {
    return this.typeParameter_.size();
  }
  
  public ProtoBuf.TypeTable getTypeTable()
  {
    return this.typeTable_;
  }
  
  public boolean hasFqName()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasTypeTable()
  {
    return (this.bitField0_ & 0x2000) == 8192;
  }
  
  public final boolean isInitialized()
  {
    if (!hasFqName()) {
      return false;
    }
    int i = 0;
    while (i < getTypeParameterCount())
    {
      if (!getTypeParameter(i).isInitialized()) {
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < getSupertypeCount())
    {
      if (!getSupertype(i).isInitialized()) {
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < getConstructorCount())
    {
      if (!getConstructor(i).isInitialized()) {
        return false;
      }
      i += 1;
    }
    i = 0;
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
    i = 0;
    while (i < getEnumEntryCount())
    {
      if (!getEnumEntry(i).isInitialized()) {
        return false;
      }
      i += 1;
    }
    if ((hasTypeTable()) && (!getTypeTable().isInitialized())) {
      return false;
    }
    return extensionsAreInitialized();
  }
  
  public Builder mergeFrom(ProtoBuf.Class paramClass)
  {
    if (paramClass == ProtoBuf.Class.getDefaultInstance()) {
      return this;
    }
    if (paramClass.hasFlags()) {
      setFlags(paramClass.getFlags());
    }
    if (paramClass.hasFqName()) {
      setFqName(paramClass.getFqName());
    }
    if (paramClass.hasCompanionObjectName()) {
      setCompanionObjectName(paramClass.getCompanionObjectName());
    }
    if (!ProtoBuf.Class.access$9200(paramClass).isEmpty()) {
      if (this.typeParameter_.isEmpty())
      {
        this.typeParameter_ = ProtoBuf.Class.access$9200(paramClass);
        this.bitField0_ &= 0xFFFFFFF7;
      }
      else
      {
        ensureTypeParameterIsMutable();
        this.typeParameter_.addAll(ProtoBuf.Class.access$9200(paramClass));
      }
    }
    if (!ProtoBuf.Class.access$9300(paramClass).isEmpty()) {
      if (this.supertype_.isEmpty())
      {
        this.supertype_ = ProtoBuf.Class.access$9300(paramClass);
        this.bitField0_ &= 0xFFFFFFEF;
      }
      else
      {
        ensureSupertypeIsMutable();
        this.supertype_.addAll(ProtoBuf.Class.access$9300(paramClass));
      }
    }
    if (!ProtoBuf.Class.access$9400(paramClass).isEmpty()) {
      if (this.supertypeId_.isEmpty())
      {
        this.supertypeId_ = ProtoBuf.Class.access$9400(paramClass);
        this.bitField0_ &= 0xFFFFFFDF;
      }
      else
      {
        ensureSupertypeIdIsMutable();
        this.supertypeId_.addAll(ProtoBuf.Class.access$9400(paramClass));
      }
    }
    if (!ProtoBuf.Class.access$9500(paramClass).isEmpty()) {
      if (this.nestedClassName_.isEmpty())
      {
        this.nestedClassName_ = ProtoBuf.Class.access$9500(paramClass);
        this.bitField0_ &= 0xFFFFFFBF;
      }
      else
      {
        ensureNestedClassNameIsMutable();
        this.nestedClassName_.addAll(ProtoBuf.Class.access$9500(paramClass));
      }
    }
    if (!ProtoBuf.Class.access$9600(paramClass).isEmpty()) {
      if (this.constructor_.isEmpty())
      {
        this.constructor_ = ProtoBuf.Class.access$9600(paramClass);
        this.bitField0_ &= 0xFFFFFF7F;
      }
      else
      {
        ensureConstructorIsMutable();
        this.constructor_.addAll(ProtoBuf.Class.access$9600(paramClass));
      }
    }
    if (!ProtoBuf.Class.access$9700(paramClass).isEmpty()) {
      if (this.function_.isEmpty())
      {
        this.function_ = ProtoBuf.Class.access$9700(paramClass);
        this.bitField0_ &= 0xFFFFFEFF;
      }
      else
      {
        ensureFunctionIsMutable();
        this.function_.addAll(ProtoBuf.Class.access$9700(paramClass));
      }
    }
    if (!ProtoBuf.Class.access$9800(paramClass).isEmpty()) {
      if (this.property_.isEmpty())
      {
        this.property_ = ProtoBuf.Class.access$9800(paramClass);
        this.bitField0_ &= 0xFFFFFDFF;
      }
      else
      {
        ensurePropertyIsMutable();
        this.property_.addAll(ProtoBuf.Class.access$9800(paramClass));
      }
    }
    if (!ProtoBuf.Class.access$9900(paramClass).isEmpty()) {
      if (this.typeAlias_.isEmpty())
      {
        this.typeAlias_ = ProtoBuf.Class.access$9900(paramClass);
        this.bitField0_ &= 0xFFFFFBFF;
      }
      else
      {
        ensureTypeAliasIsMutable();
        this.typeAlias_.addAll(ProtoBuf.Class.access$9900(paramClass));
      }
    }
    if (!ProtoBuf.Class.access$10000(paramClass).isEmpty()) {
      if (this.enumEntry_.isEmpty())
      {
        this.enumEntry_ = ProtoBuf.Class.access$10000(paramClass);
        this.bitField0_ &= 0xFFFFF7FF;
      }
      else
      {
        ensureEnumEntryIsMutable();
        this.enumEntry_.addAll(ProtoBuf.Class.access$10000(paramClass));
      }
    }
    if (!ProtoBuf.Class.access$10100(paramClass).isEmpty()) {
      if (this.sealedSubclassFqName_.isEmpty())
      {
        this.sealedSubclassFqName_ = ProtoBuf.Class.access$10100(paramClass);
        this.bitField0_ &= 0xFFFFEFFF;
      }
      else
      {
        ensureSealedSubclassFqNameIsMutable();
        this.sealedSubclassFqName_.addAll(ProtoBuf.Class.access$10100(paramClass));
      }
    }
    if (paramClass.hasTypeTable()) {
      mergeTypeTable(paramClass.getTypeTable());
    }
    if (!ProtoBuf.Class.access$10300(paramClass).isEmpty()) {
      if (this.versionRequirement_.isEmpty())
      {
        this.versionRequirement_ = ProtoBuf.Class.access$10300(paramClass);
        this.bitField0_ &= 0xFFFFBFFF;
      }
      else
      {
        ensureVersionRequirementIsMutable();
        this.versionRequirement_.addAll(ProtoBuf.Class.access$10300(paramClass));
      }
    }
    if (paramClass.hasVersionRequirementTable()) {
      mergeVersionRequirementTable(paramClass.getVersionRequirementTable());
    }
    mergeExtensionFields(paramClass);
    setUnknownFields(getUnknownFields().concat(ProtoBuf.Class.access$10600(paramClass)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 442	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 448 3 0
    //   12: checkcast 120	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 206	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 451	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 120	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 206	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Class$Builder;
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
    if (((this.bitField0_ & 0x2000) == 8192) && (this.typeTable_ != ProtoBuf.TypeTable.getDefaultInstance())) {
      this.typeTable_ = ProtoBuf.TypeTable.newBuilder(this.typeTable_).mergeFrom(paramTypeTable).buildPartial();
    } else {
      this.typeTable_ = paramTypeTable;
    }
    this.bitField0_ |= 0x2000;
    return this;
  }
  
  public Builder mergeVersionRequirementTable(ProtoBuf.VersionRequirementTable paramVersionRequirementTable)
  {
    if (((this.bitField0_ & 0x8000) == 32768) && (this.versionRequirementTable_ != ProtoBuf.VersionRequirementTable.getDefaultInstance())) {
      this.versionRequirementTable_ = ProtoBuf.VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(paramVersionRequirementTable).buildPartial();
    } else {
      this.versionRequirementTable_ = paramVersionRequirementTable;
    }
    this.bitField0_ |= 0x8000;
    return this;
  }
  
  public Builder setCompanionObjectName(int paramInt)
  {
    this.bitField0_ |= 0x4;
    this.companionObjectName_ = paramInt;
    return this;
  }
  
  public Builder setFlags(int paramInt)
  {
    this.bitField0_ |= 0x1;
    this.flags_ = paramInt;
    return this;
  }
  
  public Builder setFqName(int paramInt)
  {
    this.bitField0_ |= 0x2;
    this.fqName_ = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Builder
 * JD-Core Version:    0.7.0.1
 */
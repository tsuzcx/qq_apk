package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder;

public final class ProtoBuf$Function$Builder
  extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf.Function, Builder>
  implements ProtoBuf.FunctionOrBuilder
{
  private int bitField0_;
  private ProtoBuf.Contract contract_ = ProtoBuf.Contract.getDefaultInstance();
  private int flags_ = 6;
  private int name_;
  private int oldFlags_ = 6;
  private int receiverTypeId_;
  private ProtoBuf.Type receiverType_ = ProtoBuf.Type.getDefaultInstance();
  private int returnTypeId_;
  private ProtoBuf.Type returnType_ = ProtoBuf.Type.getDefaultInstance();
  private List<ProtoBuf.TypeParameter> typeParameter_ = Collections.emptyList();
  private ProtoBuf.TypeTable typeTable_ = ProtoBuf.TypeTable.getDefaultInstance();
  private List<ProtoBuf.ValueParameter> valueParameter_ = Collections.emptyList();
  private List<Integer> versionRequirement_ = Collections.emptyList();
  
  private ProtoBuf$Function$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void ensureTypeParameterIsMutable()
  {
    if ((this.bitField0_ & 0x20) != 32)
    {
      this.typeParameter_ = new ArrayList(this.typeParameter_);
      this.bitField0_ |= 0x20;
    }
  }
  
  private void ensureValueParameterIsMutable()
  {
    if ((this.bitField0_ & 0x100) != 256)
    {
      this.valueParameter_ = new ArrayList(this.valueParameter_);
      this.bitField0_ |= 0x100;
    }
  }
  
  private void ensureVersionRequirementIsMutable()
  {
    if ((this.bitField0_ & 0x400) != 1024)
    {
      this.versionRequirement_ = new ArrayList(this.versionRequirement_);
      this.bitField0_ |= 0x400;
    }
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.Function build()
  {
    ProtoBuf.Function localFunction = buildPartial();
    if (localFunction.isInitialized()) {
      return localFunction;
    }
    throw newUninitializedMessageException(localFunction);
  }
  
  public ProtoBuf.Function buildPartial()
  {
    ProtoBuf.Function localFunction = new ProtoBuf.Function(this, null);
    int k = this.bitField0_;
    int j = 1;
    if ((k & 0x1) != 1) {
      j = 0;
    }
    ProtoBuf.Function.access$13502(localFunction, this.flags_);
    int i = j;
    if ((k & 0x2) == 2) {
      i = j | 0x2;
    }
    ProtoBuf.Function.access$13602(localFunction, this.oldFlags_);
    j = i;
    if ((k & 0x4) == 4) {
      j = i | 0x4;
    }
    ProtoBuf.Function.access$13702(localFunction, this.name_);
    i = j;
    if ((k & 0x8) == 8) {
      i = j | 0x8;
    }
    ProtoBuf.Function.access$13802(localFunction, this.returnType_);
    j = i;
    if ((k & 0x10) == 16) {
      j = i | 0x10;
    }
    ProtoBuf.Function.access$13902(localFunction, this.returnTypeId_);
    if ((this.bitField0_ & 0x20) == 32)
    {
      this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
      this.bitField0_ &= 0xFFFFFFDF;
    }
    ProtoBuf.Function.access$14002(localFunction, this.typeParameter_);
    i = j;
    if ((k & 0x40) == 64) {
      i = j | 0x20;
    }
    ProtoBuf.Function.access$14102(localFunction, this.receiverType_);
    j = i;
    if ((k & 0x80) == 128) {
      j = i | 0x40;
    }
    ProtoBuf.Function.access$14202(localFunction, this.receiverTypeId_);
    if ((this.bitField0_ & 0x100) == 256)
    {
      this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
      this.bitField0_ &= 0xFFFFFEFF;
    }
    ProtoBuf.Function.access$14302(localFunction, this.valueParameter_);
    i = j;
    if ((k & 0x200) == 512) {
      i = j | 0x80;
    }
    ProtoBuf.Function.access$14402(localFunction, this.typeTable_);
    if ((this.bitField0_ & 0x400) == 1024)
    {
      this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
      this.bitField0_ &= 0xFFFFFBFF;
    }
    ProtoBuf.Function.access$14502(localFunction, this.versionRequirement_);
    j = i;
    if ((k & 0x800) == 2048) {
      j = i | 0x100;
    }
    ProtoBuf.Function.access$14602(localFunction, this.contract_);
    ProtoBuf.Function.access$14702(localFunction, j);
    return localFunction;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.Contract getContract()
  {
    return this.contract_;
  }
  
  public ProtoBuf.Function getDefaultInstanceForType()
  {
    return ProtoBuf.Function.getDefaultInstance();
  }
  
  public ProtoBuf.Type getReceiverType()
  {
    return this.receiverType_;
  }
  
  public ProtoBuf.Type getReturnType()
  {
    return this.returnType_;
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
  
  public ProtoBuf.ValueParameter getValueParameter(int paramInt)
  {
    return (ProtoBuf.ValueParameter)this.valueParameter_.get(paramInt);
  }
  
  public int getValueParameterCount()
  {
    return this.valueParameter_.size();
  }
  
  public boolean hasContract()
  {
    return (this.bitField0_ & 0x800) == 2048;
  }
  
  public boolean hasName()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public boolean hasReceiverType()
  {
    return (this.bitField0_ & 0x40) == 64;
  }
  
  public boolean hasReturnType()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public boolean hasTypeTable()
  {
    return (this.bitField0_ & 0x200) == 512;
  }
  
  public final boolean isInitialized()
  {
    if (!hasName()) {
      return false;
    }
    if ((hasReturnType()) && (!getReturnType().isInitialized())) {
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
    if ((hasReceiverType()) && (!getReceiverType().isInitialized())) {
      return false;
    }
    i = 0;
    while (i < getValueParameterCount())
    {
      if (!getValueParameter(i).isInitialized()) {
        return false;
      }
      i += 1;
    }
    if ((hasTypeTable()) && (!getTypeTable().isInitialized())) {
      return false;
    }
    if ((hasContract()) && (!getContract().isInitialized())) {
      return false;
    }
    return extensionsAreInitialized();
  }
  
  public Builder mergeContract(ProtoBuf.Contract paramContract)
  {
    if (((this.bitField0_ & 0x800) == 2048) && (this.contract_ != ProtoBuf.Contract.getDefaultInstance())) {
      this.contract_ = ProtoBuf.Contract.newBuilder(this.contract_).mergeFrom(paramContract).buildPartial();
    } else {
      this.contract_ = paramContract;
    }
    this.bitField0_ |= 0x800;
    return this;
  }
  
  public Builder mergeFrom(ProtoBuf.Function paramFunction)
  {
    if (paramFunction == ProtoBuf.Function.getDefaultInstance()) {
      return this;
    }
    if (paramFunction.hasFlags()) {
      setFlags(paramFunction.getFlags());
    }
    if (paramFunction.hasOldFlags()) {
      setOldFlags(paramFunction.getOldFlags());
    }
    if (paramFunction.hasName()) {
      setName(paramFunction.getName());
    }
    if (paramFunction.hasReturnType()) {
      mergeReturnType(paramFunction.getReturnType());
    }
    if (paramFunction.hasReturnTypeId()) {
      setReturnTypeId(paramFunction.getReturnTypeId());
    }
    if (!ProtoBuf.Function.access$14000(paramFunction).isEmpty()) {
      if (this.typeParameter_.isEmpty())
      {
        this.typeParameter_ = ProtoBuf.Function.access$14000(paramFunction);
        this.bitField0_ &= 0xFFFFFFDF;
      }
      else
      {
        ensureTypeParameterIsMutable();
        this.typeParameter_.addAll(ProtoBuf.Function.access$14000(paramFunction));
      }
    }
    if (paramFunction.hasReceiverType()) {
      mergeReceiverType(paramFunction.getReceiverType());
    }
    if (paramFunction.hasReceiverTypeId()) {
      setReceiverTypeId(paramFunction.getReceiverTypeId());
    }
    if (!ProtoBuf.Function.access$14300(paramFunction).isEmpty()) {
      if (this.valueParameter_.isEmpty())
      {
        this.valueParameter_ = ProtoBuf.Function.access$14300(paramFunction);
        this.bitField0_ &= 0xFFFFFEFF;
      }
      else
      {
        ensureValueParameterIsMutable();
        this.valueParameter_.addAll(ProtoBuf.Function.access$14300(paramFunction));
      }
    }
    if (paramFunction.hasTypeTable()) {
      mergeTypeTable(paramFunction.getTypeTable());
    }
    if (!ProtoBuf.Function.access$14500(paramFunction).isEmpty()) {
      if (this.versionRequirement_.isEmpty())
      {
        this.versionRequirement_ = ProtoBuf.Function.access$14500(paramFunction);
        this.bitField0_ &= 0xFFFFFBFF;
      }
      else
      {
        ensureVersionRequirementIsMutable();
        this.versionRequirement_.addAll(ProtoBuf.Function.access$14500(paramFunction));
      }
    }
    if (paramFunction.hasContract()) {
      mergeContract(paramFunction.getContract());
    }
    mergeExtensionFields(paramFunction);
    setUnknownFields(getUnknownFields().concat(ProtoBuf.Function.access$14800(paramFunction)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 376	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 382 3 0
    //   12: checkcast 99	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 175	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 385	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 99	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 175	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function$Builder;
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
  
  public Builder mergeReceiverType(ProtoBuf.Type paramType)
  {
    if (((this.bitField0_ & 0x40) == 64) && (this.receiverType_ != ProtoBuf.Type.getDefaultInstance())) {
      this.receiverType_ = ProtoBuf.Type.newBuilder(this.receiverType_).mergeFrom(paramType).buildPartial();
    } else {
      this.receiverType_ = paramType;
    }
    this.bitField0_ |= 0x40;
    return this;
  }
  
  public Builder mergeReturnType(ProtoBuf.Type paramType)
  {
    if (((this.bitField0_ & 0x8) == 8) && (this.returnType_ != ProtoBuf.Type.getDefaultInstance())) {
      this.returnType_ = ProtoBuf.Type.newBuilder(this.returnType_).mergeFrom(paramType).buildPartial();
    } else {
      this.returnType_ = paramType;
    }
    this.bitField0_ |= 0x8;
    return this;
  }
  
  public Builder mergeTypeTable(ProtoBuf.TypeTable paramTypeTable)
  {
    if (((this.bitField0_ & 0x200) == 512) && (this.typeTable_ != ProtoBuf.TypeTable.getDefaultInstance())) {
      this.typeTable_ = ProtoBuf.TypeTable.newBuilder(this.typeTable_).mergeFrom(paramTypeTable).buildPartial();
    } else {
      this.typeTable_ = paramTypeTable;
    }
    this.bitField0_ |= 0x200;
    return this;
  }
  
  public Builder setFlags(int paramInt)
  {
    this.bitField0_ |= 0x1;
    this.flags_ = paramInt;
    return this;
  }
  
  public Builder setName(int paramInt)
  {
    this.bitField0_ |= 0x4;
    this.name_ = paramInt;
    return this;
  }
  
  public Builder setOldFlags(int paramInt)
  {
    this.bitField0_ |= 0x2;
    this.oldFlags_ = paramInt;
    return this;
  }
  
  public Builder setReceiverTypeId(int paramInt)
  {
    this.bitField0_ |= 0x80;
    this.receiverTypeId_ = paramInt;
    return this;
  }
  
  public Builder setReturnTypeId(int paramInt)
  {
    this.bitField0_ |= 0x10;
    this.returnTypeId_ = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.Builder
 * JD-Core Version:    0.7.0.1
 */
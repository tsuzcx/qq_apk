package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder;

public final class ProtoBuf$ValueParameter$Builder
  extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf.ValueParameter, Builder>
  implements ProtoBuf.ValueParameterOrBuilder
{
  private int bitField0_;
  private int flags_;
  private int name_;
  private int typeId_;
  private ProtoBuf.Type type_ = ProtoBuf.Type.getDefaultInstance();
  private int varargElementTypeId_;
  private ProtoBuf.Type varargElementType_ = ProtoBuf.Type.getDefaultInstance();
  
  private ProtoBuf$ValueParameter$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.ValueParameter build()
  {
    ProtoBuf.ValueParameter localValueParameter = buildPartial();
    if (localValueParameter.isInitialized()) {
      return localValueParameter;
    }
    throw newUninitializedMessageException(localValueParameter);
  }
  
  public ProtoBuf.ValueParameter buildPartial()
  {
    ProtoBuf.ValueParameter localValueParameter = new ProtoBuf.ValueParameter(this, null);
    int k = this.bitField0_;
    int j = 1;
    if ((k & 0x1) != 1) {
      j = 0;
    }
    ProtoBuf.ValueParameter.access$16902(localValueParameter, this.flags_);
    int i = j;
    if ((k & 0x2) == 2) {
      i = j | 0x2;
    }
    ProtoBuf.ValueParameter.access$17002(localValueParameter, this.name_);
    j = i;
    if ((k & 0x4) == 4) {
      j = i | 0x4;
    }
    ProtoBuf.ValueParameter.access$17102(localValueParameter, this.type_);
    i = j;
    if ((k & 0x8) == 8) {
      i = j | 0x8;
    }
    ProtoBuf.ValueParameter.access$17202(localValueParameter, this.typeId_);
    j = i;
    if ((k & 0x10) == 16) {
      j = i | 0x10;
    }
    ProtoBuf.ValueParameter.access$17302(localValueParameter, this.varargElementType_);
    i = j;
    if ((k & 0x20) == 32) {
      i = j | 0x20;
    }
    ProtoBuf.ValueParameter.access$17402(localValueParameter, this.varargElementTypeId_);
    ProtoBuf.ValueParameter.access$17502(localValueParameter, i);
    return localValueParameter;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.ValueParameter getDefaultInstanceForType()
  {
    return ProtoBuf.ValueParameter.getDefaultInstance();
  }
  
  public ProtoBuf.Type getType()
  {
    return this.type_;
  }
  
  public ProtoBuf.Type getVarargElementType()
  {
    return this.varargElementType_;
  }
  
  public boolean hasName()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasType()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public boolean hasVarargElementType()
  {
    return (this.bitField0_ & 0x10) == 16;
  }
  
  public final boolean isInitialized()
  {
    if (!hasName()) {
      return false;
    }
    if ((hasType()) && (!getType().isInitialized())) {
      return false;
    }
    if ((hasVarargElementType()) && (!getVarargElementType().isInitialized())) {
      return false;
    }
    return extensionsAreInitialized();
  }
  
  public Builder mergeFrom(ProtoBuf.ValueParameter paramValueParameter)
  {
    if (paramValueParameter == ProtoBuf.ValueParameter.getDefaultInstance()) {
      return this;
    }
    if (paramValueParameter.hasFlags()) {
      setFlags(paramValueParameter.getFlags());
    }
    if (paramValueParameter.hasName()) {
      setName(paramValueParameter.getName());
    }
    if (paramValueParameter.hasType()) {
      mergeType(paramValueParameter.getType());
    }
    if (paramValueParameter.hasTypeId()) {
      setTypeId(paramValueParameter.getTypeId());
    }
    if (paramValueParameter.hasVarargElementType()) {
      mergeVarargElementType(paramValueParameter.getVarargElementType());
    }
    if (paramValueParameter.hasVarargElementTypeId()) {
      setVarargElementTypeId(paramValueParameter.getVarargElementTypeId());
    }
    mergeExtensionFields(paramValueParameter);
    setUnknownFields(getUnknownFields().concat(ProtoBuf.ValueParameter.access$17600(paramValueParameter)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 206	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 212 3 0
    //   12: checkcast 47	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 102	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 215	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 47	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 102	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$ValueParameter$Builder;
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
  
  public Builder mergeType(ProtoBuf.Type paramType)
  {
    if (((this.bitField0_ & 0x4) == 4) && (this.type_ != ProtoBuf.Type.getDefaultInstance())) {
      this.type_ = ProtoBuf.Type.newBuilder(this.type_).mergeFrom(paramType).buildPartial();
    } else {
      this.type_ = paramType;
    }
    this.bitField0_ |= 0x4;
    return this;
  }
  
  public Builder mergeVarargElementType(ProtoBuf.Type paramType)
  {
    if (((this.bitField0_ & 0x10) == 16) && (this.varargElementType_ != ProtoBuf.Type.getDefaultInstance())) {
      this.varargElementType_ = ProtoBuf.Type.newBuilder(this.varargElementType_).mergeFrom(paramType).buildPartial();
    } else {
      this.varargElementType_ = paramType;
    }
    this.bitField0_ |= 0x10;
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
    this.bitField0_ |= 0x2;
    this.name_ = paramInt;
    return this;
  }
  
  public Builder setTypeId(int paramInt)
  {
    this.bitField0_ |= 0x8;
    this.typeId_ = paramInt;
    return this;
  }
  
  public Builder setVarargElementTypeId(int paramInt)
  {
    this.bitField0_ |= 0x20;
    this.varargElementTypeId_ = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter.Builder
 * JD-Core Version:    0.7.0.1
 */
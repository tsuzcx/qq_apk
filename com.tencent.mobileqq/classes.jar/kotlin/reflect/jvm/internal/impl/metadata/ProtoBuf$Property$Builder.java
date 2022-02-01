package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder;

public final class ProtoBuf$Property$Builder
  extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf.Property, Builder>
  implements ProtoBuf.PropertyOrBuilder
{
  private int bitField0_;
  private int flags_ = 518;
  private int getterFlags_;
  private int name_;
  private int oldFlags_ = 2054;
  private int receiverTypeId_;
  private ProtoBuf.Type receiverType_ = ProtoBuf.Type.getDefaultInstance();
  private int returnTypeId_;
  private ProtoBuf.Type returnType_ = ProtoBuf.Type.getDefaultInstance();
  private int setterFlags_;
  private ProtoBuf.ValueParameter setterValueParameter_ = ProtoBuf.ValueParameter.getDefaultInstance();
  private List<ProtoBuf.TypeParameter> typeParameter_ = Collections.emptyList();
  private List<Integer> versionRequirement_ = Collections.emptyList();
  
  private ProtoBuf$Property$Builder()
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
  
  private void ensureVersionRequirementIsMutable()
  {
    if ((this.bitField0_ & 0x800) != 2048)
    {
      this.versionRequirement_ = new ArrayList(this.versionRequirement_);
      this.bitField0_ |= 0x800;
    }
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.Property build()
  {
    ProtoBuf.Property localProperty = buildPartial();
    if (localProperty.isInitialized()) {
      return localProperty;
    }
    throw newUninitializedMessageException(localProperty);
  }
  
  public ProtoBuf.Property buildPartial()
  {
    ProtoBuf.Property localProperty = new ProtoBuf.Property(this, null);
    int k = this.bitField0_;
    int j = 1;
    if ((k & 0x1) != 1) {
      j = 0;
    }
    ProtoBuf.Property.access$15202(localProperty, this.flags_);
    int i = j;
    if ((k & 0x2) == 2) {
      i = j | 0x2;
    }
    ProtoBuf.Property.access$15302(localProperty, this.oldFlags_);
    j = i;
    if ((k & 0x4) == 4) {
      j = i | 0x4;
    }
    ProtoBuf.Property.access$15402(localProperty, this.name_);
    i = j;
    if ((k & 0x8) == 8) {
      i = j | 0x8;
    }
    ProtoBuf.Property.access$15502(localProperty, this.returnType_);
    j = i;
    if ((k & 0x10) == 16) {
      j = i | 0x10;
    }
    ProtoBuf.Property.access$15602(localProperty, this.returnTypeId_);
    if ((this.bitField0_ & 0x20) == 32)
    {
      this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
      this.bitField0_ &= 0xFFFFFFDF;
    }
    ProtoBuf.Property.access$15702(localProperty, this.typeParameter_);
    i = j;
    if ((k & 0x40) == 64) {
      i = j | 0x20;
    }
    ProtoBuf.Property.access$15802(localProperty, this.receiverType_);
    j = i;
    if ((k & 0x80) == 128) {
      j = i | 0x40;
    }
    ProtoBuf.Property.access$15902(localProperty, this.receiverTypeId_);
    i = j;
    if ((k & 0x100) == 256) {
      i = j | 0x80;
    }
    ProtoBuf.Property.access$16002(localProperty, this.setterValueParameter_);
    j = i;
    if ((k & 0x200) == 512) {
      j = i | 0x100;
    }
    ProtoBuf.Property.access$16102(localProperty, this.getterFlags_);
    i = j;
    if ((k & 0x400) == 1024) {
      i = j | 0x200;
    }
    ProtoBuf.Property.access$16202(localProperty, this.setterFlags_);
    if ((this.bitField0_ & 0x800) == 2048)
    {
      this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
      this.bitField0_ &= 0xFFFFF7FF;
    }
    ProtoBuf.Property.access$16302(localProperty, this.versionRequirement_);
    ProtoBuf.Property.access$16402(localProperty, i);
    return localProperty;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.Property getDefaultInstanceForType()
  {
    return ProtoBuf.Property.getDefaultInstance();
  }
  
  public ProtoBuf.Type getReceiverType()
  {
    return this.receiverType_;
  }
  
  public ProtoBuf.Type getReturnType()
  {
    return this.returnType_;
  }
  
  public ProtoBuf.ValueParameter getSetterValueParameter()
  {
    return this.setterValueParameter_;
  }
  
  public ProtoBuf.TypeParameter getTypeParameter(int paramInt)
  {
    return (ProtoBuf.TypeParameter)this.typeParameter_.get(paramInt);
  }
  
  public int getTypeParameterCount()
  {
    return this.typeParameter_.size();
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
  
  public boolean hasSetterValueParameter()
  {
    return (this.bitField0_ & 0x100) == 256;
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
    if ((hasSetterValueParameter()) && (!getSetterValueParameter().isInitialized())) {
      return false;
    }
    return extensionsAreInitialized();
  }
  
  public Builder mergeFrom(ProtoBuf.Property paramProperty)
  {
    if (paramProperty == ProtoBuf.Property.getDefaultInstance()) {
      return this;
    }
    if (paramProperty.hasFlags()) {
      setFlags(paramProperty.getFlags());
    }
    if (paramProperty.hasOldFlags()) {
      setOldFlags(paramProperty.getOldFlags());
    }
    if (paramProperty.hasName()) {
      setName(paramProperty.getName());
    }
    if (paramProperty.hasReturnType()) {
      mergeReturnType(paramProperty.getReturnType());
    }
    if (paramProperty.hasReturnTypeId()) {
      setReturnTypeId(paramProperty.getReturnTypeId());
    }
    if (!ProtoBuf.Property.access$15700(paramProperty).isEmpty()) {
      if (this.typeParameter_.isEmpty())
      {
        this.typeParameter_ = ProtoBuf.Property.access$15700(paramProperty);
        this.bitField0_ &= 0xFFFFFFDF;
      }
      else
      {
        ensureTypeParameterIsMutable();
        this.typeParameter_.addAll(ProtoBuf.Property.access$15700(paramProperty));
      }
    }
    if (paramProperty.hasReceiverType()) {
      mergeReceiverType(paramProperty.getReceiverType());
    }
    if (paramProperty.hasReceiverTypeId()) {
      setReceiverTypeId(paramProperty.getReceiverTypeId());
    }
    if (paramProperty.hasSetterValueParameter()) {
      mergeSetterValueParameter(paramProperty.getSetterValueParameter());
    }
    if (paramProperty.hasGetterFlags()) {
      setGetterFlags(paramProperty.getGetterFlags());
    }
    if (paramProperty.hasSetterFlags()) {
      setSetterFlags(paramProperty.getSetterFlags());
    }
    if (!ProtoBuf.Property.access$16300(paramProperty).isEmpty()) {
      if (this.versionRequirement_.isEmpty())
      {
        this.versionRequirement_ = ProtoBuf.Property.access$16300(paramProperty);
        this.bitField0_ &= 0xFFFFF7FF;
      }
      else
      {
        ensureVersionRequirementIsMutable();
        this.versionRequirement_.addAll(ProtoBuf.Property.access$16300(paramProperty));
      }
    }
    mergeExtensionFields(paramProperty);
    setUnknownFields(getUnknownFields().concat(ProtoBuf.Property.access$16500(paramProperty)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 347	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 353 3 0
    //   12: checkcast 87	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 166	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 356	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 87	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 166	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property$Builder;
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
  
  public Builder mergeSetterValueParameter(ProtoBuf.ValueParameter paramValueParameter)
  {
    if (((this.bitField0_ & 0x100) == 256) && (this.setterValueParameter_ != ProtoBuf.ValueParameter.getDefaultInstance())) {
      this.setterValueParameter_ = ProtoBuf.ValueParameter.newBuilder(this.setterValueParameter_).mergeFrom(paramValueParameter).buildPartial();
    } else {
      this.setterValueParameter_ = paramValueParameter;
    }
    this.bitField0_ |= 0x100;
    return this;
  }
  
  public Builder setFlags(int paramInt)
  {
    this.bitField0_ |= 0x1;
    this.flags_ = paramInt;
    return this;
  }
  
  public Builder setGetterFlags(int paramInt)
  {
    this.bitField0_ |= 0x200;
    this.getterFlags_ = paramInt;
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
  
  public Builder setSetterFlags(int paramInt)
  {
    this.bitField0_ |= 0x400;
    this.setterFlags_ = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.Builder
 * JD-Core Version:    0.7.0.1
 */
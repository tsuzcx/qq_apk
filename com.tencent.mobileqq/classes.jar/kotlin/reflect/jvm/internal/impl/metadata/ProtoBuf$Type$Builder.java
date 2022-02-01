package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder;

public final class ProtoBuf$Type$Builder
  extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf.Type, Builder>
  implements ProtoBuf.TypeOrBuilder
{
  private int abbreviatedTypeId_;
  private ProtoBuf.Type abbreviatedType_ = ProtoBuf.Type.getDefaultInstance();
  private List<ProtoBuf.Type.Argument> argument_ = Collections.emptyList();
  private int bitField0_;
  private int className_;
  private int flags_;
  private int flexibleTypeCapabilitiesId_;
  private int flexibleUpperBoundId_;
  private ProtoBuf.Type flexibleUpperBound_ = ProtoBuf.Type.getDefaultInstance();
  private boolean nullable_;
  private int outerTypeId_;
  private ProtoBuf.Type outerType_ = ProtoBuf.Type.getDefaultInstance();
  private int typeAliasName_;
  private int typeParameterName_;
  private int typeParameter_;
  
  private ProtoBuf$Type$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void ensureArgumentIsMutable()
  {
    if ((this.bitField0_ & 0x1) != 1)
    {
      this.argument_ = new ArrayList(this.argument_);
      this.bitField0_ |= 0x1;
    }
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.Type build()
  {
    ProtoBuf.Type localType = buildPartial();
    if (localType.isInitialized()) {
      return localType;
    }
    throw newUninitializedMessageException(localType);
  }
  
  public ProtoBuf.Type buildPartial()
  {
    ProtoBuf.Type localType = new ProtoBuf.Type(this, null);
    int k = this.bitField0_;
    int j = 1;
    if ((k & 0x1) == 1)
    {
      this.argument_ = Collections.unmodifiableList(this.argument_);
      this.bitField0_ &= 0xFFFFFFFE;
    }
    ProtoBuf.Type.access$5902(localType, this.argument_);
    if ((k & 0x2) != 2) {
      j = 0;
    }
    ProtoBuf.Type.access$6002(localType, this.nullable_);
    int i = j;
    if ((k & 0x4) == 4) {
      i = j | 0x2;
    }
    ProtoBuf.Type.access$6102(localType, this.flexibleTypeCapabilitiesId_);
    j = i;
    if ((k & 0x8) == 8) {
      j = i | 0x4;
    }
    ProtoBuf.Type.access$6202(localType, this.flexibleUpperBound_);
    i = j;
    if ((k & 0x10) == 16) {
      i = j | 0x8;
    }
    ProtoBuf.Type.access$6302(localType, this.flexibleUpperBoundId_);
    j = i;
    if ((k & 0x20) == 32) {
      j = i | 0x10;
    }
    ProtoBuf.Type.access$6402(localType, this.className_);
    i = j;
    if ((k & 0x40) == 64) {
      i = j | 0x20;
    }
    ProtoBuf.Type.access$6502(localType, this.typeParameter_);
    j = i;
    if ((k & 0x80) == 128) {
      j = i | 0x40;
    }
    ProtoBuf.Type.access$6602(localType, this.typeParameterName_);
    i = j;
    if ((k & 0x100) == 256) {
      i = j | 0x80;
    }
    ProtoBuf.Type.access$6702(localType, this.typeAliasName_);
    j = i;
    if ((k & 0x200) == 512) {
      j = i | 0x100;
    }
    ProtoBuf.Type.access$6802(localType, this.outerType_);
    i = j;
    if ((k & 0x400) == 1024) {
      i = j | 0x200;
    }
    ProtoBuf.Type.access$6902(localType, this.outerTypeId_);
    j = i;
    if ((k & 0x800) == 2048) {
      j = i | 0x400;
    }
    ProtoBuf.Type.access$7002(localType, this.abbreviatedType_);
    i = j;
    if ((k & 0x1000) == 4096) {
      i = j | 0x800;
    }
    ProtoBuf.Type.access$7102(localType, this.abbreviatedTypeId_);
    j = i;
    if ((k & 0x2000) == 8192) {
      j = i | 0x1000;
    }
    ProtoBuf.Type.access$7202(localType, this.flags_);
    ProtoBuf.Type.access$7302(localType, j);
    return localType;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.Type getAbbreviatedType()
  {
    return this.abbreviatedType_;
  }
  
  public ProtoBuf.Type.Argument getArgument(int paramInt)
  {
    return (ProtoBuf.Type.Argument)this.argument_.get(paramInt);
  }
  
  public int getArgumentCount()
  {
    return this.argument_.size();
  }
  
  public ProtoBuf.Type getDefaultInstanceForType()
  {
    return ProtoBuf.Type.getDefaultInstance();
  }
  
  public ProtoBuf.Type getFlexibleUpperBound()
  {
    return this.flexibleUpperBound_;
  }
  
  public ProtoBuf.Type getOuterType()
  {
    return this.outerType_;
  }
  
  public boolean hasAbbreviatedType()
  {
    return (this.bitField0_ & 0x800) == 2048;
  }
  
  public boolean hasFlexibleUpperBound()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public boolean hasOuterType()
  {
    return (this.bitField0_ & 0x200) == 512;
  }
  
  public final boolean isInitialized()
  {
    int i = 0;
    while (i < getArgumentCount())
    {
      if (!getArgument(i).isInitialized()) {
        return false;
      }
      i += 1;
    }
    if ((hasFlexibleUpperBound()) && (!getFlexibleUpperBound().isInitialized())) {
      return false;
    }
    if ((hasOuterType()) && (!getOuterType().isInitialized())) {
      return false;
    }
    if ((hasAbbreviatedType()) && (!getAbbreviatedType().isInitialized())) {
      return false;
    }
    return extensionsAreInitialized();
  }
  
  public Builder mergeAbbreviatedType(ProtoBuf.Type paramType)
  {
    if (((this.bitField0_ & 0x800) == 2048) && (this.abbreviatedType_ != ProtoBuf.Type.getDefaultInstance())) {
      this.abbreviatedType_ = ProtoBuf.Type.newBuilder(this.abbreviatedType_).mergeFrom(paramType).buildPartial();
    } else {
      this.abbreviatedType_ = paramType;
    }
    this.bitField0_ |= 0x800;
    return this;
  }
  
  public Builder mergeFlexibleUpperBound(ProtoBuf.Type paramType)
  {
    if (((this.bitField0_ & 0x8) == 8) && (this.flexibleUpperBound_ != ProtoBuf.Type.getDefaultInstance())) {
      this.flexibleUpperBound_ = ProtoBuf.Type.newBuilder(this.flexibleUpperBound_).mergeFrom(paramType).buildPartial();
    } else {
      this.flexibleUpperBound_ = paramType;
    }
    this.bitField0_ |= 0x8;
    return this;
  }
  
  public Builder mergeFrom(ProtoBuf.Type paramType)
  {
    if (paramType == ProtoBuf.Type.getDefaultInstance()) {
      return this;
    }
    if (!ProtoBuf.Type.access$5900(paramType).isEmpty()) {
      if (this.argument_.isEmpty())
      {
        this.argument_ = ProtoBuf.Type.access$5900(paramType);
        this.bitField0_ &= 0xFFFFFFFE;
      }
      else
      {
        ensureArgumentIsMutable();
        this.argument_.addAll(ProtoBuf.Type.access$5900(paramType));
      }
    }
    if (paramType.hasNullable()) {
      setNullable(paramType.getNullable());
    }
    if (paramType.hasFlexibleTypeCapabilitiesId()) {
      setFlexibleTypeCapabilitiesId(paramType.getFlexibleTypeCapabilitiesId());
    }
    if (paramType.hasFlexibleUpperBound()) {
      mergeFlexibleUpperBound(paramType.getFlexibleUpperBound());
    }
    if (paramType.hasFlexibleUpperBoundId()) {
      setFlexibleUpperBoundId(paramType.getFlexibleUpperBoundId());
    }
    if (paramType.hasClassName()) {
      setClassName(paramType.getClassName());
    }
    if (paramType.hasTypeParameter()) {
      setTypeParameter(paramType.getTypeParameter());
    }
    if (paramType.hasTypeParameterName()) {
      setTypeParameterName(paramType.getTypeParameterName());
    }
    if (paramType.hasTypeAliasName()) {
      setTypeAliasName(paramType.getTypeAliasName());
    }
    if (paramType.hasOuterType()) {
      mergeOuterType(paramType.getOuterType());
    }
    if (paramType.hasOuterTypeId()) {
      setOuterTypeId(paramType.getOuterTypeId());
    }
    if (paramType.hasAbbreviatedType()) {
      mergeAbbreviatedType(paramType.getAbbreviatedType());
    }
    if (paramType.hasAbbreviatedTypeId()) {
      setAbbreviatedTypeId(paramType.getAbbreviatedTypeId());
    }
    if (paramType.hasFlags()) {
      setFlags(paramType.getFlags());
    }
    mergeExtensionFields(paramType);
    setUnknownFields(getUnknownFields().concat(ProtoBuf.Type.access$7400(paramType)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 368	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 374 3 0
    //   12: checkcast 41	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 168	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 377	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 41	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 168	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Builder;
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
  
  public Builder mergeOuterType(ProtoBuf.Type paramType)
  {
    if (((this.bitField0_ & 0x200) == 512) && (this.outerType_ != ProtoBuf.Type.getDefaultInstance())) {
      this.outerType_ = ProtoBuf.Type.newBuilder(this.outerType_).mergeFrom(paramType).buildPartial();
    } else {
      this.outerType_ = paramType;
    }
    this.bitField0_ |= 0x200;
    return this;
  }
  
  public Builder setAbbreviatedTypeId(int paramInt)
  {
    this.bitField0_ |= 0x1000;
    this.abbreviatedTypeId_ = paramInt;
    return this;
  }
  
  public Builder setClassName(int paramInt)
  {
    this.bitField0_ |= 0x20;
    this.className_ = paramInt;
    return this;
  }
  
  public Builder setFlags(int paramInt)
  {
    this.bitField0_ |= 0x2000;
    this.flags_ = paramInt;
    return this;
  }
  
  public Builder setFlexibleTypeCapabilitiesId(int paramInt)
  {
    this.bitField0_ |= 0x4;
    this.flexibleTypeCapabilitiesId_ = paramInt;
    return this;
  }
  
  public Builder setFlexibleUpperBoundId(int paramInt)
  {
    this.bitField0_ |= 0x10;
    this.flexibleUpperBoundId_ = paramInt;
    return this;
  }
  
  public Builder setNullable(boolean paramBoolean)
  {
    this.bitField0_ |= 0x2;
    this.nullable_ = paramBoolean;
    return this;
  }
  
  public Builder setOuterTypeId(int paramInt)
  {
    this.bitField0_ |= 0x400;
    this.outerTypeId_ = paramInt;
    return this;
  }
  
  public Builder setTypeAliasName(int paramInt)
  {
    this.bitField0_ |= 0x100;
    this.typeAliasName_ = paramInt;
    return this;
  }
  
  public Builder setTypeParameter(int paramInt)
  {
    this.bitField0_ |= 0x40;
    this.typeParameter_ = paramInt;
    return this;
  }
  
  public Builder setTypeParameterName(int paramInt)
  {
    this.bitField0_ |= 0x80;
    this.typeParameterName_ = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Builder
 * JD-Core Version:    0.7.0.1
 */
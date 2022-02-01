package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder;

public final class ProtoBuf$TypeAlias$Builder
  extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf.TypeAlias, Builder>
  implements ProtoBuf.TypeAliasOrBuilder
{
  private List<ProtoBuf.Annotation> annotation_ = Collections.emptyList();
  private int bitField0_;
  private int expandedTypeId_;
  private ProtoBuf.Type expandedType_ = ProtoBuf.Type.getDefaultInstance();
  private int flags_ = 6;
  private int name_;
  private List<ProtoBuf.TypeParameter> typeParameter_ = Collections.emptyList();
  private int underlyingTypeId_;
  private ProtoBuf.Type underlyingType_ = ProtoBuf.Type.getDefaultInstance();
  private List<Integer> versionRequirement_ = Collections.emptyList();
  
  private ProtoBuf$TypeAlias$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void ensureAnnotationIsMutable()
  {
    if ((this.bitField0_ & 0x80) != 128)
    {
      this.annotation_ = new ArrayList(this.annotation_);
      this.bitField0_ |= 0x80;
    }
  }
  
  private void ensureTypeParameterIsMutable()
  {
    if ((this.bitField0_ & 0x4) != 4)
    {
      this.typeParameter_ = new ArrayList(this.typeParameter_);
      this.bitField0_ |= 0x4;
    }
  }
  
  private void ensureVersionRequirementIsMutable()
  {
    if ((this.bitField0_ & 0x100) != 256)
    {
      this.versionRequirement_ = new ArrayList(this.versionRequirement_);
      this.bitField0_ |= 0x100;
    }
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.TypeAlias build()
  {
    ProtoBuf.TypeAlias localTypeAlias = buildPartial();
    if (localTypeAlias.isInitialized()) {
      return localTypeAlias;
    }
    throw newUninitializedMessageException(localTypeAlias);
  }
  
  public ProtoBuf.TypeAlias buildPartial()
  {
    ProtoBuf.TypeAlias localTypeAlias = new ProtoBuf.TypeAlias(this, null);
    int k = this.bitField0_;
    int j = 1;
    if ((k & 0x1) != 1) {
      j = 0;
    }
    ProtoBuf.TypeAlias.access$18002(localTypeAlias, this.flags_);
    int i = j;
    if ((k & 0x2) == 2) {
      i = j | 0x2;
    }
    ProtoBuf.TypeAlias.access$18102(localTypeAlias, this.name_);
    if ((this.bitField0_ & 0x4) == 4)
    {
      this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
      this.bitField0_ &= 0xFFFFFFFB;
    }
    ProtoBuf.TypeAlias.access$18202(localTypeAlias, this.typeParameter_);
    j = i;
    if ((k & 0x8) == 8) {
      j = i | 0x4;
    }
    ProtoBuf.TypeAlias.access$18302(localTypeAlias, this.underlyingType_);
    i = j;
    if ((k & 0x10) == 16) {
      i = j | 0x8;
    }
    ProtoBuf.TypeAlias.access$18402(localTypeAlias, this.underlyingTypeId_);
    j = i;
    if ((k & 0x20) == 32) {
      j = i | 0x10;
    }
    ProtoBuf.TypeAlias.access$18502(localTypeAlias, this.expandedType_);
    i = j;
    if ((k & 0x40) == 64) {
      i = j | 0x20;
    }
    ProtoBuf.TypeAlias.access$18602(localTypeAlias, this.expandedTypeId_);
    if ((this.bitField0_ & 0x80) == 128)
    {
      this.annotation_ = Collections.unmodifiableList(this.annotation_);
      this.bitField0_ &= 0xFFFFFF7F;
    }
    ProtoBuf.TypeAlias.access$18702(localTypeAlias, this.annotation_);
    if ((this.bitField0_ & 0x100) == 256)
    {
      this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
      this.bitField0_ &= 0xFFFFFEFF;
    }
    ProtoBuf.TypeAlias.access$18802(localTypeAlias, this.versionRequirement_);
    ProtoBuf.TypeAlias.access$18902(localTypeAlias, i);
    return localTypeAlias;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.Annotation getAnnotation(int paramInt)
  {
    return (ProtoBuf.Annotation)this.annotation_.get(paramInt);
  }
  
  public int getAnnotationCount()
  {
    return this.annotation_.size();
  }
  
  public ProtoBuf.TypeAlias getDefaultInstanceForType()
  {
    return ProtoBuf.TypeAlias.getDefaultInstance();
  }
  
  public ProtoBuf.Type getExpandedType()
  {
    return this.expandedType_;
  }
  
  public ProtoBuf.TypeParameter getTypeParameter(int paramInt)
  {
    return (ProtoBuf.TypeParameter)this.typeParameter_.get(paramInt);
  }
  
  public int getTypeParameterCount()
  {
    return this.typeParameter_.size();
  }
  
  public ProtoBuf.Type getUnderlyingType()
  {
    return this.underlyingType_;
  }
  
  public boolean hasExpandedType()
  {
    return (this.bitField0_ & 0x20) == 32;
  }
  
  public boolean hasName()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public boolean hasUnderlyingType()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public final boolean isInitialized()
  {
    if (!hasName()) {
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
    if ((hasUnderlyingType()) && (!getUnderlyingType().isInitialized())) {
      return false;
    }
    if ((hasExpandedType()) && (!getExpandedType().isInitialized())) {
      return false;
    }
    i = 0;
    while (i < getAnnotationCount())
    {
      if (!getAnnotation(i).isInitialized()) {
        return false;
      }
      i += 1;
    }
    return extensionsAreInitialized();
  }
  
  public Builder mergeExpandedType(ProtoBuf.Type paramType)
  {
    if (((this.bitField0_ & 0x20) == 32) && (this.expandedType_ != ProtoBuf.Type.getDefaultInstance())) {
      this.expandedType_ = ProtoBuf.Type.newBuilder(this.expandedType_).mergeFrom(paramType).buildPartial();
    } else {
      this.expandedType_ = paramType;
    }
    this.bitField0_ |= 0x20;
    return this;
  }
  
  public Builder mergeFrom(ProtoBuf.TypeAlias paramTypeAlias)
  {
    if (paramTypeAlias == ProtoBuf.TypeAlias.getDefaultInstance()) {
      return this;
    }
    if (paramTypeAlias.hasFlags()) {
      setFlags(paramTypeAlias.getFlags());
    }
    if (paramTypeAlias.hasName()) {
      setName(paramTypeAlias.getName());
    }
    if (!ProtoBuf.TypeAlias.access$18200(paramTypeAlias).isEmpty()) {
      if (this.typeParameter_.isEmpty())
      {
        this.typeParameter_ = ProtoBuf.TypeAlias.access$18200(paramTypeAlias);
        this.bitField0_ &= 0xFFFFFFFB;
      }
      else
      {
        ensureTypeParameterIsMutable();
        this.typeParameter_.addAll(ProtoBuf.TypeAlias.access$18200(paramTypeAlias));
      }
    }
    if (paramTypeAlias.hasUnderlyingType()) {
      mergeUnderlyingType(paramTypeAlias.getUnderlyingType());
    }
    if (paramTypeAlias.hasUnderlyingTypeId()) {
      setUnderlyingTypeId(paramTypeAlias.getUnderlyingTypeId());
    }
    if (paramTypeAlias.hasExpandedType()) {
      mergeExpandedType(paramTypeAlias.getExpandedType());
    }
    if (paramTypeAlias.hasExpandedTypeId()) {
      setExpandedTypeId(paramTypeAlias.getExpandedTypeId());
    }
    if (!ProtoBuf.TypeAlias.access$18700(paramTypeAlias).isEmpty()) {
      if (this.annotation_.isEmpty())
      {
        this.annotation_ = ProtoBuf.TypeAlias.access$18700(paramTypeAlias);
        this.bitField0_ &= 0xFFFFFF7F;
      }
      else
      {
        ensureAnnotationIsMutable();
        this.annotation_.addAll(ProtoBuf.TypeAlias.access$18700(paramTypeAlias));
      }
    }
    if (!ProtoBuf.TypeAlias.access$18800(paramTypeAlias).isEmpty()) {
      if (this.versionRequirement_.isEmpty())
      {
        this.versionRequirement_ = ProtoBuf.TypeAlias.access$18800(paramTypeAlias);
        this.bitField0_ &= 0xFFFFFEFF;
      }
      else
      {
        ensureVersionRequirementIsMutable();
        this.versionRequirement_.addAll(ProtoBuf.TypeAlias.access$18800(paramTypeAlias));
      }
    }
    mergeExtensionFields(paramTypeAlias);
    setUnknownFields(getUnknownFields().concat(ProtoBuf.TypeAlias.access$19000(paramTypeAlias)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 309	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 315 3 0
    //   12: checkcast 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 143	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 318	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 143	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeAlias$Builder;
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
  
  public Builder mergeUnderlyingType(ProtoBuf.Type paramType)
  {
    if (((this.bitField0_ & 0x8) == 8) && (this.underlyingType_ != ProtoBuf.Type.getDefaultInstance())) {
      this.underlyingType_ = ProtoBuf.Type.newBuilder(this.underlyingType_).mergeFrom(paramType).buildPartial();
    } else {
      this.underlyingType_ = paramType;
    }
    this.bitField0_ |= 0x8;
    return this;
  }
  
  public Builder setExpandedTypeId(int paramInt)
  {
    this.bitField0_ |= 0x40;
    this.expandedTypeId_ = paramInt;
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
  
  public Builder setUnderlyingTypeId(int paramInt)
  {
    this.bitField0_ |= 0x10;
    this.underlyingTypeId_ = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias.Builder
 * JD-Core Version:    0.7.0.1
 */
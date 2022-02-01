package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder;

public final class ProtoBuf$TypeParameter$Builder
  extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf.TypeParameter, Builder>
  implements ProtoBuf.TypeParameterOrBuilder
{
  private int bitField0_;
  private int id_;
  private int name_;
  private boolean reified_;
  private List<Integer> upperBoundId_ = Collections.emptyList();
  private List<ProtoBuf.Type> upperBound_ = Collections.emptyList();
  private ProtoBuf.TypeParameter.Variance variance_ = ProtoBuf.TypeParameter.Variance.INV;
  
  private ProtoBuf$TypeParameter$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void ensureUpperBoundIdIsMutable()
  {
    if ((this.bitField0_ & 0x20) != 32)
    {
      this.upperBoundId_ = new ArrayList(this.upperBoundId_);
      this.bitField0_ |= 0x20;
    }
  }
  
  private void ensureUpperBoundIsMutable()
  {
    if ((this.bitField0_ & 0x10) != 16)
    {
      this.upperBound_ = new ArrayList(this.upperBound_);
      this.bitField0_ |= 0x10;
    }
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.TypeParameter build()
  {
    ProtoBuf.TypeParameter localTypeParameter = buildPartial();
    if (localTypeParameter.isInitialized()) {
      return localTypeParameter;
    }
    throw newUninitializedMessageException(localTypeParameter);
  }
  
  public ProtoBuf.TypeParameter buildPartial()
  {
    ProtoBuf.TypeParameter localTypeParameter = new ProtoBuf.TypeParameter(this, null);
    int k = this.bitField0_;
    int j = 1;
    if ((k & 0x1) != 1) {
      j = 0;
    }
    ProtoBuf.TypeParameter.access$7802(localTypeParameter, this.id_);
    int i = j;
    if ((k & 0x2) == 2) {
      i = j | 0x2;
    }
    ProtoBuf.TypeParameter.access$7902(localTypeParameter, this.name_);
    j = i;
    if ((k & 0x4) == 4) {
      j = i | 0x4;
    }
    ProtoBuf.TypeParameter.access$8002(localTypeParameter, this.reified_);
    i = j;
    if ((k & 0x8) == 8) {
      i = j | 0x8;
    }
    ProtoBuf.TypeParameter.access$8102(localTypeParameter, this.variance_);
    if ((this.bitField0_ & 0x10) == 16)
    {
      this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
      this.bitField0_ &= 0xFFFFFFEF;
    }
    ProtoBuf.TypeParameter.access$8202(localTypeParameter, this.upperBound_);
    if ((this.bitField0_ & 0x20) == 32)
    {
      this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
      this.bitField0_ &= 0xFFFFFFDF;
    }
    ProtoBuf.TypeParameter.access$8302(localTypeParameter, this.upperBoundId_);
    ProtoBuf.TypeParameter.access$8402(localTypeParameter, i);
    return localTypeParameter;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.TypeParameter getDefaultInstanceForType()
  {
    return ProtoBuf.TypeParameter.getDefaultInstance();
  }
  
  public ProtoBuf.Type getUpperBound(int paramInt)
  {
    return (ProtoBuf.Type)this.upperBound_.get(paramInt);
  }
  
  public int getUpperBoundCount()
  {
    return this.upperBound_.size();
  }
  
  public boolean hasId()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasName()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public final boolean isInitialized()
  {
    if (!hasId()) {
      return false;
    }
    if (!hasName()) {
      return false;
    }
    int i = 0;
    while (i < getUpperBoundCount())
    {
      if (!getUpperBound(i).isInitialized()) {
        return false;
      }
      i += 1;
    }
    return extensionsAreInitialized();
  }
  
  public Builder mergeFrom(ProtoBuf.TypeParameter paramTypeParameter)
  {
    if (paramTypeParameter == ProtoBuf.TypeParameter.getDefaultInstance()) {
      return this;
    }
    if (paramTypeParameter.hasId()) {
      setId(paramTypeParameter.getId());
    }
    if (paramTypeParameter.hasName()) {
      setName(paramTypeParameter.getName());
    }
    if (paramTypeParameter.hasReified()) {
      setReified(paramTypeParameter.getReified());
    }
    if (paramTypeParameter.hasVariance()) {
      setVariance(paramTypeParameter.getVariance());
    }
    if (!ProtoBuf.TypeParameter.access$8200(paramTypeParameter).isEmpty()) {
      if (this.upperBound_.isEmpty())
      {
        this.upperBound_ = ProtoBuf.TypeParameter.access$8200(paramTypeParameter);
        this.bitField0_ &= 0xFFFFFFEF;
      }
      else
      {
        ensureUpperBoundIsMutable();
        this.upperBound_.addAll(ProtoBuf.TypeParameter.access$8200(paramTypeParameter));
      }
    }
    if (!ProtoBuf.TypeParameter.access$8300(paramTypeParameter).isEmpty()) {
      if (this.upperBoundId_.isEmpty())
      {
        this.upperBoundId_ = ProtoBuf.TypeParameter.access$8300(paramTypeParameter);
        this.bitField0_ &= 0xFFFFFFDF;
      }
      else
      {
        ensureUpperBoundIdIsMutable();
        this.upperBoundId_.addAll(ProtoBuf.TypeParameter.access$8300(paramTypeParameter));
      }
    }
    mergeExtensionFields(paramTypeParameter);
    setUnknownFields(getUnknownFields().concat(ProtoBuf.TypeParameter.access$8500(paramTypeParameter)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 246	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 252 3 0
    //   12: checkcast 67	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 124	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 255	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 67	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 124	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeParameter$Builder;
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
  
  public Builder setId(int paramInt)
  {
    this.bitField0_ |= 0x1;
    this.id_ = paramInt;
    return this;
  }
  
  public Builder setName(int paramInt)
  {
    this.bitField0_ |= 0x2;
    this.name_ = paramInt;
    return this;
  }
  
  public Builder setReified(boolean paramBoolean)
  {
    this.bitField0_ |= 0x4;
    this.reified_ = paramBoolean;
    return this;
  }
  
  public Builder setVariance(ProtoBuf.TypeParameter.Variance paramVariance)
  {
    if (paramVariance != null)
    {
      this.bitField0_ |= 0x8;
      this.variance_ = paramVariance;
      return this;
    }
    throw new NullPointerException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Builder
 * JD-Core Version:    0.7.0.1
 */
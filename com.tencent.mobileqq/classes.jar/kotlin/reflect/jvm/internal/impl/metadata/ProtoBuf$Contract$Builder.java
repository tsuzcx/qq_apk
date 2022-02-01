package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;

public final class ProtoBuf$Contract$Builder
  extends GeneratedMessageLite.Builder<ProtoBuf.Contract, Builder>
  implements ProtoBuf.ContractOrBuilder
{
  private int bitField0_;
  private List<ProtoBuf.Effect> effect_ = Collections.emptyList();
  
  private ProtoBuf$Contract$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void ensureEffectIsMutable()
  {
    if ((this.bitField0_ & 0x1) != 1)
    {
      this.effect_ = new ArrayList(this.effect_);
      this.bitField0_ |= 0x1;
    }
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.Contract build()
  {
    ProtoBuf.Contract localContract = buildPartial();
    if (localContract.isInitialized()) {
      return localContract;
    }
    throw newUninitializedMessageException(localContract);
  }
  
  public ProtoBuf.Contract buildPartial()
  {
    ProtoBuf.Contract localContract = new ProtoBuf.Contract(this, null);
    if ((this.bitField0_ & 0x1) == 1)
    {
      this.effect_ = Collections.unmodifiableList(this.effect_);
      this.bitField0_ &= 0xFFFFFFFE;
    }
    ProtoBuf.Contract.access$22502(localContract, this.effect_);
    return localContract;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.Contract getDefaultInstanceForType()
  {
    return ProtoBuf.Contract.getDefaultInstance();
  }
  
  public ProtoBuf.Effect getEffect(int paramInt)
  {
    return (ProtoBuf.Effect)this.effect_.get(paramInt);
  }
  
  public int getEffectCount()
  {
    return this.effect_.size();
  }
  
  public final boolean isInitialized()
  {
    int i = 0;
    while (i < getEffectCount())
    {
      if (!getEffect(i).isInitialized()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public Builder mergeFrom(ProtoBuf.Contract paramContract)
  {
    if (paramContract == ProtoBuf.Contract.getDefaultInstance()) {
      return this;
    }
    if (!ProtoBuf.Contract.access$22500(paramContract).isEmpty()) {
      if (this.effect_.isEmpty())
      {
        this.effect_ = ProtoBuf.Contract.access$22500(paramContract);
        this.bitField0_ &= 0xFFFFFFFE;
      }
      else
      {
        ensureEffectIsMutable();
        this.effect_.addAll(ProtoBuf.Contract.access$22500(paramContract));
      }
    }
    setUnknownFields(getUnknownFields().concat(ProtoBuf.Contract.access$22600(paramContract)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 146	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 152 3 0
    //   12: checkcast 49	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 79	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 155	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 49	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 79	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Contract$Builder;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract.Builder
 * JD-Core Version:    0.7.0.1
 */
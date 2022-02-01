package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;

public final class ProtoBuf$Type$Argument$Builder
  extends GeneratedMessageLite.Builder<ProtoBuf.Type.Argument, Builder>
  implements ProtoBuf.Type.ArgumentOrBuilder
{
  private int bitField0_;
  private ProtoBuf.Type.Argument.Projection projection_ = ProtoBuf.Type.Argument.Projection.INV;
  private int typeId_;
  private ProtoBuf.Type type_ = ProtoBuf.Type.getDefaultInstance();
  
  private ProtoBuf$Type$Argument$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.Type.Argument build()
  {
    ProtoBuf.Type.Argument localArgument = buildPartial();
    if (localArgument.isInitialized()) {
      return localArgument;
    }
    throw newUninitializedMessageException(localArgument);
  }
  
  public ProtoBuf.Type.Argument buildPartial()
  {
    ProtoBuf.Type.Argument localArgument = new ProtoBuf.Type.Argument(this, null);
    int k = this.bitField0_;
    int j = 1;
    if ((k & 0x1) != 1) {
      j = 0;
    }
    ProtoBuf.Type.Argument.access$5202(localArgument, this.projection_);
    int i = j;
    if ((k & 0x2) == 2) {
      i = j | 0x2;
    }
    ProtoBuf.Type.Argument.access$5302(localArgument, this.type_);
    j = i;
    if ((k & 0x4) == 4) {
      j = i | 0x4;
    }
    ProtoBuf.Type.Argument.access$5402(localArgument, this.typeId_);
    ProtoBuf.Type.Argument.access$5502(localArgument, j);
    return localArgument;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.Type.Argument getDefaultInstanceForType()
  {
    return ProtoBuf.Type.Argument.getDefaultInstance();
  }
  
  public ProtoBuf.Type getType()
  {
    return this.type_;
  }
  
  public boolean hasType()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public final boolean isInitialized()
  {
    return (!hasType()) || (getType().isInitialized());
  }
  
  public Builder mergeFrom(ProtoBuf.Type.Argument paramArgument)
  {
    if (paramArgument == ProtoBuf.Type.Argument.getDefaultInstance()) {
      return this;
    }
    if (paramArgument.hasProjection()) {
      setProjection(paramArgument.getProjection());
    }
    if (paramArgument.hasType()) {
      mergeType(paramArgument.getType());
    }
    if (paramArgument.hasTypeId()) {
      setTypeId(paramArgument.getTypeId());
    }
    setUnknownFields(getUnknownFields().concat(ProtoBuf.Type.Argument.access$5600(paramArgument)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 159	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 165 3 0
    //   12: checkcast 50	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 91	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 168	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 50	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 91	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Type$Argument$Builder;
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
    if (((this.bitField0_ & 0x2) == 2) && (this.type_ != ProtoBuf.Type.getDefaultInstance())) {
      this.type_ = ProtoBuf.Type.newBuilder(this.type_).mergeFrom(paramType).buildPartial();
    } else {
      this.type_ = paramType;
    }
    this.bitField0_ |= 0x2;
    return this;
  }
  
  public Builder setProjection(ProtoBuf.Type.Argument.Projection paramProjection)
  {
    if (paramProjection != null)
    {
      this.bitField0_ |= 0x1;
      this.projection_ = paramProjection;
      return this;
    }
    throw new NullPointerException();
  }
  
  public Builder setTypeId(int paramInt)
  {
    this.bitField0_ |= 0x4;
    this.typeId_ = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Builder
 * JD-Core Version:    0.7.0.1
 */
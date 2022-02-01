package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;

public final class ProtoBuf$Annotation$Argument$Builder
  extends GeneratedMessageLite.Builder<ProtoBuf.Annotation.Argument, Builder>
  implements ProtoBuf.Annotation.ArgumentOrBuilder
{
  private int bitField0_;
  private int nameId_;
  private ProtoBuf.Annotation.Argument.Value value_ = ProtoBuf.Annotation.Argument.Value.getDefaultInstance();
  
  private ProtoBuf$Annotation$Argument$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.Annotation.Argument build()
  {
    ProtoBuf.Annotation.Argument localArgument = buildPartial();
    if (localArgument.isInitialized()) {
      return localArgument;
    }
    throw newUninitializedMessageException(localArgument);
  }
  
  public ProtoBuf.Annotation.Argument buildPartial()
  {
    ProtoBuf.Annotation.Argument localArgument = new ProtoBuf.Annotation.Argument(this, null);
    int k = this.bitField0_;
    int i = 1;
    if ((k & 0x1) != 1) {
      i = 0;
    }
    ProtoBuf.Annotation.Argument.access$3802(localArgument, this.nameId_);
    int j = i;
    if ((k & 0x2) == 2) {
      j = i | 0x2;
    }
    ProtoBuf.Annotation.Argument.access$3902(localArgument, this.value_);
    ProtoBuf.Annotation.Argument.access$4002(localArgument, j);
    return localArgument;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.Annotation.Argument getDefaultInstanceForType()
  {
    return ProtoBuf.Annotation.Argument.getDefaultInstance();
  }
  
  public ProtoBuf.Annotation.Argument.Value getValue()
  {
    return this.value_;
  }
  
  public boolean hasNameId()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public boolean hasValue()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public final boolean isInitialized()
  {
    if (!hasNameId()) {
      return false;
    }
    if (!hasValue()) {
      return false;
    }
    return getValue().isInitialized();
  }
  
  public Builder mergeFrom(ProtoBuf.Annotation.Argument paramArgument)
  {
    if (paramArgument == ProtoBuf.Annotation.Argument.getDefaultInstance()) {
      return this;
    }
    if (paramArgument.hasNameId()) {
      setNameId(paramArgument.getNameId());
    }
    if (paramArgument.hasValue()) {
      mergeValue(paramArgument.getValue());
    }
    setUnknownFields(getUnknownFields().concat(ProtoBuf.Annotation.Argument.access$4100(paramArgument)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 136	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 142 3 0
    //   12: checkcast 41	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 145	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 41	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 78	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Builder;
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
  
  public Builder mergeValue(ProtoBuf.Annotation.Argument.Value paramValue)
  {
    if (((this.bitField0_ & 0x2) == 2) && (this.value_ != ProtoBuf.Annotation.Argument.Value.getDefaultInstance())) {
      this.value_ = ProtoBuf.Annotation.Argument.Value.newBuilder(this.value_).mergeFrom(paramValue).buildPartial();
    } else {
      this.value_ = paramValue;
    }
    this.bitField0_ |= 0x2;
    return this;
  }
  
  public Builder setNameId(int paramInt)
  {
    this.bitField0_ |= 0x1;
    this.nameId_ = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Builder
 * JD-Core Version:    0.7.0.1
 */
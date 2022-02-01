package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder;

public final class ProtoBuf$Constructor$Builder
  extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf.Constructor, Builder>
  implements ProtoBuf.ConstructorOrBuilder
{
  private int bitField0_;
  private int flags_ = 6;
  private List<ProtoBuf.ValueParameter> valueParameter_ = Collections.emptyList();
  private List<Integer> versionRequirement_ = Collections.emptyList();
  
  private ProtoBuf$Constructor$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void ensureValueParameterIsMutable()
  {
    if ((this.bitField0_ & 0x2) != 2)
    {
      this.valueParameter_ = new ArrayList(this.valueParameter_);
      this.bitField0_ |= 0x2;
    }
  }
  
  private void ensureVersionRequirementIsMutable()
  {
    if ((this.bitField0_ & 0x4) != 4)
    {
      this.versionRequirement_ = new ArrayList(this.versionRequirement_);
      this.bitField0_ |= 0x4;
    }
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.Constructor build()
  {
    ProtoBuf.Constructor localConstructor = buildPartial();
    if (localConstructor.isInitialized()) {
      return localConstructor;
    }
    throw newUninitializedMessageException(localConstructor);
  }
  
  public ProtoBuf.Constructor buildPartial()
  {
    ProtoBuf.Constructor localConstructor = new ProtoBuf.Constructor(this, null);
    int j = this.bitField0_;
    int i = 1;
    if ((j & 0x1) != 1) {
      i = 0;
    }
    ProtoBuf.Constructor.access$12702(localConstructor, this.flags_);
    if ((this.bitField0_ & 0x2) == 2)
    {
      this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
      this.bitField0_ &= 0xFFFFFFFD;
    }
    ProtoBuf.Constructor.access$12802(localConstructor, this.valueParameter_);
    if ((this.bitField0_ & 0x4) == 4)
    {
      this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
      this.bitField0_ &= 0xFFFFFFFB;
    }
    ProtoBuf.Constructor.access$12902(localConstructor, this.versionRequirement_);
    ProtoBuf.Constructor.access$13002(localConstructor, i);
    return localConstructor;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.Constructor getDefaultInstanceForType()
  {
    return ProtoBuf.Constructor.getDefaultInstance();
  }
  
  public ProtoBuf.ValueParameter getValueParameter(int paramInt)
  {
    return (ProtoBuf.ValueParameter)this.valueParameter_.get(paramInt);
  }
  
  public int getValueParameterCount()
  {
    return this.valueParameter_.size();
  }
  
  public final boolean isInitialized()
  {
    int i = 0;
    while (i < getValueParameterCount())
    {
      if (!getValueParameter(i).isInitialized()) {
        return false;
      }
      i += 1;
    }
    return extensionsAreInitialized();
  }
  
  public Builder mergeFrom(ProtoBuf.Constructor paramConstructor)
  {
    if (paramConstructor == ProtoBuf.Constructor.getDefaultInstance()) {
      return this;
    }
    if (paramConstructor.hasFlags()) {
      setFlags(paramConstructor.getFlags());
    }
    if (!ProtoBuf.Constructor.access$12800(paramConstructor).isEmpty()) {
      if (this.valueParameter_.isEmpty())
      {
        this.valueParameter_ = ProtoBuf.Constructor.access$12800(paramConstructor);
        this.bitField0_ &= 0xFFFFFFFD;
      }
      else
      {
        ensureValueParameterIsMutable();
        this.valueParameter_.addAll(ProtoBuf.Constructor.access$12800(paramConstructor));
      }
    }
    if (!ProtoBuf.Constructor.access$12900(paramConstructor).isEmpty()) {
      if (this.versionRequirement_.isEmpty())
      {
        this.versionRequirement_ = ProtoBuf.Constructor.access$12900(paramConstructor);
        this.bitField0_ &= 0xFFFFFFFB;
      }
      else
      {
        ensureVersionRequirementIsMutable();
        this.versionRequirement_.addAll(ProtoBuf.Constructor.access$12900(paramConstructor));
      }
    }
    mergeExtensionFields(paramConstructor);
    setUnknownFields(getUnknownFields().concat(ProtoBuf.Constructor.access$13100(paramConstructor)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 187	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 193 3 0
    //   12: checkcast 57	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 97	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 196	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 57	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 97	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Constructor$Builder;
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
  
  public Builder setFlags(int paramInt)
  {
    this.bitField0_ |= 0x1;
    this.flags_ = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor.Builder
 * JD-Core Version:    0.7.0.1
 */
package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;

public final class JvmProtoBuf$StringTableTypes$Builder
  extends GeneratedMessageLite.Builder<JvmProtoBuf.StringTableTypes, Builder>
  implements JvmProtoBuf.StringTableTypesOrBuilder
{
  private int bitField0_;
  private List<Integer> localName_ = Collections.emptyList();
  private List<JvmProtoBuf.StringTableTypes.Record> record_ = Collections.emptyList();
  
  private JvmProtoBuf$StringTableTypes$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void ensureLocalNameIsMutable()
  {
    if ((this.bitField0_ & 0x2) != 2)
    {
      this.localName_ = new ArrayList(this.localName_);
      this.bitField0_ |= 0x2;
    }
  }
  
  private void ensureRecordIsMutable()
  {
    if ((this.bitField0_ & 0x1) != 1)
    {
      this.record_ = new ArrayList(this.record_);
      this.bitField0_ |= 0x1;
    }
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public JvmProtoBuf.StringTableTypes build()
  {
    JvmProtoBuf.StringTableTypes localStringTableTypes = buildPartial();
    if (localStringTableTypes.isInitialized()) {
      return localStringTableTypes;
    }
    throw newUninitializedMessageException(localStringTableTypes);
  }
  
  public JvmProtoBuf.StringTableTypes buildPartial()
  {
    JvmProtoBuf.StringTableTypes localStringTableTypes = new JvmProtoBuf.StringTableTypes(this, null);
    if ((this.bitField0_ & 0x1) == 1)
    {
      this.record_ = Collections.unmodifiableList(this.record_);
      this.bitField0_ &= 0xFFFFFFFE;
    }
    JvmProtoBuf.StringTableTypes.access$1402(localStringTableTypes, this.record_);
    if ((this.bitField0_ & 0x2) == 2)
    {
      this.localName_ = Collections.unmodifiableList(this.localName_);
      this.bitField0_ &= 0xFFFFFFFD;
    }
    JvmProtoBuf.StringTableTypes.access$1502(localStringTableTypes, this.localName_);
    return localStringTableTypes;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public JvmProtoBuf.StringTableTypes getDefaultInstanceForType()
  {
    return JvmProtoBuf.StringTableTypes.getDefaultInstance();
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Builder mergeFrom(JvmProtoBuf.StringTableTypes paramStringTableTypes)
  {
    if (paramStringTableTypes == JvmProtoBuf.StringTableTypes.getDefaultInstance()) {
      return this;
    }
    if (!JvmProtoBuf.StringTableTypes.access$1400(paramStringTableTypes).isEmpty()) {
      if (this.record_.isEmpty())
      {
        this.record_ = JvmProtoBuf.StringTableTypes.access$1400(paramStringTableTypes);
        this.bitField0_ &= 0xFFFFFFFE;
      }
      else
      {
        ensureRecordIsMutable();
        this.record_.addAll(JvmProtoBuf.StringTableTypes.access$1400(paramStringTableTypes));
      }
    }
    if (!JvmProtoBuf.StringTableTypes.access$1500(paramStringTableTypes).isEmpty()) {
      if (this.localName_.isEmpty())
      {
        this.localName_ = JvmProtoBuf.StringTableTypes.access$1500(paramStringTableTypes);
        this.bitField0_ &= 0xFFFFFFFD;
      }
      else
      {
        ensureLocalNameIsMutable();
        this.localName_.addAll(JvmProtoBuf.StringTableTypes.access$1500(paramStringTableTypes));
      }
    }
    setUnknownFields(getUnknownFields().concat(JvmProtoBuf.StringTableTypes.access$1600(paramStringTableTypes)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 141	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 147 3 0
    //   12: checkcast 54	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 87	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes;)Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 150	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 54	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 87	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes;)Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$StringTableTypes$Builder;
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
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Builder
 * JD-Core Version:    0.7.0.1
 */
package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;

public final class JvmProtoBuf$JvmMethodSignature$Builder
  extends GeneratedMessageLite.Builder<JvmProtoBuf.JvmMethodSignature, Builder>
  implements JvmProtoBuf.JvmMethodSignatureOrBuilder
{
  private int bitField0_;
  private int desc_;
  private int name_;
  
  private JvmProtoBuf$JvmMethodSignature$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public JvmProtoBuf.JvmMethodSignature build()
  {
    JvmProtoBuf.JvmMethodSignature localJvmMethodSignature = buildPartial();
    if (localJvmMethodSignature.isInitialized()) {
      return localJvmMethodSignature;
    }
    throw newUninitializedMessageException(localJvmMethodSignature);
  }
  
  public JvmProtoBuf.JvmMethodSignature buildPartial()
  {
    JvmProtoBuf.JvmMethodSignature localJvmMethodSignature = new JvmProtoBuf.JvmMethodSignature(this, null);
    int k = this.bitField0_;
    int i = 1;
    if ((k & 0x1) != 1) {
      i = 0;
    }
    JvmProtoBuf.JvmMethodSignature.access$2002(localJvmMethodSignature, this.name_);
    int j = i;
    if ((k & 0x2) == 2) {
      j = i | 0x2;
    }
    JvmProtoBuf.JvmMethodSignature.access$2102(localJvmMethodSignature, this.desc_);
    JvmProtoBuf.JvmMethodSignature.access$2202(localJvmMethodSignature, j);
    return localJvmMethodSignature;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public JvmProtoBuf.JvmMethodSignature getDefaultInstanceForType()
  {
    return JvmProtoBuf.JvmMethodSignature.getDefaultInstance();
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Builder mergeFrom(JvmProtoBuf.JvmMethodSignature paramJvmMethodSignature)
  {
    if (paramJvmMethodSignature == JvmProtoBuf.JvmMethodSignature.getDefaultInstance()) {
      return this;
    }
    if (paramJvmMethodSignature.hasName()) {
      setName(paramJvmMethodSignature.getName());
    }
    if (paramJvmMethodSignature.hasDesc()) {
      setDesc(paramJvmMethodSignature.getDesc());
    }
    setUnknownFields(getUnknownFields().concat(JvmProtoBuf.JvmMethodSignature.access$2300(paramJvmMethodSignature)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 124	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 130 3 0
    //   12: checkcast 32	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 70	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature;)Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 133	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 32	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 70	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature;)Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmMethodSignature$Builder;
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
  
  public Builder setDesc(int paramInt)
  {
    this.bitField0_ |= 0x2;
    this.desc_ = paramInt;
    return this;
  }
  
  public Builder setName(int paramInt)
  {
    this.bitField0_ |= 0x1;
    this.name_ = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.Builder
 * JD-Core Version:    0.7.0.1
 */
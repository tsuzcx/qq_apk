package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;

public final class JvmProtoBuf$JvmPropertySignature$Builder
  extends GeneratedMessageLite.Builder<JvmProtoBuf.JvmPropertySignature, Builder>
  implements JvmProtoBuf.JvmPropertySignatureOrBuilder
{
  private int bitField0_;
  private JvmProtoBuf.JvmFieldSignature field_ = JvmProtoBuf.JvmFieldSignature.getDefaultInstance();
  private JvmProtoBuf.JvmMethodSignature getter_ = JvmProtoBuf.JvmMethodSignature.getDefaultInstance();
  private JvmProtoBuf.JvmMethodSignature setter_ = JvmProtoBuf.JvmMethodSignature.getDefaultInstance();
  private JvmProtoBuf.JvmMethodSignature syntheticMethod_ = JvmProtoBuf.JvmMethodSignature.getDefaultInstance();
  
  private JvmProtoBuf$JvmPropertySignature$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public JvmProtoBuf.JvmPropertySignature build()
  {
    JvmProtoBuf.JvmPropertySignature localJvmPropertySignature = buildPartial();
    if (localJvmPropertySignature.isInitialized()) {
      return localJvmPropertySignature;
    }
    throw newUninitializedMessageException(localJvmPropertySignature);
  }
  
  public JvmProtoBuf.JvmPropertySignature buildPartial()
  {
    JvmProtoBuf.JvmPropertySignature localJvmPropertySignature = new JvmProtoBuf.JvmPropertySignature(this, null);
    int k = this.bitField0_;
    int j = 1;
    if ((k & 0x1) != 1) {
      j = 0;
    }
    JvmProtoBuf.JvmPropertySignature.access$3402(localJvmPropertySignature, this.field_);
    int i = j;
    if ((k & 0x2) == 2) {
      i = j | 0x2;
    }
    JvmProtoBuf.JvmPropertySignature.access$3502(localJvmPropertySignature, this.syntheticMethod_);
    j = i;
    if ((k & 0x4) == 4) {
      j = i | 0x4;
    }
    JvmProtoBuf.JvmPropertySignature.access$3602(localJvmPropertySignature, this.getter_);
    i = j;
    if ((k & 0x8) == 8) {
      i = j | 0x8;
    }
    JvmProtoBuf.JvmPropertySignature.access$3702(localJvmPropertySignature, this.setter_);
    JvmProtoBuf.JvmPropertySignature.access$3802(localJvmPropertySignature, i);
    return localJvmPropertySignature;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public JvmProtoBuf.JvmPropertySignature getDefaultInstanceForType()
  {
    return JvmProtoBuf.JvmPropertySignature.getDefaultInstance();
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Builder mergeField(JvmProtoBuf.JvmFieldSignature paramJvmFieldSignature)
  {
    if (((this.bitField0_ & 0x1) == 1) && (this.field_ != JvmProtoBuf.JvmFieldSignature.getDefaultInstance())) {
      this.field_ = JvmProtoBuf.JvmFieldSignature.newBuilder(this.field_).mergeFrom(paramJvmFieldSignature).buildPartial();
    } else {
      this.field_ = paramJvmFieldSignature;
    }
    this.bitField0_ |= 0x1;
    return this;
  }
  
  public Builder mergeFrom(JvmProtoBuf.JvmPropertySignature paramJvmPropertySignature)
  {
    if (paramJvmPropertySignature == JvmProtoBuf.JvmPropertySignature.getDefaultInstance()) {
      return this;
    }
    if (paramJvmPropertySignature.hasField()) {
      mergeField(paramJvmPropertySignature.getField());
    }
    if (paramJvmPropertySignature.hasSyntheticMethod()) {
      mergeSyntheticMethod(paramJvmPropertySignature.getSyntheticMethod());
    }
    if (paramJvmPropertySignature.hasGetter()) {
      mergeGetter(paramJvmPropertySignature.getGetter());
    }
    if (paramJvmPropertySignature.hasSetter()) {
      mergeSetter(paramJvmPropertySignature.getSetter());
    }
    setUnknownFields(getUnknownFields().concat(JvmProtoBuf.JvmPropertySignature.access$3900(paramJvmPropertySignature)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 178	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 184 3 0
    //   12: checkcast 55	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 97	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;)Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 187	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 55	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 97	kotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;)Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature$Builder;
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
  
  public Builder mergeGetter(JvmProtoBuf.JvmMethodSignature paramJvmMethodSignature)
  {
    if (((this.bitField0_ & 0x4) == 4) && (this.getter_ != JvmProtoBuf.JvmMethodSignature.getDefaultInstance())) {
      this.getter_ = JvmProtoBuf.JvmMethodSignature.newBuilder(this.getter_).mergeFrom(paramJvmMethodSignature).buildPartial();
    } else {
      this.getter_ = paramJvmMethodSignature;
    }
    this.bitField0_ |= 0x4;
    return this;
  }
  
  public Builder mergeSetter(JvmProtoBuf.JvmMethodSignature paramJvmMethodSignature)
  {
    if (((this.bitField0_ & 0x8) == 8) && (this.setter_ != JvmProtoBuf.JvmMethodSignature.getDefaultInstance())) {
      this.setter_ = JvmProtoBuf.JvmMethodSignature.newBuilder(this.setter_).mergeFrom(paramJvmMethodSignature).buildPartial();
    } else {
      this.setter_ = paramJvmMethodSignature;
    }
    this.bitField0_ |= 0x8;
    return this;
  }
  
  public Builder mergeSyntheticMethod(JvmProtoBuf.JvmMethodSignature paramJvmMethodSignature)
  {
    if (((this.bitField0_ & 0x2) == 2) && (this.syntheticMethod_ != JvmProtoBuf.JvmMethodSignature.getDefaultInstance())) {
      this.syntheticMethod_ = JvmProtoBuf.JvmMethodSignature.newBuilder(this.syntheticMethod_).mergeFrom(paramJvmMethodSignature).buildPartial();
    } else {
      this.syntheticMethod_ = paramJvmMethodSignature;
    }
    this.bitField0_ |= 0x2;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature.Builder
 * JD-Core Version:    0.7.0.1
 */
package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;

public final class ProtoBuf$Annotation$Argument$Value$Builder
  extends GeneratedMessageLite.Builder<ProtoBuf.Annotation.Argument.Value, Builder>
  implements ProtoBuf.Annotation.Argument.ValueOrBuilder
{
  private ProtoBuf.Annotation annotation_ = ProtoBuf.Annotation.getDefaultInstance();
  private int arrayDimensionCount_;
  private List<ProtoBuf.Annotation.Argument.Value> arrayElement_ = Collections.emptyList();
  private int bitField0_;
  private int classId_;
  private double doubleValue_;
  private int enumValueId_;
  private int flags_;
  private float floatValue_;
  private long intValue_;
  private int stringValue_;
  private ProtoBuf.Annotation.Argument.Value.Type type_ = ProtoBuf.Annotation.Argument.Value.Type.BYTE;
  
  private ProtoBuf$Annotation$Argument$Value$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void ensureArrayElementIsMutable()
  {
    if ((this.bitField0_ & 0x100) != 256)
    {
      this.arrayElement_ = new ArrayList(this.arrayElement_);
      this.bitField0_ |= 0x100;
    }
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.Annotation.Argument.Value build()
  {
    ProtoBuf.Annotation.Argument.Value localValue = buildPartial();
    if (localValue.isInitialized()) {
      return localValue;
    }
    throw newUninitializedMessageException(localValue);
  }
  
  public ProtoBuf.Annotation.Argument.Value buildPartial()
  {
    ProtoBuf.Annotation.Argument.Value localValue = new ProtoBuf.Annotation.Argument.Value(this, null);
    int k = this.bitField0_;
    int j = 1;
    if ((k & 0x1) != 1) {
      j = 0;
    }
    ProtoBuf.Annotation.Argument.Value.access$2302(localValue, this.type_);
    int i = j;
    if ((k & 0x2) == 2) {
      i = j | 0x2;
    }
    ProtoBuf.Annotation.Argument.Value.access$2402(localValue, this.intValue_);
    j = i;
    if ((k & 0x4) == 4) {
      j = i | 0x4;
    }
    ProtoBuf.Annotation.Argument.Value.access$2502(localValue, this.floatValue_);
    i = j;
    if ((k & 0x8) == 8) {
      i = j | 0x8;
    }
    ProtoBuf.Annotation.Argument.Value.access$2602(localValue, this.doubleValue_);
    j = i;
    if ((k & 0x10) == 16) {
      j = i | 0x10;
    }
    ProtoBuf.Annotation.Argument.Value.access$2702(localValue, this.stringValue_);
    i = j;
    if ((k & 0x20) == 32) {
      i = j | 0x20;
    }
    ProtoBuf.Annotation.Argument.Value.access$2802(localValue, this.classId_);
    j = i;
    if ((k & 0x40) == 64) {
      j = i | 0x40;
    }
    ProtoBuf.Annotation.Argument.Value.access$2902(localValue, this.enumValueId_);
    i = j;
    if ((k & 0x80) == 128) {
      i = j | 0x80;
    }
    ProtoBuf.Annotation.Argument.Value.access$3002(localValue, this.annotation_);
    if ((this.bitField0_ & 0x100) == 256)
    {
      this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
      this.bitField0_ &= 0xFFFFFEFF;
    }
    ProtoBuf.Annotation.Argument.Value.access$3102(localValue, this.arrayElement_);
    j = i;
    if ((k & 0x200) == 512) {
      j = i | 0x100;
    }
    ProtoBuf.Annotation.Argument.Value.access$3202(localValue, this.arrayDimensionCount_);
    i = j;
    if ((k & 0x400) == 1024) {
      i = j | 0x200;
    }
    ProtoBuf.Annotation.Argument.Value.access$3302(localValue, this.flags_);
    ProtoBuf.Annotation.Argument.Value.access$3402(localValue, i);
    return localValue;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.Annotation getAnnotation()
  {
    return this.annotation_;
  }
  
  public ProtoBuf.Annotation.Argument.Value getArrayElement(int paramInt)
  {
    return (ProtoBuf.Annotation.Argument.Value)this.arrayElement_.get(paramInt);
  }
  
  public int getArrayElementCount()
  {
    return this.arrayElement_.size();
  }
  
  public ProtoBuf.Annotation.Argument.Value getDefaultInstanceForType()
  {
    return ProtoBuf.Annotation.Argument.Value.getDefaultInstance();
  }
  
  public boolean hasAnnotation()
  {
    return (this.bitField0_ & 0x80) == 128;
  }
  
  public final boolean isInitialized()
  {
    if ((hasAnnotation()) && (!getAnnotation().isInitialized())) {
      return false;
    }
    int i = 0;
    while (i < getArrayElementCount())
    {
      if (!getArrayElement(i).isInitialized()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public Builder mergeAnnotation(ProtoBuf.Annotation paramAnnotation)
  {
    if (((this.bitField0_ & 0x80) == 128) && (this.annotation_ != ProtoBuf.Annotation.getDefaultInstance())) {
      this.annotation_ = ProtoBuf.Annotation.newBuilder(this.annotation_).mergeFrom(paramAnnotation).buildPartial();
    } else {
      this.annotation_ = paramAnnotation;
    }
    this.bitField0_ |= 0x80;
    return this;
  }
  
  public Builder mergeFrom(ProtoBuf.Annotation.Argument.Value paramValue)
  {
    if (paramValue == ProtoBuf.Annotation.Argument.Value.getDefaultInstance()) {
      return this;
    }
    if (paramValue.hasType()) {
      setType(paramValue.getType());
    }
    if (paramValue.hasIntValue()) {
      setIntValue(paramValue.getIntValue());
    }
    if (paramValue.hasFloatValue()) {
      setFloatValue(paramValue.getFloatValue());
    }
    if (paramValue.hasDoubleValue()) {
      setDoubleValue(paramValue.getDoubleValue());
    }
    if (paramValue.hasStringValue()) {
      setStringValue(paramValue.getStringValue());
    }
    if (paramValue.hasClassId()) {
      setClassId(paramValue.getClassId());
    }
    if (paramValue.hasEnumValueId()) {
      setEnumValueId(paramValue.getEnumValueId());
    }
    if (paramValue.hasAnnotation()) {
      mergeAnnotation(paramValue.getAnnotation());
    }
    if (!ProtoBuf.Annotation.Argument.Value.access$3100(paramValue).isEmpty()) {
      if (this.arrayElement_.isEmpty())
      {
        this.arrayElement_ = ProtoBuf.Annotation.Argument.Value.access$3100(paramValue);
        this.bitField0_ &= 0xFFFFFEFF;
      }
      else
      {
        ensureArrayElementIsMutable();
        this.arrayElement_.addAll(ProtoBuf.Annotation.Argument.Value.access$3100(paramValue));
      }
    }
    if (paramValue.hasArrayDimensionCount()) {
      setArrayDimensionCount(paramValue.getArrayDimensionCount());
    }
    if (paramValue.hasFlags()) {
      setFlags(paramValue.getFlags());
    }
    setUnknownFields(getUnknownFields().concat(ProtoBuf.Annotation.Argument.Value.access$3500(paramValue)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 340	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 346 3 0
    //   12: checkcast 79	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 164	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 349	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 79	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 164	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Argument$Value$Builder;
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
  
  public Builder setArrayDimensionCount(int paramInt)
  {
    this.bitField0_ |= 0x200;
    this.arrayDimensionCount_ = paramInt;
    return this;
  }
  
  public Builder setClassId(int paramInt)
  {
    this.bitField0_ |= 0x20;
    this.classId_ = paramInt;
    return this;
  }
  
  public Builder setDoubleValue(double paramDouble)
  {
    this.bitField0_ |= 0x8;
    this.doubleValue_ = paramDouble;
    return this;
  }
  
  public Builder setEnumValueId(int paramInt)
  {
    this.bitField0_ |= 0x40;
    this.enumValueId_ = paramInt;
    return this;
  }
  
  public Builder setFlags(int paramInt)
  {
    this.bitField0_ |= 0x400;
    this.flags_ = paramInt;
    return this;
  }
  
  public Builder setFloatValue(float paramFloat)
  {
    this.bitField0_ |= 0x4;
    this.floatValue_ = paramFloat;
    return this;
  }
  
  public Builder setIntValue(long paramLong)
  {
    this.bitField0_ |= 0x2;
    this.intValue_ = paramLong;
    return this;
  }
  
  public Builder setStringValue(int paramInt)
  {
    this.bitField0_ |= 0x10;
    this.stringValue_ = paramInt;
    return this;
  }
  
  public Builder setType(ProtoBuf.Annotation.Argument.Value.Type paramType)
  {
    if (paramType != null)
    {
      this.bitField0_ |= 0x1;
      this.type_ = paramType;
      return this;
    }
    throw new NullPointerException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Builder
 * JD-Core Version:    0.7.0.1
 */
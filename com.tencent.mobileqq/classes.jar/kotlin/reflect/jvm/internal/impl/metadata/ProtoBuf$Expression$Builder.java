package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;

public final class ProtoBuf$Expression$Builder
  extends GeneratedMessageLite.Builder<ProtoBuf.Expression, Builder>
  implements ProtoBuf.ExpressionOrBuilder
{
  private List<ProtoBuf.Expression> andArgument_ = Collections.emptyList();
  private int bitField0_;
  private ProtoBuf.Expression.ConstantValue constantValue_ = ProtoBuf.Expression.ConstantValue.TRUE;
  private int flags_;
  private int isInstanceTypeId_;
  private ProtoBuf.Type isInstanceType_ = ProtoBuf.Type.getDefaultInstance();
  private List<ProtoBuf.Expression> orArgument_ = Collections.emptyList();
  private int valueParameterReference_;
  
  private ProtoBuf$Expression$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void ensureAndArgumentIsMutable()
  {
    if ((this.bitField0_ & 0x20) != 32)
    {
      this.andArgument_ = new ArrayList(this.andArgument_);
      this.bitField0_ |= 0x20;
    }
  }
  
  private void ensureOrArgumentIsMutable()
  {
    if ((this.bitField0_ & 0x40) != 64)
    {
      this.orArgument_ = new ArrayList(this.orArgument_);
      this.bitField0_ |= 0x40;
    }
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.Expression build()
  {
    ProtoBuf.Expression localExpression = buildPartial();
    if (localExpression.isInitialized()) {
      return localExpression;
    }
    throw newUninitializedMessageException(localExpression);
  }
  
  public ProtoBuf.Expression buildPartial()
  {
    ProtoBuf.Expression localExpression = new ProtoBuf.Expression(this, null);
    int k = this.bitField0_;
    int j = 1;
    if ((k & 0x1) != 1) {
      j = 0;
    }
    ProtoBuf.Expression.access$23902(localExpression, this.flags_);
    int i = j;
    if ((k & 0x2) == 2) {
      i = j | 0x2;
    }
    ProtoBuf.Expression.access$24002(localExpression, this.valueParameterReference_);
    j = i;
    if ((k & 0x4) == 4) {
      j = i | 0x4;
    }
    ProtoBuf.Expression.access$24102(localExpression, this.constantValue_);
    i = j;
    if ((k & 0x8) == 8) {
      i = j | 0x8;
    }
    ProtoBuf.Expression.access$24202(localExpression, this.isInstanceType_);
    j = i;
    if ((k & 0x10) == 16) {
      j = i | 0x10;
    }
    ProtoBuf.Expression.access$24302(localExpression, this.isInstanceTypeId_);
    if ((this.bitField0_ & 0x20) == 32)
    {
      this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
      this.bitField0_ &= 0xFFFFFFDF;
    }
    ProtoBuf.Expression.access$24402(localExpression, this.andArgument_);
    if ((this.bitField0_ & 0x40) == 64)
    {
      this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
      this.bitField0_ &= 0xFFFFFFBF;
    }
    ProtoBuf.Expression.access$24502(localExpression, this.orArgument_);
    ProtoBuf.Expression.access$24602(localExpression, j);
    return localExpression;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.Expression getAndArgument(int paramInt)
  {
    return (ProtoBuf.Expression)this.andArgument_.get(paramInt);
  }
  
  public int getAndArgumentCount()
  {
    return this.andArgument_.size();
  }
  
  public ProtoBuf.Expression getDefaultInstanceForType()
  {
    return ProtoBuf.Expression.getDefaultInstance();
  }
  
  public ProtoBuf.Type getIsInstanceType()
  {
    return this.isInstanceType_;
  }
  
  public ProtoBuf.Expression getOrArgument(int paramInt)
  {
    return (ProtoBuf.Expression)this.orArgument_.get(paramInt);
  }
  
  public int getOrArgumentCount()
  {
    return this.orArgument_.size();
  }
  
  public boolean hasIsInstanceType()
  {
    return (this.bitField0_ & 0x8) == 8;
  }
  
  public final boolean isInitialized()
  {
    if ((hasIsInstanceType()) && (!getIsInstanceType().isInitialized())) {
      return false;
    }
    int i = 0;
    while (i < getAndArgumentCount())
    {
      if (!getAndArgument(i).isInitialized()) {
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < getOrArgumentCount())
    {
      if (!getOrArgument(i).isInitialized()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public Builder mergeFrom(ProtoBuf.Expression paramExpression)
  {
    if (paramExpression == ProtoBuf.Expression.getDefaultInstance()) {
      return this;
    }
    if (paramExpression.hasFlags()) {
      setFlags(paramExpression.getFlags());
    }
    if (paramExpression.hasValueParameterReference()) {
      setValueParameterReference(paramExpression.getValueParameterReference());
    }
    if (paramExpression.hasConstantValue()) {
      setConstantValue(paramExpression.getConstantValue());
    }
    if (paramExpression.hasIsInstanceType()) {
      mergeIsInstanceType(paramExpression.getIsInstanceType());
    }
    if (paramExpression.hasIsInstanceTypeId()) {
      setIsInstanceTypeId(paramExpression.getIsInstanceTypeId());
    }
    if (!ProtoBuf.Expression.access$24400(paramExpression).isEmpty()) {
      if (this.andArgument_.isEmpty())
      {
        this.andArgument_ = ProtoBuf.Expression.access$24400(paramExpression);
        this.bitField0_ &= 0xFFFFFFDF;
      }
      else
      {
        ensureAndArgumentIsMutable();
        this.andArgument_.addAll(ProtoBuf.Expression.access$24400(paramExpression));
      }
    }
    if (!ProtoBuf.Expression.access$24500(paramExpression).isEmpty()) {
      if (this.orArgument_.isEmpty())
      {
        this.orArgument_ = ProtoBuf.Expression.access$24500(paramExpression);
        this.bitField0_ &= 0xFFFFFFBF;
      }
      else
      {
        ensureOrArgumentIsMutable();
        this.orArgument_.addAll(ProtoBuf.Expression.access$24500(paramExpression));
      }
    }
    setUnknownFields(getUnknownFields().concat(ProtoBuf.Expression.access$24700(paramExpression)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 261	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 267 3 0
    //   12: checkcast 75	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 135	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 270	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 75	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 135	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Expression$Builder;
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
  
  public Builder mergeIsInstanceType(ProtoBuf.Type paramType)
  {
    if (((this.bitField0_ & 0x8) == 8) && (this.isInstanceType_ != ProtoBuf.Type.getDefaultInstance())) {
      this.isInstanceType_ = ProtoBuf.Type.newBuilder(this.isInstanceType_).mergeFrom(paramType).buildPartial();
    } else {
      this.isInstanceType_ = paramType;
    }
    this.bitField0_ |= 0x8;
    return this;
  }
  
  public Builder setConstantValue(ProtoBuf.Expression.ConstantValue paramConstantValue)
  {
    if (paramConstantValue != null)
    {
      this.bitField0_ |= 0x4;
      this.constantValue_ = paramConstantValue;
      return this;
    }
    throw new NullPointerException();
  }
  
  public Builder setFlags(int paramInt)
  {
    this.bitField0_ |= 0x1;
    this.flags_ = paramInt;
    return this;
  }
  
  public Builder setIsInstanceTypeId(int paramInt)
  {
    this.bitField0_ |= 0x10;
    this.isInstanceTypeId_ = paramInt;
    return this;
  }
  
  public Builder setValueParameterReference(int paramInt)
  {
    this.bitField0_ |= 0x2;
    this.valueParameterReference_ = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression.Builder
 * JD-Core Version:    0.7.0.1
 */
package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;

public final class ProtoBuf$Effect$Builder
  extends GeneratedMessageLite.Builder<ProtoBuf.Effect, Builder>
  implements ProtoBuf.EffectOrBuilder
{
  private int bitField0_;
  private ProtoBuf.Expression conclusionOfConditionalEffect_ = ProtoBuf.Expression.getDefaultInstance();
  private List<ProtoBuf.Expression> effectConstructorArgument_ = Collections.emptyList();
  private ProtoBuf.Effect.EffectType effectType_ = ProtoBuf.Effect.EffectType.RETURNS_CONSTANT;
  private ProtoBuf.Effect.InvocationKind kind_ = ProtoBuf.Effect.InvocationKind.AT_MOST_ONCE;
  
  private ProtoBuf$Effect$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void ensureEffectConstructorArgumentIsMutable()
  {
    if ((this.bitField0_ & 0x2) != 2)
    {
      this.effectConstructorArgument_ = new ArrayList(this.effectConstructorArgument_);
      this.bitField0_ |= 0x2;
    }
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.Effect build()
  {
    ProtoBuf.Effect localEffect = buildPartial();
    if (localEffect.isInitialized()) {
      return localEffect;
    }
    throw newUninitializedMessageException(localEffect);
  }
  
  public ProtoBuf.Effect buildPartial()
  {
    ProtoBuf.Effect localEffect = new ProtoBuf.Effect(this, null);
    int k = this.bitField0_;
    int j = 1;
    if ((k & 0x1) != 1) {
      j = 0;
    }
    ProtoBuf.Effect.access$23002(localEffect, this.effectType_);
    if ((this.bitField0_ & 0x2) == 2)
    {
      this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
      this.bitField0_ &= 0xFFFFFFFD;
    }
    ProtoBuf.Effect.access$23102(localEffect, this.effectConstructorArgument_);
    int i = j;
    if ((k & 0x4) == 4) {
      i = j | 0x2;
    }
    ProtoBuf.Effect.access$23202(localEffect, this.conclusionOfConditionalEffect_);
    j = i;
    if ((k & 0x8) == 8) {
      j = i | 0x4;
    }
    ProtoBuf.Effect.access$23302(localEffect, this.kind_);
    ProtoBuf.Effect.access$23402(localEffect, j);
    return localEffect;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.Expression getConclusionOfConditionalEffect()
  {
    return this.conclusionOfConditionalEffect_;
  }
  
  public ProtoBuf.Effect getDefaultInstanceForType()
  {
    return ProtoBuf.Effect.getDefaultInstance();
  }
  
  public ProtoBuf.Expression getEffectConstructorArgument(int paramInt)
  {
    return (ProtoBuf.Expression)this.effectConstructorArgument_.get(paramInt);
  }
  
  public int getEffectConstructorArgumentCount()
  {
    return this.effectConstructorArgument_.size();
  }
  
  public boolean hasConclusionOfConditionalEffect()
  {
    return (this.bitField0_ & 0x4) == 4;
  }
  
  public final boolean isInitialized()
  {
    int i = 0;
    while (i < getEffectConstructorArgumentCount())
    {
      if (!getEffectConstructorArgument(i).isInitialized()) {
        return false;
      }
      i += 1;
    }
    return (!hasConclusionOfConditionalEffect()) || (getConclusionOfConditionalEffect().isInitialized());
  }
  
  public Builder mergeConclusionOfConditionalEffect(ProtoBuf.Expression paramExpression)
  {
    if (((this.bitField0_ & 0x4) == 4) && (this.conclusionOfConditionalEffect_ != ProtoBuf.Expression.getDefaultInstance())) {
      this.conclusionOfConditionalEffect_ = ProtoBuf.Expression.newBuilder(this.conclusionOfConditionalEffect_).mergeFrom(paramExpression).buildPartial();
    } else {
      this.conclusionOfConditionalEffect_ = paramExpression;
    }
    this.bitField0_ |= 0x4;
    return this;
  }
  
  public Builder mergeFrom(ProtoBuf.Effect paramEffect)
  {
    if (paramEffect == ProtoBuf.Effect.getDefaultInstance()) {
      return this;
    }
    if (paramEffect.hasEffectType()) {
      setEffectType(paramEffect.getEffectType());
    }
    if (!ProtoBuf.Effect.access$23100(paramEffect).isEmpty()) {
      if (this.effectConstructorArgument_.isEmpty())
      {
        this.effectConstructorArgument_ = ProtoBuf.Effect.access$23100(paramEffect);
        this.bitField0_ &= 0xFFFFFFFD;
      }
      else
      {
        ensureEffectConstructorArgumentIsMutable();
        this.effectConstructorArgument_.addAll(ProtoBuf.Effect.access$23100(paramEffect));
      }
    }
    if (paramEffect.hasConclusionOfConditionalEffect()) {
      mergeConclusionOfConditionalEffect(paramEffect.getConclusionOfConditionalEffect());
    }
    if (paramEffect.hasKind()) {
      setKind(paramEffect.getKind());
    }
    setUnknownFields(getUnknownFields().concat(ProtoBuf.Effect.access$23500(paramEffect)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 231	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 237 3 0
    //   12: checkcast 77	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 123	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 240	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 77	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 123	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Effect$Builder;
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
  
  public Builder setEffectType(ProtoBuf.Effect.EffectType paramEffectType)
  {
    if (paramEffectType != null)
    {
      this.bitField0_ |= 0x1;
      this.effectType_ = paramEffectType;
      return this;
    }
    throw new NullPointerException();
  }
  
  public Builder setKind(ProtoBuf.Effect.InvocationKind paramInvocationKind)
  {
    if (paramInvocationKind != null)
    {
      this.bitField0_ |= 0x8;
      this.kind_ = paramInvocationKind;
      return this;
    }
    throw new NullPointerException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.Builder
 * JD-Core Version:    0.7.0.1
 */
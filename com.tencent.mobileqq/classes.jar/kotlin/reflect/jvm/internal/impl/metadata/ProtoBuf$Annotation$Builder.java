package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;

public final class ProtoBuf$Annotation$Builder
  extends GeneratedMessageLite.Builder<ProtoBuf.Annotation, Builder>
  implements ProtoBuf.AnnotationOrBuilder
{
  private List<ProtoBuf.Annotation.Argument> argument_ = Collections.emptyList();
  private int bitField0_;
  private int id_;
  
  private ProtoBuf$Annotation$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void ensureArgumentIsMutable()
  {
    if ((this.bitField0_ & 0x2) != 2)
    {
      this.argument_ = new ArrayList(this.argument_);
      this.bitField0_ |= 0x2;
    }
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.Annotation build()
  {
    ProtoBuf.Annotation localAnnotation = buildPartial();
    if (localAnnotation.isInitialized()) {
      return localAnnotation;
    }
    throw newUninitializedMessageException(localAnnotation);
  }
  
  public ProtoBuf.Annotation buildPartial()
  {
    ProtoBuf.Annotation localAnnotation = new ProtoBuf.Annotation(this, null);
    int j = this.bitField0_;
    int i = 1;
    if ((j & 0x1) != 1) {
      i = 0;
    }
    ProtoBuf.Annotation.access$4402(localAnnotation, this.id_);
    if ((this.bitField0_ & 0x2) == 2)
    {
      this.argument_ = Collections.unmodifiableList(this.argument_);
      this.bitField0_ &= 0xFFFFFFFD;
    }
    ProtoBuf.Annotation.access$4502(localAnnotation, this.argument_);
    ProtoBuf.Annotation.access$4602(localAnnotation, i);
    return localAnnotation;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.Annotation.Argument getArgument(int paramInt)
  {
    return (ProtoBuf.Annotation.Argument)this.argument_.get(paramInt);
  }
  
  public int getArgumentCount()
  {
    return this.argument_.size();
  }
  
  public ProtoBuf.Annotation getDefaultInstanceForType()
  {
    return ProtoBuf.Annotation.getDefaultInstance();
  }
  
  public boolean hasId()
  {
    return (this.bitField0_ & 0x1) == 1;
  }
  
  public final boolean isInitialized()
  {
    if (!hasId()) {
      return false;
    }
    int i = 0;
    while (i < getArgumentCount())
    {
      if (!getArgument(i).isInitialized()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public Builder mergeFrom(ProtoBuf.Annotation paramAnnotation)
  {
    if (paramAnnotation == ProtoBuf.Annotation.getDefaultInstance()) {
      return this;
    }
    if (paramAnnotation.hasId()) {
      setId(paramAnnotation.getId());
    }
    if (!ProtoBuf.Annotation.access$4500(paramAnnotation).isEmpty()) {
      if (this.argument_.isEmpty())
      {
        this.argument_ = ProtoBuf.Annotation.access$4500(paramAnnotation);
        this.bitField0_ &= 0xFFFFFFFD;
      }
      else
      {
        ensureArgumentIsMutable();
        this.argument_.addAll(ProtoBuf.Annotation.access$4500(paramAnnotation));
      }
    }
    setUnknownFields(getUnknownFields().concat(ProtoBuf.Annotation.access$4700(paramAnnotation)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 167	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 173 3 0
    //   12: checkcast 50	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 89	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 176	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 50	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 89	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Annotation$Builder;
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
  
  public Builder setId(int paramInt)
  {
    this.bitField0_ |= 0x1;
    this.id_ = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Builder
 * JD-Core Version:    0.7.0.1
 */
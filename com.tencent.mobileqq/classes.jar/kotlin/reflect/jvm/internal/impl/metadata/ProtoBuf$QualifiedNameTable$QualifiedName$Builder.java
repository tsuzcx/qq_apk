package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;

public final class ProtoBuf$QualifiedNameTable$QualifiedName$Builder
  extends GeneratedMessageLite.Builder<ProtoBuf.QualifiedNameTable.QualifiedName, Builder>
  implements ProtoBuf.QualifiedNameTable.QualifiedNameOrBuilder
{
  private int bitField0_;
  private ProtoBuf.QualifiedNameTable.QualifiedName.Kind kind_ = ProtoBuf.QualifiedNameTable.QualifiedName.Kind.PACKAGE;
  private int parentQualifiedName_ = -1;
  private int shortName_;
  
  private ProtoBuf$QualifiedNameTable$QualifiedName$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.QualifiedNameTable.QualifiedName build()
  {
    ProtoBuf.QualifiedNameTable.QualifiedName localQualifiedName = buildPartial();
    if (localQualifiedName.isInitialized()) {
      return localQualifiedName;
    }
    throw newUninitializedMessageException(localQualifiedName);
  }
  
  public ProtoBuf.QualifiedNameTable.QualifiedName buildPartial()
  {
    ProtoBuf.QualifiedNameTable.QualifiedName localQualifiedName = new ProtoBuf.QualifiedNameTable.QualifiedName(this, null);
    int k = this.bitField0_;
    int j = 1;
    if ((k & 0x1) != 1) {
      j = 0;
    }
    ProtoBuf.QualifiedNameTable.QualifiedName.access$902(localQualifiedName, this.parentQualifiedName_);
    int i = j;
    if ((k & 0x2) == 2) {
      i = j | 0x2;
    }
    ProtoBuf.QualifiedNameTable.QualifiedName.access$1002(localQualifiedName, this.shortName_);
    j = i;
    if ((k & 0x4) == 4) {
      j = i | 0x4;
    }
    ProtoBuf.QualifiedNameTable.QualifiedName.access$1102(localQualifiedName, this.kind_);
    ProtoBuf.QualifiedNameTable.QualifiedName.access$1202(localQualifiedName, j);
    return localQualifiedName;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.QualifiedNameTable.QualifiedName getDefaultInstanceForType()
  {
    return ProtoBuf.QualifiedNameTable.QualifiedName.getDefaultInstance();
  }
  
  public boolean hasShortName()
  {
    return (this.bitField0_ & 0x2) == 2;
  }
  
  public final boolean isInitialized()
  {
    return hasShortName();
  }
  
  public Builder mergeFrom(ProtoBuf.QualifiedNameTable.QualifiedName paramQualifiedName)
  {
    if (paramQualifiedName == ProtoBuf.QualifiedNameTable.QualifiedName.getDefaultInstance()) {
      return this;
    }
    if (paramQualifiedName.hasParentQualifiedName()) {
      setParentQualifiedName(paramQualifiedName.getParentQualifiedName());
    }
    if (paramQualifiedName.hasShortName()) {
      setShortName(paramQualifiedName.getShortName());
    }
    if (paramQualifiedName.hasKind()) {
      setKind(paramQualifiedName.getKind());
    }
    setUnknownFields(getUnknownFields().concat(ProtoBuf.QualifiedNameTable.QualifiedName.access$1300(paramQualifiedName)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 149	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 155 3 0
    //   12: checkcast 43	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 83	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 158	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 43	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 83	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$QualifiedName$Builder;
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
  
  public Builder setKind(ProtoBuf.QualifiedNameTable.QualifiedName.Kind paramKind)
  {
    if (paramKind != null)
    {
      this.bitField0_ |= 0x4;
      this.kind_ = paramKind;
      return this;
    }
    throw new NullPointerException();
  }
  
  public Builder setParentQualifiedName(int paramInt)
  {
    this.bitField0_ |= 0x1;
    this.parentQualifiedName_ = paramInt;
    return this;
  }
  
  public Builder setShortName(int paramInt)
  {
    this.bitField0_ |= 0x2;
    this.shortName_ = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.Builder
 * JD-Core Version:    0.7.0.1
 */
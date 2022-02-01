package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder;

public final class ProtoBuf$EnumEntry$Builder
  extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf.EnumEntry, Builder>
  implements ProtoBuf.EnumEntryOrBuilder
{
  private int bitField0_;
  private int name_;
  
  private ProtoBuf$EnumEntry$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.EnumEntry build()
  {
    ProtoBuf.EnumEntry localEnumEntry = buildPartial();
    if (localEnumEntry.isInitialized()) {
      return localEnumEntry;
    }
    throw newUninitializedMessageException(localEnumEntry);
  }
  
  public ProtoBuf.EnumEntry buildPartial()
  {
    ProtoBuf.EnumEntry localEnumEntry = new ProtoBuf.EnumEntry(this, null);
    int j = this.bitField0_;
    int i = 1;
    if ((j & 0x1) != 1) {
      i = 0;
    }
    ProtoBuf.EnumEntry.access$19402(localEnumEntry, this.name_);
    ProtoBuf.EnumEntry.access$19502(localEnumEntry, i);
    return localEnumEntry;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.EnumEntry getDefaultInstanceForType()
  {
    return ProtoBuf.EnumEntry.getDefaultInstance();
  }
  
  public final boolean isInitialized()
  {
    return extensionsAreInitialized();
  }
  
  public Builder mergeFrom(ProtoBuf.EnumEntry paramEnumEntry)
  {
    if (paramEnumEntry == ProtoBuf.EnumEntry.getDefaultInstance()) {
      return this;
    }
    if (paramEnumEntry.hasName()) {
      setName(paramEnumEntry.getName());
    }
    mergeExtensionFields(paramEnumEntry);
    setUnknownFields(getUnknownFields().concat(ProtoBuf.EnumEntry.access$19600(paramEnumEntry)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 117	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 123 3 0
    //   12: checkcast 31	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 64	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 126	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 31	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 64	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$EnumEntry$Builder;
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
  
  public Builder setName(int paramInt)
  {
    this.bitField0_ |= 0x1;
    this.name_ = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry.Builder
 * JD-Core Version:    0.7.0.1
 */
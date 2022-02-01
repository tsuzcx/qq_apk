package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;

public final class ProtoBuf$StringTable$Builder
  extends GeneratedMessageLite.Builder<ProtoBuf.StringTable, Builder>
  implements ProtoBuf.StringTableOrBuilder
{
  private int bitField0_;
  private LazyStringList string_ = LazyStringArrayList.EMPTY;
  
  private ProtoBuf$StringTable$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void ensureStringIsMutable()
  {
    if ((this.bitField0_ & 0x1) != 1)
    {
      this.string_ = new LazyStringArrayList(this.string_);
      this.bitField0_ |= 0x1;
    }
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.StringTable build()
  {
    ProtoBuf.StringTable localStringTable = buildPartial();
    if (localStringTable.isInitialized()) {
      return localStringTable;
    }
    throw newUninitializedMessageException(localStringTable);
  }
  
  public ProtoBuf.StringTable buildPartial()
  {
    ProtoBuf.StringTable localStringTable = new ProtoBuf.StringTable(this, null);
    if ((this.bitField0_ & 0x1) == 1)
    {
      this.string_ = this.string_.getUnmodifiableView();
      this.bitField0_ &= 0xFFFFFFFE;
    }
    ProtoBuf.StringTable.access$302(localStringTable, this.string_);
    return localStringTable;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.StringTable getDefaultInstanceForType()
  {
    return ProtoBuf.StringTable.getDefaultInstance();
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Builder mergeFrom(ProtoBuf.StringTable paramStringTable)
  {
    if (paramStringTable == ProtoBuf.StringTable.getDefaultInstance()) {
      return this;
    }
    if (!ProtoBuf.StringTable.access$300(paramStringTable).isEmpty()) {
      if (this.string_.isEmpty())
      {
        this.string_ = ProtoBuf.StringTable.access$300(paramStringTable);
        this.bitField0_ &= 0xFFFFFFFE;
      }
      else
      {
        ensureStringIsMutable();
        this.string_.addAll(ProtoBuf.StringTable.access$300(paramStringTable));
      }
    }
    setUnknownFields(getUnknownFields().concat(ProtoBuf.StringTable.access$400(paramStringTable)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 124	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 130 3 0
    //   12: checkcast 45	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 77	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable$Builder;
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
    //   39: checkcast 45	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 77	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$StringTable$Builder;
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
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable.Builder
 * JD-Core Version:    0.7.0.1
 */
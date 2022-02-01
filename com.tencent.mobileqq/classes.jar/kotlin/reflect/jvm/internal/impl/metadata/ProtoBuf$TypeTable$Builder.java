package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;

public final class ProtoBuf$TypeTable$Builder
  extends GeneratedMessageLite.Builder<ProtoBuf.TypeTable, Builder>
  implements ProtoBuf.TypeTableOrBuilder
{
  private int bitField0_;
  private int firstNullable_ = -1;
  private List<ProtoBuf.Type> type_ = Collections.emptyList();
  
  private ProtoBuf$TypeTable$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void ensureTypeIsMutable()
  {
    if ((this.bitField0_ & 0x1) != 1)
    {
      this.type_ = new ArrayList(this.type_);
      this.bitField0_ |= 0x1;
    }
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.TypeTable build()
  {
    ProtoBuf.TypeTable localTypeTable = buildPartial();
    if (localTypeTable.isInitialized()) {
      return localTypeTable;
    }
    throw newUninitializedMessageException(localTypeTable);
  }
  
  public ProtoBuf.TypeTable buildPartial()
  {
    ProtoBuf.TypeTable localTypeTable = new ProtoBuf.TypeTable(this, null);
    int j = this.bitField0_;
    int i = 1;
    if ((j & 0x1) == 1)
    {
      this.type_ = Collections.unmodifiableList(this.type_);
      this.bitField0_ &= 0xFFFFFFFE;
    }
    ProtoBuf.TypeTable.access$12002(localTypeTable, this.type_);
    if ((j & 0x2) != 2) {
      i = 0;
    }
    ProtoBuf.TypeTable.access$12102(localTypeTable, this.firstNullable_);
    ProtoBuf.TypeTable.access$12202(localTypeTable, i);
    return localTypeTable;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.TypeTable getDefaultInstanceForType()
  {
    return ProtoBuf.TypeTable.getDefaultInstance();
  }
  
  public ProtoBuf.Type getType(int paramInt)
  {
    return (ProtoBuf.Type)this.type_.get(paramInt);
  }
  
  public int getTypeCount()
  {
    return this.type_.size();
  }
  
  public final boolean isInitialized()
  {
    int i = 0;
    while (i < getTypeCount())
    {
      if (!getType(i).isInitialized()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public Builder mergeFrom(ProtoBuf.TypeTable paramTypeTable)
  {
    if (paramTypeTable == ProtoBuf.TypeTable.getDefaultInstance()) {
      return this;
    }
    if (!ProtoBuf.TypeTable.access$12000(paramTypeTable).isEmpty()) {
      if (this.type_.isEmpty())
      {
        this.type_ = ProtoBuf.TypeTable.access$12000(paramTypeTable);
        this.bitField0_ &= 0xFFFFFFFE;
      }
      else
      {
        ensureTypeIsMutable();
        this.type_.addAll(ProtoBuf.TypeTable.access$12000(paramTypeTable));
      }
    }
    if (paramTypeTable.hasFirstNullable()) {
      setFirstNullable(paramTypeTable.getFirstNullable());
    }
    setUnknownFields(getUnknownFields().concat(ProtoBuf.TypeTable.access$12300(paramTypeTable)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 166	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 172 3 0
    //   12: checkcast 52	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 89	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 175	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 52	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 89	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$TypeTable$Builder;
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
  
  public Builder setFirstNullable(int paramInt)
  {
    this.bitField0_ |= 0x2;
    this.firstNullable_ = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable.Builder
 * JD-Core Version:    0.7.0.1
 */
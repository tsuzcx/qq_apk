package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;

public final class ProtoBuf$QualifiedNameTable$Builder
  extends GeneratedMessageLite.Builder<ProtoBuf.QualifiedNameTable, Builder>
  implements ProtoBuf.QualifiedNameTableOrBuilder
{
  private int bitField0_;
  private List<ProtoBuf.QualifiedNameTable.QualifiedName> qualifiedName_ = Collections.emptyList();
  
  private ProtoBuf$QualifiedNameTable$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void ensureQualifiedNameIsMutable()
  {
    if ((this.bitField0_ & 0x1) != 1)
    {
      this.qualifiedName_ = new ArrayList(this.qualifiedName_);
      this.bitField0_ |= 0x1;
    }
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.QualifiedNameTable build()
  {
    ProtoBuf.QualifiedNameTable localQualifiedNameTable = buildPartial();
    if (localQualifiedNameTable.isInitialized()) {
      return localQualifiedNameTable;
    }
    throw newUninitializedMessageException(localQualifiedNameTable);
  }
  
  public ProtoBuf.QualifiedNameTable buildPartial()
  {
    ProtoBuf.QualifiedNameTable localQualifiedNameTable = new ProtoBuf.QualifiedNameTable(this, null);
    if ((this.bitField0_ & 0x1) == 1)
    {
      this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
      this.bitField0_ &= 0xFFFFFFFE;
    }
    ProtoBuf.QualifiedNameTable.access$1602(localQualifiedNameTable, this.qualifiedName_);
    return localQualifiedNameTable;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.QualifiedNameTable getDefaultInstanceForType()
  {
    return ProtoBuf.QualifiedNameTable.getDefaultInstance();
  }
  
  public ProtoBuf.QualifiedNameTable.QualifiedName getQualifiedName(int paramInt)
  {
    return (ProtoBuf.QualifiedNameTable.QualifiedName)this.qualifiedName_.get(paramInt);
  }
  
  public int getQualifiedNameCount()
  {
    return this.qualifiedName_.size();
  }
  
  public final boolean isInitialized()
  {
    int i = 0;
    while (i < getQualifiedNameCount())
    {
      if (!getQualifiedName(i).isInitialized()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public Builder mergeFrom(ProtoBuf.QualifiedNameTable paramQualifiedNameTable)
  {
    if (paramQualifiedNameTable == ProtoBuf.QualifiedNameTable.getDefaultInstance()) {
      return this;
    }
    if (!ProtoBuf.QualifiedNameTable.access$1600(paramQualifiedNameTable).isEmpty()) {
      if (this.qualifiedName_.isEmpty())
      {
        this.qualifiedName_ = ProtoBuf.QualifiedNameTable.access$1600(paramQualifiedNameTable);
        this.bitField0_ &= 0xFFFFFFFE;
      }
      else
      {
        ensureQualifiedNameIsMutable();
        this.qualifiedName_.addAll(ProtoBuf.QualifiedNameTable.access$1600(paramQualifiedNameTable));
      }
    }
    setUnknownFields(getUnknownFields().concat(ProtoBuf.QualifiedNameTable.access$1700(paramQualifiedNameTable)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 146	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 152 3 0
    //   12: checkcast 49	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 79	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 155	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 49	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 79	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$QualifiedNameTable$Builder;
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
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.Builder
 * JD-Core Version:    0.7.0.1
 */
package kotlin.reflect.jvm.internal.impl.metadata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder;

public final class ProtoBuf$VersionRequirementTable$Builder
  extends GeneratedMessageLite.Builder<ProtoBuf.VersionRequirementTable, Builder>
  implements ProtoBuf.VersionRequirementTableOrBuilder
{
  private int bitField0_;
  private List<ProtoBuf.VersionRequirement> requirement_ = Collections.emptyList();
  
  private ProtoBuf$VersionRequirementTable$Builder()
  {
    maybeForceBuilderInitialization();
  }
  
  private static Builder create()
  {
    return new Builder();
  }
  
  private void ensureRequirementIsMutable()
  {
    if ((this.bitField0_ & 0x1) != 1)
    {
      this.requirement_ = new ArrayList(this.requirement_);
      this.bitField0_ |= 0x1;
    }
  }
  
  private void maybeForceBuilderInitialization() {}
  
  public ProtoBuf.VersionRequirementTable build()
  {
    ProtoBuf.VersionRequirementTable localVersionRequirementTable = buildPartial();
    if (localVersionRequirementTable.isInitialized()) {
      return localVersionRequirementTable;
    }
    throw newUninitializedMessageException(localVersionRequirementTable);
  }
  
  public ProtoBuf.VersionRequirementTable buildPartial()
  {
    ProtoBuf.VersionRequirementTable localVersionRequirementTable = new ProtoBuf.VersionRequirementTable(this, null);
    if ((this.bitField0_ & 0x1) == 1)
    {
      this.requirement_ = Collections.unmodifiableList(this.requirement_);
      this.bitField0_ &= 0xFFFFFFFE;
    }
    ProtoBuf.VersionRequirementTable.access$21102(localVersionRequirementTable, this.requirement_);
    return localVersionRequirementTable;
  }
  
  public Builder clone()
  {
    return create().mergeFrom(buildPartial());
  }
  
  public ProtoBuf.VersionRequirementTable getDefaultInstanceForType()
  {
    return ProtoBuf.VersionRequirementTable.getDefaultInstance();
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
  
  public Builder mergeFrom(ProtoBuf.VersionRequirementTable paramVersionRequirementTable)
  {
    if (paramVersionRequirementTable == ProtoBuf.VersionRequirementTable.getDefaultInstance()) {
      return this;
    }
    if (!ProtoBuf.VersionRequirementTable.access$21100(paramVersionRequirementTable).isEmpty()) {
      if (this.requirement_.isEmpty())
      {
        this.requirement_ = ProtoBuf.VersionRequirementTable.access$21100(paramVersionRequirementTable);
        this.bitField0_ &= 0xFFFFFFFE;
      }
      else
      {
        ensureRequirementIsMutable();
        this.requirement_.addAll(ProtoBuf.VersionRequirementTable.access$21100(paramVersionRequirementTable));
      }
    }
    setUnknownFields(getUnknownFields().concat(ProtoBuf.VersionRequirementTable.access$21200(paramVersionRequirementTable)));
    return this;
  }
  
  /* Error */
  public Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream paramCodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite paramExtensionRegistryLite)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 128	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable:PARSER	Lkotlin/reflect/jvm/internal/impl/protobuf/Parser;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 134 3 0
    //   12: checkcast 49	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 79	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable$Builder;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_2
    //   29: aload_3
    //   30: astore_1
    //   31: goto +15 -> 46
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 137	kotlin/reflect/jvm/internal/impl/protobuf/InvalidProtocolBufferException:getUnfinishedMessage	()Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;
    //   39: checkcast 49	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable
    //   42: astore_1
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull +9 -> 56
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 79	kotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable$Builder:mergeFrom	(Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable;)Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$VersionRequirementTable$Builder;
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
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable.Builder
 * JD-Core Version:    0.7.0.1
 */